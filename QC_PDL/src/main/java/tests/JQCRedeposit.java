package tests;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class JQCRedeposit extends QCStore {

	public static void redeposit(String SSN, String AppURL) {
		int i;
		for (i = 0; i < 3; i++) {
		try {

			int lastrow = TestData.getLastRow("Redeposit");
			String sheetName = "Redeposit";

			for (int row = 2; row <= lastrow; row++) {
				String RegSSN = TestData.getCellData(sheetName, "SSN", row);

				if (SSN.equals(RegSSN)) {
					String Representation_Type = TestData.getCellData(sheetName, "RepresentationType", row);

					test.log(LogStatus.PASS, "Re Deposit has started");

					driver.switchTo().frame("topFrame");
					driver.findElement(locator(Jprop.getProperty("transactions_tab"))).click();
					test.log(LogStatus.PASS, "Clicked on Loan Transactions");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.findElement(By.partialLinkText("Collateral Checks")).click();
					test.log(LogStatus.PASS, "Clicked on collateral check types");
					driver.findElement(By.partialLinkText("Payday Loan")).click();
					test.log(LogStatus.PASS, "Clicked on Paydayloan");
					driver.findElement(By.partialLinkText("ReDeposit")).click();
					test.log(LogStatus.PASS, "Clicked on Redeposit");

					driver.switchTo().defaultContent();
					driver.switchTo().frame("mainFrame");
					driver.switchTo().frame("main");
					driver.findElement(By.name("requestBean.loanCode")).sendKeys(loan_nbr);
					test.log(LogStatus.PASS, "Enterd loan number is :" + loan_nbr);
					driver.findElement(By.name("button")).click();
					test.log(LogStatus.PASS, "Click on submit button");
					Thread.sleep(1000);
					driver.findElement(By.name("requestBean.chkName")).click();
					test.log(LogStatus.PASS, "Selected the check box");
					driver.findElement(By.name("dispRepresentmentType")).sendKeys(Representation_Type);
					test.log(LogStatus.PASS, "Selected the Representation Type as "+Representation_Type);
					driver.findElement(By.name("CmdReturnPosting")).click();
					test.log(LogStatus.PASS, "Clicked on Finish Deposit button ");
					test.log(LogStatus.PASS, "Re Deposit is successful");
					test.log(LogStatus.PASS, "*************************************");


					break;
				}

			}
			break;
		}

		catch (Exception e) {

			test.log(LogStatus.INFO, "" + e);
			test.log(LogStatus.INFO, "Re Deposit intiated again due to Application sync issue");
			driver.get("http://192.168.2.203/cc/login/index.jsp");
			continue;

		}

	}
		if(i==3)
		{
			test.log(LogStatus.FAIL, "Re Deposit is failed");
	
		}
	}
}
