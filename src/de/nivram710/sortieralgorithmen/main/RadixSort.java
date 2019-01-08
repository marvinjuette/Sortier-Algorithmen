package de.nivram710.sortieralgorithmen.main;

import java.util.Arrays;

class RadixSort {

    private static int getMax(int[] array) {
        int max =array[0];
        for (int anArray : array) {
            if (anArray > max) {
                max = anArray;
            }
        }
        return max;
    }

    private static void countSort(int[] array, int exp) {
        int[] output = new int[array.length];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for(i=0; i < array.length; i++) {
            count[(array[i]/exp)%10]++;
        }

        for(i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        for(i = array.length - 1; i >= 0; i--) {
            output[count[(array[i]/exp)%10] - 1] = array[i];
            count[(array[i]/exp)%10]--;
        }

        for(i=0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

    static void sort(int[] array) {
        int max = getMax(array);
        for(int exp = 1; max/exp > 0; exp*=10) {
            countSort(array, exp);
        }
    }

}
