package firstproject1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddOddNumberItem {
	
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

	@Test( priority = 1)
	public void LoginTest () {
		
             driver.get(TheURL);
		
		WebElement TheUserNameInput = 	driver.findElement(By.name("user-name"));
		WebElement ThePasswordInput = driver.findElement(By.name("password"));
		WebElement TheLoginButton =   driver.findElement(By.id("login-button"));
		
		
		TheUserNameInput.sendKeys(TheCorractUserName);
		ThePasswordInput .sendKeys(TheCorractPassword);
		
		TheLoginButton.click();
	}
	
	@Test (priority = 2)
	public void AddEnenNumberItems () {
		
		List<WebElement>AddtocartButtons = 	driver.findElements(By.className("btn_primary"));
		
		
	for(int i =0 ; i<AddtocartButtons.size(); i=i+2 ) {
			
			AddtocartButtons.get(i).click();
			
			
	}
	
		
		
		
	}
	
	

}
