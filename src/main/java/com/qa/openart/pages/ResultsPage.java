package com.qa.openart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilities.ElementUtil;

public class ResultsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private By prodcutsearcLink = By.xpath("//h4/a"); 

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);  
	}

	public int getSearchResultsCount() {
		int count = eleUtil.getElementsTextList(prodcutsearcLink).size();
		return count;
	}

	public ProductDisplaypage productDisplaypage(String prodcut) {

		List<WebElement> lstproducts = eleUtil.getElements(prodcutsearcLink);

		for (WebElement webElement : lstproducts) {

			String text = eleUtil.doGetElementText(webElement);
			if (text.contains(prodcut)) {
				eleUtil.doClick(webElement);
			}
		}
		return new ProductDisplaypage(driver);

	}
}
