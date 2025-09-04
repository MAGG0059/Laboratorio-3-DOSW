package edu.dosw.lab.reto4;

public class Cuenta {
    private String numeroCuenta;
    private double saldo;
    private Usuario usuario;

    public Cuenta(Usuario usuario, double saldo, String numeroCuenta) {
        this.usuario = usuario;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void transferir(double monto) {
        this.saldo -= monto;
    }
}
