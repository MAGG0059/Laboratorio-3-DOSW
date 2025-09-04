package edu.dosw.lab.reto4;

public class AccountManager {

    public AccountManager() {
    }

    public Cuenta crearCuenta(Usuario user, double saldoInicial) {
        return Bankify.crearCuenta(user, saldoInicial);
    }
}
