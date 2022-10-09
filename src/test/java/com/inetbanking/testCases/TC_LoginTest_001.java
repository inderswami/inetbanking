package com.inetbanking.testCases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass

{

	private static final Logger LOGGER = LoggerFactory.getLogger(TC_LoginTest_001.class);

	@Test
	public void LoginTest()

	{

		LOGGER.info("URL is opened");

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);

		LOGGER.info("Entered username");

		lp.setPassword(password);

		LOGGER.info("Entered password");

		lp.clickSubmit();

		if (driver.getTitle().equals("Guru99 Bank Manager Home Page")) {
			Assert.assertTrue(true);
			LOGGER.info("Login Test Passed");

		}

		else

		{
			Assert.assertTrue(false);
			LOGGER.info("Login Test Passed");
		}
	}

}
