import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlaceOrder {

	
    WebDriver driver;
    public PlaceOrder(WebDriver driver) {
        this.driver = driver;
        
    }

    public void fillCardDetails(String fullname, String cardnumber, String CVV, String MONTH, String YEAR) throws InterruptedException {
    WebElement addCard = driver.findElement(By.xpath("//button[text() = '+Add a new card']"));
    
    addCard.click();
    
    WebElement fullName = driver.findElement(By.id( "full_name"));
    WebElement cardNumber = driver.findElement(By.id("card_number"));
    WebElement cvv = driver.findElement(By.id("cvv"));
    WebElement month = driver.findElement(By.id("month"));
    WebElement year = driver.findElement(By.id("year"));
    WebElement addcard = driver.findElement(By.id("submitbutton"));
    WebElement confirmBtn = driver.findElement(By.id("confirm_btn"));      
        
        fullName.sendKeys(fullname);
        cardNumber.sendKeys(cardnumber);
        cvv.sendKeys(CVV);
        month.sendKeys(MONTH);
        year.sendKeys(YEAR);
        addcard.click();
        confirmBtn.click();
        
        Thread.sleep(2000);

        WebElement orderIdElement = driver.findElement(By.xpath("//span[contains(@class, 'orderNum')]"));
        String orderId = orderIdElement.getText();
        System.out.println("Order ID: " + orderId);
        Thread.sleep(2000);
    }
	
}
