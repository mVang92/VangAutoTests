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
	private String forumPath = "/forum";
	private String updatesPath = "/updates";
	private String aboutPath = "/about";
	
	@DataProvider(name = "data")
	private Object[][] dataProviderMethod() {
		return new Object[][] {
			{
				aboutFooterLink,
				aboutPath			
			},
			{
				releaseNotesFooterLink,
				updatesPath
			},
			{
				forumFooterLink,
				forumPath
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
	private void loggedOutTest(String footerLink, String path) {
		clickOnElement(footerLink, xpath);
		if (path == forumPath) {
			assertEquals(getText(forumLoggedOutText, xpath), expectedForumLoggedOutText);
			assertTrue(isElementDisplayed(sortThreadsDropdown, id));
		}
		assertTrue(getCurrentUrl().contains(path));
		assertFalse(isElementDisplayed(startNewThreadButton, id));
		clickOnElement(applicationName, id);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}
