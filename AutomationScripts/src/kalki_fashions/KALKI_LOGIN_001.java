package kalki_fashions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pom.BasePage;
import preconditions.BaseClass;

public class KALKI_LOGIN_001 extends BaseClass  {
public String expectedLoginPopUpText="Sign In";

	@Parameters("browserName")
	@Test(groups = "Functionality-positive")
	
	public void clickingOnMyProfileIcon() {
		BasePage basePage=new BasePage(driver);
		
		//To click on my profile icon
		basePage.getMyProfileIcon().click();
		WebElement actualLoginPagePopUpText = driver.findElement(By.xpath("//div[@id=\"login_title\"]/h2"));
		Assert.assertEquals(actualLoginPagePopUpText.getText(),expectedLoginPopUpText,"Loginpage is not displayed");
		Reporter.log("login page is displayed",true);
	}
}
