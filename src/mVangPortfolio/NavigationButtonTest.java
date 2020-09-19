package mVangPortfolio;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class NavigationButtonTest extends BasePage {
	
	@BeforeClass
	private void setup() {
		doPortfolioTest();
	}

	/**
	 * Verify the functionality of the navigation buttons and the back to top button
	 */
	@Test
	private void navigationButtonTest() {
		clickOnElement(getProp("aboutMeNavButton"), xpath);
		clickOnElement(getProp("myProjectsNavButton"), xpath);
		clickOnElement(getProp("contactNavButton"), xpath);
		clickOnElement(getProp("backToTopButton"), id);
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
