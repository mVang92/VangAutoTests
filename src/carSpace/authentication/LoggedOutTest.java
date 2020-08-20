package carSpace.authentication;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class LoggedOutTest extends BasePage{
	
	@BeforeClass
	private void setup() {
		doCarSpaceTest();
	}
	
	/**
	 * Verify certain elements around the app are not present when a user is not logged in
	 */
	@Test
	private void loggedOutTest() {
		clickOnElement(forumFooterLink, xpath);
		assertEquals(getText(forumPageHeader, xpath), "Forum");
		System.out.println(getCurrentUrl());
//		assertEquals(getCurrentUrl(), "Forum");
		assertFalse(isElementDisplayed(startNewThreadButton, id));
	}
	
	@AfterClass
	private void teardown() {
		close();
	}

}
