package edu.local.java.core.session101.inheritance;

import java.util.Arrays;
import java.util.List;

public class InheritanceExample {
	public static void main(String[] args) {
/*		List<BaseA> testClazzes = Arrays.asList(new BaseB(), new BaseC());
		testClazzes.stream().forEach(tc -> System.out.println("Class: " + tc.getClass().getName() + "; " + tc.sayHello("Alex")));
		System.out.println("Class C: " + ((BaseC)testClazzes.get(1)).sayHello(1));*/

//		System.out.println("0.1 * 3: " + (0.1 * 3));
//		System.out.println("0.1 * 3 != 0.3: " + (0.1 * 3 != 0.3));
		
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("Hello from runnable");
			}
		};
		
		Thread testThread = new Thread(r);
		testThread.run();
		
		Thread testThread1 = new Thread(() -> System.out.println("Hello From func runnable"));
		testThread1.run();
	}
}

class BaseA {
	public String sayHello(String name) {
		return "Hello, " + name;
	}
}

class BaseB extends BaseA {
	@Override
	public String sayHello(String name) {
		return "Hello, hello " + name;
	}
}

class BaseC extends BaseA {
	public String sayHello(int num) {
		return "Hello, hello " + "num: " + num;
	}
}

@FunctionalInterface
interface ExampleFunctionalInterface {
	void doSmth(Object o);
}
