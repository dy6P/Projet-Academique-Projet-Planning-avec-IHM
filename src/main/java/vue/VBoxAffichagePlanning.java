package vue;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.DateCalendrier;

public class VBoxAffichagePlanning extends VBox {
    private Label chNumSemaine;

    public VBoxAffichagePlanning() {
        DateCalendrier calendrier = new DateCalendrier();
        chNumSemaine = new Label(String.valueOf(calendrier.getNoSemaine()));
    }

    public void setChNumSemaine(int parNumSemaine) {
        chNumSemaine.setText(String.valueOf(parNumSemaine));
    }

    public String getChNumSemaine() {
        return "Semaine " + chNumSemaine.getText();
    }
}
