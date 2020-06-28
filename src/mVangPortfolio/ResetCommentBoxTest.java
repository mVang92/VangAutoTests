package mVangPortfolio;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class ResetCommentBoxTest extends BasePage {

	/**
	 * Verify the functionality of the reset button in the comment box
	 */
	@Test
	private void resetCommentBoxTest() {
		setProperty();
		maximizeWindow();
		usePortfolioUrl();
		clickOnElement(contactNavButton, xpath);
		clickOnElement(portfolioResetButton, id);
		fillInputField(portfolioCommentInput, "This is a test comment from VangAutoTests.", id);
		clickOnElement(portfolioResetButton, id);
		assertEquals(getValue(portfolioCommentInput, id), "");
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
