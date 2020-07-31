package carSpace.Authentication;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class CloseAuthModalBugFixTest extends BasePage {

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
		assertEquals(getText(toastNotificationBody, xpath), invalidPasswordErrorMessage);
		clickOnElement(toastNotificationErrorCloseButton, xpath);
		clickOnElement(closeSignUpModal, id);
		clickOnElement(signInNavButton, id);
		fillInputField(passwordTextInput, password, id);
		clickOnElement(signInButton, id);
		assertEquals(getText(toastNotificationBody, xpath), invalidEmailErrorMessage);
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
