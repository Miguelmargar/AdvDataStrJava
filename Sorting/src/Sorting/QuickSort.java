package Sorting;
import java.util.ArrayList;


public class QuickSort {
    ArrayList<Integer> myArray = new ArrayList<Integer>();

    public QuickSort(int[] anArray) {
        for (int num : anArray) {myArray.add(num);}
    }

    public QuickSort(ArrayList<Integer> anArray) {
        myArray = anArray;
    }

    public ArrayList<Integer> doSort() {
//      Base case
        if (myArray.size() < 2) return myArray;

//      Create empty Arrays for smaller, pivot and bigger values
        ArrayList<Integer> pivot = new ArrayList<Integer>();
        pivot.add(myArray.get(0));
        myArray.remove(0);

        ArrayList<Integer> smaller = new ArrayList<Integer>();
        ArrayList<Integer> bigger = new ArrayList<Integer>();

//      sort each item and send to the appropiate array
        while (myArray.size() > 0) {
//            System.out.println("Array size inside while is:" + myArray.size());

            if (myArray.get(0) < pivot.get(0)) {
                smaller.add(myArray.get(0));
                myArray.remove(0);
            }
            else if (myArray.get(0) == pivot.get(0)) {
                pivot.add(myArray.get(0));
                myArray.remove(0);
            }
            else if (myArray.get(0) > pivot.get(0)) {
                bigger.add(myArray.get(0));
                myArray.remove(0);
            }
        }

//      Recursively do the same to each of the above arrays and return the sum
//      of the three arrays
        QuickSort finalP = new QuickSort(pivot);

        QuickSort finalS = new QuickSort(smaller);

        QuickSort finalB = new QuickSort(bigger);

        ArrayList<Integer> finalArr = new ArrayList<Integer>();
        finalArr.addAll(finalS.doSort());
        finalArr.addAll(finalP.doSort());
        finalArr.addAll(finalB.doSort());

        return finalArr;
    }
}
