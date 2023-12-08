package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class LoginPage {
	WebDriver driver;
	ElementUtility elementutil;
	WaitUtility waitutil;
	@FindBy(name="email")
	WebElement usernamefield;
	@FindBy(name="password")
	WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement submitfield;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		elementutil= new ElementUtility(driver);
		waitutil=new WaitUtility(driver);
		PageFactory.initElements(driver,this );//initiaze webelements declared using @FindBY
		//pagefactory -class
	}
	public void doLogin(String username,String password)
	{
		waitutil.waitForVisibility(usernamefield);
		elementutil.doSendKeys(usernamefield, username);
		//waitutil.waitForVisibility(passwordfield);
		elementutil.doSendKeys(passwordfield, password);
		waitutil.waitForClick(submitfield);
		elementutil.doClick(submitfield);
	}


}
