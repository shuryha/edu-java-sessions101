package edu.local.java.streams.misc;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiscStreamExamples {
	
	private static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	public void testCollect() {
		System.out.println("Calling: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		final List<String> words = Arrays.asList("Oracle", "Java", "Magazine");
		final List<Integer> wordLengths = words.stream().map(String::length).collect(Collectors.toList());
		System.out.println(
				"Words lengths: " + Arrays.toString(wordLengths.parallelStream().mapToInt(Integer::intValue).toArray()));
	}

	public void testReduce() {
		System.out.println("Calling: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		final long sum = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println("Sum: " + sum);
	}
	
	public void testInfStream() {
		System.out.println("Calling: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Stream<Integer> numbers = Stream.iterate(0, n -> n + 10);
		numbers.limit(5).forEach(System.out::println);
	}
	
	/**
	 * Flat map example
	 */
	public void testFlatMap() {
		System.out.println("Calling: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		
		Stream<String> words = Stream.of("Java", "Magazine", "is", "the", "best");

		Map<String, Long> letterToCount = words.map(w -> w.split(StringUtils.EMPTY)).flatMap(Arrays::stream)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		System.out.println(letterToCount);
	}
	
	public static final String TEST_FILE_NAME = "stuff.txt";
	
	/**
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public void testFileLinesFlatMap() throws IOException, URISyntaxException {
		System.out.println("Calling: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Files.lines(Paths.get(ClassLoader.getSystemResource(TEST_FILE_NAME).toURI()), Charset.defaultCharset())
				.map(line -> line.split("\\s+"))
				// .map(Arrays::stream) // map String[] to Stream<String>
				.flatMap(Arrays::stream) // map String[] to Stream<String>
				.distinct()
				.forEach(System.out::println);
	}
	
	public void testFileLinesFlatMap2() throws IOException, URISyntaxException {
		System.out.println("Calling: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Map<String, Long> wordsToCount = Files.lines(Paths.get(ClassLoader.getSystemResource(TEST_FILE_NAME).toURI()), Charset.defaultCharset())
				.map(line -> line.split("\\s+"))
				// .map(Arrays::stream) // map String[] to Stream<String>
				.flatMap(Arrays::stream) // map String[] to Stream<String>
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(wordsToCount);
	}

	public static void main(String[] args) {
		final MiscStreamExamples examples = new MiscStreamExamples();
		//examples.testReduce();
		//examples.testCollect();
		// examples.testInfStream();		
		// examples.testFlatMap();
		
		try {
			// examples.testFileLinesFlatMap();
			examples.testFileLinesFlatMap2();
		} catch (IOException | URISyntaxException e) {
			LOGGER.error("Failed to load and parse file: ", e);
		}
	}
}
