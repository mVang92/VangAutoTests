package carSpace.authentication;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class LoginTest extends BasePage {

	/**
	 * Verify the user can sign-in and sign-out, and the email displays correctly
	 */
	@Test
	private void loginTest() {
		doSignIn();
		clickOnElement(getProp("menuDropdownButton"), id);
		clickOnElement(getProp("accountNavButton"), id);
		assertEquals(getText(getProp("accountPageUserEmail"), id), getProp("testUser"));
		doSignOut();
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
