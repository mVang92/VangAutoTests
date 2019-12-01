package carSpace;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class AddRemoveOneVehicleTest extends BaseClass {
	private String vehicleYear = "2003";
	private String vehicleMake = "Toyota";
	private String vehicleModel = "Highlander";

	/**
	 * Add a vehicle to the user's record
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	private void addOneVehicleTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.id(signIn)).click();
		driver.findElement(By.id(emailTextInput)).sendKeys(userEmail);
		driver.findElement(By.id(passwordTextInput)).sendKeys(password);
		driver.findElement(By.id(signInButton)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(vehicleYearInput)).sendKeys(vehicleYear);
		driver.findElement(By.id(vehicleMakeInput)).sendKeys(vehicleMake);
		driver.findElement(By.id(vehicleModelInput)).sendKeys(vehicleModel);
		driver.findElement(By.id(addVehicleButton)).click();
		Thread.sleep(1000);
		String expectedMessage = "Added a " + vehicleYear + " " + vehicleMake + " " + vehicleModel + ".";
		String toastNotificationMessage = driver.findElement(By.xpath(toastNotificationSuccess)).getText();
		assertTrue(toastNotificationMessage.contains(expectedMessage));
		driver.close();
	}

	/**
	 * Delete the vehicle from record
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	private void deleteOneVehicleTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.id(signIn)).click();
		driver.findElement(By.id(emailTextInput)).sendKeys(userEmail);
		driver.findElement(By.id(passwordTextInput)).sendKeys(password);
		driver.findElement(By.id(signInButton)).click();
		Thread.sleep(1000);
		String vehicleToDelete = driver.findElement(By.xpath(vehicleList)).getText();
		String actualVehicleToDelete = vehicleYear + " " + vehicleMake + " " + vehicleModel;
		if (vehicleToDelete.equals(actualVehicleToDelete)) {
			driver.findElement(By.xpath(vehicleList)).click();
			driver.findElement(By.xpath(deleteVehicleButton)).click();
			driver.findElement(By.id(confirmDeleteVehicleButton)).click();
		}
		Thread.sleep(1000);
		String expectedMessage = "Vehicle Deleted Successfully";
		String toastNotificationMessage = driver.findElement(By.xpath(toastNotificationSuccess)).getText();
		driver.findElement(By.xpath(toastNotificationSuccess)).getText();
		assertTrue(toastNotificationMessage.contains(expectedMessage));
		driver.close();
	}
}
