package Automation;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Selenium2 
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
        
        email.sendKeys("harv5.spec@example.com");
        pwd.sendKeys("f@Z3!234");
        
        WebElement Signin = driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]"));
        Signin.click();
        
        try {
            Thread.sleep(15000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
       
        
        WebElement WelComeElement = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Harvey Spectre!']"));
        String messagefound = WelComeElement.getText();
        String requiredMessage = "Welcome, Harvey Spectre!";
        Assert.assertTrue(messagefound.contains(requiredMessage), "The success message was not as expected.");
        
       
        
     
    }
    
    
}
