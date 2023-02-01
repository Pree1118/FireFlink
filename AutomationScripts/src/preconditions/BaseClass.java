package preconditions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	public WebDriver driver;
	public String expectedHomePagetitle="Buy Traditional Indian Clothing and Ethnic Wear for Women and Men - KALKI Fashion";
	
	@Parameters("browserName")
	@BeforeClass
	public void browserSetUp(@Optional("chrome") String bname) throws InvalidBrowserValueException {
		//Step-1:To launch a browser
		if(bname.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			Reporter.log("ChromeBrowser is launched",true);
		}
		else if(bname.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
			Reporter.log("FirefoxBrowser is launched",true);
		}
		else {
			throw new InvalidBrowserValueException();
		}
		driver.manage().window().maximize();
		Reporter.log("Browser window is maximized",true);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		//Step-2:Navigating to URL
		driver.get(ReadData.fromPropertyFile("url").toString());
		Assert.assertEquals(driver.getTitle(), expectedHomePagetitle,"homepage is mismatched");
	}
	//Handling the exception
	class InvalidBrowserValueException extends Exception{
		InvalidBrowserValueException(){
			super("Invalid browser");
		}
	}
	
	//To close the browser
	@AfterClass
	public void toQuitTheBrowser() {
		//driver.quit();
	}
	
	
}
