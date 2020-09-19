package carSpace.accountPage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import basePage.BasePage;
import static org.testng.Assert.assertEquals;

public class AccountPageVerificationTest extends BasePage {
	
	private String applicationName;
	private String mainPageDisplayName;
	
	@BeforeClass
	private void setup() {
		doSignIn();
		applicationName = getProp("applicationName");
	}
	
	@BeforeMethod
	private void navigateToAccountPage() {
		mainPageDisplayName = getText(getProp("displayName"), id);
		clickOnElement(getProp("menuDropdownButton"), id);
		clickOnElement(getProp("accountNavButton"), id);
	}
	
	/**
	 * Verify the user data appears correctly in the Account Details section
	 */
	@Test(priority = 0)
	public void userDataVerificationTest() {
		assertEquals(getText(getProp("accountPageUserDisplayName"), id), mainPageDisplayName);
		assertEquals(getText(getProp("accountPageUserEmail"), id), getProp("testUser"));
		assertEquals(getText(getProp("userRole"), id), "User");
		clickOnElement(applicationName, id);
	}
	
	/**
	 * Verify the functionality to update user data displays the proper modal when submitting blank values
	 */
	@Test(priority = 1)
	public void inputFieldsVerificationTest() {
		String closeUpdatePictureModalButton = getProp("closeUpdatePictureModalButton");
		String modalTitle = getProp("modalTitle");
		clickOnElement(getProp("submitNewBackgroundPictureButton"), id);
		assertEquals(getText(modalTitle, xpath), expectedDefaultBackgroundPictureModalTitle);
		clickOnElement(closeUpdatePictureModalButton, id);
		clickOnElement(getProp("submitNewProfilePictureButton"), id);
		assertEquals(getText(modalTitle, xpath), expectedDefaultPictureModalTitle);
		clickOnElement(closeUpdatePictureModalButton, id);
		clickOnElement(getProp("submitNewDisplayNameButton"), id);
		assertEquals(getText(modalTitle, xpath), expectedDefaultNameModalTitle);
		clickOnElement(getProp("closeUpdateDisplayNameModalButton"), id);
		clickOnElement(getProp("submitNewPasswordButton"), id);
		assertEquals(getText(toastNotificationBody, xpath), invalidPasswordErrorMessage);
		clickOnElement(applicationName, id);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}
