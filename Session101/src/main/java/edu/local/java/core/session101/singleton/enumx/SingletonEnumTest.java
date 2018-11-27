package edu.local.java.core.session101.singleton.enumx;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SingletonEnumTest {
	
	private static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	public static void main(String[] args) {
		LOGGER.info("Logger: '" + SingletonEnum.INSTANCE.sayHello());
		System.out.println(SingletonEnum.INSTANCE.sayHello());
	}
}
