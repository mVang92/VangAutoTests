package engineRev.accountPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePage.BasePage;

public class ResetInputFieldsTest extends BasePage {

	@DataProvider(name = "testData")
	private Object[][] dataProviderMethod() {
		String testUserDisplayName = getProp("testUserDisplayName");
		String picture = getProp("resetInputFieldsTestImage");
		return new Object[][] {
			{
				newBackgroundPictureInput,
				submitNewBackgroundPictureButton,
				expectedUpdateBackgroundPictureModalTitle,
				resetNewBackgroundPictureButton,
				expectedDefaultBackgroundPictureModalTitle,
				picture,
				closeUpdatePictureModalButton
			},
			{
				newProfilePictureInput,
				submitNewProfilePictureButton,
				expectedUpdateProfilePictureModalTitle,
				resetNewProfilePictureButton,
				expectedDefaultPictureModalTitle,
				picture,
				closeUpdatePictureModalButton
			},
			{
				newDisplayNameInput,
				submitNewDisplayNameButton,
				String.format(getProp("updateDisplayNameModalBodyText"), testUserDisplayName),
				resetNewDisplayNameButton,
				expectedDefaultNameModalTitle,
				testUserDisplayName,
				closeUpdateDisplayNameModalButton
			}
		};
	}

	@BeforeClass
	private void setup() {
		doSignIn();
		navigateToAccountPage();
	}

	/**
	 * Verify the Reset function works for the update input fields and the react states reset with each field
	 */
	@Test(dataProvider = "testData")
	private void resetInputFieldsTest(
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
	private void teardown() {
		close();
	}
}
