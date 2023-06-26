package engineRev.logPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class VehicleNameTest extends BasePage {
	
	private int year = 2003;
	private String make = "Honda";
	private String model = "Pilot";
	private String customVehicleName = "Sigourney Weaver";

	@BeforeClass
	public void setup() {
		doSignIn();
		addVehicle(year, make, model);
	}
	
	/**
	 * Verify the vehicle name changes when the user adds the vehicle name
	 */
	@Test
	public void addVehicleNameTest() {
		selectVehicle(year, make, model);
		clickOnElement(editVehicleNameButton, id);
		fillInputField(vehicleNameInput, customVehicleName, id);
		clickOnElement(confirmSaveEditVehicleNameButton, id);
		assertEquals(getText(toastNotificationBody, xpath), expectedEditVehicleInfoSuccessMessage);
		clickOnElement(toastNotificationCloseButton, xpath);
		clickOnElement(applicationName, id);
		selectVehicle(customVehicleName);
		assertEquals(getText(vehicleNameHeader, id), customVehicleName);
		clickOnElement(editVehicleNameButton, id);
		assertEquals(getValue(vehicleNameInput, id), customVehicleName);
	}
	
	/**
	 * Verify the vehicle name header shows the year, make, and model when the user deletes the custom vehicle name
	 */
	@Test(dependsOnMethods = "addVehicleNameTest")
	public void deleteVehicleNameTest() {
		String defaultVehicleNameString = year + " " + make + " " + model;
		selectVehicle(customVehicleName);
		assertEquals(getText(vehicleNameHeader, id), customVehicleName);
		assertNotEquals(getText(vehicleNameHeader, id), defaultVehicleNameString);
		clickOnElement(editVehicleNameButton, id);
		clickOnElement(removeVehicleNameButton, id);
		assertEquals(getText(toastNotificationBody, xpath), expectedEditVehicleInfoSuccessMessage);
		clickOnElement(toastNotificationCloseButton, xpath);
		clickOnElement(applicationName, id);
		selectVehicle(year, make, model);
		assertEquals(getText(vehicleNameHeader, id), defaultVehicleNameString);
		clickOnElement(editVehicleNameButton, id);
		assertEquals(getValue(vehicleNameInput, id), "");
	}
	
	@AfterClass
	public void teardown() {
		deleteVehicle(year, make, model);
		close();
	}
}
