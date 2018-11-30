package edu.local.java.core.session101.datetime.core;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Month;

public class NewDateTimeSampleApp {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2016,Month.APRIL, 1);
		System.out.println("Date from new API is: " + date);
		
		System.out.println("System default zone: " + Clock.systemDefaultZone());
	}
}
