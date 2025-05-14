package vue;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;


public class Application extends javafx.application.Application {
    public void start(Stage stage) {
        HBoxRoot root = new HBoxRoot();
        Scene scene = new Scene(root, 1000, 700);

        File css = new File("CSS" + File.separator + "VBoxRootCalendrier.css");
        scene.getStylesheets().add(css.toURI().toString());

        stage.setScene(scene);
        stage.setTitle("Calendrier du mois");
        stage.show();
    }
    public static void main (String [] args) {
        javafx.application.Application.launch();
    }
}