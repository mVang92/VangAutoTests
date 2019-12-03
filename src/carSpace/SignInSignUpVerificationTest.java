package carSpace;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class SignInSignUpVerificationTest extends BaseClass {

	/**
	 * This test ensures the email and password states reset for SignIn after
	 * attempting to SignUp with bad credentials
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void verifyReactStatesResetAfterClosingSignUpModal() throws InterruptedException {
		setProperty();
		maximizeWindow();
		testCarSpace();
		clickOnElementUsingId(signUp);
		fillInputFieldUsingId(emailTextInput, email);
		clickOnElementUsingId(signUpButton);
		Thread.sleep(1000);
		String expectedMessage = invalidPasswordErrorMessage;
		String actualMessage = getTextUsingXpath(toastNotificationBody);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElementUsingXpath(toastNotificationCloseButton);
		clickOnElementUsingId(closeSignUpModal);
		clickOnElementUsingId(signIn);
		fillInputFieldUsingId(passwordTextInput, password);
		clickOnElementUsingId(signInButton);
		Thread.sleep(1000);
		expectedMessage = invalidEmailErrorMessage;
		actualMessage = getTextUsingXpath(toastNotificationBody);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElementUsingXpath(toastNotificationCloseButton);
		close();
	}
}
