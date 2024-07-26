import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
	WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean getOrderID(String ORDERIDINPUT) {
    List<WebElement> orderIDs = driver.findElements(By.xpath("//div[@class = 'jsx-353953937 orderid']"));

        for (WebElement webElement : orderIDs) {
            if (webElement.equals(ORDERIDINPUT)) {
                return true;
            }
        }
        return false;
    }
}
