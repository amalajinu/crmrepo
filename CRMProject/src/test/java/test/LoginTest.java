package test;

import org.testng.annotations.Test;

import constants.Constants;
import page.LoginPage;
import utility.ExcelRead;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class LoginTest  extends BaseTest{
   
  @Test(groups= {"sanity","regression"},dataProvider = "dp")
  public void verifyLogIn(String username,String password) {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin(username,password);
  }
  @DataProvider
  public Object[][] dp() throws InvalidFormatException, IOException
  {
	  Object[][] excelvalue=ExcelRead.getDataFromExcel(Constants.testData, "logindata"); 
	  return excelvalue;
  }
 

 
}
