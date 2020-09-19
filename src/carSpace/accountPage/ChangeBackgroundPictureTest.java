package carSpace.accountPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class ChangeBackgroundPictureTest extends BasePage {
	private String imageUrl = getProp("sillyLookingKrabs");
	private String defaultImageUrl = getProp("defaultImage");
	
	@BeforeClass
	private void setup() {
		doSignIn();
	}
	
	/**
	 * Verify the user can successfully change their background picture
	 */
	@Test
	private void changeBackgroundPictureTest() {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(getProp("accountNavButton"), id);
		fillInputField(newBackgroundPictureInput, imageUrl, id);
		clickOnElement(submitNewBackgroundPictureButton, id);
		assertEquals(getText(modalTitle, xpath), expectedUpdateBackgroundPictureModalTitle);
		assertEquals(getImageSrcAttribute(backgroundPicturePreview, id), imageUrl);
		clickOnElement(confirmUpdatePictureButton, id);
	}
	
	@AfterClass
	private void teardown() {
		changeBackgroundPicture(defaultImageUrl);
		close();
	}
}
