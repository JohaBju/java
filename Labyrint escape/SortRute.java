public class SortRute extends Rute {
    public SortRute(Labyrint labArr, int rPos, int kPos){
        super(labArr, rPos, kPos);
    }

    @Override
    //Sort rute representeres vha tegn '#'
    public char tilTegn(){
        return '#';
    }

    @Override
    //Dersom gaa-metode møter en "vegg"
    public void gaa(String vei, Rute forrige){
        return;
    }
}