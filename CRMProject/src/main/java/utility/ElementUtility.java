package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Properties;


import constants.Constants;

public class ElementUtility {
	WebDriver driver;
	public ElementUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	public static String getPropertyValue(String key) 
	{

		File src=new File(Constants.propertyConfig_File);//load file
		Properties pro=new Properties();
		try {
			FileInputStream fis = new FileInputStream (src);//open the file
			
			pro.load(fis);//file load the property
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		String value=pro.get(key).toString();
		return value;
	}
	public void doSendKeys(WebElement element,String value)
	{
		element.sendKeys(value);
	}
	public void doClick(WebElement element)
	{
		element.click();
	}
	public void doSelect(WebElement element,String value)
	{
		Select selectDrop=new Select(element)	;	
		selectDrop.selectByVisibleText(value);
	}
	public String getDataFromText(WebElement element)
	{
		String data=element.getText();
		return data;
		
	}
    public void doClear(WebElement element)
    {
    	element.clear();
    }
    public void doAlert()
    {
    	Alert alt1=driver.switchTo().alert();
		//alt1.accept();
    	alt1.dismiss();
    }

    public void scrollIntoView(WebElement element)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}
  /*  public void  takeScreenShot(String filepath) throws IOException
    {
    	 File  srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   	     File destFile=new File(filepath);
   	     FileUtils.copyFile(srcfile, destFile);
    }*/
    public int getTableDataRowCount(List<WebElement> tableRowData ,String expectedValue)//search
	{
		int counter=0;
		for(int i=0;i<tableRowData.size();i++)
		{
			String value=tableRowData.get(i).getText();
			if(expectedValue.equalsIgnoreCase(value))
			{
				counter=i+1;
				break;
			}
		}
		return counter;
	}
	

}
