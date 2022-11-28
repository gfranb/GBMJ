package dao;

import modelo.Pedido;

public interface DAOPedido {
    public boolean registrarPedido(Pedido pedido) throws Exception;
    public Pedido buscarpedido(String email) throws Exception;
    public Pedido eliminarpedido (Pedido pedido) throws Exception;
}
