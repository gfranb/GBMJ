package modelo;

public class Cliente_Premium extends Cliente{
        private float descuento;

        public Cliente_Premium(float descuento, String nif, String nombre, String domicilio, String email ) {
            super(nif, nombre, domicilio, email);
            this.descuento = descuento;
        }

        public float getDescuento() {
            return descuento;
        }

        public void setDescuento(float descuento) {
            this.descuento = descuento;
        }

        @Override
        public String toString() {
            return "Cliente_Premium(" + super.toString() + "descuento=" + descuento + '}';
}
