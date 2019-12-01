package carSpace;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class AddVehicleBadInputTest extends BaseClass {
	private String invalidVehicleYear = "nan";
	private String vehicleMake = "Toyota";
	private String vehicleModel = "Highlander";
	
	@Test
	private void addVehicleBadInputTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.id(signIn)).click();
		driver.findElement(By.id(emailTextInput)).sendKeys(userEmail);
		driver.findElement(By.id(passwordTextInput)).sendKeys(password);
		driver.findElement(By.id(signInButton)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(vehicleMakeInput)).sendKeys(vehicleMake);
		driver.findElement(By.id(vehicleModelInput)).sendKeys(vehicleModel);
		driver.findElement(By.id(addVehicleButton)).click();
		String expectedMessage = addVehicleInputErrorMessage;
		String actualMessage = driver.findElement(By.xpath(addVehicleErrorModal)).getText();
		assertTrue(actualMessage.contains(expectedMessage));
		driver.findElement(By.xpath(AddVehicleErrorModalOkayButton)).click();
		driver.findElement(By.id(vehicleYearInput)).sendKeys(invalidVehicleYear);
		Thread.sleep(1000);
		driver.findElement(By.id(addVehicleButton)).click();
		expectedMessage = addVehicleInvalidYearMessage;
		actualMessage = driver.findElement(By.xpath(addVehicleErrorModal)).getText();
		assertTrue(actualMessage.contains(expectedMessage));
		driver.findElement(By.xpath(AddVehicleErrorModalOkayButton)).click();
		driver.close();
	}
}
