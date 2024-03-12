package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "CarLoanVerificationData")
	public static String[][]  getCarLoanVerificationData() throws IOException {

		String path = ".\\TestData\\TestInputData.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("CarLoanDataInput");
		int totalcols = xlUtils.getCellCount("CarLoanDataInput", 1);
//		System.out.println(totalrows+" "+totalcols);
		String loanVerificationData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loanVerificationData[i - 1][j] = xlUtils.getCellData("CarLoanDataInput", i, j);// i-1 because we are skipping 1st heading
//				System.out.print(xlUtils.getCellData("CarLoanDataInput", i, j)+" ");
			}
//			System.out.println();
		}
		return loanVerificationData;

	}
	@DataProvider(name = "HomeLoanVerificationData")
	public static String[][]  getHomeLoanVerificationData() throws IOException {

		String path = ".\\TestData\\TestInputData.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("HomeLoanDataInput");
		int totalcols = xlUtils.getCellCount("HomeLoanDataInput", 1);
//		System.out.println(totalrows+" "+totalcols);
		String loanVerificationData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loanVerificationData[i - 1][j] = xlUtils.getCellData("HomeLoanDataInput", i, j);// i-1 because we are skipping 1st heading
//				System.out.print(xlUtils.getCellData("HomeLoanDataInput", i, j)+" ");
			}
//			System.out.println();
		}
		return loanVerificationData;

	}
	
	@DataProvider(name = "LoanCalculatorVerificationData")
	public static String[][]  getLoanCalculatorVerificationData() throws IOException {

		String path = ".\\TestData\\TestInputData.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("LoanCalculatorDataInput");
		int totalcols = xlUtils.getCellCount("LoanCalculatorDataInput", 1);
//		System.out.println(totalrows+" "+totalcols);
		String loanVerificationData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loanVerificationData[i - 1][j] = xlUtils.getCellData("LoanCalculatorDataInput", i, j);// i-1 because we are skipping 1st heading
//				System.out.print(xlUtils.getCellData("LoanCalculatorDataInput", i, j)+" ");
			}
//			System.out.println();
		}
		return loanVerificationData;

	}
	@DataProvider(name = "yearMonthData")
	public static String[][]  getYearMonthData() throws IOException {

		String path = ".\\TestData\\TestInputData.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("YearMonthData");
		int totalcols = xlUtils.getCellCount("YearMonthData", 1);
//		System.out.println(totalrows+" "+totalcols);
		String yearMonthData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				yearMonthData[i - 1][j] = xlUtils.getCellData("YearMonthData", i, j);// i-1 because we are skipping 1st heading
//				System.out.print(xlUtils.getCellData("YearMonthData", i, j)+" ");
			}
//			System.out.println();
		}
		return yearMonthData;

	}
	@DataProvider(name = "EmiCalData")
	public static String[][]  getEmiCalData() throws IOException {

		String path = ".\\TestData\\TestInputData.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("EmiCalData");
		int totalcols = xlUtils.getCellCount("EmiCalData", 1);
//		System.out.println(totalrows+" "+totalcols);
		String EmiCalData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				EmiCalData[i - 1][j] = xlUtils.getCellData("EmiCalData", i, j);// i-1 because we are skipping 1st heading
//				System.out.print(xlUtils.getCellData("EmiCalData", i, j)+" ");
			}
//			System.out.println();
		}
		return EmiCalData;

	}
	
	@DataProvider(name = "LoanTentureCalculatorData")
	public static String[][]  getLoanTentureCalculatorData() throws IOException {

		String path = ".\\TestData\\TestInputData.xlsx";
		ExcelDataFile xlUtils = new ExcelDataFile(path);

		int totalrows = xlUtils.getRowCount("LoanTentureCalculatorData");
		int totalcols = xlUtils.getCellCount("LoanTentureCalculatorData", 1);
//		System.out.println(totalrows+" "+totalcols);
		String LoanTentureCalculatorData[][] = new String[totalrows][totalcols];
		
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				LoanTentureCalculatorData[i - 1][j] = xlUtils.getCellData("LoanTentureCalculatorData", i, j);// i-1 because we are skipping 1st heading
//				System.out.print(xlUtils.getCellData("LoanTentureCalculatorData", i, j)+" ");
			}
//			System.out.println();
		}
		return LoanTentureCalculatorData;

	}
	
	
//	public static void main(String[] args) throws IOException {
//		DataProviders.getHomeLoanVerificationData();
//		
//	}
//	
}
