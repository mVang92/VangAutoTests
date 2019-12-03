package carSpace;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddVehicleBadInputTest extends BaseClass {
	private String invalidVehicleYear = "nan";
	private String vehicleMake = "Toyota";
	private String vehicleModel = "Highlander";

	@BeforeClass
	private void setup() throws InterruptedException {
		doSignIn();
	}

	/**
	 * Verify the functionality of the error message while trying to submit empty
	 * input fields
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 0)
	private void addVehicleBadInputTest() throws InterruptedException {
		fillInputFieldUsingId(vehicleMakeInput, vehicleMake);
		fillInputFieldUsingId(vehicleModelInput, vehicleModel);
		clickOnElementUsingId(addVehicleButton);
		String expectedMessage = addVehicleInputErrorMessage;
		String actualMessage = getTextUsingXpath(addVehicleErrorModal);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElementUsingXpath(AddVehicleErrorModalOkayButton);
	}

	/**
	 * Verify the functionality of the NaN error for the Year input
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1)
	private void addVehicleBadYearInputTest() throws InterruptedException {
		fillInputFieldUsingId(vehicleYearInput, invalidVehicleYear);
		Thread.sleep(1000);
		clickOnElementUsingId(addVehicleButton);
		String expectedMessage = addVehicleInvalidYearMessage;
		String actualMessage = getTextUsingXpath(addVehicleErrorModal);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElementUsingXpath(AddVehicleErrorModalOkayButton);
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
