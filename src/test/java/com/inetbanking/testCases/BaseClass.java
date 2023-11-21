package com.inetbanking.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	// public String baseurl="https://demo.guru99.com/v4/#google_vignette";
	public String baseurl = readconfig.getApplicationUrl();

	// public String username="vaibhav";
	public String username = readconfig.getUsername();

	// public String password="khare";
	public String password = readconfig.getPassword();

	public static WebDriver driver;
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseClass.class);
	
	private ExtentSparkReporter reporter;
	private ExtentReports extent;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br){
		
		reporter = new ExtentSparkReporter("C:\\Users\\91995\\eclipse-workspace\\inetBankingV1\\test-output\\extent");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		//ExtentTes
		

		LOGGER.info("initializing driver" , br);
		if (br.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());

			driver = new ChromeDriver();

		}

		else if (br.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());

			driver = new FirefoxDriver();

		}

		else if (br.equals("ie")) {

			System.setProperty("webdriver.chrome.driver", readconfig.getIEPath());

			driver = new InternetExplorerDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseurl);

	}

	@AfterClass
	public void tearDown() {
		LOGGER.info("quiting driver");
		driver.quit();
		
		extent.flush();
		System.out.println("It is base class");
	}

}

