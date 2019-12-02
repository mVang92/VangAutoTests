package baseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	public String carSpaceUrl = "https://car-space.herokuapp.com/";
	public String mVangPortfolioUrl = "https://mvang92.github.io/Portfolio/";
	public String chromeDriverPath = "C:\\chromedriver\\chromedriver.exe";
	
	public String email = "sally@thing.com";
	public String password = "123123";
	
	public String noUserOnRecordSignInErrorMessage = "Error: There is no user record corresponding to this identifier. The user may have been deleted.";
	public String invalidEmailErrorMessage = "Error: The email address is badly formatted.";
	public String invalidPasswordErrorMessage = "Error: The password must be 6 characters long or more.";
	public String resetFieldsSuccessMessage = "Input Fields Reset";
	public String addVehicleInputErrorMessage = "Please fill in all of the required input fields.";
	public String addVehicleInvalidYearMessage = "Please enter a valid input for Year.";
	public String vehicleDeletedSuccessfullyMessage = "Vehicle Deleted Successfully";
	
	public String signIn = "signInNavButton";
	public String signUp = "signUpNavButton";
	public String emailTextInput = "emailInput";
	public String passwordTextInput = "passwordInput";
	public String signInButton = "signInButton";
	public String signOutButton = "signOutNavButton";
	public String signUpButton = "signUpButton";
	public String confirmSignOut = "doSignOutButton";
	public String closeSignUpModal = "closeSignUpModal";
	public String vehicleYearInput = "vehicleYearInput";
	public String vehicleMakeInput = "vehicleMakeInput";
	public String vehicleModelInput = "vehicleModelInput";
	public String addVehicleButton = "addVehicleButton";
	public String confirmDeleteVehicleButton = "confirmDeleteVehicleButton";
	public String userEmailDisplay = "userEmail";
	public String vehicleCountForUser = "vehicleCountForUser";
	public String resetVehicleInputFieldsButton = "resetVehicleInputFieldsButton";
	public String backToTopButton = "topImg";
	
	public String vehicleList = "//*[@title='View Service Logs']";
	public String deleteVehicleButton = "//*[@class='deleteBtn']";
	public String addVehicleErrorModal = "//*[@class='col-md-10 userInputErrorMessage']";
	public String AddVehicleErrorModalOkayButton = "//button[@title='Okay']";
	public String aboueMeNavButton = "//a[@href='#aboutMe']";
	public String myProjectsNavButton = "//a[@href='#portfolio']";
	public String contactNavButton = "//a[@href='#contact']";
	
	public String toastNotificationError = "//*[@class='Toastify__toast Toastify__toast--error']";
	public String toastNotificationSuccess = "//*[@class='Toastify__toast Toastify__toast--success']";
	public String toastNotificationBody = "//*[@class='Toastify__toast-body']";
	public String toastNotificationCloseButton = "//*[@class='Toastify__close-button Toastify__close-button--error']";
	
	/**
	 * Sign the user out
	 * 
	 * @param driver Web driver
	 */
	public void doSignOut(WebDriver driver) {
		clickOnElementUsingId(driver, signOutButton);
		clickOnElementUsingId(driver, confirmSignOut);
	}
	
	/**
	 * Sign in with a specific user
	 * 
	 * @param driver Web driver Web driver
	 * @param specificEmail The specific user email to use
	 * @param specificPassword  The specific user password to use
	 * @throws InterruptedException
	 */
	public void doSignIn(WebDriver driver, String specificEmail, String specificPassword) throws InterruptedException {
		clickOnElementUsingId(driver, signIn);
		fillInputFieldUsingId(driver, emailTextInput, specificEmail);
		fillInputFieldUsingId(driver, passwordTextInput, specificPassword);
		clickOnElementUsingId(driver, signInButton);
		Thread.sleep(1000);
	}
	
	/**
	 * Sign the user in
	 * 
	 * @param driver
	 * @throws InterruptedException
	 */
	public void doSignIn(WebDriver driver) throws InterruptedException {
		clickOnElementUsingId(driver, signIn);
		fillInputFieldUsingId(driver, emailTextInput, email);
		fillInputFieldUsingId(driver, passwordTextInput, password);
		clickOnElementUsingId(driver, signInButton);
		Thread.sleep(1000);
	}
	
	/**
	 * Set the system property to use the Chrome driver
	 */
	public void setProperty() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
	}
	
	/**
	 * Maximize the browser window
	 * 
	 * @param driver Web driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * Click on an element using the id of the element
	 * 
	 * @param driver Web driver
	 */
	public void clickOnElementUsingId(WebDriver driver, String id) {
		driver.findElement(By.id(id)).click();
	}
	
	/**
	 * Click on an element using the xpath of the element
	 * 
	 * @param driver Web driver
	 */
	public void clickOnElementUsingXpath(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	/**
	 * Fill in the input field using the id to the input field
	 * 
	 * @param driver     Web driver
	 * @param inputField Input field to target
	 * @param inputValue Input value to fill the input field
	 */
	public void fillInputFieldUsingId(WebDriver driver, String inputField, String inputValue) {
		driver.findElement(By.id(inputField)).sendKeys(inputValue);
	}
	
	/**
	 * Get the text from the xpath of the element
	 * 
	 * @param driver Web driver
	 * @param xpath  Xpath of the element
	 * @return       Return the text from the element
	 */
	public String getTextUsingXpath(WebDriver driver, String xpath) {
		String text = driver.findElement(By.xpath(xpath)).getText();
		return text;
	}
	
	/**
	 * Get the text from the id of the element
	 * 
	 * @param driver Web driver
	 * @param id     id of the element
	 * @return       Return the text from the element
	 */
	public String getTextUsingId(WebDriver driver, String id) {
		String text = driver.findElement(By.id(id)).getText();
		return text;
	}
}
