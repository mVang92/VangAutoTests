package baseClass;

public class BaseClass {
	public String URL = "https://car-space.herokuapp.com/";
	public String chromeDriverPath = "C:\\chromedriver\\chromedriver.exe";
	
	public String userEmail = "sally@thing.com";
	public String password = "123123";
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
}
