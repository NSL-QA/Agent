package agentside;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;


@Test
public class signup {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://bedrock-agent.netscapelabs.com/");
        driver.findElement(By.xpath("//span[normalize-space()='Sign up']")).click();
    }
    
    @Test

    public void testSignUpWithOTP() {
        // Your implementation to fill in valid details
        WebElement usernameInput = driver.findElement(By.id("validationFormikFirstName"));
        usernameInput.sendKeys("valid");
        WebElement usernamelast = driver.findElement(By.id("validationFormikLastName"));
        usernamelast.sendKeys("info");

        WebElement emailInput = driver.findElement(By.id("validationFormikEmail"));
        emailInput.sendKeys("valid@yopmail.com");
        
        WebElement phone = driver.findElement(By.id("validationFormikPhoneNumber"));
        phone.sendKeys("87878787686464");

//        WebElement passwordInput = driver.findElement(By.id("formBasicPassword"));
//        passwordInput.sendKeys("Password@123");
//        
//        WebElement passwordInputt = driver.findElement(By.id("formBasicPassword"));
//        passwordInputt.sendKeys("Password@123");
        
        List<WebElement> passwordInputs = driver.findElements(By.id("formBasicPassword"));

     // First element
     WebElement passwordInput = passwordInputs.get(0);
     passwordInput.sendKeys("Password@123");

     // Second element
     WebElement passwordInputt = passwordInputs.get(1);
     passwordInputt.sendKeys("Password@123");
        
        WebElement checkbox = driver.findElement(By.id("myCheckbox"));
        checkbox.click();
        
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Scroll down by a specific pixel value (e.g., 500 pixels)
        jsExecutor.executeScript("window.scrollBy(0,500)");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Attempting to locate and click the submit button...");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Next')]")));
        System.out.println("Submit button located and clicked successfully.");

        submitButton.click();
        
        System.out.println("Clicked");
        
        WebElement state = driver.findElement(By.id("formBasicPassword"));
        state.sendKeys("tgfjjasdasdf");
        System.out.println("Enter successfully");
        WebElement number = driver.findElement(By.xpath("//div[@class='mb-5']//input[@id='formBasicPassword']"));
        number.sendKeys("878744546");
        System.out.println("Entered number successfully");
        
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Sign Up']"));
        button.click();
        
//        Actions actions = new Actions(driver);
//        actions.moveToElement(submitButton).click().perform();
        // Simulate receiving OTP via email
        // In a real scenario, you might need to interact with external services or APIs
        String receivedOTP = "123456"; // Replace with the actual OTP

        WebElement otpInput = driver.findElement(By.xpath("//input[@aria-label='Please enter OTP character 1']"));        
        otpInput.sendKeys(receivedOTP);

        WebElement verifyButton = driver.findElement(By.id("verifyBtn"));
        verifyButton.click();

    }
//
//    public void testSignIn() {
//        // Your implementation to fill in valid credentials
//        WebElement usernameInput = driver.findElement(By.id("username"));
//        usernameInput.sendKeys("validUsername");
//
//        WebElement passwordInput = driver.findElement(By.id("password"));
//        passwordInput.sendKeys("ValidPassword123");
//
//        WebElement signInButton = driver.findElement(By.id("signInBtn"));
//        signInButton.click();
//
//        // Assuming successful sign-in redirects to a dashboard page
//        String actualUrl = driver.getCurrentUrl();
//        Assert.assertEquals(actualUrl, "https://example.com/dashboard");
//    }
//
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
