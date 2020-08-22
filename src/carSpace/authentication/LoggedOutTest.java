package carSpace.authentication;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePage.BasePage;

public class LoggedOutTest extends BasePage {
	
	@DataProvider(name = "data")
	public Object[][] dataProviderMethod() {
		return new Object[][] {
			{
				forumFooterLink,
				"/forum"				
			},
			{
				releaseNotesFooterLink,
				"/updates"
			},
			{
				aboutFooterLink,
				"/about"
			}
		};
	}
	
	@BeforeClass
	private void setup() {
		doCarSpaceTest();
	}
	
	/**
	 * Verify certain elements around the app are not present when a user is not logged in
	 */
	@Test(dataProvider = "data")
	private void loggedOutTest(String footerLink, String directory) {
		clickOnElement(footerLink, xpath);
		assertTrue(getCurrentUrl().contains(directory));
		assertFalse(isElementDisplayed(startNewThreadButton, id));
		clickOnElement(applicationName, id);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}

}
