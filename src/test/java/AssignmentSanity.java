
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class AssignmentSanity {
	
	static String firstName = "TestFirst";
	static String lastName = "TestLast";
	static String mobNo = "9876543870";
	static String email ="testsample@email.com";
    static String country = "India";
    static String address = "24th Battery PI";
    static String zip ="10004";
    static WebDriver driver;
    
    @BeforeSuite
	public static WebDriver createDriver() throws MalformedURLException {
     
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }
	
	public static void logStatus(String type, String message, String status) {

	        System.out.println(String.format("%s |  %s  |  %s | %s", String.valueOf(java.time.LocalDateTime.now()), type,
	                message, status));
	 }
	 
	@Test(priority=1,description = "Verify Sign Up")
	public static void TestCase01() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	       
	        logStatus("Start TestCase", "Test Case 1: Verify Sign Up", "DONE");

	        // Visit the Registration page and register a new user
	        SignUp signup = new SignUp(driver);
	        signup.navigateToSignUpPage();
	        signup.registerUser(country,mobNo, firstName, lastName, email,true);
	     }
	 
	@Test(priority=2,description = "Select Brand")
	 public static void TestCase02() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        logStatus("Start TestCase", "Test Case 2: Select Brand", "DONE");

	        MegaMenu megamenu = new MegaMenu(driver);
	        
	        megamenu.selectBrand("Emani");
	       
	    }
	 
	@Test(priority=3,description = "Print Product Names")
	 public static void TestCase03() throws InterruptedException, IOException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        logStatus("Start TestCase", "Test Case 3: Print Product Names", "DONE");

	        PLP plp = new PLP(driver);
	        
	        plp.printProductDetailsToExcel();

	    }
	
	@Test(priority=4,description = "Navigate to product Details Page")
	 public static void TestCase04() throws InterruptedException, IOException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        
	        logStatus("Start TestCase", "Test Case 4: Navigate to product Details Page", "DONE");

	        PDP pdp = new PDP(driver);
	        pdp.checkProductDetails(Integer.toString(2));
	        
	    }
	 
	@Test(priority=5,description = "Verify product details on Cartpage")
	 public static void TestCase05() throws InterruptedException, IOException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        
	        logStatus("Start TestCase", "Test Case 5: Verify product details on Cartpage", "DONE");

	        CartPage cartpage = new CartPage(driver);
	        cartpage.isProductDetailsCorrect();
	        
	      }
	
	@Test(priority=6,description = "Checkout and fill the details")
	 public static void TestCase06() throws InterruptedException, IOException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        
	        logStatus("Start TestCase", "Test Case 6: Checkout and fill the details", "DONE");

	        Checkout checkout = new Checkout(driver);
	        checkout.fillDetails(firstName, lastName, mobNo, address, zip);
    }

	@Test(priority=7,description = "Place Order")
	 public static void TestCase07() throws InterruptedException {
		 
		logStatus("Start TestCase", "Test Case 7: Place Order", "DONE");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 String fullname = firstName+" "+lastName;
		 String cardnumber ="4242 4242 4242 4242"; 
		 String cvv ="111";
		 String month = "05";
		 String year = "2026";
	        
	        

	        PlaceOrder placeorder = new PlaceOrder(driver);
	        placeorder.fillCardDetails(fullname, cardnumber, cvv, month, year);
	                      
 	    }
	 
	@Test(priority=8,description = "Logout")
	public static void TestCase08() throws InterruptedException {
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  logStatus("TestCase", "Test Case 8: Logout", "DONE");

	       Logout logout = new Logout(driver);
	       logout.logout();
	                      
 	    }
	
	 @AfterSuite
	    public void closeDriver() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

}
