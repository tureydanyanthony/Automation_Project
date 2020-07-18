package com.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondTest {
	WebDriver driver;

	@BeforeClass
	public void testSetup() {

		System.setProperty("webdriver.gecko.driver", "C:\\Tools\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

	}

	@BeforeMethod
	public void openBrowser() {
		String URL = "http://automationpractice.com/index.php";
		driver.get(URL);
		System.out.println("We are currently on the following URL " + driver.getCurrentUrl());
	}

	@Test(description = "This method validates the login functionality")
	public void login() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("tureydanyanthony.20it@licet.ac.in");
		driver.findElement(By.id("passwd")).sendKeys("admin123");
		driver.findElement(By.id("SubmitLogin")).click();

		String actualUrl = "http://automationpractice.com/index.php?controller=my-account";
		String expectedUrl = driver.getCurrentUrl();

		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login  failed");
		}
		driver.close();
	}
}
