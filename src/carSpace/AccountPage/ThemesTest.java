package carSpace.AccountPage;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;
import resources.Themes;

public class ThemesTest extends BasePage {
	private int themeDisplayCheckInterval = 0;

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
			assertTrue(isCorrectThemeDisplayedToUser(counter));
		}
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
	
	/**
	 * 
	 */
	private Boolean isCorrectThemeDisplayedToUser(int counter) {
		Boolean displayedTheme = false;
		System.out.println(getText(accountPageCurrentTheme, id));
		System.out.println(displayTheme(Themes.values()[counter]));
		if (getText(accountPageCurrentTheme, id).equals(displayTheme(Themes.values()[counter]))) {
			displayedTheme = true;
		} else {
			if (themeDisplayCheckInterval < 50) {
				themeDisplayCheckInterval++;
				System.out.println(themeDisplayCheckInterval);
				isCorrectThemeDisplayedToUser(counter);
			} else {
				displayedTheme = false;
			}
		}
		return displayedTheme;
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
