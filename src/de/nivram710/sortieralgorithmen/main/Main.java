package de.nivram710.sortieralgorithmen.main;

import de.nivram710.sortieralgorithmen.fx.Controller;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final int arrayLength = 10_000;

    private static final boolean SHOW_ARRAYS = true;

    private static int[] array;
    private static int[] arrayUnsorted = new int[arrayLength];

    public static void main(String[] args) {

        runAlgorithms(true, true, true, true, true, true, true, false, arrayLength);

    }

    public static void runAlgorithms(boolean bubblesort, boolean selectionsort, boolean insertionsort, boolean mergesort, boolean quicksort, boolean countingsort, boolean radixsort, boolean windowMode, int arraySize) {

        array = new int[arraySize];

        long startTime;

        if(!windowMode) {
            System.out.println("================================================");
            System.out.println("============= Sortier Algorithmen ==============");
            System.out.println("================================================");

            space();
        }

        // Bubble Sort
        if(bubblesort) {
            if(windowMode) Controller.getInstace().addLabelToListView("================== Bubble Sort =================");
            else System.out.println("================== Bubble Sort =================");
            initArray();
            startTime = System.nanoTime();
            BubbleSort.sort(array);
            evaluateTime(startTime, windowMode);
        }

        // Insertion Sort
        if(insertionsort) {
            if(windowMode) Controller.getInstace().addLabelToListView("================= Insertion Sort ================");
            else System.out.println("================= Insertion Sort ================");
            initArray();
            startTime = System.nanoTime();
            InsertionSort.sort(array);
            evaluateTime(startTime, windowMode);
        }

        // Selection Sort
        if(selectionsort) {
            if(windowMode) Controller.getInstace().addLabelToListView("================= Selection Sort ================");
            else System.out.println("================= Selection Sort ================");
            initArray();
            startTime = System.nanoTime();
            SelectionSort.sort(array);
            evaluateTime(startTime, windowMode);
        }

        // Merge Sort
        if(mergesort) {
            if(windowMode) Controller.getInstace().addLabelToListView("=================== Merge Sort ===================");
            else System.out.println("=================== Merge Sort ===================");
            initArray();
            startTime = System.nanoTime();
            array = MergeSort.sort(array);
            evaluateTime(startTime, windowMode);
        }

        // Quick Sort
        if(quicksort) {
            if(windowMode) Controller.getInstace().addLabelToListView("=================== Quick Sort =================");
            else System.out.println("=================== Quick Sort =================");
            initArray();
            startTime = System.nanoTime();
            SelectionSort.sort(array);
            evaluateTime(startTime, windowMode);
        }

        // Counting Sort
        if(countingsort) {
            if(windowMode) Controller.getInstace().addLabelToListView("================= Counting Sort ================");
            else System.out.println("================= Counting Sort ================");
            initArray();
            startTime = System.nanoTime();
            CountingSort.sort(array);
            evaluateTime(startTime, windowMode);
        }

        // Radix Sort
        if(radixsort) {
            if(windowMode) Controller.getInstace().addLabelToListView("================= Radix Sort ================");
            else System.out.println("================= Radix Sort ================");
            initArray();
            startTime = System.nanoTime();
            RadixSort.sort(array);
            evaluateTime(startTime, windowMode);
        }

        if(windowMode) Controller.getInstace().button_start.setDisable(false);
    }

    private static void evaluateTime(long startTime, boolean windowMode) {
        long elapsedTime;
        elapsedTime = System.nanoTime() - startTime;

        String unit = "ns";
        if (elapsedTime > 1500) {
            elapsedTime = TimeUnit.MICROSECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
            unit = "μs";
        }
        if (elapsedTime > 1500) {
            elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.MICROSECONDS);
            unit = "ms";
        }
        if (elapsedTime > 1500) {
            elapsedTime = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.MILLISECONDS);
            unit = "s";
        }

        if (SHOW_ARRAYS) {
            if(windowMode) {
                Controller.getInstace().addLabelToListView("Unsortiertes Array: " + Arrays.toString(arrayUnsorted));
                Controller.getInstace().addLabelToListView("Sortiertes Array: " + Arrays.toString(array));
            } else {
                System.out.println("Unsortiertes Array: " + Arrays.toString(arrayUnsorted));
                System.out.println("Sortiertes Array: " + Arrays.toString(array));
            }
        }
        if(windowMode) Controller.getInstace().addLabelToListView("Dauer: " + elapsedTime + unit);
        else System.out.println("Dauer: " + elapsedTime + unit);

        if(!windowMode) space();
    }

    private static void space() {
        System.out.println(" ");
        System.out.println(" ");
    }

    private static void initArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(0, 100);
        }
        arrayUnsorted = array.clone();
    }
}
