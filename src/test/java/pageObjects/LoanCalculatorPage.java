package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelDataFile;

public class LoanCalculatorPage extends BasePage {
	JavascriptExecutor javascriptExecutor;

	// passing driver to parent class BasePage
	public LoanCalculatorPage(WebDriver driver) throws IOException {
		super(driver);
		javascriptExecutor = (JavascriptExecutor) driver;

	}

	@FindBy(xpath = "//html/ins/div/iframe")
	WebElement advertiseiFrameParentLink;
	
	@FindBy(xpath = "//a[text()='Loan Amount ']")
	WebElement LoanAmountCal; 
	
	@FindBy(xpath = "//a[text()='Loan Tenure ']")
	WebElement LoanTenureCal;

	@FindBy(xpath = "//iframe[@id='ad_iframe']")
	WebElement advertiseiFrameChildLink;

	@FindBy(xpath = "//div[@id='dismiss-button']/div")
	WebElement advertiseDismissButton;

	@FindBy(xpath = "//input[@id='loanamount']")
	WebElement loanAmountInputLink;

	@FindBy(xpath = "//input[@id='loaninterest']")
	WebElement loanInterestInputLink;

	@FindBy(xpath = "//input[@id='loanterm']")
	public
	WebElement loanTenureInputLink;

	@FindBy(xpath = "//input[@id='loanfees']")
	WebElement feesInputLink;
	@FindBy(xpath = "//input[@id='loanemi']")
	WebElement loanEmiInputLink;
	
	
	@FindBy(xpath = "//input[@id='loanyears']")
	public
	WebElement loanYearLink;

	@FindBy(xpath = "//input[@id='loanmonths']")
	public
	WebElement loanMonthLink;

	@FindBy(xpath = "//div[@id='loansummary-emi']/p/span")
	public WebElement loanEmiValueLink;

	@FindBy(xpath = "//div[@id='loansummary-apr']/p/span")
	WebElement loanAprValueLink;

	@FindBy(xpath = "//div[@id='loansummary-totalinterest']/p/span")
	WebElement totalInterestValueLink;

	@FindBy(xpath = "//div[@id='loansummary-totalamount']/p/span")
	WebElement totalPaymentValueLink;

	@FindBy(xpath = "//*[@id='loanpaymenttable']/table/tbody/tr[1]")
	WebElement loanPaymentTableHeaderRowLink;

	@FindBy(xpath = "//div[@id='loanpaymenttable']/table/tbody/tr[contains(@class, 'yearlypaymentdetails')]/td")
	List<WebElement> loanPaymentTableRowsCellDataLink;

	@FindBy(xpath = "//tbody//tr[not(contains(@class,'monthlypaymentdetails'))]//td")
	List<WebElement> loanPaymentTableAllCellDataLink;

	@FindBy(xpath = "//label[text()='Loan Amount']")
	public WebElement scrollPoint1;
	
	@FindBy(xpath = "//label[text()='EMI']")
	public WebElement scrollPoint3;
	@FindBy(xpath = "//li[@id=\"loan-amount-calc\"]")
	WebElement loanAmountCalculatorLink;
	@FindBy(xpath = "//li[@id='emi-calc']")
	WebElement emiCalculatorLink;
	@FindBy(xpath = "//td[contains(@class,'paymentyear')]")
	List<WebElement> yearTableExapndLink;
	
	@FindBy(xpath = "//a[text()=' Share']")
	public 
	WebElement shareBtn;
	@FindBy(xpath = "//input[@id='sharelink']")
	public 
	WebElement shareLink;
	
	public void clickLoanAmountCal() {
		LoanAmountCal.click();
	}
	public void clickLoanTenureCal() {
		LoanTenureCal.click();
	}
	
	public void handleAdvertise() {
		try {
			driver.switchTo().frame(advertiseiFrameParentLink);
			driver.switchTo().frame(advertiseiFrameChildLink);
			advertiseDismissButton.click();
			driver.switchTo().parentFrame();
		} catch (Exception e) {
		}
	}

