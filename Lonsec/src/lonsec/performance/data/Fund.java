package lonsec.performance.data;

import com.opencsv.bean.CsvBindByName;

public class Fund implements IFund {

	@CsvBindByName
	private String fundCode;
	@CsvBindByName
	private String fundName;
	@CsvBindByName
	private String benchmarkCode;
	
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public String getBenchmarkCode() {
		return benchmarkCode;
	}
	public void setBenchmarkCode(String benchmarkCode) {
		this.benchmarkCode = benchmarkCode;
	}
	
	public static String getCSVFileName() {
		return "Fund";
	}

}
