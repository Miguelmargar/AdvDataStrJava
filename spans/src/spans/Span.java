package spans;

public class Span {
	
	public Span() {
		
	}
	
	public int[] getSpan(int[] arr) {
		int[] span_array = new int[arr.length];
		
		int counter = 1;
		int biggest = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				span_array[i] = 1;
				biggest = arr[i];
			}
			else {
				if (arr[i] <= arr[i - 1]) {
					counter = 1;
					span_array[i] = counter;
					biggest = arr[i - 1];
					counter++;
				} else {
					if (arr[i] <= biggest) {
						span_array[i] = counter;
						counter++;
					} else {
						counter = 1;
						span_array[i] = counter;
						biggest = arr[i];
					}
				}
			}
		}
		return span_array;
	}
}
