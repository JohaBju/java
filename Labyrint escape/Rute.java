abstract public class Rute {
    protected int radPos, kolPos;
    protected Rute n, s, o, v; //Naboruter
    protected static Lenkeliste<String> utveierArr;
    protected Labyrint refLabyrint;

    public Rute(Labyrint nyLab, int rPos, int kPos){
        radPos = rPos;
        kolPos = kPos;
        refLabyrint = nyLab;
    }

    public void settInnNabo(Rute nord, Rute ost, Rute sor, Rute vest){
        n = nord; o = ost; s = sor; v = vest;
    }
    abstract char tilTegn();

    public boolean sjekkAapning(){
        return false;
    }

    public Liste<String> finnUtvei(){
        gaa("", this);
        return utveierArr;
    }

    public abstract void gaa(String kart, Rute forrige);

    @Override
    public String toString(){
        return String.format("(%d,%d)", kolPos, radPos);
    }
}
