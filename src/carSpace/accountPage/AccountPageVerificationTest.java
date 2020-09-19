package carSpace.accountPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import basePage.BasePage;
import static org.testng.Assert.assertEquals;

public class AccountPageVerificationTest extends BasePage {
	
	private String mainPageDisplayName;
	private String applicationName = getProp("applicationName");
	
	@BeforeClass
	private void setup() {
		doSignIn();
	}
	
	@BeforeMethod
	private void navigateToAccountPage() {
		mainPageDisplayName = getText(displayName, id);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(getProp("accountNavButton"), id);
	}
	
	/**
	 * Verify the user data appears correctly in the Account Details section
	 */
	@Test(priority = 0)
	public void userDataVerificationTest() {
		assertEquals(getText(accountPageUserDisplayName, id), mainPageDisplayName);
		assertEquals(getText(accountPageUserEmail, id), getProp("testUser"));
		assertEquals(getText(userRole, id), "User");
		clickOnElement(applicationName, id);
	}
	
	/**
	 * Verify the functionality to update user data displays the proper modal when submitting blank values
	 */
	@Test(priority = 1)
	public void inputFieldsVerificationTest() {
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
		clickOnElement(applicationName, id);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}
