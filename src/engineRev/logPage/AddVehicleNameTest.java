package engineRev.logPage;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class AddVehicleNameTest extends BasePage {
	
	private int year = 2003;
	private String make = "Honda";
	private String model = "Pilot";
	private String vehicleName = "Sigourney Weaver";

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
		fillInputField(vehicleNameInput, vehicleName, id);
		clickOnElement(confirmSaveEditVehicleNameButton, id);
		assertEquals(getText(toastNotificationBody, xpath), expectedEditVehicleInfoSuccessMessage);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
		clickOnElement(applicationName, id);
		selectVehicle(year, make, model);
		assertEquals(getText(vehicleNameHeader, id), vehicleName);
		clickOnElement(editVehicleNameButton, id);
		assertEquals(getValue(vehicleNameInput, id), vehicleName);
	}
	
	@AfterClass
	public void teardown() {
		deleteVehicle(year, make, model);
		close();
	}
}
