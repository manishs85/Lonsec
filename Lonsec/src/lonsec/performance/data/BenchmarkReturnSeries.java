package lonsec.performance.data;

import com.opencsv.bean.CsvBindByName;

public class BenchmarkReturnSeries implements IFund {

	@CsvBindByName
	private String benchmarkCode;
	@CsvBindByName
	private String date;
	@CsvBindByName
	private double returnPercentage;

	public String getBenchmarkCode() {
		return benchmarkCode;
	}

	public void setBenchmarkCode(String benchmarkCode) {
		this.benchmarkCode = benchmarkCode;
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
		return "BenchmarkReturnSeries";
	}

}
