package Automation;

import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium 
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

    @Test(priority = 1)
    public void testSignup() {
        // Navigate to the registration page
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        
        // Fill out the form
        WebElement firstName = driver.findElement(By.id("firstname"));
        WebElement lastName = driver.findElement(By.id("lastname"));
        WebElement email = driver.findElement(By.id("email_address"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
        
        String fn =  "Stewart26";
        String ln = "Wilkins";
        String emailValue = fn.toLowerCase() + "." + ln.toLowerCase() + "@example.com";
        firstName.sendKeys(fn);
        lastName.sendKeys(ln);
        email.sendKeys(emailValue);
        password.sendKeys("f@Z3!234");
        confirmPassword.sendKeys("f@Z3!234");
        
        // Click on the 'Create an Account' button
        WebElement createAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account']"));
        createAccountButton.click();
        
       
        
        // Assertion to verify that the signup was successful
        // This should be replaced with an appropriate success message or element check
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement successMessage = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));

        // Assertion to verify that the signup was successful
        String expectedMessage = "Thank you for registering with Main Website Store.";
        String actualMessage = successMessage.getText();
        String expectedName = fn + " " + ln;
        
        //Scroll Down
        WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Contact Information']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        
        String actualName = driver.findElement(By.xpath("//p[contains(text(),'Stewart26')]")).getText();
        System.out.println(actualName);
        //Assert.assertTrue(actualMessage.contains(expectedMessage), "The success message was not as expected.");
        Assert.assertTrue(actualName.contains(expectedName), "The name is wrong.");
        
        
        //Signout
        
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")).click();
        
        //Signin
        
        try {
            Thread.sleep(6000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
    	
    	WebElement mail = driver.findElement(By.id("email"));
        WebElement pwd = driver.findElement(By.id("pass"));
        
        mail.sendKeys(emailValue);
        pwd.sendKeys("f@Z3!234");
        
        WebElement Signin = driver.findElement(By.xpath("//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]"));
        Signin.click();
        
        //Validate Sign in
        
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
             
        WebElement WelComeElement = driver.findElement(By.xpath("//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Stewart26 Wilkins!']"));
        String messagefound = WelComeElement.getText();
        String requiredMessage = "Welcome, Stewart26 Wilkins!";
        Assert.assertTrue(messagefound.contains(requiredMessage), "The success message was not as expected.");
        
        
        
        // Add 2 items to wishlist
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
        
        //Validate addition to wishlist
        WebElement element1 = driver.findElement(By.xpath("//a[@title='Argus All-Weather Tank'][normalize-space()='Argus All-Weather Tank']"));
        // Cast driver object to JavascriptExecutor
        JavascriptExecutor js1 = (JavascriptExecutor) driver;

        // Scroll into view the element
        js1.executeScript("arguments[0].scrollIntoView(true);", element1);
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        WebElement link1 = driver.findElement(By.xpath("//a[@title='Argus All-Weather Tank'][normalize-space()='Argus All-Weather Tank']"));
        Assert.assertTrue(link1.isDisplayed(), "Link is not displayed.");
        
        WebElement link2 = driver.findElement(By.xpath("//a[@title='Hero Hoodie'][normalize-space()='Hero Hoodie']"));
        Assert.assertTrue(link2.isDisplayed(), "Link is not displayed.");
        
        
//Edit Wishlist
        
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Next line deletes hero hoodie from Left dialogue box
        driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[2]//div[2]//a[1]")).click();
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement element2 = driver.findElement(By.xpath("//a[@title='Argus All-Weather Tank'][normalize-space()='Argus All-Weather Tank']"));
        // Cast driver object to JavascriptExecutor
        JavascriptExecutor js2 = (JavascriptExecutor) driver;

        // Scroll into view the element
        js2.executeScript("arguments[0].scrollIntoView(true);", element2);
        
        //Validate deletion of hero hoodie
        
        try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
        
        boolean elementPresent;
        try {
            WebElement link_deleted = driver.findElement(By.xpath("//a[@title='Hero Hoodie'][normalize-space()='Hero Hoodie']"));
            elementPresent = link_deleted.isDisplayed();
        } catch (NoSuchElementException e) {
            elementPresent = false;
        }
        Assert.assertFalse(elementPresent, "Link is unexpectedly displayed.");
        
        
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
        driver.findElement(By.xpath("//textarea[@title='Comment']")).sendKeys("Good"); //Adds comment to Tank
        
        
    }
 //40, 75, 122, 124
}
