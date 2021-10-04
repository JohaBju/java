import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labyrint {

    //Antall rader og kolonner
    private static int r;
    private static int k;
    private static Rute[/*rad*/][/*kolonne*/] labArr;
    public static Liste<String> utveier;

    private Labyrint(Rute nyLabyrint[][], int antRad, int antKolonner){
        r = antRad;
        k = antKolonner;
        labArr = nyLabyrint;
    }

    public static Labyrint lesFraFil(File filn) throws FileNotFoundException{
        Scanner scanner = new Scanner(filn);

        //Første linje leses inn fra fil (dersom den har gått forbi try/catch uten problemer)
        String infoLinje = scanner.nextLine();
        String[] labyrintInfo = infoLinje.split(" ");

        //Setter antall kolonner og rader
        int antR = Integer.parseInt(labyrintInfo[0]); int antK = Integer.parseInt(labyrintInfo[1]);
        Rute[][] ruter = new Rute[antR][antK];
        Labyrint nyLabyrint = new Labyrint(ruter, antR, antK);

        Rute rute;
        int rad = 0;
        while (scanner.hasNext()){
            int kol = 0;
            Rute[] aktuellRad = new Rute[antK];
            String lestFraFil = scanner.nextLine();
            String[] deler = lestFraFil.split("");
            for (String x: deler){
                rute = null;
                if (x.equals("#")){
                    rute = new SortRute(nyLabyrint, rad, kol);
                } else if(x.equals(".")){
                    if((rad == 0) || (rad == antR-1)|| (kol ==  0) || (kol == antK-1)){ //Dersom det er åpning
                        rute = new Aapning(nyLabyrint, rad, kol);
                    } else{
                        rute = new HvitRute(nyLabyrint, rad, kol);
                    }
                } else {
                    System.out.println("FEIL\nForventet: \"#\" eller \".\"\nFaktisk verdi: " + x);
                }
                aktuellRad[kol] = rute;
                kol++;
            }
            ruter[rad] = aktuellRad;
            rad++;
        }

        for(int y = 0;y < antR; y++) {
            for (int x = 0; x < antK; x++){
                Rute n = null; Rute o = null; Rute s = null; Rute v = null;
                Rute aktuell = ruter[y][x];
                //Nord
                if (y != 0) {
                    n = ruter[y - 1][x];
                }
                //Sør
                if (y != (antR - 1)) {
                    s = ruter[y + 1][x];
                }
                //Vest
                if (x != 0) {
                    v = ruter[y][x - 1];
                }
                //Øst
                if (x != (antK - 1)) {
                    o = ruter[y][x + 1];
                }
                aktuell.settInnNabo(n, o, s, v);
            }
        }
        return new Labyrint(ruter, antR, antK);
    }

    public Liste<String> finnUtveiFra(int kol, int rad){
        utveier = new Lenkeliste<String>();
        Rute startRute = labArr[rad][kol];
        startRute.finnUtvei();
        return utveier;
    }

    public String toString(){
        String utskrift = " Stoerrelse: " + r + " x " + k + " ruter | Totalt: " + r*k + " ruter (XX markerer åpning)\n";
        //Går igjennom hele arrayet
        for(Rute[] rad : labArr){
            for(Rute e : rad){
                //Sørger for pen utskrift
                if (e.sjekkAapning()) {
                    utskrift += "XX";
                } else if (e.tilTegn() == '.'){
                    utskrift += "  ";
                } else {
                    utskrift += "##";
                }
            }
            utskrift += "\n";
        }
        return utskrift;
    }
}
