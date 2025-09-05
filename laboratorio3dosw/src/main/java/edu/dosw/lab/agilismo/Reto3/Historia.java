package edu.dosw.lab.agilismo.Reto3;

public class Historia {
    private String nombre;
    private int puntajeFinal = -1;

    public Historia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntajeFinal() {
        return puntajeFinal;
    }

    public void setPuntajeFinal(int puntaje) {
        this.puntajeFinal = puntaje;
    }
}