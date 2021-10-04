import java.util.ArrayList;

public class Rack {

    ArrayList <Noder> nodeListe;//Oppretter nytt array

    public Rack (){
        nodeListe = new ArrayList<Noder>();
    }

    public void settInnNode(Noder nyNode){
        nodeListe.add(nyNode); 
    }

    public int visAntNoder(){   
        return nodeListe.size(); //Returnerer antall nodeobjekter i array
    }

    public int antProsesser(){
        int total = 0;
        for (int i = 0; i < nodeListe.size(); i++){
            total += nodeListe.get(i).returnerAntPros();
            }
        return total;  
    }

    public int noderMedNokMinne(int paakrevdMinne){ //Metode som sjekker hvilke noder i en rack som er godkjente

        int kravOppfylteNoder = 0;

        for (int i = 0; i < nodeListe.size(); i++){ //Gaar igjennom arr
            if (nodeListe.get(i).sjekkNokMinne(paakrevdMinne)){ //Sjekker at minne er mindre enn maks minne
                kravOppfylteNoder++;
            }
        }
        return kravOppfylteNoder;
    }
}