package carSpace.mainPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Random;
import basePage.BasePage;

public class AddRemoveOneVehicleTest extends BasePage {
	
	Random randon = new Random(); 
	private String accountNavButton = getProp("accountNavButton");
	private String vehicleMake = "Toyota";
	private int actualVehicleCount;
	private int vehicleCount;
	private String vehicleModels [] = {
			"Camry",
			"Corolla",
			"Hilux",
			"Kluger",
			"Land Cruiser",
			"Matrix",
			"Rav4",
			"Tacoma",
			"Tundra"
	};
	private int vehicleYears [] = {
			2000,
			2001,
			2002,
			2003,
			2004,
			2005,
			2006,
			2007,
			2008,
			2009,
			2010
	};
	private int vehicleYear = vehicleYears[randon.nextInt(vehicleYears.length)];
	private String vehicleModel = vehicleModels[randon.nextInt(vehicleModels.length)];
	private String vehicle = vehicleYear + " " + vehicleMake + " " + vehicleModel;

	@BeforeClass
	private void setup() {
		doSignIn();
	}

	/**
	 * Verify the user can add a vehicle, and the vehicle count reflects the addition
	 */
	@Test(priority = 0)
	private void addOneVehicleTest() {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		vehicleCount = Integer.parseInt(getText(accountPageVehicleCount, id));
		clickOnElement(backHomeBtn, xpath);
		fillInputField(vehicleYearInput, vehicleYear, id);
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		clickOnElement(addVehicleButton, id);
		assertEquals(getText(toastNotificationBody, xpath), "Added a " + vehicleYear + " " + vehicleMake + " " + vehicleModel + ".");
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
		selectVehicle(vehicleYear, vehicleMake, vehicleModel);
		assertEquals(getText(vehicleNameHeader, id), vehicle);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		actualVehicleCount = Integer.parseInt(getText(accountPageVehicleCount, id));
		assertEquals(actualVehicleCount, (vehicleCount + 1));
		clickOnElement(backHomeBtn, xpath);
	}

	/**
	 * Verify the user can delete a vehicle, and the vehicle count reflects the deletion
	 */
	@Test(priority = 1, dependsOnMethods = "addOneVehicleTest")
	private void deleteOneVehicleTest() {
		selectVehicle(vehicleYear, vehicleMake, vehicleModel);
		clickOnElement(editVehicleNameButton, id);
		clickOnElement(addLogDeleteVehicleButton, id);
		assertTrue(getText(deleteVehicleModalTitle, id).contains(vehicle));
		clickOnElement(confirmDeleteVehicleButton, id);
		assertEquals(getText(toastNotificationBody, xpath), vehicleDeletedSuccessfullyMessage);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		actualVehicleCount = Integer.parseInt(getText(accountPageVehicleCount, id));
		assertEquals(actualVehicleCount, vehicleCount);
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
