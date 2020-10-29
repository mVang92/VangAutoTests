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

	public static String engineRevUrl = "https://enginerev.herokuapp.com/";
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
	public static String noAuthorizationErrorMessage = "You are not authorized to perform this action.";
	public static String passwordResetConfirmationSuccessMessage = "Password confirmation sent. Please check your email.";
	
	public static String applicationName = "applicationName";
	public static String signInNavButton = "signInNavButton";
	public static String signUpNavButton = "signUpNavButton";
	public static String accountNavButton = "accountNavButton";
	public static String forumNavButton = "forumNavButton";
	public static String menuDropdownButton = "menuDropdownButton";
	public static String emailInput = "emailInput";
	public static String passwordInput = "passwordInput";
	public static String signInButton = "signInButton";
	public static String signOutNavButton = "signOutNavButton";
	public static String signUpButton = "signUpButton";
	public static String doSignOutButton = "doSignOutButton";
	public static String closeSignUpModal = "closeSignUpModal";
	public static String vehicleNameHeader = "vehicleNameHeader";
	public static String vehicleNameInput = "vehicleNameInput";
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
	public static String submitNewBackgroundPictureButton = "submitNewBackgroundPictureButton";
	public static String submitNewProfilePictureButton = "submitNewProfilePictureButton";
	public static String submitNewDisplayNameButton = "submitNewDisplayNameButton";
	public static String submitNewEmailButton = "submitNewEmailButton";
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
	public static String newBackgroundPictureInput = "newBackgroundPictureInput";
	public static String newProfilePictureInput = "newProfilePictureInput";
	public static String resetNewBackgroundPictureButton = "resetNewBackgroundPictureButton";
	public static String resetNewProfilePictureButton = "resetNewProfilePictureButton";
	public static String resetNewDisplayNameButton = "resetNewDisplayNameButton";
	public static String profilePicture = "profilePicture";
	public static String profilePicturePreview = "profilePicturePreview";
	public static String backgroundPicturePreview = "backgroundPicture";
	public static String confirmUpdatePictureButton = "confirmUpdatePictureButton";
	public static String closeUpdateProfilePictureSuccessModalButton = "closeUpdateProfilePictureSuccessModalButton";
	public static String mainPageProfilePicture = "mainPageProfilePicture";
	public static String themeSelectionDropdown = "themeSelectionDropdown";
	public static String applyThemeButton = "applyThemeButton";
	public static String accountPageCurrentTheme = "accountPageCurrentTheme";
	public static String confirmSaveEditVehicleNameButton = "confirmSaveEditVehicleNameButton";
	public static String startNewThreadButton = "startNewThreadButton";
	public static String submitNewThreadButton = "submitNewThreadButton";
	public static String newThreadTitleInput = "newThreadTitleInput";
	public static String newThreadDescriptionInput = "newThreadDescriptionInput";
	public static String userRole = "userRole";
	public static String advancedSettingsToggle = "advancedSettingsToggle";
	public static String newEmailInput = "newEmailInput";
	public static String removeVehicleNameButton = "removeVehicleNameButton";
	public static String forgotPassword = "forgotPassword";
	public static String emailInputForPasswordReset = "emailInputForPasswordReset";
	public static String forgotPasswordSubmitButton = "forgotPasswordSubmitButton";
	public static String closeForgotPasswordModal = "closeForgotPasswordModal";

	public static String modal = "//*[@class='ReactModal__Content ReactModal__Content--after-open Modal__Bootstrap modal-dialog']";
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
	public static String topButton = "//button[@class='backToTopButton']";
	public static String forumFooterLink = "//a[contains(@href, '/forum')]";
	public static String releaseNotesFooterLink = "//a[contains(@href, '/updates')]";
	public static String aboutFooterLink = "//a[contains(@href, '/about')]";
	public static String forumLoggedOutText = "//*[contains(text(), 'Please sign in or create an account to start a thread.')]";
	public static String serviceLog = "//div[@class='serviceLog']";
	public static String vehicleToSelect = "//*[@title='%s %s %s']";	

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
		useEngineRev();
		signIn(specificEmail, specificPassword);
	}

	/**
	 * Setup system property, maximize window, select test URL, and sign-in
	 */
	public void doSignIn() {
		setProperty();
		maximizeWindow();
		useEngineRev();
		signIn();
	}
	
	/**
	 * Open EngineRev
	 */
	public void doEngineRevTest() {
		setProperty();
		maximizeWindow();
		useEngineRev();
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
	 * Run EngineRev test
	 */
	public void useEngineRev() {
		driver.get(engineRevUrl);
		propertiesFile = "src/resources/config/engineRev.properties";
	}

	/**
	 * Sign the user out
	 */
	public void doSignOut() {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(signOutNavButton, id);
		clickOnElement(doSignOutButton, id);
	}

	/**
	 * Sign in with a specific user
	 * 
	 * @param specificEmail    The specific user email to use
	 * @param specificPassword The specific user password to use
	 */
	public void signIn(String specificEmail, String specificPassword) {
		clickOnElement(signInNavButton, id);
		fillInputField(emailInput, specificEmail, id);
		fillInputField(passwordInput, specificPassword, id);
		clickOnElement(signInButton, id);
	}

	/**
	 * Sign the user in
	 */
	private void signIn() {
		clickOnElement(signInNavButton, id);
		fillInputField(emailInput, getProp("testUser"), id);
		fillInputField(passwordInput, getProp("testUserPassword"), id);
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
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
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
					js.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element))));
				break;
			case ID:
					js.executeScript("arguments[0].click();", wait.until(ExpectedConditions.elementToBeClickable(By.id(element))));
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
				text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).getText();
				break;
			case ID:
				text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element))).getText();
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
				value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).getAttribute("value");
				break;
			case ID:
				value = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element))).getAttribute("value");
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
		shouldClickApplicationName();
		fillInputField(vehicleYearInput, year, id);
		fillInputField(vehicleMakeInput, make, id);
		fillInputField(vehicleModelInput, model, id);
		clickOnElement(addVehicleButton, id);
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
		shouldClickApplicationName();
		selectVehicle(year, make, model);
		clickOnElement(editVehicleNameButton, id);
		clickOnElement(addLogDeleteVehicleButton, id);
		clickOnElement(confirmDeleteVehicleButton, id);
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
				enabled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(button))).isEnabled();
				break;
			case ID:
				enabled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(button))).isEnabled();
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
		fillInputField(serviceLogDateInput, date, id);
		fillInputField(serviceLogMileageInput, mileage, id);
		fillInputField(serviceLogServiceInput, service, id);
		clickOnElement(addServiceLogButton, id);
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
		shouldClickApplicationName();
		webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(vehicleToSelect, year, make, model))));
		try {
			webElement.click();
		} catch (Exception e) {
			webElement.click();
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
		String src = "";
		switch (locator) {
			case XPATH:
				src = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).getAttribute("src");
				break;
			case ID:
				src = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element))).getAttribute("src");
				break;
			default:
				throw new IllegalStateException(locator + " is not supported.");
		}
		return src;
	}
	
	/**
	 * Get the placeholder attribute from the input field
	 * 
	 * @param element The element to look for
	 * @param locator The type of locator to look for
	 * @return        The placeholder
	 */
	public String getPlaceholderText(String element, Locators locator) {
		String placeholder = "";
		switch (locator) {
			case XPATH:
				placeholder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).getAttribute("placeholder");
				break;
			case ID:
				placeholder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element))).getAttribute("placeholder");
				break;
			default:
				throw new IllegalStateException(locator + " is not supported.");
		}
		return placeholder;
	}
	
	/**
	 * Get the title attribute from the element
	 * 
	 * @param element The element to look for
	 * @param locator The type of locator to look for
	 * @return        The title
	 */
	public String getTitle(String element, Locators locator) {
		String title = "";
		switch (locator) {
			case XPATH:
				title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).getAttribute("title");;
				break;
			case ID:
				title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element))).getAttribute("title");
				break;
			default:
				throw new IllegalStateException(locator + " is not supported.");
		}
		return title;
	}
	
	/**
	 * Change the user profile picture
	 * 
	 * @param url The image URL
	 */
	public void changeProfilePicture(String url) {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		fillInputField(newProfilePictureInput, url, id);
		clickOnElement(submitNewProfilePictureButton, id);
		clickOnElement(confirmUpdatePictureButton, id);
		clickOnElement(closeUpdateProfilePictureSuccessModalButton, id);
	}
	
	/**
	 * Change the user background picture
	 * 
	 * @param url The image URL
	 */
	public void changeBackgroundPicture(String url) {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
		fillInputField(newBackgroundPictureInput, url, id);
		clickOnElement(submitNewBackgroundPictureButton, id);
		clickOnElement(confirmUpdatePictureButton, id);
	}
	
	/**
	 * Selects the theme from the theme selection dropdown menu
	 * 
	 * @param theme The theme to select
	 */
	public void selectThemeFromDropdown(Themes theme) {
		Select dropdown = new Select (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(themeSelectionDropdown))));
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
			case engineRev:
				displayedTheme = "EngineRev";
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
		return driver.getCurrentUrl();
	}
	
	/**
	 * Click on the application name only if the current URL is not the home page
	 */
	public void shouldClickApplicationName() {
		if (!getCurrentUrl().equals(getProp("engineRevUrl"))) {
			clickOnElement(applicationName, id);
		}
	}
	
	/**
	 * Use the navigation bar to navigate to the Account page
	 */
	public void navigateToAccountPage() {
		clickOnElement(menuDropdownButton, id);
		clickOnElement(accountNavButton, id);
	}
}
