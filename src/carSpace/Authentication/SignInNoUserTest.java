package carSpace.Authentication;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class SignInNoUserTest extends BaseClass {

	@BeforeClass
	private void setup() throws InterruptedException {
		String noRecordUserEmail = "noRecordUser@gmail.com";
		String noRecordUserpassword = "123456";
		doSignIn(noRecordUserEmail, noRecordUserpassword);
	}

	/**
	 * Verify the toast error message upon signing in with an account not on record
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void signInNoUserTest() throws InterruptedException {
		String actualMessage = getText(toastNotificationBody, xpath);
		assertTrue(actualMessage.contains(noUserOnRecordSignInErrorMessage));
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
