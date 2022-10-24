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
                datos.mostrarArticulos();
            case 2:
               // datos.addArticulo(); Pasar por parametros la info necesaria
            break;
        }
    }

    public void gestionarClientes(){// Jorge

    }

    public void gestionarPedidos(){// Bartomeu

    }
}
