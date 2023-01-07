package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;


public class IGestionOS {
    @FXML
    public Button btnArticulos;
    @FXML
    public Button btnClientes;
    @FXML
    public Button btnPedidos;

    @FXML
    private void gestionArticulos() throws Exception{

        URL url = new File("./src/main/java/vista/IGestionArticulos.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnArticulos.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }

    @FXML
    private void gestionClientes() throws Exception{

        URL url = new File("./src/main/java/vista/IGestionClientes.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnClientes.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }

    @FXML
    private void gestionPedidos() throws Exception{

        URL url = new File("./src/main/java/vista/IGestionPedidos.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnPedidos.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }
}
