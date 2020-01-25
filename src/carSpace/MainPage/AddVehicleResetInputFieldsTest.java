package carSpace.MainPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddVehicleResetInputFieldsTest extends BaseClass {

	@BeforeClass
	private void setup() throws InterruptedException {
		doSignIn();
	}

	/**
	 * Verifies the functionality of the reset button while adding a vehicle
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void addVehicleResetInputFieldsTest() throws InterruptedException {
		String vehicleYear = "2003";
		String vehicleMake = "Toyota";
		String vehicleModel = "Highlander";
		fillInputField(vehicleYearInput, vehicleYear, id);
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		clickOnElement(resetVehicleInputFieldsButton, id);
		Thread.sleep(500);
		String expectedMessage = resetFieldsSuccessMessage;
		String toastNotificationMessage = getText(toastNotificationBody, xpath);
		assertTrue(toastNotificationMessage.contains(expectedMessage));
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
