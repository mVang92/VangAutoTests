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
		setProperty();
		WebDriver driver = new ChromeDriver();
		maximizeWindow(driver);
		driver.get(carSpaceUrl);
		doSignIn(driver);
		String vehicleCount = getTextUsingId(driver, vehicleCountForUser);
		fillInputFieldUsingId(driver, vehicleYearInput, vehicleYear);
		fillInputFieldUsingId(driver, vehicleMakeInput, vehicleMake);
		fillInputFieldUsingId(driver, vehicleModelInput, vehicleModel);
		clickOnElementUsingId(driver, addVehicleButton);
		Thread.sleep(500);
		String expectedMessage = "Added a " + vehicleYear + " " + vehicleMake + " " + vehicleModel + ".";
		String toastNotificationMessage = getTextUsingXpath(driver, toastNotificationBody);
		assertTrue(toastNotificationMessage.contains(expectedMessage));
		int vehicleCountAfterAddingOneVehicle = Integer.parseInt(vehicleCount) + 1;
		vehicleCount = getTextUsingId(driver, vehicleCountForUser);
		Thread.sleep(500);
		assertTrue(vehicleCount.contains(Integer.toString(vehicleCountAfterAddingOneVehicle)));
		driver.close();
	}

	/**
	 * Delete the vehicle from record
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	private void deleteOneVehicleTest() throws InterruptedException {
		setProperty();
		WebDriver driver = new ChromeDriver();
		maximizeWindow(driver);
		driver.get(carSpaceUrl);
		doSignIn(driver);
		String vehicleCount = getTextUsingId(driver, vehicleCountForUser);
		String vehicleToDelete = getTextUsingXpath(driver, vehicleList);
		String actualVehicleToDelete = vehicleYear + " " + vehicleMake + " " + vehicleModel;
		if (vehicleToDelete.equals(actualVehicleToDelete)) {
			clickOnElementUsingXpath(driver, vehicleList);
			clickOnElementUsingXpath(driver, deleteVehicleButton);
			clickOnElementUsingId(driver, confirmDeleteVehicleButton);
			Thread.sleep(500);
			String expectedMessage = vehicleDeletedSuccessfullyMessage;
			String toastNotificationMessage = getTextUsingXpath(driver, toastNotificationBody);
			assertTrue(toastNotificationMessage.contains(expectedMessage));
			int vehicleCountAfterDeletingOneVehicle = Integer.parseInt(vehicleCount) - 1;
			vehicleCount = getTextUsingId(driver, vehicleCountForUser);
			Thread.sleep(500);
			assertTrue(vehicleCount.contains(Integer.toString(vehicleCountAfterDeletingOneVehicle)));
		}
		driver.close();
	}
}
