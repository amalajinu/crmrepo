package constants;

public class Constants {
	/*
	If you make any variable as final, you cannot change the value of final variable(It will be constant).
	//define the constant data used in project
  //classname.variablename
   //System.getProperty("user.dir")-we will get the project path
	 */
	public static final String screenShot_path= System.getProperty("user.dir") + "\\Screenshots\\";
	public static final String testData=System.getProperty("user.dir") +"\\src\\test\\resources\\testdata\\CRMData.xlsx";
	public static final String noteData=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\CRMNote.xlsx";
	public static final String propertyConfig_File=System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
}
