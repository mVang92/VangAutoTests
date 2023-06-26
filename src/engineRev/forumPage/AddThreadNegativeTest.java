package engineRev.forumPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class AddThreadNegativeTest extends BasePage {
	
	@BeforeClass
	private void setup() {
		doSignIn();
	}
	
	/**
	 * Verify the error message when trying to submit a thread with empty input fields
	 */
	@Test
	private void missingInputFieldsTest() {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(forumNavButton, id);
		clickOnElement(composeThreadButton, id);
		clickOnElement(submitNewThreadButton, id);
		assertEquals(getText(toastNotificationBody, xpath), addThreadMissingFieldsErrorMessage);
		clickOnElement(toastNotificationCloseButton, xpath);
		fillInputField(newThreadTitleInput, generateCustomText(15), id);
		clickOnElement(submitNewThreadButton, id);
		assertEquals(getText(toastNotificationBody, xpath), addThreadMissingFieldsErrorMessage);
		clickOnElement(toastNotificationCloseButton, xpath);
		fillInputField(newThreadTitleInput, " ", id);
		fillInputField(newThreadDescriptionInput, generateCustomText(15), id);
		clickOnElement(submitNewThreadButton, id);
		assertEquals(getText(toastNotificationBody, xpath), addThreadMissingFieldsErrorMessage);
		clickOnElement(toastNotificationCloseButton, xpath);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}
