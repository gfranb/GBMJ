package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class IMostrarArticulo {

    private Controlador controlador;

    @FXML
    public Button btnVolver;
    @FXML
    public Button btnMostrar;
    @FXML
    public TextField inCodigo;

    @FXML
    public Label outDescripcion, outPrecio, outGastos, outTiempo;

    @FXML
    private void volverEscena() throws Exception{

        URL url = new File("./src/main/java/vista/IGestionArticulos.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnVolver.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }

    @FXML
    private void mostrarArticulo() throws Exception{

        controlador = new Controlador();

        String codigo = inCodigo.getText();
        Alert alert = new Alert(Alert.AlertType.NONE);

        ArrayList<String> datos = controlador.mostrarArticulo(codigo);
        if(datos == null){

            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("El codigo " + codigo + " no es correcto. No se encontro ningun articulo.");
            alert.show();

        }else{
            outDescripcion.setText(datos.get(0));
            outGastos.setText(datos.get(2));
            outPrecio.setText(datos.get(1));
            outTiempo.setText(datos.get(3));
        }

    }
}
