package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.LandingPage;
import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoanCalculatorDDT extends BaseClass{
	@Test(priority = 5, dataProvider = "LoanCalculatorVerificationData", dataProviderClass = DataProviders.class,groups ="regression")
	public void LoanCalculatorTest(String LoanAmount, String InterestRate, String LoanTenure,String Fees ,String LoanEMI,String LoanAPR,
			String TotalInterestPayable, String TotalPayment) throws IOException, InterruptedException {
		BasePage bp = new BasePage(driver);
		bp.logger.info("*** Starting TC_003_LoanCalculatorDDT :LoanCalculatorTest ***");
		System.out.println("===============================================");
		System.out.println("Executing TC_003_LoanCalculatorDDT:LoanCalculatorTest");
		System.out.println("===============================================");
		
		try {
			LandingPage landingPage = new LandingPage(driver);
			landingPage.clickMenuItemCalculator();
			landingPage.clickLoanCalculator();
			timeUnitSleep(5);
			LoanCalculatorPage loanCalculatorPage = new LoanCalculatorPage(driver);
//		loanCalculatorPage.handleAdvertise();
			loanCalculatorPage.setLoanAmountInput(LoanAmount);
			timeUnitSleep(1);
			loanCalculatorPage.setLoanInterestInput(InterestRate);
			timeUnitSleep(1);
			loanCalculatorPage.setLoanTenureInput(LoanTenure);
			timeUnitSleep(1);
			loanCalculatorPage.setFeesInputLink(Fees);
			timeUnitSleep(5);

			loanCalculatorPage.scrollPoint1.click();

			scrollPageToElement(loanCalculatorPage.loanEmiValueLink);

			if (loanCalculatorPage.getLoanEmiValueLink().contains(LoanEMI)
					&& loanCalculatorPage.getLoanAprValueLink().contains(LoanAPR)
					&& loanCalculatorPage.getTotalInterestValueLink().contains(TotalInterestPayable)
					&& loanCalculatorPage.getTotalPaymentValueLink().contains(TotalPayment)) {
				bp.logger.info("validation Checked Successfully");
				loanCalculatorPage.clickYearTableExapnd();
				loanCalculatorPage.extractYearMontlyDataFromTable("EMIData");

				Assert.assertTrue(true);

			} else {
				System.out.println("Loan Amount "+LoanAmount+" Interest Rate "+InterestRate+" Loan Tenure "+LoanTenure+" validation Test Failed");

				bp.logger.info("validation Check failed");
				Assert.assertTrue(false);
			}
			bp.logger.info("*** Finishing TC_003_LoanCalculatorDDT :LoanCalculatorTest ***");
		} catch (Exception e) {
			System.out.println(e);
			bp.logger.error("TC_003_LoanCalculatorDDT :LoanCalculatorTest Failed due to " + e);
			Assert.fail();
		}

	}
	@Test(priority = 6, dataProvider = "EmiCalData", dataProviderClass = DataProviders.class,groups ="regression")
	public void LoanAmountCalculatorTest(String LoanEMI, String InterestRate, String LoanTenure,String Fees , String TotalPayment) throws IOException, InterruptedException {
		BasePage bp = new BasePage(driver);
		bp.logger.info("*** Starting TC_003_LoanCalculatorDDT : LoanAmountCalculatorTest ***");
		System.out.println("===============================================");
		System.out.println("Executing TC_003_LoanCalculatorDDT : LoanAmountCalculatorTest");
		System.out.println("===============================================");
		try {
			
			LoanCalculatorPage loanCalculatorPage = new LoanCalculatorPage(driver);
//		loanCalculatorPage.handleAdvertise();
			loanCalculatorPage.clickLoanAmountCal();
			timeUnitSleep(1);
			loanCalculatorPage.setLoanEMIInput(LoanEMI);
			timeUnitSleep(1);
			loanCalculatorPage.setLoanInterestInput(InterestRate);
			timeUnitSleep(1);
			loanCalculatorPage.setLoanTenureInput(LoanTenure);
			timeUnitSleep(1);
			loanCalculatorPage.setFeesInputLink(Fees);
			timeUnitSleep(5);

			loanCalculatorPage.scrollPoint3.click();

			scrollPageToElement(loanCalculatorPage.loanEmiValueLink);

			if (loanCalculatorPage.getTotalPaymentValueLink().contains(TotalPayment)) {
				bp.logger.info("validation Checked Successfully");
				loanCalculatorPage.clickYearTableExapnd();
				loanCalculatorPage.extractYearMontlyDataFromTable("LoanAmountCalData");

				Assert.assertTrue(true);

			} else {
				System.out.println("Loan EMI "+LoanEMI+" Interest Rate "+InterestRate+" Loan Tenure "+LoanTenure+" Fees "+Fees+" validation Test Failed");
				bp.logger.info("validation Check failed");
				Assert.assertTrue(false);
			}
			bp.logger.info("*** Finishing TC_003_LoanCalculatorDDT :LoanAmountCalculatorTest ***");
		} catch (Exception e) {
			System.out.println(e);
			bp.logger.error("TC_003_LoanCalculatorDDT :LoanCalculatorTest Failed due to " + e);
			Assert.fail();
		}

	}
	@Test(priority = 6, dataProvider = "LoanTentureCalculatorData", dataProviderClass = DataProviders.class,groups ="regression")
	public void LoanTentureCalculatorTest(String LoanAmount,String LoanEMI, String LoanInterest,String Fees , String TotalPayment) throws IOException, InterruptedException {
		BasePage bp = new BasePage(driver);
		bp.logger.info("*** Starting TC_003_LoanCalculatorDDT : LoanTentureCalculatorTest ***");
		System.out.println("===============================================");
		System.out.println("Executing TC_003_LoanCalculatorDDT : LoanTentureCalculatorTest");
		System.out.println("===============================================");
		try {
			
			LoanCalculatorPage loanCalculatorPage = new LoanCalculatorPage(driver);
//		loanCalculatorPage.handleAdvertise();
			loanCalculatorPage.clickLoanTenureCal();
			timeUnitSleep(1);
			loanCalculatorPage.setLoanAmountInput(LoanAmount);
			timeUnitSleep(1);
			loanCalculatorPage.setLoanEMIInput(LoanEMI);
			timeUnitSleep(1);
			
			loanCalculatorPage.setLoanInterestInput(LoanInterest);
			timeUnitSleep(1);
			loanCalculatorPage.setFeesInputLink(Fees);
			timeUnitSleep(5);
 
			loanCalculatorPage.scrollPoint3.click();

			scrollPageToElement(loanCalculatorPage.loanEmiValueLink);

			if (loanCalculatorPage.getTotalPaymentValueLink().contains(TotalPayment)) {
				bp.logger.info("validation Checked Successfully");
				loanCalculatorPage.clickYearTableExapnd();
				loanCalculatorPage.extractYearMontlyDataFromTable("LoanTentureCalculatorData");

				Assert.assertTrue(true);

			} else {
				System.out.println("Loan Amount "+LoanAmount+" Loan EMI "+LoanEMI+" Loan Interest "+LoanInterest+" Fees "+Fees+" validation Test Failed");
				System.out.println(loanCalculatorPage.getTotalPaymentValueLink()+" "+TotalPayment);
				bp.logger.info("validation Check failed");
				Assert.assertTrue(false);
			}
			bp.logger.info("*** Finishing TC_003_LoanCalculatorDDT :LoanTentureCalculatorTest ***");
		} catch (Exception e) {
			System.out.println(e);
			bp.logger.error("TC_003_LoanCalculatorDDT :LoanCalculatorTest Failed due to " + e);
			Assert.fail();
		}

	}
}
