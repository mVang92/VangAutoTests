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
		String vehicleCount = getTextUsingId(vehicleCountForUser);
		fillInputFieldUsingId(vehicleYearInput, vehicleYear);
		fillInputFieldUsingId(vehicleMakeInput, vehicleMake);
		fillInputFieldUsingId(vehicleModelInput, vehicleModel);
		clickOnElementUsingId(addVehicleButton);
		Thread.sleep(500);
		String expectedMessage = "Added a " + vehicleYear + " " + vehicleMake + " " + vehicleModel + ".";
		String toastNotificationMessage = getTextUsingXpath(toastNotificationBody);
		assertTrue(toastNotificationMessage.contains(expectedMessage));
		int vehicleCountAfterAddingOneVehicle = Integer.parseInt(vehicleCount) + 1;
		vehicleCount = getTextUsingId(vehicleCountForUser);
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
		String vehicleCount = getTextUsingId(vehicleCountForUser);
		String vehicleToDelete = getTextUsingXpath(vehicleList);
		String actualVehicleToDelete = vehicleYear + " " + vehicleMake + " " + vehicleModel;
		if (vehicleToDelete.equals(actualVehicleToDelete)) {
			clickOnElementUsingXpath(vehicleList);
			clickOnElementUsingXpath(deleteVehicleButton);
			clickOnElementUsingId(confirmDeleteVehicleButton);
			Thread.sleep(500);
			String expectedMessage = vehicleDeletedSuccessfullyMessage;
			String toastNotificationMessage = getTextUsingXpath(toastNotificationBody);
			assertTrue(toastNotificationMessage.contains(expectedMessage));
			int vehicleCountAfterDeletingOneVehicle = Integer.parseInt(vehicleCount) - 1;
			vehicleCount = getTextUsingId(vehicleCountForUser);
			Thread.sleep(500);
			assertTrue(vehicleCount.contains(Integer.toString(vehicleCountAfterDeletingOneVehicle)));
		}
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
