package vue;

import controleur.Controleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;

import java.util.List;


public class VBoxCalendrier extends VBox implements ConstantesCalendrier {
    public VBoxCalendrier() {
        DateCalendrier today = new DateCalendrier();

        Label labMois = new Label(MOIS[today.getMois() - 1] + " " + today.getAnnee());
        labMois.setId("titre-mois");
        labMois.setAlignment(Pos.CENTER_LEFT);
        labMois.setAlignment(Pos.CENTER_LEFT);

        StackPane stackPaneMois = new StackPane();
        ToggleGroup buttonGroup = new ToggleGroup();
        VBox.setMargin(stackPaneMois, new Insets(4));

        /*  Ajout de chaque date du appartenant au mois */
        for (int numMois = 1; numMois <= 12; numMois++){
            CalendrierDuMois monthCalendar = new CalendrierDuMois(numMois, today.getAnnee());
            TilePane tilePane = new TilePane();
            tilePane.setPrefColumns(7);
            tilePane.setPrefRows(monthCalendar.getDates().size() % 7 + 1);
            tilePane.setPadding(new Insets(4));
            tilePane.setId("opaque");

            for (String jourAb : JOURS_SEMAINE_ABR){
                Label labelJour = new Label(jourAb);
                labelJour.setId("labelJour");
                tilePane.getChildren().add(labelJour);
            }

            for (DateCalendrier date : monthCalendar.getDates()) {
                ToggleButton boutonDate = new ToggleButton(Integer.toString(date.getJour()));

                boutonDate.setToggleGroup(buttonGroup);
                tilePane.getChildren().add(boutonDate);

                boutonDate.setUserData(date);
                boutonDate.setOnAction(new Controleur());
                if (date.getMois() != monthCalendar.getMois()) {
                    boutonDate.setId("dateHorsMois");
                }
                if (date.isToday()) {
                    boutonDate.setId("today");
                }
            }

            tilePane.setAccessibleText(MOIS[numMois-1]);
            stackPaneMois.getChildren().add(tilePane);

        }
        List<Node> liste = stackPaneMois.getChildren();
        int indiceSommet = liste.size() -1;
        while (!liste.get(indiceSommet).getAccessibleText().equals(MOIS[today.getMois()-1])) {
            liste.getFirst().toFront();
        }

        Button boutonNext = new Button(">");
        Button boutonPrevious = new Button("<");
        Button boutonLast = new Button(">>");
        Button boutonFirst = new Button("<<");

        HBox buttons = new HBox();
        buttons.getChildren().addAll(boutonFirst, boutonPrevious,boutonNext, boutonLast);
        buttons.setAlignment(Pos.CENTER_RIGHT);
        HBox.setHgrow(buttons, Priority.ALWAYS);

        HBox h_labMois = new HBox();
        h_labMois.getChildren().addAll(labMois);

        HBox toolBar = new HBox();
        toolBar.getChildren().addAll(h_labMois, buttons);

        toolBar.setPadding(new Insets(15,100,0,100));

        boutonNext.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton next");
                liste.getFirst().toFront();
                String str = liste.get(indiceSommet).getAccessibleText();
                labMois.setText(str + " " + today.getAnnee());
            }
        });

        boutonPrevious.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton previous");
                liste.getLast().toBack();
                String str = liste.get(indiceSommet).getAccessibleText();
                labMois.setText(str + " " + today.getAnnee());
            }
        });

        boutonLast.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton Last_month");
                while (!liste.get(indiceSommet).getAccessibleText().equals(MOIS[liste.size()-1])) {
                    liste.getFirst().toFront();
                }
                String str = liste.get(indiceSommet).getAccessibleText();
                labMois.setText(str + " " + today.getAnnee());
            }
        });

        boutonFirst.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                System.out.println("bouton First_month");
                while (!liste.get(indiceSommet).getAccessibleText().equals(MOIS[0])) {
                    liste.getFirst().toFront();
                }
                String str = liste.get(indiceSommet).getAccessibleText();
                labMois.setText(str + " " + today.getAnnee());
            }
        });

        this.getChildren().addAll(stackPaneMois,toolBar);
    }
}
