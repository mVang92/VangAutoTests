package mVangPortfolio;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class ResetCommentBoxTest extends BaseClass {

	/**
	 * Verify the functionality of the reset button in the comment box
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void resetCommentBoxTest() throws InterruptedException {
		String commentToInput = "This is a test comment from VangAutoTests.";
		setProperty();
		maximizeWindow();
		usePortfolioUrl();
		clickOnElement(contactNavButton, xpath);
		Thread.sleep(1000);
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
