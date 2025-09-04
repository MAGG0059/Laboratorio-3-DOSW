package edu.dosw.lab.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.testing.reto4.Bankify;
import edu.dosw.lab.testing.reto4.Cuenta;
import edu.dosw.lab.testing.reto4.Usuario;

public class BankifyTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCrearCuenta() {
        Usuario usuario = new Usuario("Test User", "12345");
        Cuenta cuenta = Bankify.crearCuenta(usuario, 1000.0);

        assertNotNull(cuenta);
        assertEquals("12345", cuenta.getUsuario().getNumID());
        assertEquals(1000.0, cuenta.getSaldo());
        assertEquals(10, cuenta.getNumeroCuenta().length());
    }

    @Test
    void testValidarCuentaValida() {
        Usuario usuario = new Usuario("Test User", "12345");
        Cuenta cuenta = Bankify.crearCuenta(usuario, 500.0);

        boolean resultado = Bankify.validarCuenta(cuenta.getNumeroCuenta());
        assertTrue(resultado);
    }

    @Test
    void testValidarCuentaInvalida() {
        boolean resultado = Bankify.validarCuenta("123");
        assertFalse(resultado);
    }

    @Test
    void testObtenerCuentaExistente() {
        Usuario usuario = new Usuario("Test User", "12345");
        Cuenta cuentaCreada = Bankify.crearCuenta(usuario, 1000.0);

        Cuenta cuentaObtenida = Bankify.obtenerCuenta(cuentaCreada.getNumeroCuenta());
        assertNotNull(cuentaObtenida);
        assertEquals(cuentaCreada.getNumeroCuenta(), cuentaObtenida.getNumeroCuenta());
    }

    @Test
    void testObtenerCuentaNoExistente() {
        Cuenta cuenta = Bankify.obtenerCuenta("9999999999");
        assertNull(cuenta);
    }
}