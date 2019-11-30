package carSpace;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class AuthenticationSignInSignUpBugFixVerificationTest {
	BaseClass baseClass = new BaseClass();
	private String emailAddress = "sally@thing.com";
	private String password = "123123";
	
	/**
	 * This test ensures the email and password states reset for SignIn after attempting to SignUp with bad credentials
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", baseClass.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://car-space.herokuapp.com/");
        driver.findElement(By.id(baseClass.signUp)).click();
        driver.findElement(By.id(baseClass.emailTextInput)).sendKeys(emailAddress);
        driver.findElement(By.id(baseClass.signUpButton)).click();
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath(baseClass.toastNotificationError)).isDisplayed());
        driver.findElement(By.id(baseClass.closeSignUpModal)).click();
        driver.findElement(By.id(baseClass.signIn)).click();
        driver.findElement(By.id(baseClass.passwordTextInput)).sendKeys(password);
        driver.findElement(By.id(baseClass.signInButton)).click();
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.xpath(baseClass.toastNotificationError)).isDisplayed());
        driver.close();
	}
}
