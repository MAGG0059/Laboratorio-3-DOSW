package edu.dosw.lab.testing.reto4;

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

    public void depositar(String numeroCuenta, double monto) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && monto > 0) {
            cuenta.depositar(monto);
        }
    }

    public double consultarSaldo(String numeroCuenta) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        return (cuenta != null) ? cuenta.getSaldo() : -1;
    }

    public Cuenta buscarCuentaPorUsuario(String idUsuario) {
        return cuentas.values().stream()
                .filter(c -> c.getUsuario().getNumID().equals(idUsuario))
                .findFirst()
                .orElse(null);
    }

}
