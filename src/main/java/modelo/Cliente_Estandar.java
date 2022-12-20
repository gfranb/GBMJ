package modelo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_estandard")
@PrimaryKeyJoinColumn(referencedColumnName = "email")
public class Cliente_Estandar extends Cliente{

        private int numCliente;

        public Cliente_Estandar( int nCliente, String nombre, String domicilio,String nif, String email) {
            super(nombre, domicilio,nif, email);
            this.numCliente = nCliente;
        }

        public  Cliente_Estandar(){
        }
        public int getNumCliente() {
            return numCliente;
        }

        public void setNumCliente(int numCliente) {
            this.numCliente = numCliente;
        }

        @Override
        public String toString() {
            return "Cliente_Estandar{" + super.toString() + "numCliente=" + numCliente + '}';
        }
}
