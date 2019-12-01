package carSpace;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class SignInSignUpVerificationTest extends BaseClass {
	
	/**
	 * This test ensures the email and password states reset for SignIn after attempting to SignUp with bad credentials
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void verifyReactStatesResetAfterClosingSignUpModal() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		maximizeWindow(driver);
        driver.get(URL);
        driver.findElement(By.id(signUp)).click();
        driver.findElement(By.id(emailTextInput)).sendKeys(userEmail);
        driver.findElement(By.id(signUpButton)).click();
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath(toastNotificationError)).isDisplayed());
        driver.findElement(By.id(closeSignUpModal)).click();
        driver.findElement(By.id(signIn)).click();
        driver.findElement(By.id(passwordTextInput)).sendKeys(password);
        driver.findElement(By.id(signInButton)).click();
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath(toastNotificationError)).isDisplayed());
        driver.close();
	}
}
