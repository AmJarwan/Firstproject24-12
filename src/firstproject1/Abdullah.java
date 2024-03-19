package firstproject1;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Abdullah {
	
	WebDriver driver = new ChromeDriver();
	
	String TheURL ="https://www.saucedemo.com/";
	String TheCorractUserName = "standard_user"; 
    String TheCorractPassword = "secret_sauce";
	String TheInCorractUserName = "layan"; 
	String TheInCorractPassword = "ilovejava";
	
	@BeforeTest
	public void  preTest () {
		
		driver.manage().window().maximize();
	}
	
	
	 
	@Test(enabled = true , priority = 1)
	public void TestLogin_HappyScenario () {
		
             driver.get(TheURL);
		
		WebElement TheUserNameInput = 	driver.findElement(By.name("user-name"));
		WebElement ThePasswordInput = driver.findElement(By.name("password"));
		WebElement TheLoginButton =   driver.findElement(By.id("login-button"));
		
		
		TheUserNameInput.sendKeys(TheCorractUserName);
		ThePasswordInput .sendKeys(TheCorractPassword);
		TheLoginButton.click();
		
		
        
       
        
	} 
	
	@Test(enabled = false , priority = 2)
	public void TestLogin_SadScenario  () {
		
		driver.get(TheURL);
		
		WebElement TheUserNameInput = 	driver.findElement(By.name("user-name"));
		WebElement ThePasswordInput = driver.findElement(By.name("password"));
		WebElement TheLoginButton =   driver.findElement(By.id("login-button"));
		
		
		TheUserNameInput.sendKeys(TheInCorractUserName);
		ThePasswordInput .sendKeys(TheInCorractPassword);
		TheLoginButton.click();
		
	}
	
	@Test(priority =  3 , enabled = false )
	public void AddtoCarttheincorrectWay() {
		
		
		    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
	        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
	        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
	        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
	        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
	     
		
	}
	
	@Test (priority = 4 , enabled = false)
	
	public void AddtoCartthecorrectWay() throws InterruptedException {
		System.out.println(	driver.findElements(By.className("btn")).size()+ "found in your website");
		
	List<WebElement>AddtocartButtons = 	driver.findElements(By.className("btn_primary"));
	
		
		for(int i =0; i<AddtocartButtons.size();i++) {
			
			AddtocartButtons.get(i).click();
			
			  Thread.sleep(2000) ;
			  
		}
		
		
		
	}
	
	
	@Test (priority = 5 , enabled = false )
	public void printTheNameItmes () {
		
	
		
List<WebElement> TheNameItmes = driver.findElements(By.className("inventory_item_name"));

for(int i =0; i<TheNameItmes.size();i++) {
	
	TheNameItmes.get(i).getText();
	

System.out.println(TheNameItmes.get(i).getText());

		}
	}
		
		@Test(priority = 6 , enabled = false )
		public void AddSpecifacItems() {
			
			List<WebElement> AddToCartItems =  driver.findElements(By.className("btn"));
			
			List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
			System.out.println( ItemsNames .size());
			System.out.println(AddToCartItems.size());
			
			for(int i = 0 ; i < AddToCartItems.size(); i++) {
				
				if(ItemsNames .get(i).getText().contains("Sauce Labs Onesie")) {
					
					continue ;
				}
				
				
				AddToCartItems.get(i).click();
				
				
				
			}
			
			
		}
	
		@Test (priority =  7 )
		public void  AddRandomITem () {
			
			Random rand = new Random() ; 
			int RandomIndexIlove = rand.nextInt(6) ; 
			
			
			System.out.println(RandomIndexIlove);
			
			
			List<WebElement> AddToCartButtons = driver.findElements(By.className("btn"));
			
			
			for(int i = 0 ; i < AddToCartButtons.size() ; i++) {
				
				AddToCartButtons.get(0).click();
				
				
			}
			
		}
	
	
 	
	@AfterTest
	public void postTesting  () {
		

	 
		
		
	} 

	
}
