package carSpace.accountPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class DisplayNameVerificationTest extends BasePage {

	@BeforeClass
	private void setup() {
		doSignIn();
	}
	
	/**
	 * Verify the functionality of the update display name feature
	 */
	@Test
	public void displayNameVerificationTest() {
		String accountNavButton = getProp("accountNavButton");
		String defaultDisplayName = getProp("defaultDisplayName");
		String testUserDisplayName = getProp("testUserDisplayName");
		String menuDropdownButton = getProp("menuDropdownButton");
		String expectedModalTitle = getProp("updateDisplayNameModalBodyText");
		String submitNewDisplayNameButton = getProp("submitNewDisplayNameButton");
		String confirmUpdateDisplayNameButton = getProp("confirmUpdateDisplayNameButton");
		String closeUpdateDisplayNameSuccessModalButton = getProp("closeUpdateDisplayNameSuccessModalButton");
		String accountPageUserDisplayName = getProp("accountPageUserDisplayName");
		String displayName = getProp("displayName");
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		clickOnElement(submitNewDisplayNameButton, id);
		clickOnElement(confirmUpdateDisplayNameButton, id);
		clickOnElement(closeUpdateDisplayNameSuccessModalButton, id);
		assertEquals(getText(displayName, id), defaultDisplayName);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		assertEquals(getText(accountPageUserDisplayName, id), defaultDisplayName);
		fillInputField(getProp("newDisplayNameInput"), testUserDisplayName, id);
		clickOnElement(submitNewDisplayNameButton, id);
		assertEquals(getText(getProp("modalTitle"), xpath), String.format(expectedModalTitle, testUserDisplayName));
		clickOnElement(confirmUpdateDisplayNameButton, id);
		clickOnElement(closeUpdateDisplayNameSuccessModalButton, id);
		assertEquals(getText(displayName, id), testUserDisplayName);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		assertEquals(getText(accountPageUserDisplayName, id), testUserDisplayName);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}