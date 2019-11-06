package com.accesshq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterPasswordPage extends BasePage {

	public EnterPasswordPage(WebDriver driver) {
		super(driver);
	}
	
	public EnterPasswordPage enterPasswordInput(String password) {
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordNext")));
		driver.findElement(By.cssSelector("[type='password']")).sendKeys(password);
		return this;
	}
	
	public GmailInboxPage clickNextCompleted() {
		driver.findElement(By.id("passwordNext")).click();
		return new GmailInboxPage(driver);	
	}

}
