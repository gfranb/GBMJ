package dao.modelo;

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
