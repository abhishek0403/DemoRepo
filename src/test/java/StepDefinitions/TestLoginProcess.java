package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestLoginProcess {
	
	public static WebDriver driver;
	
	@Before public static void browser()
	{
	System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	driver = new ChromeDriver(); 
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	}
	
	@Given("Login page for CWOA is opened")
	public void login_page_for_CWOA_is_opened() 
	{
		System.out.println("Testing Started now");
		driver.get("https://fmassist-test.retail-azure.js-devops.co.uk/");
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;

	}

	@When("The user enter’ s the valid login credentials")
	public void the_user_enter_s_the_valid_login_credentials() 
	{
		try 
		{
			Thread.sleep(3000);
			driver.findElement(By.id("username")).sendKeys("Admin");
			driver.findElement(By.id("password")).sendKeys("Admin");
			
	    }
		catch (InterruptedException e) 
		{
	        e.printStackTrace();
	    }
		
	}

	@Then("User click on the Login button")
	public void user_click_on_the_login_button() 
	{
		try 
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
	    }
		catch (InterruptedException e) 
		{
	        e.printStackTrace();
	    }
	}

	@Then("Landing page should be opened successfully")
	public void landing_page_should_be_opened_successfully() 
	{
		try 
		{
			Thread.sleep(3000);
			String welcome = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/h2")).getText();
			String text = "Welcome to FM assist";

			if (welcome.equals(text))
			{
				System.out.println("User is in Landing page");
			}
			else
			{
				System.out.println("User is not in Landing page");
			}
		}
		catch (InterruptedException e) 
		{
	        e.printStackTrace();
	    }

	}
	
	@Then("User click on the Logout button")
	public void user_click_on_the_Logout_button() 
	{
		try 
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(),'lOGOUT')]")).click();
	    }
		catch (InterruptedException e) 
		{
	        e.printStackTrace();
	    }
	}

	@When("The user enter’ s the invalid login credentials")
	public void the_user_enter_s_the_invalid_login_credentials() 
	{
	    try 
	    {
	    	Thread.sleep(5000);
	    	driver.findElement(By.id("username")).sendKeys("Admin1333");
			driver.findElement(By.id("password")).sendKeys("Admin23");
	    } 
	    catch (InterruptedException e) 
	    {
	        e.printStackTrace();
	    }

	}

	@Then("Error page should be displayed")
	public void error_page_should_be_displayed() 
	{
		try 
		{
	        Thread.sleep(3000);
	    	String error = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/h2")).getText();
			String text = "There was a problem...";
			
			if (error.equals(text))
			{
				System.out.println("User is in error page");
			}
			
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	}

	@Then("The user clicks Fetch Info from Verisae button")
	public void the_user_clicks_Fetch_Info_from_Verisae_button() 
	{
		try 
		{
	        Thread.sleep(3000);
			driver.findElement(By.xpath("//button[contains(text(),'Fetch info from Verisae')]")).click();
		 } 
		catch (InterruptedException e) 
		{
		        e.printStackTrace();
		}
	}

	@Then("All the work orders are displayed in the landing page")
	public void all_the_work_orders_are_displayed_in_the_landing_page() 
	{
		try 
		{
	        Thread.sleep(40000);
		    WebElement table = driver.findElement(By.xpath("//table[@class='ln-u-push-bottom ln-c-table']"));
		    List<WebElement> number = table.findElements(By.tagName("td"));
		    SlotWork:
		    for(WebElement workorder: number)
		    
				  	    if (workorder.getText()!=null)
				  	        {

				                System.out.println("API called and Work Order Number details exist");
				                break SlotWork;
				                
				  	        }      
		} 
		catch (InterruptedException e) 
		{
		        e.printStackTrace();
		}	
	}
	
	@After public static void TearDown()
	{
		driver.quit();
	}

}
