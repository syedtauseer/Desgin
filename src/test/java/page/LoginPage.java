package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	@FindBy(id = "username")
	private WebElement unTB;

	@FindBy(name = "pwd")
	private WebElement pwTB;

	@FindBy(xpath = "//div[text()='Login ']")
	private WebElement loginBTN;

	@FindBy(xpath = "//span[contains(text(),'Username or Password is invalid. Please try again.')]")
	private WebElement erMSG;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String un) {
		unTB.sendKeys(un);
	}

	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}

	public void clickLoginButton() {
		loginBTN.click();
	}

	public boolean verifyErrorMsgIsDisplayed(WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.visibilityOf(erMSG));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
