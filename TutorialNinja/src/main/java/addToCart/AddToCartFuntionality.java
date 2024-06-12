package addToCart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class AddToCartFuntionality {
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
	public void checkSearchProductDisplay() throws InterruptedException {

		driver.get(baseUrl);

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Imac");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[text()='iMac']")).click();

		String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=product/product&product_id=41&search=Imac";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		System.out.println("Yor are in product display page");

		driver.findElement(By.xpath("//button[text()='Add to Cart']")).click();

		WebElement successMessage = driver.findElement(By.xpath("//div[contains(@class,'alert alert-success')]"));
		System.out.println(successMessage.getText());

		if (successMessage.isDisplayed()) {
			System.out.println("Add Cart Success Message is Displayed");
		} else {
			System.out.println("Add Cart Success Message is Not Displayed");
		}

		driver.findElement(By.xpath("//a[text()='shopping cart']")).click();

		String expectedTitle = "Shopping Cart";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("User got shoping cart page");

	}

	@Test(priority = 2)
	public void checkWhisList() throws InterruptedException {
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

		driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();

		WebElement whishListSuccessMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		String whisListText = whishListSuccessMessage.getText();
		System.out.println(whisListText);

		if (whishListSuccessMessage.isDisplayed()) {
			System.out.println("Yor are added the product on whis list");
		} else {
			System.out.println("Yor are not added the product on whis list");
		}

		driver.findElement(By.xpath("//span[text()='Wish List (1)']")).click();
		driver.findElement(By.xpath("//button[@data-original-title='Add to Cart']")).click();

		WebElement addToCartShopingCart = driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		String shopingCartSuccessText = addToCartShopingCart.getText();
		System.out.println(shopingCartSuccessText);

		if (addToCartShopingCart.isDisplayed()) {
			System.out.println("Shoping cart Success Message is Displayed");
		} else {
			System.out.println("Shoping cart Success Message is not Displayed");
		}
	}

	@Test(priority = 3)
	public void viewAddToCart() throws InterruptedException {
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

		driver.findElement(By.xpath("//span[text()='Add to Cart']//parent::button")).click();
		WebElement addCartSuccessMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
		String successText = addCartSuccessMessage.getText();
		System.out.println(successText);

		if (addCartSuccessMessage.isDisplayed()) {
			System.out.println("Add to cart sucess message is displayed");
		} else {
			System.out.println("Add to cart sucess message is not displayed");
		}

		driver.findElement(By.id("cart-total")).click();

		driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']//parent::strong")).click();

		String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=checkout/cart";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		System.out.println("Yor are in CheckOut Page");

		WebElement productUnavailable = driver.findElement(By.xpath("//span[text()='***']"));

		WebElement unavailabeWarnMessage = driver
				.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
		String unavailableText = unavailabeWarnMessage.getText();

		if (productUnavailable.isDisplayed()) {
			System.out.println(unavailableText);
		} else {
			System.out.println(successText);
		}
	}

	@Test(priority = 4)
	public void shopingCart() throws InterruptedException {
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

		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Apple cinema 30");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(3000);

		String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=product/search&search=Apple%20cinema%2030";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);
		System.out.println("You are in apple cinema product display page");

		driver.findElement(By.xpath("//img[@class='img-responsive']")).click();

		String expecteddAppleProductNextPage = "https://tutorialsninja.com/demo/index.php?route=product/product&product_id=42&search=Apple+cinema+30";
		String actualdAppleProductNextPage = driver.getCurrentUrl();
		Assert.assertEquals(expecteddAppleProductNextPage, actualdAppleProductNextPage);
		System.out.println("You are in Apple cinema 30 Page");

		driver.findElement(By.name("option[218]")).click();
		driver.findElement(By.xpath("(//input[@name='option[223][]'])[1]")).click();
		Thread.sleep(3000);

		WebElement text = driver.findElement(By.name("option[208]"));
		text.clear();
		text.sendKeys("Test Purchase");
		Thread.sleep(3000);

		WebElement selectDropDown = driver.findElement(By.name("option[217]"));
		selectDropDown.click();
		Thread.sleep(3000);


		Select s = new Select(selectDropDown);
		s.selectByValue("4");
		Thread.sleep(3000);


		driver.findElement(By.name("option[209]")).sendKeys("Test Sample purchase this product");
		Thread.sleep(3000);


		String filePath="C:\\Users\\ELCOT\\Downloads\\SHEIK SALIM CV..pdf";
		WebElement fileInput = driver.findElement(By.id("button-upload222"));
		
		fileInput.sendKeys(filePath);
		

		WebElement date = driver.findElement(By.name("option[219]"));
		date.clear();
		date.sendKeys("2023-10-10");
		Thread.sleep(3000);


		WebElement time = driver.findElement(By.name("option[221]"));
		time.clear();
		time.sendKeys("08:30");
		Thread.sleep(3000);


        WebElement time1 = driver.findElement(By.name("option[220]"));
        time1.clear();
        time1.sendKeys("2023-10-13 08:30");
		Thread.sleep(3000);

		WebElement quantity = driver.findElement(By.xpath("//input[@name='quantity']"));
		quantity.clear();
		quantity.sendKeys("1");
		Thread.sleep(3000);


		driver.findElement(By.xpath("//button[@id='button-cart']")).click();
		Thread.sleep(3000);
		Assert.assertTrue(true);

	}
}
