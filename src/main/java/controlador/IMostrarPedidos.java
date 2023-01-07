package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class IMostrarPedidos {
    @FXML
    public Button btnEnviado;
    @FXML
    public Button btnPendiente;
    @FXML
    public Button btnEnviado_C;
    @FXML
    public Button btnPendiente_C;
    @FXML
    public Button btnVolver;
    @FXML
    private void mostrarEnviado() throws Exception{

        URL url = new File("./src/main/java/vista/IMostrarP_Env.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnEnviado.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }
    @FXML
    private void mostrarPendiente() throws Exception{

        URL url = new File("./src/main/java/vista/IMostrarP_Pend.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnPendiente.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }
    @FXML
    private void mostrarEnviado_C() throws Exception{

        URL url = new File("./src/main/java/vista/IMostrarP_Cli_Env.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnEnviado_C.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }
    @FXML
    private void mostrarPendiente_C() throws Exception{

        URL url = new File("./src/main/java/vista/IMostrarP_Cli_Pend.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnPendiente_C.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }

    @FXML
    private void volverEscena() throws Exception{

        URL url = new File("./src/main/java/vista/IGestionPedidos.fxml").toURI().toURL();
        Parent root  = FXMLLoader.load(url);

        Stage window = (Stage) btnVolver.getScene().getWindow();
        window.setScene(new Scene(root,700,500));

    }
}
