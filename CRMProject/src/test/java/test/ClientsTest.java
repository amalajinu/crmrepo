package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.ClientsPage;
import page.LoginPage;
import utility.ElementUtility;
import utility.FakerUtility;

public class ClientsTest extends BaseTest{
	@Test(priority = 1)
	  public void verifyWhetherTheAdminisAbletoAddClient() {
		  LoginPage loginpage=new LoginPage(driver);
		  loginpage.doLogin(ElementUtility.getPropertyValue("username"),ElementUtility.getPropertyValue("password"));
		  ClientsPage clienetspage=new ClientsPage(driver);
		  clienetspage.navigateClientPage();
		  clienetspage.doAddClient("Tecgen", "Infopark", "EKM", "kerala", "123", "India", FakerUtility.phoneNumber(), "www.tec.com", "98706","$");
		  clienetspage.navigateClientPage();
		  String searchedcompany= clienetspage.doSearchClient("Tecgen");
		  Assert.assertEquals(searchedcompany, "Tecgen","Not found");
		 /* SoftAssert softassert=new SoftAssert();
		  softassert.assertEquals(searchedcompany, "Tecgen");
		  softassert.assertAll();*/
		  
	  }
  @Test(priority = 2)
  public void verifyWhethertheAdminIsAbleToSearchClient() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.doLogin("admin@admin.com", "12345678");
	  ClientsPage clienetspage=new ClientsPage(driver);
	  clienetspage.navigateClientPage();
	  String searchedcompany= clienetspage.doSearchClient("Tectest");
	  Assert.assertEquals(searchedcompany, "Tectest","Not found");
	 
  }
  @Test(priority = 3)
  public void verifyWhetherTheAdminIsAbleToEditClient() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.doLogin("admin@admin.com", "12345678");
	  ClientsPage clienetspage=new ClientsPage(driver);
	  clienetspage.navigateClientPage();
	  clienetspage.doSearchClient("obsqura test");
	  clienetspage.doEditClient("Dmart test");
	  clienetspage.navigateClientPage();
      String searchedcompany= clienetspage.doSearchClient("Dmart test");	
      Assert.assertEquals(searchedcompany, "Dmart test","Not found");
      
  }
  @Test(priority = 4)
  public void verifyWhetherTheAdminIsAbleToDeleteClient() {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.doLogin("admin@admin.com", "12345678");
	  ClientsPage clienetspage=new ClientsPage(driver);
	  clienetspage.navigateClientPage();
	  clienetspage.doSearchClient("Dmart test");	
	  clienetspage.doDeleteClient();
	  clienetspage.navigateClientPage();
	  clienetspage.doSearchClient("Dmart test");	
  }
  
}
