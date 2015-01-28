package com.danielcorroto.selenium_tests.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverFactory {
	private static final int IMPLICIT_WAIT_TIME = 10;
	private static final TimeUnit IMPLICIT_WAIT_TIMEUNIT = TimeUnit.SECONDS;
	private static final int PAGE_LOAD_TIMEOUT_TIME = 10;
	private static final TimeUnit PAGE_LOAD_TIMEOUT_TIMEUNIT = TimeUnit.SECONDS;
	private static final int SCRIPT_TIMEOUT_TIME = -1;
	private static final TimeUnit SCRIPT_TIMEOUT_TIMEUNIT = TimeUnit.SECONDS;

	private static void setTimeouts(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, IMPLICIT_WAIT_TIMEUNIT);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT_TIME, PAGE_LOAD_TIMEOUT_TIMEUNIT);
		driver.manage().timeouts().setScriptTimeout(SCRIPT_TIMEOUT_TIME, SCRIPT_TIMEOUT_TIMEUNIT);
	}

	public static WebDriver newDriver() {
		return newFirefoxDriver();
	}

	public static WebDriver newDriverWithTimeouts() {
		WebDriver driver = newDriver();
		setTimeouts(driver);
		return driver;
	}

	public static WebDriver newFirefoxDriver() {
		return new FirefoxDriver();
	}
	
	public static WebDriver newFirefoxDriverWithTimeouts() {
		WebDriver driver = newFirefoxDriver();
		setTimeouts(driver);
		return driver;
	}

	public static WebDriver newChromeDriver() {
		return new ChromeDriver();
	}
	
	public static WebDriver newChromedDriverWithTimeouts() {
		WebDriver driver = newChromeDriver();
		setTimeouts(driver);
		return driver;
	}

	public static WebDriver newFirefoxDriverForDownload(String path) {
		FirefoxProfile firefoxProfile = new FirefoxProfile();

		firefoxProfile.setPreference("browser.download.folderList", 2);
		firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
		firefoxProfile.setPreference("browser.download.dir", path);
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");

		return new FirefoxDriver(firefoxProfile);
	}
}
