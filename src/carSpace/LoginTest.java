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
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		maximizeWindow(driver);
		driver.get(carSpaceUrl);
		clickOnElementUsingId(driver, signIn);
		fillInputFieldUsingId(driver, emailTextInput, userEmail);
		fillInputFieldUsingId(driver, passwordTextInput, password);
		clickOnElementUsingId(driver, signInButton);
		Thread.sleep(1000);
		String expectedUserEmail = userEmail;
		String actualUserEmail = getTextUsingId(driver, userEmailDisplay);
		assertTrue(actualUserEmail.contains(expectedUserEmail));
		clickOnElementUsingId(driver, signOutButton);
		clickOnElementUsingId(driver, confirmSignOut);
		driver.close();
	}
}
