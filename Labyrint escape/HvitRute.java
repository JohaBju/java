public class HvitRute extends Rute {

    public HvitRute(Labyrint labArr, int rPos, int kPos){
        super(labArr, rPos, kPos);
    }

    @Override
        //Hvit rute representeres vha tegn '.'
    char tilTegn(){
        return '.';
    }

    @Override
    //Rekursiv gaa-funksjon
    public void gaa(String vei, Rute forrige){
        vei += toString() + " --> ";
        if (n != forrige) n.gaa(vei, this);
        if (o != forrige) o.gaa(vei, this);
        if (s != forrige) s.gaa(vei, this);
        if (v != forrige) v.gaa(vei, this);
    }
}
