package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;

public class QCDeliquentLoan extends QCStore {

	public static void delinquent(String SSN, String AppURL) throws InterruptedException {

		int lastrow = TestData.getLastRow("Deposit");
		String sheetName = "Deposit";

		for (int row = 2; row <= lastrow; row++) {
			String RegSSN = TestData.getCellData(sheetName, "SSN", row);
			if (SSN.equals(RegSSN)) {
				// String Deposit_Type =
				// TestData.getCellData(sheetName,"RepresentmentType",row);
				String PIN = TestData.getCellData(sheetName, "Password", row);
				String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

				String SSN1 = SSN.substring(0, 3);
				String SSN2 = SSN.substring(3, 5);
				String SSN3 = SSN.substring(5, 9);

				Thread.sleep(1000);

				test.log(LogStatus.INFO, "Veriyfing loan in Delinquent status");

				driver.switchTo().frame("bottom");
				String Str_date = driver.findElement(By.xpath("/html/body/blink/table/tbody/tr/td[4]")).getText();
				test.log(LogStatus.PASS, "" + Str_date);
				String store_date[] = Str_date.split(":");
				business_date = store_date[1].trim();
				test.log(LogStatus.PASS, "Business date is :" + business_date);

				driver.switchTo().defaultContent();

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("topFrame")));
				driver.switchTo().frame("topFrame");
				wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[id='910000']")));
				driver.findElement(By.cssSelector("li[id='910000']")).click();
				test.log(LogStatus.PASS, "Clicked on Loan Transactions");
				Thread.sleep(3000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");

				driver.findElement(By.cssSelector("li[id='911101']")).click();
				test.log(LogStatus.PASS, "Clicked on Transactions");
				driver.switchTo().frame("main");
				driver.findElement(By.name("ssn1")).sendKeys(SSN1);
				test.log(LogStatus.PASS, "SSN1 is entered: " + SSN1);
				driver.findElement(By.name("ssn2")).sendKeys(SSN2);
				test.log(LogStatus.PASS, "SSN2 is entered: " + SSN2);
				driver.findElement(By.name("ssn3")).sendKeys(SSN3);
				test.log(LogStatus.PASS, "SSN3 is entered: " + SSN3);
				driver.findElement(By.name("submit1")).click();
				test.log(LogStatus.PASS, "Click on submit Button");

				driver.findElement(By.name("button")).click();
				test.log(LogStatus.PASS, "Clicked on Go button under search results");

				// String
				// loan_nbr=driver.findElement(By.name("/html/body/form[1]/table/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr[7]/td[2]/table/tbody/tr/td/table/tbody/tr[5]/td[2]")).getText();

				driver.findElement(locator(prop.getProperty("clear_go"))).click();
				test.log(LogStatus.PASS, "Clicked on Go button under Loans section");

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				Thread.sleep(4000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame("mainFrame");
				driver.switchTo().frame("main");

				String BalanceStatus = driver
						.findElement(By
								.xpath("/html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]"))
						.getText();
				/// html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]
				if (BalanceStatus.equalsIgnoreCase("Delinquent")) {
					test.log(LogStatus.PASS, "Loan status is Delinquent");
				} else {
					test.log(LogStatus.FAIL, "Loan status is not Delinquent");
				}
				/// html/body/table/tbody/tr/td/table/tbody/tr/td/form/table[2]/tbody/tr[7]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[11]/table/tbody/tr/td[1]/select

				// List<WebElement> list=
				List<WebElement> options=driver.findElements(By.xpath("//select[@name='transactionList']/option"));
				int n=options.size();
				for (int i = 1; i <= n; i++) {

					String value = driver.findElement(By.xpath("//select[@name='transactionList']/option["+i+"]")).getAttribute("value");
					if (value.equalsIgnoreCase("Draw")) {
						test.log(LogStatus.FAIL, "Draw option available in the list");
						break;
					}
					if (!value.equalsIgnoreCase("Draw")) {
						
						if(i==n)
						{
							test.log(LogStatus.PASS, "Draw option is not available in the list");
							test.log(LogStatus.PASS, "*********************************************");
							break;
						}
					}
					
				}

				break;

			}

		}

	}
}
