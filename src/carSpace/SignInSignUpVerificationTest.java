package carSpace;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class SignInSignUpVerificationTest extends BaseClass {

	/**
	 * Verify the email and password states reset for SignIn after attempting to
	 * SignUp with bad credentials
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void verifyReactStatesResetAfterClosingSignUpModal() throws InterruptedException {
		setProperty();
		maximizeWindow();
		useCarSpaceUrl();
		clickOnElement(signUp, id);
		fillInputField(emailTextInput, email, id);
		clickOnElement(signUpButton, id);
		Thread.sleep(1000);
		String expectedMessage = invalidPasswordErrorMessage;
		String actualMessage = getText(toastNotificationBody, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(toastNotificationCloseButton, xpath);
		clickOnElement(closeSignUpModal, id);
		clickOnElement(signIn, id);
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
