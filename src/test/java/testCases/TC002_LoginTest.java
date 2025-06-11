	package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {

	@Test(groups= {"Master","Sanity"})
	public void verify_login() {
		logger.info("**********starting login verification*********");
		try {
			HomePage hp =new HomePage(driver);
			hp.clickmyaccount();
			hp.clicklogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();
			
			MyAccountPage ma= new MyAccountPage(driver);
			Assert.assertTrue(ma.ismyaccountpageexist());
		}catch(Exception e) {
			Assert.fail();
		}
 
		
		
		logger.info("**********Ending login verification************");
		
	}
}