	public void setLoanAmountInput(String str) {
		try {
			loanAmountInputLink.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			loanAmountInputLink.sendKeys(Keys.BACK_SPACE);
			loanAmountInputLink.sendKeys(str);
			logger.info("Loan Ammount Input setted successfully");
		} catch (Exception e) {
			logger.info("Loan Ammount Input setting got Failed");
		}

	}public void setLoanEMIInput(String str) {
		try {
			loanEmiInputLink.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			loanEmiInputLink.sendKeys(Keys.BACK_SPACE);
			loanEmiInputLink.sendKeys(str);
			logger.info("Loan EMI Input setted successfully");
		} catch (Exception e) {
			logger.info("Loan AmmoEMIunt Input setting got Failed");
		}

	}


	public void setLoanInterestInput(String str) {
		try {
			loanInterestInputLink.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			loanInterestInputLink.sendKeys(Keys.BACK_SPACE);
			loanInterestInputLink.sendKeys(str);
			logger.info("Loan Interest Input setted successfully");
		} catch (Exception e) {
			logger.info("Loan Interset Input setting got Failed");

		}
	}

	public void setLoanTenureInput(String str) {
		try {
			loanTenureInputLink.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			loanTenureInputLink.sendKeys(Keys.BACK_SPACE);
			loanTenureInputLink.sendKeys(str);
			logger.info("Loan Tenure Input setted successfully");
		} catch (Exception e) {
			logger.info("Loan Tenure Input setting got Failed");

		}
	}

	public void setFeesInputLink(String str) {
		try {
			feesInputLink.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			feesInputLink.sendKeys(Keys.BACK_SPACE);
			feesInputLink.sendKeys(str);
			logger.info("Fees Input setted successfully");
		} catch (Exception e) {
			logger.info("Fees Input setting got Failed");

		}

	}
	
	public String getLoanTenure() {
		return loanTenureInputLink.getAttribute("value");
	}

//	public void loadData() throws InterruptedException {
//		try {
//			emiCalculatorLink.click();
//
//			loanAmountCalculatorLink.click();
//		} catch (Exception e) {
//			
//		}
//		
//
//	}

	public String getLoanEmiValueLink() {
		try {
			return loanEmiValueLink.getText();
		} catch (Exception e) {

			logger.info("Loan Emi Value not present");
			return "";
		}

	}

	public String getLoanAprValueLink() {
		try {
			return loanAprValueLink.getText();
		} catch (Exception e) {

			logger.info("Loan APR Value not present");
			return "";
		}
	}

	public String getTotalInterestValueLink() {
		try {
			return totalInterestValueLink.getText();
		} catch (Exception e) {

			logger.info("Total Interest Value not present");
			return "";
		}
	}

	public String getTotalPaymentValueLink() {
		try {
			return totalPaymentValueLink.getText();
		} catch (Exception e) {

			logger.info("Total Payment Value not present");
			return "";
		}
	}

	public void clickYearTableExapnd() throws InterruptedException {
		try {
		for (WebElement w : yearTableExapndLink) {
			w.click();
			timeUnitSleepMili(1000);
		}
		logger.info("Year table expand");
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void extractYearMontlyDataFromTable(String sheetName) {
		try {
			ExcelDataFile excelfile = new ExcelDataFile(
					System.getProperty("user.dir") + "\\TestData\\TestOutputData.xlsx");

			if (excelfile.isSheetExist(sheetName)) {
				excelfile.removeSheet(sheetName);
			}
			excelfile.addSheet(sheetName);

			List<WebElement> columns = loanPaymentTableHeaderRowLink.findElements(By.tagName("th"));

			// we are printing the headers or table attribute names
			// only 1st row data input
			int colNum = 1;
			System.out.println("Yearly & Monthly Detailed Data Table: ");
			for (int i = 0; i < columns.size(); i++) {
				// as there 8 elements but only 6 are real so we are filtering
				if (!(columns.get(i).getText().isBlank() || columns.get(i).getText().isEmpty())) {
//					System.out.print(columns.get(i).getText() + " ");
					excelfile.setCellData(sheetName, colNum, 1, columns.get(i).getText());
					colNum++;
				}
//				System.out.println();
			}

			List<String> list = new ArrayList<>();
			for (WebElement e : loanPaymentTableAllCellDataLink) {
				list.add(e.getText());
			}
			System.out.println(list.size());
			int col = 6;
			int row = list.size() / col;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					System.out.print(list.get(i * 6 + j) + " ");
					excelfile.setCellData(sheetName, j + 1, i + 2, list.get(i * 6 + j));
				}
				System.out.println();
			}

		} catch (Exception e) {
			System.out.println(e);
			logger.info("Monthly Data extraction From Table failed due to "+e);
		}
	}

}
