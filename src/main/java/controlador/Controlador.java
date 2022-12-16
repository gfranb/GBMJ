package controlador;

import modelo.Datos;
public class Controlador {
    private final Datos datos;
    public Controlador() {
        datos = new Datos ();
    }
    public boolean anadirArticulo(String codigo, String descripcion, float precio, float gEnvio, int pEnvio){
         return datos.addArticulo(codigo,descripcion,precio,gEnvio,pEnvio);
    }
    public String mostrarArticulo(String codigo){
        try{
            return datos.mostrarArticulos(codigo);
        }catch(Exception e){
            return "El articulo no existe";
        }
    }
    public boolean crearCliente(String n, String e, String d, String nif, char t) throws Exception {
        return datos.addCliente(n,d,nif,e,t);
    }
    public String mostrarCliente(String email){
        return datos.showCliente(email);
    }
    public String showCatalogo() throws Exception {
        return datos.catalogo();
    }
    public int crearPedido(String email, String idArticulo, int cantidadArticulo) throws Exception {
        return datos.crearPedido(email,idArticulo,cantidadArticulo);
    }
    public boolean eliminarPedido(int n){
        return datos.eliminarPedido(n);
    }
    public String mostrarPedidosEnviados(){
        return datos.buscarPE();
    }
    public String mostrarPedidosEnviados(String email){
        return datos.buscarPECliente(email);
    }
    public String mostrarPedidosPendientes(String email){
        return datos.buscarPPCliente(email);
    }
    public String mostrarPedidosPendientes(){
        return datos.buscarPP();
    }
}
