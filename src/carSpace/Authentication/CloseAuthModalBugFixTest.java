package carSpace.Authentication;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class CloseAuthModalBugFixTest extends BaseClass {

	@BeforeClass
	private void setup() {
		setProperty();
		maximizeWindow();
		useCarSpaceUrl();
	}

	/**
	 * Verify the email and password states reset after attempting to SignUp with bad credentials
	 */
	@Test
	private void verifyReactStatesResetAfterClosingSignUpModal() {
		clickOnElement(signUpNavButton, id);
		fillInputField(emailTextInput, email, id);
		clickOnElement(signUpButton, id);
		String expectedMessage = invalidPasswordErrorMessage;
		String actualMessage = getText(toastNotificationBody, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(toastNotificationErrorCloseButton, xpath);
		clickOnElement(closeSignUpModal, id);
		clickOnElement(signInNavButton, id);
		fillInputField(passwordTextInput, password, id);
		clickOnElement(signInButton, id);
		expectedMessage = invalidEmailErrorMessage;
		actualMessage = getText(toastNotificationBody, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(toastNotificationErrorCloseButton, xpath);
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
