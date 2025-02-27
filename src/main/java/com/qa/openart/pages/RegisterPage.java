package com.qa.openart.pages;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.ElementUtil;

public class RegisterPage {
	private WebDriver driver;
	private ElementUtil eleUtil; 

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String registerPageTitle() {
		return eleUtil.waitForTitleContainsAndReturn("Register Account", 5);

	}

}
