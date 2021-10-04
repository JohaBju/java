public class Aapning extends HvitRute {
    private static int teller = 1;
    public Aapning(Labyrint labArr, int rPos, int kPos){
        super(labArr, rPos, kPos);
    }

    @Override
    public boolean sjekkAapning(){
        return true;
    }

    @Override
    public void gaa(String vei, Rute forrige){
        vei += toString() + " | Mulig utvei nr." + teller + "\n";
        refLabyrint.utveier.leggTil(vei);
        teller++;
    }
}
