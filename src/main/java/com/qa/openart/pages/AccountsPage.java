package com.qa.openart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.opencart.appconstants.AppConstants;
import com.qa.opencart.utilities.ElementUtil;

public class AccountsPage  {

	private WebDriver driver;
	private ElementUtil eleUtil;
    private By logoutLink = By.linkText("Logout");
	private By headers = By.cssSelector("div#content h2");
	private By accPage_searchbox = By.xpath("//*[@id='search']/input");
	private By serachIcon = By.xpath("//*[@id='search']/span/button/i");
	
	

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccountsPageTitle() {

		String title = eleUtil.waitForTitleContainsAndReturn(AppConstants.ACCOUNTS_PAGE_TITLE,
				AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("login page title: " + title); 
		return title;
	}

	public boolean isLogoutLinkExist() { 
		return eleUtil.isElementDisplayed(logoutLink);	
	}

	public Object getTotalAccountsPageHeader() {
		return eleUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
	}

	
	public List<String> getAccPageHeaders() {
		List<WebElement> headersList = eleUtil.waitForElementsVisible(headers, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		List<String> headersValueList = new ArrayList<String>();
		for(WebElement e : headersList) {
			String header = e.getText();
			headersValueList.add(header);
		}
		return headersValueList;
	}

	public ResultsPage doSearch(String searchKey) {
		eleUtil.doActionsSendKeys(accPage_searchbox, searchKey);
		eleUtil.doActionsClick(serachIcon);
		return new ResultsPage(driver);
		
	}
	
	


}
