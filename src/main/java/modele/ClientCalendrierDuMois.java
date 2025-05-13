package modele;

public class ClientCalendrierDuMois {
    public static void main(String[] args) {
        DateCalendrier d = new DateCalendrier();
        CalendrierDuMois cdm = new CalendrierDuMois(d.getMois(),d.getAnnee());
        System.out.println(cdm);
        System.out.println(d);
    }
}
