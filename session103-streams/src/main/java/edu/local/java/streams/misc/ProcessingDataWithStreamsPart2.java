package edu.local.java.streams.misc;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessingDataWithStreamsPart2 {
	private static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	private static final int ID_BOUND = 1000;
	private static final int VAL_BOUND = 1000;
	
	/**
	 * Tests {@link Stream} processing result being collected into {@link HashSet}
	 */
	public void testCollectToHashSet() {
		System.out.println("Calling: " + Thread.currentThread().getStackTrace()[1].getMethodName());
		final List<Transaction> exampleData = ProcessingDataWithStreamsPart2.initTestData();
		printExampleData(exampleData);
		final Set<String> resCities = exampleData.stream().filter(t -> t.getValue() > 200).map(Transaction::getCity)
				.collect(Collectors.toCollection(HashSet::new));
		System.out.println("Result: ");
		System.out.println(resCities);
	}
	
	public static List<Transaction> initTestData() {
		Random idGen = new Random(7843);
		Random valGen = new Random(513);
		
		return Arrays.asList(new Transaction(idGen.nextInt(ID_BOUND), valGen.nextInt(VAL_BOUND), "Tokio"),
				new Transaction(idGen.nextInt(ID_BOUND), valGen.nextInt(VAL_BOUND), "London"),
				new Transaction(idGen.nextInt(ID_BOUND), valGen.nextInt(VAL_BOUND), "New York"),
				new Transaction(idGen.nextInt(ID_BOUND), valGen.nextInt(VAL_BOUND), "Madrid"),
				new Transaction(idGen.nextInt(ID_BOUND), valGen.nextInt(VAL_BOUND), "Warsaw"),
				new Transaction(idGen.nextInt(ID_BOUND), valGen.nextInt(VAL_BOUND), "Paris"),
				new Transaction(idGen.nextInt(ID_BOUND), valGen.nextInt(VAL_BOUND), "Barselona"),
				new Transaction(idGen.nextInt(ID_BOUND), valGen.nextInt(VAL_BOUND), "Rome"),
				new Transaction(idGen.nextInt(ID_BOUND), valGen.nextInt(VAL_BOUND), "Milan"),
				new Transaction(idGen.nextInt(ID_BOUND), valGen.nextInt(VAL_BOUND), "Berlin"));
	}
	
	public static void printExampleData(final List<Transaction> exampleData) {
		System.out.println("Example data: ");
		exampleData.stream().forEach(System.out::println);
	}
	
	public static void main(String[] arg) {
		// List<Transaction> exampleData = ProcessingDataWithStreamsPart2.initTestData();
		// exampleData.stream().forEach(System.out::println);
		
		ProcessingDataWithStreamsPart2 example = new ProcessingDataWithStreamsPart2();
		example.testCollectToHashSet();
	}
}

class Transaction {
	public Transaction(long id, long value, String city) {
		super();
		this.id = id;
		this.value = value;
		this.city = city;
	}
	private long id;
	private long value;
	private String city;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", value=" + value + ", city=" + city + "]";
	}
}
