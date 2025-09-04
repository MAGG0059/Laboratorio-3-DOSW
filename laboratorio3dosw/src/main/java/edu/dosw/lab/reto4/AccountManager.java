package edu.dosw.lab.reto4;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {

    private Map<String, Cuenta> cuentas = new HashMap<>();

    public Cuenta crearCuenta(Usuario user, double saldoInicial) {
        String numeroCuenta = generarNumeroCuenta();
        Cuenta cuenta = new Cuenta(user, saldoInicial, numeroCuenta);
        cuentas.put(numeroCuenta, cuenta);
        return cuenta;
    }

    public Cuenta obtenerCuenta(String numeroCuenta) {
        return cuentas.get(numeroCuenta);
    }

    private String generarNumeroCuenta() {
        long numero = (long) (Math.random() * 1_000_000_0000L);
        return String.format("%010d", numero);
    }
}
