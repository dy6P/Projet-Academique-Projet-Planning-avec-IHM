package vue;

import controleur.Controleur;
import javafx.scene.layout.HBox;
import modele.*;

public class HBoxRoot extends HBox {

    private static PlanningCollections chPCollection;
    private static Controleur chControleur;
    private static VBoxCalendrier chCalendrierPane;
    private static GridPaneFormulaireReservation chReservationPane;

    public HBoxRoot() {
        chPCollection = new PlanningCollections();
        chControleur = new Controleur();
        chCalendrierPane = new VBoxCalendrier();
        chReservationPane = new GridPaneFormulaireReservation();

        this.getChildren().addAll(chCalendrierPane, chReservationPane);
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
}
