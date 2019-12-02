package carSpace;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
		WebDriver driver = new ChromeDriver();
		maximizeWindow(driver);
		driver.get(carSpaceUrl);
		doSignIn(driver);
		fillInputFieldUsingId(driver, vehicleMakeInput, vehicleMake);
		fillInputFieldUsingId(driver, vehicleModelInput, vehicleModel);
		clickOnElementUsingId(driver, addVehicleButton);
		String expectedMessage = addVehicleInputErrorMessage;
		String actualMessage = getTextUsingXpath(driver, addVehicleErrorModal);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElementUsingXpath(driver, AddVehicleErrorModalOkayButton);
		fillInputFieldUsingId(driver, vehicleYearInput, invalidVehicleYear);
		Thread.sleep(1000);
		clickOnElementUsingId(driver, addVehicleButton);
		expectedMessage = addVehicleInvalidYearMessage;
		actualMessage = getTextUsingXpath(driver, addVehicleErrorModal);
		assertTrue(actualMessage.contains(expectedMessage));
		clickOnElementUsingXpath(driver, AddVehicleErrorModalOkayButton);
		driver.close();
	}
}
