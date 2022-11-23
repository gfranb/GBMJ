package dao;

import modelo.Articulo;

import java.util.List;

public interface DAOArticulo {

    public boolean registrar(Articulo articulo) throws Exception;
    public Articulo buscar(String id) throws Exception;

}
