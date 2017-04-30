package lonsec.performance.processing;

import java.util.ArrayList;
import java.util.List;

import lonsec.performance.data.BenchmarkReturnSeries;
import lonsec.performance.data.Fund;
import lonsec.performance.data.FundReturnSeries;
import lonsec.performance.data.IFund;
import lonsec.performance.data.MonthlyPerformance;
import lonsec.performance.util.CSVFileReader;

public class ProcessMonthlyPerformance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<MonthlyPerformance> monthlyPerformanceList = new ArrayList<MonthlyPerformance>();
		List<? extends IFund> fundReturnSeriesList = CSVFileReader
				.populateObjectFromCSV(FundReturnSeries.getCSVFileName());

		for (IFund iFund : fundReturnSeriesList) {
			FundReturnSeries fundReturnSeries = (FundReturnSeries) iFund;

			MonthlyPerformance monthlyPerformance = new MonthlyPerformance();

			Fund fund = CSVFileReader.searchFundFromCSV(fundReturnSeries
					.getFundCode());
			monthlyPerformance.setFundName(fund.getFundName());
			monthlyPerformance.setDate(fundReturnSeries.getDate());
			double excess = calculateExcess(fundReturnSeries.getDate(),
					fundReturnSeries.getReturnPercentage(),
					fund.getBenchmarkCode());
			monthlyPerformance.setExcess(excess);
			monthlyPerformance
					.setOutPerformance(calculateOutPerformance(excess));
			monthlyPerformance.setReturnVal(fundReturnSeries
					.getReturnPercentage());
			
			monthlyPerformanceList.add(monthlyPerformance);

		}

	}

	private static String calculateOutPerformance(double excess) {
		if (excess < 1) {
			return "underPerfomed";
		} else if (excess > 1) {
			return "outPerformed";
		} else {
			return "";
		}
	}

	private static double calculateExcess(String fundDate,
			double fundReturnPercentage, String benchmarkCode) {
		BenchmarkReturnSeries benchmarkReturnSeries = CSVFileReader
				.searchBenchmarkSeriesReturnFromCSV(fundDate, benchmarkCode);
		double result = fundReturnPercentage
				- benchmarkReturnSeries.getReturnPercentage();

		return Math.round(result);
	}

}
