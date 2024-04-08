package agentside;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import org.junit.AfterClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class address {
    private WebDriver driver;
    @BeforeClass
    public void setup() throws AWTException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://bedrock-agent.netscapelabs.com/");
        System.out.println("Starting setup...");
        
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_R);
		
		rb.keyRelease(KeyEvent.VK_WINDOWS);
		rb.keyRelease(KeyEvent.VK_ALT);
		rb.keyRelease(KeyEvent.VK_R);
    }

	@Test (priority = 1)
	public void emailexist() throws InterruptedException {		
//		rb.keyPress(KeyEvent.VK_ENTER);
		
		WebElement usernameInput = driver.findElement(By.id("formBasicEmail"));
		usernameInput.sendKeys("agent@yopmail.com");

		WebElement passwordInput = driver.findElement(By.id("formBasicPassword"));
		passwordInput.sendKeys("Agent@123");

		WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        Thread.sleep(2000);
        
		WebElement rennovation = driver.findElement(By.xpath("//li[normalize-space()='Renovation']"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        waits.until(ExpectedConditions.elementToBeClickable(rennovation)).click();
        Thread.sleep(2000);
        
		driver.findElement(By.xpath("//p[normalize-space()='Create']")).click();
		Thread.sleep(2000);
        
        WebElement email = driver.findElement(By.id("formBasicPassword"));
        email.sendKeys("sahil@yopmail.com");
        
        WebElement next = driver.findElement(By.xpath("//button[@class='emailbtn btn btn-primary']"));
        next.click();
        Thread.sleep(2000);
        
        
        WebElement Address = driver.findElement(By.xpath("//div[@class='address-head']"));
        Address.click();
        try {
            WebElement location = driver.findElement(By.id("formBasicPassword"));
            location.sendKeys("Dallas");
            Thread.sleep(2000);
            
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(5000);
            // takenscreenshot("emailexist.png");

            Alert alert = driver.switchTo().alert();
            alert.dismiss(); // Or alert.accept() to accept the dialog
            
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll the window vertically by 500 pixels
            js.executeScript("window.scrollBy(0, 500)");

            // Don't forget to switch back to the main window if needed
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            // Handle the uncaught runtime error
            System.out.println("An uncaught runtime error occurred: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging
            // Additional error handling logic can be added here
        }
        
        WebElement city = driver.findElement(By.name("city"));
        if (city != null && city.getAttribute("value").isEmpty()) {
            // Type into the city field only if it's null or empty
            city.sendKeys("Texas");
        }        
        	WebElement zipcode = driver.findElement(By.name("zip_code"));
        	if (zipcode != null && zipcode.getAttribute("value").isEmpty()) {
        		
        		zipcode.sendKeys("180005");
				
			}
        	
            WebDriverWait waitx = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement inputField = waitx.until(ExpectedConditions.visibilityOfElementLocated(By.name("state")));

            // Set value to the input field
            inputField.sendKeys("Texas");
            
        	WebElement construction = driver.findElement(By.xpath("//input[@placeholder='Select date']"));
        	construction.sendKeys("02/2015");
        	
        	WebElement address = driver.findElement(By.id("exampleForm.ControlTextarea1"));
        	address.sendKeys("kjdsfk sd fdkjs fkjs dfj dsfkj dskja fdsjk fdkjs a");
        	
        	driver.findElement(By.xpath("//button[@type='submit']")).click();

        };
	
	@Test(priority = 2)
	public void emailnotexist() throws InterruptedException {
		driver.get("https://bedrock-agent.netscapelabs.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.localStorage.clear();");
		
		WebElement usernameInput = driver.findElement(By.id("formBasicEmail"));
		usernameInput.sendKeys("agent@yopmail.com");

		WebElement passwordInput = driver.findElement(By.id("formBasicPassword"));
		passwordInput.sendKeys("Agent@123");

		WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        Thread.sleep(2000);
        
		WebElement rennovation = driver.findElement(By.xpath("//li[normalize-space()='Renovation']"));
        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        waits.until(ExpectedConditions.elementToBeClickable(rennovation)).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//p[normalize-space()='Create']")).click();
        Thread.sleep(2000);
        
        WebElement email = driver.findElement(By.id("formBasicPassword"));
        email.sendKeys("tim@yopmail.com");
        
        
	      WebElement next = driver.findElement(By.xpath("//button[@class='emailbtn btn btn-primary']"));
	      next.click();
	      Thread.sleep(2000);
        
        WebElement create1 = driver.findElement(By.xpath("//button[normalize-space()='Create Account']"));
        create1.click();
        Thread.sleep(2000);
        
        WebElement first = driver.findElement(By.name("first_name"));
        first.sendKeys("Naman");
        
        WebElement Last = driver.findElement(By.name("last_name"));
        Last.sendKeys("Dutta");
        
        WebElement update = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
        update.click();
        Thread.sleep(2000);
        
        WebElement send = driver.findElement(By.xpath("//button[normalize-space()='Okay']"));
        send.click();
        Thread.sleep(2000);
        
        WebElement Address = driver.findElement(By.xpath("//div[@class='address-head']"));
        Address.click();
        
        try {
            WebElement location = driver.findElement(By.id("formBasicPassword"));
            location.sendKeys("Dallas");
            Thread.sleep(2000);
            
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(5000);
            // takenscreenshot("emailexist.png");

            Alert alert = driver.switchTo().alert();
            alert.dismiss(); // Or alert.accept() to accept the dialog
            
            JavascriptExecutor jss = (JavascriptExecutor) driver;

            // Scroll the window vertically by 500 pixels
            jss.executeScript("window.scrollBy(0, 500)");

            // Don't forget to switch back to the main window if needed
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            // Handle the uncaught runtime error
            System.out.println("An uncaught runtime error occurred: " + e.getMessage());
            e.printStackTrace(); // Print the stack trace for debugging
            // Additional error handling logic can be added here
        }
        
        WebElement city = driver.findElement(By.name("city"));
        if (city != null && city.getAttribute("value").isEmpty()) {
            // Type into the city field only if it's null or empty
            city.sendKeys("Texas");
        }        
        	WebElement zipcode = driver.findElement(By.name("zip_code"));
        	if (zipcode != null && zipcode.getAttribute("value").isEmpty()) {
        		
        		zipcode.sendKeys("180005");
				
			}
        	
            WebDriverWait waitx = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement inputField = waitx.until(ExpectedConditions.visibilityOfElementLocated(By.name("state")));

            // Set value to the input field
            inputField.sendKeys("Texas");
            
        	WebElement construction = driver.findElement(By.xpath("//input[@placeholder='Select date']"));
        	construction.sendKeys("02/2015");
        	
        	WebElement address = driver.findElement(By.id("exampleForm.ControlTextarea1"));
        	address.sendKeys("kjdsfk sd fdkjs fkjs dfj dsfkj dskja fdsjk fdkjs a");
        	
        	driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        
	}
	
	public void takenscreenshot(String filename) {
		if (driver instanceof TakesScreenshot) {
			TakesScreenshot screenshotdriver = (TakesScreenshot) driver;
			
			File screenshotfile = screenshotdriver.getScreenshotAs(OutputType.FILE);
			
			String destinationFilePath = "D:\\\\Inspector\\\\Signup" +filename;
			
            try {
                Files.copy(screenshotfile.toPath(), new File(destinationFilePath).toPath());
                System.out.println("Screenshot saved to: " + destinationFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Driver does not support taking screenshots");
        }
    }
	
	@AfterClass
	
	public void close() throws AWTException {
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_R);
		
		rb.keyRelease(KeyEvent.VK_WINDOWS);
		rb.keyRelease(KeyEvent.VK_ALT);
		rb.keyRelease(KeyEvent.VK_R);
	}
	}