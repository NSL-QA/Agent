	package agentside;

import java.time.Duration;

import javax.interceptor.Interceptor.Priority;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
public  class signin {
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

		Assert.assertEquals(driver.getCurrentUrl(), "https://bedrock-agent.netscapelabs.com/");
		System.out.println("Starting setup...");
		Thread.sleep(5000);

	}

	@Test
	public void testInvalidLogin() throws InterruptedException {
		WebElement usernameInput = driver.findElement(By.id("formBasicEmail"));
		usernameInput.sendKeys("mannual@yopmail.com");

		WebElement passwordInput = driver.findElement(By.id("formBasicPassword"));
		passwordInput.sendKeys("invalid_password");

		WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
		loginButton.click();

		WebElement errorMessage = driver.findElement(By.id("error-message"));
		Assert.assertTrue(errorMessage.isDisplayed());
		System.out.println("Starting setup...");
		Thread.sleep(5000);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}