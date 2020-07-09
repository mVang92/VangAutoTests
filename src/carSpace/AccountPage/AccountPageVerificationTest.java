package carSpace.AccountPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

import static org.testng.Assert.assertEquals;

public class AccountPageVerificationTest extends BasePage {
	
	@BeforeClass
	private void setup() {
		doSignIn();
	}
	
	/**
	 * Verify the functionality of the Account page
	 */
	@Test
	public void accountPageVerificationTest() {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		assertEquals(getText(accountPageUserEmail, id), email);
		clickOnElement(submitNewBackgroundPictureButton, id);
		assertEquals(getText(modalTitle, xpath), expectedDefaultBackgroundPictureModalTitle);
		clickOnElement(closeUpdatePictureModalButton, id);
		clickOnElement(submitNewProfilePictureButton, id);
		assertEquals(getText(modalTitle, xpath), expectedDefaultPictureModalTitle);
		clickOnElement(closeUpdatePictureModalButton, id);
		clickOnElement(submitNewDisplayNameButton, id);
		assertEquals(getText(modalTitle, xpath), expectedDefaultNameModalTitle);
		clickOnElement(closeUpdateDisplayNameModalButton, id);
		clickOnElement(submitNewPasswordButton, id);
		assertEquals(getText(toastNotificationBody, xpath), invalidPasswordErrorMessage);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}
