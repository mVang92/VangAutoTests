package baseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	public String URL = "https://car-space.herokuapp.com/";
	public String chromeDriverPath = "C:\\chromedriver\\chromedriver.exe";
	
	public String userEmail = "sally@thing.com";
	public String password = "123123";
	
	public String noUserOnRecordSignInErrorMessage = "Error: There is no user record corresponding to this identifier. The user may have been deleted.";
	public String addVehicleInputErrorMessage = "Please fill in all of the required input fields.";
	public String addVehicleInvalidYearMessage = "Please enter a valid input for Year.";
	
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
	
	public String vehicleList = "//*[@title='View Service Logs']";
	public String deleteVehicleButton = "//*[@class='deleteBtn']";
	public String addVehicleErrorModal = "//*[@class='col-md-10 userInputErrorMessage']";
	public String AddVehicleErrorModalOkayButton = "//button[@title='Okay']";
	
	public String toastNotificationError = "//*[@class='Toastify__toast Toastify__toast--error']";
	public String toastNotificationSuccess = "//*[@class='Toastify__toast Toastify__toast--success']";
	public String toastNotificationBody = "//*[@class='Toastify__toast-body']";
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void clickOnElementUsingId(WebDriver driver, String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clickOnElementUsingXpath(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void fillInputFieldUsingId(WebDriver driver, String inputField, String inputValue) {
		driver.findElement(By.id(inputField)).sendKeys(inputValue);
	}
	
	public String getTextUsingXpath(WebDriver driver, String xpath) {
		String text = driver.findElement(By.xpath(xpath)).getText();
		return text;
	}
}
