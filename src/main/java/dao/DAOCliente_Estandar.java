package dao;

import modelo.Cliente_Estandar;

public interface DAOCliente_Estandar {

        public boolean registrar(Cliente_Estandar cliente_estandar) throws Exception;
        public Cliente_Estandar buscar(String email) throws Exception;

    }
