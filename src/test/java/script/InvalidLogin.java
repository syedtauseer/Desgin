package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.LoginPage;

public class InvalidLogin extends BaseTest {
	@Test(dataProvider = "getData", priority = 2, groups = { "smoke" })
	public void testInValidLogin(String un, String pw) {
		LoginPage loginpage = new LoginPage(driver);
		test.info("Enter The User Name");
		loginpage.setUserName(un);
		test.info("Enter The Password");
		loginpage.setPassword(pw);
		test.info("Click On Login Button");
		loginpage.clickLoginButton();
		test.info("Verify Error Message Is Displayed");
		boolean result = loginpage.verifyErrorMsgIsDisplayed(wait);
		Assert.assertTrue(result, "Error Message Is Not Displayed");
		test.pass("ErrorMessage Is Displayed");

	}
}
