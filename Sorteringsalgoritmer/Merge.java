public class Merge extends Sorter{
    @Override
    void sort() {
        //https://www.geeksforgeeks.org/merge-sort/
        internal_sort(A, 0, A.length - 1);
    }

    //Arrayen blir aldri "splittet" teknisk sett, saa den trenger aldri settes sammen igjen.
    //Man unngaar splitting og forskjellige arrays ved aa holde rede paa indeksene som gjor grensene til arrayene.
    private void internal_sort(int[] array, int left, int right) {
        //Hvis de er samme er det bare ett element igjen, trenger ikke sortere mer da.
        if (left < right) {
            int center = (left + right) / 2;

            //Sorter left array, den delen av array som gaar fra venstre til midten.
            internal_sort(array, left, center);

            //Sorter right array, den delen av array som gaar fra midten til hoyre.
            //(bruker middle+1 slik at samme element ikke blir med i begge delene')
            internal_sort(array, center+1, right);

            //Merge de to etter de har blitt sortert
            merge(array, left, center, right);
        }
    }

    //Her ogsaa bruker vi kun low og high til aa slippe aa splitte arrayen
    private void merge(int[] array, int left, int center, int right) {

        //legg til 1 for aa faa med center elementet
        int leftSize = center-left+1;

        int rightSize = right-center;

        int leftTmp[] = new int[leftSize]; 

        int rightTmp[] = new int[rightSize]; 

        //Fyll tmp arrays med data
        for (int i = 0; i<leftSize;i++) {
            leftTmp[i] = array[left+i];
        }
        //Ikke tell med center elementet paa right side
        for (int i = 0; i<rightSize;i++) {
            rightTmp[i] = array[center+1+i];
        }
        int leftIndex = 0;
        int rightIndex = 0;
        int arrayIndex = left; //forste indeks vi skal bruke i hovedarrayen

        //Merge, gaa gjennom alle elementene og legg til i riktig rekkefolge.
        while (lt(leftIndex,leftSize) && lt(rightIndex, rightSize)) {
            if (leq(leftTmp[leftIndex], rightTmp[rightIndex])) {
                array[arrayIndex] = leftTmp[leftIndex];
                leftIndex++;
            } else {
                array[arrayIndex] = rightTmp[rightIndex];
                rightIndex++;
            }
            arrayIndex++;
        }

        //Kopier resterende elementer hvis arrayene har storrelsesforskjell.
        //Man kan anta at hver av arrayene (left, right) er sortert fra for.
        while (lt(leftIndex, leftSize)) {
            array[arrayIndex] = leftTmp[leftIndex];
            leftIndex++;
            arrayIndex++;
        }

        while (lt(rightIndex, rightSize)) {
            array[arrayIndex] = rightTmp[rightIndex];
            rightIndex++;
            arrayIndex++;
        }
    }

    @Override
    String algorithmName() {
        return "merge sort";
    }
}
