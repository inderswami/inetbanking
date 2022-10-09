
  package com.inetbanking.testCases;
  
  import java.io.IOException;
  
  import org.openqa.selenium.NoAlertPresentException; import org.testng.Assert;
  import org.testng.annotations.DataProvider; import
  org.testng.annotations.Test;
  
  import com.inetbanking.pageObjects.LoginPage; import
  com.inetbanking.utilities.XLUtilis;
  
  public class TC_LoginDDT_002 extends BaseClass {
  
  @Test(dataProvider="LoginData")
  public void loginDDT(String user, String pwd)
  { 
	  LoginPage lp=new LoginPage(driver);
	  lp.setUserName(user);
  
      lp.setPassword(pwd);
      lp.clickSubmit();
  
  if(isAlertPresent()==true) 
  { 
	  driver.switchTo().alert().accept();
      driver.switchTo().defaultContent(); 
      Assert.assertTrue(false); }
  
  else 
  { 
	  Assert.assertTrue(true); 
      lp.clickLogout();
      driver.switchTo().alert().accept(); driver.switchTo().defaultContent(); 
      } 
  }
  
  
  public boolean isAlertPresent() 
  { try 
  { driver.switchTo().alert(); 
  
  return true; 
  } 
  
  catch(NoAlertPresentException e) 
  
  { 
	  return false ;
  
  } 
  
  }
  
  @DataProvider(name="LoginData") String [][]getData() throws IOException 
  {
  
  //String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/LoginData.xlsx";
  
  String path="./src/test/resources/testData/LoginData.xlsx" ;
  
  int rownum=XLUtilis.getRowCount(path, "sheet1") ; 
  int colcount=XLUtilis.getCellCount(path,"sheet1", 1); 
  String logindata[][]=new String [rownum][colcount];
  
  for(int i=1; i<=rownum;i++) 
  { for(int j=0;j<colcount;j++) 
  { logindata
  [i-1][j]=XLUtilis.getCellData(path, "sheet1", i, j); 
  } 
  } 
  return logindata; 
  }
  
  }
 