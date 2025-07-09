/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tareacolecciones;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Deque;

/**
 *
 * @author gatumbac
 */
public class Procesador {
    // Se usa Deque como Pila en lugar de Stack.
    public static int contadorProcesos = 1;
    
    public static void simulacion1(List<Proceso> procesos, Map<Integer, Deque<Proceso>> handler) {
        List<Proceso> procesosTerminados = new ArrayList<>();
        Queue<Proceso> colaProcesos = new PriorityQueue<>((Proceso p1, Proceso p2) -> p2.getPrioridad() - p1.getPrioridad());
        llenarCola(procesos, colaProcesos);       
        
        while (procesosTerminados.size() != procesos.size()) {
            Proceso procesoActual = colaProcesos.poll();
            
            manejar(procesoActual, handler);
            
            if (procesoActual.getCiclos() == 0) {
                procesosTerminados.add(procesoActual);
            } else {
                colaProcesos.offer(procesoActual);
            }
        }
    }
    
    public static void simulacion2(List<Proceso> procesos, Map<Integer, Deque<Proceso>> handler) {
        List<Proceso> procesosTerminados = new ArrayList<>();
        Queue<Proceso> colaProcesos = new PriorityQueue<>((Proceso p1, Proceso p2) -> p2.getPrioridad() - p1.getPrioridad());
        llenarCola(procesos, colaProcesos);
        
        while (procesosTerminados.size() != procesos.size()) {
            List<Proceso> procesosManejados = new ArrayList<>();
            while (!colaProcesos.isEmpty()) {
                Proceso procesoActual = colaProcesos.poll();
                manejar(procesoActual, handler);
                procesosManejados.add(procesoActual);
            }
            
            for (Proceso proceso: procesosManejados) {
                if (proceso.getCiclos() == 0) {
                    procesosTerminados.add(proceso);
                } else {
                    colaProcesos.offer(proceso);
                }
            }
        }
    }
    
    
    private static void llenarCola(List<Proceso> procesos, Queue<Proceso> colaProcesos) {
        for (Proceso p: procesos) {
            colaProcesos.offer(p);
        }
    }
    
    private static void manejar(Proceso procesoActual, Map<Integer, Deque<Proceso>> handler) {
        if (procesoActual.getNombre().startsWith("interrupcion")) {
            manejarInterrupcion(procesoActual, handler);
        } else {
            manejarProceso(procesoActual);
        }
    }
    
    private static void manejarProceso(Proceso procesoActual) {
        int ciclosRestantes = procesoActual.getCiclos() - 1;
        System.out.println("" + contadorProcesos + ". Procesando: " + procesoActual + " - Ciclos Restantes: " + (ciclosRestantes));
        procesoActual.setCiclos(ciclosRestantes);
        contadorProcesos++;
    }
    
    private static void manejarInterrupcion(Proceso interrupcion, Map<Integer, Deque<Proceso>> handler) {
        manejarProceso(interrupcion);
        Deque<Proceso> pilaProcesos = handler.get(interrupcion.getId());
        if (pilaProcesos != null) {
            while (!pilaProcesos.isEmpty()) {
                Proceso procesoActual = pilaProcesos.pop();
                while (procesoActual.getCiclos() > 0) {
                    manejarProceso(procesoActual);
                }
            }
        }
    }
    
}
