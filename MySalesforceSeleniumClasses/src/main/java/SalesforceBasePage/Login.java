package SalesforceBasePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class Login 
{
		public static WebDriver driver;
		public static WebDriver getdriver() {
		return driver;
	}
	
	
    public static void initialize()
    {
//		public static void loginScreen() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bani\\Downloads\\chromedriver_win32\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();      
    	driver.get(Constants.url);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(30));
//      wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\\\"username\\\"]")));
    	WebElement id = driver.findElement(By.xpath("//*[@id=\"username\"]"));
    	id.click();
    	id.sendKeys("banishrihembram-gmail.com@ta-candidate.cic.salesforce.com");
    	WebElement pw = driver.findElement(By.xpath("//*[@id=\"password\"]"));
    	pw.click();
    	pw.sendKeys("Catherine@18");
    	WebElement login = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
    	login.click();
     	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);    	
    	driver.navigate().refresh();
    	WebDriverWait wait1 = new WebDriverWait (driver, Duration.ofSeconds(15));
    	wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@title='Service Cloud']")));
     	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
    	System.out.println("Home Screen Landed");
    }
	

	public static void closeBrowser() {
		driver.close();
		System.out.println("Browser Closed");
	}
}
