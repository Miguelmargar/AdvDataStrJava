package Sorting;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        RandSizeArr randomArr = new RandSizeArr();

////      Selection Sort
//        int[] unsorted1 = randomArr.getRandArray();
//        SelectionSort selectObj = new SelectionSort(unsorted1);
//        StopWatch timerSelect = new StopWatch();
//        timerSelect.start();
//        int[] finalSelectArray = selectObj.doSort();
//        timerSelect.stop();
//        System.out.println(Arrays.toString(finalSelectArray));
//        System.out.println("Elapsed time for SELECTION SORT is: " + timerSelect.getElapsedTime() + " milliseconds");
//
////      Insertion Sort
//        int[] unsorted2 = randomArr.getRandArray();
//        InsertionSort insertObj = new InsertionSort(unsorted2);
//        StopWatch timerInsert = new StopWatch();
//        timerInsert.start();
//        int[] finalInsertArray = insertObj.doSort();
//        timerInsert.stop();
//        System.out.println(Arrays.toString(finalInsertArray));
//        System.out.println("Elapsed time for INSERTION SORT is: " + timerInsert.getElapsedTime() + " milliseconds");

//      Merge Sort
        int[] unsorted3 = randomArr.getRandArray();
        MergeSort mergeObj = new MergeSort();
        StopWatch timerMerge = new StopWatch();
        timerMerge.start();
        int[] finalMergeArray = mergeObj.doSort(unsorted3);
        timerMerge.stop();
        System.out.println(Arrays.toString(finalMergeArray));
        System.out.println("Elapsed time for MERGE SORT is: " + timerMerge.getElapsedTime() + " milliseconds");
    }
}
