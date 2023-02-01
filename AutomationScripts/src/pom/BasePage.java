package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//myProfileIcon
	@FindBy(xpath="//div[@id='customer-menu']/*[name()='svg']")
	private WebElement myProfileIcon;
	
	//emailIdTextBox
	@FindBy(id="email_id")
	private WebElement emailIdTextbox;
	
	//signInButton
	@FindBy(id="signinsubmit")
	private WebElement signInButton;
	
	//passwordTextBox
	@FindBy(id="userpassword")
	private WebElement passwordTextBox;

	public WebElement getMyProfileIcon() {
		return myProfileIcon;
	}

	public WebElement getEmailIdTextbox() {
		return emailIdTextbox;
	}

	public WebElement getSignInButton() {
		return signInButton;
	}

	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}
	
	
	
}
