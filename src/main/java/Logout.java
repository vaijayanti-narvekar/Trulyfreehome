import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout {
	
    WebDriver driver;
    public Logout(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
    
    WebElement profileBox = driver.findElement(By.xpath("//div[@class = 'jsx-1990881828 profile_box']"));

    WebElement logout = driver.findElement(By.xpath("//p[text() = 'Logout']"));

        profileBox.click();
        logout.click();
    }
	
}
