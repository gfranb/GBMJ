package dao;

import dao.modelo.ListaPedidos;
import dao.modelo.Pedido;

public interface DAOPedido {
    public boolean registrar(Pedido pedido) throws Exception;
    public Pedido buscar(int nPedido) throws Exception;
    public boolean eliminarpedido(String nPedido) throws Exception;
    public ListaPedidos buscarpedidocliente(String email) throws Exception;
    public ListaPedidos buscarpedidos() throws Exception;
}
