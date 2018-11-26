package edu.local.java.core.session101.singleton;

public class DoubleCheckedLockingExample {

	public static void main(String[] args) {
		SampleSingleton ss = SampleSingleton.getInstance();
		System.out.println(ss.sayHello());
	}
}
