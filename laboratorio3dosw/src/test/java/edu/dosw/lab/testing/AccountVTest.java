package edu.dosw.lab.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.testing.reto4.AccountManager;
import edu.dosw.lab.testing.reto4.AccountV;
import edu.dosw.lab.testing.reto4.Cuenta;
import edu.dosw.lab.testing.reto4.Usuario;

public class AccountVTest {

    private AccountV accountV;
    private AccountManager accountManager;

    @BeforeEach
    void setUp() {
        accountManager = new AccountManager();
        accountV = new AccountV(accountManager);
    }

    @Test
    void testValidarCuentaValida() {
        Usuario usuario = new Usuario("Juan Pérez", "123456");
        Cuenta cuenta = accountManager.crearCuenta(usuario, 1000.0);

        boolean resultado = accountV.validarCuenta(cuenta.getNumeroCuenta());
        assertTrue(resultado, "La cuenta válida debería pasar la validación");
    }

    @Test
    void testValidarCuentaInvalida() {
        boolean resultado = accountV.validarCuenta("99999");
        assertFalse(resultado, "La cuenta inválida no debería pasar la validación");
    }

    @Test
    void testValidarCuentaConSaldoCero() {
        Usuario usuario = new Usuario("Juan Pérez", "123456");
        Cuenta cuenta = accountManager.crearCuenta(usuario, 0.0);

        boolean resultado = accountV.validarCuenta(cuenta.getNumeroCuenta());
        assertTrue(resultado, "La cuenta con saldo cero debería ser válida");
    }

    @Test
    void testValidarCuentaConSaldoNegativo() {
        Usuario usuario = new Usuario("Juan Pérez", "123456");
        Cuenta cuenta = accountManager.crearCuenta(usuario, -100.0);

        boolean resultado = accountV.validarCuenta(cuenta.getNumeroCuenta());
        assertFalse(resultado, "La cuenta con saldo negativo no debería ser válida");
    }


    @Test
    void testDepositoEnCuenta() {
        Usuario usuario = new Usuario("Ana López", "7890");
        Cuenta cuenta = accountManager.crearCuenta(usuario, 500.0);

        cuenta.depositar(200.0);
        assertEquals(700.0, cuenta.getSaldo(), "El saldo debería incrementarse después de un depósito");
    }

    @Test
    void testDepositoEnAccountManager() {
        Usuario usuario = new Usuario("Carlos Ruiz", "5555");
        Cuenta cuenta = accountManager.crearCuenta(usuario, 300.0);

        accountManager.depositar(cuenta.getNumeroCuenta(), 150.0);
        assertEquals(450.0, cuenta.getSaldo(), "El saldo debería incrementarse al depositar vía AccountManager");
    }

    @Test
    void testConsultarSaldo() {
        Usuario usuario = new Usuario("Laura Gómez", "3333");
        Cuenta cuenta = accountManager.crearCuenta(usuario, 1000.0);

        double saldo = accountManager.consultarSaldo(cuenta.getNumeroCuenta());
        assertEquals(1000.0, saldo, "La consulta de saldo debería devolver el monto correcto");
    }

    @Test
    void testBuscarCuentaPorUsuario() {
        Usuario usuario = new Usuario("Pedro Torres", "9999");
        Cuenta cuenta = accountManager.crearCuenta(usuario, 200.0);

        Cuenta encontrada = accountManager.buscarCuentaPorUsuario("9999");
        assertNotNull(encontrada, "La cuenta debería encontrarse por el ID del usuario");
        assertEquals(cuenta.getNumeroCuenta(), encontrada.getNumeroCuenta(), "El número de cuenta debería coincidir");
    }

    @Test
    void testValidarCuentaCuentaNula() {
        // Rama: cuenta == null → return false
        boolean resultado = accountV.validarCuenta("9999999999"); // Cuenta que no existe
        assertFalse(resultado);
    }

    @Test
    void testValidarCuentaLongitudInvalida() {
        Usuario usuario = new Usuario("Test User", "12345");
        Cuenta cuenta = accountManager.crearCuenta(usuario, 1000.0);

        String numeroCorto = cuenta.getNumeroCuenta().substring(0, 5);
        boolean resultado = accountV.validarCuenta(numeroCorto);
        assertFalse(resultado);
    }

    @Test
    void testValidarCuentaSaldoNegativo() {

        Usuario usuario = new Usuario("Test User", "12345");
        Cuenta cuenta = accountManager.crearCuenta(usuario, -100.0); // Saldo negativo

        boolean resultado = accountV.validarCuenta(cuenta.getNumeroCuenta());
        assertFalse(resultado);
    }

    @Test
    void testValidarCuentaTodasCondicionesValidas() {
        Usuario usuario = new Usuario("Test User", "12345");
        Cuenta cuenta = accountManager.crearCuenta(usuario, 1000.0);

        boolean resultado = accountV.validarCuenta(cuenta.getNumeroCuenta());
        assertTrue(resultado);
    }


}
