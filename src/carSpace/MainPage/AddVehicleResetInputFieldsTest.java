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
		String expectedMessage = resetFieldsSuccessMessage;
		String toastNotificationMessage = getText(toastNotificationBody, xpath);
		assertEquals(toastNotificationMessage, expectedMessage);
		String vehicleYearInputAfterReset = getValue(vehicleYearInput, id);
		String vehicleMakeInputAfterReset = getValue(vehicleMakeInput, id);
		String vehicleModelInputAfterReset = getValue(vehicleModelInput, id);
		assertEquals(vehicleYearInputAfterReset, "");
		assertEquals(vehicleMakeInputAfterReset, "");
		assertEquals(vehicleModelInputAfterReset, "");
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
