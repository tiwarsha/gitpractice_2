package com.qa.opencart.basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.openart.pages.AccountsPage;
import com.qa.openart.pages.AddtoCart;
import com.qa.openart.pages.LoginPage;
import com.qa.openart.pages.ProductDisplaypage;
import com.qa.openart.pages.RegisterPage;
import com.qa.openart.pages.ResultsPage;
import com.qa.opencart.driverfactory.DriverFactory;
import com.qa.opencart.driverfactory.OptionsManager;

public class BaseTest {

	private  WebDriver driver;
	protected Properties prop;
	OptionsManager manager;
	DriverFactory df;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected ResultsPage resultsPage;
	protected ProductDisplaypage productDisplaypage;
	protected AddtoCart addtoCart;
	protected RegisterPage registerPage;

	@BeforeTest 
	public void setup() {
		df = new DriverFactory();
		prop = df.initProperty();
		driver = df.getBrowser(prop);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver); 

	}

	@AfterTest

	public void teardown() {
		driver.quit();

	}

}
