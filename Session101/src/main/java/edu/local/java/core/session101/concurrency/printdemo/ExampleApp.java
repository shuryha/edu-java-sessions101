package edu.local.java.core.session101.concurrency.printdemo;


public class ExampleApp {
	
	public static void main(String args[]) {
		PrintDemo printDemo = new PrintDemo();
		
		ThreadDemo firstThread = new ThreadDemo("Thread 1", printDemo);
		ThreadDemo secondThread = new ThreadDemo("Thread 2", printDemo);
		ThreadDemo thirdThread = new ThreadDemo("Thread 3", printDemo);
		
		try {
			firstThread.start();
			secondThread.start();
			thirdThread.start();
		} catch (Exception e) {
			System.out.println("Interrupted.");
		}
	}
}
