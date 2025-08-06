package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage {

	public LogOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement myAccnt;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']") WebElement logout;
	@FindBy(xpath="//h1[normalize-space()='Account Logout']") WebElement validlogout;
	
	
	public void myaccnt() {
		myAccnt.click();
	}
	public void logout() {
		logout.click();
	}
	public boolean validlogou() {
		return validlogout.isDisplayed();
	}
}
