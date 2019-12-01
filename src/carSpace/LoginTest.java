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
		driver.manage().window().maximize();
        driver.get(URL);
        driver.findElement(By.id(signIn)).click();
        driver.findElement(By.id(emailTextInput)).sendKeys(userEmail);
        driver.findElement(By.id(passwordTextInput)).sendKeys(password);
        driver.findElement(By.id(signInButton)).click();
        Thread.sleep(1000);
        driver.findElement(By.id(signOutButton)).click();
        driver.findElement(By.id(confirmSignOut)).click();
        driver.close();
	}
}
