package edu.dosw.lab.agilismo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.agilismo.Reto3.Historia;

public class HistoriaTest {

    @Test
    void testCrearHistoria() {
        Historia h = new Historia("Login de usuario");
        assertEquals("Login de usuario", h.getNombre());
        assertEquals(-1, h.getPuntajeFinal(), "El puntaje inicial debe ser -1");
    }

    @Test
    void testSetPuntajeFinal() {
        Historia h = new Historia("Carrito de compras");
        h.setPuntajeFinal(8);
        assertEquals(8, h.getPuntajeFinal());
    }
}
