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
        VBoxAffichagePlanning affichagePlanning = HBoxRoot.getAffichagePlanning();

        if (event.getSource() instanceof ToggleButton) {
            ToggleButton toggleButton = (ToggleButton) event.getSource();
            DateCalendrier dateCalendrier = (DateCalendrier) toggleButton.getUserData();
            reservationPane.setDate(dateCalendrier);
            affichagePlanning.setChNumSemaine(dateCalendrier.getNoSemaine());
            affichagePlanning.clearTableDesReservations();
            for (Reservation reservation : planning.getReservations(dateCalendrier.getNoSemaine())) {
                affichagePlanning.ajouterReservation(reservation);
            }
        }

        if (event.getSource() instanceof Button) {
            Reservation reservation;
            try {
                reservation = reservationPane.getReservation();
            } catch (ExceptionPlageHoraire parException) {
                throw new RuntimeException(parException);
            }
            planning.ajout(reservation);
            System.out.println(planning);
            affichagePlanning.clearTableDesReservations();
            DateCalendrier dateCalendrier = reservation.getChDate();
            affichagePlanning.clearTableDesReservations();
            for (Reservation reservation2 : planning.getReservations(dateCalendrier.getNoSemaine())) {
                affichagePlanning.ajouterReservation(reservation2);
            }
        }
    }
}
