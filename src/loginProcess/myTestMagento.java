package loginProcess;

import java.util.List;
import java.util.Random;
import org.testng.Assert;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestMagento {
	WebDriver driver= new ChromeDriver();
	
	String webSite="https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html";
	Random rand =new Random();

	 @BeforeTest
	    public void myBeforeTest() {
	        driver.manage().window().maximize();
	    }
	    @Test(invocationCount = 1)
	    public void myFirstTest() throws InterruptedException {
	        driver.get(webSite);
	        WebElement ItemsContainer = driver.findElement(By.cssSelector(".products.list.items.product-items"));
	        List<WebElement> AllItems = ItemsContainer.findElements(By.tagName("li"));
	        AllItems.get(0).click();
	        Thread.sleep(1000);
	        // assert to check the size
	        WebElement SizesContainer = driver
	                .findElement(By.xpath("//div[@class='swatch-attribute size']//div[@role='listbox']"));
	        List<WebElement> AllSizes = SizesContainer.findElements(By.tagName("div"));
	        int randomSize = rand.nextInt(AllSizes.size());
	        AllSizes.get(randomSize).click();
	        String ExpectedSize = AllSizes.get(randomSize).getText();
	        String ActualSize = driver.findElement(By.cssSelector(".swatch-attribute-selected-option")).getText();
	        Assert.assertEquals(ActualSize, ExpectedSize);

		WebElement colorContaner=driver.findElement(By.cssSelector("div[class='swatch-attribute color'] div[role='listbox']"));
		List<WebElement> AllColors =colorContaner.findElements(By.tagName("div"));
		int randomColor=rand.nextInt(AllColors.size());
		AllColors.get(randomColor).click();
		String ExpectedColor=AllColors.get(randomColor).getAttribute("option-label");
		 String ActualColor=driver.findElement(By.cssSelector(
                 "div[class='swatch-attribute color'] span[class='swatch-attribute-selected-option']")).getText();
		Assert.assertEquals(ActualColor, ExpectedColor);
		
	    WebElement AddtoCartButton = driver.findElement(By.id("product-addtocart-button"));
        AddtoCartButton.click();
        WebElement Msg = driver.findElement(By.id("product-addtocart-button"));
        String ActualMsg = Msg.getText();
        Assert.assertEquals(ActualMsg.contains("added"), true);


	        
	        
	        
		
		
		
		
	}
	
	@AfterTest 
	public void afterTest() {}

	
	

}
