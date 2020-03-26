package carSpace.LogPage;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddServiceLogBadInputTest extends BaseClass {
	
	@BeforeClass
	private void setup() throws InterruptedException {
		String vehicleYear = "2014";
		String vehicleMake = "Honda";
		String vehicleModel = "Accord";
		doSignIn();
		addOneVehicle(vehicleYear, vehicleMake, vehicleModel);
	}
	
	/**
	 * Verify the functionality of the error message while trying to submit empty
	 * input fields when adding a service log
	 */
	@Test
	private void addServiceLogBadInputTest() {
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
