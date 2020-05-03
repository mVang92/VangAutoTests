package carSpace.MainPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddRemoveOneVehicleTest extends BaseClass {
	private String vehicleMake = "Toyota";
	private String vehicleModel = "Highlander";
	private int vehicleYear = 2003;
	private int actualVehicleCount;
	private int vehicleCount;

	@BeforeClass
	private void setup() {
		doSignIn();
	}

	/**
	 * Verify the user can add a vehicle, and the vehicle count reflects the addition
	 */
	@Test(priority = 0)
	private void addOneVehicleTest() {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		vehicleCount = Integer.parseInt(getText(accountPageVehicleCount, id));
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
		actualVehicleCount = Integer.parseInt(getText(accountPageVehicleCount, id));
		assertEquals(actualVehicleCount, (vehicleCount + 1));
		clickOnElement(backHomeBtn, xpath);
	}

	/**
	 * Verify the user can delete a vehicle, and the vehicle count reflects the deletion
	 */
	@Test(priority = 1, dependsOnMethods = "addOneVehicleTest")
	private void deleteOneVehicleTest() {
		String vehicle = vehicleYear + " " + vehicleMake + " " + vehicleModel;
		selectVehicle(vehicleYear, vehicleMake, vehicleModel);
		String actualVehicleName = getText(vehicleNameHeader, id);
		assertEquals(actualVehicleName, vehicle);
		clickOnElement(editVehicleNameButton, id);
		clickOnElement(addLogDeleteVehicleButton, id);
		String actualModalTitle = getText(deleteVehicleModalTitle, id);
		assertTrue(actualModalTitle.contains(vehicle));
		clickOnElement(confirmDeleteVehicleButton, id);
		String expectedMessage = vehicleDeletedSuccessfullyMessage;
		String toastNotificationMessage = getText(toastNotificationBody, xpath);
		assertTrue(toastNotificationMessage.contains(expectedMessage));
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		actualVehicleCount = Integer.parseInt(getText(accountPageVehicleCount, id));
		assertEquals(actualVehicleCount, vehicleCount);
		
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
