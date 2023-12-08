package page;

import java.io.IOException;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class NotesPage {
	WebDriver driver;
	ElementUtility elementutil;
	WaitUtility waitutil;
	@FindBy(xpath ="//a[contains(@href,'notes')]")
	WebElement noteslink;//@FindBy(xpath="//span[text()='Notes']")
	//@FindBy(xpath ="//a[@title='Add note' and @data-title='Add note' ]")
	@FindBy(xpath="//a[text()=' Add note']")
	WebElement addlink;
	@FindBy(xpath ="//input[@name='title']")
	WebElement titleadd;
	@FindBy(xpath = "//textarea[@id='description']")
	WebElement descriptionadd;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement savebutton;
	@FindBy(xpath ="//button[text()=' Close']")
	WebElement closebutton;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchelement;
	@FindBy(xpath = "//table[@id='note-table']//tbody//tr[1]//td[2]//a")
	WebElement tablelement;
	@FindBy(xpath = "//table[@id='note-table']//tbody//tr[1]//td[4]//a[1]")
	WebElement editelement;
	@FindBy(xpath = "//input[@id='title']")
	WebElement edittitleelement;
	@FindBy(xpath ="//button[text()=' Save']")
	WebElement editsaveelement;
	@FindBy(xpath = "//table[@id='note-table']//tbody//tr[1]//td[4]//a[2]")
	WebElement deleteelement;
	@FindBy(xpath = "//button[@id='confirmDeleteButton']")
	WebElement confirmdeleteelement;
	@FindBy(xpath = "//button[@class='close']")
	WebElement btntitleclose;
	@FindBy(xpath = "//table[@id='note-table']//tbody//tr[1]//td[1]")
	WebElement deletetablecolumn;
	
	
	public NotesPage(WebDriver driver)
	{
		this.driver=driver;
		elementutil=new ElementUtility(driver);
		PageFactory.initElements(driver,this );
		waitutil=new WaitUtility(driver);
	}
	public void navigateNotePage()
	{
		waitutil.waitForClick(noteslink);
		elementutil.doClick(noteslink);
		
	}
	public void openAddNote()
	{
		waitutil.waitForClick(addlink);
		elementutil.doClick(addlink);
	}
	public void doaddNote(String title,String description) throws IOException
	{
		if(title==""&&description=="")
		{
			elementutil.doClick(closebutton);
		}
		else {
			waitutil.waitForVisibility(titleadd);
			elementutil.doSendKeys(titleadd, title);
			elementutil.doSendKeys(descriptionadd, description);
			waitutil.waitForClick(savebutton);
			elementutil.doClick(savebutton);
			waitutil.waitForClick(btntitleclose);
			elementutil.doClick(btntitleclose);
			
			
		}
		
	}
	public String dosearchNote(String searchtext)
	{
		waitutil.waitForVisibility(searchelement);
		elementutil.doSendKeys(searchelement, searchtext);		
		//String columnvalue=elementutil.getDataFromText(tablelement);
		//return columnvalue;
		
		By locator=By.xpath("//table[@id='note-table']//tbody//tr//td//a[contains(text(),'"+searchtext+"')]");
		waitutil.waitForVisibility(locator);
		List<WebElement> notetable=driver.findElements(By.xpath("//table[@id='note-table']//tbody//tr//td//a[contains(text(),'"+searchtext+"')]"));
		waitutil.waitForVisibility(notetable);
		int row=elementutil.getTableDataRowCount(notetable, searchtext);

		String actualmsg="";
		if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='note-table']//tbody//tr["+row+"]//td[2]"));
			actualmsg=tableRow.getText();
			System.out.println("Searched Element : " +actualmsg);
		}
		return actualmsg;
		
	}
	public void doeditNote(String titleedit)
	{
		elementutil.doClick(editelement);
		elementutil.doClear(edittitleelement);
		elementutil.doClear(searchelement);
		elementutil.doSendKeys(edittitleelement, titleedit);
		elementutil.doClick(editsaveelement);
		waitutil.waitForClick(btntitleclose);
		elementutil.doClick(btntitleclose);
	}
	
	public String dodeleteNote(String searchtext)
	{
		waitutil.waitForClick(deleteelement);
		elementutil.doClick(deleteelement);
		waitutil.waitForClick(confirmdeleteelement);
		elementutil.doClick(confirmdeleteelement);
		waitutil.waitForVisibility(searchelement);
		elementutil.doSendKeys(searchelement, searchtext);		
		String deletetext=elementutil.getDataFromText(deletetablecolumn);
		return deletetext;
		
	}
}
