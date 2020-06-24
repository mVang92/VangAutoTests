package carSpace.MainPage;

import static org.testng.Assert.assertEquals;
import java.util.Calendar;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class AddVehicleBadInputTest extends BasePage {
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
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertEquals(actualMessage, addVehicleInputErrorMessage);
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
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertEquals(actualMessage, addVehicleInvalidYearMessage);
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
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertEquals(actualMessage, addVehicleInvalidYearMessage);
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
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertEquals(actualMessage, addVehicleInputErrorMessage);
	}
	
	/**
	 * Verify the user cannot add a vehicle if the year is three or more years in the future
	 */
	@Test(priority = 4)
	private void addVehicleThreeYearsInFutureTest() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int futureYear = year + 3;
		fillInputField(vehicleYearInput, futureYear, id);
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		clickOnElement(addVehicleButton, id);
		String actualMessage = getText(addVehicleErrorModal, xpath);
		assertEquals(actualMessage, addVehicleInvalidYearMessage);
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
