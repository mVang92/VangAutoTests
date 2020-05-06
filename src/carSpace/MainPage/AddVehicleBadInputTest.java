package carSpace.MainPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddVehicleBadInputTest extends BaseClass {
	String vehicleMake = "Toyota";
	String vehicleModel = "Highlander";
	
	@BeforeClass
	private void setup() {
		doSignIn();
	}

	/**
	 * Verify the functionality of the error message while trying to submit empty
	 * input fields when adding a vehicle
	 */
	@Test(priority = 0)
	private void addVehicleMissingInputTest() {
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		clickOnElement(addVehicleButton, id);
		String expectedMessage = addVehicleInputErrorMessage;
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertEquals(actualMessage, expectedMessage);
	}

	/**
	 * Verify the functionality of the NaN error for the Year input
	 */
	@Test(priority = 1)
	private void addVehicleNanYearInputTest() {
		String nanVehicleYear = "nan";
		fillInputField(vehicleYearInput, nanVehicleYear, id);
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		clickOnElement(addVehicleButton, id);
		String expectedMessage = addVehicleInvalidYearMessage;
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertEquals(actualMessage, expectedMessage);
	}
	
	/**
	 * Verify the user cannot add a vehicle before 1885
	 */
	@Test(priority = 2)
	private void addVehicleBadYearInputTest() {
		int invalidVehicleYear = 1884;
		fillInputField(vehicleYearInput, invalidVehicleYear, id);
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		clickOnElement(addVehicleButton, id);
		String expectedMessage = addVehicleInvalidYearMessage;
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertEquals(actualMessage, expectedMessage);
	}
	
	/**
	 * Verify the user cannot add a vehicle if the make and model inputs contain only spaces
	 */
	@Test(priority = 3)
	private void addVehicleEmptyInputTest() {
		String inputWithSpaces = "     ";
		fillInputField(vehicleYearInput, 2000, id);
		fillInputField(vehicleMakeInput, inputWithSpaces, id);
		fillInputField(vehicleModelInput, inputWithSpaces, id);
		clickOnElement(addVehicleButton, id);
		String expectedMessage = addVehicleInputErrorMessage;
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertEquals(actualMessage, expectedMessage);
	}
	
	@AfterMethod
	private void resetVehicleInputFields() {
		clickOnElement(addVehicleErrorModalOkayButton, xpath);
		clickOnElement(resetVehicleInputFieldsButton, id);
	}

	@AfterClass(alwaysRun = true)
	private void teardown() {
		close();
	}
}
