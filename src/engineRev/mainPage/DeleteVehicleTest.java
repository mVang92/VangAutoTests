package engineRev.mainPage;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Random;
import basePage.BasePage;

public class DeleteVehicleTest extends BasePage {
	
	Random random = new Random();
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
	private int vehicleYear = random.nextInt(2010 - 2000 + 1) + 2000;
	private String vehicleModel = vehicleModels[random.nextInt(vehicleModels.length)];
	private String vehicle = vehicleYear + " " + vehicleMake + " " + vehicleModel;

	@BeforeClass
	private void setup() {
		doSignIn();
		addVehicle(vehicleYear, vehicleMake, vehicleModel);
		navigateToAccountPage();
		vehicleCount = Integer.parseInt(getText(accountPageVehicleCount, id));
	}

	/**
	 * Verify the user can delete a vehicle, and the vehicle count reflects the deletion in the Account page
	 */
	@Test
	private void deleteVehicleTest() {
		selectVehicle(vehicleYear, vehicleMake, vehicleModel);
		clickOnElement(editVehicleNameButton, id);
		clickOnElement(addLogDeleteVehicleButton, id);
		assertTrue(getText(deleteVehicleModalTitle, id).contains(vehicle));
		clickOnElement(confirmDeleteVehicleButton, id);
		assertEquals(getText(toastNotificationBody, xpath), vehicleDeletedSuccessfullyMessage);
		clickOnElement(toastNotificationCloseButton, xpath);
		navigateToAccountPage();
		actualVehicleCount = Integer.parseInt(getText(accountPageVehicleCount, id));
		assertEquals(actualVehicleCount, (vehicleCount - 1));
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
