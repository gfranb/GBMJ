package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "pedido")
@Table(name = "pedido")
public class Pedido extends ListaPedidos {
    @Id
    @Column(name = "nPedido", unique = true)
    private int nPedido;
    @Column(name = "email")
    private String email;
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "precio")
    private double precioP;

    public Pedido(){}
    public Pedido(Cliente C, Articulo A, int nPedido, int cantidad, double p){

        this.codigo = A.getCodigo();
        this.nPedido = nPedido;
        this.cantidad = cantidad;
        this.email = C.getEmail();
        this.precioP = p;

        LocalDate date= LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String text = date.format(formatters);
        this.fecha = LocalDate.parse(text, formatters);
    }
    public void setArticulo(Articulo articulo) {
        this.codigo = articulo.getCodigo();
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setCliente(Cliente cliente) {
        this.email = cliente.getEmail();
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setnPedido(int nPedido) {
        this.nPedido = nPedido;
    }
    public String getArticulo() {
        return codigo;
    }
    public String getCliente() {
        return email;
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
        return "Pedido{" +
                "nPedido=" + nPedido +
                ", email='" + email + '\'' +
                ", codigo='" + codigo + '\'' +
                ", cantidad=" + cantidad +
                ", fecha=" + fecha +
                ", precioP=" + precioP +
                '}';
    }
}