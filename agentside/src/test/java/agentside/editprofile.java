package agentside;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
public  class editprofile {
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://bedrock-agent.netscapelabs.com/");
		System.out.println("Starting setup...");
	}

	@Test
	//Signing in
	public void testValidLogin() throws InterruptedException, IOException, AWTException {
		WebElement usernameInput = driver.findElement(By.id("formBasicEmail"));
		usernameInput.sendKeys("agent@yopmail.com");

		WebElement passwordInput = driver.findElement(By.id("formBasicPassword"));
		passwordInput.sendKeys("Agent@123");

		WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

		System.out.println("Starting setup...");
		Thread.sleep(2000);
		
		//Navigate to side menu
		
		
		WebElement Aboutus = driver.findElement(By.xpath("//li[normalize-space()='About Us']"));
		Aboutus.click();
		Thread.sleep(2000);
		
		WebElement Privacy = driver.findElement(By.xpath("//li[normalize-space()='Privacy policy']"));
		Privacy.click();
		Thread.sleep(2000);
		
		WebElement terms = driver.findElement(By.xpath("//li[normalize-space()='Terms and Conditions']"));
		terms.click();
		Thread.sleep(2000);
		
		WebElement support = driver.findElement(By.xpath("//li[normalize-space()='Support & Help Center']"));
		support.click();
		Thread.sleep(2000);
		
		//Edit Profile
		
		WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element = Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='dropdown-basic']")));
		element.click();
		
		WebDriverWait Wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement editprofile =  Wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Edit Profile']")));
		editprofile.click();
		Thread.sleep(5000);
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Scroll down by a specific pixel value (e.g., 500 pixels)
        jsExecutor.executeScript("window.scrollBy(0,500)");
		
		WebElement profile = driver.findElement(By.xpath("//div[@class='profile-image']//div[@class='profile-image']"));
		profile.click();
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		StringSelection ss = new StringSelection("C:\\Users\\Kaushal\\Downloads\\Image");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
       WebElement button =  driver.findElement(By.xpath("//button[normalize-space()='Update']"));
       
       button.click();
		
	}
}
