package lonsec.performance.data;

import com.opencsv.bean.CsvBindByName;

public class FundReturnSeries implements IFund {

	@CsvBindByName
	private String fundCode;
	@CsvBindByName
	private String date;
	@CsvBindByName
	private double returnPercentage;

	public String getFundCode() {
		return fundCode;
	}

	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getReturnPercentage() {
		return returnPercentage;
	}

	public void setReturnPercentage(double returnPercentage) {
		this.returnPercentage = returnPercentage;
	}

	public static String getCSVFileName() {
		return "FundReturnSeries";
	}

}
