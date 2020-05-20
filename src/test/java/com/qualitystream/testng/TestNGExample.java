package com.qualitystream.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGExample {
	
	WebDriver driver;
	By searchBoxLocator = By.id("twotabsearchtextbox");
	By resultsLocator = By.cssSelector("span.a-dropdown-label");

	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	}

	@Test
	public void ordenar_por() {
		
		WebElement searchbox = driver.findElement(searchBoxLocator);
		searchbox.clear(); //limpiar cualquier texto que este escrito
		searchbox.sendKeys("blusa");
		searchbox.submit();
		
		WebDriverWait Wait = new WebDriverWait (driver, 7);
		Wait.until(ExpectedConditions.presenceOfElementLocated(resultsLocator));
	
	}

	@AfterClass
	public void afterClass() {
	}

}
