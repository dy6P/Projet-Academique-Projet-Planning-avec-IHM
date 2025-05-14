package modele;

public class Reservation implements Comparable<Reservation> {
    private DateCalendrier ChDate;
    private PlageHoraire ChPlageHoraire;
    private String ChIntitule;

    public Reservation(String parintitule,DateCalendrier parDate,PlageHoraire ParPlageHoraire) throws ExceptionReservation{
        ChIntitule = parintitule;
        ChDate = parDate;
        ChPlageHoraire = ParPlageHoraire;

        if (! est_valide())
            throw new ExceptionReservation("Reservation invalide.");
    }

    public boolean est_valide (){
        return ChDate.estValide() && ChPlageHoraire.estValide() && ChIntitule != null && getChPlageHoraire() != null;
    }


    // GET :
    public DateCalendrier getChDate() {
        return ChDate;
    }
    public PlageHoraire getChPlageHoraire() {
        return ChPlageHoraire;
    }
    public String getChIntitule() {
        return ChIntitule;
    }
    // SET :
    public void setChDate(DateCalendrier chDate) {
        ChDate = chDate;
    }
    public void setChPlageHoraire(PlageHoraire chPlageHoraire) {
        ChPlageHoraire = chPlageHoraire;
    }
    public void setChIntitule(String chIntitule) {
        ChIntitule = chIntitule;
    }

    public int compareTo(Reservation r) {
        if(ChDate.compareTo(r.ChDate) == 0){
            return ChPlageHoraire.compareTo(r.ChPlageHoraire);
        }
        return ChDate.compareTo(r.ChDate);
    }

    public String toString() {
        return ChIntitule + ", " + ChDate + ", " + ChPlageHoraire;
    }
}
