package modele;


import java.util.Calendar;

public class DateCalendrier extends Date implements ConstantesCalendrier, Comparable <Date>  {

    private int chJourSemaine;
    private int chNoSemaine;

    /** retourne la date d'aujourd'hui
     *
     */
    public DateCalendrier ()   {
        // GregorianCalendar dateAuj = new GregorianCalendar ();
        Calendar dateAuj = Calendar.getInstance();
        chAnnee = dateAuj.get (Calendar.YEAR);
        chMois = dateAuj.get (Calendar.MONTH) + 1;
        chJour = dateAuj.get (Calendar.DAY_OF_MONTH);
        chJourSemaine = dateAuj.get (Calendar.DAY_OF_WEEK);
        if (chJourSemaine == 1)
            chJourSemaine = 7;
        else chJourSemaine -= 1;
        chNoSemaine = dateAuj.get (Calendar.WEEK_OF_YEAR);
    }

    public DateCalendrier (int parJour, int parMois, int parAnnee)   {
        super(parJour, parMois, parAnnee);
        Calendar date = Calendar.getInstance();
        date.set(chAnnee,chMois-1,chJour);
        chJourSemaine = date.get (Calendar.DAY_OF_WEEK);
        if (chJourSemaine == 1)
            chJourSemaine = 7;
        else chJourSemaine -= 1;
        chNoSemaine = date.get (Calendar.WEEK_OF_YEAR);
    }

    public String toString () {
        return  JOURS_SEMAINE [chJourSemaine -1] + " " + chJour + " " + MOIS [chMois-1];
    }

    public int getNoSemaine() {
        return chNoSemaine;
    }

    public int getChJourSemaine() {
        return chJourSemaine;
    }

    public boolean isToday() {
        return this.compareTo(new DateCalendrier()) == 0;
    }

    public DateCalendrier dateDuLendemain ()   {
        Date dateLendemain =  super.dateDuLendemain();
        return new DateCalendrier (dateLendemain.chJour,dateLendemain.chMois,dateLendemain.chAnnee);
    }

    public DateCalendrier dateDeLaVeille ()  {
        Date dateVeille =  super.dateDeLaVeille();
        return new DateCalendrier (dateVeille.chJour,dateVeille.chMois,dateVeille.chAnnee);
    }

    //@Override
    //public int compareTo(Date o) {
    //	return 0;
    //}
}