package src.main;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE_PREMIUM", schema = "GBMJ_DB", catalog = "")
public class ClientePremiumEntity {
    @Basic
    @Column(name = "descuento")
    private Double descuento;
    @Basic
    @Column(name = "email")
    private String email;

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
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

        ClientePremiumEntity that = (ClientePremiumEntity) o;

        if (descuento != null ? !descuento.equals(that.descuento) : that.descuento != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = descuento != null ? descuento.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
