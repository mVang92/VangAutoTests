package carSpace.forumPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class AddThreadNegativeTest extends BasePage {
	
	@BeforeClass
	private void setup() {
		doSignIn();
		clickOnElement(menuDropdownButton, id);
		clickOnElement(forumNavButton, id);
		clickOnElement(startNewThreadButton, id);
	}
	
	/**
	 * Verify the error message when trying to submit a thread with empty input fields
	 */
	@Test
	private void missingInputFieldsTest() {
		clickOnElement(submitNewThreadButton, id);
		assertEquals(getText(toastNotificationBody, xpath), addThreadMissingFieldsErrorMessage);
		clickOnElement(toastNotificationErrorCloseButton, xpath);
		fillInputField(newThreadTitleInput, "Title", id);
		clickOnElement(submitNewThreadButton, id);
		assertEquals(getText(toastNotificationBody, xpath), addThreadMissingFieldsErrorMessage);
		clickOnElement(toastNotificationErrorCloseButton, xpath);
		fillInputField(newThreadTitleInput, " ", id);
		fillInputField(newThreadDescriptionInput, "Description", id);
		clickOnElement(submitNewThreadButton, id);
		assertEquals(getText(toastNotificationBody, xpath), addThreadMissingFieldsErrorMessage);
		clickOnElement(toastNotificationErrorCloseButton, xpath);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}