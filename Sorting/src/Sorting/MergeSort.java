package Sorting;

import java.nio.file.attribute.UserPrincipalNotFoundException;

public class MergeSort {
    private int[] myArray;

    public MergeSort(int[] anArray) {
        myArray = anArray;
    }

    public int[] doSort() {
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

        MergeSort first2 = new MergeSort(first);
        MergeSort second2 = new MergeSort(second);
        int[] first2recur = first2.doSort();
        int[] second2recur = second2.doSort();

//        moves the smallest element of each array into the result array
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;

        while (iFirst < first2recur.length && iSecond < second2recur.length) {
            if (first2recur[iFirst] < second2recur[iSecond]) {
                result[j] = first2recur[iFirst];
                iFirst++;
            }
            else {
                result[j] = second2recur[iSecond];
                iSecond++;
            }
            j++;
        }
//      last remaining element of one or the other array to be pushed to the result array
        while (iFirst < first2recur.length) {
            result[j] = first2recur[iFirst];
            iFirst++;
            j++;
        }
        while (iSecond < second2recur.length) {
            result[j] = second2recur[iSecond];
            iSecond++;
            j++;
        }
        return result;
    }
}
