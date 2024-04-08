package agentside;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
public  class changepassword {
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://bedrock-agent.netscapelabs.com/");
		System.out.println("Starting setup...");
	}

	@Test
	public void testValidLogin() throws InterruptedException {
		WebElement usernameInput = driver.findElement(By.id("formBasicEmail"));
		usernameInput.sendKeys("agent@yopmail.com");

		WebElement passwordInput = driver.findElement(By.id("formBasicPassword"));
		passwordInput.sendKeys("Agent@123");

		WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();

		
		WebDriverWait Wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement element = Wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='dropdown-basic']")));
		element.click();
		
		WebDriverWait waits = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement elements = waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Change Password']")));
		elements.click();
		
//		Change Password
		
		WebElement password = driver.findElement(By.id("formOldPassword"));
		password.sendKeys("Test@123");
		
	     List<WebElement> passwordInputs = driver.findElements(By.id("formNewPassword"));
	
	     // First element
	     WebElement passwordInpute = passwordInputs.get(0);
	     passwordInpute.sendKeys("Password@123");
	
	     // Second element
	     WebElement passwordInputt = passwordInputs.get(1);
	     passwordInputt.sendKeys("Password@123");
	     
	        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

	        // Scroll down by a specific pixel value (e.g., 500 pixels)
	        jsExecutor.executeScript("window.scrollBy(0,500)");
	        
	        WebElement submit = driver.findElement(By.xpath("//button[normalize-space()='Update password']"));
	        submit.click();
	}
}