package com.automation;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThirdTest {

	WebDriver driver;
	
	@BeforeClass
	public void testSetup() {

		System.setProperty("webdriver.gecko.driver", "C:\\Tools\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
        
	}

	@BeforeMethod
	public void openBrowser() {
		String URL = "http://automationpractice.com/index.php";
		driver.get(URL);
	     driver.manage().window().maximize();
		System.out.println("We are currently on the following URL " + driver.getCurrentUrl());
	}

	@Test(description = "This method validates the add to cart functionality")
	public void addToCart() throws Exception {

		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("tureydanyanthony.20it@licet.ac.in");
		driver.findElement(By.id("passwd")).sendKeys("admin123");
		driver.findElement(By.id("SubmitLogin")).click();

		driver.findElement(By.linkText("WOMEN")).click();

		WebElement SecondImg = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
		SecondImg.click();

		driver.findElement(By.id("quantity_wanted")).clear();
		driver.findElement(By.id("quantity_wanted")).sendKeys("2");

		WebElement Sizedrpdwn = driver.findElement(By.xpath("//*[@id=\"group_1\"]"));
		Select selectSize = new Select(Sizedrpdwn);
		selectSize.selectByVisibleText("M");

		driver.findElement(By.id("color_11")).click();

		driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();

		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();

		driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();

		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();

		String ConfirmationText = driver
				.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();

		if (ConfirmationText.contains("complete")) {
			System.out.println("Order Completed: Test Case Passed");
		} else {
			System.out.println("Order Not Successfull: Test Case Failed");
		}
		
		driver.close();
	}
}
