package engineRev.authentication;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import basePage.BasePage;

public class ForgotPasswordTest extends BasePage{
	
	@BeforeClass
	private void setup() {
		doEngineRevTest();
	}
	
	@BeforeMethod
	private void openSignInModal() {
		clickOnElement(signInNavButton, id);
		clickOnElement(forgotPassword, id);
	}

	/**
	 * Verify the email confirmation toast notification displays after sending the password reset confirmation
	 */
	@Test
	private void forgotPasswordTestPositive() {
		fillInputField(emailInputForPasswordReset, getProp("testUser"), id);
		clickOnElement(forgotPasswordSubmitButton, id);
		assertEquals(getText(toastNotificationBody, xpath), passwordResetConfirmationSuccessMessage);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
		clickOnElement(closeForgotPasswordModal, id);
	}
	
	/**
	 * Verify the email confirmation toast notification displays an error with an empty input field
	 */
	@Test(priority = 1)
	private void forgotPasswordEmptyInputTest() {
		fillInputField(emailInputForPasswordReset, " ", id);
		clickOnElement(forgotPasswordSubmitButton, id);
		assertEquals(getText(toastNotificationBody, xpath), invalidEmailErrorMessage);
		clickOnElement(toastNotificationErrorCloseButton, xpath);
		clickOnElement(closeForgotPasswordModal, id);
	}
	
	/**
	 * Verify the email confirmation toast notification displays an error with an email that does not exist
	 */
	@Test(priority = 2)
	private void forgotPasswordNoRegisteredEmailTest() {
		fillInputField(emailInputForPasswordReset, getProp("unregisteredTestUser"), id);
		clickOnElement(forgotPasswordSubmitButton, id);
		assertEquals(getText(toastNotificationBody, xpath), invalidEmailErrorMessage);
		clickOnElement(toastNotificationErrorCloseButton, xpath);
		clickOnElement(closeForgotPasswordModal, id);
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
