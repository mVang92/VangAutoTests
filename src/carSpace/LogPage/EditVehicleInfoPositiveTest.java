package carSpace.LogPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class EditVehicleInfoPositiveTest extends BasePage {
	private int year = 2014;
	private String make = "Honda";
	private String model = "Pilot";
	private int newYear = 1999;
	private String newMake = "Lexus";
	private String newModel = "ES 300";
	
	@BeforeClass
	private void setup() {
		doSignIn();
		addVehicle(year, make, model);
		selectVehicle(year, make, model);
	}
	
	@Test
	private void test() {
		assertEquals(getText(vehicleNameHeader, id), year + " " + make + " " + model);
		clickOnElement(editVehicleNameButton, id);
		fillInputField(vehicleYearInput, newYear, id);
		clickOnElement(confirmSaveEditVehicleNameButton, id);
		System.out.println(getText(vehicleNameHeader, id));
		assertEquals(getText(vehicleNameHeader, id), newYear + " " + make + " " + model);
	}

	@AfterClass
	private void teardown() {
		deleteVehicle(year, make, model);
		close();
	}

}
