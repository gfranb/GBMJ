package dao.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pedido {

    private int nPedido;
    private Cliente cliente;
    private Articulo articulo;
    private int cantidad;
    private LocalDate fecha;

    private double precioP;

    public Pedido(){}
    public Pedido(Cliente C, Articulo A, int nPedido, int cantidad, double p){

        this.articulo = A;
        this.nPedido = nPedido;
        this.cantidad = cantidad;
        this.cliente = C;
        this.precioP = p;

        LocalDate date= LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String text = date.format(formatters);
        this.fecha = LocalDate.parse(text, formatters);
    }
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setFecha(LocalDate fecha) {
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

    public LocalDate getFecha() {
        return fecha;
    }
    public int getCantidad() {
        return cantidad;
    }
    public int getnPedido() {
        return nPedido;
    }
    public double getPrecioP() {
        return precioP;
    }
    public void setPrecioP(double precioP) {
        this.precioP = precioP;
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
