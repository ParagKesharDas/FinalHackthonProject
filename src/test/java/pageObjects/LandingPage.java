package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelDataFile;

public class LandingPage extends BasePage {
	JavascriptExecutor javascriptExecutor;
	List<String> list1;
	

	// passing driver to parent class BasePage
	public LandingPage(WebDriver driver) throws IOException {
		super(driver);
		javascriptExecutor = (JavascriptExecutor) driver;

	}

	@FindBy(xpath = "//a[@id='menu-item-dropdown-2696']")
	WebElement menuItemCalculatorLink;

	@FindBy(xpath = "//a[text()='Loan Calculator']")
	WebElement loanCalculatorLink;

	@FindBy(xpath = "//li[@id='car-loan']//a")
	public
	WebElement carLoanTabLink;

	@FindBy(xpath = "//li[@id='home-loan']//a")
	public
	WebElement homeLoanTabLink;

	@FindBy(xpath = "//input[@id='loanamount']")
	WebElement loanAmountInputLink;

	@FindBy(xpath = "//input[@id='loaninterest']")
	WebElement loanInterestInputLink;

	@FindBy(xpath = "//input[@id='loanterm']")
	WebElement loanTenureInputLink;

	@FindBy(xpath = "//input[@id='loanyears']")
	WebElement loanYearLink;

	@FindBy(xpath = "//input[@id='loanmonths']")
	WebElement loanMonthLink;

	@FindBy(xpath = "//div[@id='emiamount']/p/span")
	WebElement emiAmountValueLink;

	@FindBy(xpath = "//div[@id='emitotalinterest']/p/span")
	WebElement totalInterestValueLink;

	@FindBy(xpath = "//div[@id='emitotalamount']/p/span")
	public WebElement totalPaymentValueLink;

	@FindBy(xpath = "//td[contains(@class,'paymentyear')]")
	List<WebElement> yearTableExapndLink;

	// class was common so tr[1]
	@FindBy(xpath = "//div[@id='emipaymenttable']/table/tbody/tr[1]")
	WebElement emiPaymentTableHeaderRow;

	@FindBy(xpath = "//div[@id='emipaymenttable']/table/tbody/tr[contains(@class, 'yearlypaymentdetails')]")
	List<WebElement> emiPaymentTableDataRows;

	@FindBy(xpath = "//div[@id='emipaymenttable']//tr[contains(@class,'monthlypaymentdetails')]")
	List<WebElement> emiPaymentTableMonthlyDataRows;
	@FindBy(xpath = "//div[@id='emipaymenttable']//tr[contains(@class,'monthlypaymentdetails')]//tr")
	List<WebElement> emiPaymentTableMonthlyDataRows1;
	@FindBy(xpath = "//div[@id='emipaymenttable']//tr[contains(@class,'monthlypaymentdetails')]//tr//td")
	List<WebElement> emiPaymentTableMonthlyDataRows2;
	@FindBy(id = "loantermsteps")
	public WebElement scrollPointElement1;

	@FindBy(id = "yearheader")
	public WebElement scrollPointElement2;
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	public void clickCarLoanTab() {
		try {
			carLoanTabLink.click();
			logger.info("car loan tab clicked");
		} catch (Exception e) {
			logger.info("car loan tab clicking failed");
		}

	}

	public void clickHomeLoanTab() {
		try {
			homeLoanTabLink.click();
			logger.info("home loan tab clicked");
		} catch (Exception e) {
			logger.info("home loan tab clicking failed");
		}
	}

	public void clickMenuItemCalculator() {
		try {
			menuItemCalculatorLink.click();
			logger.info("MenuItem Calculator clicked");
		} catch (Exception e) {
			logger.info("MenuItem Calculator clicking failed");
		}
	}

	public void clickLoanCalculator() {
		try {
			loanCalculatorLink.click();
			logger.info("Loan Calculator clicked");
		} catch (Exception e) {
			logger.info("Loan Calculator clicking failed");
		}
	}

	public void setLoanAmount(String amount) {
		try {
			loanAmountInputLink.clear();
			loanAmountInputLink.sendKeys(amount);
			logger.info("Loan Ammount setting done");
		} catch (Exception e) {
			logger.info("Loan Ammount setting failed");
		}

	}

	public void setLoanIntrest(String interestRate) {
		try {
			javascriptExecutor.executeScript("arguments[0].value='" + interestRate + "'", loanInterestInputLink);
			loanInterestInputLink.click();
			logger.info("Loan Interest setting done");
		} catch (Exception e) {
			logger.info("Loan Interest setting failed");
		}
	}

	public void setLoanTenure(String tenure) {
		try {
			loanTenureInputLink.clear();
			javascriptExecutor.executeScript("arguments[0].value='" + tenure + "'", loanTenureInputLink);
			loanTenureInputLink.click();
			logger.info("Loan Tenure setting done");
		} catch (Exception e) {
			logger.info("Loan Tenure setting failed");
		}
	}

