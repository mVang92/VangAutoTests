package carSpace;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		WebDriver driver = new ChromeDriver();
		maximizeWindow(driver);
		driver.get(carSpaceUrl);
		doSignIn(driver);
		fillInputFieldUsingId(driver, vehicleYearInput, vehicleYear);
		fillInputFieldUsingId(driver, vehicleMakeInput, vehicleMake);
		fillInputFieldUsingId(driver, vehicleModelInput, vehicleModel);
		clickOnElementUsingId(driver, resetVehicleInputFieldsButton);
		Thread.sleep(500);
		String expectedMessage = resetFieldsSuccessMessage;
		String toastNotificationMessage = getTextUsingXpath(driver, toastNotificationBody);
		assertTrue(toastNotificationMessage.contains(expectedMessage));
		String vehicleYearInputAfterReset = getTextUsingId(driver, vehicleYearInput);
		String vehicleMakeInputAfterReset = getTextUsingId(driver, vehicleMakeInput);
		String vehicleModelInputAfterReset = getTextUsingId(driver, vehicleModelInput);
		assertEquals(vehicleYearInputAfterReset, "");
		assertEquals(vehicleMakeInputAfterReset, "");
		assertEquals(vehicleModelInputAfterReset, "");
		driver.close();
	}

}
