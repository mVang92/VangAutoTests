package carSpace;

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
	 *
	 * @throws InterruptedException
	 */
	@Test
	private void signInTest() throws InterruptedException {
		String expectedUserEmail = email;
		String actualUserEmail = getText(userEmailDisplay, id);
		assertTrue(actualUserEmail.contains(expectedUserEmail));
		doSignOut();
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
