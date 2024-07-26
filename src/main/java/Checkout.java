import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout {

	WebDriver driver;
	
    public Checkout(WebDriver driver) {
        this.driver = driver;
    }
    
    public void fillDetails(String firstname, String lastname, String number, String address, String zipcode) {    
    WebElement firstName = driver.findElement(By.xpath("//input[@name = \"firstName\"]"));   
    
    WebElement lastName = driver.findElement(By.xpath("//input[@name = \"lastName\"]"));

    
    WebElement phone = driver.findElement(By.id("regPhoneInput"));

    
    WebElement addressel = driver.findElement(By.xpath("//input[@placeholder = 'Enter address']"));

    
    WebElement pincode = driver.findElement(By.xpath("//input[@placeholder = 'Enter zip code']"));

    
    WebElement continuebutton = driver.findElement(By.xpath("//button[text() = 'Continue']"));

      
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        phone.sendKeys(number);
        addressel.sendKeys(address);
        pincode.sendKeys(zipcode);
        continuebutton.click();
    }
    
	
}
