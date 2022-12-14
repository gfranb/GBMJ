package dao;

import modelo.Articulo;

import java.util.ArrayList;

public interface DAOArticulo {

    public boolean registrar(Articulo articulo) throws Exception;
    public Articulo buscar(String id) throws Exception;
    public ArrayList<Articulo> mostrar()throws Exception;
}
