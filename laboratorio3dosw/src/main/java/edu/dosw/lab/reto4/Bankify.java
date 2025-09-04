package edu.dosw.lab.reto4;

public class Bankify{
    public static Cuenta crearCuenta(Usuario usuario, double saldo){
        return new Cuenta(usuario,saldo); // falta validación con clase accountV -k
    }

    public void hacerTransferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto){
            cuentaOrigen.transferir(monto);
    }
}