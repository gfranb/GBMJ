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

public class IAnadirArticulo {

    private Controlador controlador;

    @FXML
    public Button btnVolver;
    @FXML
    public Button btnAnadir;
    @FXML
    public TextField inCodigo, inDescripcion, inPrecio, inGEnvio, inPEnvio;

    @FXML
    private void volverEscena() throws Exception{

        URL url = new File("./src/main/java/vista/IGestionArticulos.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnVolver.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }

    @FXML
    private void anadirArticulo() throws Exception{

        controlador = new Controlador();

        String codigo = inCodigo.getText();
        String descripcion = inDescripcion.getText();
        float  precio = Float.parseFloat(inPrecio.getText());
        float gEnvio = Float.parseFloat(inGEnvio.getText());
        int pEnvio = Integer.parseInt(inPEnvio.getText());

        Alert alert = new Alert(Alert.AlertType.NONE);
        if(controlador.anadirArticulo(codigo,descripcion, precio, gEnvio,pEnvio)){

            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("Articulo " + codigo + " ha sido creado correctamente");
            alert.show();

        }else{

            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("Articulo " + codigo + " ya existe");
            alert.show();

        }
    }
}
