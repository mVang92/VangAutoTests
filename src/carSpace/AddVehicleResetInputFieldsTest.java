package carSpace;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddVehicleResetInputFieldsTest extends BaseClass {
	private String vehicleYear = "2003";
	private String vehicleMake = "Toyota";
	private String vehicleModel = "Highlander";

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
		fillInputField(vehicleYearInput, vehicleYear, id);
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		clickOnElement(resetVehicleInputFieldsButton, id);
		Thread.sleep(500);
		String expectedMessage = resetFieldsSuccessMessage;
		String toastNotificationMessage = getText(toastNotificationBody, xpath);
		assertTrue(toastNotificationMessage.contains(expectedMessage));
		String vehicleYearInputAfterReset = getText(vehicleYearInput, id);
		String vehicleMakeInputAfterReset = getText(vehicleMakeInput, id);
		String vehicleModelInputAfterReset = getText(vehicleModelInput, id);
		assertEquals(vehicleYearInputAfterReset, "");
		assertEquals(vehicleMakeInputAfterReset, "");
		assertEquals(vehicleModelInputAfterReset, "");
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
