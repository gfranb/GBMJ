package modelo;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table (name = "cliente")
public abstract class Cliente {

    @Column(name = "nombre")
    protected String nombre;
    @Column(name = "domicilio")
    protected String domicilio;
    @Column(name = "nif", unique = true)
    protected String nif;
    @Id
    @Column(name = "email", unique = true)
    protected String email;

    public Cliente(String nombre,String domicilio,String nif, String email){
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.email = email;
    }
    public Cliente(){}

    public String getDomicilio() {
        return domicilio;
    }

    public String getEmail() {
        return email;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "modelo.Cliente{" +
                "nombre='" + nombre + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", nif='" + nif + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
