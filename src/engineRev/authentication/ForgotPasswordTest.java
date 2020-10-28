package engineRev.authentication;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import basePage.BasePage;

public class ForgotPasswordTest extends BasePage{
	
	@BeforeClass
	private void setup() {
		doEngineRevTest();
	}

	/**
	 * Verify the email confirmation toast notification displays after sending the password reset confirmation
	 */
	@Test
	private void forgotPasswordTestPositive() {
		
	}
	
	/**
	 * Verify the email confirmation toast notification displays an error with a non existing email address
	 */
	@Test
	private void forgotPasswordTestNegative() {
		
	}

	@AfterClass
	private void teardown() {
		close();
	}
}
