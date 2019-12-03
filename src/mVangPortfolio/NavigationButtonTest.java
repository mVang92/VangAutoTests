package mVangPortfolio;

import org.testng.annotations.Test;
import baseClass.BaseClass;

public class NavigationButtonTest extends BaseClass {

	@Test
	private void navigationButtonTest() throws InterruptedException {
		setProperty();
		maximizeWindow();
		testPortfolio();
		clickOnElementUsingXpath(aboueMeNavButton);
		Thread.sleep(250);
		clickOnElementUsingXpath(myProjectsNavButton);
		Thread.sleep(250);
		clickOnElementUsingXpath(contactNavButton);
		Thread.sleep(500);
		clickOnElementUsingId(backToTopButton);
		close();
	}
}
