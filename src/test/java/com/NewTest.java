package com;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
	 
	 
  @Test
  public void Test_ODA_HomePage() {
	 	 
	  //String exePath = "C:\\\\Users\\\\shanmugamvv\\\\Downloads\\\\chromedriver.exe";
	  String exePath = "C:\\\\Users\\\\shanmugamvv\\\\eclipse-project\\\\mvnproject\\\\lib\\\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath); 
			WebDriver driver = new ChromeDriver();
			driver.get("https://sharestg.ninds.nih.gov/sites/ODA/SitePages/Default.aspx");
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		    String expectedTitle = "Official Duty Activity/Sponsored Travel - Default";
			String actualTitle = driver.getTitle();
			//System.out.println("ODA Home Page:" + actualTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
			driver.close();
  }
  
  @Test
  public void Test_ODA_RequestLink() {
	  
	  String exePath = "C:\\\\Users\\\\shanmugamvv\\\\eclipse-project\\\\mvnproject\\\\lib\\\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://sharestg.ninds.nih.gov/sites/ODA/SitePages/Default.aspx");
		driver.findElement(By.xpath("//a[@href ='/sites/ODA/Lists/ODA Requests/Item/newifs.aspx?Source=/Sites/ODA/SitePages/Default.aspx']")).click();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String ODA_Request_Link_expectedTitle = "ODA Requests - New Item";
		String ODA_Request_Link_actualTitle = driver.getTitle();
		Assert.assertEquals(ODA_Request_Link_actualTitle, ODA_Request_Link_expectedTitle);
		driver.close();
								
  }
  
  @Test
  public void Test_MyLink() {
					
			String exePath = "C:\\\\Users\\\\shanmugamvv\\\\eclipse-project\\\\mvnproject\\\\lib\\\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath); 
			WebDriver driver = new ChromeDriver();
			driver.get("https://sharestg.ninds.nih.gov/sites/ODA/SitePages/Default.aspx");
			driver.findElement(By.xpath("//a[@href ='/Sites/ODA/SitePages/NgMyView.aspx']")).click();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);	
			String MyLink_expectedTitle = "NgMyView";
			String MyLink_actualTitle = driver.getTitle();
			Assert.assertEquals(MyLink_actualTitle, MyLink_expectedTitle);
			driver.close();
						
  }
  

  @Test
  public void Test_ODA_Process_Workflow_Link() {
	  
	   String exePath = "C:\\\\Users\\\\shanmugamvv\\\\eclipse-project\\\\mvnproject\\\\lib\\\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://sharestg.ninds.nih.gov/sites/ODA/SitePages/Default.aspx");
		String mainwindow = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[@href ='/Sites/ODA/SitePages/ODAProcessFlow.aspx']")).click();
		 Set<String> s1 = driver.getWindowHandles();
		 Iterator<String> i1 = s1.iterator();
		 while (i1.hasNext()) {
	            String ChildWindow = i1.next();
	                if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
	                driver.switchTo().window(ChildWindow);
	             }
	        }    
		 
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String ODA_Process_flow_expectedTitle = "ODAProcessFlow";
		String ODA_Process_flow_actualTitle = driver.getTitle();
		System.out.println("ODA_Process_flow_actualTitle " + ODA_Process_flow_actualTitle );
		Assert.assertEquals(ODA_Process_flow_actualTitle, ODA_Process_flow_expectedTitle);
		driver.close();
								
  }
  
}
