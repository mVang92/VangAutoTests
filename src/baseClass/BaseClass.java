package baseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	WebDriver driver;

	public static String carSpaceUrl = "https://car-space.herokuapp.com/";
	public static String mVangPortfolioUrl = "https://mvang92.github.io/Portfolio/";
	public static String chromeDriverPath = "C:\\chromedriver\\chromedriver.exe";

	public static String id = "id";
	public static String xpath = "xpath";

	public static String email = "sally@thing.com";
	public static String password = "123123";

	public static String noUserOnRecordSignInErrorMessage = "Error: There is no user record corresponding to this identifier. The user may have been deleted.";
	public static String invalidEmailErrorMessage = "Error: The email address is badly formatted.";
	public static String invalidPasswordErrorMessage = "Error: The password must be 6 characters long or more.";
	public static String resetFieldsSuccessMessage = "Input Fields Reset";
	public static String addVehicleInputErrorMessage = "Please fill in all of the required input fields.";
	public static String addVehicleInvalidYearMessage = "Please enter a valid input for Year.";
	public static String vehicleDeletedSuccessfullyMessage = "Vehicle Deleted Successfully";

	public static String signIn = "signInNavButton";
	public static String signUp = "signUpNavButton";
	public static String emailTextInput = "emailInput";
	public static String passwordTextInput = "passwordInput";
	public static String signInButton = "signInButton";
	public static String signOutButton = "signOutNavButton";
	public static String signUpButton = "signUpButton";
	public static String confirmSignOut = "doSignOutButton";
	public static String closeSignUpModal = "closeSignUpModal";
	public static String vehicleYearInput = "vehicleYearInput";
	public static String vehicleMakeInput = "vehicleMakeInput";
	public static String vehicleModelInput = "vehicleModelInput";
	public static String addVehicleButton = "addVehicleButton";
	public static String confirmDeleteVehicleButton = "confirmDeleteVehicleButton";
	public static String userEmailDisplay = "userEmail";
	public static String vehicleCountForUser = "vehicleCountForUser";
	public static String resetVehicleInputFieldsButton = "resetVehicleInputFieldsButton";
	public static String backToTopButton = "topImg";
	public static String portfolioCommentInput= "commentInput";
	public static String portfolioResetButton = "resetButton";

	public static String vehicleList = "//*[@title='View Service Logs']";
	public static String deleteVehicleButton = "//*[@class='deleteBtn']";
	public static String addVehicleErrorModal = "//*[@class='col-md-10 userInputErrorMessage']";
	public static String AddVehicleErrorModalOkayButton = "//button[@title='Okay']";
	public static String aboueMeNavButton = "//a[@href='#aboutMe']";
	public static String myProjectsNavButton = "//a[@href='#portfolio']";
	public static String contactNavButton = "//a[@href='#contact']";

	public static String toastNotificationError = "//*[@class='Toastify__toast Toastify__toast--error']";
	public static String toastNotificationSuccess = "//*[@class='Toastify__toast Toastify__toast--success']";
	public static String toastNotificationBody = "//*[@class='Toastify__toast-body']";
	public static String toastNotificationCloseButton = "//*[@class='Toastify__close-button Toastify__close-button--error']";

	/**
	 * Setup system property, maximize window, select test URL, and sign-in using a
	 * specific user
	 * 
	 * @throws InterruptedException
	 */
	public void doSignIn(String specificEmail, String specificPassword) throws InterruptedException {
		setProperty();
		maximizeWindow();
		useCarSpaceUrl();
		signIn(specificEmail, specificPassword);
	}

	/**
	 * Setup system property, maximize window, select test URL, and sign-in
	 * 
	 * @throws InterruptedException
	 */
	public void doSignIn() throws InterruptedException {
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
		clickOnElement(signOutButton, id);
		clickOnElement(confirmSignOut, id);
	}

	/**
	 * Sign in with a specific user
	 * 
	 * @param specificEmail    The specific user email to use
	 * @param specificPassword The specific user password to use
	 * @throws InterruptedException
	 */
	public void signIn(String specificEmail, String specificPassword) throws InterruptedException {
		clickOnElement(signIn, id);
		fillInputField(emailTextInput, specificEmail, id);
		fillInputField(passwordTextInput, specificPassword, id);
		clickOnElement(signInButton, id);
		Thread.sleep(1000);
	}

	/**
	 * Sign the user in
	 * 
	 * @throws InterruptedException
	 */
	private void signIn() throws InterruptedException {
		clickOnElement(signIn, id);
		fillInputField(emailTextInput, email, id);
		fillInputField(passwordTextInput, password, id);
		clickOnElement(signInButton, id);
		Thread.sleep(1000);
	}

	/**
	 * Set the system property to use the Chrome driver
	 */
	public void setProperty() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
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
				driver.findElement(By.xpath(element)).click();
				break;
			case "id":
				driver.findElement(By.id(element)).click();
		}
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
				driver.findElement(By.xpath(inputField)).sendKeys(inputValue);
				break;
			case "id":
				driver.findElement(By.id(inputField)).sendKeys(inputValue);
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
				text = driver.findElement(By.xpath(element)).getText();
				break;
			case "id":
				text = driver.findElement(By.id(element)).getText();
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
				value = driver.findElement(By.xpath(element)).getAttribute("value");
				break;
			case "id":
				value = driver.findElement(By.id(element)).getAttribute("value");
		}
		return value;
	}
}
