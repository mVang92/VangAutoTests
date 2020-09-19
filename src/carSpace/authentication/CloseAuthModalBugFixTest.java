package carSpace.authentication;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class CloseAuthModalBugFixTest extends BasePage {

	@BeforeClass
	private void setup() {
		doCarSpaceTest();
	}

	/**
	 * Verify the email and password states reset after attempting to sign-up with bad credentials
	 */
	@Test
	private void verifyReactStatesResetAfterClosingSignUpModal() {
		clickOnElement(getProp("signUpNavButton"), id);
		fillInputField(getProp("emailInput"), getProp("testUser"), id);
		clickOnElement(getProp("signUpButton"), id);
		assertEquals(getText(toastNotificationBody, xpath), invalidPasswordErrorMessage);
		clickOnElement(toastNotificationErrorCloseButton, xpath);
		clickOnElement(getProp("closeSignUpModal"), id);
		clickOnElement(getProp("signInNavButton"), id);
		fillInputField(getProp("passwordInput"), getProp("testUserPassword"), id);
		clickOnElement(getProp("signInButton"), id);
		assertEquals(getText(toastNotificationBody, xpath), invalidEmailErrorMessage);
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
