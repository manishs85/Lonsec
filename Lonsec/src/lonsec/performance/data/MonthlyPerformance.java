package lonsec.performance.data;

import com.opencsv.bean.CsvBindByName;

public class MonthlyPerformance {

	@CsvBindByName
	private String fundName;
	@CsvBindByName
	private String Date;
	@CsvBindByName
	private double excess;
	@CsvBindByName
	private String outPerformance;
	@CsvBindByName
	private double returnVal;
	@CsvBindByName
	private int rank;

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public double getExcess() {
		return excess;
	}

	public void setExcess(double excess) {
		this.excess = excess;
	}

	public String getOutPerformance() {
		return outPerformance;
	}

	public void setOutPerformance(String outPerformance) {
		this.outPerformance = outPerformance;
	}

	public double getReturnVal() {
		return returnVal;
	}

	public void setReturnVal(double returnVal) {
		this.returnVal = returnVal;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
