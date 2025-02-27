package com.qa.opencart.driverfactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private WebDriver driver;

	OptionsManager manager;
	Properties prop;
	public static String isHighlight;
        // adding comments for practice

	public WebDriver getBrowser(Properties prop) {

		String browser = prop.getProperty("browser");
		isHighlight = prop.getProperty("highlight");

		if (browser.trim().equalsIgnoreCase("chrome")) {
			return driver = new ChromeDriver();
		}

		else if (browser.trim().equalsIgnoreCase("firefox")) {
			return driver = new FirefoxDriver();
		}

		else if (browser.trim().equalsIgnoreCase("edge")) {
			return driver = new EdgeDriver();
		}
		return null;

	}

	public Properties initProperty() {

		prop = new Properties();

		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
			prop.load(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;

	}

}
