package carSpace;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddRemoveOneVehicleTest extends BaseClass {
	private String vehicleYear = "2003";
	private String vehicleMake = "Toyota";
	private String vehicleModel = "Highlander";

	@BeforeClass
	private void setup() throws InterruptedException {
		doSignIn();
	}

	/**
	 * Add a vehicle to the user's record
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 0)
	private void addOneVehicleTest() throws InterruptedException {
		String vehicleCount = getText(vehicleCountForUser, id);
		fillInputField(vehicleYearInput, vehicleYear, id);
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		clickOnElement(addVehicleButton, id);
		Thread.sleep(1000);
		String expectedMessage = "Added a " + vehicleYear + " " + vehicleMake + " " + vehicleModel + ".";
		String toastNotificationMessage = getText(toastNotificationBody, xpath);
		assertTrue(toastNotificationMessage.contains(expectedMessage));
		int vehicleCountAfterAddingOneVehicle = Integer.parseInt(vehicleCount) + 1;
		vehicleCount = getText(vehicleCountForUser, id);
		Thread.sleep(500);
		assertTrue(vehicleCount.contains(Integer.toString(vehicleCountAfterAddingOneVehicle)));
	}

	/**
	 * Delete the vehicle from record
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1, dependsOnMethods = "addOneVehicleTest")
	private void deleteOneVehicleTest() throws InterruptedException {
		String vehicleCount = getText(vehicleCountForUser, id);
		String vehicleToDelete = getText(vehicleList, id);
		String actualVehicleToDelete = vehicleYear + " " + vehicleMake + " " + vehicleModel;
		if (vehicleToDelete.equals(actualVehicleToDelete)) {
			clickOnElement(vehicleList, id);
			clickOnElement(editVehicleNameButton, id);
			clickOnElement(addLogDeleteVehicleButton, id);
			clickOnElement(confirmDeleteVehicleButton, id);
			Thread.sleep(1000);
			String expectedMessage = vehicleDeletedSuccessfullyMessage;
			String toastNotificationMessage = getText(toastNotificationBody, xpath);
			assertTrue(toastNotificationMessage.contains(expectedMessage));
			int vehicleCountAfterDeletingOneVehicle = Integer.parseInt(vehicleCount) - 1;
			vehicleCount = getText(vehicleCountForUser, id);
			Thread.sleep(500);
			assertTrue(vehicleCount.contains(Integer.toString(vehicleCountAfterDeletingOneVehicle)));
		}
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
