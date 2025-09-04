package edu.dosw.lab.reto4;

public class Bankify {

    public static Cuenta crearCuenta(Usuario user, double saldo) {
        return new Cuenta(user, saldo); // aquí puedes agregar validación con AccountV si hace falta
    }

    public static void hacerTransferencia(Cuenta cuentaOrigen, Cuenta cuentaDestino, double monto) {
        if (cuentaOrigen.getSaldo() >= monto) {
            cuentaOrigen.transferir(monto);
            cuentaDestino.recibirTransferencia(monto);
        } else {
            throw new IllegalArgumentException("Saldo insuficiente en la cuenta de origen");
        }
    }
    
}
