package carSpace;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddVehicleBadInputTest extends BaseClass {
	String vehicleMake = "Toyota";
	String vehicleModel = "Highlander";
	
	@BeforeClass
	private void setup() throws InterruptedException {
		doSignIn();
	}

	/**
	 * Verify the functionality of the error message while trying to submit empty
	 * input fields when adding a vehicle
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 0)
	private void addVehicleBadInputTest() throws InterruptedException {
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		clickOnElement(addVehicleButton, id);
		String expectedMessage = addVehicleInputErrorMessage;
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(addVehicleErrorModalOkayButton, xpath);
	}

	/**
	 * Verify the functionality of the NaN error for the Year input
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1, dependsOnMethods = "addVehicleBadInputTest")
	private void addVehicleNanYearInputTest() throws InterruptedException {
		String nanVehicleYear = "nan";
		fillInputField(vehicleYearInput, nanVehicleYear, id);
		Thread.sleep(1000);
		clickOnElement(addVehicleButton, id);
		String expectedMessage = addVehicleInvalidYearMessage;
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(addVehicleErrorModalOkayButton, xpath);
	}
	
	/**
	 * Verify the user cannot add a vehicle if year is less than 1885
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	private void addVehicleBadYearInputTest() throws InterruptedException {
		String invalidVehicleYear = "1884";
		fillInputField(vehicleYearInput, invalidVehicleYear, id);
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		Thread.sleep(1000);
		clickOnElement(addVehicleButton, id);
		String expectedMessage = addVehicleInvalidYearMessage;
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(addVehicleErrorModalOkayButton, xpath);
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
