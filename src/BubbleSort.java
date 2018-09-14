class BubbleSort {

    static void sort(int[] array) {
        int arrayLength = array.length;

        while(arrayLength > 1) {
            for(int i=0; i <= arrayLength -2; i++) {
                if(array[i] > array[i+1]) {
                    int tmp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = tmp;
                }
            }
            arrayLength -= 1;
        }
    }
}
