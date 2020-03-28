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
		String userDisplayName = "Sally Thing";
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		clickOnElement(submitNewDisplayNameButton, id);
		clickOnElement(confirmUpdateDisplayNameButton, id);
		clickOnElement(closeUpdateDisplayNameSuccessModalButton, id);
		String displayNameInMainPage = getText(displayName, id);
		assertEquals(displayNameInMainPage, defaultDisplayName);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		fillInputField(newDisplayNameInput, userDisplayName, id);
		clickOnElement(submitNewDisplayNameButton, id);
		String actualTitle = getText(modalTitle, xpath);
		String expectedTitle = "Use \"" + userDisplayName + "\" as your name?";
		assertEquals(actualTitle, expectedTitle);
		clickOnElement(confirmUpdateDisplayNameButton, id);
		clickOnElement(closeUpdateDisplayNameSuccessModalButton, id);
		displayNameInMainPage = getText(displayName, id);
		assertEquals(displayNameInMainPage, userDisplayName);
	}
	
	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
