package test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constants;
import page.LoginPage;
import page.NotesPage;
import utility.ExcelRead;

public class NotesTest extends  BaseTest{
  @Test(priority = 1,groups = {"regression"},dataProvider = "dp1")
  public void verifyWhetherTheAdminIsAbletoAddNote(String title,String description) throws IOException {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.doLogin(ExcelRead.getString(1, 0, "logindata"), ExcelRead.getNumeric(1, 1, "logindata"));
	  NotesPage notespage=new NotesPage(driver);
	  notespage.navigateNotePage();
	  notespage.openAddNote();//save note
	 //  np.doaddNote("therese","added on the date 12 for test");
	  notespage.doaddNote(title, description);
	  notespage.navigateNotePage();
	   String columnvalue= notespage.dosearchNote("jinu");//search title of 1st raw
	  Assert.assertEquals(columnvalue, "jinu","User is unable to add note");
		// SoftAssert softassert=new SoftAssert();
		// softassert.assertEquals(columnvalue, "jinu");
		//softassert.assertAll();
		

  }
  @Test(priority = 2)
  public void verifyWhethertheAdminIsAbleToSearchNote() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.doLogin("admin@admin.com", "12345678");
	  NotesPage notespage=new NotesPage(driver);
	  notespage.navigateNotePage();
	 String columnvalue= notespage.dosearchNote("therese");//search title of 1st raw
	  Assert.assertEquals(columnvalue, "therese","found");
  }
  @Test(priority = 3,retryAnalyzer = generaltests.Retry.class)
  public void verifyWhetherTheAdminisAbleToEditNote() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.doLogin("admin@admin.com", "12345678");
	  NotesPage notespage=new NotesPage(driver);
	  notespage.navigateNotePage();
	  notespage.dosearchNote("therese");//search 
	  notespage.doeditNote("anju");//edit title from 1st raw of table( np.searchNote("therese"))
	  notespage.navigateNotePage();
	  String columnvalue= notespage.dosearchNote("anju");//search title of 1st raw
	  Assert.assertEquals(columnvalue, "jinu","not found");
  }
  @Test(priority = 4)
  public void verifyWhetherTheAdminIsAbleToDeleteNote() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.doLogin("admin@admin.com", "12345678");
	  NotesPage notespage=new NotesPage(driver);
	  notespage.navigateNotePage();
	  notespage.dosearchNote("anju");
	   String deleteText=notespage.dodeleteNote("anju");//delete element from 1st raw of table(delete searched item- np.searchNote("anju"))
	 // String columnvalue= np.dosearchNote("anju");//search title of 1st raw
	   Assert.assertEquals(deleteText, "anju","found");
	  
  }
  @DataProvider
  public Object[][] dp1() throws InvalidFormatException, IOException
  {
	  Object[][] excelvalue=ExcelRead.getDataFromExcel(Constants.noteData, "Sheet1"); 
	  return excelvalue;
  }

  
}
