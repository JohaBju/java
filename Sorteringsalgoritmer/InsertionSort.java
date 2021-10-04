class InsertionSort extends Sorter{

    void sort() {

        for (int i = 1; i < n; ++i) { 
            int current = A[i];
            int j = i - 1; 

            //Checks if next element is bigger than current and index j is greater or equal to 0
            while (geq(j, 0) && gt(A[j], current)) {
                //Increases swaps and changes number on indexes
                swaps++;
                A[j + 1] = A[j]; 
                j = j - 1;
            } 
            //Sets next index to current
            A[j + 1] = current;
        } 
    }

    String algorithmName() {
        return "insertion";
    }

}