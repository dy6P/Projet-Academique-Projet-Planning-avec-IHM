package modele;

public class PlageHoraire implements Comparable<PlageHoraire> {
    private final static int ChDuree_min = 30;
    private final Horaire chHoraireDebut;
    private final Horaire chHoraireFin;

    public PlageHoraire(Horaire parhdebut, Horaire parhfin) throws ExceptionPlageHoraire{
        chHoraireDebut = parhdebut;
        chHoraireFin = parhfin;
        if (! estValide()) {
            throw new ExceptionPlageHoraire("Plage Horaire inférieur à 30");
        }
    }

    public boolean estValide() { return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes() >= ChDuree_min;}


    public int duree() { return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes();}

    public int compareTo(PlageHoraire parPlageHoraire) {
        if(parPlageHoraire.chHoraireFin.toMinutes() < this.chHoraireDebut.toMinutes()) {
            return 1;
        }
        else if(parPlageHoraire.chHoraireDebut.toMinutes() > this.chHoraireFin.toMinutes()) {
            return -1;
        }
        return 0;
    }

    public String toString() {
        return chHoraireDebut + "-" + chHoraireFin + ", durée : "+
                duree()/60 + "h"+
                duree()%60 + "min";
    }
}
