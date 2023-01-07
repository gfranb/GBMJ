package controlador;

import dao.*;
import modelo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControladorTest {

    @Test
    void anadirArticulo() throws Exception {
        Controlador controlador = new Controlador();
        assertTrue(controlador.anadirArticulo("B2","Ejemplo de descripción de producto ",4,3,10));
    }
    @Test
    void crearCliente() throws Exception {
        Controlador controlador = new Controlador();
        assertTrue(controlador.crearCliente("78", "jose@gamil.com", "mayor 3 Valencia", "45678934D", '1'));
    }
    @Test
    void dbRegistrarArticulo() throws Exception {
        Articulo a = new Articulo("W","Ejemplo de descripción de producto ",4,3,10);
        DAOArticulo daoArticulo = new ArticuloDAOImpl();
        assertTrue(daoArticulo.registrar(a));
    }
    @Test
    void dbBuscarArticulo() throws Exception{
        DAOArticulo daoArticulo = new ArticuloDAOImpl();
        Articulo a = new Articulo();
        assertEquals("A",daoArticulo.buscar("A").getCodigo());
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
        Cliente_Estandar cE= new Cliente_Estandar(123,"gian", "Los Palos, 167. 08756", "536543D","gian@gmail.com");
        DAOCliente_Estandar daoCE = new Cliente_EstandardDAOImpl();
        assertTrue(daoCE.registrar(cE));
    }
    @Test
    void buscarCEbd() throws Exception{
        Cliente_Estandar cE= new Cliente_Estandar();
        String email = "julian@gmail.com";
        DAOCliente_Estandar daoCE = new Cliente_EstandardDAOImpl();
        assertEquals(email, daoCE.buscar(email).getEmail());

    }
    @Test
    void crearCPbd() throws Exception {
        Cliente_Premium cP= new Cliente_Premium(0.10,"barto","Los Palos, 300. 08756", "131233D","barto@gmail.com");
        DAOCliente_Premium daoCP = new Cliente_PremiumDAOImpl();
        assertTrue(daoCP.registrar(cP));
    }
    @Test
    void buscarCPbd() throws Exception{
        String email = "barto@gmail.com";
        DAOCliente_Premium daoCP = new Cliente_PremiumDAOImpl();
        assertEquals("barto@gmail.com", daoCP.buscar(email).getEmail());
    }

    @Test
    void crearpedido() throws Exception{
        Cliente_Estandar cE= new Cliente_Estandar(321,"julian", "Los Palos, 167. 08756", "536543D","julian@gmail.com");
        Articulo a = new Articulo("A","Ejemplo de descripción de producto ",4,3,10);
        Pedido p = new Pedido(cE,a,12,1,18.2);
        DAOPedido daoPedido= new PedidoDAOImpl();
        assertTrue(daoPedido.registrar(p));
    }

    @Test
    void buscarPedido() throws Exception {
        Pedido p = new Pedido();
        DAOPedido daoPedido= new PedidoDAOImpl();
        assertEquals(12, daoPedido.buscar(12).getnPedido());
    }
    @Test
    void buscarpedidocliente() throws Exception {
        String c = "julian@gmail.com";
        DAOPedido daoPedido= new PedidoDAOImpl();
        for(Pedido p : daoPedido.buscarpedidocliente(c).getArrayList()){
            assertEquals(c,p.getCliente());
        }
    }
}