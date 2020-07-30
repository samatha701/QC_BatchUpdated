package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;*/

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class QCStore {

	public static WebDriverWait wait;
	public static WebDriver driver;
	public static WebDriver driver1;
	String appUrl;
	String timestamp = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss").format(new Date());

	public static Properties prop;
	public static Properties Jprop;
	public static Properties Rprop;
	public static Properties Aprop;
	public static String loan_number;
	public static ExtentReports reports;
	public static ExtentTest test;
	// public static ExtentReports reports;
	// public static ExtentTest test;
	// static ExtentHtmlReporter htmlReporter;
	// static ExtentReports extent;
	public static String Eankey = null;
	public static String encryption_store_no = null;
	public static String encryption_transaction_nbr = null;
	public static String FileName;
	public static ExcelNew TestData;
	public static String loan_nbr;
	public static String business_date;
	public static String NextDueDate;
	public static String AppURL;
	public static String AdminURL;
	public static String transaction_date;

	public static String ESign_CheckNbr;
	public static String Password;
	public static String ESign_CollateralType;
	public static String Date1;
	public static String Date2;
	public static String Date3;
	public static String customer_number;

	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;

	public static String Due_Date1;
	public static String Due_Date2;
	public static String Due_Date3;

	public static String Str_date;
	public static String Ctc_PrimaryPhone;
	public static String Storeid;
	public static String SSN;
	public static String PP1;
	public static String PP2;
	public static String PP3;

	public static String age_Date1;
	public static String age_Date2;
	public static String age_Date3;
	public static String appdate;
	public static String day;

	@Test(priority = 101, groups="Brahmith1")
	public static void QC_TLP_NewLoan_Txn() throws Exception {
		
			
			test = reports.startTest((prop.getProperty("QC_TLP_NewLoan_Txn_scenario")),
					"Login->Borrower Registratino->New Loan");

			FileName = prop.getProperty("QC_TLP_NewLoan2_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					
					/*QCCSRLoginLogout.adminLogin(SSN, SSN);
					BAdminStartDate.toStartdate(SSN, SSN);
					QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
					BProc3.proc();*/
					

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority=103,groups="Brahmith1")
	public static void QC_NewLoan_Promotion_Txn() throws Exception {
		

			test = reports.startTest(prop.getProperty("QC_TLP_NewLoan_Promotion_Txn_scenario"),
					"Login->Borrower Registration->New Loan with Promotion");

			FileName = prop.getProperty("QC_TLP_NewLoan_Promotion_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

		
			String sheetName = "Start";
			int lastrow = TestData.getLastRow("Start");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		
	}

	@Test(priority = 104,groups="Brahmith1")
	public static void QC_NewLoan_Void_Txn() throws Exception {
		
			test = reports.startTest((prop.getProperty("QC_TLP_NewLoan_Void_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->Void");

			FileName = prop.getProperty("QC_TLP_NewLoan_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
                String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 105,groups="Brahmith1")
	public static void QC_AgeStore_Void_Txn() throws Exception {
		
			test = reports.startTest((prop.getProperty("QC_TLP_AgeStore_Void_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->Void");

			FileName = prop.getProperty("QC_TLP_AgeStore_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCEncryptionDetails.readEncryptionDetails(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				
					QCAdminEncryption.getEncryption(driver, SSN, AppURL);
			
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreVoid.ageStoreVoid(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 116,groups="Brahmith")
	public static void QC_TLP_Buyback_Txn() throws Exception {
		
			test = reports.startTest((prop.getProperty("QC_TLP_Buyback_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->Pay Off the balance");

			FileName = prop.getProperty("QC_TLP_Buyback_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
			
				if (RunFlag.equals("Y")) {

				
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 117,groups="Brahmith")
	public static void QC_TLP_Buyback_Void_Txn() throws Exception {
		
			test = reports.startTest((prop.getProperty("QC_TLP_Buyback_Void_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->Payment Pay Off the balance-> Void");

			FileName = prop.getProperty("QC_TLP_Buyback_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 118,groups="Brahmith")
	public static void QC_Installmentpayment_Txn() throws Exception {
		
			test = reports.startTest((prop.getProperty("QC_TLP_Installmentpayment_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->PartialPayment Pay Installment Amt");

			

			FileName = prop.getProperty("QC_TLP_Installmentpayment_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 119, groups = "Brahmith")
	public static void QC_Installmentpayment_Void_Txn() throws Exception {
		
			test = reports.startTest((prop.getProperty("QC_TLP_Installmentpayment_Void_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->PartialPayment Pay Installment Amt->Void");

			FileName = prop.getProperty("QC_TLP_Installmentpayment_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 120,groups="Brahmith")
	public static void QC_PayAnyotherAmount_Txn() throws Exception {
		
			test = reports.startTest((prop.getProperty("QC_TLP_Payanyotheramount_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->PartialPayment Payanyotheramount");


			FileName = prop.getProperty("QC_TLP_Payanyotheramount_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 121,groups="Brahmith")
	public static void QC_PayAnyotherAmount_Void_Txn() throws Exception {
		
			test = reports.startTest((prop.getProperty("QC_TLP_Payanyotheramount_Void_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->AgeStore->PartialPayment Payanyotheramount-> Void");

			FileName = prop.getProperty("QC_TLP_Payanyotheramount_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 131,groups="Brahmith")
	public static void QC_TLP_Writeoff_Recovery_Txn() throws Exception {
		
			test = reports.startTest((prop.getProperty("QC_TLP_Writeoff_Recovery_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->AgeStor Duedate->Write Off->Age Store to Gracedays->WriteOff Recovery");

			FileName = prop.getProperty("QC_TLP_Writeoff_Recovery_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCCSRWriteOff.writeoff(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRWriteOffRecovery.writeoffrecovery(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 132,groups="Brahmith")
	public static void QC_TLP_Writeoff_Recovery_Void_Txn() throws Exception {
		
			test = reports.startTest((prop.getProperty("QC_TLP_Writeoff_Recovery_Void_Txn_scenario")),
					"Login->Borrower Registratino->New Loan->AgeStor Duedate->Write Off->Age Store to Gracedays->WriteOff Recovery->Void");

			
			FileName = prop.getProperty("QC_TLP_Writeoff_Recovery_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

				    String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);

					QCCSRWriteOff.writeoff(SSN, SSN);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, SSN);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRWriteOffRecovery.writeoffrecovery(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
			}
	// Janaki Scenarios

	@Test(priority = 204, enabled = true, groups = "Janaki")
	public static void JQC_TLP_Deposit_Menu_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_TLP_Deposit_Menu_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit Menu");

			FileName = Jprop.getProperty("QC_TLP_Deposit_Menu_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositMenu.depositMenu(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "JQC_TLP_Deposit_Menu_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario 11 JQC_TLP_Deposit_Menu_Txn ");

		}
	}

	@Test(priority = 203, enabled = true, groups = "Janaki")
	public static void JQC_TLP_Deposit_dropdown_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_TLP_Deposit_dropdown_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit Dropdown");

			FileName = Jprop.getProperty("QC_TLP_Deposit_dropdown_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "JQC_TLP_Deposit_dropdown_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario 08 JQC_TLP_Deposit_dropdown_Txn ");

		}
	}

	@Test(priority = 202, enabled = true, groups = "Janaki")
	public static void JQC_TLP_GraceDays_Deposit_Menu_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_TLP_GraceDays_Deposit_Menu_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit Dropdown");

			FileName = Jprop.getProperty("QC_TLP_GraceDays_Deposit_Menu_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositMenu.depositMenu(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "JQC_TLP_GraceDays_Deposit_Menu_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario 15 JQC_TLP_GraceDays_Deposit_Menu_Txn ");

		}
	}

	@Test(priority = 201, enabled = true, groups = "Janaki")
	public static void JQC_TLP_GraceDays_Deposit_MidDay_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_TLP_GraceDays_Deposit_MidDay_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit through MidDay");

			FileName = Jprop.getProperty("QC_TLP_GraceDays_Deposit_MidDay_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					CSRMidDayDeposit.middeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "JQC_TLP_GraceDays_Deposit_MidDay_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario 13 JQC_TLP_GraceDays_Deposit_MidDay_Txn ");

		}
	}

	@Test(priority = 200, enabled = true, groups = "Janaki")
	public static void JQC_TLP_Deposit_MidDay_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_TLP_Deposit_MidDay_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit through MidDay");

			FileName = Jprop.getProperty("QC_TLP_Deposit_MidDay_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					CSRMidDayDeposit.middeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "JQC_TLP_Deposit_MidDay_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario 10 JQC_TLP_Deposit_MidDay_Txn ");

		}
	}

	@Test(priority = 205, enabled = true, groups = "Janaki")
	public static void JQC_TLP_GraceDays_Deposit_dropdown_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_TLP_GraceDays_Deposit_dropdown_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit Dropdown");

			FileName = Jprop.getProperty("QC_TLP_GraceDays_Deposit_dropdown_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "JQC_TLP_GraceDays_Deposit_dropdown_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario 12 JQC_TLP_GraceDays_Deposit_dropdown_Txn ");

		}
	}

	// Date: 01/02/2018
	@Test(priority = 206, enabled = true, groups = "Janaki")

	public static void JQC_TLP_Deceased_Txn() throws Exception {
		try {

			test = reports.startTest(Jprop.getProperty("QC_TLP_Deceased_Txn"),
					"Login->Borrower Registratino->New Loan ->Deceased");

			FileName = Jprop.getProperty("QC_TLP_Deceased_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQC_Deceased.Deceased(SSN, AppURL);
					JQCAdmin_Bankruptcy.Admin_Bankruptcy(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}

		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "JQC_TLP_Deceased_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario 12 JQC_TLP_Deceased_Txn ");

		}

	}

	@Test(priority = 207, enabled = true, groups = "Janaki")
	public static void JQC_DefaultPayment_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_DefaultPayment"),
					"Login->Borrower Registration->New Loan->Age the Store installment wise to make a loan Default->DefaultPayment");
			String FileName = "QC_DefaultPayment_Txn_Testdata.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRDefault.sdefault(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "JQC_DefaultPayment_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenarios ");

		}
	}

	@Test(priority = 208, enabled = true, groups = "Janaki")
	public static void JQC_DefaultPayment_Void_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(("QC_DefaultPayment_Void"),
					"Login->Borrower Registration->New Loan->Age the Store installment wise to make a loan Default->DefaultPayment-->Void");
			String FileName = "QC_DefaultPayment_Void_Txn_Testdata.xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRDefault.sdefault(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRDefaultPayment.sdefaultpayment(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRDefaultVoid.svoid(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			String screenshotPath = getScreenhot(driver, "JQC_DefaultPayment_Void_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenarios ");

		}
	}

	// Date: 01/02/2018
	@Test(priority = 209, enabled = true, groups = "Janaki_EOD_set1")
	public static void JQC_TLP_Deposit_EOD_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_TLP_Deposit_EOD_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->Deposit EOD");

			FileName = Jprop.getProperty("QC_TLP_Deposit_EOD_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);

					JQCEODDeposit.eodDeposit(SSN, AppURL);

					JQCAdminStoreSetup.storeSetup(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCSafeAssign.safeAssign(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDrawerAssign.drawerAssign(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "JQC_TLP_Deposit_EOD_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario 09 JQC_TLP_Deposit_EOD_Txn ");

		}
	}

	// Date:01/11/2018
	@Test(priority = 210, enabled = true, groups = "Janaki_EOD_set2")
	public static void JQC_TLP_GraceDays_Deposit_EOD_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_TLP_GraceDays_Deposit_EOD_Txn"),
					"Login->Borrower Registratino->New Loan with Promotion->Age Store->GraceDays->Deposit EOD");

			FileName = Jprop.getProperty("QC_TLP_GraceDays_Deposit_EOD_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {
				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {
					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					System.out.println(AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCEODDeposit.eodDeposit(SSN, AppURL);

					JQCAdminStoreSetup.storeSetup(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCSafeAssign.safeAssign(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDrawerAssign.drawerAssign(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test" + e);
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "JQC_TLP_GraceDays_Deposit_EOD_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario 14 JQC_TLP_GraceDays_Deposit_EOD_Txn ");

		}
	}

	// Anoop scenariso

	@Test(priority = 310,enabled=true,groups="Anoop_bankruptcy")
	// This is date dependent so needs to run on 01/02/2018
	public void TLP_bankruptcyDismiss() throws Exception {

		FileName = "QC_TLP_bankruptcyDismiss.xls";
		test = reports.startTest("QC_TLP_bankruptcyDismiss", "Loan - bankruptcy - age the store -Dismiss");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ATLP_GetLoanNumber.loannumber(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQCbankruptcy.bankruptcy(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				AQCAdminLoginLogout.login(SSN, AppURL);
				ATLPBankruptcyDismiss.dismiss(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Bankruptcy dismiss is pass******");

			}
		}
	}

	@Test(priority = 309,enabled=true,groups="Anoop_writeoff")
	// This is date dependent so needs to run on 01/02/2018
	public void TLP_bankruptcyWriteOff() throws Exception {

		FileName = "QC_TLP_bankruptcyWriteOff.xls";
		test = reports.startTest("QC_TLP_bankruptcyWriteOff", "Loan - bankruptcy - age the store - write off recovery");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ATLP_GetLoanNumber.loannumber(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQCbankruptcy.bankruptcy(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Bankruptcy write off recovery  is pass******");
			}
		}
	}

	@Test(priority = 300,enabled=true,groups="Anoop_st_void")
	// Date will be /03/12/218
	public void TLP_RefinanceStepDownVoid() throws Exception {

		FileName = "QC_TLP_StepDownVoid.xls";
		test = reports.startTest("QC_TLP_StepDownVoid",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Step Down-->Void");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ATLP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ATLPRefinanceStepDown.StepDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Step Down void is pass******");
			}
		}
	}

	@Test(priority = 310,enabled=true,groups="Anoop_st_down")
	// Date will be /03/12/218
	public void TLP_RefinanceStepDown() throws Exception {

		FileName = "QC_TLP_StepDown.xls";
		test = reports.startTest("QC_TLP_StepDown",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Step Down");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ATLP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ATLPRefinanceStepDown.StepDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Step Down  is pass******");
			}
		}
	}

	@Test(priority = 308,enabled=true,groups="Anoop")

	public void TLP_ProcessAutoClear() throws Exception {

		FileName = "QC_TLP_ProcessAutoClear.xls";
		test = reports.startTest("QC_TLP_ProcessAutoClear",
				"Loan -->Age the store upto duedate --> perform deposit-->Ach process--> age the store -->Auto clear");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				ATLPACHProcessing.achProcess(SSN, SSN);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AAutoclearCheck.autoclear(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Process Auto Clear  is pass******");
			}
		}
	}

	@Test(priority = 306,enabled=true,groups="Anoop")

	public void TLP_ProcessClearFromMenu() throws Exception {

		FileName = "QC_TLP_ProcessClearMenu.xls";
		test = reports.startTest("QC_TLP_ProcessClearMenu",
				"Loan -->Age the store upto duedate --> perform deposit--> age the store -->process Clear from Menu");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				ATLPACHProcessing.achProcess(SSN, SSN);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCClearMenu.clearMenu(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Process Clear from menu is pass******");
			}
		}
	}

	@Test(priority = 307,enabled=true,groups="Anoop")

	public void TLP_ProcessClear() throws Exception {

		FileName = "QC_TLP_ProcessClear.xls";
		test = reports.startTest("QC_TLP_ProcessClear",
				"Loan -->Age the store upto duedate --> perform deposit--> age the store -->process Clear from drop Down");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				ATLPACHProcessing.achProcess(SSN, SSN);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AILPClearFromDropDown.clearDropdown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Process Clear  is pass******");
			}
		}
	}

	@Test(priority = 305,enabled=true,groups="Anoop")

	public void TLP_RefinanceStepSame_Void() throws Exception {

		FileName = "QC_TLP_StepSameVoid.xls";
		test = reports.startTest("QC_TLP_StepSameVoid",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Step Same Void");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ATLP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ATLP_Refinance_StepSame.StepSame(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCVoid.qcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Step Same Void  is pass******");
			}
		}
	}

	@Test(priority = 304,enabled=true,groups="Anoop")

	public void TLP_RefinanceStepSame() throws Exception {

		FileName = "QC_TLP_StepSame.xls";
		test = reports.startTest("QC_TLP_StepSame",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Step Same");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ATLP_Payment.payment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ATLP_Refinance_StepSame.StepSame(SSN, AppURL);
				;
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Step Same  is pass******");
			}
		}
	}

	@Test(priority = 303,enabled=true,groups="Anoop")

	public void TLP_agerescind() throws Exception {
		test = reports.startTest("QC_NewLoan_AgeRescind", "Login-->Age the loan to rescind days--->Rescind loan");
		FileName = "QC_NewLoan_AgeRescind.xls";

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");

		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.rescind(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				// test.log(LogStatus.INFO, "****Test Scenario for age to store
				// loan rescind is pass******");

			}
		}
	}

	@Test(priority = 302,enabled=true,groups="Anoop")

	public void TLP_rescindloan() throws Exception {
		test = reports.startTest("TLP_rescindloan", "Loan->NewLoan-->Rescind");
		FileName = "QC_TLP_RescindLoan.xls";

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRNewLoan.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.rescind(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO,
						"**********************Test Scenario for  loan rescind  is pass***********************");

			}
		}
	}

	@Test(priority = 301,enabled=true,groups="Anoop")
	public void newLoan() throws Exception {
		FileName = "QC_TLP_NewLoan.xls";
		test = reports.startTest("QC_TLP_NewLoan", "Login-->Home screen--> Inactive customer--> New Loan");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);

			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanInactivecust.newLoanInact(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Inactive customer new loan is pass******");
			}
		}
	}

	@BeforeClass(alwaysRun = true)

	public void setup() throws IOException {

		try {

			// prop=prop.getProperty("user.dir")+"/Tests/Objects.properties";
			BufferedReader reader;
			BufferedReader Jreader;
			BufferedReader Rreader;
			BufferedReader Areader;
			try {
				reader = new BufferedReader(
						new FileReader("C:/QC_Batch/QC_TLP/src/test/java/tests/Objects.properties"));
				prop = new Properties();
				prop.load(reader);
				reader.close();
				AppURL = prop.getProperty("CSR_URL");
				AdminURL = prop.getProperty("ADMIN_CSR_URL");
				String filename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + filename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Jreader = new BufferedReader(

						new FileReader("C:/QC_Batch/QC_TLP/src/test/java/tests/JObjects.properties"));

				Jprop = new Properties();
				Jprop.load(Jreader);
				Jreader.close();
				String Jfilename = Jprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Jprop.getProperty("QC_Store_extent_report_path") + Jfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Rreader = new BufferedReader(
						new FileReader("C:/QC_Batch/QC_TLP/src/test/java/tests/RObjects.properties"));
				Rprop = new Properties();
				Rprop.load(Rreader);
				Rreader.close();
				String filename = Rprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Rprop.getProperty("QC_Store_extent_report_path") + filename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Areader = new BufferedReader(
						new FileReader("C:/QC_Batch/QC_TLP/src/test/java/tests/AObjects.properties"));
				Aprop = new Properties();
				Aprop.load(Areader);
				Areader.close();
				String filename = Aprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Aprop.getProperty("QC_Store_extent_report_path") + filename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
		//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/MicrosoftWebDriver.exe");

		}

		catch (Exception e) {
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// setup for the QC Store " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)

	public void killProcess() throws Exception {

		try {

			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(5000); // Allow OS to kill the process
			System.out.println("killed the process in TLP");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/TLP/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod(alwaysRun = true)

	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			// test.log(LogStatus.FAIL, "Test Case Failed is
			// "+result.getThrowable());

			String screenshotPath = getScreenhot(driver, result.getName());
			// To add it in the extent report
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " Test Case is Passed");
		}
		reports.flush();
		driver.quit();

	}

	@AfterMethod(alwaysRun = true)

	public void endReport() {

		// reports.endTest(test);
		// reports.flush();

		// driver.quit();
		// extent.flush();

	}

	public static By locator(String obj) {

		String loctype = null;
		String locname = null;
		By locator = null;
		String[] locobj = obj.split("%%");
		loctype = locobj[0];
		locname = locobj[1];
		// System.out.println("startign of switch case");
		// System.out.println(obj);
		/*
		 * switch(loctype) { case "id": locator=By.id(locname); break; case
		 * "name": locator=By.name(locname); break; case "linkText":
		 * locator=By.linkText(locname); break; case "xpath":
		 * locator=By.xpath(locname); case "cssSelector":
		 * locator=By.cssSelector(locname); break; }
		 */

		if (loctype.equalsIgnoreCase("id"))
			return locator = By.id(locname);
		else if (loctype.equalsIgnoreCase("name"))
			return locator = By.name(locname);
		else if (loctype.equalsIgnoreCase("linkText"))
			return locator = By.linkText(locname);
		else if (loctype.equalsIgnoreCase("partialLinkText"))
			return locator = By.partialLinkText(locname);
		else if (loctype.equalsIgnoreCase("xpath"))
			return locator = By.xpath(locname);
		else if (loctype.equalsIgnoreCase("cssSelector"))
			return locator = By.cssSelector(locname);
		return locator;

		// System.out.println(locator);
		// return locator;

	}

}
