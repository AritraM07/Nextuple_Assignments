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


public class Compare_List 
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
    public void compare()
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
        
        
        driver.findElement(By.xpath("//a[@title='Fusion Backpack']")).click();
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        String actualSKU1 = driver.findElement(By.xpath("//div[@itemprop='sku']")).getText();
        System.out.println(actualSKU1);
        
        driver.findElement(By.xpath("//span[normalize-space()='Add to Compare']")).click();
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//a[@aria-label='store logo']//img")).click();
        
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//a[@title='Push It Messenger Bag']")).click();
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String actualSKU2 = driver.findElement(By.xpath("//div[@itemprop='sku']")).getText();
        System.out.println(actualSKU2);
        
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//span[normalize-space()='Add to Compare']")).click();
        
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//a[@title='Compare Products']")).click();
        
        List<WebElement> productElements = driver.findElements(By.cssSelector("td.cell.product.info"));

        // Print the number of products
        System.out.println("There are " + productElements.size() + " products.");
        
        
        WebElement link1 = driver.findElement(By.xpath("//a[normalize-space()='Fusion Backpack']"));
        Assert.assertTrue(link1.isDisplayed(), "Link is not displayed.");
        
        WebElement link2 = driver.findElement(By.xpath("//a[normalize-space()='Push It Messenger Bag']"));
        Assert.assertTrue(link2.isDisplayed(), "Link is not displayed.");
        
        WebElement element1 = driver.findElement(By.xpath("//a[normalize-space()='Fusion Backpack']"));
        // Cast driver object to JavascriptExecutor
        JavascriptExecutor js1 = (JavascriptExecutor) driver;

        // Scroll into view the element
        js1.executeScript("arguments[0].scrollIntoView(true);", element1);
        
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        // SKU Comparison
        String Selenium_SKU1 = driver.findElement(By.xpath("(//td[@class='cell product attribute']/div[@class='attribute value'])[1]")).getText();
        String Selenium_SKU2 = driver.findElement(By.xpath("(//td[@class='cell product attribute']/div[@class='attribute value'])[2]")).getText();

        Assert.assertTrue(actualSKU1.contains(Selenium_SKU1), "The success message was not as expected.");
        Assert.assertTrue(actualSKU2.contains(Selenium_SKU2), "The success message was not as expected.");
    }
}
