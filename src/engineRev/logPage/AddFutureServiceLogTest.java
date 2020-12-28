package engineRev.logPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class AddFutureServiceLogTest extends BasePage {
	
	private int year = 1997;
	private String date = getDate(1);
	private int mileage = 123456;
	private String make = "Lexus";
	private String model = "ES300";
	private String service = "Transmission Fluid Change";

	@BeforeClass
	private void setup() {
		doSignIn();
		addVehicle(year, make, model);
	}
	
	@Test
	private void addFutureServiceLogCancelTest() {
		selectVehicle(year, make, model);
		fillInputField(serviceLogDateInput, date, id);
		fillInputField(serviceLogMileageInput, mileage, id);
		fillInputField(serviceLogServiceInput, service, id);
		clickOnElement(addServiceLogButton, id);
		assertEquals(getText(modalHeader, xpath), expectedFutureServiceLogModalTitle);
		clickOnElement(cancelSubmitFutureDateButton, id);
	}
	
	@Test(dependsOnMethods = "addFutureServiceLogCancelTest")
	private void addFutureServiceLogTest() {
		clickOnElement(addServiceLogButton, id);
		clickOnElement(confirmSubmitFutureDateButton, id);
		assertEquals(getText(toastNotificationBody, xpath), addLogSuccessMessage(service, mileage, date));
	}
	
	@AfterClass
	private void teardown() {
		deleteVehicle(year, make, model);
		close();
	}
}
