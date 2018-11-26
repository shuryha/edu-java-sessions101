package edu.local.java.core.session101.singleton;


public class SampleSingleton {
	private static volatile SampleSingleton theInstance;
	
	public static SampleSingleton getInstance() {
		if (theInstance == null) {
			synchronized (SampleSingleton.class) {
				if (theInstance == null) {
					theInstance = new SampleSingleton();
				}
			}
		}
		return theInstance;
	}
	
	public String sayHello() {
		return "Hello from Sample DC Singletone '" + this + "'";
	}
}
