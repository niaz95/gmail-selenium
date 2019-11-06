package com.accesshq.dialogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewMessageDialog {

WebElement element;
	
	public NewMessageDialog(WebElement element) {
		this.element = element;
	}
	//newMessageDialog.enterRecipient(recipient).enterSubject(subject).enterBodyText().clickSend();

	private NewMessageDialog enterText(By locator,String text) {
		element.findElement(locator).sendKeys(text);
		return this;
	}
	
	public NewMessageDialog enterRecipient(String recipient) {
		return enterText(By.cssSelector("[aria-label='To']"),recipient);
	}
	
	public NewMessageDialog enterSubject(String subject) {
		return enterText(By.cssSelector("[aria-label='Subject']"),subject);
	}
	
	public NewMessageDialog enterBodyText(String body) {
		return enterText(By.cssSelector("[role='textbox']"),body);
	}
	
	public void clickSend() {
		//This css selector would work only for macOS, I could not find a better locator than this.
		element.findElement(By.cssSelector("div[aria-label='Send ‪(⌘Enter)‬']")).click();;
	}


}
