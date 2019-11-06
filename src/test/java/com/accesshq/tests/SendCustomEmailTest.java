package com.accesshq.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.accesshq.dialogs.NewMessageDialog;
import com.accesshq.pages.EnterEmailPage;
import com.accesshq.pages.GmailInboxPage;
import com.sun.jmx.snmp.Timestamp;

class SendCustomEmailTest extends BaseTest {

	@Test
	void sendCustomEmailtest() {
		String email = "Your email";
		String password = "Your password";
		String recipient = "recipient email";
		String subject = "Automated message by Selenium Web Driver " + new Timestamp(System.currentTimeMillis());
		String body = "Hello, "
				+ "\n\n"
				+ "This is a simple program that sends an automated email using Selenium Web Driver. "
				+ "\n"
				+ "Thank you very much."
				+ "\n\n"
				+ "Regards, "
				+ "\n"
				+ "Selenium ";
		
		
		GmailInboxPage gmailInboxPage = new EnterEmailPage(getDriver()).enterEmailInput(email).clickNextCompleted().enterPasswordInput(password).clickNextCompleted();
		NewMessageDialog newMessageDialog = gmailInboxPage.clickComposeButton();
		newMessageDialog.enterRecipient(recipient).enterSubject(subject).enterBodyText(body).clickSend();
		
		Assertions.assertTrue(gmailInboxPage.checkEmailSent(),"Email has been sent successfully");

	}

}
