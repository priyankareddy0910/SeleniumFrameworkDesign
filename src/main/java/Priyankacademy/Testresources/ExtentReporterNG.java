package Priyankacademy.Testresources;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	


	public static ExtentReports config() {
		//Expects a path where your report should be created
		//it will helps us to create new Html.report
		// it will help us to set up the configurations
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Test Results");
		reporter.config().setDocumentTitle("Test Results Priyanka");
		

		ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Priyanka Reddy");
			
			
			
  return extent;
		
		
		
	}


}
