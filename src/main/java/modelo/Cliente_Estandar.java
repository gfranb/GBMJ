package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "cliente_estandard")
@PrimaryKeyJoinColumn(referencedColumnName = "email")
public class Cliente_Estandar extends Cliente{

        private int numCliente;

        public Cliente_Estandar(  String nombre, String domicilio,String nif, String email) {
            super(nombre, domicilio,nif, email);

        }

        public  Cliente_Estandar(){
        }

    @Override
    public String toString() {
       return "Cliente_Estandar{" + super.toString()+'}';
    }
}
