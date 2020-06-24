package mVangPortfolio;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class NavigationButtonTest extends BasePage {

	/**
	 * Verify the functionality of the navigation buttons and the back to top button
	 */
	@Test
	private void navigationButtonTest() {
		setProperty();
		maximizeWindow();
		usePortfolioUrl();
		clickOnElement(aboutMeNavButton, xpath);
		clickOnElement(myProjectsNavButton, xpath);
		clickOnElement(contactNavButton, xpath);
		clickOnElement(backToTopButton, id);
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
