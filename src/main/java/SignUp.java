import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUp {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
	
	String url = "https://trulyfreehome.dev/";
	WebDriver driver;
    public SignUp(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToSignUpPage() {
        if (!driver.getCurrentUrl().equals(this.url)) {
            driver.get(this.url);
        }
    }
	
	 public Boolean registerUser(String userCountry,String userMobNo, String userFirstName, String userLastName, String userEmail, Boolean makeUsernameDynamic)
	            throws InterruptedException {		 
			
		     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		     WebElement signMe = driver.findElement(By.xpath("//button[contains(text(),'Sign Me')]"));
		     signMe.click();
		     WebElement dropdownCountry = driver.findElement(By.cssSelector(".selected-flag"));
		     dropdownCountry.click();
		     List<WebElement> countries = driver.findElements(By.cssSelector("ul[class=\"country-list\"] li"));
		     for(WebElement c : countries) {
		    	 if(c.getText().contains(userCountry)) {
		    		 c.click();
		    		 break;
		    	 }
		     }
		      String test_data_email;
		        if (makeUsernameDynamic)
		            // Concatenate the timestamp to string to form unique timestamp
		            test_data_email = String.valueOf(java.time.LocalTime.now())+userEmail;
		        else
		            test_data_email = userEmail;
		     WebElement phoneNo = driver.findElement(By.id("regPhoneInput"));
		     phoneNo.sendKeys(userMobNo);
		     
		     WebElement checkbox = driver.findElement(By.cssSelector("input[type=\"checkbox\"]"));
		     checkbox.click();
		     
		     WebElement btnContinue = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		     btnContinue.click();
		     
		     List<WebElement> code = driver.findElements(By.cssSelector(".inputStyle"));
		     for(WebElement c : code) {
		    	 c.sendKeys("1");
		     }
		   
		     WebElement firstName = driver.findElement(By.cssSelector("input[label=\"First Name*\"]"));
		     firstName.sendKeys(userFirstName);
		     
		     WebElement lastName = driver.findElement(By.cssSelector("input[label=\"Last Name*\"]"));
		     lastName.sendKeys(userLastName);
		     
		     WebElement email = driver.findElement(By.name("email"));
		     email.sendKeys(test_data_email.split(":")[2]);
		     
		     Thread.sleep(2000);
		     
		     WebElement done = driver.findElement(By.xpath("//div/button[@type=\"submit\"]"));
		     done.click();
		     
		     WebElement profile = driver.findElement(By.xpath("//div/span[contains(text(),"+userFirstName+")]"));
		     
		     try {
		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		            wait.until(ExpectedConditions.visibilityOf(profile));
		        } catch (TimeoutException e) {
		            return false;
		        }
		 
		 return profile.isDisplayed();
		 
	 }

}
