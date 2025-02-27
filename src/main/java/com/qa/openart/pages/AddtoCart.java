package com.qa.openart.pages;

import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.ElementUtil;

public class AddtoCart {

	private ElementUtil eleUtil;

	private WebDriver driver;

	public AddtoCart(WebDriver driver) {  
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	
	public String verifyaddtocartPageTitle() {
		
		String text = eleUtil.getPageTitleContains("Shopping Cart", 5);
		return text;
	}
}
