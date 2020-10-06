package de.nivram710.sortieralgorithmen.main;

public class MergeSort {

    public static int[] sort(int[] array) {
        // get array length
        int n = array.length;

        // recursion stop
        if (n <= 1) return array;

        else {
            // split array into two
            int leftArrayLength = n/2;
            int rightArrayLength = n-leftArrayLength;
            int[] leftArray = new int[leftArrayLength];
            int[] rightArray = new int[rightArrayLength];

            System.arraycopy(array, 0, leftArray, 0, leftArrayLength);
            leftArray = sort(leftArray);

            if (rightArrayLength >= 0) System.arraycopy(array, leftArrayLength, rightArray, 0, rightArrayLength);
            rightArray = sort(rightArray);

            return merge(leftArray, rightArray);
        }
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        // get sizes of arrays
        int leftArraySize = leftArray.length;
        int rightArraySize = rightArray.length;
        int n = leftArraySize + rightArraySize;

        // create new empty array to merge in
        int[] mergeArray = new int[n];

        // create counter
        int counterMergeArray, counterLeftArray, counterRightArray;
        counterMergeArray = 0; counterLeftArray = 0; counterRightArray = 0;

        // while there are elements in both arrays compare then by size and the merge
        while(counterLeftArray < leftArraySize && counterRightArray < rightArraySize) {
            if (leftArray[counterLeftArray] <= rightArray[counterRightArray]) {
                mergeArray[counterMergeArray] = leftArray[counterLeftArray];
                counterMergeArray++; counterLeftArray++;
            } else {
                mergeArray[counterMergeArray] = rightArray[counterRightArray];
                counterMergeArray++; counterRightArray++;
            }
        }

        // if there are only elements left in the right array --> add them to the mergeArray
        while(counterRightArray < rightArraySize) {
            mergeArray[counterMergeArray] = rightArray[counterRightArray];
            counterMergeArray++; counterRightArray++;
        }

        // if there are only elements left in the left array --> add them to the mergeArray
        while(counterLeftArray < leftArraySize) {
            mergeArray[counterMergeArray] = leftArray[counterLeftArray];
            counterMergeArray++; counterLeftArray++;
        }


        return mergeArray;
    }

}
