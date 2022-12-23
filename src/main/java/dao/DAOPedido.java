package dao;

import modelo.ListaPedidos;
import modelo.Pedido;

public interface DAOPedido {
    public boolean registrar(Pedido pedido) throws Exception;
    public Pedido buscar(int nPedido) throws Exception;
    public boolean eliminarpedido(Pedido p) throws Exception;
    public ListaPedidos buscarpedidocliente(String email) throws Exception;
    public ListaPedidos buscarpedidos() throws Exception;
}
