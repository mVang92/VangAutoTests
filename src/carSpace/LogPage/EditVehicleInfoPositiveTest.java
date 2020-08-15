package carSpace.LogPage;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import basePage.BasePage;

public class EditVehicleInfoPositiveTest extends BasePage {
	private String year = "2014";
	private String make = "Honda";
	private String model = "Pilot";
	private String newYear = "1999";
	private String newMake = "Lexus";
	private String newModel = "ES 300";
	
	@DataProvider(name = "data")
	public Object[][] dataProviderMethod() {
		return new Object[][] {
			{
				year,
				make,
				model,
				newYear,
				vehicleYearInput				
			},
			{
				newYear,
				make,
				model,
				newMake,
				vehicleMakeInput
			},
			{
				newYear,
				newMake,
				model,
				newModel,
				vehicleModelInput				
			},
			{
				newYear,
				newMake,
				newModel,
				null,
				null				
			}
		};
	}
	
	@BeforeClass
	public void setup() {
		doSignIn();
		addVehicle(Integer.parseInt(year), make, model);
	}
	
	/**
	 * Verify the vehicle name, make, and model are editable and the user is able to save them
	 */
	@Test(dataProvider = "data")
	public void changeVehicleNameTest(
		String year,
		String make,
		String model,
		String input,
		String inputField		
	){
		selectVehicle(Integer.parseInt(year), make, model);
		assertEquals(getText(vehicleNameHeader, id), year + " " + make + " " + model);
		if (input != null) {
			clickOnElement(editVehicleNameButton, id);
			fillInputField(inputField, input, id);
			clickOnElement(confirmSaveEditVehicleNameButton, id);
			clickOnElement(applicationName, id);
		}
	}

	@AfterClass
	public void teardown() {
		deleteVehicle(Integer.parseInt(newYear), newMake, newModel);
		close();
	}

}
