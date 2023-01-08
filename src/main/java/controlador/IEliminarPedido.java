package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class IEliminarPedido {
    private Controlador controlador;

    @FXML
    public Button btnVolver;
    @FXML
    public Button btnEliminar;
    @FXML
    public TextField inPedido;

    @FXML
    private void volverEscena() throws Exception{

        URL url = new File("./src/main/java/vista/IGestionPedidos.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnVolver.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }

    @FXML
    private void eliminarPedidos() throws Exception{

        controlador = new Controlador();

        int nPedido = Integer.parseInt(inPedido.getText());
        Alert alert = new Alert(Alert.AlertType.NONE);

        if(controlador.eliminarPedido(nPedido)){
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("Pedido " + nPedido + " se ha eliminado");
            alert.show();


        }else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("Error: No hay ningun pedido o ya esta enviado");
            alert.show();

        }

    }
}
