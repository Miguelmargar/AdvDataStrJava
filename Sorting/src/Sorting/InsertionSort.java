package Sorting;

public class InsertionSort {
    private int[] myArray;

    public InsertionSort(int[] anArray) {
        myArray = anArray;
    }

    public int[] doSort() {

        for (int i = 0; i < myArray.length; i++) {
            int j = i;
            while (j > 0) {
                if (myArray[j] < myArray[j - 1]) {
                    int temp = myArray[j];
                    myArray[j] = myArray[j - 1];
                    myArray[j - 1] = temp;
                }
                j--;
            }
        }
        return myArray;
    }

}
