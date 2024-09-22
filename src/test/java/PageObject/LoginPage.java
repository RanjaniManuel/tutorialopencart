package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	//constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	//Locator


	@FindBy(name = "email")
	WebElement txtUserName ;
	@FindBy(name = "password")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@value='Login' and @type='submit']")
	WebElement btnLogin ;
	@FindBy(xpath = "//a[contains(text(),'Edit your account information')]")
	WebElement linkLoginConfMessage ;
	@FindBy(xpath = "//div[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")
	WebElement errorLoginMessage ;
	
	
	//Action
	
	public  void setUserName(String emailId) {
		txtUserName.sendKeys(emailId);
		
	}
	public  void setPassword(String password) {
		txtPassword.sendKeys(password);
		
	}
	public  void clickLogin() {
		btnLogin.click();;
		
	}
	public  boolean isLoginErrorMessageDisplayed() {
		return errorLoginMessage.isDisplayed();
		
	}
	public boolean isLoginConfirmationLinkDisplayed() {
		return linkLoginConfMessage.isDisplayed();
	}


	


	
	

}
