import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
        this.driver = driver;
    }
	
	public Boolean isProductDetailsCorrect() {
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		Boolean status;
		WebElement cartel = driver.findElement(By.xpath("//li[@title = 'Cart']"));
	    cartel.click();
	      
	    WebElement totalprice = driver.findElement(By.xpath("//span[@class = 'total_price']"));

	   status = totalprice.isDisplayed() ;
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text() = 'Proceed to Checkout'])[1]")));
	   WebElement proceedCheckout = driver.findElement(By.xpath("//a[text() = 'Proceed to Checkout'])[1]"));
	
	   proceedCheckout.click();
	  
	  return status;
		
    }
    
	
	
	
	

}
