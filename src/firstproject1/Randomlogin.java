package firstproject1;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Randomlogin {
	

     	WebDriver driver = new ChromeDriver() ;
     	
     	String [] UserNames = {"standard_user","locked_out_user","problem_user","performance_glitch_user","error_user","visual_user"};
     	
		Random rand = new Random ();
		

	@BeforeTest
	public void mySetup () {
		
		driver.manage().window().maximize();
		
	}
	
	@Test (enabled = true )
	public void loginUsingDifferentUserNames () {
		
		
		
		System.out.println(rand.nextInt(UserNames.length));
		
		driver.get("https://www.saucedemo.com/");
		WebElement UserNamesInputField = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		WebElement PasswordInputField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement loginButton =driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		
		
		String theUser = UserNames[rand.nextInt(UserNames.length)] ;
		String commonPassword = "secret_sauce" ;
		
		UserNamesInputField.sendKeys(theUser);
		PasswordInputField.sendKeys(commonPassword);
		
		loginButton.click();
		
		
	   List<WebElement> AddTocartButtons = driver.findElements(By.className("btn_primary"));
	   
	   for (int  i = 0 ; i < AddTocartButtons.size(); i++){
		   
		   AddTocartButtons.get(i).click();	
	   }
		  int expecteditemAsNumber = AddTocartButtons.size();
		  
		 String expecteditemAsText = Integer.toString(expecteditemAsNumber);
		  
		   String actualitem = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a") ). getText() ;
		   
		   
		// int actualitmAsNumber = Integer.parseInt(actualitem);
		  
		  assertEquals(actualitem, expecteditemAsText);
	   }
	
 		
		@Test ()
		public void  thePriceOfTheFirstTwoItems () {
			
		List<WebElement> Prices = driver.findElements(By.className("inventory_item_price"));
			
			for (int i = 0 ; i < Prices.size();i++) {
				
			String first_item_price = Prices.get(0).getText().replace("$", "");
			String second_item_price = Prices.get(1).getText().replace("$","");

			double PriceOne = Double.parseDouble(first_item_price);
			double PriceTwo = Double.parseDouble(second_item_price);

			double Actualprice = PriceOne + PriceTwo ;
			double expectedprice = 39.98 ;
			
			assertEquals(Actualprice, expectedprice);
			}
			
		}
		
		
	
	} 
	


	


