package modelo;

public class Cliente_Premium extends Cliente{

    private double descuento;
    Cliente_Premium(String nombre, String domicilio,String nif, String email, double descuento){
        super(nombre,domicilio,nif,email);
        this.descuento = descuento;
    }
    Cliente_Premium(){
        super();
    }
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    public double getDescuento() {
        return descuento;
    }
}
