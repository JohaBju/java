//https://github.uio.no/IN2010/oblig3_h20_src/blob/master/Quick.java

class Quicksort extends Sorter{

    @Override
    void sort() {
        //Create a reccursive sort-algorithm
        internal_sort(A, 0, A.length-1);
    }

    void internal_sort(int[] array, int low, int high) {
        //if equal, it is only one element
        if (lt(low, high)) {
            int partitionIndex = partition(array, low, high);

            //sort before and after partition
            internal_sort(array, low, partitionIndex-1);
            internal_sort(array, partitionIndex+1, high);
        }
    }

    int partition(int[] array, int low, int high){
        int pivot = array[high]; //last / highest element
        int i = low-1; //setter til en under low fordi vi oker den foer vi bruker den, se senere
        for (int j=low; j<high; j++) {
            if (lt(array[j], pivot)) {
                i++;
                //Swaps if condition is true
                swap(i, j);
            }
        }

        //swap array[i+1] with the pivot
        swap(i+1, high);

        return i+1;
    } 

    String algorithmName() {
        return "quick";
    }
}