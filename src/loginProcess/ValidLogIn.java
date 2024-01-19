package loginProcess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidLogIn {
	
	WebDriver driver =new ChromeDriver();
	String MyURL = "https://www.saucedemo.com/";
	String UserNameInput="standard_user";
	String password="secret_sauce";
	
	

	@BeforeTest 
	public void Setup() {
		driver.manage().window().maximize();
		driver.get(MyURL);
	}
	
	@Test (priority =1)
	public void logInTest () {
	WebElement UserName = driver.findElement(By.id("user-name"));
	WebElement passwordInput =driver.findElement(By.id("password"));
	WebElement logInButten =driver.findElement(By.id("login-button"));
	
	UserName.sendKeys(UserNameInput);
	passwordInput.sendKeys(password);
	logInButten.click();
	
	}
	@Test (priority=2,enabled=false)
	public void AddToCart() {
		WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		addToCart.click();
		
	}
	@Test (priority=3) 
	public void printItems() {
		List<WebElement> addToCart= driver.findElements(By.className("btn"));
		List<WebElement> ItemsName= driver.findElements(By.className("inventory_item_name"));
		List<WebElement> itemPrice= driver.findElements(By.className("inventory_item_price"));

		
		for (int i = 0; i < addToCart.size(); i++) {
		    if (ItemsName.get(i).getText().contains("Backpack") || ItemsName.get(i).getText()
		            .contains("Fleece") || ItemsName.get(i).getText().contains("Onesie")) {
		        String PriceAfterTax = itemPrice.get(i).getText().replace("$", "");
		        double PriceAsDouble = Double.parseDouble(PriceAfterTax);
		        double TaxValue = 0.10;
		        double FinalPrice = PriceAsDouble * TaxValue + PriceAsDouble;
		        if ((int) (FinalPrice / 2) % 2 == 0) {
		            System.out.println("this item " + ItemsName.get(i)
		                    .getText() + " WAS NOT ADDED" + " and the origin price of this item is "
		                    + itemPrice.get(i).getText()
		                    + " the price after tax is an odd number and the value is " + FinalPrice);
		        } else {
		            System.out.println("this item " + ItemsName.get(i)
		                    .getText() + " WAS NOT ADDED" + " and the origin price of this item is "
		                    + itemPrice.get(i).getText()
		                    + " the price after tax is an even number and the value is " + FinalPrice);
		        }
		        continue;
		    } else {
		        String PriceAfterTax = itemPrice.get(i).getText().replace("$", "");
		        double PriceAsDouble = Double.parseDouble(PriceAfterTax);
		        double TaxValue = 0.10;
		        double FinalPrice = PriceAsDouble * TaxValue + PriceAsDouble;
		    
		        addToCart.get(i).click();
		        System.out.println("this item " + ItemsName.get(i).getText()
		                + " was added" + " and the price of this item is " + itemPrice.get(i).getText());
		        if ((int) (FinalPrice / 2) % 2 == 0) {
		            System.out.println("and this number is an Even number");
		        } else {
		            System.out.println("and this number is an ODD number");
		        }
		    }
		}
	}
		
	
	
	@AfterTest 
	public void PostTesting (){
		driver.quit();
	}
	

}
