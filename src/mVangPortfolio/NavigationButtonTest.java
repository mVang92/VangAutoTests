package mVangPortfolio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class NavigationButtonTest extends BaseClass {
	
	@Test
	private void navigationButtonTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		maximizeWindow(driver);
		driver.get(mVangPortfolioUrl);
		clickOnElementUsingXpath(driver, aboueMeNavButton);
		Thread.sleep(250);
		clickOnElementUsingXpath(driver, myProjectsNavButton);
		Thread.sleep(250);
		clickOnElementUsingXpath(driver, contactNavButton);
		Thread.sleep(500);
		clickOnElementUsingId(driver, backToTopButton);
		driver.close();
	}
}
