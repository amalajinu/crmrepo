package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class ClientsPage {
	WebDriver driver;
	ElementUtility elementutil;
	WaitUtility waitutil;
	@FindBy(xpath = "//span[text()='Clients']")
	WebElement clientlinkfield;
	@FindBy(xpath = "//input[@type='search']")
	WebElement searchclientfield;
	@FindBy(xpath = "//table[@id='client-table']//tbody//tr[1]//td[2]//a")
	WebElement companyfromtable;
	@FindBy(xpath ="//table[@id='client-table']//tbody//tr[1]//td[9]//a[1]")
	WebElement editlinkelement;
	@FindBy(xpath = "//input[@id='company_name']")
	WebElement companyeditfield;
	@FindBy(xpath ="//button[text()=' Save']")
	WebElement btnsave;
	@FindBy(xpath = "//table[@id='client-table']//tbody//tr[1]//td[9]//a[2]")
	WebElement btndelete;
	@FindBy(xpath = "//button[text()=' Delete']")
	WebElement btnconfirmDelete;
	@FindBy(xpath ="//a[@title='Add client']")
	WebElement addclientfield;
	@FindBy(xpath="//input[@name='company_name']")
	WebElement companyfield;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement addressfield;
	@FindBy(xpath = "//input[@name='city']")
	WebElement cityfield;
	@FindBy(xpath = "//input[@name='state']")
	WebElement statefield;
	@FindBy(xpath = "//input[@name='zip']")
	WebElement zipfield;
	@FindBy(xpath = "//input[@name='country']")
	WebElement countryfield;
	@FindBy(xpath = "//input[@name='phone']")
	WebElement phonefield;
	@FindBy(xpath = "//input[@name='website']")
	WebElement websitefield;
	@FindBy(xpath = "//input[@name='vat_number']")
	WebElement vatnumberfield;
	@FindBy(xpath = "//div[@id='s2id_currency']")
	WebElement currencyfield;
	@FindBy(xpath = "//div[text()='AED']")
	WebElement currencyselectionfield;
	@FindBy(xpath = "//input[@name='currency_symbol']")
	WebElement currencysymbolfield;
	@FindBy(xpath = "//input[@name='disable_online_payment']")
	WebElement onlinepaymentfield;   
	@FindBy(xpath = "//button[text()=' Save']")
	WebElement savefield;
	
	
	public ClientsPage(WebDriver driver)
	{
		elementutil=new ElementUtility(driver);
		waitutil=new WaitUtility(driver);
		PageFactory.initElements(driver,this );
	}
	public void navigateClientPage()
	{
		waitutil.waitForClick(clientlinkfield);
		elementutil.doClick(clientlinkfield);
		elementutil.doClear(searchclientfield);
	}
	public void doAddClient(String company,String address,String city,String state,String zip,String country,String phoneno,String website,
			String vatno,String currencysymbol)
	{
		waitutil.waitForClick(addclientfield);
		elementutil.doClick(addclientfield);
		waitutil.waitForVisibility(companyfield);
		elementutil.doSendKeys(companyfield, company);
		elementutil.doSendKeys(addressfield, address);
		elementutil.doSendKeys(cityfield, city);
		elementutil.doSendKeys(statefield, state);
		elementutil.doSendKeys(zipfield, zip);
		elementutil.doSendKeys(countryfield, country);
		elementutil.doSendKeys(phonefield, phoneno);
		elementutil.scrollIntoView(phonefield);
		elementutil.doSendKeys(websitefield, website);
		elementutil.doSendKeys(vatnumberfield, vatno);
		waitutil.waitForClick(currencyfield);
		elementutil.doClick(currencyfield);
		waitutil.waitForClick(currencyselectionfield);
		elementutil.doClick(currencyselectionfield);
		waitutil.waitForClick(onlinepaymentfield);
		elementutil.doClick(onlinepaymentfield);
		elementutil.doSendKeys(currencysymbolfield, currencysymbol);
		elementutil.doClick(savefield);
		
		
	}
	public String doSearchClient(String serachelement)
	{
		waitutil.waitForVisibility(searchclientfield);
		elementutil.doSendKeys(searchclientfield, serachelement);
		String searcheditem=elementutil.getDataFromText(companyfromtable);
		return searcheditem;
		
	}
	public void doEditClient(String companyrename)
	{
		elementutil.doClick(editlinkelement);
		waitutil.waitForVisibility(companyeditfield);
		elementutil.doClear(companyeditfield);
		elementutil.doSendKeys(companyeditfield, companyrename);
		waitutil.waitForClick(btnsave);
		elementutil.doClick(btnsave);
		elementutil.doClear(searchclientfield);
		
	}
	public void doDeleteClient()
	{
		waitutil.waitForClick(btndelete);
		elementutil.doClick(btndelete);
		waitutil.waitForClick(btnconfirmDelete);
		elementutil.doClick(btnconfirmDelete);
		
	}
	

}
