class InsertionSort {

    static void sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int j = i;
            while(j > 0 && array[j-1] > array[j]) {
                int tmp = array[j-1];
                array[j-1] = array[j];
                array[j] = tmp;
                j--;
            }
        }
    }
}
