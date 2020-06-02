package common_methods;

import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CommonMethod
{

	public static WebDriver driver;
	 public static WebElement element;
	
	
	public static void browser_and_url_open() throws Throwable 
	{
		System.setProperty(readProperty("browserkey"),
				readProperty("chromebrowser"));
		//Reporter.addStepLog("Browser Opening");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.get(readProperty("url"));
		//Reporter.addStepLog("Opening the url [ "+readProperty("url")+ " ]");
	}
	 
	
	public static String readProperty(String key) throws Exception
	{
		FileReader reader=new FileReader("C:\\Users\\lenovo\\eclipse-workspace\\TestInTwoTive\\src\\main\\resources\\Configuration.propoties");  
	      
	    Properties p=new Properties();  
	    p.load(reader);  
	    
	    String value = p.getProperty(key);
	    return value;
	}
	
	 public static  void clickElementByElement(WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;    
			js.executeScript("arguments[0].click();", element); 
		}
	 public static void normalWait(long seconds) throws Exception
		{
			Thread.sleep(seconds);
		}

		public static void implicitlyWait(long time)
		{
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.MILLISECONDS);
		}
		
		public static void expwait(String Xpath)
		{
		     WebDriverWait wait = new WebDriverWait(driver, 50);
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
		}
		
		public static void waitTime()
		{
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		

		public static void pressEnter()
		{
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
		}
		
		public static void maximizeWindow()
		{
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		 
		 public static void waitTillClick(String Xpath)
		 {
			 WebDriverWait wait = new WebDriverWait(driver, 10);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
		 }
		
		public static void selectValue(WebElement element, String value)
		{
			element.sendKeys(value);
		}
		
		 public static void scrolloperation(long index)
		{
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("window.scrollBy(0,"+index+")");
		}
		
		
		
		 public static void clickElementByXpath(String Xpath)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;    
			js.executeScript("arguments[0].click();", driver.findElement(By.xpath(Xpath))); 
		}
		
		 public static void normalclick(String Xpath)
		{
			driver.findElement(By.xpath(Xpath)).click();
		}
		
		public static void scrollviewoperation(WebElement element)
		{
			  JavascriptExecutor js = (JavascriptExecutor)driver;
		      js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		public static void scrollviewmultioperation(String xpath)
		{
			 JavascriptExecutor js = (JavascriptExecutor)driver;
		     js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpath)));
		}
		
		public static void dropdown(String text, WebElement element)
		{
			Select se = new Select(element);
			se.selectByVisibleText(text);
		}
		
		public static void moveToElement(WebElement wb)
		{
			Actions act = new Actions(driver);
			act.moveToElement(wb).perform();
		}
		
		public static void windowHandle(String windowid)
		{
			driver.switchTo().window(windowid);
		}
		
		public static void frameHandle(int index)
		{
			driver.switchTo().frame(index);
		}
		
		public static String TodayDate()
		{
			Date date = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");  
		    String strDate= formatter.format(date); 
		    return strDate;
		}
		
		public static Date yesterday() 
		{
			    final Calendar cal = Calendar.getInstance();
			    cal.add(Calendar.DATE, -1);
			    return cal.getTime();
		}

		public static Date defaultEndDate(int number)
	    {
	        final Calendar cal = Calendar.getInstance();
	        cal.add(Calendar.DATE, +number);
	        return cal.getTime();
	    }
		
		public static String YesterdayDate()
		{
			     DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			     return dateFormat.format(yesterday());
		}
		
		public static void ExtentReport()
		{
			ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/plm.html");
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
		}

}
