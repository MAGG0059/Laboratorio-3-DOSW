package edu.dosw.lab.reto4;

public class Bankify{
    public Cuenta crearCuenta(String numID,String nombre, double saldo){
        return new Cuenta(numID,nombre,saldo); // falta validación con clase accountV -k
    }

    public void hacerTransferencia(Cuenta cuenta){
            // error de diseño ???
    }
}