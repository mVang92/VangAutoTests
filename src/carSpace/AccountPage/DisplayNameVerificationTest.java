package carSpace.AccountPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class DisplayNameVerificationTest extends BaseClass {

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
		String displayNameInMainPage = getText(displayName, id);
		assertEquals(displayNameInMainPage, defaultDisplayName);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		String displayNameInAccountPage = getText(accountPageUserDisplayName, id);
		assertEquals(displayNameInAccountPage, defaultDisplayName);
		fillInputField(newDisplayNameInput, testUserDisplayName, id);
		clickOnElement(submitNewDisplayNameButton, id);
		String actualTitle = getText(modalTitle, xpath);
		String expectedTitle = "Use \"" + testUserDisplayName + "\" as your name?";
		assertEquals(actualTitle, expectedTitle);
		clickOnElement(confirmUpdateDisplayNameButton, id);
		clickOnElement(closeUpdateDisplayNameSuccessModalButton, id);
		displayNameInMainPage = getText(displayName, id);
		assertEquals(displayNameInMainPage, testUserDisplayName);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		displayNameInAccountPage = getText(accountPageUserDisplayName, id);
		assertEquals(displayNameInAccountPage, testUserDisplayName);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}