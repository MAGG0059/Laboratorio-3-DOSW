package edu.dosw.lab.agilismo.Reto3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PlanningPoker {
    private List<Historia> historias = new ArrayList<>();
    private List<String> equipo = new ArrayList<>();
    private final int[] fibonacci = {1, 2, 3, 5, 8, 13};
    private Scanner sc = new Scanner(System.in);

    public void registrarHistorias() {
        System.out.println("=== Registro de Historias ===");
        while (true) {
            System.out.print("Ingresa el nombre de la historia (o 'fin' para terminar): ");
            String nombre = sc.nextLine();
            if (nombre.equalsIgnoreCase("fin")) break;
            historias.add(new Historia(nombre));
        }
    }

    public void registrarEquipo() {
        System.out.print("Cantidad de integrantes del equipo: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        for (int i = 0; i < n; i++) {
            System.out.print("Nombre del integrante " + (i + 1) + ": ");
            equipo.add(sc.nextLine());
        }
    }

    public void iniciarVotaciones() {
        for (Historia h : historias) {
            Map<String, Integer> votos = new HashMap<>();
            boolean consenso = false;
            System.out.println("\nHistoria: " + h.getNombre());

            for (String miembro : equipo) {
                votos.put(miembro, pedirVoto(miembro));
            }

            while (!consenso) {
                if (hayConsenso(new ArrayList<>(votos.values()))) {
                    h.setPuntajeFinal(votos.values().iterator().next());
                    consenso = true;
                } else {
                    System.out.println("Votos divergentes – Discutan y solo cambien quienes deseen");
                    System.out.println("Votos actuales: " + votos);

                    
                    for (String miembro : equipo) {
                        System.out.print(miembro + ", ¿quieres cambiar tu voto? (s/n): ");
                        String respuesta = sc.nextLine();
                        if (respuesta.equalsIgnoreCase("s")) {
                            votos.put(miembro, pedirVoto(miembro));
                        }
                    }
                }
            }
        }
    }

    private int pedirVoto(String miembro) {
        int voto = -1;
        while (!esVotoValido(voto)) {
            System.out.print(miembro + ", ingresa tu voto (1,2,3,5,8,13): ");
            String linea = sc.nextLine();
            try {
                voto = Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida, ingresa un número de la secuencia.");
                continue;
            }
            if (!esVotoValido(voto)) {
                System.out.println("Número no permitido, ingresa un voto válido de la secuencia.");
            }
        }
        return voto;
    }


    private boolean esVotoValido(int voto) {
        for (int f : fibonacci) {
            if (voto == f) return true;
        }
        return false;
    }

    private boolean hayConsenso(List<Integer> votos) {
        int primero = votos.get(0);
        for (int v : votos) {
            if (v != primero) return false;
        }
        return true;
    }

    public void mostrarResumen() {
        System.out.println("\n=== Resumen de Historias ===");
        for (Historia h : historias) {
            System.out.println(h.getNombre() + " : " + h.getPuntajeFinal());
        }
    }

    public static void main(String[] args) {
        PlanningPoker poker = new PlanningPoker();
        poker.registrarHistorias();
        poker.registrarEquipo();
        poker.iniciarVotaciones();
        poker.mostrarResumen();
    }
}