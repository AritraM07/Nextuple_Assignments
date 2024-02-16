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
public class Multiple_checkouts 
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
    public void mul_checkouts()
    {
    	driver.get("https://magento.softwaretestingboard.com/");
    	driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
    	
    	WebElement email = driver.findElement(By.id("email"));
        WebElement pwd = driver.findElement(By.id("pass"));
        
        email.sendKeys("Jon.Snow@example.com");
        pwd.sendKeys("f@Z3!234");
        
        WebElement Signin = driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]"));
        Signin.click();
        
        
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
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//span[normalize-space()='View and Edit Cart']")).click();
        
        try {
            Thread.sleep(1000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //driver.findElement(By.xpath("//span[normalize-space()='View and Edit Cart']")).click();
        
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        /*
        WebElement link = driver.findElement(By.xpath("//a[@title='Edit item parameters']"));
        Actions actions1 = new Actions(driver);
        
        actions1.moveToElement(link).perform();
        */
        //driver.findElement(By.xpath("//a[@class='action showcart']")).click();
        
        //Next 3 lines will help me to scroll to the multiple checkout link
        WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Check Out with Multiple Addresses']"));

        // Cast driver object to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll into view the element
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        
        driver.findElement(By.xpath("//span[normalize-space()='Check Out with Multiple Addresses']")).click();
	
    }
    
    
    
    
    
}    
