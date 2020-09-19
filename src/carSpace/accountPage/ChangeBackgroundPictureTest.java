package carSpace.accountPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class ChangeBackgroundPictureTest extends BasePage {
	private String imageUrl;
	private String defaultImageUrl;
	
	@BeforeClass
	private void setup() {
		doSignIn();
		imageUrl = getProp("sillyLookingKrabs");
		defaultImageUrl = getProp("defaultImage");
	}
	
	/**
	 * Verify the user can successfully change their background picture
	 */
	@Test
	private void changeBackgroundPictureTest() {
		clickOnElement(getProp("menuDropdownButton"), id);
		clickOnElement(getProp("accountNavButton"), id);
		fillInputField(getProp("newBackgroundPictureInput"), imageUrl, id);
		clickOnElement(getProp("submitNewBackgroundPictureButton"), id);
		assertEquals(getText(modalTitle, xpath), expectedUpdateBackgroundPictureModalTitle);
		assertEquals(getImageSrcAttribute(getProp("backgroundPicturePreview"), id), imageUrl);
		clickOnElement(getProp("confirmUpdatePictureButton"), id);
	}
	
	@AfterClass
	private void teardown() {
		changeBackgroundPicture(defaultImageUrl);
		close();
	}
}
