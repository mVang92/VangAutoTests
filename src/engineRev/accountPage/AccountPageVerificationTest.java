package engineRev.accountPage;

import resources.Roles;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountPageVerificationTest extends BasePage {

	private String testUser;
	
	@BeforeClass
	private void setup() {
		doSignIn();
		testUser = getProp("testUser");
	}
	
	/**
	 * Verify the user data appears correctly in the Account Details section
	 */
	@Test
	private void userDataVerificationTest() {
		String mainPageDisplayName = getText(displayName, id);
		navigateToAccountPage();
		assertEquals(getTitle(profilePicture, id), getText(accountPageUserDisplayName, id));
		assertEquals(getText(accountPageUserDisplayName, id), mainPageDisplayName);
		assertEquals(getText(accountPageUserEmail, id), testUser);
		assertEquals(getText(userRole, id), Roles.TEST_USER.toString());
	}
	
	/**
	 * Verify the functionality to update user data displays the proper modal when submitting blank values
	 */
	@Test(priority = 1)
	private void inputFieldsVerificationTest() {
		navigateToAccountPage();
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
		assertEquals(getText(toastNotificationBody, xpath), emailCannotBeBlankErrorMessage);
		clickOnElement(toastNotificationCloseButton, xpath);
		clickOnElement(submitNewPasswordButton, id);
		assertEquals(getText(toastNotificationBody, xpath), passwordCannotBeBlankErrorMessage);
	}
	
	/**
	 * Verify the user can navigate to the Account page by clicking their display picture from the home page,
	 * or via the menu drop down
	 */
	@Test(priority = 2)
	private void navigationToAccountPageTest() {
		String path = "/account";
		clickOnElement(mainPageProfilePicture, id);
		assertTrue(getCurrentUrl().contains(path));
		clickOnElement(applicationName, id);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		assertTrue(getCurrentUrl().contains(path));
	}
	
	@AfterMethod
	private void goToHomePage() {
		clickOnElement(applicationName, id);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}
