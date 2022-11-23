package controlador;
import dao.ArticuloDAOImpl;
import dao.DAOArticulo;
import modelo.Articulo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ControladorTest {

    @Test
    void anadirArticulo() {
        Controlador controlador = new Controlador();
        assertEquals(true, controlador.anadirArticulo("122", "Mesa", (float) 10.22, 6, 20));
    }

    @Test
    void crearCliente() {
        Controlador controlador = new Controlador();
        assertEquals(true, controlador.crearCliente("78", "jose@gamil.com", "mayor 3 Valencia", "45678934D", '1'));
    }
    @Test
    void dbRegistrarArticulo() throws Exception {
        Articulo a = new Articulo("A","Ejemplo de descripción de producto ",4,3,10);
        DAOArticulo daoArticulo = new ArticuloDAOImpl();
        assertEquals(true,daoArticulo.registrar(a));
    }
}