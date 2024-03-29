package engineRev.authentication;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class CloseAuthModalBugFixTest extends BasePage {

	@BeforeClass
	private void setup() {
		doEngineRevTest();
	}

	/**
	 * Verify the email and password states reset after attempting to sign-up with bad credentials
	 */
	@Test
	private void verifyReactStatesResetAfterClosingSignUpModal() {
		clickOnElement(signUpNavButton, id);
		fillInputField(emailInput, getProp("testUser"), id);
		clickOnElement(signUpButton, id);
		assertEquals(getText(toastNotificationBody, xpath), invalidPasswordErrorMessage);
		clickOnElement(toastNotificationCloseButton, xpath);
		clickOnElement(closeSignUpModal, id);
		clickOnElement(signInNavButton, id);
		fillInputField(passwordInput, getProp("testUserPassword"), id);
		clickOnElement(signInButton, id);
		assertEquals(getText(toastNotificationBody, xpath), invalidEmailErrorMessage);
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
