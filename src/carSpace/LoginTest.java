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
	
	@Test
	private void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", baseClass.chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
        driver.get("https://car-space.herokuapp.com/");
        driver.findElement(By.xpath(baseClass.signIn)).click();
        driver.findElement(By.xpath(baseClass.emailTextInput)).sendKeys(emailAddress);
        driver.findElement(By.xpath(baseClass.passwordTextInput)).sendKeys(password);
        driver.findElement(By.xpath(baseClass.signInButton)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(baseClass.signOutButton)).click();
        driver.findElement(By.xpath(baseClass.confirmSignOut)).click();
        driver.close();
	}
}
