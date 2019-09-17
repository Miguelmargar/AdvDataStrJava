package Sorting;

public class SelectionSort {
    private int[] myArray;

    public SelectionSort(int[] anArray) {
        myArray = anArray;
    }

    public int[] doSort() {

        for (int i = 0; i < myArray.length; i++) {
            for (int j = i; j < myArray.length; j++) {
                if (myArray[i] >= myArray[j]) {
                    int placeholder = myArray[i];
                    myArray[i] = myArray[j];
                    myArray[j] = placeholder;
                }
            }
        }
        return myArray;
    }
}
