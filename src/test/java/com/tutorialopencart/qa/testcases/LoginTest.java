package com.tutorialopencart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;

public class LoginTest extends BaseTest {
	LoginPage login;
	
	@Test(enabled = true)
	public void loginValidcredential() throws InterruptedException {
		
		LoginPage login=new LoginPage(driver);
	
		login.setUserName(prop.getProperty("username"));
		login.setPassword(prop.getProperty("password"));
		login.clickLogin();


		Assert.assertTrue(login.isLoginConfirmationLinkDisplayed());

	}

	@Test(enabled = true)
	public void loginInvalidcredential() {
		LoginPage login=new LoginPage(driver);
		login.setUserName(emailGenarator());
		login.setPassword("123sder45");
		login.clickLogin();


		Assert.assertTrue(login.isLoginErrorMessageDisplayed());

	}

	@Test(enabled = true)
	public void loginInvalidUsername() {
		LoginPage login=new LoginPage(driver);
		login.setUserName(emailGenarator());
		login.setPassword(prop.getProperty("password"));
		login.clickLogin();

		Assert.assertTrue(login.isLoginErrorMessageDisplayed());





	}

	@Test
	public void loginInvalidPassword() {
		
		LoginPage login=new LoginPage(driver);
		login.setUserName(prop.getProperty("username"));
		login.setPassword("dkjljfs");
		login.clickLogin();

		Assert.assertTrue(login.isLoginErrorMessageDisplayed());



	}

	@Test
	public void loginWithoutCredential() {

		LoginPage login=new LoginPage(driver);

		login.clickLogin();

		Assert.assertTrue(login.isLoginErrorMessageDisplayed());

	}

	
}
