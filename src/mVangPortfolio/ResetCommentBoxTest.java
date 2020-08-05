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
