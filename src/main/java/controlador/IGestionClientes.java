package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class IGestionClientes {

    @FXML
    public Button btnCrearCliente;
    @FXML
    public Button btnMostrarCliente;
    @FXML
    public Button btnVolver;
    @FXML
    private void crearCliente() throws Exception{

        URL url = new File("./src/main/java/vista/ICrearCliente.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnCrearCliente.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }
    @FXML
    private void mostrarCliente() throws Exception{

        URL url = new File("./src/main/java/vista/IMostrarCliente.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnMostrarCliente.getScene().getWindow();
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
