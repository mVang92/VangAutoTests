package engineRev.accountPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class ChangeProfilePictureTest extends BasePage {
	
	@BeforeClass
	private void setup() {
		doSignIn();
	}
	
	/**
	 * Verify the user can successfully change their profile picture
	 */
	@Test
	private void changeProfilePictureTest() {
		String imageUrl = getProp("sillyLookingKrabs");
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		fillInputField(newProfilePictureInput, imageUrl, id);
		clickOnElement(submitNewProfilePictureButton, id);
		assertEquals(getText(modalTitle, xpath), expectedUpdateProfilePictureModalTitle);
		assertEquals(getImageSrcAttribute(profilePicturePreview, id), imageUrl);
		clickOnElement(confirmUpdatePictureButton, id);
		clickOnElement(closeUpdateProfilePictureSuccessModalButton, id);
		assertEquals(getImageSrcAttribute(mainPageProfilePicture, id), imageUrl);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		assertEquals(getImageSrcAttribute(profilePicture, id), imageUrl);
	}
	
	@AfterClass
	private void teardown() {
		changeProfilePicture("");
		close();
	}
}
