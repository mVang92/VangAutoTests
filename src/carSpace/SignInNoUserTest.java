package carSpace;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class SignInNoUserTest extends BaseClass {
	private String noRecordUserEmail = "noRecordUser@gmail.com";
	private String noRecordUserpassword = "123456";
	
	@BeforeClass
	public void setup() throws InterruptedException {
		doSignIn(noRecordUserEmail, noRecordUserpassword);
	}

	/**
	 * Verify the toast error message upon signing in with an account not on record
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void signInNoUserTest() throws InterruptedException {
		String expectedMessage = noUserOnRecordSignInErrorMessage;
		String actualMessage = getTextUsingXpath(toastNotificationBody);
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
