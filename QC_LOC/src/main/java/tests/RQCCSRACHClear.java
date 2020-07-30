package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class RQCCSRACHClear extends QCStore
{

	public static void achclear(String SSN,String AppURL)
	{
		int i;
		for(i=0;i<3;i++)
		{
		
	try{
			int lastrow=TestData.getLastRow("ACHClear");
			String sheetName="ACHClear";

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				if(SSN.equals(RegSSN))
				{
					String TxnType = TestData.getCellData(sheetName,"TxnType",row);
					//String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					//String PaymentAmount = TestData.getCellData(sheetName,"PaymentAmount",row);
					//String PIN = TestData.getCellData(sheetName,"Password",row);
					//String TenderAmount = TestData.getCellData(sheetName,"TenderAmount",row);	
					//String PaymentType = TestData.getCellData(sheetName,"PaymentType",row);
					String SSN1 = SSN.substring(0, 3);
					String SSN2 = SSN.substring(3,5);
					String SSN3 = SSN.substring(5,9);

					Thread.sleep(3000);
					test.log(LogStatus.INFO,"ACHClear started");
					driver.switchTo().frame("topFrame");
					driver.findElement(locator(Rprop.getProperty("transactions_tab"))).click();			
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");

					driver.findElement(By.cssSelector("li[id='911101']")).click();
					test.log(LogStatus.PASS, "Clicked on Transaction");		
					driver.switchTo().frame("main");	
					Thread.sleep(500);
					driver.findElement(By.name("ssn1")).sendKeys(SSN1);
					test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
					driver.findElement(locator(Rprop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
					test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
					driver.findElement(locator(Rprop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
					test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
					driver.findElement(locator(Rprop.getProperty("csr_new_loan_submit_button"))).click();
					test.log(LogStatus.PASS, "Clicked on submit Button");		
								
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(Rprop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button under search results");
					Thread.sleep(5000);					  
						
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button Under Product web table");
					Thread.sleep(5000);
					driver.findElement(By.name("transactionList")).sendKeys(TxnType);
					test.log(LogStatus.PASS, "Transaction Type is selected as :" +TxnType);
					Thread.sleep(2000);	
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button ");
					Thread.sleep(5000);	
					driver.findElement(By.name("requestBean.chkName")).click();
					test.log(LogStatus.PASS, "Clicked on Check box ");
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='CmdReturnPosting']")).click();
					test.log(LogStatus.PASS, "Clicked on ACH Clear ");
					Thread.sleep(500);
					//driver.findElement(By.name("ok")).click();
					//test.log(LogStatus.PASS, "Clicked on Transaction Completed Successfully Ok ");
					//test.log(LogStatus.PASS, "<FONT color=green style=Arial> ACH Clear Completed Successfully");
				
									
					
				
					Thread.sleep(5000);
					if(driver.findElement(By.name("ok")).isDisplayed())
					{
						Thread.sleep(1000);
						//test.log(LogStatus.PASS, "<FONT color=green style=Arial> Void LOC Closure is successfull");
						driver.findElement(By.name("ok")).click();
						//Thread.sleep(1000);
						//driver.findElement(By.name("ok")).click();
					//test.log(LogStatus.PASS, "PayOff transaction is successfully");
					test.log(LogStatus.PASS, "<FONT color=green style=Arial> ACH Clear Completed Successfully");
					}
					test.log(LogStatus.PASS,"****************************************");
					break;
					
				}
					}
		
break;

}

			
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						test.log(LogStatus.FAIL, "ACH Clear is failed");

					}
				}

	}
}
	