package com.accesshq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterEmailPage extends BasePage {

	public EnterEmailPage(WebDriver driver) {
		super(driver);
	}
	
	public EnterEmailPage enterEmailInput(String email) {
		driver.findElement(By.cssSelector("[type='email']")).sendKeys(email);
		return this;
	}
	
	public EnterPasswordPage clickNextCompleted() {
		driver.findElement(By.id("identifierNext")).click();
		return new EnterPasswordPage(driver);	
	}
	
	

}
