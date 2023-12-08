package test;

import org.testng.annotations.Test;

import page.LoginPage;
import page.ProjectPage;
import utility.ElementUtility;

public class ProjectTest extends BaseTest {
  @Test
  public void verifyEditData() {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin(ElementUtility.getPropertyValue("username"),ElementUtility.getPropertyValue("password"));
	  ProjectPage pp=new ProjectPage(driver);
	  pp.navigateProject();
	  pp.doEditProject("huwaiEE");
	  
  }
}
