package com.accesshq.tests;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class BaseTest {

	protected static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<WebDriver>();
	
	protected WebDriver getDriver() {
		return driverInstance.get();
	}
	


	@BeforeEach
	void setUp() throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail");
		
		driverInstance.set(driver);
	}
	
	@AfterEach
	void tearDown() {
		getDriver().quit();
	}

}
