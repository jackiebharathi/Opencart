package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= {"DataDriven"})//if data providers class in another package need to add another args
	public void verify_loginDDT(String email,String pwd, String exp)
	{
	
		
		logger.info("**********starting TC003_loginDDT******");
	
		try {
	HomePage hp =new HomePage(driver);
	hp.clickmyaccount();
	hp.clicklogin();
	
	LoginPage lp = new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.clickLogin();
	
	MyAccountPage ma= new MyAccountPage(driver);
	boolean targetpage = (ma.ismyaccountpageexist());
	
	if(exp.equalsIgnoreCase("valid")) {
		if(targetpage==true) {
			ma.clicklogout();
			Assert.assertTrue(true);
		}else {
			
			Assert.fail();
		}
	}else {
		if(targetpage==false) {
			
			Assert.assertTrue(true);
		}else {
			ma.clicklogout();
			Assert.fail();;
		}
	}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		finally {
	logger.info("********ending TC003*********");
	}
	}
}
