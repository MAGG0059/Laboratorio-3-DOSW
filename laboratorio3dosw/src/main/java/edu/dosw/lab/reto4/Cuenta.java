package edu.dosw.lab.reto4;

public class Cuenta{

    private int numeroCuenta;
    private double saldo;
    private Usuario usuario;

    public Cuenta(Usuario usuario, double Saldo){

        // mum de cuenta 03
        String numeroCuenta = "03" + String.format("%08d", (int)(Math.random() * 100000000));

        this.saldo = Saldo;
        this.usuario = usuario;
    }//-k

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void transferir(double monto){
        this.saldo -= monto;
    }

    public void recibirTransferencia(double monto){
        this.saldo += monto;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}