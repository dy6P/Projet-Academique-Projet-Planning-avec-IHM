package modele;

public class Horaire {
    private int chHeure;
    private int chQuartHeure;

    public String toString() {
        return chHeure + "h" + chQuartHeure;
    }

    public Horaire(int parHeure, int parQuartheure) {
        chHeure = parHeure;
        chQuartHeure = parQuartheure;
    }

    public int compareTo(Horaire o) {
        if (this.toMinutes() > o.toMinutes()) {
            return 1;
        } else if (this.toMinutes() < o.toMinutes()) {
            return -1;
        }
        return 0;
    }

    public int toMinutes() {
        return chHeure * 60 + chQuartHeure;
    }

    public int getHeure() {
        return chHeure;
    }

    public int getQuartHeure() {
        return chQuartHeure;
    }

    public void setHeure(int parHeure) {
        chHeure = parHeure;
    }

    public void setQuartheure(int parQuartheure) {
        chQuartHeure = parQuartheure;
    }
}
