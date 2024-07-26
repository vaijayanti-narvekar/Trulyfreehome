//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//public class HomePage {
//
//	public static void main(String[] args) throws InterruptedException {
//		// TODO Auto-generated method stub
//		WebDriver driver = new EdgeDriver();
//		driver.manage().window().maximize();
//	     driver.get("https://trulyfreehome.dev/");
//	    
//	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	     WebElement signMe = driver.findElement(By.xpath("//button[contains(text(),'Sign Me')]"));
//	     signMe.click();
//	     WebElement dropdownCountry = driver.findElement(By.cssSelector(".selected-flag"));
//	     dropdownCountry.click();
//	     List<WebElement> countries = driver.findElements(By.cssSelector("ul[class=\"country-list\"] li"));
//	     for(WebElement c : countries) {
//	    	 if(c.getText().contains("India")) {
//	    		 c.click();
//	    		 break;
//	    	 }
//	     }
//	     
//	     WebElement phoneNo = driver.findElement(By.id("regPhoneInput"));
//	     phoneNo.sendKeys("9172838085");
//	     
//	     WebElement checkbox = driver.findElement(By.cssSelector("input[type=\"checkbox\"]"));
//	     checkbox.click();
//	     
//	     WebElement btnContinue = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
//	     btnContinue.click();
//	     
//	     List<WebElement> code = driver.findElements(By.cssSelector(".inputStyle"));
//	     for(WebElement c : code) {
//	    	 c.sendKeys("1");
//	     }
//	   
//	     WebElement firstName = driver.findElement(By.cssSelector("input[label=\"First Name*\"]"));
//	     firstName.sendKeys("TestFirstName");
//	     
//	     WebElement lastName = driver.findElement(By.cssSelector("input[label=\"Last Name*\"]"));
//	     lastName.sendKeys("TestLastName");
//	     
//	     WebElement email = driver.findElement(By.name("email"));
//	     email.sendKeys("testsample@email.com");
//	     
//	     Thread.sleep(2000);
//	     
//	     WebElement done = driver.findElement(By.xpath("//div/button[@type=\"submit\"]"));
//	     done.click();
//	   
//	}
//
//}
