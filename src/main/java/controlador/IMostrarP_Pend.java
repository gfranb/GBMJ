package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class IMostrarP_Pend {
    private Controlador controlador;

    @FXML
    public Button btnVolver;
    @FXML
    public Button btnMostrar;

    @FXML
    public Label outSalida;

    @FXML
    private void volverEscena() throws Exception{

        URL url = new File("./src/main/java/vista/IMostrarPedidos.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnVolver.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }

    @FXML
    private void mostrarPedidos() throws Exception{

        controlador = new Controlador();
        Alert alert = new Alert(Alert.AlertType.NONE);
        String datos = controlador.mostrarPedidosPendientes();

        if(datos.equals("")){

            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("Error: No hay ningun pedido pendiente");
            alert.show();

        }else{
            outSalida.setText(datos);
        }

    }
}
