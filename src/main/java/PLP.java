
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PLP {
	
	WebDriver driver;
    public PLP(WebDriver driver) {
        this.driver = driver;
    }
    
	public String printProductDetailsToExcel() throws IOException, InterruptedException {
        // Locate product name and price elements
        List<WebElement> productNames = driver.findElements(By.xpath("//div[@class='jsx-c3ec2b6b129f087d card_content_wrapper pt-0']//child::span[@class='jsx-c3ec2b6b129f087d card_title d-inline-block text-truncate w-100']"));
        List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='jsx-c3ec2b6b129f087d price']"));

	String filePath = "C:\\Users\\meetv\\eclipse-workspace\\Trulyfreehome\\src\\test\\resources\\product_details.xlsx";
	FileInputStream fs = new FileInputStream(filePath);

        // Create an Excel workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.createSheet("Product Details");

        // Write product details to the Excel sheet
        for (int i = 0; i < productNames.size(); i++) {
            XSSFRow row = sheet.createRow(i);
            row.createCell(0).setCellValue(productNames.get(i).getText());
            row.createCell(1).setCellValue(productPrices.get(i).getText());
        }

        // Write the workbook to a file and close resources
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
            fileOut.close();
        } finally {
            workbook.close();
        }

		
	Thread.sleep(3000);										
	WebElement product= driver.findElement(By.xpath("(//div[contains(@class,'itemProductInnerNew')])[1]"));
	String productName = product.getText(); 
	product.click();
	
	return productName;
		 
       
    }
}
