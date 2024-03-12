//package testCases;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import pageObjects.LandingPage;
//import pageObjects.LoanCalculatorPage;
//import testBase.BaseClass;
//import utilities.DataProviders;
//
//public class TC_AllDDT extends BaseClass {
//	@Test(priority = 0, dataProvider = "CarLoanVerificationData", dataProviderClass = DataProviders.class)
//	public void carLoanTest(String CarLoanAmount, String InterestRate, String LoanTenure, String LoanEMI,
//			String TotalInterestPayable, String TotalPayment) throws IOException {
//		logger.info("*** Starting TC_001_CarLoanTest :carLoanTest ***");
//		try {
//			LandingPage l = new LandingPage(driver);
//			l.clickCarLoanTab();
//			logger.info("Clicked on Home loan tab");
//			l.setLoanAmount(CarLoanAmount);
//			l.setLoanIntrest(InterestRate);
//			l.setLoanTenure(LoanTenure);
//			logger.info("Entering the values in input field");
//			timeUnitSleep(3);
////			System.out.println(
////					l.getEmiAmountValue() + " " + l.getTotalInterestValue() + " " + l.getTotalPaymentValueLink());
//			scrollPageToElement(l.scrollPointElement1);
//			logger.info("Scrolled to scrollPointElement1");
//			logger.info("Checking the validation");
//			if (l.getEmiAmountValue().contains(LoanEMI) && l.getTotalInterestValue().contains(TotalInterestPayable)
//					&& l.getTotalPaymentValueLink().contains(TotalPayment)) {
//				logger.info("validation Checked Successfully");
//				l.extractDataFromTable("CarLoan");
//				logger.info("all Yearly data extracted and writen in excel file");
//				scrollPageToElement(l.scrollPointElement2);
//				logger.info("Scrolled to scrollPointElement2");
//				l.clickYearTableExapnd();
//				l.extractYearMontlyDataFromTable("CarLoanInDetails");
//				logger.info("all Yearly and Monthly data extracted and writen in excel file");
//				timeUnitSleep(3);
//				Assert.assertTrue(true);
//			} else {
//				Assert.assertTrue(false);
//			}
//			logger.info("*** Finishing TC_001_CarLoanTest :carLoanTest ***");
//
//		} catch (Exception e) {
////			System.out.println(e);
//			logger.error("TC_001_CarLoanTest :carLoanTest Failed due to " + e);
//			Assert.fail();
//		}
//
//	}
//
//	@Test(priority = 1, dataProvider = "HomeLoanVerificationData", dataProviderClass = DataProviders.class)
//
//	// dataProvider will pass data in method arguments
//	public void homeLoanTest(String LoanAmount, String InterestRate, String LoanTenure, String LoanEMI,
//			String TotalInterestPayable, String TotalPayment) throws IOException {
//		logger.info("*** Starting TC_002_HomeLoanDDT :homeLoanTest ***");
//		try {
//			LandingPage l = new LandingPage(driver);
//
//			l.clickHomeLoanTab();
//			logger.info("Clicked on Home loan tab");
//			l.setLoanAmount(LoanAmount);
//			l.setLoanIntrest(InterestRate);
//			l.setLoanTenure(LoanTenure);
//			logger.info("Entering the values in input field");
//
//			timeUnitSleep(3);
////		System.out.println(
////				l.getEmiAmountValue() + " " + l.getTotalInterestValue() + " " + l.getTotalPaymentValueLink());
//			scrollPageToElement(l.scrollPointElement1);
//
//			logger.info("Scrolled to scrollPointElement1");
//			logger.info("Checking the validation");
//			if (l.getEmiAmountValue().contains(LoanEMI) && l.getTotalInterestValue().contains(TotalInterestPayable)
//					&& l.getTotalPaymentValueLink().contains(TotalPayment)) {
//				logger.info("validation Checked Successfully");
//				l.extractDataFromTable("HomeLoan");
//				logger.info("all Yearly data extracted and writen in excel file");
//				scrollPageToElement(l.scrollPointElement2);
//				logger.info("Scrolled to scrollPointElement2");
//				l.clickYearTableExapnd();
//				l.extractYearMontlyDataFromTable("HomeLoanInDetails");
//				logger.info("all Yearly and Monthly data extracted and writen in excel file");
//				timeUnitSleep(3);
//				Assert.assertTrue(true);
//			} else {
//				logger.info("validation Checking Failed");
//				Assert.assertTrue(false);
//			}
//			logger.info("*** Finishing TC_001_CarLoanTest :homeLoanTest ***");
//		} catch (Exception e) {
////		System.out.println(e);
//			logger.error("TC_001_CarLoanTest :homeLoanTest Failed due to " + e);
//			Assert.fail();
//		}
//	}
//
//	@Test(priority = 5, dataProvider = "LoanCalculatorVerificationData", dataProviderClass = DataProviders.class)
//	public void LoanCalculatorTest(String LoanAmount, String InterestRate, String LoanTenure,String Fees ,String LoanEMI,String LoanAPR,
//			String TotalInterestPayable, String TotalPayment) throws IOException, InterruptedException {
//		try {
//			LandingPage landingPage = new LandingPage(driver);
//			landingPage.clickMenuItemCalculator();
//			landingPage.clickLoanCalculator();
//			timeUnitSleep(5);
//			LoanCalculatorPage loanCalculatorPage = new LoanCalculatorPage(driver);
////		loanCalculatorPage.handleAdvertise();
//			loanCalculatorPage.setLoanAmountInput(LoanAmount);
//			timeUnitSleep(1);
//			loanCalculatorPage.setLoanInterestInput(InterestRate);
//			timeUnitSleep(1);
//			loanCalculatorPage.setLoanTenureInput(LoanTenure);
//			timeUnitSleep(1);
//			loanCalculatorPage.setFeesInputLink(Fees);
//			timeUnitSleep(5);
//
//			loanCalculatorPage.scrollPoint1.click();
//
//			scrollPageToElement(loanCalculatorPage.loanEmiValueLink);
//
//			if (loanCalculatorPage.getLoanEmiValueLink().contains(LoanEMI)
//					&& loanCalculatorPage.getLoanAprValueLink().contains(LoanAPR)
//					&& loanCalculatorPage.getTotalInterestValueLink().contains(TotalInterestPayable)
//					&& loanCalculatorPage.getTotalPaymentValueLink().contains(TotalPayment)) {
//
//				loanCalculatorPage.clickYearTableExapnd();
//				loanCalculatorPage.extractYearMontlyDataFromTable("EMIData");
//
//				Assert.assertTrue(true);
//
//			} else {
//				Assert.assertTrue(false);
//			}
//
//		} catch (Exception e) {
//			System.out.println(e);
//			Assert.fail();
//		}
//
//	}
//
//}
