//Just for fun

public class Bogo extends Sorter{
    int BOGO_SORT_LIMIT = 100000000;
    int bogo_sort_count = 0;

    @Override
    void sort() {
        //Remove to run bogo
        if (n == original.length){
            while(!sorted(A)){
                if (bogo_sort_count >= BOGO_SORT_LIMIT) {
                    System.out.println("Giving up on Bogo :/ Here's your unsorted pile of cards back.");
                    break;
                }
                shuffle();
            }
        }
    }

    boolean sorted(int[] A){
        for (int i=1; i< A.length; i++) 
            if (lt(A[i], A[i-1])) {
                return false;
            }
            System.out.println("Bogo sort completed successfully. Consider yourself lucky");
            return true; 
    }

    void shuffle(){
        for (int i = 1; i < n; i++) {
            swap(i, (int)(Math.random()*i));
            bogo_sort_count++;
        }
    }

    @Override
    String algorithmName() {
        return "bogo";
    }
}
