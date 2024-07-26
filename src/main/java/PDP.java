import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PDP {
	WebDriver driver;
	
    public PDP(WebDriver driver) {
        this.driver = driver;
    }
    
    
    public Boolean checkProductDetails(String number) throws InterruptedException {
    	Boolean status ;
//    	Thread.sleep(2000);
//    	WebElement firstProduct = driver.findElement(By.xpath("(//div[contains(@class,'product_item')]//a)[1]"));
//        firstProduct.click();
//        Thread.sleep(2000);

//        WebElement productDetails = driver.findElement(By.xpath("//div[contains(@class,'detail_section')]"));
//        status = productDetails.isDisplayed();
//
//        WebElement quantityInput = driver
//                .findElement(By.xpath("//select[contains(@name,'one-time-purchase')]"));
//        Select selectQuantity = new Select(quantityInput);
//        selectQuantity.selectByValue("2");
//       
//
//        WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to Cart']"));
//        addToCartButton.click();
//        
//
//        WebElement cartCount = driver
//                .findElement(By.xpath("//span[@class = 'jsx-1508469962 product_count']"));
//        assertEquals(cartCount.getText(), "2");
//       
//    	
    	WebElement quantityDropdown = driver.findElement(By.xpath("//select"));
        
        WebElement addToCart= driver.findElement(By.xpath("//button[text() = 'Add to Cart']"));

        //("//div[contains(@class,'subscription_option')]"));

        

       
            Select sl = new Select(quantityDropdown);
            sl.selectByVisibleText(number);
            addToCart.click();
            
            
//            WebElement cartCount = driver.findElement(By.xpath("//div//option[@xpath=\"1\"]"));
//        System.out.println(sl.getFirstSelectedOption().getText());
           status = sl.getFirstSelectedOption().getText().equals(number);
        
    	
    	return status;
    	
    	

    
    }
    
}
