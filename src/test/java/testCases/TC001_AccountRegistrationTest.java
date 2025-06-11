package testCases;

import java.time.Duration;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

@SuppressWarnings("unused")
public class TC001_AccountRegistrationTest extends BaseClass{

	
	
	@Test(groups= {"Regression","Master"})
	public void verify_account_registration() {
		HomePage hp=new HomePage(driver);
		hp.clickmyaccount();
		hp.clickregiter();
		
		AccountRegistrationPage arp=new AccountRegistrationPage(driver);
		arp.setfirstname(randomAlphaString().toUpperCase());
		arp.setlastname(randomAlphaString().toUpperCase());
		arp.setemail(randomAlphaString()+"@gmail.com");
		arp.settelephone(randomeNumber());
		
		
		String pwd = randomAlphanumber();
		arp.setpassword(pwd);
		arp.setconfirm(pwd);
		
		arp.setagree();
		arp.setcontinue();
		
		String confmsg= arp.getconfirmation();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
	}
	

	

}
