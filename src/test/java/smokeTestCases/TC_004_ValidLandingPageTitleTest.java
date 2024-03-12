package smokeTestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.LandingPage;
import testBase.BaseClass;

public class TC_004_ValidLandingPageTitleTest extends BaseClass {
	@Test(groups = "smoke test")
	public void validLandingPage() throws IOException {
		
		BasePage bp = new BasePage(driver);
		bp.logger.info("*** Starting TC_004_ValidLandingPageTitleTest :validLandingPage ***");
		System.out.println("===============================================");
		System.out.println("Executing TC_004_ValidLandingPageTitleTest");
		System.out.println("===============================================");
		try {
			LandingPage l = new LandingPage(driver);
			System.out.println(l.getPageTitle());
			if (l.getPageTitle().contains("EMI Calculator for Home Loan, Car Loan & Personal Loan in India")) {
				bp.logger.info("Page title matched");
				System.out.println("Page title matched");
				
				Assert.assertTrue(true);
			} else {
				bp.logger.info("Page title mismatched");
				System.out.println("Page title mismatched");
				
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			bp.logger.error("TC_004_ValidLandingPageTitleTest :validLandingPage Failed due to " + e);
			Assert.fail();
		}
	}
}
