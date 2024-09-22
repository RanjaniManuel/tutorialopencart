package com.tutorialopencart.qa.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import PageObject.HomePage;

public class BaseTest {

	WebDriver driver;
	Properties prop;

	@SuppressWarnings("deprecation")
	@BeforeMethod
	@Parameters({ "os", "browser" })

	public void setup(String os, String browserName) throws MalformedURLException {

		prop = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream("./src/test/resources/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (prop.getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilites = new DesiredCapabilities();
			// os
			if (os.equalsIgnoreCase("windows")) {
				capabilites.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("Mac")) {
				capabilites.setPlatform(Platform.MAC);
			} else if (os.equalsIgnoreCase("Linux")) {
				capabilites.setPlatform(Platform.LINUX);
			} else {
				System.out.println("No matching os");
				return;
			}
			// browser
			switch (browserName.toLowerCase()) {
			case "chrome":
				 capabilites.setBrowserName("chrome");
				break;

			case "edge":
				capabilites.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capabilites.setBrowserName("Firefox");
				break;
			default:
				System.out.println("Invalid browser name");
				return;
			}
			driver= new RemoteWebDriver(new URL("http://192.168.1.222:4444/wd/hub"), capabilites);
			

		}

		else if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (browserName.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;

			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("Invalid browser name");
				return;
			}
		} else {
			System.out.println("no match os and remote");
		}
		
		HomePage home = new HomePage(driver);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		home.clickMyAccount();
		home.clickLinkLogin();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	public String emailGenarator() {
		Date date = new Date();
		// System.out.println();
		return "ranjan" + date.toString().replace(" ", "_").replace(":", "_");
	}

}
