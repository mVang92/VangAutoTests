package engineRev.logPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class AddServiceLogResetInputFieldsTest extends BasePage {
	
	private int year = 1997;
	private String date = getDate(0);
	private int mileage = 123456;
	private String make = "Lexus";
	private String model = "ES300";
	private String service = "Transmission Fluid Change";
	
	@BeforeClass
	private void setup() {
		doSignIn();
		addVehicle(year, make, model);
	}

	/**
	 * Verify the functionality of the reset button while adding a service log
	 */
	@Test
	private void addServiceLogResetInputFieldsTest() {
		selectVehicle(year, make, model);
		fillInputField(serviceLogDateInput, date, id);
		fillInputField(serviceLogMileageInput, mileage, id);
		fillInputField(serviceLogServiceInput, service, id);
		clickOnElement(addLogResetInputFieldsButton, id);
		assertEquals(getText(toastNotificationBody, xpath), resetFieldsSuccessMessage);
		assertEquals(getValue(serviceLogDateInput, id), "");
		assertEquals(getValue(serviceLogMileageInput, id), "");
		assertEquals(getValue(serviceLogServiceInput, id), "");
	}

	@AfterClass
	private void teardown() {
		deleteVehicle(year, make, model);
		close();
	}
}
