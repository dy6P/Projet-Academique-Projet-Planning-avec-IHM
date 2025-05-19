package vue;

import controleur.Controleur;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import modele.*;

public class GridPaneFormulaireReservation extends GridPane {
    private DateCalendrier chDateCourante = new DateCalendrier();
    private Label chJour = new Label(chDateCourante.toString());
    private ChoiceBox<String> chHeuresDebut = new ChoiceBox<String>();
    private ChoiceBox<String> chMinutesDebut = new ChoiceBox<String>();
    private ChoiceBox<String> chHeuresFin = new ChoiceBox<String>();
    private ChoiceBox<String> chMinutesFin = new ChoiceBox<String>();
    private Integer chHeureDebut = 8;
    private Integer chHeureFin = 9;
    private Integer chMinuteDebut = 0;
    private Integer chMinuteFin = 0;
    private TextField chEventName = new TextField();
    private RadioButton chTD = new RadioButton("_TD");
    private RadioButton chTP = new RadioButton("_TP");
    private RadioButton chAmphi = new RadioButton("_Amphi");
    private RadioButton chDS = new RadioButton("_DS");
    private final String [] MINUTES = {"0", "15", "30", "45"};
    private final String [] HEURES = {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17"};

    public GridPaneFormulaireReservation() {
        setGridLinesVisible(false);

        Label cours = new Label("_Cours");
        chEventName.setPromptText("Entrer un nom de cours");
        cours.setLabelFor(chEventName);

        Label type = new Label("_Type");

        ToggleGroup group = new ToggleGroup();
        chTD.setSelected(true);
        group.getToggles().addAll(chTD, chTP, chAmphi, chDS);

        Label from = new Label("De");
        Label to = new Label("A");

        setHeuresBox(chHeuresDebut);
        setHeuresBox(chHeuresFin);
        setMinutesBox(chMinutesDebut);
        setMinutesBox(chMinutesFin);

        Button reset = new Button("_Annuler");
        Button save = new Button("_Enregistrer");

        add(chJour, 0, 0);
        add(cours, 0,1);
        add(chEventName, 1, 1);
        add(type, 0, 2);
        add(chTD, 1, 2);
        add(chTP, 2, 2);
        add(chAmphi, 1, 3);
        add(chDS, 2, 3);
        add(from, 0, 4);
        add(to, 2, 4);
        add(chHeuresDebut, 1, 4);
        add(chHeuresFin, 3, 4);
        add(chMinutesDebut, 1, 5);
        add(chMinutesFin, 3, 5);
        add(reset, 2, 6);
        add(save, 3, 6);

        Platform.runLater(chEventName::requestFocus);

        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                annuler();
            }
        });
        save.setOnAction(new Controleur());
    }

    private void setMinutesBox(ChoiceBox<String> parMinutes) {
        for (String minute : MINUTES) {
            parMinutes.getItems().add(minute);
        }
    }

    private void setHeuresBox(ChoiceBox<String> parHeures) {
        for (String heure : HEURES) {
            parHeures.getItems().add(heure);
        }
    }

    public void setDate(DateCalendrier parDate) {
        chDateCourante = parDate;
        chJour.setText(chDateCourante.toString());
    }

    public int getNumSemaine() {
        return chDateCourante.getNoSemaine();
    }

    public void annuler() {
        chEventName.clear();
        chTD.setSelected(true);
        chTP.setSelected(false);
        chAmphi.setSelected(false);
        chDS.setSelected(false);
        chHeuresFin.getSelectionModel().clearSelection();
        chHeuresDebut.getSelectionModel().clearSelection();
        chMinutesFin.getSelectionModel().clearSelection();
        chMinutesDebut.getSelectionModel().clearSelection();
        chHeureFin = 9;
        chHeureDebut = 8;
        chMinuteFin = 0;
        chMinuteDebut = 0;
    }

    public Reservation getReservation() throws ExceptionPlageHoraire {
        if (chHeuresDebut.getValue() != null && chHeuresFin.getValue() != null) {
            chHeureDebut = Integer.parseInt(chHeuresDebut.getValue());
            chHeureFin = Integer.parseInt(chHeuresFin.getValue());
            if (chMinutesDebut.getValue() != null && chMinutesFin.getValue() != null) {
                chMinuteDebut= Integer.parseInt(chMinutesDebut.getValue());
                chMinuteFin = Integer.parseInt(chMinutesFin.getValue());
            }
        }
        Reservation reservation = new Reservation(chEventName.getText(), chDateCourante, new PlageHoraire(new Horaire(chHeureDebut, chMinuteDebut), new Horaire(chHeureFin, chMinuteFin)));
        annuler();
        return reservation;
    }
}
