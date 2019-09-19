package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        RandSizeArr randomArr = new RandSizeArr();

//      Selection Sort
        int[] unsorted1 = randomArr.getRandArray();
        SelectionSort selectObj = new SelectionSort(unsorted1);
        StopWatch timerSelect = new StopWatch();
        timerSelect.start();
        int[] finalSelectArray = selectObj.doSort();
        timerSelect.stop();
        System.out.println(Arrays.toString(finalSelectArray));
        System.out.println("Elapsed time for SELECTION SORT is: " + timerSelect.getElapsedTime() + " milliseconds");

//      Insertion Sort
        int[] unsorted2 = randomArr.getRandArray();
        InsertionSort insertObj = new InsertionSort(unsorted2);
        StopWatch timerInsert = new StopWatch();
        timerInsert.start();
        int[] finalInsertArray = insertObj.doSort();
        timerInsert.stop();
        System.out.println(Arrays.toString(finalInsertArray));
        System.out.println("Elapsed time for INSERTION SORT is: " + timerInsert.getElapsedTime() + " milliseconds");

//      Merge Sort
        int[] unsorted3 = randomArr.getRandArray();
        MergeSort mergeObj = new MergeSort(unsorted3);
        StopWatch timerMerge = new StopWatch();
        timerMerge.start();
        int[] finalMergeArray = mergeObj.doSort();
        timerMerge.stop();
        System.out.println(Arrays.toString(finalMergeArray));
        System.out.println("Elapsed time for MERGE SORT is: " + timerMerge.getElapsedTime() + " milliseconds");

//      Quick Sort
//        int[] unsorted4 = randomArr.getRandArray();
//        QuickSort quickObj = new QuickSort(unsorted4);
//        StopWatch timerQuick = new StopWatch();
//        ArrayList<Integer> quickSortFinal = new ArrayList<Integer>();
//        timerQuick.start();
//        quickSortFinal.addAll(quickObj.doSort());
//        timerQuick.stop();
//        System.out.println(quickSortFinal.toString());
//        System.out.println("Elapsed time for QUICK SORT is: " + timerQuick.getElapsedTime() + " milliseconds");
    }
}
