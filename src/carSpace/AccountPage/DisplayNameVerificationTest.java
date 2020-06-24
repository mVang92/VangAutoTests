package carSpace.AccountPage;

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
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		clickOnElement(submitNewDisplayNameButton, id);
		clickOnElement(confirmUpdateDisplayNameButton, id);
		clickOnElement(closeUpdateDisplayNameSuccessModalButton, id);
		assertEquals(getText(displayName, id), defaultDisplayName);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		assertEquals(getText(accountPageUserDisplayName, id), defaultDisplayName);
		fillInputField(newDisplayNameInput, testUserDisplayName, id);
		clickOnElement(submitNewDisplayNameButton, id);
		String expectedTitle = "Use \"" + testUserDisplayName + "\" as your name?";
		assertEquals(getText(modalTitle, xpath), expectedTitle);
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