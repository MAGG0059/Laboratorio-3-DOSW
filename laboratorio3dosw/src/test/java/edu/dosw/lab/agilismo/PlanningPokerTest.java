package edu.dosw.lab.agilismo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.agilismo.Reto3.Historia;
import edu.dosw.lab.agilismo.Reto3.PlanningPoker;

class PlanningPokerTest {

    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void testRegistrarHistorias() {
        String input = "Historia1\nHistoria2\nfin\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PlanningPoker poker = new PlanningPoker();
        poker.registrarHistorias();

        
        assertEquals("=== Registro de Historias ===\n", outContent.toString().split("\r?\n")[0] + "\n");
    }

    @Test
    void testRegistrarEquipo() {
        String input = "2\nAna\nLuis\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PlanningPoker poker = new PlanningPoker();
        poker.registrarEquipo();

        
        assertTrue(outContent.toString().contains("Cantidad de integrantes del equipo:"));
    }

    @Test
    void testEsVotoValido() throws Exception {
        PlanningPoker poker = new PlanningPoker();
        var method = PlanningPoker.class.getDeclaredMethod("esVotoValido", int.class);
        method.setAccessible(true);

        assertTrue((boolean) method.invoke(poker, 3));
        assertFalse((boolean) method.invoke(poker, 7));
    }

    @Test
    void testHayConsenso() throws Exception {
        PlanningPoker poker = new PlanningPoker();
        var method = PlanningPoker.class.getDeclaredMethod("hayConsenso", List.class);
        method.setAccessible(true);

        assertTrue((boolean) method.invoke(poker, List.of(5, 5, 5)));
        assertFalse((boolean) method.invoke(poker, List.of(3, 5, 8)));
    }

    @Test
    void testMostrarResumen() {
        PlanningPoker poker = new PlanningPoker();
        Historia h1 = new Historia("Login");
        h1.setPuntajeFinal(5);
        Historia h2 = new Historia("Checkout");
        h2.setPuntajeFinal(8);

        
        try {
            var field = PlanningPoker.class.getDeclaredField("historias");
            field.setAccessible(true);
            List<Historia> historias = (List<Historia>) field.get(poker);
            historias.add(h1);
            historias.add(h2);
        } catch (Exception e) {
            fail(e);
        }

        poker.mostrarResumen();
        String output = outContent.toString();
        assertTrue(output.contains("Login : 5"));
        assertTrue(output.contains("Checkout : 8"));
    }
}
