package vue;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modele.DateCalendrier;
import modele.PlageHoraire;
import modele.Reservation;

public class VBoxAffichagePlanning extends VBox {
    private Label chNumSemaine;
    private TableView<Reservation> tableDesReservations;

    public VBoxAffichagePlanning() {
        DateCalendrier calendrier = new DateCalendrier();
        chNumSemaine = new Label("Semaine " + String.valueOf(calendrier.getNoSemaine()));
        tableDesReservations = new TableView<>();

        TableColumn<Reservation, DateCalendrier> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("ChDate"));
        tableDesReservations.getColumns().add(dateColumn);

        TableColumn<Reservation, String> coursColumn = new TableColumn<>("Cours");
        coursColumn.setCellValueFactory(new PropertyValueFactory<>("ChIntitule"));
        tableDesReservations.getColumns().add(coursColumn);

        //TableColumn<Reservation, String> typeColumn = new TableColumn<>("Type");
        //dateColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        //tableDesReservations.getColumns().add(typeColumn);

        TableColumn<Reservation, PlageHoraire> plageHoraireColumn = new TableColumn<>("Horaire");
        plageHoraireColumn.setCellValueFactory(new PropertyValueFactory<>("ChPlageHoraire"));
        tableDesReservations.getColumns().add(plageHoraireColumn);

        this.getChildren().addAll(chNumSemaine, tableDesReservations);
    }

    public void ajouterReservation(Reservation reservation) {
        tableDesReservations.getItems().add(reservation);
    }

    public void clearTableDesReservations() {
        tableDesReservations.getItems().clear();
    }

    public void setChNumSemaine(int parNumSemaine) {
        chNumSemaine.setText("Semaine " + parNumSemaine);
    }
}
