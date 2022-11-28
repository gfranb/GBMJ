package controlador;
import dao.ArticuloDAOImpl;
import dao.Cliente_EstandardDAOImpl;
import dao.DAOArticulo;
import dao.DAOCliente_Estandar;
import modelo.Articulo;
import modelo.Cliente_Estandar;
import org.junit.jupiter.api.Test;
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
        System.out.println(daoCE.buscar(email));
        assertEquals(cE.getClass(), daoCE.buscar(email).getClass());
    }
}