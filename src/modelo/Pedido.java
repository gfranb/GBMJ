package modelo;

import java.util.Date;

public class Pedido {

    private int nPedido;
    private Cliente cliente;
    private Articulo articulo;
    private int cantidad;
    private Date fecha;

    Pedido(){}

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setnPedido(int nPedido) {
        this.nPedido = nPedido;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getnPedido() {
        return nPedido;
    }

    @Override
    public String toString() {
        return "modelo.Pedido{" +
                "nPedido=" + nPedido +
                ", cliente=" + cliente +
                ", articulo=" + articulo +
                ", cantidad=" + cantidad +
                ", fecha=" + fecha +
                '}';
    }
}
