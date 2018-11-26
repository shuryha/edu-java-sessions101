package edu.local.java.core.session101.builder.cake;

public class BuilderPatternExample {
	public static void main(String[] main) {
		Cake whiteCake = new Cake.Builder().sugar(1).butter(0.5).eggs(2).vanila(2).flour(1.5).bakingpowder(0.75)
				.milk(0.5).build();
		System.out.println(whiteCake);
	}
}
