package agentside;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logout {
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
		WebElement elements = waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space()='Logout']")));
		elements.click();
		
		WebDriverWait wai = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement cancel = wai.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Cancel']")));
		cancel.click();
		

}
	}
