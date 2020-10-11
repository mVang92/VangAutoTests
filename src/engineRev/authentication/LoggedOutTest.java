package engineRev.authentication;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePage.BasePage;

public class LoggedOutTest extends BasePage {
	
	private String expectedForumLoggedOutText = "Please sign in or create an account to start a thread.";
	private String forumDirectory = "/forum";
	private String updatesDirectory = "/updates";
	private String aboutDirectory = "/about";
	
	@DataProvider(name = "data")
	public Object[][] dataProviderMethod() {
		return new Object[][] {
			{
				aboutFooterLink,
				aboutDirectory			
			},
			{
				releaseNotesFooterLink,
				updatesDirectory
			},
			{
				forumFooterLink,
				forumDirectory
			}
		};
	}
	
	@BeforeClass
	private void setup() {
		doEngineRevTest();
	}
	
	/**
	 * Verify certain elements around the app are not present when a user is not logged in
	 */
	@Test(dataProvider = "data")
	private void loggedOutTest(String footerLink, String directory) {
		clickOnElement(footerLink, xpath);
		if (directory == forumDirectory) {
			assertEquals(getText(forumLoggedOutText, xpath), expectedForumLoggedOutText);
		}
		assertTrue(getCurrentUrl().contains(directory));
		assertFalse(isElementDisplayed(startNewThreadButton, id));
		clickOnElement(applicationName, id);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}
