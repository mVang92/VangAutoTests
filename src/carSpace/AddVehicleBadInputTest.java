package carSpace;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddVehicleBadInputTest extends BaseClass {
	
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
		String vehicleMake = "Toyota";
		String vehicleModel = "Highlander";
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		clickOnElement(addVehicleButton, id);
		String expectedMessage = addVehicleInputErrorMessage;
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(AddVehicleErrorModalOkayButton, xpath);
	}

	/**
	 * Verify the functionality of the NaN error for the Year input
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1, dependsOnMethods = "addVehicleBadInputTest")
	private void addVehicleBadYearInputTest() throws InterruptedException {
		String invalidVehicleYear = "nan";
		fillInputField(vehicleYearInput, invalidVehicleYear, id);
		Thread.sleep(1000);
		clickOnElement(addVehicleButton, id);
		String expectedMessage = addVehicleInvalidYearMessage;
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(AddVehicleErrorModalOkayButton, xpath);
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
