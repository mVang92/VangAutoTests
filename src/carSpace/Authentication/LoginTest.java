package carSpace.Authentication;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class LoginTest extends BaseClass {

	/**
	 * Verify the sign-in and sign-out capabilities
	 */
	@Test
	private void signInTest() {
		doSignIn();
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		String expectedUserEmail = email;
		String actualUserEmail = getText(accountPageUserEmail, id);
		assertEquals(actualUserEmail, expectedUserEmail);
		doSignOut();
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
