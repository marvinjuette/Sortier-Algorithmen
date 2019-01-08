package de.nivram710.sortieralgorithmen.main;

class CountingSort {

    static void sort(int[] array) {
        int maxNumber = array[0];
        for (int anArray : array) {
            if (anArray > maxNumber) {
                maxNumber = anArray;
            }
        }

        int minNumber = array[0];
        for (int anArray : array)
            if (anArray < minNumber) {
                minNumber = anArray;
            }

        int[] counts = new int[maxNumber - minNumber + 1];

        for (int anArray : array) {
            counts[anArray - minNumber]++;
        }

        int insertPosition = 0;

        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[insertPosition] = i;
                insertPosition++;
            }
        }
    }
}
