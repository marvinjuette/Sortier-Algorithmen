class QuickSort {

    private static int partition(int[] array, int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = array[(left + right) / 2];

        while (i <= j) {
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;
            if (i <= j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    static void sort(int[] array, int left, int right) {
        int index = partition(array, left, right);
        if(left < index - 1) sort(array, left, index - 1);
        if(index < right) sort(array, index, right);
    }

}
