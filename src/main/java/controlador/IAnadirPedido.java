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

public class IAnadirPedido {
    private Controlador controlador;

    @FXML
    public Button btnVolver;
    @FXML
    public Button btnAnadir;
    @FXML
    public TextField inEmail, inCodArt, inCant;
    @FXML
    public Button btnCatalogo;

    @FXML
    private void volverEscena() throws Exception{

        URL url = new File("./src/main/java/vista/IGestionPedidos.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnVolver.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }
    private void irCatalog() throws Exception{

        URL url = new File("./src/main/java/vista/ICatalogo.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnCatalogo.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }


    @FXML
    private void anadirPedido() throws Exception{

        controlador = new Controlador();

        String email = inEmail.getText();
        String codArticulo = inCodArt.getText();
        int cantidad = Integer.parseInt(inCant.getText());

        Alert alert = new Alert(Alert.AlertType.NONE);
        if(controlador.crearPedido(email,codArticulo,cantidad) != 0){

            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("El Pedido ha sido generado correctamente");
            alert.show();

        }else{

            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("Error: No se ha generado el pedido");
            alert.show();

        }
    }
}
