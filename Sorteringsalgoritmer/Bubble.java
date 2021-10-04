public class Bubble extends Sorter{
    @Override
    void sort() {

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                //Checks if current element is greater than next element
                if (gt(A[j], A[j+1])){
                    //Swaps if conditiion is true
                    swap(j+1, j);
                }
            }
        }
    }
    
    @Override
    String algorithmName() {
        return "bubble sort";
    }
}
