package basePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import resources.Themes;
import resources.Locators;

public class BasePage {
	WebDriver driver;
	WebElement webElement;
	JavascriptExecutor js;
	WebDriverWait wait;
	Properties properties;

	public static String carSpaceUrl = "https://car-space.herokuapp.com/";
	public static String mVangPortfolioUrl = "https://mvang92.github.io/Portfolio/";
	public static String chromeDriverPath = "selenium/selenium/chromedriver/chromedriver.exe";
	public static String propertiesFile;

	public static Locators id = Locators.ID;
	public static Locators xpath = Locators.XPATH;

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
	public static String expectedDefaultBackgroundPictureModalTitle = "Reset your background picture to default?";
	public static String expectedDefaultPictureModalTitle = "Reset your profile picture to default?";
	public static String expectedDefaultNameModalTitle = "Reset your name to default?";
	public static String expectedUpdateDisplayNameModalTitle = "Display name updated!";
	public static String expectedUpdateProfilePictureSuccessModalTitle = "Profile picture updated!";
	public static String expectedUpdateBackgroundPictureModalTitle = "Use this image as your background picture?";
	public static String expectedUpdateProfilePictureModalTitle = "Use this image as your profile picture?";
	public static String expectedEditVehicleInfoSuccessMessage = "Vehicle name updated successfully.";
	public static String addThreadMissingFieldsErrorMessage = "Title and description are required.";

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
		useCarSpace();
		signIn(specificEmail, specificPassword);
	}

	/**
	 * Setup system property, maximize window, select test URL, and sign-in
	 */
	public void doSignIn() {
		setProperty();
		maximizeWindow();
		useCarSpace();
		signIn();
	}
	
	/**
	 * Open CarSpace
	 */
	public void doCarSpaceTest() {
		setProperty();
		maximizeWindow();
		useCarSpace();
	}

	/**
	 * Close the browser window
	 */
	public void close() {
		driver.quit();
	}

	/**
	 * Open Portfolio
	 */
	public void doPortfolioTest() {
		setProperty();
		maximizeWindow();
		driver.get(mVangPortfolioUrl);
		propertiesFile = "src/resources/config/portfolio.properties";
	}

	/**
	 * Run CarSpace test
	 */
	public void useCarSpace() {
		driver.get(carSpaceUrl);
		propertiesFile = "src/resources/config/carSpace.properties";
	}

	/**
	 * Sign the user out
	 */
	public void doSignOut() {
		clickOnElement(getProp("menuDropdownButton"), id);
		clickOnElement(getProp("signOutNavButton"), id);
		clickOnElement(getProp("doSignOutButton"), id);
	}

	/**
	 * Sign in with a specific user
	 * 
	 * @param specificEmail    The specific user email to use
	 * @param specificPassword The specific user password to use
	 */
	public void signIn(String specificEmail, String specificPassword) {
		clickOnElement(getProp("signInNavButton"), id);
		fillInputField(getProp("emailInput"), specificEmail, id);
		fillInputField(getProp("passwordInput"), specificPassword, id);
		clickOnElement(getProp("signInButton"), id);
	}

	/**
	 * Sign the user in
	 */
	private void signIn() {
		clickOnElement(getProp("signInNavButton"), id);
		fillInputField(getProp("emailInput"), getProp("testUser"), id);
		fillInputField(getProp("passwordInput"), getProp("testUserPassword"), id);
		clickOnElement(getProp("signInButton"), id);
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
	 * Get the prop from the config file and return it
	 * 
	 * @param prop The property to load
	 * @return     The property value
	 */
	public String getProp(String prop) {
		try {
			properties = readPropertiesFile(propertiesFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(prop);
	}
	
	/**
	 * Read the properties file
	 * 
	 * @param fileName     The path to the targeted file
	 * @return             The properties from the file
	 * @throws IOException
	 */
	public Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fileInputStream = null;
		Properties prop = null;
		try {
			fileInputStream = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fileInputStream);
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fileInputStream.close();
		}
		return prop;
	}

	/**
	 * Click on an element by specifying it and its locator
	 * 
	 * @param element The element to target
	 * @param locator The type of locator to look for
	 */
	public void clickOnElement(String element, Locators locator) {
		switch (locator) {
			case XPATH:
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
			case ID:
				try {
					webElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(element)));
					js.executeScript("arguments[0].scrollIntoView();", webElement);
					webElement.click();
				} catch (Exception e) {
					webElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(element)));
					js.executeScript("arguments[0].scrollIntoView();", webElement);
					webElement.click();
				}
				break;
			default:
				throw new IllegalStateException(locator + " is not supported.");
		}
	}
	
	/**
	 * Fill in the input field using the id to the input field
	 * 
	 * @param inputField Input field to target
	 * @param inputValue Input value to fill the input field
	 * @param locator    The type of locator to look for
	 */
	public void fillInputField(String inputField, int inputValue, Locators locator) {
		fillInputField(inputField, String.valueOf(inputValue), locator);
	}

	/**
	 * Fill in the input field using the id to the input field
	 * 
	 * @param inputField Input field to target
	 * @param inputValue Input value to fill the input field
	 * @param locator    The type of locator to look for
	 */
	public void fillInputField(String inputField, String inputValue, Locators locator) {
		switch (locator) {
			case XPATH:
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(inputField)));
				webElement.clear();
				webElement.sendKeys(inputValue);
				break;
			case ID:
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(inputField)));
				webElement.clear();
				webElement.sendKeys(inputValue);
				break;
			default:
				throw new IllegalStateException(locator + " is not supported.");
		}
	}

	/**
	 * Get the text of the element using a specific locator
	 * 
	 * @param element The element to target
	 * @param locator The type of locator to look for
	 * @return        Return the text
	 */
	public String getText(String element, Locators locator) {
		String text = null;
		switch (locator) {
			case XPATH:
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
				text = webElement.getText();
				break;
			case ID:
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
				text = webElement.getText();
				break;
			default:
				throw new IllegalStateException(locator + " is not supported.");
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
	public String getValue(String element, Locators locator) {
		String value = null;
		switch (locator) {
			case XPATH:
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
				value = webElement.getAttribute("value");
				break;
			case ID:
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
				value = webElement.getAttribute("value");
				break;
			default:
				throw new IllegalStateException(locator + " is not supported.");
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
		clickOnElement(getProp("applicationName"), id);
		fillInputField(getProp("vehicleYearInput"), year, id);
		fillInputField(getProp("vehicleMakeInput"), make, id);
		fillInputField(getProp("vehicleModelInput"), model, id);
		clickOnElement(getProp("addVehicleButton"), id);
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
		clickOnElement(getProp("applicationName"), id);
		selectVehicle(year, make, model);
		clickOnElement(getProp("editVehicleNameButton"), id);
		clickOnElement(getProp("addLogDeleteVehicleButton"), id);
		clickOnElement(getProp("confirmDeleteVehicleButton"), id);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
	}
	
	/**
	 * The expected text in the toast notification after successfully adding a service log
	 * 
	 * @param service       The type of service recorded
	 * @param miles         The mileage to record
	 * @param formattedDate The date to record
	 * @return              Return the expected toast notification message
	 */
	public String addLogSuccessMessage(String service, int miles, String formattedDate) {
		return String.format(getProp("addLogSuccessMessage"), service, miles, formattedDate);
	}
	
	/**
	 * Checks to see if the button is enabled
	 * 
	 * @param button  The button to check
	 * @param locator The type of locator to look for
	 * @return        Return true/false if the button is enabled/disabled
	 */
	public Boolean isButtonEnabled(String button, Locators locator) {
		Boolean enabled = false;
		switch (locator) {
			case XPATH:
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(button)));
				enabled = webElement.isEnabled();
				break;
			case ID:
				webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(button)));
				enabled = webElement.isEnabled();
				break;
			default:
				throw new IllegalStateException(locator + " is not supported.");
		}
		return enabled;
	}
	
	/**
	 * Adds one service log to the vehicle without comments
	 * 
	 * @param date     The date of the service log
	 * @param mileage  The mileage of the vehicle
	 * @param service  The type of service
	 */
	public void addServiceLog(String date, int mileage, String service) {
		fillInputField(getProp("serviceLogDateInput"), date, id);
		fillInputField(getProp("serviceLogMileageInput"), mileage, id);
		fillInputField(getProp("serviceLogServiceInput"), service, id);
		clickOnElement(getProp("addServiceLogButton"), id);
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
		fillInputField(getProp("serviceLogDateInput"), date, id);
		fillInputField(getProp("serviceLogMileageInput"), mileage, id);
		fillInputField(getProp("serviceLogServiceInput"), service, id);
		fillInputField(getProp("serviceLogCommentsInput"), comments, id);
		clickOnElement(getProp("addServiceLogButton"), id);
		clickOnElement(toastNotificationSuccessCloseButton, xpath);
	}
	
	/**
	 * Check to see if the element is displayed
	 * 
	 * @param element The element to look for
	 * @param locator The type of locator to look for
	 * @return        Return true/false depending if the element is present or not
	 */
	public Boolean isElementDisplayed(String element, Locators locator) {
		Boolean isDisplayed = false;
		switch (locator) {
			case XPATH:
				isDisplayed = driver.findElements(By.xpath(element)).size() > 0;
				break;
			case ID:
				isDisplayed = driver.findElements(By.id(element)).size() > 0;
				break;
			default:
				throw new IllegalStateException(locator + " is not supported.");
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
		WebElement vehicle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(getProp("vehicle"), year, make, model))));
		try {
			vehicle.click();
		} catch (Exception e) {
			vehicle.click();
		}
	}
	
	/**
	 * Get the date relative to today
	 * 
	 * @param  dayOffset The amount of days to offset the requested date from the current date
	 * @return           The requested date
	 */
	public String getDate(int dayOffset) {
		final Calendar cal = Calendar.getInstance();
	    cal.add(Calendar.DATE, dayOffset);
	    Date dateToFormat = cal.getTime();
	    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = dateFormat.format(dateToFormat);
        return formattedDate.replace("/","");
	}
	
	/**
	 * Get the src attribute for the image
	 * 
	 * @param element The element to look for
	 * @param locator The type of locator to look for
	 * @return        The image src
	 */
	public String getImageSrcAttribute(String element, Locators locator) {
		WebElement image;
		String src = "";
		switch (locator) {
			case XPATH:
				image = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
				src = image.getAttribute("src");
				break;
			case ID:
				image = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
				src = image.getAttribute("src");
				break;
			default:
				throw new IllegalStateException(locator + " is not supported.");
		}
		return src;
	}
	
	/**
	 * Change the user profile picture
	 * 
	 * @param url The image URL
	 */
	public void changeProfilePicture(String url) {
		clickOnElement(getProp("applicationName"), id);
		clickOnElement(getProp("menuDropdownButton"), id);
		clickOnElement(getProp("accountNavButton"), id);
		fillInputField(getProp("newProfilePictureInput"), url, id);
		clickOnElement(getProp("submitNewProfilePictureButton"), id);
		clickOnElement(getProp("confirmUpdatePictureButton"), id);
		clickOnElement(getProp("closeUpdateProfilePictureSuccessModalButton"), id);
	}
	
	/**
	 * Change the user background picture
	 * 
	 * @param url The image URL
	 */
	public void changeBackgroundPicture(String url) {
		clickOnElement(getProp("applicationName"), id);
		clickOnElement(getProp("menuDropdownButton"), id);
		clickOnElement(getProp("accountNavButton"), id);
		fillInputField(getProp("newBackgroundPictureInput"), url, id);
		clickOnElement(getProp("submitNewBackgroundPictureButton"), id);
		clickOnElement(getProp("confirmUpdatePictureButton"), id);
	}
	
	/**
	 * Selects the theme from the theme selection dropdown menu
	 * 
	 * @param theme The theme to select
	 */
	public void selectThemeFromDropdown(Themes theme) {
		Select dropdown = new Select (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(getProp("themeSelectionDropdown")))));
		dropdown.selectByValue(theme.toString());
	}
	
	/**
	 * Return the appropriate theme displayed to the user
	 * 
	 * @param theme The theme to check
	 * @return      The appropriate theme to display to the user
	 */
	public String displayTheme(Themes theme) {
		String displayedTheme = "";
		switch(theme) {
			case carSpace:
				displayedTheme = "CarSpace";
				break;
			case light:
				displayedTheme = "Light";
				break;
			case grey:
				displayedTheme = "Grey";
				break;
			case dark:
				displayedTheme = "Dark";
				break;
			case transparentLight:
				displayedTheme = "Transparent Light";
				break;
			case transparentGrey:
				displayedTheme = "Transparent Grey";
				break;
			case transparentDark:
				displayedTheme = "Transparent Dark";
				break;
			default:
				throw new IllegalStateException(theme + " is not a supported theme.");	
		}
		return displayedTheme;
	}
	
	/**
	 * Get the current URL
	 * 
	 * @return The URL
	 */
	public String getCurrentUrl() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("loadingAnimation"))));
		return driver.getCurrentUrl();
	}
}
