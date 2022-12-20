package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_premium")
@PrimaryKeyJoinColumn(referencedColumnName = "email")
public class Cliente_Premium extends Cliente{
        private double descuento;

    public Cliente_Premium(double descuento, String nombre, String domicilio,String nif, String email) {
            super(nombre, domicilio, nif, email);
            this.descuento = descuento;
    }


    public Cliente_Premium(double descuento) {
        this.descuento = descuento;
    }

    public Cliente_Premium(){}

        public double getDescuento() {
            return descuento;
        }

        public void setDescuento(double descuento) {
            this.descuento = descuento;
        }

        @Override
        public String toString() {
            return "Cliente_Premium(" + super.toString() + "descuento=" + descuento + ')';
        }
}
