package Automation;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Validate_Order_My_Account 
{
	private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create instance of WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void validate()
    {
    	driver.get("https://magento.softwaretestingboard.com/");
    	driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
    	
    	WebElement email = driver.findElement(By.id("email"));
        WebElement pwd = driver.findElement(By.id("pass"));
        
        email.sendKeys("Jon.Snow@example.com");
        pwd.sendKeys("f@Z3!234");
        
        WebElement Signin = driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]"));
        Signin.click();
        
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //Select dropdown = new Select(driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")));
        //dropdown.selectByVisibleText("My Account");
        
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']")).click();
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//a[normalize-space()='My Orders']")).click();
        
     // Find the table with orders
        WebElement ordersTable = driver.findElement(By.id("my-orders-table"));

        // Find all rows in the table
        List<WebElement> orderRows = ordersTable.findElements(By.tagName("tr"));

        // This boolean will track if we've found a pending order
        boolean pendingOrderFound = false;

        // Loop through all rows and check the status column
        for (WebElement row : orderRows) {
            // Find all cells in the row
            List<WebElement> cells = row.findElements(By.tagName("td"));
            
            // Assuming status is always in the 5th column (index 4)
            if (cells.size() > 4) {
                WebElement statusCell = cells.get(4);
                if (statusCell.getText().equals("Pending")) {
                    pendingOrderFound = true;
                    break; // Stop the loop if a pending order is found
                }
            }
        }

        // Assert that a pending order was found
        Assert.assertTrue(pendingOrderFound, "No pending orders found.");
        
        
    }
}
