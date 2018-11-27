package edu.local.java.core.session101.singleton.enumx;

public enum SingletonEnum {
	INSTANCE;
	
	private SingletonEnum() {}
	
	public String sayHello() {
		return new StringBuilder("Say hello from '" + SingletonEnum.class + "'").toString();
	}
}
