package firstproject1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddSpecifacItems {

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

	@Test(priority = 2, enabled = false)
	public void AddSpecifacItemBasedOnTheIndex() {

		List<WebElement> AddtocartButtons = driver.findElements(By.className("btn_primary"));

		for (int i = 0; i < AddtocartButtons.size(); i++) {

			// first item

			AddtocartButtons.get(0).click();

			// second item

			AddtocartButtons.get(1).click();

		}

	}

	@Test(priority = 3, enabled = false)
	public void AddSpecifacItemBasedOnTheNameItem() {

		List<WebElement> AddtocartButtons = driver.findElements(By.className("btn_primary"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddtocartButtons.size(); i++) {

			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")) {

				AddtocartButtons.get(i).click();

			}

		}

	}

	@Test(priority = 4 , enabled = false )
	public void AddTwoSpecifacItemBasedOnTheNames() {

		List<WebElement> AddtocartButtons = driver.findElements(By.className("btn_primary"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddtocartButtons.size(); i++) {

			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")
					|| ItemsNames.get(i).getText().contains("Sauce Labs Bolt T-Shirt")) {

				AddtocartButtons.get(i).click();

			}

		}

	}
	@Test(priority = 5 , enabled = false  )
	public void AddAllItemsExceptForOneItemOrTwo() {

		List<WebElement> AddtocartButtons = driver.findElements(By.className("btn_primary"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddtocartButtons.size(); i++) {

			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")
					|| ItemsNames.get(i).getText().contains("Sauce Labs Bolt T-Shirt")) {

				continue ; 
			}
			AddtocartButtons.get(i).click();

		}

	}
	@Test(priority = 6)
	public void AddAllItemAndStopAtOneItem() {

		List<WebElement> AddtocartButtons = driver.findElements(By.className("btn_primary"));
		List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AddtocartButtons.size(); i++) {

			if (ItemsNames.get(i).getText().contains("Sauce Labs Fleece Jacket")) {

				break ; 
			}
			AddtocartButtons.get(i).click();

		}

	}

}
