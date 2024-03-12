package smokeTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.LandingPage;
import testBase.BaseClass;

public class TC_005_CarLoanTabClickableTest extends BaseClass {
	@Test(groups = "smoke test")
	public void isCarLoanTabClickable() throws IOException {
		BasePage bp = new BasePage(driver);
		bp.logger.info("*** Starting TC_005_CarLoanTabClickableTest :isCarLoanTabClickable ***");
		System.out.println("===============================================");
		System.out.println("Executing TC_005_CarLoanTabClickableTest");
		System.out.println("===============================================");
		
		try {
			LandingPage l = new LandingPage(driver);
			if (l.carLoanTabLink.isEnabled()) {
				l.clickCarLoanTab();
				bp.logger.info("Car Loan Tab is Clickable");
				System.out.println("Car Loan Tab is Clickable");
				Assert.assertTrue(true);
			} else {
				bp.logger.info("Car Loan Tab is not Clickable");
				System.out.println("Car Loan Tab is not Clickable");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			bp.logger.error("TC_005_CarLoanTabClickableTest :isCarLoanTabClickable Failed due to " + e);
			Assert.fail();
		}

	}
}
