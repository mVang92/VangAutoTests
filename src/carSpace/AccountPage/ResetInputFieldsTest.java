package carSpace.AccountPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class ResetInputFieldsTest extends BaseClass {
	private String picture = "https://oswallpapers.com/wp-content/uploads/2016/06/img19.jpg";
	private String displayName = "Sally Thing";
	
	@DataProvider(name = "testData")
    public Object[][] dataProviderMethod() {
        return new Object[][]
        {
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
        		"Use \"" + displayName + "\" as your name?",
        		resetNewDisplayNameButton,
        		expectedDefaultNameModalTitle,
        		displayName,
        		closeUpdateDisplayNameModalButton
        	}
        };
    }
	
	@BeforeClass
	private void setup() {
		doSignIn();
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
	}
	
	/**
	 * Verify the Reset function works for the update input fields and the react states reset each field
	 */
	@Test(dataProvider = "testData")
	public void updateBackgroundPictureResetInputFieldTest(
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
	
	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}

}
