package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class ProjectPage {
	WebDriver driver;
	WaitUtility waitutil;
	ElementUtility elementutil;
	@FindBy (xpath = "//span[text()='Projects']")
	WebElement projectlinkfield;
	@FindBy(xpath = "//span[text()='All Projects']")
	WebElement allprojectfield;
	@FindBy(xpath ="//table[@id='project-table']//tr[1]//td[9]//a[1]" )
	WebElement editfield;
	@FindBy(xpath = "//input[@id='title']")
	WebElement titlefield;
	@FindBy(xpath = "//input[@id='start_date']")
	WebElement startdatefield;
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement savefield;
	public ProjectPage(WebDriver driver)
	{
		this.driver=driver;
		waitutil=new WaitUtility(driver);
		elementutil=new ElementUtility(driver);
		PageFactory.initElements(driver, this);
	}
	public void navigateProject()
	{
		waitutil.waitForClick(projectlinkfield);
		elementutil.doClick(projectlinkfield);
		waitutil.waitForClick(allprojectfield);
		elementutil.doClick(allprojectfield);
	}
	public void doEditProject(String title)
	{
		waitutil.waitForClick(editfield);
		elementutil.doClick(editfield);
		elementutil.doClear(titlefield);
		elementutil.doSendKeys(titlefield, title);
		elementutil.scrollIntoView(startdatefield);
		waitutil.waitForClick(savefield);
		elementutil.doClick(savefield);
	}
	

}
