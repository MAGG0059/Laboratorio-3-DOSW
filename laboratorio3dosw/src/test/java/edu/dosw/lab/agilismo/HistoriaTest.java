package edu.dosw.lab.agilismo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.agilismo.Reto3.Historia;

public class HistoriaTest {

        @Test
    void testGetNombre() {
        Historia h = new Historia("Login");
        assertEquals("Login", h.getNombre());
    }

    @Test
    void testGetPuntajeFinal() {
        Historia h = new Historia("Carrito");
        assertEquals(-1, h.getPuntajeFinal(), "Debe iniciar con -1");
    }

    @Test
    void SetPuntaje() {
        Historia h = new Historia("Checkout");
        h.setPuntajeFinal(8);
        assertEquals(8, h.getPuntajeFinal());
    }
}
