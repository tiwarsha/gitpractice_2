package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.appconstants.AppConstants;
import com.qa.opencart.basetest.BaseTest;

public class AccountsPageTest extends BaseTest { 

	@BeforeClass
	public void accSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		String actTitle = accPage.getAccountsPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE); 
	}

	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist()); 
	}

	@Test
	public void accPageHeadersCountTest() {
		Assert.assertEquals(accPage.getTotalAccountsPageHeader(), AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);

	}

	@Test
	public void accPageHeadersTest() {
		List<String> actualHeadersList = accPage.getAccPageHeaders();
		Assert.assertEquals(actualHeadersList, AppConstants.EXPECTED_ACC_PAGE_HEADERS_LIST);
	}

	@Test
	public void searchCountTest() {
		resultsPage = accPage.doSearch("samsung");
		 Assert.assertTrue(resultsPage.getSearchResultsCount()>0);
	}

	@Test
	public void productdetailtitle() {
		resultsPage = accPage.doSearch("samsung");
		productDisplaypage = resultsPage.productDisplaypage("Samsung Galaxy");
		String text = productDisplaypage.getProductDisplaypageTitlePage();
        Assert.assertTrue(text.contains("Samsung Galaxy"));

	}

}
