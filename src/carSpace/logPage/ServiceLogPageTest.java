package carSpace.logPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class ServiceLogPageTest extends BasePage {
	private int year = 1997;
	private String make = "Lexus";
	private String model = "ES300";
	
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
	private void serviceLogPageTest() {
		int miles = 123456;
		String service = "Transmission Fluid Change";
		String addLogDeleteVehicleButton = getProp("addLogDeleteVehicleButton");
		String editVehicleNameButton = getProp("editVehicleNameButton");
		String addLogSortLogsButton = getProp("addLogSortLogsButton");
		String printPageButton = getProp("printPageButton");
		String printPageViaDeleteButton = getProp("printPageViaDeleteButton");
		String noButton = getProp("noButton");
		String topButton = getProp("topButton");
		selectVehicle(year, make, model);
		assertFalse(isButtonEnabled(addLogSortLogsButton, id));
		assertFalse(isButtonEnabled(printPageButton, id));
		assertFalse(isElementDisplayed(topButton, xpath));
		addServiceLog(getDate(-3), miles, service, "First Log");
		clickOnElement(editVehicleNameButton, id);
		clickOnElement(addLogDeleteVehicleButton, id);
		assertFalse(isElementDisplayed(printPageViaDeleteButton, id));
		clickOnElement(noButton, xpath);
		assertFalse(isButtonEnabled(addLogSortLogsButton, id));
		assertTrue(isButtonEnabled(printPageButton, id));
		assertFalse(isElementDisplayed(topButton, xpath));
		addServiceLog(getDate(-2), miles, service, "Second Log");
		clickOnElement(addLogSortLogsButton, id);
		clickOnElement(editVehicleNameButton, id);
		clickOnElement(addLogDeleteVehicleButton, id);
		assertTrue(isButtonEnabled(printPageViaDeleteButton, id));
		assertFalse(isElementDisplayed(topButton, xpath));
		clickOnElement(noButton, xpath);
		assertTrue(isButtonEnabled(addLogSortLogsButton, id));
		addServiceLog(getDate(-1), miles, service, "Third Log");
		clickOnElement(addLogSortLogsButton, id);
		assertTrue(isButtonEnabled(addLogSortLogsButton, id));
		assertTrue(isButtonEnabled(printPageButton, id));
		assertFalse(isElementDisplayed(topButton, xpath));
		addServiceLog(getDate(0), miles, service, "Top button is displayed.");
		clickOnElement(addLogSortLogsButton, id);
		assertTrue(isElementDisplayed(topButton, xpath));
	}
	
	@AfterClass
	private void teardown() {
		deleteVehicle(year, make, model);
		close();
	}
}
