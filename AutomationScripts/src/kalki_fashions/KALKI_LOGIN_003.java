package kalki_fashions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.BasePage;
import preconditions.BaseClass;
import preconditions.ReadData;

public class KALKI_LOGIN_003 extends BaseClass {
	public String expectedLoginPopUpText="Sign In";
	public String expectedEmailId="preethamgowda3098@gmail.com";
	public String expectedPassword="Appu@35007";
	
	@Parameters("browserName")
	@Test(groups = "Functionality-positive")
	
	public void enteringPassword() {
		BasePage basePage=new BasePage(driver);
		
		//To click on my profile icon
		basePage.getMyProfileIcon().click();
		WebElement actualLoginPagePopUpText = driver.findElement(By.xpath("//div[@id=\"login_title\"]/h2"));
		Assert.assertEquals(actualLoginPagePopUpText.getText(),expectedLoginPopUpText,"Loginpage is not displayed");
		Reporter.log("login page is displayed",true);
		
		//To enter registered email Id 
		basePage.getEmailIdTextbox().sendKeys(ReadData.fromPropertyFile("emailId").toString());
		String actualEmailId = basePage.getEmailIdTextbox().getAttribute("value");
		Assert.assertEquals(expectedEmailId, expectedEmailId,"Email Id entered is mismatched");
		Reporter.log("Email Id entered is matched",true);
		
		//Clicking on sign in button
		basePage.getSignInButton().click();
		
		//To enter valid password
		basePage.getPasswordTextBox().sendKeys(ReadData.fromPropertyFile("password").toString());
		String actualPassword=basePage.getPasswordTextBox().getAttribute("value");
		Assert.assertEquals(expectedPassword, actualPassword,"Password entered is mismatched");
		Reporter.log("Password entered is matched",true);
	}
}
