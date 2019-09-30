package spans;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] a = {6, 3, 4, 1, 2, 3, 5, 4};
		Span cool = new Span();
		System.out.println(Arrays.toString(cool.getSpan(a)));
	}
}
