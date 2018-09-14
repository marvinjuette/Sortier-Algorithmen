import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    private static int arrayLength = 10000;

    public static void main(String[] args) {

        long startTime;
        long elapsedTime;

        int[] bubbleSort = initArray();
        int[] insertionSort = initArray();
        int[] selectionSort = initArray();
        int[] quickSort = initArray();
        int[] countingSort = initArray();

        int[] bubbleSortUnsort = bubbleSort.clone();
        int[] insertionSortUnsort = insertionSort.clone();
        int[] selectionSortUnsort = selectionSort.clone();
        int[] quickSortUnsort = quickSort.clone();
        int[] countingSortUnsort = quickSort.clone();

        System.out.println("================================================");
        System.out.println("============= Sortier Algorithmen ==============");
        System.out.println("================================================");

        space();

        // Bubble Sort
        System.out.println("================== Bubble Sort =================");
        startTime = System.nanoTime();
        BubbleSort.sort(bubbleSort);
        elapsedTime = System.nanoTime() - startTime;
        elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println("Unsortiertes Array: " + Arrays.toString(bubbleSortUnsort));
        System.out.println("Sortiertes Array: " + Arrays.toString(bubbleSort));
        System.out.println("Dauer: " + elapsedTime + "ms");

        space();

        // Insertion Sort
        System.out.println("================= Insertion Sort ================");
        startTime = System.nanoTime();
        InsertionSort.sort(insertionSort);
        elapsedTime = System.nanoTime() - startTime;
        elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println("Unsortiertes Array: " + Arrays.toString(insertionSortUnsort));
        System.out.println("Sortiertes Array: " + Arrays.toString(insertionSort));
        System.out.println("Dauer: " + elapsedTime + "ms");

        space();

        // Selection Sort
        System.out.println("================= Selection Sort ================");
        startTime = System.nanoTime();
        SelectionSort.sort(selectionSort);
        elapsedTime = System.nanoTime() - startTime;
        elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println("Unsortiertes Array: " + Arrays.toString(selectionSortUnsort));
        System.out.println("Sortiertes Array: " + Arrays.toString(selectionSort));
        System.out.println("Dauer: " + elapsedTime + "ms");

        space();

        // Quick Sort
        System.out.println("=================== Quick Sort =================");
        startTime = System.nanoTime();
        SelectionSort.sort(quickSort);
        elapsedTime = System.nanoTime() - startTime;
        elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println("Unsortiertes Array: " + Arrays.toString(quickSortUnsort));
        System.out.println("Sortiertes Array: " + Arrays.toString(quickSort));
        System.out.println("Dauer: " + elapsedTime + "ms");

        space();

        // Counting Sort
        System.out.println("================= Counting Sort ================");
        startTime = System.nanoTime();
        CountingSort.sort(countingSort);
        elapsedTime = System.nanoTime() - startTime;
        elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println("Unsortiertes Array: " + Arrays.toString(countingSortUnsort));
        System.out.println("Sortiertes Array: " + Arrays.toString(countingSort));
        System.out.println("Dauer: " + elapsedTime + "ms");
    }

    private static void space() {
        System.out.println(" ");
        System.out.println(" ");
    }

    private static int[] initArray() {
        int[] array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(0, 100);
        }
        return array;
    }
}
