package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ICrearCliente implements Initializable {

    private Controlador controlador;

    @FXML
    public Button btnCrearCliente;
    @FXML
    public Button btnVolver;
    @FXML
    public TextField inN, inE, inD, inNif;

    @FXML
    public ChoiceBox<String> tipoCliente;

    private String[] tipos = {"Premium","Estandard"};


    @FXML
    private void crearCliente() throws Exception{

        controlador = new Controlador();

        String nombre = inN.getText();
        String email = inE.getText();
        String direccion = inD.getText();
        String nif = inNif.getText();
        char t;
        if(tipoCliente.getValue().equals("Premium")){
            t= '1';
        }else{
            t = '2';
        }


        Alert alert = new Alert(Alert.AlertType.NONE);
        if(controlador.crearCliente( nombre,  nif, email, direccion, t)){

            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("Cliente " + email + " ha sido creado correctamente");
            alert.show();

        }else{

            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setTitle("Estado de la solicitud");
            alert.setContentText("Cliente " + email + " ya existe");
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tipoCliente.getItems().addAll(tipos);
    }
}
