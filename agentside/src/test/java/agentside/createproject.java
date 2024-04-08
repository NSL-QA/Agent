package agentside;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

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
public class createproject {
    private WebDriver driver;
    @BeforeClass
    public void setup() throws AWTException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://bedrock-agent.netscapelabs.com/");
        System.out.println("Starting setup...");
        
		
//		Robot rb = new Robot();
//		rb.delay(2000);
//		
//		rb.keyPress(KeyEvent.VK_WINDOWS);
//		rb.keyPress(KeyEvent.VK_ALT);
//		rb.keyPress(KeyEvent.VK_R);
//		
//		rb.keyRelease(KeyEvent.VK_WINDOWS);
//		rb.keyRelease(KeyEvent.VK_ALT);
//		rb.keyRelease(KeyEvent.VK_R);
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
        Thread.sleep(4000);
        
        driver.findElement(By.xpath("//button[@class='emailbtn btn btn-primary']")).click();
        Thread.sleep(2000);
        
        
        
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll the window vertically by 500 pixels
        js.executeScript("window.scrollBy(0, 500)");
        
        WebElement check = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[2]/input[1]"));
        WebDriverWait checks = new WebDriverWait(driver, Duration.ofSeconds(10));
        checks.until(ExpectedConditions.elementToBeClickable(check)).click();
        
//        WebElement checkss = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[1]/div[2]/input[2]"));
//        WebDriverWait checksss = new WebDriverWait(driver, Duration.ofSeconds(10));
//        checksss.until(ExpectedConditions.elementToBeClickable(checkss)).click();
        
        WebElement nexts = driver.findElement(By.xpath("//button[@class='emailbtn btn btn-primary']"));
        nexts.click();
        
        driver.findElement(By.name("min_amount")).sendKeys("100");
        driver.findElement(By.name("max_amount")).sendKeys("200");
        
        List<WebElement> passwordInputs = driver.findElements(By.id("dropdown-basic"));

     // First element
     WebElement passwordInputt = passwordInputs.get(0);
     // Second element
     WebElement passwordInputts = passwordInputs.get(1);
     passwordInputts.click();
        driver.findElement(By.xpath("//div[@class='address-dropdown mb-4 show dropdown']//p[1]")).click();
        
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")).click();

        
	}
}
