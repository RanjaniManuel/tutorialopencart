package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	//constructor
		public HomePage(WebDriver driver) {
			super(driver);
		}
		//Locator


		@FindBy(linkText  = "My Account")
		WebElement linkMyAccount ;
		@FindBy(linkText  = "Login")
		WebElement linkLogin;
		
		public void clickMyAccount() {
			linkMyAccount.click();
		}
		public void clickLinkLogin() {
			linkLogin.click();
		}
}
