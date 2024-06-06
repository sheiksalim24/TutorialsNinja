package search;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchFunctionality {
	WebDriver driver;
	String baseUrl = "https://tutorialsninja.com/demo/index.php?route=common/home";

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void searchExistingProduct() throws InterruptedException {
		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Imac");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(3000);

		String expectedSearchUrl = "https://tutorialsninja.com/demo/index.php?route=product/search&search=Imac";
		String actualSearchUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedSearchUrl, actualSearchUrl);

		WebElement searchPageHeading = driver.findElement(By.xpath("//a[text()='Search']"));

		if (searchPageHeading.isDisplayed()) {
			System.out.println("searchPageHeading Is Display");
		} else {
			System.out.println("Search Page heading is not displayed");
		}

	}

	@Test(priority = 2)
	public void searchNonExistingProduct() throws InterruptedException {
		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Fitib");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(3000);

		WebElement errorMessageForNonsearchProduct = driver
				.findElement(By.xpath("//p[contains(text(),'There is no product that matches')]"));
		errorMessageForNonsearchProduct.getText();

		if (errorMessageForNonsearchProduct.isDisplayed()) {
			System.out.println("Error Message is displayed for non exosting search product");
		} else {
			System.out.println("Error message is not displayed");
		}

	}

	@Test(priority = 3)
	public void wthoutProvidingSearchField() throws InterruptedException {
		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(3000);

		WebElement errorMessageForNonsearchProduct = driver
				.findElement(By.xpath("//p[contains(text(),'There is no product that matches')]"));
		errorMessageForNonsearchProduct.getText();

		if (errorMessageForNonsearchProduct.isDisplayed()) {
			System.out.println("There is no product error message is displayed");
		} else {
			System.out.println("Error message is not displayed");
		}
	}

	@Test(priority = 4)
	public void serachProductAfetrLogin() throws InterruptedException {
		driver.navigate().to(baseUrl);

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();

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

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Imac");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(3000);

		String expectedSearchUrl = "https://tutorialsninja.com/demo/index.php?route=product/search&search=Imac";
		String actualSearchUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedSearchUrl, actualSearchUrl);

		WebElement searchPageHeading = driver.findElement(By.xpath("//a[text()='Search']"));

		if (searchPageHeading.isDisplayed()) {
			System.out.println("searchPageHeading Is Display");
		} else {
			System.out.println("Search Page heading is not displayed");
		}

	}

	@Test(priority = 5)
	public void checkSearchBoxPlaceHoledrs() throws InterruptedException {
		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(3000);

		WebElement searchPlaceHoledr = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		String placeHoledrtext = searchPlaceHoledr.getAttribute("placeholder");
		System.out.println(placeHoledrtext);

		if (placeHoledrtext != null && !placeHoledrtext.isEmpty()) {
			System.out.println("Search Placehoder is displayed" + " " + placeHoledrtext);
		} else {
			System.out.println("Search Placehoder is not displayed");
		}

		WebElement searchCriteriaPlaceHoledr = driver.findElement(By.xpath("//input[@id='input-search']"));
		String placeHolder2 = searchCriteriaPlaceHoledr.getAttribute("placeholder");

		if (placeHolder2 != null && !placeHolder2.isEmpty()) {
			System.out.println("Search Criteria Placehoder is displayed" + " " + placeHolder2);
		} else {
			System.out.println("Search Criteria is not displayed");
		}

	}

	@Test(priority = 6)
	public void searchProductUsingSearchCriteriaField() throws InterruptedException 
	{
		driver.navigate().to(baseUrl);

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Login']")).click();

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
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		driver.findElement(By.xpath("//input[@id='input-search']")).sendKeys("Imac");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='button-search']")).click();
		
		String expetedUrl = "https://tutorialsninja.com/demo/index.php?route=product/search&search=Imac";
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		Assert.assertEquals(expetedUrl, actualUrl);
		System.out.println("Search Criteria Test is Passed");

	}

	@Test(priority = 6)
	public void selectWrongCatagoriSearchDropDown() throws InterruptedException
	{
		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Imac");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(3000);

		String expectedSearchUrl = "https://tutorialsninja.com/demo/index.php?route=product/search&search=Imac";
		String actualSearchUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedSearchUrl, actualSearchUrl);
		
		driver.findElement(By.id("input-search")).sendKeys("Imac");
		WebElement searchCatagory = driver.findElement(By.xpath("//select[@name='category_id']"));
		
		Select s = new Select(searchCatagory);
		s.selectByValue("46");
	}
}
