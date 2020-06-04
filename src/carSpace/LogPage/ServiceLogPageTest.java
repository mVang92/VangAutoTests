package carSpace.LogPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class ServiceLogPageTest extends BaseClass {
	private int miles = 123456;
	private int year = 1997;
	private String make = "Lexus";
	private String model = "ES300";
	private String service = "Transmission Fluid Change";
	
	@BeforeClass
	private void setup() {
		doSignIn();
		addVehicle(year, make, model);
	}
	
	/**
	 * Verify the Print and Sort Dates buttons display upon certain conditions
	 * based on the number of service logs
	 */
	@Test
	private void buttonsVerificationTest() {
		selectVehicle(year, make, model);
		assertFalse(isButtonEnabled(addLogSortLogsButton, id));
		assertFalse(isButtonEnabled(printPageButton, id));
		assertFalse(isElementDisplayed(topButton, xpath));
		addServiceLog("01012000", miles, service, "First Log");
		clickOnElement(editVehicleNameButton, id);
		clickOnElement(addLogDeleteVehicleButton, id);
		assertFalse(isElementDisplayed(printPageViaDeleteButton, id));
		clickOnElement(noButton, xpath);
		assertFalse(isButtonEnabled(addLogSortLogsButton, id));
		assertTrue(isButtonEnabled(printPageButton, id));
		assertFalse(isElementDisplayed(topButton, xpath));
		addServiceLog("05102000", miles, service, "Second Log");
		clickOnElement(addLogSortLogsButton, id);
		clickOnElement(editVehicleNameButton, id);
		clickOnElement(addLogDeleteVehicleButton, id);
		assertTrue(isButtonEnabled(printPageViaDeleteButton, id));
		assertFalse(isElementDisplayed(topButton, xpath));
		clickOnElement(noButton, xpath);
		assertTrue(isButtonEnabled(addLogSortLogsButton, id));
		addServiceLog("11132000", miles, service, "Third Log");
		clickOnElement(addLogSortLogsButton, id);
		assertTrue(isButtonEnabled(addLogSortLogsButton, id));
		assertTrue(isButtonEnabled(printPageButton, id));
		assertFalse(isElementDisplayed(topButton, xpath));
		addServiceLog("12102000", miles, service, "Top button is displayed.");
		clickOnElement(addLogSortLogsButton, id);
		assertTrue(isElementDisplayed(topButton, xpath));
	}
	
	@AfterClass
	private void teardown() {
		deleteVehicle(year, make, model);
		close();
	}
}
