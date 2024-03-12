package testCases;

import java.io.IOException;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.LandingPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_001_CarLoanDDT extends BaseClass {

	@Test(priority = 0, dataProvider = "CarLoanVerificationData", dataProviderClass = DataProviders.class, groups = "regression")
	public void carLoanTest(String CarLoanAmount, String InterestRate, String LoanTenure, String LoanEMI,
			String TotalInterestPayable, String TotalPayment) throws IOException {
		BasePage bp = new BasePage(driver);
		bp.logger.info("*** Starting TC_001_CarLoanTest :carLoanTest ***");
		System.out.println("===============================================");
		System.out.println("Executing TC_001_CarLoanDDT");
		System.out.println("===============================================");
		try {
			LandingPage l = new LandingPage(driver);
			l.clickCarLoanTab();
			l.setLoanAmount(CarLoanAmount);
			l.setLoanIntrest(InterestRate);
			l.setLoanTenure(LoanTenure);

			timeUnitSleep(3);
//			System.out.println(
//					l.getEmiAmountValue() + " " + l.getTotalInterestValue() + " " + l.getTotalPaymentValueLink());
			scrollPageToElement(l.scrollPointElement1);
			if (l.getEmiAmountValue().contains(LoanEMI) && l.getTotalInterestValue().contains(TotalInterestPayable)
					&& l.getTotalPaymentValueLink().contains(TotalPayment)) {
				bp.logger.info("validation Checked Successfully");
				ZipSecureFile.setMinInflateRatio(0);
				l.extractDataFromTable("CarLoan");
				scrollPageToElement(l.scrollPointElement2);
				l.clickYearTableExapnd();
				l.extractYearMontlyDataFromTable("CarLoanInDetails");
				l.firstMonthDetails();
				timeUnitSleep(3);
				Assert.assertTrue(true);
			} else {
				System.out.println("Loan Amount "+CarLoanAmount+" Interest Rate "+InterestRate+" Loan Tenure "+LoanTenure+" validation Test Failed");
				bp.logger.info("validation Check Failed");
				Assert.assertTrue(false);
			}
			bp.logger.info("*** Finishing TC_001_CarLoanTest :carLoanTest ***");

		} catch (Exception e) {
			System.out.println(e);
			bp.logger.error("TC_001_CarLoanTest :carLoanTest Failed due to " + e);
			Assert.fail();
		}

	}

}
