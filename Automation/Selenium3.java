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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium3 
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
    public void testSignin()
    {
    	driver.get("https://magento.softwaretestingboard.com/");
    	driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
    	
    	WebElement email = driver.findElement(By.id("email"));
        WebElement pwd = driver.findElement(By.id("pass"));
        
        email.sendKeys("harvey1.spectre@example.com");
        pwd.sendKeys("f@Z3!234");
        
        WebElement Signin = driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]"));
        Signin.click();
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        driver.findElement(By.xpath("//a[@title='Argus All-Weather Tank']")).click();
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//div[@class='product-addto-links']//span[contains(text(),'Add to Wish List')]")).click();
        
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//a[@aria-label='store logo']//img")).click();
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//a[@title='Hero Hoodie']")).click();
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//div[@class='product-addto-links']//span[contains(text(),'Add to Wish List')]")).click();
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        
        
        
     // Locate the <ol> element
        WebElement olElement = driver.findElement(By.cssSelector("ol.product-items"));

        // Find all the <li> elements within the <ol>
        List<WebElement> liElements = olElement.findElements(By.tagName("li"));

        // Check the size of the list of <li> elements
        int numberOfItems = liElements.size();

        // Verify that there are exactly 2 <li> elements
        Assert.assertEquals(numberOfItems, 2, "There are not exactly two elements inside the <ol class='product-items'> tag");
        
       // Check the two items are present in wishlist
        WebElement link1 = driver.findElement(By.xpath("//a[@title='Argus All-Weather Tank'][normalize-space()='Argus All-Weather Tank']"));
        Assert.assertTrue(link1.isDisplayed(), "Link is not displayed.");
        
        WebElement link2 = driver.findElement(By.xpath("//a[@title='Hero Hoodie'][normalize-space()='Hero Hoodie']"));
        Assert.assertTrue(link2.isDisplayed(), "Link is not displayed.");
        
        //Edit Wishlist
        
        driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[2]//div[2]//a[1]")).click();
        
        
        WebElement productElement = driver.findElement(By.xpath("//div[@data-container='product-grid']//img[@alt='Argus All-Weather Tank']"));
        
        
        Actions actions = new Actions(driver);
        
        // Hover over the product to make the trash icon visible
        actions.moveToElement(productElement).perform();
        
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        //driver.findElement(By.xpath("//a[@title='Remove Item']")).click(); //Removes Tank
        driver.findElement(By.xpath("//textarea[@title='Comment']")).sendKeys("Good");
        
        
        
        /*
        //Hovering
        WebElement productElement = driver.findElement(By.xpath("//div[@data-container='product-grid']//img[@alt='Argus All-Weather Tank']"));
        
        Actions actions = new Actions(driver);
        
        // Hover over the product to make the trash icon visible
        actions.moveToElement(productElement).perform();
        
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        WebElement trash = driver.findElement(By.xpath("//li[@id='item_17245']//a[@title='Remove Item']"));
        Assert.assertTrue(trash.isDisplayed(), "Link is not displayed.");

        driver.findElement(By.xpath("//textarea[@id='product-item-comment-17252']")).sendKeys("Good");
*/
    }
}
