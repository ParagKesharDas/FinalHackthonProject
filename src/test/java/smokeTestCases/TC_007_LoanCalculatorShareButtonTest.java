package smokeTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.LoanCalculatorPage;
import testBase.BaseClass;

public class TC_007_LoanCalculatorShareButtonTest extends BaseClass {
	@Test(groups = "smoke test")
	public void isShareBtnWorking() throws IOException {
		BasePage bp = new BasePage(driver);
		bp.logger.info("*** Starting TC_007_LoanCalculatorShareButtonTest :isShareBtnWorking ***");
		System.out.println("===============================================");
		System.out.println("Executing TC_007_LoanCalculatorShareButtonTest ");
		System.out.println("===============================================");
		
		try {
			LoanCalculatorPage loanCalculatorPage = new LoanCalculatorPage(driver);
			loanCalculatorPage.shareBtn.click();
			timeUnitSleep(2);
			if (loanCalculatorPage.shareLink.isDisplayed()) {
				bp.logger.info("Yes Working");
				System.out.println("Yes Working");
				scrollPageToElement(loanCalculatorPage.shareLink);
				Assert.assertTrue(true);
			} else {
				bp.logger.info("No Working");
				System.out.println("No Working");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			bp.logger.error("TC_007_LoanCalculatorShareButtonTest :isShareBtnWorking Failed due to " + e);
			Assert.fail();
		}

	}
}
