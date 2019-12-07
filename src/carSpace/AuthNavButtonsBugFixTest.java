package carSpace;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class AuthNavButtonsBugFixTest extends BaseClass {

	@BeforeClass
	private void setup() {
		setProperty();
		maximizeWindow();
		useCarSpaceUrl();
	}

	/**
	 * Verify the email and password states reset for SignIn after attempting to
	 * SignUp with bad credentials and clicking on the SignIn navigation button
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void verifyReactStatesResetAfterClickingNavButtons() throws InterruptedException {
		clickOnElement(signUpNavButton, id);
		fillInputField(passwordTextInput, password, id);
		clickOnElement(signUpButton, id);
		Thread.sleep(1000);
		String expectedMessage = passwordsDoNotMatchErrorMessage;
		String actualMessage = getText(toastNotificationBody, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(toastNotificationCloseButton, xpath);
		clickOnElement(signInNavButton, id);
		fillInputField(emailTextInput, email, id);
		clickOnElement(signInButton, id);
		Thread.sleep(1000);
		expectedMessage = invalidPasswordOrNoPasswordErrorMessage;
		actualMessage = getText(toastNotificationBody, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(toastNotificationCloseButton, xpath);
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
