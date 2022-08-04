package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class TestLogin extends BaseTest {
	@Test(dataProvider = "getData", priority = 1, groups = { "smoke" })
	public void testValidLogin(String un, String pw, String eTitle) {
		LoginPage loginpage = new LoginPage(driver);
		test.info("Enter The User Name");
		loginpage.setUserName(un);
		test.info("Enter The Password");
		loginpage.setPassword(pw);
		test.info("Click On Login Button");
		loginpage.clickLoginButton();
		test.info("Verify HomePage Is Displayed");
		EnterTimeTrackPage ettPage = new EnterTimeTrackPage(driver);
		boolean result = ettPage.verifyPageTitle(wait, eTitle);
		Assert.assertTrue(result, "HomePage Is Not Displayed");
		test.pass("HomePage Is Displayed");

	}
}
