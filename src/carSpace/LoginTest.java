package carSpace;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class LoginTest extends BaseClass {
	
	/**
	 * Verify the sign-in capability and logs out
	 *
	 * @throws InterruptedException
	 */
	@Test
	private void signInTest() throws InterruptedException {
		setProperty();
		WebDriver driver = new ChromeDriver();
		maximizeWindow(driver);
		driver.get(carSpaceUrl);
		doSignIn(driver);
		String expectedUserEmail = email;
		String actualUserEmail = getTextUsingId(driver, userEmailDisplay);
		assertTrue(actualUserEmail.contains(expectedUserEmail));
		doSignOut(driver);
		driver.close();
	}
}
