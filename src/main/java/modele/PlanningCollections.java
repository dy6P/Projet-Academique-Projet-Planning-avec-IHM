package modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;


public class PlanningCollections {
    private ArrayList<Reservation> chListe;
    private TreeSet<Reservation> chSet;
    private TreeMap<Integer,TreeSet<Reservation>> chMap;

    public PlanningCollections() {
        chListe = new ArrayList<>();
        chSet = new TreeSet<>();
        chMap = new TreeMap<>();
    }

    public void ajout (Reservation r) {
        chSet.add(r);
        chListe.add(r);
        int numSem = r.getChDate().getNoSemaine();
        if (chMap.containsKey(numSem)) {
            chMap.get(numSem).add(r);
        }
        else {
            TreeSet<Reservation> valeurs = new TreeSet<>();
            valeurs.add(r);
            chMap.put(numSem, valeurs);
        }
    }

    public String toString () {
        //String str = "\nArrayList\n" + chListe+ "\nTreeSet\n" + chSet + "\nTreeMap\n" + chMap + "\n";
        //return "Taille liste : " + chListe.size() + "\nTaille Set : " + chSet.size() + "Taille Map : " + chMap.size() + str;
        return chMap.toString();
    }

    public TreeSet<Reservation> getReservations(DateCalendrier parDate) {
        TreeSet<Reservation> res = new TreeSet<>();
        Iterator<Reservation> it = chSet.iterator();
        while (it.hasNext()) {
            Reservation r = it.next();
            if (r.getChDate().compareTo(parDate) == 0) {
                res.add(r);
            }
        }
        return res;
    }

    public TreeSet<Reservation> getReservations(String parString) {
        TreeSet<Reservation> res = new TreeSet<>();
        Iterator<Reservation> it = chSet.iterator();
        while (it.hasNext()) {
            Reservation r = it.next();
            if (r.getChIntitule().equals(parString)) {
                res.add(r);
            }
        }
        return res;
    }
}
