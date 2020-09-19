package carSpace.accountPage;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;
import resources.Themes;

public class ThemesTest extends BasePage {
	private int checkInterval = 0;
	private final int MAX_CHECK_INTERVAL = 30;

	@BeforeClass
	private void setup() {
		doSignIn();
	}
	
	/**
	 * Verify the user can change their theme and the Theme text displays the correct theme
	 */
	@Test
	private void themesTest() {
		clickOnElement(getProp("menuDropdownButton"), id);
		clickOnElement(getProp("accountNavButton"), id);
		for (Themes theme : Themes.values()) {
			selectThemeFromDropdown(theme);
			clickOnElement(getProp("applyThemeButton"), id);
			checkIfCorrectThemeIsDisplayed(theme);
		}
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
	
	/**
	 * Assert true if the theme text in the UI displays the expected theme.
	 * If it does not, wait for the text to change and try again until the check interval reaches max check intervals.
	 */
	private void checkIfCorrectThemeIsDisplayed(Themes theme) {
		if (getText(getProp("accountPageCurrentTheme"), id).equals(displayTheme(theme))) {
			assertTrue(true);
			checkInterval = 0;
		} else {
			if (checkInterval < MAX_CHECK_INTERVAL) {
				checkInterval++;
				checkIfCorrectThemeIsDisplayed(theme);
			} else {
				assertTrue(false);
			}
		}
	}
}
