package edu.local.java.core.session101.concurrency.printdemo;

public class PrintDemo {
	public void printCount() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Selected number is: '" + i + "' @" + Thread.currentThread().getName());
			}
		} catch (Exception e) {
			System.out.println("Thread has been interrupted.");			
		}
	}
}
