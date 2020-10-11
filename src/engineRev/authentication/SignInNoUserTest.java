package engineRev.authentication;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class SignInNoUserTest extends BasePage {

	@BeforeClass
	private void setup() {
		doSignIn("noRecordUser@gmail.com", "123456");
	}

	/**
	 * Verify the toast error message upon signing in with an account not on record
	 */
	@Test
	private void signInNoUserTest() {
		assertEquals(getText(toastNotificationBody, xpath), noUserOnRecordSignInErrorMessage);
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
