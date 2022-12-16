package src.main;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE", schema = "GBMJ_DB", catalog = "")
public class ClienteEntity {
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "nif")
    private String nif;
    @Basic
    @Column(name = "domilicio")
    private String domilicio;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "email")
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDomilicio() {
        return domilicio;
    }

    public void setDomilicio(String domilicio) {
        this.domilicio = domilicio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteEntity that = (ClienteEntity) o;

        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (nif != null ? !nif.equals(that.nif) : that.nif != null) return false;
        if (domilicio != null ? !domilicio.equals(that.domilicio) : that.domilicio != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (nif != null ? nif.hashCode() : 0);
        result = 31 * result + (domilicio != null ? domilicio.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
