package tests;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

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
	public static String AppURL;
	public static String AdminURL;

	public static String FirstName;
	public static String passwrd;
	public static String report_filename;
	public static String LastName;
	public static String ESign_CheckNbr;
	public static String ESign_CollateralType;

	public static String NextDueDate;

	@Test(priority = 100, groups = { "1stBatch" })
	public static void QC_NewLoan_Promotion_Txn() throws Exception {
		
			
			test = reports.startTest("QC_NewLoan_Promotion_Txn",
					"Login->Borrower Registratino->New Loan with Promotion");

			FileName = prop.getProperty("QC_Store_BorrowerRegistration_NewLoan_Promotion_Txn_file_name") + ".xls";

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
					//History.history(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
			}

	@Test(priority = 108, groups = { "1stBatch" })
	public static void QC_OpenLoan_NewLoan_Txn() throws Exception {
		
			test = reports.startTest("QC_OpenLoan_NewLoan_Txn", "Login->Borrower Registratino->Open Loan->New Loan");

			FileName = prop.getProperty("QC_Store_QC_OpenLoan_NewLoan_Txn_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";

			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					//History.history(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
			}

	@Test(priority = 109, groups = { "1stBatch" })
	public static void QC_NewLoan_Void_Txn() throws Exception {
		
			
			test = reports.startTest("QC_NewLoan_Void_Txn", "Login->Borrower Registratino->New Loan->Void");

			FileName = prop.getProperty("QC_Store_NewLoan_Void_Txn_file_name") + ".xls";

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
					//History.history(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 110, groups = { "1stBatch" })
	public static void QC_AgeStore_Void_Txn() throws Exception {
		
			
			test = reports.startTest("QC_AgeStore_Void_Txn", "Login->Borrower Registratino->New Loan->AgeStore->Void");

			FileName = prop.getProperty("QC_Store_AgeStore_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);

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
					QCCSRLoginLogout.adminLogin( SSN, AppURL);
					QCAdminEncryption.getEncryption(driver, SSN, AppURL);
				    QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreVoid.ageStoreVoid(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					//History.history(SSN, SSN);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 111, groups = { "1stBatch" })
	public static void QC_Deposit_Menu_Txn() throws Exception {
		
			test = reports.startTest("QC_Deposit_Menu_Txn",
					"Login->Borrower Registratino->New Loan->AgeStore->Deposit through Menu");

			FileName = prop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name") + ".xls";
            TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);
                    
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
                    QCDepositMenu.depositMenu(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					
				}
			}
		
	}

	@Test(priority = 112, groups = { "1stBatch" })
	public static void QC_Deposit_GraceDays_Txn() throws Exception {
		
			
			test = reports.startTest("QC_Deposit_GraceDays_Txn",
					"Login->Borrower Registration->New Loan->AgeStore Duedate->AgeStore Gracedays->Deposit through dropdown");

			FileName = prop.getProperty("QC_Store_AgeStore_Deposit_GraceDays_Dropdown_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
                    QCDepositDropdown.depositDropDown(SSN, AppURL);
                    QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 113, groups = { "1stBatch" })
	public static void QC_FutureDeposit_DropDown() throws Exception {
		
			
			test = reports.startTest("QC_FutureDeposit_DropDown",
					"Login->Borrower Registration->New Loan->AgeStore Duedate->Future Date->Age Store Gracedays->Deposit through dropdown");

			FileName = prop.getProperty("QC_FutureDeposit_DropDown_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCFutureDeposit.futureDeposit(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		
	}

	@Test(priority = 157, groups = { "1stBatch" })
	public static void QC_Epp_Deposit_Void_Txn() throws Exception {
		
			
			test = reports.startTest((prop.getProperty("QC_Epp_Deposit_Void_Txn_scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->Void");

			FileName = prop.getProperty("QC_Epp_Deposit_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCStoreEPP.epp(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, AppURL);
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

	@Test(priority = 158, groups = { "1stBatch" })
	public static void QC_Epp_PrePayment_Txn() throws Exception {
		
			
			test = reports.startTest("QC_Epp_PrePayment_Txn",
					"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->AgeStore to Due Date->Pre Payment");

			FileName = prop.getProperty("QC_Epp_PrePayment_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = 12;
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCStoreEPP.epp(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPrePayment.prePayment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		
	}

	@Test(priority = 159, groups = { "1stBatch" })
	public static void QC_Epp_Check_Deposit_Clear_Txn() throws Exception {
		
			
			test = reports.startTest("QC_Epp_Check_Deposit_Clear_Txn",
					"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->Internal transfer->->Cash Management->Clear");

			FileName = prop.getProperty("QC_Epp_Deposit_Clear_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = 12;
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCStoreEPP.epp(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCInternalTransfer.internalTransfer(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCClearDropdown.clearDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		
	}

	@Test(priority = 160, groups = { "1stBatch" })
	public static void QC_EppDepositClear_Refund_Txn() throws Exception {
		
			test = reports.startTest("QC_EppDepositClear_Refund_Txn",
					"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->AgeStore to gracedays->Pre Payment->AgeStore to gracedays->Clear->Refund");

			FileName = prop.getProperty("QC_EppDepositClear_Refund_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = 12;
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

				    String SSN = TestData.getCellData(sheetName, "SSN", row);
				    
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCStoreEPP.epp(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPrePayment.prePayment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCClearDropdown.clearDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRefund.qcRefund(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 161, groups = { "1stBatch" })
	public static void QC_Epp_PrePayment_Return_Txn() throws Exception {
		
			
			test = reports.startTest((prop.getProperty("QC_Epp_PrePayment_Return_Txn_scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->AgeStore to Due Date->Pre Payment->Internal Transfer->Cash Management->Return Posting");

			FileName = prop.getProperty("QC_Epp_PrePayment_Return_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = 12;
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCStoreEPP.epp(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPrePayment.prePayment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCInternalTransfer.internalTransfer(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, AppURL);
					QCReturnCheck.qcRturn(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		
	}

	@Test(priority = 162, groups = { "1stBatch" })
	public static void QC_Epp_Return_NSFPayment_Txn() throws Exception {
		
			
			test = reports.startTest((prop.getProperty("QC_Epp_Return_NSFPayment_Txn_scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->AgeStore to Due Date->Pre Payment->Internal Transfer->Cash Management->Return Posting->NSF Payment");

			FileName = prop.getProperty("QC_Epp_Return_NSFPayment_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = 12;
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {
                   
					String SSN = TestData.getCellData(sheetName, "SSN", row);
				    
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCStoreEPP.epp(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCInternalTransfer.internalTransfer(SSN, AppURL);
                    QCCSRLoginLogout.login(SSN, AppURL);
					QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, AppURL);
					QCReturnCheck.qcRturn(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCNSFPayment.nsfpayment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 163, groups = { "1stBatch" })
	public static void QC_Epp_Return_ReDeposit_Txn() throws Exception {
		
			
			test = reports.startTest((prop.getProperty("QC_Epp_Return_ReDeposit_Txn_scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Due Date->EPP loan->AgeStore to Due Date->Deposit through dropdown->AgeStore to Due Date->Pre Payment->Internal Transfer->Cash Management->Re Deposit");

			FileName = prop.getProperty("QC_Epp_Return_ReDeposit_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = 12;
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
			
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCStoreEPP.epp(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCInternalTransfer.internalTransfer(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, AppURL);
					QCReturnCheck.qcRturn(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCRedeposit.redeposit(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		
	}

	@Test(priority = 169, groups = { "1stBatch" })
	public static void QC_Void_FullReturnPayment_Txn() throws Exception {
		
			test = reports.startTest((prop.getProperty("QC_Void_FullReturnPayment_Txn_scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Due Date->Deposit through dropdown->Internal Transfer->Cash Management->Return Posting->Re Deposit->Internal Transfer->Cash Management->->Return Posting->Partial Payment->Void->Full Return Payment->Void->Full Return Payment");

			FileName = prop.getProperty("QC_Void_FullReturnPayment_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = 12;
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDepositDropdown.depositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCInternalTransfer.internalTransfer(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, AppURL);
					QCReturnCheck.qcRturn(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCRedeposit.redeposit(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCInternalTransfer.internalTransfer(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.adminLogin(SSN, AppURL);
					QCReturnCheck.qcRturn(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCNSFPayment.nsfpayment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCVoid.qcVoid(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCNSFPayment.nsfpayment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		
	}

	@Test(priority = 170, groups = { "1stBatch" })
	public static void QC_PartialPayment_RefundVoid_Txn() throws Exception {
		
			test = reports.startTest((prop.getProperty("QC_PartialPayment_RefundVoid_Txn_scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Due Date->Patial Payment->->Deposit through dropdown->Internal Transfer->Cash Management->Deposit clear>Refund->Void");

			FileName = prop.getProperty("QC_PartialPayment_RefundVoid_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = 12;
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

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
					QCDepositDropdown.depositDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCInternalTransfer.internalTransfer(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCCashMgmtDeposit.cashmgmtDeposit(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCClearDropdown.clearDropDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRefund.qcRefund(SSN, AppURL);

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

	@Test(priority = 102, groups = { "1stBatch" })
	public static void QC_RefinanceStepDown_Txn() throws Exception {
		
			
			test = reports.startTest("QC_RefinanceStepDown_Txn",
					"Login->Borrower Registration->New Loan->AgeStore to Gracedays->Partial Payment->Age Store to Duedate->Refinance Stepdown");

			FileName = prop.getProperty("QC_RefinanceStepDown_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCRefinance.refinanceStepDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		
	}

	@Test(priority = 103, groups = { "1stBatch" })
	public static void QC_RefinanceStepDown_Void_Txn() throws Exception {
		
			
			test = reports.startTest("QC_RefinanceStepDown_Void_Txn",
					"Login->Borrower Registration->New Loan->AgeStore to Gracedays->Partial Payment->Age Store to Duedate->Refinance Stepdown->Void");

			FileName = prop.getProperty("QC_RefinanceStepDown_Void_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				
				if (RunFlag.equals("Y")) {

					String SSN = TestData.getCellData(sheetName, "SSN", row);
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRefinance.refinanceStepDown(SSN, AppURL);
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

	@Test(priority = 201, groups = { "Rebate" })
	public static void QC_Refinance_StepDownURP_Txn() throws Exception {
		try {
			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Void_Txn_file_name"));
			test = reports.startTest("QC_Refinance_StepDownURP",
					"Login->Borrower Registration->New Loan->AgeStore to Gracedays->Partial Payment->AgeStore to Gracedays->Refinance Stepdown->Rebate");

			FileName = prop.getProperty("QC_Refinance_StepDownURP_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName, "AppURL",
					// row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					BAdminRebateDate.toStartdate(SSN, SSN);
					QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
					BProc3.proc();
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRefinance.refinanceStepDown(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to execute scenario QC_FutureDeposit_EOD_Txn ");

		}
	}

	@Test(priority = 202, groups = { "Rebate" })
	public static void QC_Refinance_StepDownVoidURP_Txn() throws Exception {
		try {
			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Void_Txn_file_name"));
			test = reports.startTest("QC_Refinance_StepDownVoidURP",
					"Login->Borrower Registration->New Loan->AgeStore to Gracedays->Partial Payment->AgeStore to Gracedays->Refinance Stepdown->Rebate->Void");

			FileName = prop.getProperty("QC_Refinance_StepDownVoidURP_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName, "AppURL",
					// row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRefinance.refinanceStepDown(SSN, AppURL);
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

		catch (Exception e) {
			System.out.println("under catch of Test");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to execute scenario QC_FutureDeposit_EOD_Txn ");

		}
	}

	@Test(priority = 198, groups = { "1stBatch_NV" })
	public static void QC_Refinance_StepSameURP_Txn() throws Exception {
		try {
			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Void_Txn_file_name"));
			test = reports.startTest("QC_Refinance_StepSameURP_Txn",
					"Login->Borrower Registration->New Loan->AgeStore to Gracedays->Partial Payment->AgeStore to Gracedays->Refinance StepSame->Rebate");

			FileName = prop.getProperty("QC_Refinance_StepSameURP_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName, "AppURL",
					// row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					QCCSRLoginLogout.adminLogin(SSN, SSN);
					BAdminNVDate.toStartdate(SSN, SSN);
					QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
					BProc3.proc();
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRefinance.refinanceStepSame(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to execute scenario QC_FutureDeposit_EOD_Txn ");

		}
	}

	@Test(priority = 199, groups = { "1stBatch_NV" })
	public static void QC_Refinance_StepSameVoidURP_Txn() throws Exception {
		try {
			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Void_Txn_file_name"));
			test = reports.startTest("QC_Refinance_StepSameVoidURP",
					"Login->Borrower Registration->New Loan->AgeStore to Gracedays->Partial Payment->AgeStore to Gracedays->Refinance StepSame->Rebate->Void");

			FileName = prop.getProperty("QC_Refinance_StepSameVoidURP_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName, "AppURL",
					// row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCPayment.payment(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays2ndTime(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCRefinance.refinanceStepSame(SSN, AppURL);
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

		catch (Exception e) {
			System.out.println("under catch of Test");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to execute scenario QC_FutureDeposit_EOD_Txn ");

		}
	}

	@Test(priority = 281, groups = { "EOD" })
	public static void QC_EOD_Deposit_Txn() throws Exception {
		try {
			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Void_Txn_file_name"));
			test = reports.startTest("QC_EOD_Deposit_Txn",
					"Login->Borrower Registration->New Loan->AgeStore Duedate->Deposit through EOD");

			FileName = prop.getProperty("QC_store_AgeStore_DueDate_Deposit_EOD_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName, "AppURL",
					// row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);

					System.out.println(AppURL);

					QCCSRLoginLogout.adminLogin(SSN, SSN);
					BAdminEODDate.toStartdate(SSN, SSN);
					QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
					BProc3.proc();
					
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);
					// QCCSRLoginLogout.logout(SSN, AppURL);
					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to execute scenario QC_store_AgeStore_DueDate_Deposit_EOD_Txn ");

		}
	}

	@Test(priority = 282, groups = { "EOD" })
	public static void QC_GraceDays_EODDeposit_Txn() throws Exception {
		try {
			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Void_Txn_file_name"));
			test = reports.startTest("QC_GraceDays_EODDeposit_Txn",
					"Login->Borrower Registration->New Loan->AgeStore Duedate->Age Store Gracedays->Deposit through EOD");

			FileName = prop.getProperty("QC_GraceDays_EODDeposit_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName, "AppURL",
					// row);
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
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);
					
					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to execute scenario QC_store_AgeStore_DueDate_Deposit_EOD_Txn ");

		}
	}

	@Test(priority = 283, groups = { "EOD" })
	public static void QC_FutureDeposit_EOD_Txn() throws Exception {
		try {
			// test =
			// extent.createTest(prop.getProperty("QC_Store_AgeStore_Void_Txn_file_name"));
			test = reports.startTest("QC_FutureDeposit_EOD_Txn",
					"Login->Borrower Registration->New Loan->AgeStore Duedate->Future Date->Age Store Gracedays->Deposit through EOD");

			FileName = prop.getProperty("QC_FutureDeposit_EOD_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ prop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);
				// System.out.println(RunFlag);
				if (RunFlag.equals("Y")) {

					// String AppURL = TestData.getCellData(sheetName, "AppURL",
					// row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRNewLoan.newLoan(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCFutureDeposit.futureDeposit(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCEODDeposit.eodDeposit(SSN, AppURL);

					QCAdminStoreSetup.storeSetup(SSN, AppURL);
					QCCSRLoginLogout.adminLogout(driver, SSN, AppURL);

					QCCSRLoginLogout.login(SSN, AppURL);
					QCSafeAssign.safeAssign(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCDrawerAssign.drawerAssign(SSN, AppURL);

					QCCSRLoginLogout.logout(SSN, AppURL);
					QCCSRLoginLogout.login(SSN, AppURL);
					QCCSRHistory.history(SSN, AppURL);
					QCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			test.log(LogStatus.ERROR, "Unable to execute scenario QC_FutureDeposit_EOD_Txn ");

		}
	}

	// Anoop scenarios
	
	@Test(priority = 22, enabled=true, groups ="Anoop")

	public void AQC_EPP_Redeposit() throws Exception {

		FileName = "QC_EPP_Redeposit.xls";
		test = reports.startTest("QC_EPP_Redeposit", "EPP --> EPP payment ---> Deposit-->Return-->Redeposit");
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
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_Redeposit.redeposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "*************Test Scenario for EPP Redeposit is pass *************");
			}
		}
	}

	@Test(priority = 21, enabled=true, groups = "Anoop")

	public void AQC_EPP_nsfPayment() throws Exception {

		FileName = "QC_EPP_nsfPayment.xls";
		test = reports.startTest("QC_EPP_nsfPayment", "EPP --> EPP payment ---> Deposit-->Return-->NsfPayment");
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
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQC_NSFPayment.nsfpayment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO, "*************Test Scenario for EPP Nsf Payment is pass *************");
			}
		}
	}

	@Test(priority = 20, enabled=true, groups = "Anoop")

	public void AQC_EPP_Return() throws Exception {

		FileName = "QC_EPP_Prepayment_Return.xls";
		test = reports.startTest("QC_EPP_Prepay_Return", "EPP --> EPP payment ---> Deposit--> prepayment --> Return");
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
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_Prepayment.Prepayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();

				AQCAdminLoginLogout.login(SSN, AppURL);
				AQC_EPP_Return.qcReturn(SSN, AppURL);
				AQCAdminLoginLogout.logout(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for EPP Return is pass******");
			}
		}
	}

	@Test(priority = 19, enabled=true, groups = "Anoop")

	public void AQC_EPP_refund() throws Exception {

		FileName = "QC_EPP_Refund.xls";
		test = reports.startTest("QC_EPP_Refund", "EPP --> EPP payment ---> Deposit--> prepayment --> clear--> refund");

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
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPPayment.epppayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AInternalTfAndCashManagement.internaltf(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_Prepayment.Prepayment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AEPPClearOnly.eppClear(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPRefund.qcRefund(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for EPP refund is pass******");
			}
		}
	}

	@Test(priority = 18, enabled=true, groups = "Anoop")

	public void AQC_EPP_clear() throws Exception {

		FileName = "QC_EPP_Clear.xls";
		test = reports.startTest("QC_EPP_DepositClear", "EPP -->EPP payment-->Deposit--> clear");

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
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_EPPClear.eppClear(SSN, AppURL);
				;
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "************Test Scenario for EPP Clear is pass**************");
			}
		}
	}

	@Test(priority = 17, enabled=true, groups = "Anoop")

	public void AQC_EPP_Prepayment() throws Exception {

		FileName = "QC_EPP_Prepayment.xls";
		test = reports.startTest("QC_EPP_Prepayment", "EPP -->EPP payment--> Deposit---> prepayment");

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

				/*ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();*/
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_Prepayment.Prepayment(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for EPP Prepayment is pass******");
			}
		}
	}

	@Test(priority = 16, enabled=true, groups = "Anoop")

	public void AQC_EPPDeposit() throws Exception {

		FileName = "QC_EPPDeposit.xls";
		test = reports.startTest("QC_EPPDeposit", "Loan-EPP--> age the store upto 1st installment --> perform Deposit");

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
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.epp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQcEPP.scheduler();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCDepositDropdown.depositDropDown(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
				test.log(LogStatus.INFO, "****Test Scenario for EPP deposit is pass******");
			}
		}
	}

	// This test case is for borrower registration and new loan processing
	@Test(priority = 13, enabled=true, groups = "Anoop")
	public void borrowregNewloan() throws Exception {
		FileName = "QC_BorrowerRegistration_NewLoan.xls";
		test = reports.startTest("QC_BorrowerRegistration_NewLoan",
				"Login-->Home Screen-->Borrower Registration-->New Loan");

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
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();
			}
		}
	}

	// This test case is to check status for the customer and apply loan for
	// inactive customers
	@Test(priority = 2, enabled=true, groups = "Anoop")
	public void inactiveNewloan() throws Exception {
		FileName = "QC_NewLoan_InactiveCustomer.xls";
		test = reports.startTest("QC_NewLoan_InactiveCustomer", "Login-->Home Screen-->In active customer-->New Loan");

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

			}
		}
	}

	// This test case is to check customer max loan count
	/*
	 * Make sure that "ESign_LoanAmt" column having an amount 50 and for pdl max
	 * loan count for customer 10 and maximum loan 500
	 */
	@Test(priority = 6, enabled=true, groups = "Anoop")

	public void maxloanCount() throws Exception {
		FileName = "QC_MaxLoanCount_Testdata.xls";
		test = reports.startTest("QC_MaxLoanCount", "Login-->Borrower-->Max loan count");

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
				Thread.sleep(2000);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();

				for (int i = 1; i <= 11; i++) {

					ACSRLoginLogout.login(SSN, AppURL);
					AMaxLoanCount.maxLoan(SSN, AppURL);
					//ACSRLoginLogout.logout();
					if (!(i == 11)) {
						test.log(LogStatus.INFO, "******Customer loan Number " + i + "is approved successfully*****");
					} else {
						test.log(LogStatus.INFO, "******Customer loan Number " + i + "is denied*****");
						break;
					}
				}

				/*
				 * ACSRLoginLogout.login(SSN,AppURL);
				 * AQCCSRHistory.history(SSN,AppURL); ACSRLoginLogout.logout();
				 */

				//test.log(LogStatus.INFO, "****Test Scenario for max loan amount is pass******");

			}
		}
	}

	@Test(priority = 4, enabled=true, groups = "Anoop")

	public void rescindloan() throws Exception {
		test = reports.startTest("QC_NewLoan_Rescind", "BorrowerRegistration-->New Loan->Rescind");
		FileName = "QC_BorrowerReg_NewLoan_Rescind_Txn_Testdata.xls";

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
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.rescind(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for  loan rescind  is pass******");

			}
		}
	}

	@Test(priority = 5, enabled=true, groups = "Anoop")

	public void agerescindtest() throws Exception {
		test = reports.startTest("QC_NewLoan_AgeStore_Rescind", "Login-->Age the loan to rescind days--->Rescind loan");
		FileName = "QC_BorrowerReg_NewLoan_AgeRescind_Txn_Testdata.xls";

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
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.rescind(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for age to store loan rescind  is pass******");

			}
		}
	}

	// Ach deposit from drop down
	@Test(priority = 3, enabled=true, groups = "Anoop")
	public void Achdeposit() throws Exception {
		test = reports.startTest("QC_NewLoan_Deposit", "Login-->Age the stote up to due date--->Perform deposit");
		FileName = "QC_BorrowerReg_NewLoan_AchDeposit_Txn_Testdata.xls";

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
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.achDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Ach Deposit  is pass******");
			}
		}
	}

	// ACH deposit from safe
	/* Give this test case as 0 priority mandatory */
	@Test(priority = 0, enabled=true, groups = "Anoop")
	public void middayDeposit() throws Exception {
		FileName = "QC_BorrowerReg_NewLoan_MidDayDeposit_Txn_Testdata.xls";
		test = reports.startTest("QC_NewLoan_MiddayDeposit",
				"Login-->Age the stote up to due date--->Perform Mid day deposit");

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
				
				/*QCCSRLoginLogout.adminLogin(SSN, SSN);
				AAdminStartDate.toStartdate(SSN, SSN);
				QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
				AProc1.proc();*/
				
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRMidDayDeposit.middeposit();
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for MidDay Deposit  is pass******");
			}
		}
	}

	// Adding 5 days to due date and perform midday deposit
	@Test(priority = 7, enabled=true, groups = "Anoop")

	public void GracedaysMiddayDeposit() throws Exception {

		FileName = "QC_AgeStoretoduedate+Gracedays_MiddayDeposit.xls";
		test = reports.startTest("QC_NewLoan_AgeStore_MiddayDeposit",
				"Login-->Age the stote up to due date+Gracedays--->Perform Mid day deposit");

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
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();	
				ACSRLoginLogout.login(SSN, AppURL);
				ARunschedulerGracedays.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRMidDayDeposit.middeposit();
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for GraceDays MidDay Deposit  is pass******");
			}
		}
	}

	// Adding 5 days to due date and perform deposit from deposit menu
	@Test(priority = 8, enabled=true, groups = "Anoop")

	public void GracedaysDepositMenu() throws Exception {

		FileName = "QC_AgeStoretoduedate+Gracedays_DepositMenu.xls";
		test = reports.startTest("QC_NewLoan_AgeStore_DepositMenu",
				"Login-->Age the stote up to due date+Gracedays--->Perform DepositMenu");

		TestData = new ExcelNew(
				System.getProperty("user.dir") + Aprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
		String sheetName = "Start";
		int lastrow = TestData.getLastRow("Start");
		System.out.println(lastrow);
		for (int row = 2; row <= lastrow; row++) {
			String RunFlag = TestData.getCellData(sheetName, "Run", row);
			// System.out.println(RunFlag);
			if (RunFlag.equals("Y")) {
				String AppURL = TestData.getCellData(sheetName, "AppURL", row);
				String SSN = TestData.getCellData(sheetName, "SSN", row);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ARunschedulerGracedays.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQC_CSRDepositMenu.depositMenu(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for GraceDays DepositMenu  is pass******");
			}
		}
	}

	// Age the store to 3 days and perform partial payment and age the store to
	// due date and perform re finance step up
	@Test(priority = 9, enabled=true, groups = "Anoop")

	public void RefinanceStepup() throws Exception {

		FileName = "QC_AgeStore_payment_AgetoDuedate_RefinanceStepUp.xls";
		test = reports.startTest("QC_Refinanace StepUp",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Stepup");

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
				
			/*	QCCSRLoginLogout.adminLogin(SSN, SSN);
				AAdminStartDate.toStartdateNV(SSN, SSN);
				QCCSRLoginLogout.adminLogout(driver, SSN, SSN);
				AProc1.proc();*/

				/*ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();
				*/ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				ARefinanceStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Stepup  is pass******");
			}
		}
	}

	// Age the store to 3 days and perform partial payment and age the store to
	// due date and perform re finance step same
	@Test(priority = 10, enabled=true, groups = "Anoop")

	public void RefinanceStepSame() throws Exception {

		FileName = "QC_AgeStore_payment_AgetoDuedate_RefinanceStepSame.xls";
		test = reports.startTest("QC_Refinanace StepSame",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance StepSame");

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

				/*ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();*/
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ARefinanceStepSame.StepSame(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance StepSame  is pass******");
			}
		}
	}

	@Test(priority = 11, enabled=true, groups = "Anoop")

	public void RefinanceStepupVoid() throws Exception {

		FileName = "QC_RefinanceStepup_void.xls";
		test = reports.startTest("QC_RefinanceStepup_void",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance Stepup-->void");

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
				/*ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();*/
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ARefinanceStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Step up Void  is pass******");
			}
		}
	}

	@Test(priority = 12, enabled=true, groups = "Anoop")

	public void RefinanceStepSameVoid() throws Exception {

		FileName = "QC_RefinanceStep_Same_void.xls";
		test = reports.startTest("QC_RefinanceStep_Same_void",
				"Login-->Age the Store_payment_Age store to Duedate_Refinance StepSame void");

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
				/*ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();*/
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ARefinanceStepSame.StepSame(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for Refinance Step Same void is pass******");
			}
		}
	}

	// This needs to be 0 or top priority
	@Test(priority = 1, enabled=true, groups = "Anoop")
	public void futureMidayDeposit() throws Exception {
		FileName = "QC_AgeStoretoduedate_FutureDeposit_MiddayDeposit.xls";
		test = reports.startTest("QC_Future MidDay Deposit",
				"Loan-->Age the store upto duedate--> perform future deposit—->age the store uptofuture deposit date--->perform Deposit(Mid Day)");

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
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRACHDeposit.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRFutureDeposit.futureDeposit(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ARunschedulerGracedays.runscheduler(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRMidDayDeposit.middeposit();
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO, "****Test Scenario for future MidDay Deposit  is pass******");
			}
		}
	}

	@Test(priority = 14, enabled=true, groups = "Anoop")

	public void rebateStepup() throws Exception {

		FileName = "QC__RefinanceStepUp_rebate.xls";
		test = reports.startTest("QC_RefinanceStepUp_rebate",
				"Loan-Age the store--make a payment -- age the store-->do refinance(step up)(loan should be under rebate period)");

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
				/*ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();*/
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);

				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AUnderRebateAge.agerescind();
				ACSRLoginLogout.login(SSN, AppURL);
				AUnderRebateStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO,
						"****Test Scenario for Refinance Stepup loan under rebate period  is pass******");
			}
		}
	}

	@Test(priority = 15, enabled=true, groups = "Anoop")

	public void rebateStepupVoid() throws Exception {

		FileName = "QC__RefinanceStepUp_rebate_Void.xls";
		test = reports.startTest("QC_RefinanceStepUp_rebate_Void",
				"Loan-Age the store--make a payment -- age the store-->do refinance(step up)(loan should be under rebate period)-->Void");

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

				/*ACSRLoginLogout.login(SSN, AppURL);
				ACSRBorrowerRegistration.borrowerReg(SSN, AppURL);
				ACSRLoginLogout.logout();*/
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRNewLoanPage.newLoan(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				ACSRRescindLoan.agerescind(SSN, AppURL);
				ACSRLoginLogout.login(SSN, AppURL);
				AQCRefinanace.payment(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AUnderRebateAge.agerescind();
				ACSRLoginLogout.login(SSN, AppURL);
				AUnderRebateStepup.StepUp(SSN, AppURL);
				ACSRLoginLogout.logout();
				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRVoid.QcVoid(SSN, AppURL);
				ACSRLoginLogout.logout();

				ACSRLoginLogout.login(SSN, AppURL);
				AQCCSRHistory.history(SSN, AppURL);
				ACSRLoginLogout.logout();

				test.log(LogStatus.INFO,
						"****Test Scenario for Refinance Stepup loan under rebate period and void is pass******");
			}
		}
	}

	// Janaki scenarios

	@Test(priority = 0, enabled = true, groups = "Janaki")

	public static void JQC_AgeStore_Deposit_PrePayment_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_PrePayment_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->ACH/Check Deposit-> AgeStore-> PrePayment");

			FileName = Jprop.getProperty("QC_PrePayment_Txn_TestData_file_name") + ".xls";

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
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPrePayment.prePayment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_AgeStore_Deposit_PrePayment_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_Deposit_PrePayment_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_Deposit_PrePayment_Txn ");

		}
	}

	@Test(priority = 402, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Deposit_PrePayment_Void_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_PrePayment_Void_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->ACH/Check Deposit-> AgeStore-> PrePayment-> Void");

			// test =
			// extent.createTest(Jprop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = Jprop.getProperty("QC_PrePayment_Void_Txn_TestData_file_name") + ".xls";

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
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPrePayment.prePayment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPrePaymentVoid.prePaymentVoid(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_AgeStore_Deposit_PrePaymentVoid_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_Deposit_PrePayment_Void_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_Deposit_PrePaymentVoid_Txn ");

		}
	}

	@Test(priority = 403, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Deposit_ClearDropdown_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_Clear_Dropdown_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->ACH/Check Deposit-> AgeStore-> Clear");

			FileName = Jprop.getProperty("QC_Clear_Dropdown_Txn_TestData_file_name") + ".xls";

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
					String adminURL = TestData.getCellData(sheetName, "AdminURL", row);
					String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					System.out.println(AppURL);
					System.out.println(adminURL);

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
					if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					} else if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
						JQCAdminLoginLogout.login(SSN, NextDueDate);
						JQCACHProcessing.ACHProcess(SSN, NextDueDate);
						JQCAdminLoginLogout.logout(SSN, NextDueDate);
					}
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCClearDropdown.clearDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_AgeStore_Deposit_ClearDropdown_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_Deposit_ClearDropdown_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_Deposit_ClearDropdown_Txn ");

		}
	}

	@Test(priority = 404, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Deposit_ClearMenu_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_Clear_Menu_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->ACH/Check Deposit-> AgeStore-> Clear");

			FileName = Jprop.getProperty("QC_Clear_Menu_Txn_TestData_file_name") + ".xls";

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
					String adminURL = TestData.getCellData(sheetName, "AdminURL", row);
					String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					System.out.println(AppURL);
					System.out.println(adminURL);

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
					if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					} else if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
						JQCAdminLoginLogout.login(SSN, NextDueDate);
						JQCACHProcessing.ACHProcess(SSN, NextDueDate);
						JQCAdminLoginLogout.logout(SSN, NextDueDate);
					}
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCClearMenu.clearMenu(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_AgeStore_Deposit_ClearMenu_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_Deposit_ClearMenu_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_Deposit_ClearMenu_Txn ");

		}
	}

	@Test(priority = 405, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Deposit_AutoClear_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_AutoClear_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->ACH/Check Deposit-> AgeStore-> AutoClear");

			// test =
			// extent.createTest(Jprop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = Jprop.getProperty("QC_AutoClear_Txn_TestData_file_name") + ".xls";

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
					String adminURL = TestData.getCellData(sheetName, "AdminURL", row);
					String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					System.out.println(AppURL);
					System.out.println(adminURL);

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
					if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					} else if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
						JQCAdminLoginLogout.login(SSN, NextDueDate);
						JQCACHProcessing.ACHProcess(SSN, NextDueDate);
						JQCAdminLoginLogout.logout(SSN, NextDueDate);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					}
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAutoClear.autoClear(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_AgeStore_Deposit_AutoClear_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_Deposit_AutoClear_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_Deposit_AutoClear_Txn ");

		}
	}

	@Test(priority = 410, enabled = false)
	public static void JQC_AgeStore_DCDeposit_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_DCDeposit_Dropdown_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->DC Deposit");

			FileName = Jprop.getProperty("QC_DCDeposit_Dropdown_Txn_file_name") + ".xls";

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
			System.out.println("QC_AgeStore_DCDeposit_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_DCDeposit_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_DCDeposit_Txn ");

		}
	}

	@Test(priority = 411, enabled = false)
	public static void JQC_AgeStore_DCDeposit_Menu_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_DCDeposit_Menu_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->DC Deposit");

			FileName = Jprop.getProperty("QC_DCDeposit_Menu_Txn_file_name") + ".xls";

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
			System.out.println("QC_AgeStore_DCDeposit_Menu_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_DCDeposit_Menu_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_DCDeposit_Menu_Txn");

		}
	}

	@Test(priority = 412, enabled = false)
	public static void JQC_AgeStore_GraceDays_DCDeposit_Dropdown_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_GraceDays_DCDeposit_Dropdown_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->DC Deposit");

			// test =
			// extent.createTest(Jprop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = Jprop.getProperty("QC_GraceDays_DCDeposit_Dropdown_Txn_file_name") + ".xls";

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
			System.out.println("QC_AgeStore_GraceDays_DCDeposit_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_GraceDays_DCDeposit_Dropdown_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_GraceDays_DCDeposit_Txn");

		}
	}

	@Test(priority = 413, enabled = false)
	public static void JQC_AgeStore_GraceDays_DCDeposit_Menu_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_GraceDays_DCDeposit_Menu_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->DC Deposit");

			FileName = Jprop.getProperty("QC_GraceDays_DCDeposit_Menu_Txn_file_name") + ".xls";

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
			System.out.println("QC_AgeStore_GraceDays_DCDeposit_Menu_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_GraceDays_DCDeposit_Menu_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_GraceDays_DCDeposit_Menu_Txn ");

		}
	}

	@Test(priority = 409, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_ACHReturn_Refinance_Rescind_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_ACHReturn_Refinance_Rescind_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->Deposit->ACHReturn->Refinance->Rescind");

			// test =
			// extent.createTest(Jprop.getProperty("QC_Store_AgeStore_Deposit_Menu_Txn_file_name"));

			FileName = Jprop.getProperty("QC_ACHReturn_Refinance_Rescind_Txn_TestData_file_name") + ".xls";

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
					String adminURL = TestData.getCellData(sheetName, "AdminURL", row);
					System.out.println(AppURL);
					System.out.println(adminURL);

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
					JQCAdminLoginLogout.login(SSN, NextDueDate);
					JQCACHProcessing.ACHProcess(SSN, NextDueDate);
					JQCAdminLoginLogout.logout(SSN, NextDueDate);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCACHReturn.ACHReturn(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCRefinance.Refinance(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCRescind.Rescind(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_AgeStore_ACHReturn_Refinance_Rescind_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_ACHReturn_Refinance_Rescind_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_ACHReturn_Refinance_Rescind_Txn");

		}
	}

	@Test(priority = 408, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_NSFPosting_Refinance_Rescind_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_NSFPosting_Refinance_Rescind_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->Deposit->NSFPosting->Refinance->Rescind");

			FileName = Jprop.getProperty("QC_NSFPosting_Refinance_Rescind_Txn_TestData_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++) {

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String adminURL = TestData.getCellData(sheetName, "AdminURL", row);
					System.out.println(AppURL);
					System.out.println(adminURL);

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
					JQCInternalTransfer.InternalTransfer(SSN, AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCmgDeposit.CmgDeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCAdminLoginLogout.login(SSN, AppURL);
					JQC_EPP_Return.qcReturn(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCRefinance.Refinance(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCRescind.Rescind(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_AgeStore_NSFPosting_Refinance_Rescind_Txn");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_NSFPosting_Refinance_Rescind_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_NSFPosting_Refinance_Rescind_Txn");

		}
	}

	@Test(priority = 406, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_PrePayment_Return_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_PrePayment_Return_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->Deposit->AgeStore -> Pre-payment -> AgeStore -> Return");
			FileName = Jprop.getProperty("QC_PrePayment_Return_Txn_file_name") + ".xls";
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
					String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

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
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPrePayment.prePayment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.secondAgeStoreGraceDays(SSN, AppURL);
					if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
						JQCAdminLoginLogout.login(SSN, AppURL);
						JQC_EPP_Return.qcReturn(SSN, AppURL);
						JQCAdminLoginLogout.logout(SSN, AppURL);
					} else if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
						JQCAdminLoginLogout.login(SSN, NextDueDate);
						JQCACHProcessing.ACHProcess(SSN, NextDueDate);
						JQCAdminLoginLogout.logout(SSN, NextDueDate);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCACHReturn.ACHReturn(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);

					}
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_AgeStore_PrePayment_Return_Txn");
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_PrePayment_Return_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_PrePayment_Return_Txn");

		}
	}

	@Test(priority = 407, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_PrePayment_Clear_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_PrePayment_Clear_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->Deposit->AgeStore -> Pre-payment -> AgeStore -> Clear");
			FileName = Jprop.getProperty("QC_PrePayment_Clear_Txn_file_name") + ".xls";
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
					String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);

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
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPrePayment.prePayment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreGraceDays.secondAgeStoreGraceDays(SSN, AppURL);
					if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
						JQCAdminLoginLogout.login(SSN, NextDueDate);
						JQCACHProcessing.ACHProcess(SSN, NextDueDate);
						JQCAdminLoginLogout.logout(SSN, NextDueDate);
					}
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCClearDropdown.clearDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_AgeStore_PrePayment_Clear_Txn");
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_PrePayment_Clear_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_AgeStore_PrePayment_Clear_Txn");

		}
	}

	@Test(priority = 410, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Deposit_Return_Refinance_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_Deposit_Return_Refinance_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->Return->Deposit->Return->Refinance");

			FileName = Jprop.getProperty("QC_Deposit_Return_Refinance_Txn_file_name") + ".xls";

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
					String adminURL = TestData.getCellData(sheetName, "AdminURL", row);
					String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					System.out.println(AppURL);
					System.out.println(adminURL);

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
					if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
						JQCAdminLoginLogout.login(SSN, NextDueDate);
						JQCACHProcessing.ACHProcess(SSN, NextDueDate);
						JQCAdminLoginLogout.logout(SSN, NextDueDate);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCACHReturn.ACHReturn(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
					} else if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.InternalTransfer(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCmgDeposit.CmgDeposit(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCAdminLoginLogout.login(SSN, AppURL);
						JQC_EPP_Return.qcReturn(SSN, AppURL);
						JQCAdminLoginLogout.logout(SSN, AppURL);
					}
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCRefinance.Refinance(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Deposit_Return_Refinance_Txn_file_name");
			e.printStackTrace();
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_Deposit_Return_Refinance_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_Deposit_Return_Refinance_Txn_file_name");

		}
	}

	@Test(priority = 411, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Deposit_Return_Refinance_Void_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_Deposit_Return_Refinance_Void_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->Return->Deposit->Return->Refinance-> Void");

			FileName = Jprop.getProperty("QC_Deposit_Return_Refinance_Void_Txn_file_name") + ".xls";

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
					String adminURL = TestData.getCellData(sheetName, "AdminURL", row);
					String ESign_CollateralType = TestData.getCellData(sheetName, "ESign_CollateralType", row);
					System.out.println(AppURL);
					System.out.println(adminURL);

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
					if (ESign_CollateralType.equalsIgnoreCase("ACH")) {
						JQCAdminLoginLogout.login(SSN, NextDueDate);
						JQCACHProcessing.ACHProcess(SSN, NextDueDate);
						JQCAdminLoginLogout.logout(SSN, NextDueDate);
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCACHReturn.ACHReturn(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
					} else if (ESign_CollateralType.equalsIgnoreCase("CHECK")) {
						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCInternalTransfer.InternalTransfer(SSN, AppURL);

						JQCCSRLoginLogout.login(SSN, AppURL);
						JQCCmgDeposit.CmgDeposit(SSN, AppURL);
						JQCCSRLoginLogout.logout(SSN, AppURL);
						JQCAdminLoginLogout.login(SSN, AppURL);
						JQC_EPP_Return.qcReturn(SSN, AppURL);
						JQCAdminLoginLogout.logout(SSN, AppURL);
					}
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCRefinance.Refinance(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCVoid.qcVoid(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Deposit_Return_Refinance_Txn_file_name");
			e.printStackTrace();
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_Deposit_Return_Refinance_Void_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_Deposit_Return_Refinance_Txn_file_name");

		}
	}

	@Test(priority = 412, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Refinance_Rescind_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_Refinance_Rescind_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->Return->Deposit->Return->Refinance");

			FileName = Jprop.getProperty("QC_Refinance_Rescind_Txn_file_name") + ".xls";

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
					String adminURL = TestData.getCellData(sheetName, "AdminURL", row);
					System.out.println(AppURL);
					System.out.println(adminURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCBorrowerRegistration.borrowerRegistration(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPayment.payment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCRefinance.Refinance(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCRescind.Rescind(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Deposit_Return_Refinance_Txn_file_name");
			e.printStackTrace();
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_Refinance_Rescind_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_Deposit_Return_Refinance_Txn_file_name");

		}
	}

	@Test(priority = 413, enabled = true, groups = "Janaki")
	public static void JQC_AgeStore_Redeposit_Prepayment_Void_Prepayment_Return_Txn() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_Redeposit_Prepayment_Void_Return_Txn")),
					"Login->Borrower Registratino->New Loan->AgeStore->Deposit->Return->ReDeposite->Prepayment->Void->Prepayment->Return");

			FileName = Jprop.getProperty("QC_Redeposit_Prepayment_Void_Return_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			String sheetName = "Start";
			System.out.println(lastrow);
			for (int row = 2; row <= lastrow; row++)

			{

				String RunFlag = TestData.getCellData(sheetName, "Run", row);

				if (RunFlag.equals("Y")) {

					String AppURL = TestData.getCellData(sheetName, "AppURL", row);
					String SSN = TestData.getCellData(sheetName, "SSN", row);
					String adminURL = TestData.getCellData(sheetName, "AdminURL", row);
					System.out.println(AppURL);
					System.out.println(adminURL);

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
					JQCInternalTransfer.InternalTransfer(SSN, AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCmgDeposit.CmgDeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCAdminLoginLogout.login(SSN, AppURL);
					JQC_EPP_Return.qcReturn(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCRedeposit.redeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPrePayment.prePayment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPrePaymentVoid.prePaymentVoid(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCPrePayment.prePayment(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCInternalTransfer.InternalTransfer(SSN, AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCmgDeposit.CmgDeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCAdminLoginLogout.login(SSN, AppURL);
					JQC_EPP_Return.qcReturn(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("QC_Redeposit_Prepayment_Void_Return_Txn");
			e.printStackTrace();
			String screenshotPath = getScreenhot(driver, "QC_AgeStore_Redeposit_Prepayment_Void_Prepayment_Return_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_Redeposit_Prepayment_Void_Return_Txn");

		}
	}

	@Test(priority = 414, enabled = true, groups = "Janaki")
	public static void JQC_Return_ReDeposit_Clear_Txn() throws Exception {
		try {
			test = reports.startTest(Jprop.getProperty("QC_Return_ReDeposit_Clear_Txn_Testdata"),
					"Login->Borrower Registratino->New Loan with Promotion->JQC_Return_ReDeposit_Clear_Txn");
			FileName = Jprop.getProperty("QC_Return_ReDeposit_Clear_Txn_Testdata_file_name") + ".xls";
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = 3;
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
					JQCInternalTransfer.InternalTransfer(SSN, AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCmgDeposit.CmgDeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCAdminLoginLogout.login(SSN, AppURL);
					JQC_EPP_Return.qcReturn(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCRedeposit.redeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCInternalTransfer.InternalTransfer(SSN, AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCmgDeposit.CmgDeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCClearDropdown.clearDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_Return_ReDeposit_Clear_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_Return_ReDeposit_Clear_Txn ");

		}
	}

	@Test(priority = 415, enabled = false)
	public static void JQC_NewLoan_Veritec_Txn() throws Exception {
		try {
			// test =
			// extent.createTest(Jprop.getProperty("QC_Store_BorrowerRegistration_NewLoan_Promotion_Txn_file_name"));
			test = reports.startTest(Jprop.getProperty("QC_NewLoan_Veritec_Txn_file_name"),
					"Login->Borrower Registratino->New Loan with Veritec");

			FileName = Jprop.getProperty("QC_NewLoan_Veritec_Txn_file_name") + ".xls";

			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = 3;
			String sheetName = "Start";
			// int lastrow=TestData.getLastRow("Borrower");
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
					JQC_NewLoan_Veritec.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRNewLoan.newLoan(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			// test.log(LogStatus.ERROR, MarkupHelper.createLabel("Unable to
			// start scenario 1 " , ExtentColor.RED));
			String screenshotPath = getScreenhot(driver, "QC_NewLoan_Veritec_Txn");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenario JQC_NewLoan_Veritec_Txn ");

		}
	}

	@Test(priority = 416, enabled = true, groups = "Janaki")
	public static void JQC_BuyBack_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_BuyBack_Txn_Testdata_Scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Duedate->BuyBack");
			String FileName = Jprop.getProperty("QC_BuyBack_Txn_Testdata") + ".xls";
			// ExcelNew TestData;
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
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRBuyBack.buyback(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			String screenshotPath = getScreenhot(driver, "QC_BuyBack_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenarios ");

		}

	}

	@Test(priority = 417, enabled = true, groups = "Janaki")
	public static void JQC_BuyBack_Void_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_BuyBack_Void_Txn_Testdata_Scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Duedate->BuyBack-->Void");
			String FileName = Jprop.getProperty("QC_BuyBack_Void_Txn_Testdata") + ".xls";
			// ExcelNew TestData;
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
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRBuyBack.buyback(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRBuyBackVoid.buybackvoid(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			String screenshotPath = getScreenhot(driver, "QC_BuyBack_Void_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenarios ");

		}
	}

	@Test(priority = 418, enabled = true, groups = "Janaki")
	public static void JQC_BuyBack_Rebate_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_BuyBack_Rebate_Txn_Testdata_Scenario")),
					"Login->Borrower Registration->New Loan->AgeStore->BuyBack Rebate");
			String FileName = Jprop.getProperty("QC_BuyBack_Rebate_Txn_Testdata") + ".xls";
			// ExcelNew TestData;
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
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRBuyBackRebate.buybackrebate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			String screenshotPath = getScreenhot(driver, "QC_BuyBack_Rebate_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenarios ");

		}
	}

	@Test(priority = 419, enabled = true, groups = "Janaki")
	public static void JQC_BuyBack_Rebate_Void_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_BuyBack_Rebate_Void_Txn_Testdata_Scenario")),
					"Login->Borrower Registration->New Loan->AgeStore-->BuyBack Rebate-->Void");
			String FileName = Jprop.getProperty("QC_BuyBack_Rebate_Void_Txn_Testdata") + ".xls";
			// ExcelNew TestData;
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
					JQCAgeStoreGraceDays.ageStoreGraceDays(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRBuyBackRebate.buybackrebate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRBuyBackVoid.buybackvoid(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			String screenshotPath = getScreenhot(driver, "QC_BuyBack_Rebate_Void_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenarios ");

		}
	}

	@Test(priority = 425, enabled = true, groups = "Janaki")
	public static void JQC_EPP_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_EPP_Txn_Testdata_Scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Duedate->EPP");
			String FileName = Jprop.getProperty("QC_EPP_Txn_Testdata") + ".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);

			int lastrow = TestData.getLastRow("Start");
			// int lastrow=3;
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
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSREPP.epp(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			String screenshotPath = getScreenhot(driver, "QC_EPP_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenarios ");

		}
	}

	@Test(priority = 421, enabled = true, groups = "Janaki")
	public static void JQC_Deposit_Return_EPP_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest((Jprop.getProperty("QC_Deposit_Return_EPP_Txn_Scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Duedate->EPP->Deposit->Return");
			String FileName = Jprop.getProperty("QC_Deposit_Return_EPP_Txn_Testdata") + ".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			int lastrow = TestData.getLastRow("Start");
			// int lastrow=3;
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
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSREPP.epp(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCInternalTransfer.InternalTransfer(SSN, AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCmgDeposit.CmgDeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCAdminLoginLogout.login(SSN, AppURL);
					JQCCSRReturnPosting.ReturnPosting(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			String screenshotPath = getScreenhot(driver, "QC_Deposit_Return_EPP_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenarios ");

		}
	}

	@Test(priority = 422, enabled = true, groups = "Janaki")
	public static void JQC_EPP_AgestoreInstallmentwise_EPPPayment_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(
					(Jprop.getProperty("QC_EPP_AgestoreInstallmentwise_EPPPayment_Txn_Testdata_Scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Duedate->EPP-->Agestore Installmentwise-->EPP Payment");
			String FileName = Jprop.getProperty("QC_EPP_AgestoreInstallmentwise_EPPPayment_Txn_Testdata") + ".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			int lastrow = TestData.getLastRow("Start");
			// int lastrow=3;
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
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSREPP.epp(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSREPP_Payment.epppayment(SSN, AppURL);// 1
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSREPP_Payment.epppayment(SSN, AppURL);// 2
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSREPP_Payment.epppayment(SSN, AppURL);// 3
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSREPP_Payment.epppayment(SSN, AppURL);// 4
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			String screenshotPath = getScreenhot(driver, "QC_EPP_AgestoreInstallmentwise_EPPPayment_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenarios ");

		}
	}

	@Test(priority = 423, enabled = true, groups = "Janaki_WORecovery")
	public static void JQC_PartialWORecovery_FullWORecovery_Void_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(
					(Jprop.getProperty("QC_PartialWORecovery_FullWORecovery_Void_Txn_Testdata_Scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Duedate->Chk deposit-->Internal Transfer-->Cashmgmt Deposit-->Writeoff-->WriteoffRecovery-->Void");
			String FileName = Jprop.getProperty("QC_PartialWORecovery_FullWORecovery_Void_Txn_Testdata") + ".xls";
			// ExcelNew TestData;
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
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCInternalTransfer.InternalTransfer(SSN, AppURL);

					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCmgDeposit.CmgDeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCAdminLoginLogout.login(SSN, AppURL);
					//JQCAdminLoginLogout.login(SSN, AppURL);
					JQCCSRReturnPosting.ReturnPosting(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRWriteOff.writeoff(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRWOVoid.writeoffvoid(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			String screenshotPath = getScreenhot(driver, "QC_PartialWORecovery_FullWORecovery_Void_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenarios ");

		}
	}

	@Test(priority = 424, enabled = false)
	public static void JQC_ACH_PartialWORecovery_FullWORecovery_Void_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(
					(Jprop.getProperty("QC_ACH_PartialWORecovery_FullWORecovery_Void_Txn_Testdata_Scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Duedate->ACH deposit-->ACHReturn-->Writeoff-->WriteoffRecovery-->Void");
			String FileName = Jprop.getProperty("QC_ACH_PartialWORecovery_FullWORecovery_Void_Txn_Testdata") + ".xls";
			// ExcelNew TestData;
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
					String NextDueDate = "01/31/2018";

					/*
					 * JQCCSRLoginLogout.login(SSN, AppURL);
					 * JQCBorrowerRegistration.borrowerRegistration(SSN,
					 * AppURL); JQCCSRLoginLogout.logout(SSN, AppURL);
					 * JQCCSRLoginLogout.login(SSN, AppURL);
					 * JQCCSRNewLoan.newLoan(SSN, AppURL);
					 * JQCCSRLoginLogout.logout(SSN, AppURL);
					 * JQCCSRLoginLogout.login(SSN, AppURL);
					 * JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					 * JQCCSRLoginLogout.login(SSN, AppURL);
					 * JQCDepositDropdown.depositDropDown(SSN, AppURL);
					 * JQCCSRLoginLogout.logout(SSN, AppURL);
					 */
					JQCAdminLoginLogout.login(SSN, AppURL);
					JQCACHProcessing.ACHProcess(SSN, NextDueDate);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					/*
					 * JQCAdminACHReturn.achreturn(SSN, AppURL);
					 * JQCCSRLoginLogout.login(SSN, AppURL);
					 * JQCCSRWriteOff.writeoff(SSN, AppURL);
					 * JQCCSRLoginLogout.login(SSN, AppURL);
					 * JQCCSRWriteOffRecovery.writeoffrecovery(SSN, AppURL);
					 * JQCCSRLoginLogout.login(SSN, AppURL);
					 * JQCCSRWOVoid.writeoffvoid(SSN, AppURL);
					 * JQCCSRLoginLogout.login(SSN, AppURL);
					 * JQCCSRHistory.history(SSN, AppURL);
					 * JQCCSRLoginLogout.logout(SSN, AppURL);
					 */

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			String screenshotPath = getScreenhot(driver, "QC_ACH_PartialWORecovery_FullWORecovery_Void_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenarios ");

		}
	}

	@Test(priority = 420, enabled = true, groups = "Janaki")
	public static void JQC_ChkDeposit_RtnChk_ReDeposit_Payment_Void_Clear_Txn_Testdata() throws Exception {
		try {
			test = reports.startTest(
					(Jprop.getProperty("QC_ChkDeposit_RtnChk_ReDeposit_Payment_Void_Clear_Txn_Testdata_Scenario")),
					"Login->Borrower Registration->New Loan->AgeStore to Duedate->Chk deposi-->Return-->Redeposit-->Payment-->Void-->Payment-->Clear");
			String FileName = Jprop.getProperty("QC_ChkDeposit_RtnChk_ReDeposit_Payment_Void_Clear_Txn_Testdata")
					+ ".xls";
			// ExcelNew TestData;
			TestData = new ExcelNew(System.getProperty("user.dir")
					+ Jprop.getProperty("QC_Store_NewLoan_Test_data_sheet_path") + FileName);
			int lastrow = TestData.getLastRow("Start");
			// int lastrow=3;
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
					JQCAgeStoreDueDate.ageStoreDueDate(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCDepositDropdown.depositDropDown(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCInternalTransfer.InternalTransfer(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCmgDeposit.CmgDeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCAdminLoginLogout.login(SSN, AppURL);
					JQCCSRReturnPosting.ReturnPosting(SSN, AppURL);
					JQCAdminLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRRedeposit.redeposit(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRPrePayment.prepayment(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRWOVoid.writeoffvoid(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRPrePayment.prepayment(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCInternalTransfer.InternalTransfer(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCmgDeposit.CmgDeposit(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRClearCheck.clearcheck(SSN, AppURL);
					JQCCSRLoginLogout.login(SSN, AppURL);
					JQCCSRHistory.history(SSN, AppURL);
					JQCCSRLoginLogout.logout(SSN, AppURL);

				}
			}
		}

		catch (Exception e) {
			System.out.println("under catch of Test");
			String screenshotPath = getScreenhot(driver,
					"QC_ChkDeposit_RtnChk_ReDeposit_Payment_Void_Clear_Txn_Testdata");
			test.log(LogStatus.INFO, test.addScreenCapture(screenshotPath));

			test.log(LogStatus.ERROR, "Unable to execute scenarios ");

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
						new FileReader("C:/QC_Batch/QC_PDL/src/test/java/tests/Objects.properties"));
				prop = new Properties();
				prop.load(reader);
				reader.close();
				AppURL = prop.getProperty("CSR_URL");
				AdminURL = prop.getProperty("ADMIN_CSR_URL");
				String Bfilename = prop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + prop.getProperty("QC_Store_extent_report_path") + Bfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Jreader = new BufferedReader(
						new FileReader("C:/QC_Batch/QC_PDL/src/test/java/tests/JObjects.properties"));
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
						new FileReader("C:/QC_Batch/QC_PDL/src/test/java/tests/RObjects.properties"));
				Rprop = new Properties();
				Rprop.load(Rreader);
				Rreader.close();
				String Rfilename = Rprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Rprop.getProperty("QC_Store_extent_report_path") + Rfilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			try {
				Areader = new BufferedReader(
						new FileReader("C:/QC_Batch/QC_PDL/src/test/java/tests/AObjects.properties"));
				Aprop = new Properties();
				Aprop.load(Areader);
				Areader.close();
				String Afilename = Aprop.getProperty("QC_Store_extent_report_file_name") + timestamp + ".html";

				reports = new ExtentReports(
						System.getProperty("user.dir") + Aprop.getProperty("QC_Store_extent_report_path") + Afilename,
						true);

			}

			catch (Exception e) {

				System.out.println("Object proprties file not found");
			}

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/IEDriverServer.exe");
			//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/MicrosoftWebDriver.exe");
		}

		catch (Exception e) {

			test.log(LogStatus.ERROR, "Unable to setup for the QC Store ");

		}

	}

	@BeforeMethod(alwaysRun = true)
	public void killProcess() throws Exception {

		try {

			Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");

			Thread.sleep(5000); // Allow OS to kill the process
			System.out.println("killed the process");
			// break;

		} catch (Exception e) {
			// break;
			// continue;
		}
	}

	public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());

		File source = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/ExecutionReports/QCStore/FailedTestsScreenshots/"
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

	// @AfterMethod(alwaysRun=true)

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
