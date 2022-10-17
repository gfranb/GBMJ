package modelo;

public class Articulo {

    private String codigo;
    private String descripcion;
    private float precio;
    private float gEnvio;
    private int pEnvio;

    Articulo(){

    }

    @Override
    public String toString() {
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
