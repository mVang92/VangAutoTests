package carSpace.Authentication;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class LoginTest extends BasePage {

	/**
	 * Verify the sign-in and sign-out capabilities
	 */
	@Test
	private void signInTest() {
		doSignIn();
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		String actualUserEmail = getText(accountPageUserEmail, id);
		assertEquals(actualUserEmail, email);
		doSignOut();
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
