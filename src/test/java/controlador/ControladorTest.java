package controlador;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}