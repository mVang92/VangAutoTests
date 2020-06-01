package baseClass;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	WebDriver driver;
	WebElement webElement;
	JavascriptExecutor js;
	WebDriverWait wait;

	public static String carSpaceUrl = "https://car-space.herokuapp.com/";
	public static String mVangPortfolioUrl = "https://mvang92.github.io/Portfolio/";
	public static String chromeDriverPath = "C:\\Selenium\\selenium\\chromedriver\\chromedriver.exe";

	public static String id = "id";
	public static String xpath = "xpath";

	public static String email = "sally@thing.com";
	public static String password = "123123";
	public static String testUserDisplayName = "Sally Thing";
	public static String defaultDisplayName = "CarSpace User";

	public static String noUserOnRecordSignInErrorMessage = "Error: There is no user record corresponding to this identifier. The user may have been deleted.";
	public static String invalidPasswordOrNoPasswordErrorMessage = "Error: The password is invalid or the user does not have a password.";
	public static String invalidEmailErrorMessage = "Error: The email address is badly formatted.";
	public static String invalidPasswordErrorMessage = "Error: The password must be 6 characters long or more.";
	public static String passwordsDoNotMatchErrorMessage = "Error: Passwords do not match.";
	public static String resetFieldsSuccessMessage = "Input fields reset.";
	public static String addVehicleInputErrorMessage = "Please fill in all of the required input fields.";
	public static String addVehicleInvalidYearMessage = "Please enter a valid input for Year.";
	public static String vehicleDeletedSuccessfullyMessage = "Vehicle deleted successfully.";
	public static String addLogsMissingFieldsErrorMessage = "Please fill in the missing fields:";
	public static String expectedDefaultPictureModalTitle = "Reset your profile picture to default?";
	public static String expectedDefaultNameModalTitle = "Reset your name to default?";
	public static String expectedUpdateDisplayNameModalTitle = "Display name updated!";

	public static String applicationName = "applicationName";
	public static String signInNavButton = "signInNavButton";
	public static String signUpNavButton = "signUpNavButton";
	public static String accountNavButton = "accountNavButton";
	public static String menuDropdownButton = "menuDropdownButton";
	public static String emailTextInput = "emailInput";
	public static String passwordTextInput = "passwordInput";
	public static String signInButton = "signInButton";
	public static String signOutButton = "signOutNavButton";
	public static String signUpButton = "signUpButton";
	public static String confirmSignOut = "doSignOutButton";
	public static String closeSignUpModal = "closeSignUpModal";
	public static String vehicleNameHeader = "vehicleNameHeader";
	public static String vehicleYearInput = "vehicleYearInput";
	public static String vehicleMakeInput = "vehicleMakeInput";
	public static String vehicleModelInput = "vehicleModelInput";
	public static String addVehicleButton = "addVehicleButton";
	public static String confirmDeleteVehicleButton = "confirmDeleteVehicleButton";
	public static String accountPageUserEmail = "accountPageUserEmail";
	public static String vehicleCountForUser = "vehicleCountForUser";
	public static String accountPageVehicleCount = "accountPageVehicleCount";
	public static String resetVehicleInputFieldsButton = "resetVehicleInputFieldsButton";
	public static String backToTopButton = "topImg";
	public static String portfolioCommentInput= "commentInput";
	public static String portfolioResetButton = "resetButton";
	public static String serviceLogDateInput = "serviceLogDateInput";
	public static String serviceLogMileageInput = "serviceLogMileageInput";
	public static String serviceLogServiceInput = "serviceLogServiceInput";
	public static String serviceLogCommentsInput = "serviceLogCommentsInput";
	public static String addLogResetInputFieldsButton = "addLogResetInputFieldsButton";
	public static String addLogDeleteVehicleButton = "addLogDeleteVehicleButton";
	public static String addServiceLogButton = "addServiceLogButton";
	public static String editVehicleNameButton = "editVehicleNameButton";
	public static String submitNewProfilePictureButton = "submitNewProfilePictureButton";
	public static String submitNewDisplayNameButton = "submitNewDisplayNameButton";
	public static String submitNewPasswordButton = "submitNewPasswordButton";
	public static String closeUpdatePictureModalButton = "closeUpdatePictureModalButton";
	public static String closeUpdateDisplayNameModalButton = "closeUpdateDisplayNameModalButton";
	public static String confirmUpdateDisplayNameButton = "confirmUpdateDisplayNameButton";
	public static String closeUpdateDisplayNameSuccessModalButton = "closeUpdateDisplayNameSuccessModalButton";
	public static String newDisplayNameInput = "newDisplayNameInput";
	public static String displayName = "displayName";
	public static String deleteVehicleModalTitle = "deleteVehicleModalTitle";
	public static String accountPageUserDisplayName = "accountPageUserDisplayName";
	public static String addLogSortLogsButton = "addLogSortLogsButton";
	public static String printPageButton = "printPageButton";
	public static String printPageViaDeleteButton = "printPageViaDeleteButton";
	
	public static String addVehicleErrorModal = "//*[@class='col-md-10 userInputErrorMessage']";
	public static String addLogErrorModal = "//*[@class='col-md-10 userInputErrorMessage']";
	public static String addVehicleErrorModalOkayButton = "//button[@title='Okay']";
	public static String addLogErrorModalOkayButton = "//button[@title='Okay']";
	public static String aboutMeNavButton = "//a[@href='#aboutMe']";
	public static String myProjectsNavButton = "//a[@href='#portfolio']";
	public static String contactNavButton = "//a[@href='#contact']";
	public static String modalTitle = "//*[@class='row modal-header']";
	public static String backHomeBtn = "//*[@class='backHomeBtn']";
	public static String cancelButton = "//button[contains(text(),'Cancel')]";
	public static String noButton = "//button[contains(text(),'No')]";
	public static String editActionButton = "//button[@class='editActionButton']";

	public static String toastNotificationError = "//*[@class='Toastify__toast Toastify__toast--error']";
	public static String toastNotificationSuccess = "//*[@class='Toastify__toast Toastify__toast--success']";
	public static String toastNotificationBody = "//*[@class='Toastify__toast-body']";
	public static String toastNotificationInfoCloseButton = "//*[@class='Toastify__close-button Toastify__close-button--info']";
	public static String toastNotificationSuccessCloseButton = "//*[@class='Toastify__close-button Toastify__close-button--success']";
	public static String toastNotificationErrorCloseButton = "//*[@class='Toastify__close-button Toastify__close-button--error']";

	/**
	 * Setup system property, maximize window, select test URL, and sign-in using a specific user
	 */
	public void doSignIn(String specificEmail, String specificPassword) {
		setProperty();
		maximizeWindow();
		useCarSpaceUrl();
		signIn(specificEmail, specificPassword);
	}

	/**
	 * Setup system property, maximize window, select test URL, and sign-in
	 */
	public void doSignIn() {
		setProperty();
		maximizeWindow();
		useCarSpaceUrl();
		signIn();
	}

	/**
	 * Close the browser window
	 */
	public void close() {
		driver.close();
	}

	/**
	 * Run Portfolio test
	 */
	public void usePortfolioUrl() {
		driver.get(mVangPortfolioUrl);
	}

	/**
	 * Run CarSpace test
	 */
	public void useCarSpaceUrl() {
		driver.get(carSpaceUrl);
	}

	/**
	 * Sign the user out
	 */
	public void doSignOut() {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(signOutButton, id);
		clickOnElement(confirmSignOut, id);
	}

	/**
	 * Sign in with a specific user
	 * 
	 * @param specificEmail    The specific user email to use
	 * @param specificPassword The specific user password to use
	 */
	public void signIn(String specificEmail, String specificPassword) {
		clickOnElement(signInNavButton, id);
		fillInputField(emailTextInput, specificEmail, id);
		fillInputField(passwordTextInput, specificPassword, id);
		clickOnElement(signInButton, id);
	}

	/**
	 * Sign the user in
	 */
	private void signIn() {
		clickOnElement(signInNavButton, id);
		fillInputField(emailTextInput, email, id);
		fillInputField(passwordTextInput, password, id);
		clickOnElement(signInButton, id);
	}

	/**
	 * Set the system property to use the Chrome driver
	 */
	public void setProperty() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 35);
	}

	/**
	 * Maximize the browser window
	 */
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * Click on an element by specifying it and its locator
	 * 
	 * @param element The element to target
	 * @param locator The type of locator to look for
	 */
	public void clickOnElement(String element, String locator) {
		switch (locator) {
			case "xpath":
				try {
					webElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
					js.executeScript("arguments[0].scrollIntoView();", webElement);
					webElement.click();
				} catch (Exception e) {
					webElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
					js.executeScript("arguments[0].scrollIntoView();", webElement);
					webElement.click();
				}
				break;
			case "id":
				try {
					webElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(element)));
					js.executeScript("arguments[0].scrollIntoView();", webElement);
					webElement.click();
				} catch (Exception e) {
					webElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(element)));
					js.executeScript("arguments[0].scrollIntoView();", webElement);
					webElement.click();
				}
		}
	}
	
	/**
	 * Fill in the input field using the id to the input field
	 * 
	 * @param inputField Input field to target
	 * @param inputValue Input value to fill the input field
	 * @param locator    The type of locator to look for
	 */
	public void fillInputField(String inputField, int inputValue, String locator) {
		String inputValueToString = String.valueOf(inputValue);
		fillInputField(inputField, inputValueToString, locator);
	}

	/**
	 * Fill in the input field using the id to the input field
	 * 
	 * @param inputField Input field to target
	 * @param inputValue Input value to fill the input field
	 * @param locator    The type of locator to look for
	 */
	public void fillInputField(String inputField, String inputValue, String locator) {
		switch (locator) {
			case "xpath":
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputField)));
				webElement.sendKeys(inputValue);
				break;
			case "id":
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputField)));
				webElement.sendKeys(inputValue);
		}
	}

	/**
	 * Get the text of the element using a specific locator
	 * 
	 * @param element The element to target
	 * @param locator The type of locator to look for
	 * @return        Return the text
	 */
	public String getText(String element, String locator) {
		String text = null;
		switch (locator) {
			case "xpath":
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
				text = webElement.getText();
				break;
			case "id":
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
				text = webElement.getText();
		}
		return text;
	}
	
	/**
	 * Get the value from the input box using the element and locator
	 * 
	 * @param element The element to target
	 * @param locator The type of locator to look for
	 * @return        Return the value
	 */
	public String getValue(String element, String locator) {
		String value = null;
		switch (locator) {
			case "xpath":
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
				value = webElement.getAttribute("value");
				break;
			case "id":
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
				value = webElement.getAttribute("value");
		}
		return value;
	}
	
	/**
	 * Add a vehicle
	 * 
	 * @param year  The vehicle year
	 * @param make  The vehicle make
	 * @param model The vehicle model
	 */
	public void addVehicle(int year, String make, String model) {
		fillInputField(vehicleYearInput, year, id);
		fillInputField(vehicleMakeInput, make, id);
		fillInputField(vehicleModelInput, model, id);
		clickOnElement(addVehicleButton, id);
		String expectedMessage = "Added a " + year + " " + make + " " + model + ".";
		String toastNotificationMessage = getText(toastNotificationBody, xpath);
		assertEquals(toastNotificationMessage, expectedMessage);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
	}
	
	/**
	 * Delete a vehicle
	 * 
	 * @param year  The vehicle year
	 * @param make  The vehicle make
	 * @param model The vehicle model
	 */
	public void deleteVehicle(int year, String make, String model) {
		clickOnElement(applicationName, id);
		selectVehicle(year, make, model);
		clickOnElement(editVehicleNameButton, id);
		clickOnElement(addLogDeleteVehicleButton, id);
		clickOnElement(confirmDeleteVehicleButton, id);
		String expectedMessage = vehicleDeletedSuccessfullyMessage;
		String toastNotificationMessage = getText(toastNotificationBody, xpath);
		assertEquals(toastNotificationMessage, expectedMessage);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
	}
	
	/**
	 * Check the toast notification when adding a service log
	 * 
	 * @param service       The type of service recorded
	 * @param miles         The mileage to record
	 * @param formattedDate The date to record
	 * @return              Return the expected toast notification message
	 */
	public String addLogSuccessMessage(String service, int miles, String formattedDate) {
		String expectedMessage = "Service Logged: " + service + " at " + miles + " miles on " + formattedDate + ".";
		return expectedMessage;
	}
	
	/**
	 * Checks to see if the button is enabled
	 * 
	 * @param button  The button to check
	 * @param locator The type of locator to look for
	 * @return        Return true/false if the button is enabled/disabled
	 */
	public Boolean isButtonEnabled(String button, String locator) {
		Boolean enabled = false;
		switch (locator) {
			case "xpath":
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(button)));
				enabled = webElement.isEnabled();
				break;
			case "id":
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(button)));
				enabled = webElement.isEnabled();
		}
		return enabled;
	}
	
	/**
	 * Format the date by removing the leading 0 for months before October and days before the 10th day
	 * 
	 * @param date The date to format
	 * @return     Return the new formated date
	 */
	public String formatDate(String date) {
		String month = null;
		String day = null;
		String monthSubString = date.substring(0, 2);
		String daySubString = date.substring(2, 4);
		String yearSubString = date.substring(4);
		int monthToInt = Integer.parseInt(monthSubString);
		int dayToInt = Integer.parseInt(daySubString);
		int yearToInt = Integer.parseInt(yearSubString);
		if (monthToInt < 10) {
			month = date.substring(1, 2);
		} else {
			month = monthSubString;
		}
		if (dayToInt < 10) {
			day = date.substring(3, 4);
		} else {
			day = daySubString;
		}
		date = month + "/" + day + "/" + yearToInt;
		return date;
	}
	
	/**
	 * Adds one service log to the vehicle without comments
	 * 
	 * @param date     The date of the service log
	 * @param mileage  The mileage of the vehicle
	 * @param service  The type of service
	 */
	public void addServiceLog(String date, int mileage, String service) {
		fillInputField(serviceLogDateInput, date, id);
		fillInputField(serviceLogMileageInput, mileage, id);
		fillInputField(serviceLogServiceInput, service, id);
		clickOnElement(addServiceLogButton, id);
		String formatedDate = formatDate(date);
		String expectedMessage = addLogSuccessMessage(service, mileage, formatedDate);
		String toastNotificationMessage = getText(toastNotificationBody, xpath);
		assertEquals(toastNotificationMessage, expectedMessage);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
	}
	
	/**
	 * Adds one service log to the vehicle with comments
	 * 
	 * @param date     The date of the service log
	 * @param mileage  The mileage of the vehicle
	 * @param service  The type of service
	 * @param comments Comments to address during service
	 */
	public void addServiceLog(String date, int mileage, String service, String comments) {
		fillInputField(serviceLogDateInput, date, id);
		fillInputField(serviceLogMileageInput, mileage, id);
		fillInputField(serviceLogServiceInput, service, id);
		fillInputField(serviceLogCommentsInput, comments, id);
		clickOnElement(addServiceLogButton, id);
		String formatedDate = formatDate(date);
		String expectedMessage = addLogSuccessMessage(service, mileage, formatedDate);
		String toastNotificationMessage = getText(toastNotificationBody, xpath);
		assertEquals(toastNotificationMessage, expectedMessage);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
	}
	
	/**
	 * Check to see if the element is displayed
	 * 
	 * @param element The element to look for
	 * @param locator The type of locator to look for
	 * @return        Return true/false depending if the element is present or not
	 */
	public Boolean isElementDisplayed(String element, String locator) {
		Boolean isDisplayed = false;
		switch (locator) {
			case "xpath":
				isDisplayed = driver.findElements(By.xpath(element)).size() > 0;
				break;
			case "id":
				isDisplayed = driver.findElements(By.id(element)).size() > 0;
		}
		return isDisplayed;
	}
	
	/**
	 * Click on the selected vehicle
	 * 
	 * @param year  The vehicle year
	 * @param make  The vehicle make
	 * @param model The vehicle model
	 */
	public void selectVehicle(int year, String make, String model) {
		WebElement vehicle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title='" + year + " " + make + " " + model + "']")));
		try {
			vehicle.click();
		} catch (Exception e) {
			vehicle.click();
		}
	}
}
