package com.accesshq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accesshq.dialogs.NewMessageDialog;

public class GmailInboxPage extends BasePage {

	public GmailInboxPage(WebDriver driver) {
		super(driver);
	}
	
	public NewMessageDialog clickComposeButton() {
		driver.findElement(By.cssSelector("div[gh='cm']")).click();
		WebElement dialogBoxWebElement = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[role='dialog']")));
		return new NewMessageDialog(dialogBoxWebElement);
		
	}
	
	public boolean checkEmailSent() {
		//I know the class name 'bAq' looks generated but I have tested it in several instances and it has been the most reliable indicator
		return (new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElementLocated(By.className("bAq"), "Message sent")));	
	}

}
