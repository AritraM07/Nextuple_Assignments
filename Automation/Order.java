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



public class Order 
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
    public void order()
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
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        WebElement productElement = driver.findElement(By.xpath("//img[@alt='Breathe-Easy Tank']"));
        Actions actions = new Actions(driver);
        
        actions.moveToElement(productElement).perform();
        
        
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("(//li[contains(@class, 'product-item')])[2]//div[@role='option' and @aria-label='M']")).click();
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("(//li[contains(@class, 'product-item')])[2]//div[@aria-label='Purple']")).click();
        driver.findElement(By.xpath("//li[2]//div[1]//div[1]//div[4]//div[1]//div[1]//form[1]//button[1]//span[1]")).click();
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//a[@class='action showcart']")).click();
        
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        
        driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click();
        
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
     // Setting up the WebDriver with an implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Wait for up to 5 seconds before throwing an exception

        // Find the first element and send keys if it's available
        /*
        WebElement companyInput = driver.findElement(By.xpath("(//input[@name='company'])"));
        if (companyInput.isDisplayed()) 
        {
            companyInput.sendKeys("CityRoad");

            // Since implicit waits are set, no need for Thread.sleep()
            driver.findElement(By.xpath("//input[@name='street[0]']")).sendKeys("Chumash Road");
            
            driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Los Santos");
            
            // Selecting an option from a dropdown
            Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='region_id']")));
            dropdown.selectByVisibleText("California");
            
            driver.findElement(By.xpath("//input[@name = 'postcode']")).sendKeys("12345");
            
            driver.findElement(By.xpath("//input[@name = 'telephone']")).sendKeys("56419034578");
            
            driver.findElement(By.xpath("//input[@value='flatrate_flatrate']")).click();
            
            // Clicking the continue button to proceed
            driver.findElement(By.xpath("//button[@data-role='opc-continue']")).click();
        }
        */
        
        	driver.findElement(By.xpath("//td[contains(normalize-space(),'Fixed')]")).click();
        	driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
        	
        	//Used to scroll up to the logo image
        	/*
        	WebElement element = driver.findElement(By.xpath("//a[@aria-label='store logo']//img"));

            // Cast driver object to JavascriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll into view the element
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            */
        
        WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Place Order']"));
        // Cast driver object to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll into view the element
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        
        try {
            Thread.sleep(10000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        element.click();
        
        try {
            Thread.sleep(10000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String actual_msg = driver.findElement(By.xpath("//span[@class='base']")).getText();
        String exp_msg = "Thank you for your purchase!";
        String order_no = driver.findElement(By.xpath("//strong[contains(text(),'00')]")).getText();
        System.out.println(order_no);
        Assert.assertTrue(actual_msg.contains(exp_msg), "The success message was not as expected.");
        
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
        
        
        String my_order_no = driver.findElement(By.xpath("//table[@id='my-orders-table']//tbody/tr[1]/td[@class='col id']")).getText();
        System.out.println(my_order_no);
        Assert.assertTrue(order_no.contains(my_order_no), "The order no is wrong");
    }
        
        
        
    }

    

