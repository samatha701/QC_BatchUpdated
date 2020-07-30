package tests;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RQCAdminCCKReturn extends QCStore {

	public static void cckreturn(String SSN, String AppURL) {
		try {
			// String FileName= Rprop.getProperty("QC_Store_NewLoan_file_name");

			// ExcelNew TestData = new
			// ExcelNew(System.getProperty("user.dir")+Rprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path")+FileName+".xls");
			int lastrow = TestData.getLastRow("ReturnPosting");
			String sheetName = "ReturnPosting";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);
				if (SSN.equals(RegSSN)) {
					String AdminUserName = TestData.getCellData(sheetName,"AdminUserName",row);
					String AdminPassword = TestData.getCellData(sheetName,"AdminPassword",row);
					//String AdminURL = TestData.getCellData(sheetName, "AdminURL", row);
					String PIN = TestData.getCellData(sheetName,"PIN",row);
					String StoreID = TestData.getCellData(sheetName,"StoreID",row);
					String ProductID = TestData.getCellData(sheetName,"ProductID",row);
					String CCKReasonForReturn = TestData.getCellData(sheetName,"CCKReasonForReturn",row);
					String Esign_CollateralType = TestData.getCellData(sheetName,"Esign_CollateralType",row);
					String PaymentTenderType = TestData.getCellData(sheetName,"PaymentTenderType",row);
                    
					
					test.log(LogStatus.INFO,"Admin Application is launched For Return Posting");

					if(Rprop.getProperty("login_method").equalsIgnoreCase("local"))
					{
						driver = new InternetExplorerDriver();
					}
					else
					{
						String Node = "http://192.168.2.66:5555/wd/hub";
						 //String Node2 = "http://192.168.0.238:5566/wd/hub";
						 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
						 driver = new RemoteWebDriver(new URL(Node), cap);	
					}
					wait = new WebDriverWait(driver, 40000);

					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
				
					driver.get(AdminURL);
					test.log(LogStatus.INFO,"Opened the Admin URL"+ AdminURL);
					test.log(LogStatus.INFO,"Reading encryption details from Admin has initiated"+ AdminURL);



		
		DateFormat df=new SimpleDateFormat("MM/dd/yyyy"); 

		driver.findElement(By.name("loginRequestBean.userId")).sendKeys(AdminUserName);

		test.log(LogStatus.PASS, "Username is entered: "+AdminUserName); 

		driver.findElement(By.name("loginRequestBean.password")).sendKeys(AdminPassword);

		test.log(LogStatus.PASS, "Password is entered: "+AdminPassword); 

		//Click Login Button

		driver.findElement(By.name("login")).click();

		test.log(LogStatus.PASS, "Clicked on Submit button");

		Thread.sleep(3000);

		driver.get(csrloginpage);
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();

		driver.switchTo().frame("topFrame");

		driver.findElement(By.xpath("//*[@id='500000']/a")).click(); 
		Thread.sleep(1000);
		test.log(LogStatus.PASS, "Clicked on Transaction tab");
		
		Thread.sleep(3000);
		
		
		if(Esign_CollateralType.equalsIgnoreCase("ACH"))
		{
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			driver.switchTo().defaultContent();

			driver.switchTo().frame("mainFrame");

			
			Thread.sleep(5000);
		
				
			
			driver.findElement(By.linkText("Payment Check Return Posting")).click();

			test.log(LogStatus.PASS, "Clicked on Payment Check Return Posting link");
			
			Thread.sleep(5000);			
						
			driver.switchTo().frame("main");
			
			driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreID);
			
			test.log(LogStatus.PASS, "Store nbr entered is :" +StoreID);
		
			
			driver.findElement(By.name("requestBean.loanNo")).sendKeys(loan_number);
			
			test.log(LogStatus.PASS, "Store nbr entered is :" +loan_number);
			
			driver.findElement(By.name("requestBean.pmtTenderType")).sendKeys(PaymentTenderType);
			
			test.log(LogStatus.PASS, "Payment Tender Type select as :" +PaymentTenderType);
			
			driver.findElement(By.name("requestBean.productType")).sendKeys(ProductID);
			
			test.log(LogStatus.PASS, "Product Type Select as :" +ProductID);
			
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table[4]/tbody/tr[2]/td[2]/table[2]/tbody/tr[2]/td[2]/input")).click();
			
			test.log(LogStatus.PASS, "Clicked on Submit");
			
			Thread.sleep(8000);
			
			driver.findElement(By.name("requestBean.chkName")).click();
			
			test.log(LogStatus.PASS, "Clicked on WebCheck box");
			
			Thread.sleep(500);
			
			driver.findElement(By.name("rtnReasonId")).sendKeys(CCKReasonForReturn);
			
			test.log(LogStatus.PASS, "return For Reason Select as :" +CCKReasonForReturn );
			
			Thread.sleep(500);
			
			driver.findElement(By.name("CmdReturnPosting")).click();
			
			test.log(LogStatus.PASS, "Clicked on Finish Return Check Posting");
			
			Thread.sleep(5000);
			
			driver.findElement(By.name("checkno")).click();
			
			test.log(LogStatus.PASS, "Clicked on Transaction Completed Successfully Ok");
			
			test.log(LogStatus.PASS, "<FONT color=green style=Arial> Check Return Posting Completed Successfully");
			
			
			
			
			
					
			driver.close();
			break;
					}
				}

				
			}
			// }

		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			test.log(LogStatus.FAIL, "Return Posting from Admin is failed");

		}

	}
}
