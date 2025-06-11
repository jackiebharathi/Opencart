package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']") WebElement  txtfirstname;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtlastname ;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtemail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txttelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtpassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtconfirmpassword;
	@FindBy(xpath="//input[@name='agree']") WebElement chkdpolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgconfirmation;
	
	public void setfirstname(String fname) {
		txtfirstname.sendKeys(fname);;
	}
	public void setlastname(String lname) {
		txtlastname.sendKeys(lname);;
	}
	public void setemail(String email) {
		txtemail.sendKeys(email);
	}
	public void settelephone(String number) {
		txttelephone.sendKeys(number);
	}
	public void setpassword(String password) {
		txtpassword.sendKeys(password);
	}
	public void setconfirm(String password) {
		txtconfirmpassword.sendKeys(password);
	}
	public void setagree() {
		chkdpolicy.click();
	}
	public void setcontinue() {
		btncontinue.click();
	}
	
	public String getconfirmation() {
		try {
			return (msgconfirmation.getText());
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}









}
