package carSpace.MainPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddVehicleResetInputFieldsTest extends BaseClass {

	@BeforeClass
	private void setup() {
		doSignIn();
	}

	/**
	 * Verifies the functionality of the reset button while adding a vehicle
	 */
	@Test
	private void addVehicleResetInputFieldsTest() {
		fillInputField(vehicleYearInput, 2003, id);
		fillInputField(vehicleMakeInput, "Toyota", id);
		fillInputField(vehicleModelInput, "Highlander", id);
		clickOnElement(resetVehicleInputFieldsButton, id);
		assertEquals(getText(toastNotificationBody, xpath), resetFieldsSuccessMessage);
		assertEquals(getValue(vehicleYearInput, id), "");
		assertEquals(getValue(vehicleMakeInput, id), "");
		assertEquals(getValue(vehicleModelInput, id), "");
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
	
}
