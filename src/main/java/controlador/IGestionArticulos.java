package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class IGestionArticulos {

    @FXML
    public Button btnAnadir;
    @FXML
    public Button btnMostrar;
    @FXML
    public Button btnVolver;
    @FXML
    private void anadirArticulo() throws Exception{

        URL url = new File("./src/main/java/vista/IAnadirArticulo.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnAnadir.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }
    @FXML
    private void mostrarArticulo() throws Exception{

        URL url = new File("./src/main/java/vista/IMostrarArticulo.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnMostrar.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }

    @FXML
    private void volverEscena() throws Exception{

        URL url = new File("./src/main/java/vista/IGestionOS.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnVolver.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }
}
