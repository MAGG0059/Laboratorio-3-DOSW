package edu.dosw.lab.testing.reto4;

public class Bankify {

    private static AccountManager accountManager = new AccountManager();
    private static AccountV accountValidator = new AccountV(accountManager);

    public static Cuenta crearCuenta(Usuario usuario, double saldo) {
        return accountManager.crearCuenta(usuario, saldo);
    }

    public static boolean validarCuenta(String numeroCuenta) {
        return accountValidator.validarCuenta(numeroCuenta);
    }

    public static Cuenta obtenerCuenta(String numeroCuenta) {
        return accountManager.obtenerCuenta(numeroCuenta);
    }
}
