package carSpace;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddVehicleResetInputFieldsTest extends BaseClass {
	private String vehicleYear = "2003";
	private String vehicleMake = "Toyota";
	private String vehicleModel = "Highlander";
	
	/**
	 * Verifies the functionality of the reset button while adding a vehicle
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void addVehicleResetInputFieldsTest() throws InterruptedException {
		setProperty();
		maximizeWindow();
		testCarSpace();
		doSignIn();
		fillInputFieldUsingId(vehicleYearInput, vehicleYear);
		fillInputFieldUsingId(vehicleMakeInput, vehicleMake);
		fillInputFieldUsingId(vehicleModelInput, vehicleModel);
		clickOnElementUsingId(resetVehicleInputFieldsButton);
		Thread.sleep(500);
		String expectedMessage = resetFieldsSuccessMessage;
		String toastNotificationMessage = getTextUsingXpath(toastNotificationBody);
		assertTrue(toastNotificationMessage.contains(expectedMessage));
		String vehicleYearInputAfterReset = getTextUsingId(vehicleYearInput);
		String vehicleMakeInputAfterReset = getTextUsingId(vehicleMakeInput);
		String vehicleModelInputAfterReset = getTextUsingId(vehicleModelInput);
		assertEquals(vehicleYearInputAfterReset, "");
		assertEquals(vehicleMakeInputAfterReset, "");
		assertEquals(vehicleModelInputAfterReset, "");
		close();
	}
}
