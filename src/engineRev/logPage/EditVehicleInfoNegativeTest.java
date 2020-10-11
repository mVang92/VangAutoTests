package engineRev.logPage;

import static org.testng.Assert.assertEquals;
import java.util.Calendar;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class EditVehicleInfoNegativeTest extends BasePage {
	
	private int year = 2014;
	private String make = "Honda";
	private String model = "Pilot";
	
	@BeforeClass
	public void setup() {
		doSignIn();
		addVehicle(year, make, model);
	}
	
	/**
	 * Verify the vehicle information does not change when the user submits missing input values
	 */
	@Test(priority = 0)
	public void editVehicleMissingInputTest() {
		String missingInput = "";
		selectVehicle(year, make, model);
		clickOnElement(editVehicleNameButton, id);
		fillInputField(vehicleMakeInput, missingInput, id);
		fillInputField(vehicleModelInput, missingInput, id);
		clickOnElement(confirmSaveEditVehicleNameButton, id);
		assertEquals(getText(toastNotificationBody, xpath), expectedEditVehicleInfoSuccessMessage);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
	}
	
	/**
	 * Verify the vehicle information does not change when the user enters empty input values
	 */
	@Test(priority = 1)
	public void editVehicleEmptyInputTest() {
		String emptyInput = "   ";
		selectVehicle(year, make, model);
		clickOnElement(editVehicleNameButton, id);
		fillInputField(vehicleYearInput, emptyInput, id);
		fillInputField(vehicleMakeInput, emptyInput, id);
		clickOnElement(confirmSaveEditVehicleNameButton, id);
		assertEquals(getText(toastNotificationBody, xpath), expectedEditVehicleInfoSuccessMessage);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
	}
	
	/**
	 * Verify the vehicle year does not change when the user enters a year before 1885
	 */
	@Test(priority = 2)
	public void editVehicleBadYearInputTest() {
		selectVehicle(year, make, model);
		clickOnElement(editVehicleNameButton, id);
		fillInputField(vehicleYearInput, 1884, id);
		clickOnElement(confirmSaveEditVehicleNameButton, id);
		assertEquals(getText(toastNotificationBody, xpath), expectedEditVehicleInfoSuccessMessage);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
	}
	
	/**
	 * Verify the error modal appears when entering a non-numerical value in the year input
	 */
	@Test(priority = 3)
	public void editVehicleNanYearInputTest() {
		selectVehicle(year, make, model);
		clickOnElement(editVehicleNameButton, id);
		fillInputField(vehicleYearInput, "nan", id);
		clickOnElement(confirmSaveEditVehicleNameButton, id);
		assertEquals(getText(addVehicleErrorModal, xpath), addVehicleInvalidYearMessage);
		clickOnElement(addVehicleErrorModalOkayButton, xpath);
		clickOnElement(cancelButton, xpath);
	}
	
	/**
	 * Verify the vehicle year does not change when the user enters a value that is three years into the future
	 */
	@Test(priority = 4)
	public void editVehicleThreeYearsInFutureTest() {
		int futureYear = Calendar.getInstance().get(Calendar.YEAR) + 3;
		selectVehicle(year, make, model);
		clickOnElement(editVehicleNameButton, id);
		fillInputField(vehicleYearInput, futureYear, id);
		clickOnElement(confirmSaveEditVehicleNameButton, id);
		assertEquals(getText(toastNotificationBody, xpath), expectedEditVehicleInfoSuccessMessage);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
	}
	
	@AfterMethod
	public void saveAndCheckVehicleInfo() {
		clickOnElement(applicationName, id);
		selectVehicle(year, make, model);
		assertEquals(getText(vehicleNameHeader, id), year + " " + make + " " + model);
		clickOnElement(applicationName, id);
	}

	@AfterClass
	public void teardown() {
		deleteVehicle(year, make, model);
		close();
	}
}
