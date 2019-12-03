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
		clickOnElementUsingXpath(aboueMeNavButton);
		Thread.sleep(500);
		clickOnElementUsingXpath(myProjectsNavButton);
		Thread.sleep(500);
		clickOnElementUsingXpath(contactNavButton);
		Thread.sleep(1000);
		clickOnElementUsingId(backToTopButton);
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
