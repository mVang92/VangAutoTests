package mVangPortfolio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class NavigationButtonTest extends BaseClass {
	
	/**
	 * Verifies the functionality of the navigation buttons
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void navigationButtonTest() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		maximizeWindow(driver);
		driver.get(mVangPortfolioUrl);
		clickOnElementUsingXpath(driver, contactNavButton);
		clickOnElementUsingXpath(driver, myProjectsNavButton);
		clickOnElementUsingXpath(driver, aboueMeNavButton);
		driver.close();
	}
}
