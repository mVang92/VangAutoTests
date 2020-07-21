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
	 * Verify the user can change their theme
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
	 * If if does not, wait for the text to change and try again until the
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
	
	/**
	 * Return the appropriate theme displayed to the user
	 * 
	 * @param theme The theme to check
	 * @return      The appropriate theme to display to the user
	 */
	private String displayTheme(Themes theme) {
		String displayedTheme = "";
		switch(theme) {
			case carSpace:
				displayedTheme = "CarSpace";
				break;
			case light:
				displayedTheme = "Light";
				break;
			case grey:
				displayedTheme = "Grey";
				break;
			case dark:
				displayedTheme = "Dark";
				break;
			case transparentLight:
				displayedTheme = "Transparent Light";
				break;
			case transparentGrey:
				displayedTheme = "Transparent Grey";
				break;
			case transparentDark:
				displayedTheme = "Transparent Dark";
				break;
		}
		return displayedTheme;
	}
}
