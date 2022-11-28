package modelo;

import java.util.ArrayList;
import java.util.Map;

public class ListaArticulos extends Lista<Articulo>{

    ListaArticulos(){
        super();
    }

    ListaArticulos(ArrayList<Articulo> articulos){
        super(articulos);
    }

    public ArrayList<Articulo> getArticulos() {
        return lista;
    }
}
