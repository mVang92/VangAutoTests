package carSpace.AccountPage;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class ResetInputFieldsTest extends BaseClass {
	
	@BeforeClass
	private void setup() {
		doSignIn();
	}
	
	/**
	 * Verify the Reset function works for each input field,
	 * and the react states reset with each reset
	 */
	@Test
	public void updateBackgroundPictureResetInputFieldTest() {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		assertEquals(getValue(newBackgroundPictureInput, id), "");
		fillInputField(newBackgroundPictureInput, "https://oswallpapers.com/wp-content/uploads/2016/06/img19.jpg", id);
		clickOnElement(submitNewBackgroundPictureButton, id);
		assertEquals(getText(modalTitle, xpath), expectedUpdateBackgroundPictureModalTitle);
		clickOnElement(closeUpdatePictureModalButton, id);
		clickOnElement(resetNewBackgroundPictureButton, id);
		clickOnElement(submitNewBackgroundPictureButton, id);
		assertEquals(getText(modalTitle, xpath), expectedDefaultBackgroundPictureModalTitle);
		clickOnElement(closeUpdatePictureModalButton, id);
	}
	
	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}

}
