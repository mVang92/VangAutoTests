package carSpace.mainPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class AddVehicleResetInputFieldsTest extends BasePage {

	@BeforeClass
	private void setup() {
		doSignIn();
	}

	/**
	 * Verifies the functionality of the reset button while adding a vehicle
	 */
	@Test
	private void addVehicleResetInputFieldsTest() {
		String vehicleYearInput = getProp("vehicleYearInput");
		String vehicleMakeInput = getProp("vehicleMakeInput");
		String vehicleModelInput = getProp("vehicleModelInput");
		fillInputField(vehicleYearInput, 2003, id);
		fillInputField(vehicleMakeInput, "Toyota", id);
		fillInputField(vehicleModelInput, "Highlander", id);
		clickOnElement(getProp("resetVehicleInputFieldsButton"), id);
		assertEquals(getText(toastNotificationBody, xpath), resetFieldsSuccessMessage);
		assertEquals(getValue(vehicleYearInput, id), "");
		assertEquals(getValue(vehicleMakeInput, id), "");
		assertEquals(getValue(vehicleModelInput, id), "");
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
