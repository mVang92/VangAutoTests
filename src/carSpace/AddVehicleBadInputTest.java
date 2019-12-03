package carSpace;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import baseClass.BaseClass;

public class AddVehicleBadInputTest extends BaseClass {
	private String invalidVehicleYear = "nan";
	private String vehicleMake = "Toyota";
	private String vehicleModel = "Highlander";

	/**
	 * Verify the functionality of the invalid year and required input field modal
	 * 
	 * @throws InterruptedException
	 */
	@Test
	private void addVehicleBadInputTest() throws InterruptedException {
		setProperty();
		maximizeWindow();
		testCarSpace();
		doSignIn();
		fillInputFieldUsingId(vehicleMakeInput, vehicleMake);
		fillInputFieldUsingId(vehicleModelInput, vehicleModel);
		clickOnElementUsingId(addVehicleButton);
		String expectedMessage = addVehicleInputErrorMessage;
		String actualMessage = getTextUsingXpath(addVehicleErrorModal);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElementUsingXpath(AddVehicleErrorModalOkayButton);
		fillInputFieldUsingId(vehicleYearInput, invalidVehicleYear);
		Thread.sleep(1000);
		clickOnElementUsingId(addVehicleButton);
		expectedMessage = addVehicleInvalidYearMessage;
		actualMessage = getTextUsingXpath(addVehicleErrorModal);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElementUsingXpath(AddVehicleErrorModalOkayButton);
		close();
	}
}
