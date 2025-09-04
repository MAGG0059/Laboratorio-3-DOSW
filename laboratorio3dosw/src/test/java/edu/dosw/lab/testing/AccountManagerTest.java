package edu.dosw.lab.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.testing.reto4.AccountManager;
import edu.dosw.lab.testing.reto4.Cuenta;
import edu.dosw.lab.testing.reto4.Usuario;

public class AccountManagerTest {

    private AccountManager accountManager;

    @BeforeEach
    void setUp() {
        accountManager = new AccountManager();
    }

    @Test
    void testDepositarMontoNegativo() {
        Usuario usuario = new Usuario("Test User", "12345");
        Cuenta cuenta = accountManager.crearCuenta(usuario, 1000.0);
        double saldoInicial = cuenta.getSaldo();

        accountManager.depositar(cuenta.getNumeroCuenta(), -500.0);

        assertEquals(saldoInicial, cuenta.getSaldo(), "El saldo no debería cambiar con depósito negativo");
    }

    @Test
    void testDepositarEnCuentaInexistente() {

        accountManager.depositar("9999999999", 1000.0);
    }

    @Test
    void testConsultarSaldoCuentaInexistente() {
        double saldo = accountManager.consultarSaldo("9999999999");
        assertEquals(-1, saldo, "Debería retornar -1 para cuenta inexistente");
    }

    @Test
    void testBuscarCuentaPorUsuarioInexistente() {
        Cuenta cuenta = accountManager.buscarCuentaPorUsuario("999999");
        assertNull(cuenta, "Debería retornar null para usuario inexistente");
    }

    @Test
    void testGenerarNumeroCuentaUnico() {
        String cuenta1 = accountManager.crearCuenta(new Usuario("U1", "1"), 100.0).getNumeroCuenta();
        String cuenta2 = accountManager.crearCuenta(new Usuario("U2", "2"), 200.0).getNumeroCuenta();

        assertNotEquals(cuenta1, cuenta2, "Los números de cuenta deberían ser diferentes");
        assertEquals(10, cuenta1.length(), "El número de cuenta debería tener 10 dígitos");
        assertEquals(10, cuenta2.length(), "El número de cuenta debería tener 10 dígitos");
    }
}