package tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class QCClearMenu extends QCStore {
	public static void cleardropdown(String SSN,String AppURL) throws Exception
	{
		try{
			int lastrow=TestData.getLastRow("Clear");
			String sheetName="Clear";
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
				String UserName = TestData.getCellData(sheetName,"UserName",row);
				String Password = TestData.getCellData(sheetName,"Password",row);
				String PIN = TestData.getCellData(sheetName,"PIN#",row);
				String Deposit_Type = TestData.getCellData(sheetName,"Deposit_Type",row);
		       // System.out.println(Password);
		        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
		        String Header = StateID+ "_" + ProductID;	      
		        String columnname=StateID+"_"+ ProductID+"_"+Income_PayFrequency;                                //column name
		        System.out.println(columnname);
		       String LastName = TestData.getCellData(sheetName,"LastName",row);
		       String FirstName = TestData.getCellData(sheetName,"FirstName",row);
		       String customer_name=LastName+FileName;
		       String AddressLine = TestData.getCellData(sheetName,"AddressLine",row);
		       String City = TestData.getCellData(sheetName,"City",row);
		       String State = TestData.getCellData(sheetName,"State",row);	      
		       String ZipCode = TestData.getCellData(sheetName,"ZipCode",row);
		       String MonthsAtAddress = TestData.getCellData(sheetName,"MonthsAtAddress",row);	     
		       String Bank_ABARoutingNbr = TestData.getCellData(sheetName,"Bank_ABARoutingNbr",row);
		       String Bank_ChkgAcctNbr = TestData.getCellData(sheetName,"Bank_ChkgAcctNbr",row);	       
		       String Ctc_PrimaryPhone = TestData.getCellData(sheetName,"Ctc_PrimaryPhone",row);
		       String Ctc_PhoneType = TestData.getCellData(sheetName,"Ctc_PhoneType",row);
		       String Misc_PhotoIDNbr = TestData.getCellData(sheetName,"Misc_PhotoIDNbr",row);
		     //  String Misc_IDExpDate = TestData.getCellData(sheetName,"Misc_IDExpDate",row);	   
		       String Misc_PhotoIDType = TestData.getCellData(sheetName,"Misc_PhotoIDType",row);
		       String BorrDOB = TestData.getCellData(sheetName,"Misc_DOB",row);
		       String Income_IncomeType = TestData.getCellData(sheetName,"Income_IncomeType",row);
		       String ESign_CollateralType = TestData.getCellData(sheetName,"ESign_CollateralType",row);
		       String Income_HireDt = TestData.getCellData(sheetName,"Income_HireDt",row);
		       String Income_DirectDeposit=TestData.getCellData(sheetName,"Income_DirectDeposit",row);	       
		       String PrimaryRef_LastName = TestData.getCellData(sheetName,"PrimaryRef_LastName",row);
		       String PrimaryRef_FirstName = TestData.getCellData(sheetName,"PrimaryRef_FirstName",row);
		       String PrimaryRef_Relationship = TestData.getCellData(sheetName,"PrimaryRef_Relationship",row);
		       String PrimaryRef_PhoneNbr=TestData.getCellData(sheetName,"PrimaryRef_PhoneNbr",row);
		       String Ref_LastName = TestData.getCellData(sheetName,"Ref_LastName",row);
		       String Ref_FirstName = TestData.getCellData(sheetName,"Ref_FirstName",row);
		       String Ref_Relationship = TestData.getCellData(sheetName,"Ref_Relationship",row);
		       String Ref_PhoneNbr=TestData.getCellData(sheetName,"Ref_PhoneNbr",row);	       
		       String Bankruptcy=TestData.getCellData(sheetName,"Bankruptcy",row);	     
		       String Income_Employer = TestData.getCellData(sheetName,"Income_Employer",row);
		       String Income_WorkPhone = TestData.getCellData(sheetName,"Income_WorkPhone",row);
		       String TenderType = TestData.getCellData(sheetName,"TenderType",row);
					   DateFormat  df=new SimpleDateFormat("MM/dd/yyyy");
				        String SSN1 = SSN.substring(0, 3);
				        String SSN2 = SSN.substring(3,5);
				        String SSN3 = SSN.substring(5,9);
				        String PP1 = Ctc_PrimaryPhone.substring(0, 3);
				        String PP2 = Ctc_PrimaryPhone.substring(3, 6);
				        String PP3 = Ctc_PrimaryPhone.substring(6, 10);
				        String IncomeP1 = Income_WorkPhone.substring(0, 3);
				        String IncomeP2 = Income_WorkPhone.substring(3, 6);
				        String IncomeP3 = Income_WorkPhone.substring(6, 10);
				        String PrimaryRef_PhoneNbr1 = PrimaryRef_PhoneNbr.substring(0, 3);
				        String PrimaryRef_PhoneNbr2 = PrimaryRef_PhoneNbr.substring(3, 6);
				        String PrimaryRef_PhoneNbr3 = PrimaryRef_PhoneNbr.substring(6, 10);
				        String Ref_PhoneNbr1 = Ref_PhoneNbr.substring(0, 3);
				        String Ref_PhoneNbr2 = Ref_PhoneNbr.substring(3, 6);
				        String Ref_PhoneNbr3 = Ref_PhoneNbr.substring(6, 10);			       
				
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
				    
				  if(ProductID.equals(prop.getProperty("PDL")))
					 {
				    driver.findElement(By.xpath(" /html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
				    test.log(LogStatus.PASS, "Clicked on Go button under Loans section");
				    }
				    if(ProductID.equals(prop.getProperty("TLP")))
					 {
				    	driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[13]/input")).click();
					 }
				    
				   
				    if(ProductID.equals(prop.getProperty("LOC")))
					 {
				    		
				    	 driver.findElement(By.xpath("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[11]/input[1]")).click();
					 }
				    Thread.sleep(5000);
				     String loan_nbr= driver.findElement(By.xpath("xpath%%/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[4]/td[2]")).getText();
					  test.log(LogStatus.PASS, "Loan Number is" + loan_nbr);
					   driver.switchTo().defaultContent();
						driver.switchTo().frame("mainFrame");
						System.out.println("************"+ESign_CollateralType);
						 test.log(LogStatus.PASS, "Loan Number is" + ESign_CollateralType);
						Thread.sleep(2000);
						if(ESign_CollateralType.equalsIgnoreCase("CHECK"))
						{
							Actions action = new Actions(driver);  
							 WebElement collateral=driver.findElement(locator(prop.getProperty("deposite_collateral_check")));
							 action.moveToElement(collateral).build().perform();
							 test.log(LogStatus.PASS, " Mouse hover on collateral check menu");
							 Thread.sleep(2000);
							 WebElement pdl=driver.findElement(locator(prop.getProperty("deposite_menu_pdl")));
							 action.moveToElement(pdl).build().perform();
							 test.log(LogStatus.PASS, " Mouse hover on payday loan menu");
							 Thread.sleep(3000);
							 driver.findElement(locator(prop.getProperty("deposite_clear_menu"))).click();
							 test.log(LogStatus.PASS, " click on clear menu");
							 Thread.sleep(2000);
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(locator(prop.getProperty("deposite_menu_loannbr"))).sendKeys(loan_nbr);
							 driver.findElement(locator(prop.getProperty("deposite_menu_submit"))).click();
							 test.log(LogStatus.PASS, "Clicked on submit button");
							 driver.findElement(locator(prop.getProperty("deposit_check_box"))).click();
							 driver.findElement(locator(prop.getProperty("finish_ach_deposit"))).click();
							 test.log(LogStatus.PASS, "Clicked on  "+ESign_CollateralType+" Clear button");
							 test.log(LogStatus.PASS, ESign_CollateralType+" Clear menu from CSR is successfull");
							 test.log(LogStatus.PASS, "********************************************** ");
							} 
						else if(ESign_CollateralType.equalsIgnoreCase("ACH"))
						{
							Actions action = new Actions(driver);  
							 WebElement collateral=driver.findElement(locator(prop.getProperty("ACH")));
							 action.moveToElement(collateral).build().perform();
							 test.log(LogStatus.PASS, " Mouse hover on ACH menu");
							 Thread.sleep(2000);
							 WebElement pdl=driver.findElement(locator(prop.getProperty("deposit_ach_pdl")));
							 action.moveToElement(pdl).build().perform();
							 test.log(LogStatus.PASS, " Mouse hover on payday loan menu");
							 Thread.sleep(3000);
							 driver.findElement(locator(prop.getProperty("ACH_clear"))).click();
							 test.log(LogStatus.PASS, " click on clear menu");
							 Thread.sleep(2000);
							 driver.switchTo().defaultContent();
							 driver.switchTo().frame("mainFrame");
							 driver.switchTo().frame("main");
							 driver.findElement(locator(prop.getProperty("deposite_menu_loannbr"))).sendKeys(loan_nbr);
							 driver.findElement(locator(prop.getProperty("ACH_submit"))).click();
							 test.log(LogStatus.PASS, "Clicked on submit button");
							 driver.findElement(locator(prop.getProperty("deposit_check_box"))).click();
							 driver.findElement(locator(prop.getProperty("finish_ach_deposit"))).click();
							 test.log(LogStatus.PASS, "Clicked on  "+ESign_CollateralType+" Clear button");
							 test.log(LogStatus.PASS, ESign_CollateralType+" Clear menu from CSR is successfull");
							 test.log(LogStatus.PASS, "********************************************** ");
							}
						break;
				}
				
				 
			}
			
		}catch(Exception e){
			test.log(LogStatus.INFO,"Exception occured "+e.toString().substring(0, 250));
			String screenshotPath = getScreenhot(driver, "Clearmenu");
							test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));
						test.log(LogStatus.FAIL, "Check Clear from CSR is failed");

		}
			
		
	}
	public static void clearMenu(String SSN,String AppURL) throws Exception
	{
		
		int lastrow=TestData.getLastRow("Clear");
		String sheetName="Clear";
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
				String UserName = TestData.getCellData(sheetName,"UserName",row);
				String Password = TestData.getCellData(sheetName,"Password",row);
				String PIN = TestData.getCellData(sheetName,"PIN#",row);
				String Deposit_Type = TestData.getCellData(sheetName,"Deposit_Type",row);
		       // System.out.println(Password);
		        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
		        String Header = StateID+ "_" + ProductID;	
		       Thread.sleep(4000);
				test.log(LogStatus.INFO, "Clear through CSR has initiated");
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
			
				driver.findElement(By.cssSelector("li[id='95519019']")).click();			
				test.log(LogStatus.PASS, "Clicked on collateralCheck");
				 Actions action = new Actions(driver); 
				 if(ProductID.equalsIgnoreCase("PDL"))
				 {
				 WebElement PDL=driver.findElement(By.id("95519020"));
				 action.moveToElement(PDL).build().perform();
				 test.log(LogStatus.PASS, " Mouse hover on Payday loan menu");
				 Thread.sleep(3000);
				 /*WebElement clearMenu=driver.findElement(By.id("95519025"));
				 action.moveToElement(clearMenu).build().perform();*/
				 driver.findElement(By.linkText("Clear")).click();
				 test.log(LogStatus.PASS, " Mouse hover on clear menu");
				 }
				 if(ProductID.equalsIgnoreCase("ILP"))
				 {
					 driver.findElement(By.linkText("Installment Loan")).click();
				 WebElement ILP=driver.findElement(By.id("95519021"));
				 action.moveToElement(ILP).build().perform();
				 test.log(LogStatus.PASS, " Mouse hover on Installment loan menu");
				 Thread.sleep(3000);
				// WebElement clearMenu=driver.findElement(By.id("988190735"));//
				// action.moveToElement(clearMenu).build().perform();			//
				 driver.findElement(By.linkText("Clear")).click();
				 test.log(LogStatus.PASS, " Mouse hover on clear menu");
				 }
				 if(ProductID.equalsIgnoreCase("TLP"))
				 {
				 WebElement TLP=driver.findElement(By.id("9881908077"));
				 action.moveToElement(TLP).build().perform();
				 test.log(LogStatus.PASS, " Mouse hover on Installment loan menu");
				 Thread.sleep(3000);
				/* WebElement clearMenu=driver.findElement(By.id("9881908080"));
				 action.moveToElement(clearMenu).build().perform();*/
				 driver.findElement(By.linkText("Clear")).click();
				 test.log(LogStatus.PASS, " Mouse hover on clear menu");
				 }
				 driver.switchTo().defaultContent();
				 driver.switchTo().frame("mainFrame");
				 driver.switchTo().frame("main");
				 driver.findElement(By.name("submit")).click();
				 test.log(LogStatus.PASS, "clicked on clear submit button");
				 driver.findElement(By.name("requestBean.chkName")).click();
				 test.log(LogStatus.PASS, "clicked on clear check box");
				 driver.findElement(By.name("CmdReturnPosting")).click();
				 test.log(LogStatus.PASS, "clicked on finish clear button");
				 driver.findElement(By.name("Ok")).click();
				 test.log(LogStatus.PASS, "clicked on finish clear ok button");
				}
			}
		}

	public static void adminClearMenu(String SSN,String AppURL) throws Exception
	{
		
			int lastrow=TestData.getLastRow("Clear");
			String sheetName="Clear";
			System.out.println("...."+sheetName);

			for(int row=2;row<=lastrow;row++)
			{		
				String RegSSN = TestData.getCellData(sheetName,"SSN",row);
				System.out.println("...."+RegSSN);
				if(SSN.equals(RegSSN))
				{
				String UserName = TestData.getCellData(sheetName,"UserName",row);
				String Password = TestData.getCellData(sheetName,"Password",row);
				String PIN = TestData.getCellData(sheetName,"PIN#",row);
				String Deposit_Type = TestData.getCellData(sheetName,"Deposit_Type",row);
		       // System.out.println(Password);
		        String StoreId = TestData.getCellData(sheetName,"StoreID",row);
		        String ProductID = TestData.getCellData(sheetName,"ProductID",row);
		        String StateID = TestData.getCellData(sheetName,"StateID",row);
		        String StoreID = TestData.getCellData(sheetName,"StoreID",row);
		        String Income_PayFrequency = TestData.getCellData(sheetName,"Income_PayFrequency",row);
		        String Header = StateID+ "_" + ProductID;	
		       Thread.sleep(4000);
				test.log(LogStatus.INFO, "Clear through admin has initiated");
				
				
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='500000']")));
		        driver.findElement(By.cssSelector("li[id='500000']")).click();	
				
				test.log(LogStatus.PASS, "Clicked on  Transactions");
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
			
				driver.findElement(By.cssSelector("li[id='501000']")).click();			
				test.log(LogStatus.PASS, "Clicked on collateralCheck");
				Thread.sleep(3000);
				 Actions action = new Actions(driver); 
				 if(ProductID.equalsIgnoreCase("PDL"))
				 {
				 WebElement PDL=driver.findElement(By.id("501010"));
				 action.moveToElement(PDL).build().perform();
				 test.log(LogStatus.PASS, " Mouse hover on Payday loan menu");
				 Thread.sleep(2000);
				 /*WebElement clearMenu=driver.findElement(By.id("501017"));
				 action.moveToElement(clearMenu).build().perform();*/
				 driver.findElement(By.linkText("Clear")).click();
				 test.log(LogStatus.PASS, " Mouse hover on clear menu");
				 Thread.sleep(2000);
				 }
				 if(ProductID.equalsIgnoreCase("ILP"))
				 {
				 WebElement ILP=driver.findElement(By.id("501020"));
				 action.moveToElement(ILP).build().perform();
				 test.log(LogStatus.PASS, " Mouse hover on Installment loan menu");
				 Thread.sleep(2000);
				 /*WebElement clearMenu=driver.findElement(By.id("988190743"));
				 action.moveToElement(clearMenu).build().perform();*/
				 driver.findElement(By.linkText("Clear")).click();
				 test.log(LogStatus.PASS, " Mouse hover on clear menu");
				 Thread.sleep(1000);
				 }
				 if(ProductID.equalsIgnoreCase("TLP"))
				 {
				 WebElement TLP=driver.findElement(By.id("9881908070"));
				 action.moveToElement(TLP).build().perform();
				 test.log(LogStatus.PASS, " Mouse hover on Installment loan menu");
				 Thread.sleep(3000);
				 /*WebElement clearMenu=driver.findElement(By.id("9881908073"));
				 action.moveToElement(clearMenu).build().perform();*/
				 driver.findElement(By.linkText("Clear")).click();
				 test.log(LogStatus.PASS, " Mouse hover on clear menu");
				 }
				 
				 driver.findElement(By.id("9881908084")).click();
				 driver.switchTo().defaultContent();
				 driver.switchTo().frame("mainFrame");
				 driver.switchTo().frame("main");
				 driver.findElement(By.name("requestBean.locationNbr")).sendKeys(StoreId);
				 test.log(LogStatus.PASS, "entered store no as " + StoreId);
				 Thread.sleep(2000);
				 driver.findElement(By.name("submit")).click();
				 test.log(LogStatus.PASS, "clicked on clear submit button");
				 Thread.sleep(2000);
				 driver.findElement(By.name("requestBean.chkName")).click();
				 test.log(LogStatus.PASS, "clicked on clear check box");
				 driver.findElement(By.name("CmdReturnPosting")).click();
				 test.log(LogStatus.PASS, "clicked on finish clear button");
				 driver.findElement(By.name("Ok")).click();
				 test.log(LogStatus.PASS, "clicked on finish clear ok button");
				}
			}
		}



}
