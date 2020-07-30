package QCHome;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import com.relevantcodes.extentreports.LogStatus;
public class QCCSRBuyBack extends CSR{
	public static String State;
	public static String SSN1;
	public static String SSN2;
	public static String SSN3;

	public static void buyback(String SSN, String AppURL) throws InterruptedException {

		int lastrow = TestData.getLastRow("NewLoan");
		String sheetName = "NewLoan";

		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			
			String PIN = TestData.getCellData(sheetName,"Password",row);
			if (SSN.equals(RegSSN)) {
				//State = TestData.getCellData(sheetName,"StateID",row);



				SSN1 = SSN.substring(0, 3);
				SSN2 = SSN.substring(3,5);
				SSN3 = SSN.substring(5,9);


				Thread.sleep(2000);
				test.log(LogStatus.INFO,"Buy Back started");
				driver.switchTo().frame("topFrame");
				driver.findElement(locator(prop.getProperty("transactions_tab"))).click();			
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();			
				test.log(LogStatus.PASS, "Clicked on Transaction");		
				driver.switchTo().frame("main");	
				Thread.sleep(500);
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: "+SSN1);
				driver.findElement(locator(prop.getProperty("CSR_SSN_second_field"))).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: "+SSN2);
				driver.findElement(locator(prop.getProperty("CSR_SSN_third_field"))).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: "+SSN3);
				driver.findElement(locator(prop.getProperty("csr_new_loan_submit_button"))).click();
				test.log(LogStatus.PASS, "Clicked on submit Button");		
				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);				
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");					    					   					     
					driver.findElement(locator(prop.getProperty("csr_new_loan_go_button"))).click();
					test.log(LogStatus.PASS, "Clicked on GO Button");
					Thread.sleep(200);					  

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");

					driver.findElement(By.xpath("//input[@value='Go' and @type='button']")).click();
					test.log(LogStatus.PASS, "Clicked on GO Button");
					Thread.sleep(200);
					driver.findElement(By.name("transactionList")).sendKeys("Payment");
					test.log(LogStatus.PASS, "Transaction Type is selected as Payment");
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Clicked on Go button");
					Thread.sleep(500);	
					driver.findElement(By.id("PD3")).click();
					test.log(LogStatus.PASS, "Clicked on payoff balance ");
					driver.findElement(By.name("requestBean.siilBean.tenderTypeFirst")).sendKeys("Cash");
					test.log(LogStatus.PASS, "Tender Type is : Cash");
					String Paymentamt = driver.findElement(By.name("requestBean.siilBean.payAmt")).getAttribute("value");
					test.log(LogStatus.PASS, "Payment amount is :"+Paymentamt);
					driver.findElement(By.name("requestBean.siilBean.tenderAmtFirst")).sendKeys(Paymentamt);
					test.log(LogStatus.PASS, "Tender amount entered :"+Paymentamt);
					driver.findElement(By.name("requestBean.password")).sendKeys(PIN);
					test.log(LogStatus.PASS, "Pin is entered");
					driver.findElement(By.name("finish")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Buyback");
					Thread.sleep(1000);
					try { 
						Alert alert = driver.switchTo().alert();

						alert.accept();
						//if alert present, accept and move on.														

					}
					catch (NoAlertPresentException e) {
						//do what you normally would if you didn't have the alert.
					}
					Thread.sleep(5000);
					driver.findElement(By.name("Ok")).click();
					test.log(LogStatus.PASS, "Clicked on Ok");
					//test.log(LogStatus.PASS, "BuyBack Completed Successfully");
					test.log(LogStatus.PASS,"BuyBack Completed Successfully");

					
					break;
				}
			}


		}
		// }

	}



}

