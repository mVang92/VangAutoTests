package carSpace;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class LoginTest extends BaseClass {

	/**
	 * Verify the sign-in capability and logs out
	 *
	 * @throws InterruptedException
	 */
	@Test
	private void signInTest() throws InterruptedException {
		setProperty();
		maximizeWindow();
		testCarSpace();
		doSignIn();
		String expectedUserEmail = email;
		String actualUserEmail = getTextUsingId(userEmailDisplay);
		assertTrue(actualUserEmail.contains(expectedUserEmail));
		doSignOut();
		close();
	}
}
