package StepDefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef extends BaseClass {
	@Before
	public void setup1()
	
	{
		readConfig = new ReadConfig();
		
		System.out.println("Setup1-sanity method executed");
		
		String browser = readConfig.getBrowser();
		
		// launch browser
		switch (browser.toLowerCase()) {
		case  "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case  "edge":
			
			System.setProperty("webdriver.edge.driver","C:\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
			
		case  "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
		
		/*WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();*/
	}
	/*@Before("@Regression")
public void setup2()
	
	{
		System.out.println("Setup2-regression method executed");
		WebDriverManager.chromedriver().setup();
	    driver = new FirefoxDriver();
	}*/

	
	////////Login Feature////////
	@Given("User Launch Chrome browser")
	public void user_launch_Chrome_browser() {
	
	    
		loginPage = new LoginPage(driver);
	    addNewCustPg = new AddNewCustomerPage(driver);
	    searchCustomerPg = new SearchCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emiladd, String password) {
	loginPage.enterEmail(emiladd); 
	loginPage.enterPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
		Thread.sleep(4000);
	loginPage.clickOnLoginButton();
	    
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) throws InterruptedException {
	String actualTitle =  driver.getTitle();
	Thread.sleep(4000);
	
	System.out.println("Expected Title: " + expectedTitle);
    System.out.println("Actual Title: " + actualTitle);


	
	//Assert.assertTrue(searchCustomerPg.searchCustomerByEmail(expectedEmail));

	if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);//pass
		
		}
	else
		{
			Assert.assertTrue(false);//fail
		}
	//Thread.sleep(5000);
	//driver.findElement(By.xpath("//*[@id=\"JHsxi5\"]/div/label/input")).click();
	Thread.sleep(3000);
	}
	

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
	  loginPage.clickOnLogOutButton();  
	}

	/*@Then("close browser")
	public void close_browser() {
	    driver.close();
	   // driver.quit();
	}*/
	///////////////////////Add New Customers//////////////////

	@Then("User can view Dashbord")
	public void user_can_view_dashbord() {
		
		String actualTitle = addNewCustPg.getPageTitle();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expectedTitle = "nopCommerce demo store. Login";
		
		
		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		
	   
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		addNewCustPg.clickOnCustomersMenu();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	}

	@When("click on customer Menu Item")
	public void click_on_customer_menu_item() {
		addNewCustPg.clickOnCustomersMenuItem();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addNewCustPg.clickOnAddnew();
	   
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
	    
		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		//addNewCustPg.enterEmail("test4@gmail.com");
		addNewCustPg.enterEmail(generateEmailId()+"@gmail.com");
		addNewCustPg.enterPassword("test1");
		addNewCustPg.enterFirstName("Prachi");
		addNewCustPg.enterLastName("Gupta");
		addNewCustPg.enterGender("Female");
		addNewCustPg.enterCompanyName("Nityananda");   
	}

	@When("click on save button")
	public void click_on_save_button() {
		addNewCustPg.clickOnSave();
	    
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {
		
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(exptectedConfirmationMsg))
		{
			Assert.assertTrue(true);//pass
			
		}
		else
		{
			

			Assert.assertTrue(false);

		}
	}
		/////////////Search Customer//////////////
		
	
		@When("clich on search bar")
		public void clich_on_search_bar() {
			
		    
		}

		@When("Enter customer EMail")
		public void enter_customer_e_mail() {
			searchCustomerPg.enterEmailAdd("victoria_victoria@nopCommercw.com");
	
		    
		}

		@When("Click on search button")
		public void click_on_search_button() {
			 searchCustomerPg.clickOnSearchButton(); 
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		@Then("User should found Email in the Search table")
		public void user_should_found_email_in_the_search_table() {
			String expectedEmail = "victoria_victoria@nopCommercw.com";
			
			Assert.assertTrue(searchCustomerPg.searchCustomerByEmail(expectedEmail));
			/*if(searchCustomerPg.searchCustomerByEmail(expectedEmail) ==true)
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}*/
			
			 
	    
	}
		
		////////search customer by name
		@When("Enter customer FirstName")
		public void enter_customer_first_name() {
			searchCustomerPg.enterFirstName("Victoria");
		    
		}

		@When("Enter customer LastName")
		public void enter_customer_last_name() {
			searchCustomerPg.enterLastName("Terces");
		   
		}

		@Then("User should found Name in the Search table")
		public void user_should_found_name_in_the_search_table() {
			
			String expectedName = "victoria Terces";
			
			Assert.assertTrue(searchCustomerPg.searchCustomerByName(expectedName));
			/*if(searchCustomerPg.searchCustomerByName(expectedName) ==true)
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}*/
			
			
		    
		}  
		@After
		public void teardown(Scenario sc) throws IOException
		{
			System.out.println("Tear down method executed");
			if(sc.isFailed()==true)
			{
				TakesScreenshot ts = (TakesScreenshot)driver;
				File temp = ts.getScreenshotAs(OutputType.FILE);
				
				//step 3
				File perm = new File("C:\\cucumber\\ProjectCu\\ScreenShot\\test2.png");
				
				
				FileHandler.copy(temp, perm);
			
			}
			driver.quit();
		}
		/*@BeforeStep
		public void BeforeStepMethodDemo()
		{
			System.out.println("This is before steps....");
		}
		
		@AfterStep
		public void afterStepMethodDemo()
		{
			System.out.println("This is after steps....");
		}*/


}
