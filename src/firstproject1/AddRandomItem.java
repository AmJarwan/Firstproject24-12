package firstproject1;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddRandomItem {

	WebDriver driver = new ChromeDriver();

	String TheURL = "https://www.saucedemo.com/";
	String TheCorractUserName = "standard_user";
	String TheCorractPassword = "secret_sauce";
	String TheInCorractUserName = "layan";
	String TheInCorractPassword = "ilovejava";

	@BeforeTest
	public void preTest() {

		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void LoginTest() {

		driver.get(TheURL);

		WebElement TheUserNameInput = driver.findElement(By.name("user-name"));
		WebElement ThePasswordInput = driver.findElement(By.name("password"));
		WebElement TheLoginButton = driver.findElement(By.id("login-button"));

		TheUserNameInput.sendKeys(TheCorractUserName);
		ThePasswordInput.sendKeys(TheCorractPassword);
		TheLoginButton.click();
	}

	@Test(priority = 2)
	public void AddRandomItems() {
		
	
		// first we generate something called from class Random

		Random rand = new Random();

		// number (6) is the number that will not be taken as random so the range is 0-5
		
		int myRandomIndex = rand.nextInt(6);
		
		//you can keep printing this so you can see each time a random number between 0-5
		System.out.println(myRandomIndex);
		
		List<WebElement>AddtocartButtons = 	driver.findElements(By.className("btn_primary"));

		for(int i =0; i<AddtocartButtons.size();i++) {
			
			AddtocartButtons.get(myRandomIndex).click();
	}
}
}
