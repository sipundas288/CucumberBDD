package StepDefination;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;

/*Parent Class*/
public class BaseClass {
	
	public static WebDriver driver;
	public LoginPage loginPage;
	public AddNewCustomerPage addNewCustPg;
	public SearchCustomerPage searchCustomerPg;
	public ReadConfig readConfig;
	
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
	
	

}
