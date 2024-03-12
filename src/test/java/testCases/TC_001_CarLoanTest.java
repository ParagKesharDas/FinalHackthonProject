//package testCases;
//
//import java.io.IOException;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import pageObjects.BasePage;
//import pageObjects.LandingPage;
//import pageObjects.LoanCalculatorPage;
//import testBase.BaseClass;
//
//public class TC_001_CarLoanTest extends BaseClass {
//
//	@Test(priority = 2)
//	public void homeLoanTest() throws IOException {
////		logger.info("*** Starting TC_001_CarLoanTest :homeLoanTest ***");
//		try {
//			LandingPage l = new LandingPage(driver);
//			BasePage basePage=new BasePage(driver);
//			l.clickHomeLoanTab();
//			
//			l.setLoanAmount("1500000");
//			l.setLoanIntrest("9.5");
//			l.setLoanTenure("1");
////			logger.info("Entering the values in input field");
//
//			timeUnitSleep(3);
////			System.out.println(
////					l.getEmiAmountValue() + " " + l.getTotalInterestValue() + " " + l.getTotalPaymentValueLink());
//			scrollPageToElement(l.scrollPointElement1);
//			
////			logger.info("Scrolled to scrollPointElement1");
////			logger.info("Checking the validation");
//			if (l.getEmiAmountValue().contains("1,31,525") && l.getTotalInterestValue().contains("78,303")
//					&& l.getTotalPaymentValueLink().contains("15,78,303")) {
////				logger.info("validation Checked Successfully");
//				l.extractDataFromTable("HomeLoan");
////				logger.info("all Yearly data extracted and writen in excel file");
//				scrollPageToElement(l.scrollPointElement2);
////				logger.info("Scrolled to scrollPointElement2");
//				l.clickYearTableExapnd();
//				l.extractYearMontlyDataFromTable("HomeLoanInDetails");
////				logger.info("all Yearly and Monthly data extracted and writen in excel file");
//				timeUnitSleep(3);
//				Assert.assertTrue(true);
//			} else {
////				logger.info("validation Checking Failed");
//				Assert.assertTrue(false);
//			}
////			logger.info("*** Finishing TC_001_CarLoanTest :homeLoanTest ***");
//		} catch (Exception e) {
////			System.out.println(e);
////			logger.error("TC_001_CarLoanTest :homeLoanTest Failed due to "+e);
//			Assert.fail();
//		}
//	}
//
//	@Test(priority = 1)
//	public void carLoanTest() throws IOException {
////		logger.info("*** Starting TC_001_CarLoanTest :carLoanTest ***");
//		try {
//			LandingPage l = new LandingPage(driver);
//			l.clickCarLoanTab();
////			logger.info("Clicked on Home loan tab");
//			l.setLoanAmount("1500000");
//			l.setLoanIntrest("9.5");
//			l.setLoanTenure("1");
////			logger.info("Entering the values in input field");
//			timeUnitSleep(3);
////			System.out.println(
////					l.getEmiAmountValue() + " " + l.getTotalInterestValue() + " " + l.getTotalPaymentValueLink());
//			scrollPageToElement(l.scrollPointElement1);
////			logger.info("Scrolled to scrollPointElement1");
////			logger.info("Checking the validation");
//			if (l.getEmiAmountValue().contains("1,31,525") && l.getTotalInterestValue().contains("78,303")
//					&& l.getTotalPaymentValueLink().contains("15,78,303")) {
////				logger.info("validation Checked Successfully");
//				l.extractDataFromTable("CarLoan");
////				logger.info("all Yearly data extracted and writen in excel file");
//				scrollPageToElement(l.scrollPointElement2);
////				logger.info("Scrolled to scrollPointElement2");
//				l.clickYearTableExapnd();
//				l.extractYearMontlyDataFromTable("CarLoanInDetails");
////				logger.info("all Yearly and Monthly data extracted and writen in excel file");
//				Assert.assertTrue(true);
//				timeUnitSleep(3);
//			} else {
//				Assert.assertTrue(false);
//			}
////			logger.info("*** Finishing TC_001_CarLoanTest :carLoanTest ***");
//
//		} catch (Exception e) {
////			System.out.println(e);
////			logger.error("TC_001_CarLoanTest :carLoanTest Failed due to "+e);
//			Assert.fail();
//		}
//
//	}
//
//	@Test(priority = 3)
//	public void LoanCalculatorTest() throws IOException, InterruptedException {
//		try {
//			LandingPage landingPage = new LandingPage(driver);
//			landingPage.clickMenuItemCalculator();
//			landingPage.clickLoanCalculator();
//			timeUnitSleep(5);
//			LoanCalculatorPage loanCalculatorPage = new LoanCalculatorPage(driver);
////			loanCalculatorPage.handleAdvertise();
//			loanCalculatorPage.setLoanAmountInput("5000000");
//			timeUnitSleep(1);
//			loanCalculatorPage.setLoanInterestInput("9");
//			timeUnitSleep(1);
//			loanCalculatorPage.setLoanTenureInput("3");
//			timeUnitSleep(1);
//			loanCalculatorPage.setFeesInputLink("50000");
//			timeUnitSleep(5);
//			
//			loanCalculatorPage.scrollPoint1.click();
//			
//			scrollPageToElement(loanCalculatorPage.loanEmiValueLink);
//			
//			if (loanCalculatorPage.getLoanEmiValueLink().contains("1,58,998")
//					&& loanCalculatorPage.getLoanAprValueLink().contains("9.69")
//					&& loanCalculatorPage.getTotalInterestValueLink().contains("7,23,952")
//					&& loanCalculatorPage.getTotalPaymentValueLink().contains("57,73,952")) {
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
