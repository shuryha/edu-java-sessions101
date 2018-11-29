package edu.local.java.misc.csv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;


public class CsvReaderExampleApp {

	public static final String CSV_FILE_NAME = "countries.csv";

	public static final String CSV_REC_OUTPUT_TPL = "%s\t%s\t%s\n";

	public static List<Country> readCsv() throws FileNotFoundException, IOException {
		List<Country> countries = new ArrayList<>();
		final InputStreamReader isr = new InputStreamReader(
				CsvReaderExampleApp.class.getClassLoader().getResourceAsStream(CSV_FILE_NAME));
		final BufferedReader br = new BufferedReader(isr);

		String line = br.readLine(); // Reading header, Ignoring
		while (StringUtils.isNotEmpty((line = br.readLine()))) {
			String[] fields = line.split(",");
			String name = fields[0];
			String capital = fields[1];
			String currency = fields[2];
			Country nation = new Country.CountryBuilder().withName(name).withCapital(capital).withCurrency(currency)
					.build();
			countries.add(nation);
		}
		br.close();
		return countries;
	}

	public static void parseCsv() throws FileNotFoundException, IOException {
		final CSVParser parser = new CSVParser(
				new InputStreamReader(CsvReaderExampleApp.class.getClassLoader().getResourceAsStream(CSV_FILE_NAME)),
				CSVFormat.DEFAULT.withHeader());
		parser.getRecords().stream().forEach(CsvReaderExampleApp::print);
		parser.close();
	}

	public static void print(final List<Country> countries) {
		System.out.println("========================");
		countries.stream().forEach(System.out::println);
		System.out.println("========================");
	}

	public static void print(final CSVRecord rec) {
		System.out.printf(CSV_REC_OUTPUT_TPL, rec.get("NAME"), rec.get("CAPITAL"), rec.get("CURRENCY"));
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		System.out.println("Reading from CSV file using BufferedReader and String Split");
		List<Country> nations = readCsv();
		print(nations);
		System.out.println("Parsing CSV file using SCVParser of Apache commons CSV");
		parseCsv();
	}
}

class Country {
	private String name;
	private String capital;
	private String currency;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", capital=" + capital + ", currency=" + currency + "]";
	}

	public static class CountryBuilder {
		private String name;
		private String capital;
		private String currency;

		public CountryBuilder withName(final String name) {
			this.name = name;
			return this;
		}

		public CountryBuilder withCapital(final String capital) {
			this.capital = capital;
			return this;
		}

		public CountryBuilder withCurrency(final String currency) {
			this.currency = currency;
			return this;
		}

		public Country build() {
			return new Country(this);
		}
	}

	private Country(final CountryBuilder cb) {
		this.name = cb.name;
		this.capital = cb.capital;
		this.currency = cb.currency;
	}
}
