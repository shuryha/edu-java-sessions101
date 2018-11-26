package edu.local.java.core.session101.concurrency.printdemo;

public class ThreadDemo implements Runnable {
	private Thread thread;
	private String threadName;
	PrintDemo printDemo;
	
	ThreadDemo(String threadName, PrintDemo printDemo) {
		this.threadName = threadName;
		this.printDemo = printDemo;
	}

	public void run() {
/*		synchronized(printDemo) {
			printDemo.printCount();
		}
*/
		printDemo.printCount();
		System.out.println("Thread " + threadName + " finishing.");
	}
	
	public void start() {
		System.out.println("Starting " + threadName);
		if (thread == null) {
			thread = new Thread(this, threadName);
			thread.start();
		}
	}
}

