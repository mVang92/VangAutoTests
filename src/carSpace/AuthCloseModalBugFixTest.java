package carSpace;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class AuthCloseModalBugFixTest extends BaseClass {

	@BeforeClass
	private void setup() {
		setProperty();
		maximizeWindow();
		useCarSpaceUrl();
	}

	/**
	 * Verify the email and password states reset for SignIn after attempting to
	 * SignUp with bad credentials after clicking the modal Close button
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void verifyReactStatesResetAfterClosingSignUpModal() throws InterruptedException {
		clickOnElement(signUpNavButton, id);
		fillInputField(emailTextInput, email, id);
		clickOnElement(signUpButton, id);
		Thread.sleep(1000);
		String expectedMessage = invalidPasswordErrorMessage;
		String actualMessage = getText(toastNotificationBody, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(toastNotificationCloseButton, xpath);
		clickOnElement(closeSignUpModal, id);
		clickOnElement(signInNavButton, id);
		fillInputField(passwordTextInput, password, id);
		clickOnElement(signInButton, id);
		Thread.sleep(1000);
		expectedMessage = invalidEmailErrorMessage;
		actualMessage = getText(toastNotificationBody, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(toastNotificationCloseButton, xpath);
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
