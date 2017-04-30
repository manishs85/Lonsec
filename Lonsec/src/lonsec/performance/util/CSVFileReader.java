package lonsec.performance.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lonsec.performance.data.BenchmarkReturnSeries;
import lonsec.performance.data.Fund;
import lonsec.performance.data.FundReturnSeries;
import lonsec.performance.data.IFund;
import lonsec.performance.exception.FundProcessingException;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

public class CSVFileReader {

	private static List<? extends IFund> fundList;
	private static List<? extends IFund> benchMarkReturnList;

	static {
		fundList = populateObjectFromCSV(Fund.getCSVFileName());
		benchMarkReturnList = populateObjectFromCSV(BenchmarkReturnSeries
				.getCSVFileName());
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws FundProcessingException
	 */
	public static List<? extends IFund> populateObjectFromCSV(String className) {
		CSVReader csvReader = null;
		String csvFileName = ".\\csv\\" + className + ".csv";

		try {

			csvReader = new CSVReader(new FileReader(csvFileName));

			switch (className) {
			case "FundReturnSeries":

				HeaderColumnNameMappingStrategy<FundReturnSeries> strategyFundReturnSeries = new HeaderColumnNameMappingStrategy<>();
				strategyFundReturnSeries.setType(FundReturnSeries.class);
				CsvToBean<FundReturnSeries> csvToFundReturnSeries = new CsvToBean<>();
				List<FundReturnSeries> fundReturnSeriesList = csvToFundReturnSeries
						.parse(strategyFundReturnSeries, csvReader);

				return fundReturnSeriesList;

			case "Fund":

				HeaderColumnNameMappingStrategy<Fund> strategyFund = new HeaderColumnNameMappingStrategy<>();
				strategyFund.setType(Fund.class);
				CsvToBean<Fund> csvToFund = new CsvToBean<>();
				List<Fund> fundList = csvToFund.parse(strategyFund, csvReader);

				return fundList;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				csvReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;

	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws FundProcessingException
	 */
	public static Fund searchFundFromCSV(String searchString) {

		for (IFund iFund : fundList) {
			Fund fund = (Fund) iFund;

			if (fund.getFundCode().equalsIgnoreCase(searchString)) {
				return fund;
			}
		}

		return new Fund();

	}

	public static BenchmarkReturnSeries searchBenchmarkSeriesReturnFromCSV(
			String fundDate, String benchmarkCode) {

		for (IFund iFund : benchMarkReturnList) {
			BenchmarkReturnSeries benchMarkReturnSeries = (BenchmarkReturnSeries) iFund;

			if (benchMarkReturnSeries.getDate().equalsIgnoreCase(fundDate)
					&& benchMarkReturnSeries.getBenchmarkCode()
							.equalsIgnoreCase(benchmarkCode)) {
				return benchMarkReturnSeries;
			}
		}

		return new BenchmarkReturnSeries();

	}

}
