package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "articulo")
@Table(name = "articulo")
public class Articulo{

    @Id
    @Column(name = "codigo", unique = true)
    private String codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private float precio;
    @Column(name = "gEnvio")
    private float gEnvio;
    @Column(name = "pEnvio")
    private int pEnvio; //Tiempo de preparacion de envio.

    public Articulo(String c, String d, float p, float gE, int pE){
        this.codigo = c;
        this.descripcion = d;
        this.precio = p;
        this.gEnvio = gE;
        this.pEnvio = pE;
    }
    public Articulo(){

    }
    @Column(name = "descripcion")
    public String toString(){
        return "modelo.Articulo{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", gEnvio=" + gEnvio +
                ", pEnvio=" + pEnvio +
                '}';
    }
    public float getgEnvio() {
        return gEnvio;
    }

    public float getPrecio() {
        return precio;
    }

    public int getpEnvio() {
        return pEnvio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setgEnvio(float gEnvio) {
        this.gEnvio = gEnvio;
    }

    public void setpEnvio(int pEnvio) {
        this.pEnvio = pEnvio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}