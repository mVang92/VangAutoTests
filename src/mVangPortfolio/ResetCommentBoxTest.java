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
		String commentToInput = "This is a test comment from VangAutoTests.";
		setProperty();
		maximizeWindow();
		usePortfolioUrl();
		clickOnElement(contactNavButton, xpath);
		clickOnElement(portfolioResetButton, id);
		fillInputField(portfolioCommentInput, commentToInput, id);
		clickOnElement(portfolioResetButton, id);
		String commentBoxValueAfterReset = getValue(portfolioCommentInput, id);
		assertEquals(commentBoxValueAfterReset, "");
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
