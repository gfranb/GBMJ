package controlador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class OnlineStore extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL url = new File("./src/main/java/vista/IGestionOS.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        //GestionOS gestion = new GestionOS();
        //gestion.inicio();
        launch(args);
    }

}