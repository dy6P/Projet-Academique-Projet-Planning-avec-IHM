package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.*;
import vue.*;

public class Controleur implements EventHandler {
    @Override
    public void handle(Event event) {
        PlanningCollections planning = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();

        if (event.getSource() instanceof ToggleButton) {
            ToggleButton toggleButton = (ToggleButton) event.getSource();
            DateCalendrier dateCalendrier = (DateCalendrier) toggleButton.getUserData();
            reservationPane.setDate(dateCalendrier);
        }

        if (event.getSource() instanceof Button) {

        }
    }
}
