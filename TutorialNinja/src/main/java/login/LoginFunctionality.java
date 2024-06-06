package login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v123.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFunctionality {
	WebDriver driver;
	String baseUrl = "https://tutorialsninja.com/demo/index.php?route=account/login";

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void Closur() {
		driver.quit();
	}

	@Test(priority = 1)
	public void loginWithValidData() throws InterruptedException {
		driver.navigate().to(baseUrl);

		driver.findElement(By.id("input-email")).sendKeys("testsheik@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-password")).sendKeys("8877");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);


		String expectedPageTitle = "My Account";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedPageTitle, actualTitle);
		System.out.println("User got logged in and taken to the 'Account' page");
	}

	@Test(priority = 2)
	public void loginWithInvalidData() throws InterruptedException {
		driver.navigate().to(baseUrl);

		driver.findElement(By.id("input-email")).sendKeys("xyzabc123@gmail.com");
		Thread.sleep(2000);

		driver.findElement(By.id("input-password")).sendKeys("xyzabc123");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);


		String expectedWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert alert')]")).getText();
		String actualWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(expectedWarningMessage, actualWarningMessage);
		System.out.println("Invalid Credentials");

	}

	@Test(priority = 3)
	public void loginWithValidUserNameAndInvalidPwd() throws InterruptedException
	{
		driver.navigate().to(baseUrl);

		driver.findElement(By.id("input-email")).sendKeys("testsheik@gmail.com");
		Thread.sleep(2000);

		driver.findElement(By.id("input-password")).sendKeys("xyzabc123");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

		String expectedWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert alert')]")).getText();
		String actualWarningMessage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(expectedWarningMessage, actualWarningMessage);
		System.out.println("Invalid Password");
		
	}
	
	@Test(priority = 4)
	public void loginWithInvalidUserNameAndValidPwd() throws InterruptedException
	{
		driver.navigate().to(baseUrl);

		driver.findElement(By.id("input-email")).sendKeys("testsheik@gl.com");
		Thread.sleep(2000);

		driver.findElement(By.id("input-password")).sendKeys("8877");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);
		
		String expectedWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert alert')]")).getText();
		String actualWarningMessage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(expectedWarningMessage, actualWarningMessage);
		System.out.println("Invalid Email Address");
	}

	@Test(priority = 5)
	public void loginWithoutCredential() throws InterruptedException
	{
		driver.navigate().to(baseUrl);

		driver.findElement(By.id("input-email")).sendKeys("");
		Thread.sleep(2000);

		driver.findElement(By.id("input-password")).sendKeys("");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(2000);

		String expectedWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert alert')]")).getText();
		String actualWarningMessage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(expectedWarningMessage, actualWarningMessage);
		System.out.println("You Are not Providing Credentials");
	}
	
	@Test(priority = 6)
	public void forgotPassword() throws InterruptedException
	{
		driver.navigate().to(baseUrl);
		
		WebElement forgotPassword = driver.findElement(By.xpath("(//a[text()='Forgotten Password'])[1]"));
		Assert.assertTrue(forgotPassword.isDisplayed());
		
		forgotPassword.click();
		Thread.sleep(2000);
		
		String expectedTitle2="Forgot Your Password?";
		String actualTitle2=driver.getTitle();
		Assert.assertEquals(expectedTitle2, actualTitle2);
		System.out.println("ForGot Password is Displayed and User is taken to Forgot Password Page");
	}
		
	@Test(priority = 7)
	public void loginKeyboardKeys() throws InterruptedException
	{
		driver.navigate().to(baseUrl);
		
		Actions ac = new Actions(driver);
		
		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		
		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();   
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		
		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		
		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();   
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		
		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		
		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();   
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		
		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		
		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);

		ac.sendKeys(Keys.TAB).build().perform();   
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-email")).sendKeys("testsheik@gmail.com");
		
		ac.sendKeys(Keys.TAB).build().perform();   
		Thread.sleep(2000);
		
		driver.findElement(By.id("input-password")).sendKeys("8877");
		
		ac.sendKeys(Keys.TAB).build().perform();   
		Thread.sleep(2000);
		
		ac.sendKeys(Keys.TAB).build().perform();   
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		String expectedPageTitle = "My Account";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedPageTitle, actualTitle);
		System.out.println("Logged In SuccesFully using Keyboard Keys");

		
		
		


		

		
		
	}

	@Test(priority = 8)
	public void checkPlaceHoldersEmailAndPwd()
	{
		driver.navigate().to(baseUrl);
		
		WebElement emailPlaceHolder = driver.findElement(By.xpath("//input[@placeholder='E-Mail Address']"));
		System.out.println(emailPlaceHolder.getText());
		Assert.assertTrue(emailPlaceHolder.isDisplayed());
		
		WebElement passwordPlaceHolder = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		System.out.println(passwordPlaceHolder.getText());
		Assert.assertTrue(passwordPlaceHolder.isDisplayed());
		
		System.out.println("Email And Password PlaceHolders present on the login page");
		
	
	}
}

