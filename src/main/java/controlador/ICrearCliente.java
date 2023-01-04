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
public class ICrearCliente {

    private Controlador controlador;

    @FXML
    public Button btnCrearCliente;
    @FXML
    public Button btnVolver;
    @FXML
    public TextField inN, inE, inD, inNif, inT;


    @FXML
    private void crearCliente() throws Exception{

        controlador = new Controlador();

        String n = inN.getText();
        String e = inE.getText();
        String d = inD.getText();
        String nif = inNif.getText();
        char t = inT.getCharacters().charAt(15); ;

        Alert alert = new Alert(Alert.AlertType.NONE);
        if(controlador.crearCliente( n,  e, d, nif, t)){

            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("Cliente " + e + " ha sido creado correctamente");
            alert.show();

        }else{

            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("Cliente " + e + " ya existe");
            alert.show();

        }
    }

    @FXML
    private void volverEscena() throws Exception{

        URL url = new File("./src/main/java/vista/IGestionClientes.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnVolver.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }
}
