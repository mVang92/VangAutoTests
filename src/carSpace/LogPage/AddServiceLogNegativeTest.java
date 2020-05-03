package carSpace.LogPage;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddServiceLogNegativeTest extends BaseClass {
	private int year = 2014;
	private String make = "Honda";
	private String model = "Accord";
	
	@BeforeClass
	private void setup() {
		doSignIn();
		addVehicle(year, make, model);
	}
	
	/**
	 * Verify the functionality of the error message while trying to submit empty
	 * input fields when adding a service log
	 */
	@Test
	private void addServiceLogNegativeTest() {
		selectVehicle(year, make, model);
		fillInputField(serviceLogDateInput, "01012020", id);
		fillInputField(serviceLogServiceInput, "Transmission Fluid Change", id);
		clickOnElement(addServiceLogButton, id);
		String expectedMessage = addLogsMissingFieldsErrorMessage;
		String actualMessage = getText(addLogErrorModal, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(addLogErrorModalOkayButton, xpath);
	}
	
	@AfterClass
	private void teardown() {
		deleteVehicle(year, make, model);
		close();
	}
}
