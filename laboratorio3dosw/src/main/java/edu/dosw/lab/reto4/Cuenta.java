package edu.dosw.lab.reto4;

public class Cuenta{

    private int numeroCuenta;
    private double saldo;
    private Usuario usuario;

    public Cuenta(String numID, String nombre, double Saldo){
        this.numeroCuenta = 0 ; //como sacamos el numero de cuenta?
        this.saldo = Saldo;
        this.usuario = new Usuario(numID, nombre); // como evitar q intente hacer un usuario nuevo cada vez?

    }//-k

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

   //faltaría un get relacionado a usuario ?? -k
}