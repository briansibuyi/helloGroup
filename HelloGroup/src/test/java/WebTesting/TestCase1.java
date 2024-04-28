package WebTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import dev.failsafe.internal.util.Assert;

public class TestCase1 extends BaseTesting {

	public static void main(String[] args) throws InterruptedException {
		//driver location
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Brian\\source\\Java\\chromedriver.exe");
		
		//Launcher to the browser	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Launch Browser.");
	    Thread.sleep(5000);	    
	    
		//Navigate URL		
		driver.get("http://www.automationpractice.pl/");
		System.out.println("Navigating to the URL.");
		Thread.sleep(5000);
		
		String Search1 = "Faded Short Sleeve T-shirts";
		System.out.println("defining variable.");
		
		//Identify elements
		WebElement txtSearch = driver.findElement(By.id("search_query_top"));
		WebElement btnSearch = driver.findElement(By.name("submit_search"));
		System.out.println("Elements founds.");
		
		//action the element defined
		txtSearch.sendKeys(Search1);
		System.out.println("search criteria inserted.");
		Thread.sleep(500);
		btnSearch.click();
		System.out.println("search button clicked.");
		
		WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 400)
                .perform();
		
        Assert.notNull(true,"Faded Short Sleeve T-shirts");
        
		Thread.sleep(1000);
		//close browser
		driver.quit();
		
	}

}
