package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Pedido {

    private int nPedido;
    private Cliente cliente;
    private Articulo articulo;
    private int cantidad;
    private LocalDate fecha;

    Pedido(Cliente C, Articulo A, int nPedido, int cantidad){

        this.articulo = A;
        this.nPedido = nPedido;
        this.cantidad = cantidad;
        this.cliente = C;

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
