package controlador;
import dao.*;
import modelo.Articulo;
import modelo.Cliente_Estandar;
import modelo.Cliente_Premium;
import modelo.Pedido;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ControladorTest {

    @Test
    void anadirArticulo() throws Exception {
        Controlador controlador = new Controlador();
        assertEquals(true, controlador.anadirArticulo("B2","Ejemplo de descripción de producto ",4,3,10));
    }
    @Test
    void crearCliente() throws Exception {
        Controlador controlador = new Controlador();
        assertEquals(true, controlador.crearCliente("78", "jose@gamil.com", "mayor 3 Valencia", "45678934D", '1'));
    }
    @Test
    void dbRegistrarArticulo() throws Exception {
        Articulo a = new Articulo("A","Ejemplo de descripción de producto ",4,3,10);
        DAOArticulo daoArticulo = new ArticuloDAOImpl();
        assertEquals(true,daoArticulo.registrar(a));
    }
    @Test
    void dbBuscarArticulo() throws Exception{
        DAOArticulo daoArticulo = new ArticuloDAOImpl();
        Articulo a = new Articulo();
        assertEquals(a.getClass(),daoArticulo.buscar("A2").getClass());
    }
    @Test
    void mostrarArticulo() throws Exception{
        Controlador controlador = new Controlador();
        String a = "test";
        assertEquals(a.getClass(), controlador.mostrarArticulo("A2").getClass());
    }
    @Test
    void catalogo() throws Exception {
        Controlador controlador = new Controlador();
        String a = "test";
        assertEquals(a.getClass(), controlador.showCatalogo().getClass());
    }
    @Test
    void crearCEbd() throws Exception{
        Cliente_Estandar cE= new Cliente_Estandar(321,"julian", "Los Palos, 167. 08756", "536543D","julian@gmail.com");
        DAOCliente_Estandar daoCE = new Cliente_EstandardDAOImpl();
        assertEquals(true, daoCE.registrar(cE));
    }
    @Test
    void buscarCEbd() throws Exception{
        Cliente_Estandar cE= new Cliente_Estandar();
        String email = "julian@gmail.com";
        DAOCliente_Estandar daoCE = new Cliente_EstandardDAOImpl();
        assertEquals(cE.getClass(), daoCE.buscar(email).getClass());
    }

    @Test
    void crearCPbd() throws Exception{
        Cliente_Premium cP= new Cliente_Premium(0.10,"gianfran","Los Palos, 300. 08756", "131233D","gianfranco@gmail.com");
        DAOCliente_Premium daoCP = new Cliente_PremiumDAOImpl();
        assertEquals(true, daoCP.registrar(cP));
    }
    @Test
    void buscarCPbd() throws Exception{
        Cliente_Premium cP= new Cliente_Premium();
        String email = "gianfranco@gmail.com";
        DAOCliente_Premium daoCP = new Cliente_PremiumDAOImpl();
        assertEquals(cP.getClass(), daoCP.buscar(email).getClass());
    }

    @Test
    void crearpedido() throws Exception{
        Cliente_Estandar cE= new Cliente_Estandar(321,"julian", "Los Palos, 167. 08756", "536543D","julian@gmail.com");
        Articulo a = new Articulo("A","Ejemplo de descripción de producto ",4,3,10);
        Pedido p = new Pedido(cE,a,12,1,18.2);
        DAOPedido daoPedido= new PedidoDAOImpl();
        assertEquals(true, daoPedido.registrar(p));

    }
    
    @Test
    void buscarPedido(){

    }

}