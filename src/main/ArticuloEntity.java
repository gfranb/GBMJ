package src.main;

import javax.persistence.*;

@Entity
@Table(name = "ARTICULO", schema = "GBMJ_DB", catalog = "")
public class ArticuloEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codigo")
    private String codigo;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "precio")
    private Double precio;
    @Basic
    @Column(name = "gEnvio")
    private Double gEnvio;
    @Basic
    @Column(name = "pEnvio")
    private Integer pEnvio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getgEnvio() {
        return gEnvio;
    }

    public void setgEnvio(Double gEnvio) {
        this.gEnvio = gEnvio;
    }

    public Integer getpEnvio() {
        return pEnvio;
    }

    public void setpEnvio(Integer pEnvio) {
        this.pEnvio = pEnvio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticuloEntity that = (ArticuloEntity) o;

        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (precio != null ? !precio.equals(that.precio) : that.precio != null) return false;
        if (gEnvio != null ? !gEnvio.equals(that.gEnvio) : that.gEnvio != null) return false;
        if (pEnvio != null ? !pEnvio.equals(that.pEnvio) : that.pEnvio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (gEnvio != null ? gEnvio.hashCode() : 0);
        result = 31 * result + (pEnvio != null ? pEnvio.hashCode() : 0);
        return result;
    }
}
