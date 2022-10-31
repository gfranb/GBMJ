package controlador;

import java.util.List;
import modelo.Datos;
import vista.*;
public class Controlador {
    private Datos datos;
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
    public boolean crearCliente(String n, String e, String d, String nif, char t){
        return datos.addCliente(n,d,nif,e,t);
    }
    public String mostrarCliente(String email){
        return datos.showCliente(email);
    }
    public String showCatalogo(){
        return datos.catalogo();
    }
    public int crearPedido(String email, String idArticulo, int cantidadArticulo){
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
    public String cargar(){

            // Clientes
            datos.addCliente("jose", "Alcázabar, 35. 07560", "2354761R","jose@gmail.com",'1');
            datos.addCliente("julian", "Los Palos, 167. 08756", "536543D","julian@gmail.com",'2');
            datos.addCliente("maria", "Real Camino, 35. 07987", "987654T","maria@gmail.com",'1');
            datos.addCliente("rosana", "B.Lull. 09870", "126509Y","rosana@gmail.com",'2');
            // Artículos del Catálogo.
            datos.addArticulo("A234","Ejemplo de descripción de producto ",4,3,10);
            datos.addArticulo("A674","Ejemplo de descripción de producto ",60,10,5);
            datos.addArticulo("B987","Ejemplo de descripción de producto ",7,15,1);
            datos.addArticulo("C204","Ejemplo de descripción de producto ",55,10,9);
            // Pedido
            datos.crearPedido("jose@gmail.com","A234",2);
            datos.crearPedido("maria@gmail.com","B987",1);

        return "\n" + "|| ---------|| Carga de datos realizada ||---------------|| " +
                "\n";
    }
}
