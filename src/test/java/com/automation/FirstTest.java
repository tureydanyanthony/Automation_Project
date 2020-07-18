package com.automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.Select;

public class FirstTest {

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

	@Test(description = "This method validates the sign up functionality")
	public void signUp() {
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email_create")).sendKeys("sample34@test.com");
		driver.findElement(By.id("SubmitCreate")).click();
//		
		try {
			 String alert=driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText();
			 
			System.out.println(alert);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		
		driver.findElements(By.xpath("//input[@name='id_gender']")).get(1).click();
		driver.findElement(By.name("customer_firstname")).sendKeys("Tuery");
		driver.findElement(By.name("customer_lastname")).sendKeys("Dany");
		driver.findElement(By.id("passwd")).sendKeys("admin123");

		driver.findElement(By.id("firstname")).sendKeys("Tuery");
		driver.findElement(By.id("lastname")).sendKeys("Dany");
		driver.findElement(By.id("company")).sendKeys("BNP");
		driver.findElement(By.id("address1")).sendKeys("Test 81/1,2nd cross");
		driver.findElement(By.id("city")).sendKeys("XYZ");

		WebElement statedropdown = driver.findElement(By.name("id_state"));
		Select selectState = new Select(statedropdown);
		selectState.selectByValue("4");

		driver.findElement(By.name("postcode")).sendKeys("51838");

		WebElement countrydropDown = driver.findElement(By.name("id_country"));
		Select selectCountry = new Select(countrydropDown);
		selectCountry.selectByVisibleText("United States");

		driver.findElement(By.id("phone_mobile")).sendKeys("234567890");
		driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
		driver.findElement(By.name("submitAccount")).click();
		String userText = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();

		if (userText.contains("Tuery")) {
			System.out.println("User Verified,Test case Passed");
		} else {
			System.out.println("User Verification Failed,Test case Failed");
		}
		}
		driver.close();
	}

}
