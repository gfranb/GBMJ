package dao;

import modelo.Articulo;
import modelo.Cliente;

public interface DAOCliente {


    public boolean registrar(Cliente cliente) throws Exception;

    Cliente buscar(String id) throws Exception;


}
