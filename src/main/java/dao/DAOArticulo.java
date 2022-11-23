package dao;

import modelo.Articulo;

import java.util.List;

public interface DAOArticulo {

    public boolean registrar(Articulo articulo) throws Exception;
    public void mostrar(Articulo articulo) throws Exception;

}
