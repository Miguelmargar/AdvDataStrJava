package Sorting;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public class MergeSort {
    private int[] myArray;

//    public MergeSort(int[] anArray) {
//        myArray = anArray;
//    }

    public int[] doSort(int[] myArray) {
//        Base case
        if (myArray.length < 2) return myArray;

//        create an empty array for final result
        int[] result = new int[myArray.length];

//        Create two empty arrays
        int[] first = new int[myArray.length/2];
        int[] second = new int[myArray.length - first.length];

//        copy 1st half items to first empty array
        for (int i = 0; i < first.length; i++) {
            first[i] = myArray[i];
        }
//        copy 2nd half items to second empty array
        for (int i = 0; i < second.length; i++) {
            second[i] = myArray[first.length + i];
        }

//        moves the smallest element of each array into the result array
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            }
            else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
//      last remaining element of one or the other array to be pushed to the result array
        while (iFirst < first.length) {
            result[j] = first[iFirst];
            iFirst++;
            j++;
        }
        while (iSecond < second.length) {
            result[j] = second[iSecond];
            iSecond++;
            j++;
        }
        return result;
    }
}
