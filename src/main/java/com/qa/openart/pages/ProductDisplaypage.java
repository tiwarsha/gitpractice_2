package com.qa.openart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.ElementUtil;

public class ProductDisplaypage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	By addtocartbutton = By.xpath("//*[@id='button-cart']");
	By shoppingcartheader = By.xpath("//*[@id='cart-total']");
	By viewcart = By.xpath("//*[@id='cart']/ul/li[2]/div/p/a[1]");

	public ProductDisplaypage(WebDriver driver) { 
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getProductDisplaypageTitlePage() {

		return eleUtil.getPageTitleContains("Samsung Galaxy Tab 10.1", 5);
	}

	public AddtoCart navigateaddtocartPage() {

		eleUtil.doClick(addtocartbutton);
		driver.navigate().refresh();
		eleUtil.waitForElementPresence(shoppingcartheader, 10);
		eleUtil.doClick(shoppingcartheader);
		eleUtil.doClick(viewcart);

		return new AddtoCart(driver);

	}
}
