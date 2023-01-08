package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class IGestionPedidos {
    @FXML
    public Button btnAnadir;
    @FXML
    public Button btnMostrar;
    @FXML
    public Button btnEliminar;
    @FXML
    public Button btnVolver;
    @FXML
    private void anadirPedido() throws Exception{

        URL url = new File("./src/main/java/vista/IAnadirPedido.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnAnadir.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }
    @FXML
    private void eliminarPedido() throws Exception{

        URL url = new File("./src/main/java/vista/IEliminarPedido.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnEliminar.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }
    @FXML
    private void mostrarPedidos() throws Exception{

        URL url = new File("./src/main/java/vista/IMostrarPedidos.fxml").toURI().toURL();
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
