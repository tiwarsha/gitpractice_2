package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.basetest.BaseTest;

public class AddtocartTest extends BaseTest { 
	@BeforeClass
	public void accSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void addtocartpagetitle() {
		resultsPage = accPage.doSearch("samsung");
		productDisplaypage = resultsPage.productDisplaypage("Samsung Galaxy");
		addtoCart = productDisplaypage.navigateaddtocartPage();
		String text = addtoCart.verifyaddtocartPageTitle();
		Assert.assertEquals(text, "Shopping Cart");   

	}
}
