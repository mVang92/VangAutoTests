package engineRev.logPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class AddServiceLogPositiveTest extends BasePage {
	
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	LocalDate localDate = LocalDate.now();
	String formattedDate = dateFormatter.format(localDate);
	
	private int year = 1997;
	private int miles = 123456;
	private String make = "Lexus";
	private String model = "ES300";
	private String service = "Transmission Fluid Change";
	private String comment = "This is a test comment.";
	private String month;
	private String day;
	
	@BeforeClass
	private void setup() {
		doSignIn();
		addVehicle(year, make, model);
	}
	
	/**
	 * Verify the user can add service logs successfully and the toast notification displays properly
	 */
	@Test
	private void addServiceLogPositiveTest() {
		selectVehicle(year, make, model);
		String monthSubString = formattedDate.substring(0, 2);
		String daySubString = formattedDate.substring(3, 5);
		String yearSubString = formattedDate.substring(6);
		int monthToInt = Integer.parseInt(monthSubString);
		int dayToInt = Integer.parseInt(daySubString);
		int yearToInt = Integer.parseInt(yearSubString);
		checkMonthAndDayEqualToOne(monthSubString, daySubString, monthToInt, dayToInt);
		String date = month + "/" + day + "/" + yearToInt;
		fillInputField(serviceLogDateInput, date, id);
		fillInputField(serviceLogMileageInput, miles, id);
		fillInputField(serviceLogServiceInput, service, id);
		fillInputField(serviceLogCommentsInput, comment, id);
		clickOnElement(addServiceLogButton, id);
		if (monthToInt < 10) {
			month = formattedDate.substring(1, 2);
		}
		if (dayToInt < 10) {
			day = formattedDate.substring(4, 5);
		}
		date = month + "/" + day + "/" + yearToInt;
		assertEquals(getText(toastNotificationBody, xpath), addLogSuccessMessage(service, miles, date));
		assertTrue(isElementDisplayed(serviceLog, xpath));
	}
	
	@AfterClass
	private void teardown() {
		deleteVehicle(year, make, model);
		close();
	}
	
	/**
	 * Check if the month and day are equal to 1. If they are, add a 0 in front of the integer.
	 * 
	 * @param monthSubString The substring month
	 * @param daySubString   The substring day
	 * @param monthToInt     The month to check
	 * @param dayToInt       The day to check
	 */
	private void checkMonthAndDayEqualToOne(String monthSubString, String daySubString, int monthToInt, int dayToInt) {
		if (monthToInt == 1) {
			month = "0" + monthToInt ;
		} else {
			month = monthSubString;
		}
		if (dayToInt == 1) {
			day = "/0" + dayToInt;
		} else {
			day = daySubString;
		}
	}
}
