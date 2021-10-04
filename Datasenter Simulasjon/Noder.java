public class Noder {

    private int minne;
    private int antProsessor;

    public Noder(int mn, int pross){
        minne = mn;
        antProsessor = pross;
    }

    public int returnerAntPros(){
        return antProsessor;//Returnerer antall prosessorer i noden 
    }

    public boolean sjekkNokMinne(int paakrevdMinne){
        return (paakrevdMinne <= minne);//Sjekker om minnet paa noden er innenfor kravspecs
    }
}