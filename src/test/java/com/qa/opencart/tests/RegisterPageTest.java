package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;

public class RegisterPageTest extends BaseTest { 

	@Test
	public void verifyPageTitle() {

		registerPage = loginPage.navigateToRegisterPage();
		String text = registerPage.registerPageTitle();
		Assert.assertEquals(text, "Register Account");
	}
}
