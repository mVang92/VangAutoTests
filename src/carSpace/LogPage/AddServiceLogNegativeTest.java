package carSpace.LogPage;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddServiceLogNegativeTest extends BaseClass {
	
	@BeforeClass
	private void setup() {
		doSignIn();
		addOneVehicle("2014", "Honda", "Accord");
	}
	
	/**
	 * Verify the functionality of the error message while trying to submit empty
	 * input fields when adding a service log
	 */
	@Test
	private void addServiceLogNegativeTest() {
		clickOnElement(vehicleOnRecord, xpath);
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
		deleteCurrentVehicle();
		close();
	}
}
