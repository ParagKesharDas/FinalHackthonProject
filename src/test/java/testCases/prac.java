//package pageObjects;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//
//import utilities.ExcelDataFile;
//
//public class LandingPage extends BasePage{
//	WebDriver driver;
//	JavascriptExecutor javascriptExecutor;
//	// passing driver to parent class BasePage
//	public LandingPage(WebDriver driver) throws IOException {
//		super(driver);
//		this.driver = driver;
//		javascriptExecutor=(JavascriptExecutor)driver;
//		
//	}
//	@FindBy(xpath = "//a[@id='menu-item-dropdown-2696']")
//	WebElement menuItemCalculatorLink;
//
//	@FindBy(xpath = "//a[text()='Loan Calculator']")
//	WebElement loanCalculatorLink;
//	
//	@FindBy(xpath = "//li[@id='car-loan']//a")
//	WebElement carLoanTabLink;
//
//	@FindBy(xpath  = "//input[@id='loanamount']")
//	WebElement loanAmountInputLink;
//
//	@FindBy(xpath = "//input[@id='loaninterest']")
//	WebElement loanInterestInputLink;
//
//	@FindBy(xpath = "//input[@id='loanterm']")
//	WebElement loanTenureInputLink;
//	
//	@FindBy(xpath = "//input[@id='loanyears']")
//	WebElement loanYearLink;
//	
//	@FindBy(xpath = "//input[@id='loanmonths']")
//	WebElement loanMonthLink;
//	
//
//	@FindBy(xpath = "//div[@id='emiamount']/p/span")
//	WebElement emiAmountValueLink;
//
//	@FindBy(xpath = "//div[@id='emitotalinterest']/p/span")
//	WebElement totalInterestValueLink;
//
//	@FindBy(xpath = "//div[@id='emitotalamount']/p/span")
//	public
//	WebElement totalPaymentValueLink;
//	
//	
//	
//	
//	@FindBy(xpath = "//td[contains(@class,'paymentyear')]")
//	List<WebElement> yearTableExapndLink;
//	
//	//class was common so tr[1]
//	@FindBy(xpath = "//div[@id='emipaymenttable']/table/tbody/tr[1]")
//	WebElement emiPaymentTableHeaderRow;
//
//	@FindBy(xpath = "//div[@id='emipaymenttable']/table/tbody/tr[contains(@class, 'yearlypaymentdetails')]")
//	List<WebElement> emiPaymentTableDataRows;
//	
//	
//	
//	@FindBy(xpath = "//div[@id='emipaymenttable']//tr[contains(@class,'monthlypaymentdetails')]")
//	List<WebElement> emiPaymentTableMonthlyDataRows;
//	@FindBy(xpath = "//div[@id='emipaymenttable']//tr[contains(@class,'monthlypaymentdetails')]//tr")
//	List<WebElement> emiPaymentTableMonthlyDataRows1;
//	@FindBy(xpath = "//div[@id='emipaymenttable']//tr[contains(@class,'monthlypaymentdetails')]//tr//td")
//	List<WebElement> emiPaymentTableMonthlyDataRows2;
//	@FindBy(id = "loantermsteps") public WebElement scrollPointElement1;
//	
//	@FindBy(id = "yearheader") public WebElement scrollPointElement2;
//	
//	public void clickCarLoanTab() {
//		carLoanTabLink.click();
//	}
//	
//	public void setLoanAmount(String amount) {
//			loanAmountInputLink.clear();
//			loanAmountInputLink.sendKeys(amount);
//		
//	}
//	public void setLoanIntrest(String interestRate) {
//		javascriptExecutor.executeScript("arguments[0].value='" + interestRate + "'", loanInterestInputLink);
//		loanInterestInputLink.click();
//	}
//	
//	public void setLoanTenure(String tenure) {
//		loanTenureInputLink.clear();
//		javascriptExecutor.executeScript("arguments[0].value='" + tenure + "'", loanTenureInputLink);
//		loanTenureInputLink.click();
//	}
//	public void clickLoanYear() {
//		loanYearLink.click();
//	}
//	public void clickLoanMonth() {
//		loanMonthLink.click();
//	}
//	public String getEmiAmountValue() {
//		String emiAmount=emiAmountValueLink.getText();
//		return emiAmount;
//	}
//	public String getTotalInterestValue() {
//		String totalInterestValue=totalInterestValueLink.getText();
//		return totalInterestValue;
//	}
//	public String getTotalPaymentValueLink() {
//		String totalPaymentValue=totalPaymentValueLink.getText();
//		return totalPaymentValue;
//	}
//	public void clickYearTableExapnd() {
//		for(WebElement w: yearTableExapndLink) {
//			w.click();
//		}
//	}
//	
//	public void extractDataFromTable(String sheetName) {
//		try {
//			ExcelDataFile excelfile = new ExcelDataFile(
//					System.getProperty("user.dir") + "\\TestData\\TestOutputData.xlsx");
//
//			if (excelfile.isSheetExist(sheetName)) {
//				excelfile.removeSheet(sheetName);
//			}
//			excelfile.addSheet(sheetName);
//
//			List<WebElement> columns = emiPaymentTableHeaderRow.findElements(By.tagName("th"));
//
//			
//			//we are printing the headers or table attribute names
//			//only 1st row data input
//			int colNum = 1;
//			System.out.println("columns.size() :"+columns.size());
//			for (int i = 0; i < columns.size(); i++) {
//
//				if (!(columns.get(i).getText().isBlank() || columns.get(i).getText().isEmpty())) {
////					System.out.println("colNum: "+colNum);
//					System.out.println(columns.get(i).getText());
//					excelfile.setCellData(sheetName, colNum, 1, columns.get(i).getText());
//					colNum++;
//				}
//			}
//			System.out.println("emiPaymentTableDataRows.size() :"+emiPaymentTableDataRows.size());
//			for (int i = 0; i < emiPaymentTableDataRows.size(); i++) {
////				System.out.println("i :"+i);
//				columns = emiPaymentTableDataRows.get(i).findElements(By.tagName("td"));
////				System.out.println("columns.size() :"+columns.size());
//				for (int j = 0; j < columns.size(); j++) {
//					
//					System.out.println("colNum: "+colNum);
//					System.out.println(columns.get(j).getText());
//					excelfile.setCellData(sheetName, j + 1, i + 2, columns.get(j).getText());
//				}
//			}
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//	
//	//tr/td[contains(@class,'currency') or contains(@class,'paymentyear')or contains(@class,'paymentmonthyear') ]
//	
//	
//	public void extractYearMontlyDataFromTable(String sheetName) {
//		try {
////			ExcelDataFile excelfile = new ExcelDataFile(
////					System.getProperty("user.dir") + "\\TestData\\TestOutputData.xlsx");
////
////			if (excelfile.isSheetExist(sheetName)) {
////				excelfile.removeSheet(sheetName);
////			}
////			excelfile.addSheet(sheetName);
////
////			List<WebElement> columns = emiPaymentTableHeaderRow.findElements(By.tagName("th"));
////			List<WebElement> yColumns,mColumns,mTRColumns,mTDColumns;
////			
////			//we are printing the headers or table attribute names
////			//only 1st row data input
////			int colNum = 1;
////			for (int i = 0; i < columns.size(); i++) {
////				
////				if (!(columns.get(i).getText().isBlank() || columns.get(i).getText().isEmpty())) {
////					System.out.println(columns.get(i).getText());
////					excelfile.setCellData(sheetName, colNum, 1, columns.get(i).getText());
////					colNum++;
////				}
////			}
////			System.out.println(" emiPaymentTableMonthlyDataRows.size()"+ emiPaymentTableMonthlyDataRows.size());
////			
////			for (int i = 0; i < emiPaymentTableMonthlyDataRows.size()+emiPaymentTableDataRows.size(); i++) {
////				System.out.println("i"+i);
////				yColumns=emiPaymentTableDataRows.get(i).findElements(By.tagName("td"));
////				mColumns = emiPaymentTableMonthlyDataRows.get(i).findElements(By.xpath("//td//td"));
////				for (int j = 0; j < yColumns.size(); j++) {
////					System.out.println(yColumns.get(j).getText());
////
////					excelfile.setCellData(sheetName, j + 1, i + 2, yColumns.get(j).getText());
////				}
////				for (int j = 0; j < mColumns.size(); j++) {
////					System.out.println(mColumns.get(j).getText());
////
////					excelfile.setCellData(sheetName, j + 1, i + 3+j, mColumns.get(j).getText());
////				}
////			}
//			
//			
////			for(int i=0;i<emiPaymentTableMonthlyDataRows.size();i++) {
////				System.out.println(emiPaymentTableMonthlyDataRows.size());
////				
////				mTRColumns = emiPaymentTableMonthlyDataRows.get(i).findElements(By.tagName("//tr"));
////				System.out.println(mTRColumns.size());
////				//row
////				for(int j=0;j<mTRColumns.size();j++) {
////					
////					mTDColumns=mTRColumns.get(j).findElements(By.xpath("//td"));
////					System.out.println(mTDColumns.size());
//////					//col/cell
//////					for (int k = 0; k < mTDColumns.size(); k++) {
//////						System.out.println(i+""+j+""+k+" "+mTDColumns.get(k));
////////						excelfile.setCellData(sheetName, k + 1, j+2, mTDColumns.get(k).getText());
//////					}
////				}
////			}
//			System.out.println(emiPaymentTableMonthlyDataRows.size()+" "+emiPaymentTableMonthlyDataRows1.size()+" "+emiPaymentTableMonthlyDataRows2.size());
////			int rows=emiPaymentTableMonthlyDataRows2.size()/emiPaymentTableMonthlyDataRows1.size();
////			List<List<String>> matrix=new ArrayList<>();
////			int count=emiPaymentTableMonthlyDataRows2.size();
////			for (int i = 0; i < rows; i++) {
////				List<String> row=new ArrayList<>();
////				for (int j = 0; j < emiPaymentTableMonthlyDataRows1.size(); j++) {
////					row.add(emiPaymentTableMonthlyDataRows2.get(count).getText());
////					count++;
////					
////				}
////				matrix.add(row);
////				
////			}
////			
////			// To print the matrix
////			for (List<String> row : matrix) {
////			    for (String element : row) {
////			        System.out.print(element + " ");
////			    }
////			    System.out.println();
////			}
//			List<String> list=new ArrayList<>();
//			for(WebElement e: emiPaymentTableMonthlyDataRows2) {
////				System.out.println(e.getText());
//				list.add(e.getText());
//			}
//			System.out.println(list.size());
//			int col=6;
//			int row= list.size()/col;
//			for(int i=0;i<row;i++) {
//				for(int j=0;j<col;j++) {
//					System.out.print(list.get(i*6+j)+" ");
//				}
//				System.out.println();
//			}
//			
//			
//			
//			
//			
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//}
