package carSpace;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import baseClass.BaseClass;

public class SignInNoUserTest extends BaseClass {
	private String noRecordUserEmail = "noRecordUser@gmail.com";
	private String noRecordUserpassword = "123456";
	
	/**
	 * Verify the toast error message upon signing in with an account not on record
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void signInNoUserTest() throws InterruptedException {
		setProperty();
		WebDriver driver = new ChromeDriver();
		maximizeWindow(driver);
		driver.get(carSpaceUrl);
		doSignIn(driver, noRecordUserEmail, noRecordUserpassword);
		Thread.sleep(1000);
		String expectedMessage = noUserOnRecordSignInErrorMessage;
		String actualMessage = getTextUsingXpath(driver, toastNotificationBody);
		assertTrue(actualMessage.contains(expectedMessage));
		driver.close();
	}
}
