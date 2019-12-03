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
		fillInputFieldUsingId(vehicleYearInput, vehicleYear);
		fillInputFieldUsingId(vehicleMakeInput, vehicleMake);
		fillInputFieldUsingId(vehicleModelInput, vehicleModel);
		clickOnElementUsingId(resetVehicleInputFieldsButton);
		Thread.sleep(500);
		String expectedMessage = resetFieldsSuccessMessage;
		String toastNotificationMessage = getTextUsingXpath(toastNotificationBody);
		assertTrue(toastNotificationMessage.contains(expectedMessage));
		String vehicleYearInputAfterReset = getTextUsingId(vehicleYearInput);
		String vehicleMakeInputAfterReset = getTextUsingId(vehicleMakeInput);
		String vehicleModelInputAfterReset = getTextUsingId(vehicleModelInput);
		assertEquals(vehicleYearInputAfterReset, "");
		assertEquals(vehicleMakeInputAfterReset, "");
		assertEquals(vehicleModelInputAfterReset, "");
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
