package carSpace;

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
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void addServiceLogBadInputTest() throws InterruptedException {
		String date = "01012020";
		String service = "Transmission Fluid Change";
		clickOnElement(vehicleList, xpath);
		fillInputField(serviceLogDateInput, date, id);
		fillInputField(serviceLogServiceInput, service, id);
		clickOnElement(addServiceLogButton, id);
		Thread.sleep(500);
		String expectedMessage = addLogsMissingFieldsErrorMessage;
		String actualMessage = getText(addLogErrorModal, xpath);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElement(AddLogErrorModalOkayButton, xpath);
		Thread.sleep(500);
	}
	
	@AfterClass(alwaysRun = true)
	private void teardown() {
		clickOnElement(editVehicleNameButton, id);
		clickOnElement(addLogDeleteVehicleButton, id);
		clickOnElement(confirmDeleteVehicleButton, id);
		close();
	}

}
