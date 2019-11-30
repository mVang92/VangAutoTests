package carSpace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class LoginTest {
	BaseClass baseClass = new BaseClass();
	private String emailAddress = "sally@thing.com";
	private String password = "123123";
	
	/**
	 * This test verifies the sign-in capability and then logs the user out
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", baseClass.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://car-space.herokuapp.com/");
        driver.findElement(By.id(baseClass.signIn)).click();
        driver.findElement(By.id(baseClass.emailTextInput)).sendKeys(emailAddress);
        driver.findElement(By.id(baseClass.passwordTextInput)).sendKeys(password);
        driver.findElement(By.id(baseClass.signInButton)).click();
        Thread.sleep(1000);
        driver.findElement(By.id(baseClass.signOutButton)).click();
        driver.findElement(By.id(baseClass.confirmSignOut)).click();
        driver.close();
	}
}
