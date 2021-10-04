import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Dataklynge {

    private int maksNoderPerRack;
    private ArrayList<Rack> racks = new ArrayList<Rack>();
    private String filnavn;

    public Dataklynge(String fn){
        filnavn = fn;
        System.out.println("Ny dataklynge: " + fn);
        lesFraFil(); //Starter aa lese inn fra fil
    }

    int nodeTeller;

    public void lesFraFil(){ //Leser inn fra fil bruker har tastet inn
        Scanner fil = null;

        try {
            fil = new Scanner(new File(filnavn));
            System.out.println("\nLeser inn filen \"" + filnavn + "\"...\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        maksNoderPerRack = fil.nextInt();

        int antallNoder;
        int minnePerNode;
        int antProsPerNode;

        while (fil.hasNextLine()){ //Sjekker saa lenge det fortsatt er linjer igjen i fil
            antallNoder = fil.nextInt();
            minnePerNode = fil.nextInt();
            antProsPerNode = fil.nextInt();

            for (int i = 0; i < antallNoder; i++) {
                Noder nyNode = new Noder(minnePerNode, antProsPerNode);
                settInnNode(nyNode); 
            }
        }
        fil.close();
    }

    public void settInnNode(Noder n){ //Metode som sjekker plass i rack og setter inn noder deretter
        if (racks.size() < 1){
            Rack nyRack = new Rack();
            racks.add(nyRack);
            nyRack.settInnNode(n); 
            nodeTeller++;
        } else{
            if (nodeTeller < maksNoderPerRack - 1){
                int sisteRack = racks.size() - 1;
                racks.get(sisteRack).settInnNode(n); 
                nodeTeller++;
            } else {
                Rack nyRack = new Rack();
                racks.add(nyRack);
                nyRack.settInnNode(n);
                nodeTeller = 0;
            }
        }
    }

    public int antProsesser(){//Metode som regner ut ant. prosessorer
        int total = 0;
        
        for (int i = 0; i < racks.size(); i++) {
            total += racks.get(i).antProsesser();
        }
        return total;
    }

    public int antNoderNokM(int paakrevdM){ //MEtode som sjekker totalt ant. noder i dataklynge
        int antNoder = 0;

        for (Rack rack : racks) {
            antNoder += rack.noderMedNokMinne(paakrevdM);
        }
        return antNoder;
    }

    public int antRacks(){ //Metode som sjekker tot.ant. racks i en dataklynge
        return racks.size();
    }
}
