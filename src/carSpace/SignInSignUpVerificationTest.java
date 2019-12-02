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
		setProperty();
		WebDriver driver = new ChromeDriver();
		maximizeWindow(driver);
		driver.get(carSpaceUrl);
		clickOnElementUsingId(driver, signUp);
		fillInputFieldUsingId(driver, emailTextInput, email);
		clickOnElementUsingId(driver, signUpButton);
		Thread.sleep(1000);
		String expectedMessage = invalidPasswordErrorMessage;
		String actualMessage = getTextUsingXpath(driver, toastNotificationBody);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElementUsingXpath(driver, toastNotificationCloseButton);
		driver.findElement(By.id(closeSignUpModal)).click();
		driver.findElement(By.id(signIn)).click();
		driver.findElement(By.id(passwordTextInput)).sendKeys(password);
		driver.findElement(By.id(signInButton)).click();
		Thread.sleep(1000);
		expectedMessage = invalidEmailErrorMessage;
		actualMessage = getTextUsingXpath(driver, toastNotificationBody);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElementUsingXpath(driver, toastNotificationCloseButton);
		driver.close();
	}
}
