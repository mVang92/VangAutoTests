package carSpace.AccountPage;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class DisplayNameVerificationTest extends BaseClass {

	@BeforeClass
	private void setup() throws InterruptedException {
		doSignIn();
	}
	
	/**
	 * Verify the functionality of the update display name feature
	 * 
	 * @throws InterruptedException 
	 */
	@Test
	public void displayNameVerificationTest() throws InterruptedException {
		String userDisplayName = "Sally Thing";
		clickOnElement(accountNavButton, id);
		clickOnElement(submitNewDisplayNameButton, id);
		clickOnElement(confirmUpdateDisplayNameButton, id);
		Thread.sleep(500);
		String actualTitle = getText(modalTitle, xpath);
		assertEquals(actualTitle, expectedUpdateDisplayNameModalTitle);
		clickOnElement(closeUpdateDisplayNameSuccessModalButton, id);
		Thread.sleep(1000);
		String displayNameInMainPage = getText(displayName, id);
		assertEquals(displayNameInMainPage, defaultDisplayName);
		clickOnElement(accountNavButton, id);
		fillInputField(newDisplayNameInput, userDisplayName, id);
		clickOnElement(submitNewDisplayNameButton, id);
		actualTitle = getText(modalTitle, xpath);
		String expectedTitle = "Use \"" + userDisplayName + "\" as your name?";
		assertEquals(actualTitle, expectedTitle);
		clickOnElement(confirmUpdateDisplayNameButton, id);
		Thread.sleep(500);
		clickOnElement(closeUpdateDisplayNameSuccessModalButton, id);
		Thread.sleep(1000);
		displayNameInMainPage = getText(displayName, id);
		assertEquals(displayNameInMainPage, userDisplayName);
	}
	
	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
