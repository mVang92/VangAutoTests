package carSpace.accountPage;

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
	public void changeProfilePictureTest() {
		String imageUrl = getProp("sillyLookingKrabs");
		String accountNavButton = getProp("accountNavButton");
		String menuDropdownButton = getProp("menuDropdownButton");
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		fillInputField(getProp("newProfilePictureInput"), imageUrl, id);
		clickOnElement(getProp("submitNewProfilePictureButton"), id);
		assertEquals(getText(modalTitle, xpath), expectedUpdateProfilePictureModalTitle);
		assertEquals(getImageSrcAttribute(getProp("profilePicturePreview"), id), imageUrl);
		clickOnElement(getProp("confirmUpdatePictureButton"), id);
		clickOnElement(getProp("closeUpdateProfilePictureSuccessModalButton"), id);
		assertEquals(getImageSrcAttribute(getProp("mainPageProfilePicture"), id), imageUrl);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		assertEquals(getImageSrcAttribute(getProp("profilePicture"), id), imageUrl);
	}
	
	@AfterClass
	private void teardown() {
		changeProfilePicture("");
		close();
	}
}
