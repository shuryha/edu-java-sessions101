package edu.local.java.streams.files;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileToLinesExample {
	private static final String TEST_FILE_NAME = "countries.csv";
	public static void main(String[] arg) throws URISyntaxException, IOException {
		final long numberOfLines = Files
				.lines(Paths.get(ClassLoader.getSystemResource(TEST_FILE_NAME).toURI()), Charset.defaultCharset())
				.count();
		System.out.println("Line num: " + numberOfLines);
	}
}
