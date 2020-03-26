package carSpace.MainPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddRemoveOneVehicleTest extends BaseClass {
	private String vehicleYear = "2003";
	private String vehicleMake = "Toyota";
	private String vehicleModel = "Highlander";
	private String actualVehicleCount = "";
	private int vehicleCount = 0;

	@BeforeClass
	private void setup() throws InterruptedException {
		doSignIn();
	}

	/**
	 * Verify the user can add a vehicle, and the vehicle count reflects the addition
	 */
	@Test(priority = 0)
	private void addOneVehicleTest() {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		actualVehicleCount = getText(accountPageVehicleCount, id);
		vehicleCount = Integer.parseInt(actualVehicleCount);
		clickOnElement(backHomeBtn, xpath);
		fillInputField(vehicleYearInput, vehicleYear, id);
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		clickOnElement(addVehicleButton, id);
		String expectedMessage = "Added a " + vehicleYear + " " + vehicleMake + " " + vehicleModel + ".";
		String toastNotificationMessage = getText(toastNotificationBody, xpath);
		assertTrue(toastNotificationMessage.contains(expectedMessage));
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		actualVehicleCount = getText(accountPageVehicleCount, id);
		assertEquals((vehicleCount + 1), Integer.parseInt(actualVehicleCount));
		clickOnElement(backHomeBtn, xpath);
	}

	/**
	 * Verify the user can delete a vehicle, and the vehicle count reflects the deletion
	 */
	@Test(priority = 1, dependsOnMethods = "addOneVehicleTest")
	private void deleteOneVehicleTest() {
		String vehicleToDelete = getText(vehicleOnRecord, xpath);
		String actualVehicleToDelete = vehicleYear + " " + vehicleMake + " " + vehicleModel;
		if (vehicleToDelete.equals(actualVehicleToDelete)) {
			clickOnElement(vehicleOnRecord, xpath);
			clickOnElement(editVehicleNameButton, id);
			clickOnElement(addLogDeleteVehicleButton, id);
			clickOnElement(confirmDeleteVehicleButton, id);
			String expectedMessage = vehicleDeletedSuccessfullyMessage;
			String toastNotificationMessage = getText(toastNotificationBody, xpath);
			assertTrue(toastNotificationMessage.contains(expectedMessage));
			clickOnElement(toastNotificationSuccessCloseButton, xpath);
			clickOnElement(menuDropdownButton, id);
			clickOnElement(accountNavButton, id);
			actualVehicleCount = getText(accountPageVehicleCount, id);
			assertEquals((vehicleCount), Integer.parseInt(actualVehicleCount));
		}
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
