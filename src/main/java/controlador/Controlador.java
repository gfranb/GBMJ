package controlador;

import modelo.Datos;

import java.util.ArrayList;

public class Controlador {
    private final Datos datos;
    public Controlador() {
        datos = new Datos ();
    }
    public boolean anadirArticulo(String codigo, String descripcion, float precio, float gEnvio, int pEnvio) throws Exception{
         return datos.addArticulo(codigo,descripcion,precio,gEnvio,pEnvio);
    }
    public ArrayList<String> mostrarArticulo(String codigo){
        try{
            return datos.mostrarArticulos(codigo);
        }catch(Exception e){
            return null;
        }
    }
    public boolean crearCliente(String nombre, String nif, String email, String direccion, char t) throws Exception {
        return datos.addCliente(nombre,nif,email,direccion,t);
    }
    public ArrayList<String> mostrarCliente(String email){
        return datos.showCliente(email);
    }
    public String showCatalogo() throws Exception {
        return datos.catalogo();
    }
    public int crearPedido(String email, String idArticulo, int cantidadArticulo) throws Exception {
        return datos.crearPedido(email,idArticulo,cantidadArticulo);
    }
    public boolean eliminarPedido(int n) throws Exception {
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
