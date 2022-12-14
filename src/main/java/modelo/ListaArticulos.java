package modelo;

import java.util.ArrayList;

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
