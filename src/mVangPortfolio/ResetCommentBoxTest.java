package mVangPortfolio;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class ResetCommentBoxTest extends BasePage {
	
	@BeforeClass
	private void setup() {
		doPortfolioTest();
	}

	/**
	 * Verify the functionality of the reset button in the comment box
	 */
	@Test
	private void resetCommentBoxTest() {
		String portfolioCommentInput = getProp("portfolioCommentInput");
		String resetButton = getProp("resetButton");
		clickOnElement(getProp("contactNavButton"), xpath);
		clickOnElement(resetButton, id);
		fillInputField(portfolioCommentInput, "This is a test comment from VangAutoTests.", id);
		clickOnElement(resetButton, id);
		assertEquals(getValue(portfolioCommentInput, id), "");
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
