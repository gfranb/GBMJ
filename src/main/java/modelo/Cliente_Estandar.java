package modelo;

public class Cliente_Estandar extends Cliente{
        private int numCliente;

        public Cliente_Estandar(int numCliente, String nif, String nombre, String domicilio, String email) {
            super(nif, nombre, domicilio, email);
            this.numCliente = numCliente;

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
