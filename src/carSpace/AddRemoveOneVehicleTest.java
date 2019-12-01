package carSpace;

import static org.testng.Assert.assertTrue;

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
		maximizeWindow(driver);
		driver.get(carSpaceUrl);
		clickOnElementUsingId(driver, signIn);
		fillInputFieldUsingId(driver, emailTextInput, userEmail);
        fillInputFieldUsingId(driver, passwordTextInput, password);
        clickOnElementUsingId(driver, signInButton);
		Thread.sleep(1000);
		fillInputFieldUsingId(driver, vehicleYearInput, vehicleYear);
		fillInputFieldUsingId(driver, vehicleMakeInput, vehicleMake);
		fillInputFieldUsingId(driver, vehicleModelInput, vehicleModel);
		clickOnElementUsingId(driver, addVehicleButton);
		Thread.sleep(1000);
		String expectedMessage = "Added a " + vehicleYear + " " + vehicleMake + " " + vehicleModel + ".";
		String toastNotificationMessage = getTextUsingXpath(driver, toastNotificationBody);
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
		maximizeWindow(driver);
		driver.get(carSpaceUrl);
		clickOnElementUsingId(driver, signIn);
		fillInputFieldUsingId(driver, emailTextInput, userEmail);
        fillInputFieldUsingId(driver, passwordTextInput, password);
        clickOnElementUsingId(driver, signInButton);
		Thread.sleep(1000);
		String vehicleToDelete = getTextUsingXpath(driver, vehicleList);
		String actualVehicleToDelete = vehicleYear + " " + vehicleMake + " " + vehicleModel;
		if (vehicleToDelete.equals(actualVehicleToDelete)) {
			clickOnElementUsingXpath(driver, vehicleList);
			clickOnElementUsingXpath(driver, deleteVehicleButton);
			clickOnElementUsingId(driver, confirmDeleteVehicleButton);
		}
		Thread.sleep(1000);
		String expectedMessage = "Vehicle Deleted Successfully";
		String toastNotificationMessage = getTextUsingXpath(driver, toastNotificationBody);
		assertTrue(toastNotificationMessage.contains(expectedMessage));
		driver.close();
	}
}
