package edu.local.java.core.session101.enummap;

import java.util.EnumMap;


public class EnumMapExample {
	public enum STATE {
		NEW, RUNNING, WAITING, FINISHED
	}

	public static void main(String[] args) {
		@SuppressWarnings("serial")
		EnumMap<STATE, String> stateMap = new EnumMap<STATE, String>(STATE.class) {
			{
				put(STATE.RUNNING, "Program is running");
				put(STATE.WAITING, "Program is waiting");
				put(STATE.NEW, "Program has just been created");
				put(STATE.FINISHED, "Program has finished");
			}
		};

		System.out.println("Size of EnumMap in java: " + stateMap.size());

		System.out.println("EnumMap: " + stateMap);

		System.out.println("EnumMap key: " + STATE.NEW + ", value: " + stateMap.get(STATE.NEW));

		stateMap.keySet().stream().forEach(s -> System.out.println("key: " + s + ", value: " + stateMap.get(s)));
		
		System.out.println("Does stateMap has:" + STATE.NEW + ": " + stateMap.containsKey(STATE.NEW));
		
		System.out.println("Does stateMap has: " + STATE.NEW + ": " + stateMap.containsValue(null));
	}
}
