package carSpace.AccountPage;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import baseClass.BaseClass;

public class AccountPageVerificationTest extends BaseClass {
	
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
		String actualUserEmail = getText(accountPageUserEmail, id);
		assertTrue(actualUserEmail.contains(email));
		clickOnElement(submitNewProfilePictureButton, id);
		String actualDefaultPictureModalTitle = getText(modalTitle, xpath);
		assertEquals(actualDefaultPictureModalTitle, expectedDefaultPictureModalTitle);
		clickOnElement(closeUpdatePictureModalButton, id);
		clickOnElement(submitNewDisplayNameButton, id);
		String actualDefaultNameModalTitle = getText(modalTitle, xpath);
		assertEquals(actualDefaultNameModalTitle, expectedDefaultNameModalTitle);
		clickOnElement(closeUpdateDisplayNameModalButton, id);
		clickOnElement(submitNewPasswordButton, id);
		String actualErrorMessage = getText(toastNotificationBody, xpath);
		assertEquals(actualErrorMessage, invalidPasswordErrorMessage);
	}
	
	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}

}
