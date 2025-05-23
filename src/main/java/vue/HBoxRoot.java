package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;
import modele.*;

public class HBoxRoot extends HBox {

    private static PlanningCollections chPCollection;
    private static Controleur chControleur;
    private static VBoxCalendrier chCalendrierPane;
    private static GridPaneFormulaireReservation chReservationPane;
    private static VBoxAffichagePlanning chAffichagePlanning;

    public HBoxRoot() {
        chPCollection = new PlanningCollections();
        chControleur = new Controleur();
        chCalendrierPane = new VBoxCalendrier();
        chReservationPane = new GridPaneFormulaireReservation();
        chAffichagePlanning = new VBoxAffichagePlanning();

        this.getChildren().addAll(chCalendrierPane, chReservationPane, chAffichagePlanning);
    }

    public static PlanningCollections getPlanning(){
        return chPCollection;
    }

    public static GridPaneFormulaireReservation getReservationPane() {
        return chReservationPane;
    }

    public static VBoxCalendrier getCalendrierPane() {
        return chCalendrierPane;
    }

    public static Controleur getControleur() {
        return chControleur;
    }

    public static VBoxAffichagePlanning getAffichagePlanning() {
        return chAffichagePlanning;
    }
}
