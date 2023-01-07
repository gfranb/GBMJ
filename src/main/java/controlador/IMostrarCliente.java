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

public class IMostrarCliente {

    private Controlador controlador;

    @FXML
    public Button btnVolver;
    @FXML
    public Button btnMostrarCliente;
    @FXML
    public TextField inE;

    @FXML
    public Label outN, outE, outD, outNif, outT;

    @FXML
    private void volverEscena() throws Exception{

        URL url = new File("./src/main/java/vista/IGestionClientes.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnVolver.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }

    @FXML
    private void mostrarCliente() throws Exception{

        controlador = new Controlador();

        String email = inE.getText();
        Alert alert = new Alert(Alert.AlertType.NONE);

        String datos = controlador.mostrarCliente(email);
        if(datos == null){

            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("El email " + email + " no es correcto. No se encontro ningun cliente.");
            alert.show();

        }else{
            outN.setText(String.valueOf(datos.equals(0)));
            outE.setText(String.valueOf(datos.equals(2)));
            outD.setText(String.valueOf(datos.equals(1)));
            outNif.setText(String.valueOf(datos.equals(3)));
            outT.setText(String.valueOf(datos.equals(4)));
        }

    }
}
