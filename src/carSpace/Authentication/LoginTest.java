package carSpace.Authentication;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class LoginTest extends BaseClass {

	@BeforeClass
	private void setup() throws InterruptedException {
		doSignIn();
	}

	/**
	 * Verify the sign-in capability and logs out
	 */
	@Test
	private void signInTest() {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		String expectedUserEmail = email;
		String actualUserEmail = getText(accountPageUserEmail, id);
		assertTrue(actualUserEmail.contains(expectedUserEmail));
		doSignOut();
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
