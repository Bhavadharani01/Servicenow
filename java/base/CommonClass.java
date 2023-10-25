package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.crypto.RuntimeCryptoException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.sukgu.Shadow;
import util.ReadExcel;

public class CommonClass {
	public ChromeDriver driver;
	public ExtentTest test,node;
	public ExtentReports extent;
	public Shadow dom;
	public String testName,testDescription,testCategory,testAuthor,excelfile;

	
	@BeforeSuite
    public void startReport() {
    ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
    reporter.setAppendExisting(true);
    extent=new ExtentReports();
    extent.attachReporter(reporter);
    }
	
	@BeforeClass
	public void testcaseDetail() {
		 test = extent.createTest(testName,testDescription);
	     test.assignCategory(testCategory);
	     test.assignAuthor(testAuthor);
	}
	public int takeSnap() throws IOException {
		//generate the random number
		int ranNum=(int)(Math.random()*999999+1000000);
		 // take the screenshot
        File source = driver.getScreenshotAs(OutputType.FILE);
        // Creating physical file
        File destination = new File("./snap/img"+ranNum+".png");
        // Copy source to destination
        FileUtils.copyFile(source, destination);	
        return ranNum;
	}
	
	public void reportStep(String stepDes,String status) throws IOException {
		if (status.equalsIgnoreCase("pass")) {
			node.pass(stepDes,MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnap()+".png").build());
		}
		else if (status.equalsIgnoreCase("fail")) {
			node.fail(stepDes,MediaEntityBuilder.createScreenCaptureFromPath(".././snap/img"+takeSnap()+".png").build());
			throw new RuntimeCryptoException("Please look the report for failure");
		} 
	}
	
	@AfterSuite
	public void stopReport() {
		extent.flush();
	}
	
   @BeforeMethod
	public void launchBrowser() throws InterruptedException {
	   node = test.createNode(testName);
	   ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://dev68636.service-now.com");
		driver.get("https://dev79885.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		dom = new Shadow(driver);
		//dom.setImplicitWait(30);
	}
	
   @AfterMethod
	public void closeBrowser() {
	   driver.close();
	}
   @DataProvider(name = "fetchData")
   public String[][] getData() throws IOException{
       String[][]data=ReadExcel.readdata(excelfile);
       return data;
   }
}

