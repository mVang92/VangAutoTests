package engineRev.authentication;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class LoginTest extends BasePage {
	
	@BeforeClass
	public void setup() {
		doEngineRevTest();
	}

	/**
	 * Verify the user can sign-in and sign-out, and the email displays correctly
	 */
	@Test
	private void loginTest() {
		String testUser = getProp("testUser");
		signIn(testUser, getProp("testUserPassword"));
		assertEquals(getText(displayName, id), getProp("testUserDisplayName"));
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		assertEquals(getText(accountPageUserEmail, id), testUser);
		assertEquals(getPlaceholderText(newDisplayNameInput, id), getText(accountPageUserDisplayName, id));
		doSignOut();
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
