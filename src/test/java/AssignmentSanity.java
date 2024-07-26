import org.openqa.selenium.edge.EdgeDriver;
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
    
    @BeforeSuite
	public static WebDriver createDriver() throws MalformedURLException {
     
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }
	
	public static void logStatus(String type, String message, String status) {

	        System.out.println(String.format("%s |  %s  |  %s | %s", String.valueOf(java.time.LocalDateTime.now()), type,
	                message, status));
	 }
	 
	@Test(priority=1,description = "Verify Sign Up")
	public static void TestCase01(WebDriver driver) throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	       
	        logStatus("Start TestCase", "Test Case 1: Verify Sign Up", "DONE");

	        // Visit the Registration page and register a new user
	        SignUp signup = new SignUp(driver);
	        signup.navigateToSignUpPage();
	        signup.registerUser(country,mobNo, firstName, lastName, email,true);
	     }
	 
	@Test(priority=2,description = "Select Brand")
	 public static void TestCase02(WebDriver driver) throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        logStatus("Start TestCase", "Test Case 2: Select Brand", "DONE");

	        MegaMenu megamenu = new MegaMenu(driver);
	        
	        megamenu.selectBrand("Emani");
	        if (!status) {
	            logStatus("TestCase 2", "Test Case Fail. To select brand Emani", "FAIL");
	            logStatus("End TestCase", "Test Case 2: Select Brand : ", status ? "PASS" : "FAIL");

	            // Return False as the test case Fails
	            return false;
	        } else {
	            logStatus("TestCase 2", "Test Case Pass. Select Brand", "PASS");
	        }
               
	        return status;
	    }
	 
	 
	 public static Boolean TestCase03(WebDriver driver) throws InterruptedException, IOException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        Boolean status;
	        logStatus("Start TestCase", "Test Case 3: Print Product Names", "DONE");

	        PLP plp = new PLP(driver);
	        
	        plp.printProductDetailsToExcel();
//	        if (!status) {
//	            logStatus("TestCase 2", "Test Case Fail. To print Product Names", "FAIL");
//	            logStatus("End TestCase", "Test Case 3: Print Product Names : ", status ? "PASS" : "FAIL");
//
//	            // Return False as the test case Fails
//	            return false;
//	        } else {
//	            logStatus("TestCase 3", "Test Case Pass. Print Product Names", "PASS");
//	        }
//               
	        return true;
	    }
	 
	 public static Boolean TestCase04(WebDriver driver) throws InterruptedException, IOException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        Boolean status;
	        logStatus("Start TestCase", "Test Case 4: Navigate to product Details Page", "DONE");

	        PDP pdp = new PDP(driver);
	        status = pdp.checkProductDetails(Integer.toString(2));
	        
	        if (!status) {
	            logStatus("TestCase 4", "Test Case Fail. Navigate to product Details Page", "FAIL");
	            logStatus("End TestCase", "Test Case 4: Navigate to product Details Page : ", status ? "PASS" : "FAIL");

	            // Return False as the test case Fails
	            return false;
	        } else {
	            logStatus("TestCase 4", "Test Case Pass. Navigate to product Details Page", "PASS");
	        }
	         
	        return status;
	    }
	 
	 
	 public static Boolean TestCase05(WebDriver driver) throws InterruptedException, IOException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        Boolean status;
	        logStatus("Start TestCase", "Test Case 5: Verify product details on Cartpage", "DONE");

	        CartPage cartpage = new CartPage(driver);
	       status =  cartpage.isProductDetailsCorrect();
	        
	       if (!status) {
	            logStatus("TestCase 5", "Test Case Fail. Verify product details on Cartpage", "FAIL");
	            logStatus("End TestCase", "Test Case 4: Verify product details on Cartpage : ", status ? "PASS" : "FAIL");

	            // Return False as the test case Fails
	            return false;
	        } else {
	            logStatus("TestCase 5", "Test Case Pass. Verify product details on Cartpage", "PASS");
	        }
	         
	        return status;
	    }
	 
	 public static Boolean TestCase06(WebDriver driver) throws InterruptedException, IOException {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        Boolean status;
	        logStatus("Start TestCase", "Test Case 6: Checkout and fill the details", "DONE");

	        Checkout checkout = new Checkout(driver);
	        checkout.fillDetails(firstName, lastName, mobNo, address, zip);
	               
 
	        return true;
	    }
	 
	 public static void TestCase07(WebDriver driver) throws InterruptedException {
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 String fullname = firstName+" "+lastName;
		 String cardnumber ="4242 4242 4242 4242"; 
		 String cvv ="111";
		 String month = "05";
		 String year = "2026";
	        
	        logStatus("Start TestCase", "Test Case 7: Place Order", "DONE");

	        PlaceOrder placeorder = new PlaceOrder(driver);
	        placeorder.fillCardDetails(fullname, cardnumber, cvv, month, year);
	                      
 	    }
	 
    public static void TestCase08(WebDriver driver) throws InterruptedException {
		 
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  logStatus("TestCase", "Test Case 8: Logout", "DONE");

	       Logout logout = new Logout(driver);
	       logout.logout();
	                      
 	    }

}
