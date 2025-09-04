package edu.dosw.lab;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.reto4.AccountManager;
import edu.dosw.lab.reto4.AccountV;
import edu.dosw.lab.reto4.Cuenta;
import edu.dosw.lab.reto4.Usuario;

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
        Usuario usuario = new Usuario("123456", "Juan Pérez");
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
        Usuario usuario = new Usuario("123456", "Juan Pérez");
        Cuenta cuenta = accountManager.crearCuenta(usuario, 0.0);

        boolean resultado = accountV.validarCuenta(cuenta.getNumeroCuenta());
        assertTrue(resultado, "La cuenta con saldo cero debería ser válida");
    }

    @Test
    void testValidarCuentaConSaldoNegativo() {
        Usuario usuario = new Usuario("123456", "Juan Pérez");
        Cuenta cuenta = accountManager.crearCuenta(usuario, -100.0);

        boolean resultado = accountV.validarCuenta(cuenta.getNumeroCuenta());
        assertFalse(resultado, "La cuenta con saldo negativo no debería ser válida");
    }
}
