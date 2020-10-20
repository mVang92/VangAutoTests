package engineRev.mainPage;

import static org.testng.Assert.assertEquals;
import java.util.Random;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import basePage.BasePage;

public class AddVehicleTest extends BasePage {
	
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
	}
	
	/**
	 * Verify the user can add a vehicle, and the vehicle count reflects the addition in the Account page
	 */
	@Test
	private void addVehicleTest() {
		navigateToAccountPage();
		vehicleCount = Integer.parseInt(getText(accountPageVehicleCount, id));
		clickOnElement(backHomeBtn, xpath);
		fillInputField(vehicleYearInput, vehicleYear, id);
		fillInputField(vehicleMakeInput, vehicleMake, id);
		fillInputField(vehicleModelInput, vehicleModel, id);
		clickOnElement(addVehicleButton, id);
		assertEquals(getText(toastNotificationBody, xpath), String.format(getProp("addVehicleSuccessNotification"), vehicleYear, vehicleMake, vehicleModel));
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
		selectVehicle(vehicleYear, vehicleMake, vehicleModel);
		assertEquals(getText(vehicleNameHeader, id), vehicle);
		navigateToAccountPage();
		actualVehicleCount = Integer.parseInt(getText(accountPageVehicleCount, id));
		assertEquals(actualVehicleCount, (vehicleCount + 1));
		deleteVehicle(vehicleYear, vehicleMake, vehicleModel);
		navigateToAccountPage();
		actualVehicleCount = Integer.parseInt(getText(accountPageVehicleCount, id));
		assertEquals(actualVehicleCount, vehicleCount);
	}
	
	@AfterClass
	private void teardown() {
		close();
	}
}