	public void clickLoanYear() {
		try {
			loanYearLink.click();
			logger.info("Loan Year Clicked");
		} catch (Exception e) {
			logger.info("Loan Year Clicking failed");
		}

	}

	public void clickLoanMonth() {
		try {
			loanMonthLink.click();
			logger.info("Loan Month Clicked");
		} catch (Exception e) {
			logger.info("Loan Month Clicking failed");
		}

	}

	public String getEmiAmountValue() {
		try {
			String emiAmount = emiAmountValueLink.getText();
			logger.info("Emi Ammount got successfully ");
			return emiAmount;
		} catch (Exception e) {
			logger.info("Emi Ammount got failed ");
			return "";
		}
	}

	public String getTotalInterestValue() {
		try {
			String totalInterestValue = totalInterestValueLink.getText();
			logger.info("Total Interest Value got successfully");
			return totalInterestValue;
		} catch (Exception e) {
			logger.info("Total Interest Value got failed ");
			return "";
		}
	}

	public String getTotalPaymentValueLink() {
		try {
			String totalPaymentValue = totalPaymentValueLink.getText();
			logger.info("Total Payment Value got successfully");
			return totalPaymentValue;
		} catch (Exception e) {
			logger.info("Total Payment Value got failed ");
			return "";
		}
	}

	public void clickYearTableExapnd() throws InterruptedException {
		try {
			for (WebElement w : yearTableExapndLink) {
				w.click();
				timeUnitSleepMili(1000);
			}
			logger.info("Year Table Expanded");
		} catch (Exception e) {
			logger.info("Year Table Expand failed");
		}
	}

	public void extractDataFromTable(String sheetName) {
		try {
			ExcelDataFile excelfile = new ExcelDataFile(
					System.getProperty("user.dir") + "\\TestData\\TestOutputData.xlsx");

			if (excelfile.isSheetExist(sheetName)) {
				excelfile.removeSheet(sheetName);
			}
			excelfile.addSheet(sheetName);

			List<WebElement> columns = emiPaymentTableHeaderRow.findElements(By.tagName("th"));

			// we are printing the headers or table attribute names
			// only 1st row data input
			int colNum = 1;
			System.out.println("Yearly Data Table: ");
			for (int i = 0; i < columns.size(); i++) {
				if (!(columns.get(i).getText().isBlank() || columns.get(i).getText().isEmpty())) {
//					System.out.print(columns.get(i).getText()+" ");
					excelfile.setCellData(sheetName, colNum, 1, columns.get(i).getText());
					colNum++;
				}
			}

			for (int i = 0; i < emiPaymentTableDataRows.size(); i++) {
				columns = emiPaymentTableDataRows.get(i).findElements(By.tagName("td"));
				for (int j = 0; j < columns.size(); j++) {
					System.out.print(columns.get(j).getText()+" ");
					excelfile.setCellData(sheetName, j + 1, i + 2, columns.get(j).getText());
				}
				System.out.println();
			}
			logger.info(" Yearly Data From Table extracted successfully");

		} catch (Exception e) {
			System.out.println(e);
			logger.info("Yearly Data extraction From Table failed");
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

			List<WebElement> columns = emiPaymentTableHeaderRow.findElements(By.tagName("th"));

			// we are printing the headers or table attribute names
			// only 1st row data input
			int colNum = 1;
			System.out.println("Monthly Detailed Data Table: ");
//			System.out.println("columns.size() :" + columns.size());
			for (int i = 0; i < columns.size(); i++) {

				if (!(columns.get(i).getText().isBlank() || columns.get(i).getText().isEmpty())) {
//					System.out.print(columns.get(i).getText()+" ");
					excelfile.setCellData(sheetName, colNum, 1, columns.get(i).getText());
					colNum++;
				}
			}

			List<String> list = new ArrayList<>();
			for (WebElement e : emiPaymentTableMonthlyDataRows2) {
				list.add(e.getText());
			}
			list1=list.subList(0, 6);
//			System.out.println(list.size());
			int col = 6;
			int row = list.size() / col;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					System.out.print(list.get(i * 6 + j) + " ");
					excelfile.setCellData(sheetName, j + 1, i + 2, list.get(i * 6 + j));
				}
				System.out.println();
			}
			logger.info("Monthly Data From Table extracted successfully");

		} catch (Exception e) {
			System.out.println(e);
			logger.info("Monthly Data extraction From Table failed");
		}
	}
	
	public void firstMonthDetails() {
//		System.out.println(list1.size());
		System.out.println("For first month "+list1.get(0)+" the interest amount is "+list1.get(2)+" principal amount is "+list1.get(1));
	}

	public void sendStatus(String sheetName, String status) {
//		ExcelUtils excelUtils =new E
	}

}
