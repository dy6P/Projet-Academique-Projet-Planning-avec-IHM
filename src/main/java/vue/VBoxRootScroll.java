package vue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import modele.CalendrierDuMois;
import modele.ConstantesCalendrier;
import modele.DateCalendrier;

import java.util.List;


public class VBoxRootScroll extends VBox implements ConstantesCalendrier {
    public VBoxRootScroll() {
        DateCalendrier today = new DateCalendrier();
        Label labMois = new Label(MOIS[today.getMois() - 1] + " " + today.getAnnee());
        labMois.setId("titre-mois");
        labMois.setAlignment(Pos.CENTER_LEFT);

        StackPane stackPaneMois = new StackPane ();
        VBox.setMargin(stackPaneMois, new Insets(4));

        /*  Ajout de chaque date du appartenant au mois */
        for (int i = 1; i <= 12; i++){
            VBox boiteDates = new VBox ();
            CalendrierDuMois monthCalendar = new CalendrierDuMois(i, today.getAnnee());

            for (DateCalendrier date : monthCalendar.getDates()) {
                Label labelDate = new Label(date.toString());
                // les attributs id sont utilisés dans la feuille de style
                if (date.getMois() != monthCalendar.getMois()) {
                    labelDate.setId("dateHorsMois");
                }
                if (date.isToday()) {
                    labelDate.setId("today");
                }
                VBox.setMargin(labelDate, new Insets(8));
                boiteDates.getChildren().add(labelDate);
            }

            ScrollPane scrollPaneDates = new ScrollPane();
            scrollPaneDates.setContent(boiteDates);
            scrollPaneDates.setAccessibleText(MOIS[i-1]);

            stackPaneMois.getChildren().add(scrollPaneDates);
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

        this.getChildren().addAll(stackPaneMois,labMois, buttons);
    }
}