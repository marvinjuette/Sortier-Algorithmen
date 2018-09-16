import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int arrayLength = 10000;

    private static int[] array = new int[arrayLength];
    private static int[] arrayUnsorted = new int[arrayLength];

    public static void main(String[] args) {

        long startTime;
        long elapsedTime;

        System.out.println("================================================");
        System.out.println("============= Sortier Algorithmen ==============");
        System.out.println("================================================");

        space();


        // Bubble Sort
        System.out.println("================== Bubble Sort =================");
        initArray();
        startTime = System.nanoTime();
        BubbleSort.sort(array);
        elapsedTime = System.nanoTime() - startTime;
        elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println("Unsortiertes Array: " + Arrays.toString(arrayUnsorted));
        System.out.println("Sortiertes Array: " + Arrays.toString(array));
        System.out.println("Dauer: " + elapsedTime + "ms");

        space();

        // Insertion Sort
        System.out.println("================= Insertion Sort ================");
        initArray();
        startTime = System.nanoTime();
        InsertionSort.sort(array);
        elapsedTime = System.nanoTime() - startTime;
        elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println("Unsortiertes Array: " + Arrays.toString(arrayUnsorted));
        System.out.println("Sortiertes Array: " + Arrays.toString(array));
        System.out.println("Dauer: " + elapsedTime + "ms");

        space();

        // Selection Sort
        System.out.println("================= Selection Sort ================");
        initArray();
        startTime = System.nanoTime();
        SelectionSort.sort(array);
        elapsedTime = System.nanoTime() - startTime;
        elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println("Unsortiertes Array: " + Arrays.toString(arrayUnsorted));
        System.out.println("Sortiertes Array: " + Arrays.toString(array));
        System.out.println("Dauer: " + elapsedTime + "ms");

        space();

        // Quick Sort
        System.out.println("=================== Quick Sort =================");
        initArray();
        startTime = System.nanoTime();
        SelectionSort.sort(array);
        elapsedTime = System.nanoTime() - startTime;
        elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println("Unsortiertes Array: " + Arrays.toString(arrayUnsorted));
        System.out.println("Sortiertes Array: " + Arrays.toString(array));
        System.out.println("Dauer: " + elapsedTime + "ms");

        space();

        // Counting Sort
        System.out.println("================= Counting Sort ================");
        initArray();
        startTime = System.nanoTime();
        CountingSort.sort(array);
        elapsedTime = System.nanoTime() - startTime;
        elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println("Unsortiertes Array: " + Arrays.toString(arrayUnsorted));
        System.out.println("Sortiertes Array: " + Arrays.toString(array));
        System.out.println("Dauer: " + elapsedTime + "ms");

        space();

        // Radix Sort
        System.out.println("================= Radix Sort ================");
        initArray();
        startTime = System.nanoTime();
        RadixSort.sort(array);
        elapsedTime = System.nanoTime() - startTime;
        elapsedTime = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
        System.out.println("Unsortiertes Array: " + Arrays.toString(arrayUnsorted));
        System.out.println("Sortiertes Array: " + Arrays.toString(array));
        System.out.println("Dauer: " + elapsedTime + "ms");
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
