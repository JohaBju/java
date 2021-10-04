import java.util.Scanner;
import java.util.ArrayList;

public class Datasenter {

    public static void main(String[] args) {
        
        //Lager muligheten for aa legge til flere dataklynger i et array 
        final ArrayList<Dataklynge> dataklyngeListe = new ArrayList();

        //Starter scanner og leser inn brukerinput/filnavn
        Scanner innles = new Scanner(System.in);
        System.out.print("Skriv inn filnavn: ");
        String filn = innles.nextLine();
        innles.close();

        //Oppretter et nytt dataklyngeobjekt samt adder det til liste
        Dataklynge nyDataklynge = new Dataklynge(filn);
        dataklyngeListe.add(nyDataklynge);

        //Tester for div. minnekrav
        int noder32GB = nyDataklynge.antNoderNokM(32);
        int noder64GB = nyDataklynge.antNoderNokM(64);
        int noder128GB = nyDataklynge.antNoderNokM(128);
        int antRacks = nyDataklynge.antRacks();
        int antPros = nyDataklynge.antProsesser();

        //Lesbar linje til bruker
        System.out.println("\nNoder med minst\n32GB: " + noder32GB + "\n64GB: " + noder64GB + "\n128GB: " + noder128GB + "\n\nAnt prosessorer: " + antPros + "\nAntall racks: " + antRacks + "\n");
    }
}