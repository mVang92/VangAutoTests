package carSpace.AccountPage;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;
import resources.Themes;

public class ThemesTest extends BasePage {
	private int checkInterval = 0;
	private final int MAX_CHECK_INTERVAL = 15;

	@BeforeClass
	private void setup() {
		doSignIn();
	}
	
	/**
	 * Verify the user can change their theme and the Theme text displays the correct theme
	 */
	@Test
	private void themesTest() {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		for (int counter = 0; counter < Themes.values().length; counter++) {
			selectThemeFromDropdown(Themes.values()[counter]);
			clickOnElement(applyThemeButton, id);
			checkIfCorrectThemeIsDisplayed(counter);
		}
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
	
	/**
	 * Assert true if the theme text in the UI displays the expected theme.
	 * If if does not, wait for the text to change and try again until the check interval reaches max check intervals.
	 */
	private void checkIfCorrectThemeIsDisplayed(int counter) {
		if (getText(accountPageCurrentTheme, id).equals(displayTheme(Themes.values()[counter]))) {
			assertTrue(true);
			checkInterval = 0;
		} else {
			if (checkInterval < MAX_CHECK_INTERVAL) {
				checkInterval++;
				checkIfCorrectThemeIsDisplayed(counter);
			} else {
				assertTrue(false);
			}
		}
	}
}
