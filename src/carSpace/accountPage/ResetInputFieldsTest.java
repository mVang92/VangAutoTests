package carSpace.accountPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePage.BasePage;

public class ResetInputFieldsTest extends BasePage {

	@DataProvider(name = "testData")
	public Object[][] dataProviderMethod() {
		String testUserDisplayName = getProp("testUserDisplayName");
		String picture = getProp("resetInputFieldsTestImage");
		String expectedModalTitle = getProp("updateDisplayNameModalBodyText");
		String closeUpdatePictureModalButton = getProp("closeUpdatePictureModalButton");
		return new Object[][] {
			{
				getProp("newBackgroundPictureInput"),
				getProp("submitNewBackgroundPictureButton"),
				expectedUpdateBackgroundPictureModalTitle,
				getProp("resetNewBackgroundPictureButton"),
				expectedDefaultBackgroundPictureModalTitle,
				picture,
				closeUpdatePictureModalButton
			},
			{
				getProp("newProfilePictureInput"),
				getProp("submitNewProfilePictureButton"),
				expectedUpdateProfilePictureModalTitle,
				getProp("resetNewProfilePictureButton"),
				expectedDefaultPictureModalTitle,
				picture,
				closeUpdatePictureModalButton
			},
			{
				getProp("newDisplayNameInput"),
				getProp("submitNewDisplayNameButton"),
				String.format(expectedModalTitle, testUserDisplayName),
				getProp("resetNewDisplayNameButton"),
				expectedDefaultNameModalTitle,
				testUserDisplayName,
				getProp("closeUpdateDisplayNameModalButton")
			}
		};
	}

	@BeforeClass
	public void setup() {
		doSignIn();
		clickOnElement(getProp("menuDropdownButton"), id);
		clickOnElement(getProp("accountNavButton"), id);
	}

	/**
	 * Verify the Reset function works for the update input fields and the react states reset with each field
	 */
	@Test(dataProvider = "testData")
	public void resetInputFieldsTest(
		String inputField,
		String submitButton,
		String expectedModalTitle,
		String resetButton,
		String expectedDefaultModalTitle,
		String inputValue,
		String closeModalButton
	) {
		assertEquals(getValue(inputField, id), "");
		fillInputField(inputField, inputValue, id);
		clickOnElement(submitButton, id);
		assertEquals(getText(modalTitle, xpath), expectedModalTitle);
		clickOnElement(closeModalButton, id);
		clickOnElement(resetButton, id);
		clickOnElement(submitButton, id);
		assertEquals(getText(modalTitle, xpath), expectedDefaultModalTitle);
		clickOnElement(closeModalButton, id);
	}

	@AfterClass
	public void teardown() {
		close();
	}
}
