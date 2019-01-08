package de.nivram710.sortieralgorithmen.main;

class SelectionSort {

    static void sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int smallest = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < smallest) {
                    smallest = array[j];
                    array[j] = array[i];
                    array[i] = smallest;
                }
            }
        }
    }
}
