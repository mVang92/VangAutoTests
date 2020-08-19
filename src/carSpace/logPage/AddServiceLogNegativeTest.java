package carSpace.logPage;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class AddServiceLogNegativeTest extends BasePage {
	private int year = 2014;
	private String make = "Honda";
	private String model = "Accord";
	private String date = "01012020";
	private String service = "Transmission Fluid Change";
	
	@BeforeClass
	private void setup() {
		doSignIn();
		addVehicle(year, make, model);
		selectVehicle(year, make, model);
	}
	
	/**
	 * Verify the error message when trying to submit an empty input field
	 */
	@Test(priority = 0)
	private void missingInputFieldsTest() {
		fillInputField(serviceLogDateInput, date, id);
		fillInputField(serviceLogServiceInput, service, id);
		clickOnElement(addServiceLogButton, id);
		assertTrue(getText(addLogErrorModal, xpath).contains(addLogsMissingFieldsErrorMessage));
	}
	
	/**
	 * Verify the user cannot add a service log if the mileage and service inputs contain only spaces
	 */
	@Test(priority = 1)
	private void emptyInputFieldsTest() {
		String inputWithSpaces = "     ";
		fillInputField(serviceLogDateInput, date, id);
		fillInputField(serviceLogMileageInput, inputWithSpaces, id);
		fillInputField(serviceLogServiceInput, inputWithSpaces, id);
		clickOnElement(addServiceLogButton, id);
		assertTrue(getText(addLogErrorModal, xpath).contains(addLogsMissingFieldsErrorMessage));
	}
	
	/**
	 * Verify the error message when adding an invalid mileage input
	 */
	@Test(priority = 2)
	private void invalidMileageInputTest() {
		String invalidMileage = "nan";
		fillInputField(serviceLogDateInput, date, id);
		fillInputField(serviceLogMileageInput, invalidMileage, id);
		fillInputField(serviceLogServiceInput, service, id);
		clickOnElement(addServiceLogButton, id);
		assertTrue(getText(addLogErrorModal, xpath).contains(invalidMileage + " is not a valid input for Mileage."));
	}
	
	@AfterMethod
	private void resetVehicleInputFields() {
		clickOnElement(addLogErrorModalOkayButton, xpath);
		clickOnElement(addLogResetInputFieldsButton, id);
	}
	
	@AfterClass
	private void teardown() {
		deleteVehicle(year, make, model);
		close();
	}
}
