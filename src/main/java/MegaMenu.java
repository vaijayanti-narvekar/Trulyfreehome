import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MegaMenu {

	WebDriver driver;
    public MegaMenu(WebDriver driver) {
        this.driver = driver;
    }
    
    public Boolean selectBrand(String brand) {
    	Boolean status = false;
        try {
        	WebElement dropdownBrand = driver.findElement(By.xpath("//div[contains(text(),\"Brands\")]"));
        	dropdownBrand.click();
//        	Actions a = new Actions(driver);
//        	
//        	a.moveToElement(dropdownBrand).build().perform();
//        	WebElement selectBrand = driver.findElement(By.xpath("(//a[contains(@href,"+brand+")])[2]"));
//        	selectBrand.click();
//        	status = driver.getTitle().contains(brand);
//        	
        	 Thread.sleep(2000);
        	 WebElement brandsMenu = driver.findElement(By.xpath("//div[text()='Brands']"));
             brandsMenu.click();
            

             WebElement emaniBrandLink = driver.findElement(By.xpath("//p[text()='Emani']"));
             emaniBrandLink.click();
             Thread.sleep(2000);
             status = driver.getTitle().contains(brand);
        	return status;
        	
        }catch(Exception e){
        	return status;
        }
    }

}
