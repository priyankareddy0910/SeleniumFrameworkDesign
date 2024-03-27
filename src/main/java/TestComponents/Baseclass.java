package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v101.browser.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Priyankaacademy.pageobjects.LandingPage;

public class Baseclass {
	public WebDriver driver;
	
	public LandingPage landingPage;
	
	public WebDriver Initializedriver() throws IOException {
  Properties prop = new Properties();
  
  //FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
			//+ "//src//main//java//Priyankacademy//Testresources//GlobalProperties");
	  FileInputStream fis = new FileInputStream("C:\\Users\\ankus\\Documents\\Prathyusha\\SeleniumFrameworkDesign\\src\\main\\java\\Priyankacademy\\Testresources\\GlobalProperties");
		prop.load(fis);
		
		//String BrowserName = prop.getProperty("browser");
		String BrowserName = "chrome";
		if(BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ankus\\Documents\\chromedriver.exe");	
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			 driver = new ChromeDriver(options);
			
		}else if(BrowserName.equals("firefox")){
			
			// firefox code
			
		}else if(BrowserName.equals("edge")) {
			
			//edge code
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
		
}   @BeforeMethod(alwaysRun=true)
	public LandingPage launchApplication() throws IOException {
	driver = Initializedriver();
	 landingPage = new  LandingPage(driver);
	landingPage.goTo();
	return landingPage;
	
	}

public  String getscreenshot(String testCaseName, WebDriver driver) throws IOException {
	TakesScreenshot ts =(TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File file= new File(System.getProperty("user.dir")+ "//reports//"+ testCaseName + ".png");
	FileUtils.copyFile(source,file);
	
	return System.getProperty("user.dir")+ "//reports//"+ testCaseName + ".png";


	
	}

@AfterMethod(alwaysRun=true)
public void teardown() throws IOException {

	driver.close();
	
}

}
