package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

public class QCRedeposit extends QCStore {

	public static void redeposit(String SSN, String AppURL) throws Exception {
		
		

			int lastrow = TestData.getLastRow("Redeposit");
			String sheetName = "Redeposit";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);

				if (SSN.equals(RegSSN)) {
					//loan_nbr="11542370";
					String Representation_Type = TestData.getCellData(sheetName, "Representation_Type", row);

					test.log(LogStatus.PASS, "Re Deposit has started");

					driver.switchTo().frame("topFrame");
					driver.findElement(locator(prop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					/*driver.findElement(By.partialLinkText("ACH")).click();
					test.log(LogStatus.PASS, "Clicked on ACH");
					driver.findElement(By.partialLinkText("LOC")).click();
					test.log(LogStatus.PASS, "Clicked on LOC");
					//driver.findElement(By.partialLinkText("ReDeposit")).click()*/
					 Actions action = new Actions(driver);  
					 WebElement ACH=driver.findElement(By.id("913000"));
					 action.moveToElement(ACH).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on ACH menu");
					 Thread.sleep(3000);
					
					 WebElement loc=driver.findElement(By.id("9881909175"));
					 action.moveToElement(loc).build().perform();
					 test.log(LogStatus.PASS, " Mouse hover on LOC loan menu");
					 Thread.sleep(3000);
					 
					 driver.findElement(By.id("9881909178")).click();
					 test.log(LogStatus.PASS, " click on ACH Redeposit");
					 Thread.sleep(3000);
					
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_nbr);
					test.log(LogStatus.PASS, "Enterd loan number is :" + loan_nbr);
					driver.findElement(By.name("submit")).click();
					test.log(LogStatus.PASS, "Click on submit button");
					Thread.sleep(3000);
					driver.findElement(By.name("requestBean.chkName")).click();
					test.log(LogStatus.PASS, "Selected the check box");
					//driver.findElement(By.name("dispRepresentmentType")).sendKeys(Representation_Type);
					//test.log(LogStatus.PASS, "Selected the Representation Type as "+Representation_Type);
					driver.findElement(By.name("CmdReturnPosting")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Deposit button "+Representation_Type);
					test.log(LogStatus.PASS, "Re Deposit is successful");
					test.log(LogStatus.PASS, "*************************************");


					break;
				}

			}
			
		
	}
		
	}

