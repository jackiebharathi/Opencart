package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogOutPage;
import pageObjects.LoginPage;

public class TC004_LogOutTest extends BaseClass {

	
	@Test(groups= {"Master","Sanity"})
	public void verify_logout() {
		HomePage hp = new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		LogOutPage lo = new LogOutPage(driver);
		lo.myaccnt();
		lo.logout();
		Assert.assertTrue(lo.validlogou()); 
	}
}
