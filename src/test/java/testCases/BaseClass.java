package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {

public static WebDriver driver;
public Logger logger;
public Properties p;
  


	@BeforeClass(groups= {"Master","Sanity","Regression","DataDriven"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException {
		logger = LogManager.getLogger(this.getClass());
		
		FileReader file=new FileReader("./src//test//resources//config.properties");;
		p=new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	//os
	if(os.equalsIgnoreCase("windows")) {
		capabilities.setPlatform(Platform.WIN10);
	}else if(os.equalsIgnoreCase("linux")) {
		capabilities.setPlatform(Platform.LINUX);
	}else {
		System.out.println("No matching OS");return;
	}
	
	//browser
	switch(br.toLowerCase())
	{
	case "chrome": capabilities.setBrowserName("chrome"); break;
	case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
	case "firefox": capabilities.setBrowserName("firefox"); break;
	default: System.out.println("no matching browser"); return;
	}
	
	driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
	

		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			default : System.out.println("Invalid browser name"); return;
			}
		}
		
		

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass(groups= {"Master","Sanity","Regression","DataDriven"})
	public void teardown() {
		driver.quit();
	}
	

	@SuppressWarnings("deprecation")
	public String randomAlphaString() {
	    return RandomStringUtils.randomAlphabetic(8); // returns 8 random letters
	}

	@SuppressWarnings("deprecation")
	public String randomeNumber() {
		return RandomStringUtils.randomNumeric(10);
	}
	@SuppressWarnings("deprecation")
	public String randomAlphanumber() {
		String s1= RandomStringUtils.randomAlphabetic(8); 
		String s2= RandomStringUtils.randomNumeric(10);
		return (s1+s2);
	}
	
	public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        // Save the screenshot file
        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }
	
}
