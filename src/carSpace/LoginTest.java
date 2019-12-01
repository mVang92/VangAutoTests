package carSpace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class LoginTest extends BaseClass {
	
	/**
	 * This test verifies the sign-in capability and then logs the user out
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void signInTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		maximizeWindow(driver);
        driver.get(URL);
        clickOnElementUsingId(driver, signIn);
        fillInputFieldUsingId(driver, emailTextInput, userEmail);
        fillInputFieldUsingId(driver, passwordTextInput, password);
        clickOnElementUsingId(driver, signInButton);
        Thread.sleep(1000);
        clickOnElementUsingId(driver, signOutButton);
        clickOnElementUsingId(driver, confirmSignOut);
        driver.close();
	}
}
