package dao;

import modelo.Cliente_Premium;

public interface DAOCliente_Premium {

        public boolean registrar(Cliente_Premium cliente_premium) throws Exception;
        public Cliente_Premium buscar(String email) throws Exception;

}
