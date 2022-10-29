package test;

import controlador.Controlador;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ControladorTest {

    @Test
    void anadirArticulo() {
        Controlador controlador = new Controlador();
        assertEquals(true,controlador.anadirArticulo("122","Mesa", (float) 10.22,6,20));
    }

    @Test
    void crearCliente() {

    }

    @Test
    void crearPedido() {
    }

    @Test
    void eliminarPedido() {
    }
}