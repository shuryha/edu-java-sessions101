package edu.local.java.core.session101.string.trickyq;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

public class StringGetBytesExample {
	public static void main(String[] args) throws Exception {
		char[] chars = new char[] {'\u0097'};
		String str = new String(chars);
		byte[] bytes = str.getBytes();
		System.out.println("Locale (def): " + Locale.getDefault());
		System.out.println("Charset (def): " + Charset.defaultCharset());
		System.out.println("Chars: " + chars[0]);
		System.out.println("Bytes: " + Arrays.toString(bytes));
	}
}
