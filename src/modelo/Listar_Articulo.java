package modelo;

import java.util.ArrayList;
import java.util.Map;

public class Listar_Articulo {
    private ArrayList<Articulo> articulos;
    private Map<String, Integer> stockArticulos;

    Listar_Articulo(){
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public Map<String, Integer> getStockArticulos() {
        return stockArticulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public void setStockArticulos(Map<String, Integer> stockArticulos) {
        this.stockArticulos = stockArticulos;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "articulos=" + articulos +
                ", stockArticulos=" + stockArticulos +
                '}';
    }

}
