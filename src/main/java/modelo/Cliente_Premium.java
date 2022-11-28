package modelo;

public class Cliente_Premium extends Cliente{
        private double descuento;
        public Cliente_Premium(double descuento, String nif, String nombre, String domicilio, String email, char tipo) {
            super(nombre, domicilio, nif, email);
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
