package vue;

import controleur.Controleur;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import modele.DateCalendrier;

public class GridPaneFormulaireReservation extends GridPane {
    private DateCalendrier chDateCourante = new DateCalendrier();
    private Label chJour = new Label(chDateCourante.toString());

    public GridPaneFormulaireReservation() {
        setGridLinesVisible(false);

        Label cours = new Label("_Cours");
        TextField eventName = new TextField();
        eventName.setPromptText("Entrer un nom de cours");
        cours.setLabelFor(eventName);

        Label level = new Label("_Type");

        ToggleGroup group = new ToggleGroup();
        RadioButton TD = new RadioButton("_TD");
        TD.setSelected(true);
        RadioButton TP = new RadioButton("_TP");
        RadioButton Amphi = new RadioButton("_Amphi");
        RadioButton DS = new RadioButton("_DS");
        group.getToggles().addAll(TD, TP, Amphi, DS);

        Label from = new Label("De");
        Label to = new Label("A");


        ChoiceBox<String> hourFrom = new ChoiceBox<String>();
        ChoiceBox<String> hourTo = new ChoiceBox<String>();
        ChoiceBox<String> minuteTo = new ChoiceBox<String>();
        ChoiceBox<String> minuteFrom = new ChoiceBox<String>();

        setHourBox(hourFrom);
        setHourBox(hourTo);
        setMinutesBox(minuteFrom);
        setMinutesBox(minuteTo);

        Button reset = new Button("_Annuler");
        Button save = new Button("_Enregistrer");

        int heureDebut = hourFrom.getSelectionModel().getSelectedIndex();
        int minuteDebut = minuteFrom.getSelectionModel().getSelectedIndex();
        int heureFin = hourTo.getSelectionModel().getSelectedIndex();
        int minuteFin = minuteTo.getSelectionModel().getSelectedIndex();

        add(chJour, 0, 0);

        add(cours, 0,1);
        add(eventName, 1, 1);

        add(level, 0, 2);
        add(TD, 1, 2);
        add(TP, 2, 2);
        add(Amphi, 1, 3);
        add(DS, 2, 3);

        add(from, 0, 4);
        add(to, 2, 4);
        add(hourFrom, 1, 4);
        add(hourTo, 3, 4);
        add(minuteFrom, 1, 5);
        add(minuteTo, 3, 5);

        add(reset, 2, 6);
        add(save, 3, 6);
        Platform.runLater(eventName::requestFocus);


        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                eventName.clear();
                TD.setSelected(true);
                TP.setSelected(false);
                Amphi.setSelected(false);
                DS.setSelected(false);
                hourTo.getSelectionModel().clearSelection();
                hourFrom.getSelectionModel().clearSelection();
                minuteTo.getSelectionModel().clearSelection();
                minuteFrom.getSelectionModel().clearSelection();


            }
        });

        save.setOnAction(new Controleur());

    }

    private void setMinutesBox(ChoiceBox<String> _c) {

        for (int i = 0; i < 4; i++) {
            String temp = Integer.toString(i*15);
            if (temp.length() < 2) {
                temp = "0" + temp;
            }

            _c.getItems().add(temp);
        }
    }

    private void setHourBox(ChoiceBox<String> _c) {

        for (int i = 8; i < 18; i++) {
            String temp = Integer.toString(i);
            if (temp.length() < 2) {
                temp = "0" + temp;
            }
            _c.getItems().add(temp);
        }
    }

    public void setDate(DateCalendrier parDate) {
        chDateCourante = parDate;
        chJour.setText(chDateCourante.toString());
    }
}
