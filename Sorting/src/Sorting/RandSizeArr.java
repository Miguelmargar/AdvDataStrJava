package Sorting;

import org.w3c.dom.ls.LSOutput;

public class RandSizeArr {
    int size = (int)(Math.random() * 1000);

    public int[] getRandArray() {
        System.out.println("Array size is: " + size);
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()* 1000);
        }
        return arr;
    }
}
