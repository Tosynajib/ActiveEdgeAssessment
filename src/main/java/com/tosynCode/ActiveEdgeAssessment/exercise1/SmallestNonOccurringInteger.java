package com.tosynCode.ActiveEdgeAssessment.exercise1;

public class SmallestNonOccurringInteger {

    public static int findSmallestNonOccurringInteger(int[] array){
        int n = array.length;

        for (int i = 0; i < n; i++) {
            while (array[i] > 0 && array[i] <= n && array[array[i] -1] != array[i]) {
                int temp= array[array[i] -1];
                array[array[i] -1] = array[i];
                array[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main (String[] args) {
        int[] array1 = {1, 3, 6, 4, 1, 2};
        int[] array2 = {5, -1, -3};

        System.out.println(findSmallestNonOccurringInteger(array1));
        System.out.println(findSmallestNonOccurringInteger(array2));
    }
}
