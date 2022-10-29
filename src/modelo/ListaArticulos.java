package modelo;

import java.util.ArrayList;
import java.util.Map;

public class ListaArticulos extends Lista<Articulo>{

    ListaArticulos(){
        super();
    }

    public ArrayList<Articulo> getArticulos() {
        return lista;
    }

}
