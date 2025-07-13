package Func;

import java.util.function.Supplier;

public class StringSupplier implements Supplier<String> {
	private int next = 0;
	private String[] arr;

	public StringSupplier(String s) {
		arr = s.split(" ");
	}

	@Override
	public String get() {
		if (next >= arr.length) return null;
		return arr[next++];
	}
}
