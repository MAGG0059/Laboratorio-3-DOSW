package edu.dosw.lab.reto4;

public class AccountV {

    private AccountManager accountManager;

    public AccountV(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    public boolean validarCuenta(String numeroCuenta) {
        Cuenta cuenta = accountManager.obtenerCuenta(numeroCuenta);

        if (cuenta == null) {
            return false;
        }

        boolean longitudValida = numeroCuenta.length() == 10;
        boolean saldoValido = cuenta.getSaldo() >= 0;

        return longitudValida && saldoValido;
    }
}
