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
		clickOnElement(getProp("menuDropdownButton"), id);
		clickOnElement(getProp("forumNavButton"), id);
		clickOnElement(getProp("startNewThreadButton"), id);
	}
	
	/**
	 * Verify the error message when trying to submit a thread with empty input fields
	 */
	@Test
	private void missingInputFieldsTest() {
		String submitNewThreadButton = getProp("submitNewThreadButton");
		String newThreadTitleInput = getProp("newThreadTitleInput");
		clickOnElement(submitNewThreadButton, id);
		assertEquals(getText(toastNotificationBody, xpath), addThreadMissingFieldsErrorMessage);
		clickOnElement(toastNotificationErrorCloseButton, xpath);
		fillInputField(newThreadTitleInput, "Title", id);
		clickOnElement(submitNewThreadButton, id);
		assertEquals(getText(toastNotificationBody, xpath), addThreadMissingFieldsErrorMessage);
		clickOnElement(toastNotificationErrorCloseButton, xpath);
		fillInputField(newThreadTitleInput, " ", id);
		fillInputField(getProp("newThreadDescriptionInput"), "Description", id);
		clickOnElement(submitNewThreadButton, id);
		assertEquals(getText(toastNotificationBody, xpath), addThreadMissingFieldsErrorMessage);
		clickOnElement(toastNotificationErrorCloseButton, xpath);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}
