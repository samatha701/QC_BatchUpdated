package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class JQCAutoClear extends QCStore{
	public static void autoClear(String SSN,String AppURL)
	{
		try{
			int lastrow=TestData.getLastRow((Jprop.getProperty("Deposit")));
			String sheetName=Jprop.getProperty("Deposit");
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
				String loan_Status = TestData.getCellData(sheetName,"LoanStatus",row);	
				
		       
		       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
		
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        		       
				
		       Thread.sleep(4000);
				test.log(LogStatus.INFO, "Clear through from CSR has initiated");
				driver.switchTo().frame("bottom");
				String Str_date=driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
				String store_date[]=Str_date.split(":");
				String business_date=store_date[1];
				test.log(LogStatus.PASS, ""+Str_date);
				
				driver.switchTo().defaultContent();	
				
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
		        driver.findElement(By.cssSelector("li[id='910000']")).click();	
				
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
			
				driver.findElement(By.cssSelector("li[id='911101']")).click();			
				test.log(LogStatus.PASS, "Clicked on Transactions");		
				driver.switchTo().frame("main");		
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");		
				for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
				}
			    driver.switchTo().defaultContent();
			    driver.switchTo().frame("mainFrame");
			    driver.switchTo().frame("main");
			    
			    driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under search results");
				
			for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
					}				    
				 	driver.switchTo().defaultContent();
				    driver.switchTo().frame("mainFrame");
				    driver.switchTo().frame("main");
				    
				 driver.findElement(locator(Jprop.getProperty("go_button"))).click();
					  test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				   
				    Thread.sleep(5000);
				   
						String status= driver.findElement(locator(Jprop.getProperty("loan_status"))).getText();
						test.log(LogStatus.PASS, "Loan Status is " + status);
						test.log(LogStatus.PASS, "Loan Status is..... " + loan_Status);
						//if(loan_Status.toLowerCase().trim().equalsIgnoreCase(status.toLowerCase().trim()))	
						if(loan_Status.equalsIgnoreCase(status))
						{
							 test.log(LogStatus.PASS, ESign_CollateralType+" Auto Clear from CSR is successfull");
							 test.log(LogStatus.PASS, "********************************************** ");
							 break;
						}else{
							 test.log(LogStatus.INFO, ESign_CollateralType+" Auto Clear from CSR is successfull");
							 test.log(LogStatus.PASS, "********************************************** ");
						} 
						
				}
				
				 
			}
			
		}catch(Exception e){
						e.printStackTrace();
						test.log(LogStatus.FAIL, "Check Clear from CSR is failed");

		}
			
		
	}

}
