package baseClass;

public class BaseClass {
	public String chromeDriverPath = "C:\\chromedriver\\chromedriver.exe";
	
	public String signIn = "//*[contains(text(),'Sign In')]";
	public String emailTextInput = "//input[@type=\"text\"]";
	public String passwordTextInput = "//input[@type=\"password\"]";
	public String signInButton = "//button[@type=\"submit\"]";
	public String signOutButton = "//div[contains(text(),'Sign Out')]";
	public String confirmSignOut = "//button[contains(text(),\"Yes\")]";
	public String userEmail = "//span[@id=\"userEmail\"]/text()[1]";
}
