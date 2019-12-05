package mVangPortfolio;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class NavigationButtonTest extends BaseClass {

	/**
	 * Verify the functionality of the navigation buttons and the back to top button
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void navigationButtonTest() throws InterruptedException {
		setProperty();
		maximizeWindow();
		usePortfolioUrl();
		clickOnElement(aboueMeNavButton, xpath);
		Thread.sleep(500);
		clickOnElement(myProjectsNavButton, xpath);
		Thread.sleep(500);
		clickOnElement(contactNavButton, xpath);
		Thread.sleep(1000);
		clickOnElement(backToTopButton, id);
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
