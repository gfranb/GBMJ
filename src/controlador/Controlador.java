package controlador;

import java.util.List;
import modelo.Datos;
public class Controlador {
    private Datos datos;
    public Controlador() {
        datos = new Datos ();
    }

    public void gestionarArticulos(char op){ // Michael
        switch (op){
            case 1:
                Datos.mostrarArtiuclos();
            case 2:

            break;
        }
    }

    public void gestionarClientes(){// Jorge

    }

    public void gestionarPedidos(){// Bartomeu

    }
}
