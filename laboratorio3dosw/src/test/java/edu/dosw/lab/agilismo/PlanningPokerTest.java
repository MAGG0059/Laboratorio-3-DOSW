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
    void testRegistrarHistorias() {
        String input = "Historia1\nHistoria2\nfin\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PlanningPoker poker = new PlanningPoker();
        poker.registrarHistorias();

        try {
            var field = PlanningPoker.class.getDeclaredField("historias");
            field.setAccessible(true);
            List<Historia> historias = (List<Historia>) field.get(poker);

            assertEquals(2, historias.size());
            assertEquals("Historia1", historias.get(0).getNombre());
            assertEquals("Historia2", historias.get(1).getNombre());
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testRegistrarEquipo() {
        String input = "2\nAna\nLuis\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PlanningPoker poker = new PlanningPoker();
        poker.registrarEquipo();

        try {
            var field = PlanningPoker.class.getDeclaredField("equipo");
            field.setAccessible(true);
            List<String> equipo = (List<String>) field.get(poker);

            assertEquals(2, equipo.size());
            assertTrue(equipo.contains("Ana"));
            assertTrue(equipo.contains("Luis"));
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testIniciarVotacionesConConsensoInmediato() {
        String input = "Historia1\nfin\n1\nPedro\n5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        PlanningPoker poker = new PlanningPoker();
        poker.registrarHistorias();
        poker.registrarEquipo();
        poker.iniciarVotaciones();

        try {
            var field = PlanningPoker.class.getDeclaredField("historias");
            field.setAccessible(true);
            List<Historia> historias = (List<Historia>) field.get(poker);

            assertEquals(5, historias.get(0).getPuntajeFinal());
        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void testMostrarResumen() {
        PlanningPoker poker = new PlanningPoker();
        Historia h1 = new Historia("Login");
        h1.setPuntajeFinal(3);

        try {
            var field = PlanningPoker.class.getDeclaredField("historias");
            field.setAccessible(true);
            List<Historia> historias = (List<Historia>) field.get(poker);
            historias.add(h1);
        } catch (Exception e) {
            fail(e);
        }

        poker.mostrarResumen();
        String output = outContent.toString();

        assertTrue(output.contains("Login : 3"));
    }
}
