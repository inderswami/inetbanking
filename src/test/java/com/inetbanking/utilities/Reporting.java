package com.inetbanking.utilities;

import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporting extends TestListenerAdapter

{
	
	public ExtentSparkReporter htmlReporter ;
	
	public ExtentReports extent ;
	
	public ExtentTest logger;
	
	public void onStart()
	
	{
	
	}

	
	

}
