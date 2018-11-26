package edu.local.java.core.session101.singleton.staticholder;


public class StaticHolderSingleton {
	private static class InstanceHolder {
		public static StaticHolderSingleton theInstance = new StaticHolderSingleton(); 
	}
	
	private StaticHolderSingleton () {}
	
	public static StaticHolderSingleton getInstance() {
		return InstanceHolder.theInstance;
	}
	
	public String sayHello() {
		return "Hello from '" + this + "'";
	}
	
	public static void main(String[] args) {
		StaticHolderSingleton theSingletone = StaticHolderSingleton.getInstance();
		System.out.println(theSingletone.sayHello());
	}
}
