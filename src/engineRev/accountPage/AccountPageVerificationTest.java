package engineRev.accountPage;

import resources.Roles;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import basePage.BasePage;
import static org.testng.Assert.assertEquals;

public class AccountPageVerificationTest extends BasePage {
	
	private String mainPageDisplayName;
	private String testUser;
	
	@BeforeClass
	private void setup() {
		doSignIn();
		testUser = getProp("testUser");
	}
	
	@BeforeMethod
	private void getDisplayNameThenNavigateToAccountPage() {
		mainPageDisplayName = getText(displayName, id);
		navigateToAccountPage();
	}
	
	/**
	 * Verify the user data appears correctly in the Account Details section
	 */
	@Test
	private void userDataVerificationTest() {
		assertEquals(getTitle(profilePicture, id), getText(accountPageUserDisplayName, id));
		assertEquals(getText(accountPageUserDisplayName, id), mainPageDisplayName);
		assertEquals(getText(accountPageUserEmail, id), testUser);
		assertEquals(getText(userRole, id), Roles.TEST_USER.toString());
		clickOnElement(applicationName, id);
	}
	
	/**
	 * Verify the functionality to update user data displays the proper modal when submitting blank values
	 */
	@Test(priority = 1)
	private void inputFieldsVerificationTest() {
		clickOnElement(submitNewBackgroundPictureButton, id);
		assertEquals(getText(modalTitle, xpath), expectedDefaultBackgroundPictureModalTitle);
		clickOnElement(closeUpdatePictureModalButton, id);
		clickOnElement(submitNewProfilePictureButton, id);
		assertEquals(getText(modalTitle, xpath), expectedDefaultPictureModalTitle);
		clickOnElement(closeUpdatePictureModalButton, id);
		clickOnElement(submitNewDisplayNameButton, id);
		assertEquals(getText(modalTitle, xpath), expectedDefaultNameModalTitle);
		clickOnElement(closeUpdateDisplayNameModalButton, id);
		clickOnElement(advancedSettingsToggle, id);
		assertEquals(getPlaceholderText(newEmailInput, id), testUser);
		clickOnElement(submitNewEmailButton, id);
		assertEquals(getText(toastNotificationBody, xpath), noAuthorizationErrorMessage);
		clickOnElement(toastNotificationErrorCloseButton, xpath);
		clickOnElement(submitNewPasswordButton, id);
		assertEquals(getText(toastNotificationBody, xpath), noAuthorizationErrorMessage);
		clickOnElement(applicationName, id);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}
