/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.tareacolecciones;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author gatumbac
 */
public class TareaColecciones {

    public static void main(String[] args) {
        System.out.println("\nTAREA COLECCIONES Y MAPAS - TUMBACO SANTANA GABRIEL P1\n");
        System.out.println("\nEjercicio 1 - Simulacion de Procesos\n");
        
        List<Proceso> procesos = new ArrayList<>();
        procesos.add(new Proceso(101, "chrome.exe", 5, 10));
        procesos.add(new Proceso(302, "interrupcion1.exe", 1, 10));
        procesos.add(new Proceso(403, "firefox.exe", 3, 8));
        procesos.add(new Proceso(503, "interrupcion2.exe", 1, 6));
        
        Map<Integer, Deque<Proceso>> handler = new HashMap<>();

        // Interrupción 302
        Deque<Proceso> interrupcion1Stack = new ArrayDeque<>();
        interrupcion1Stack.push(new Proceso(602, "procesoA.exe", 2, -1));
        interrupcion1Stack.push(new Proceso(601, "procesoB.exe", 3, -1));
        handler.put(302, interrupcion1Stack);

        // Interrupción 503
        Deque<Proceso> interrupcion2Stack = new ArrayDeque<>();
        interrupcion2Stack.push(new Proceso(604, "procesoC.exe", 1, -1));
        interrupcion2Stack.push(new Proceso(603, "procesoD.exe", 4, -1));
        handler.put(503, interrupcion2Stack);
        
        /*
        NOTA:
        Se incluyen dos implementaciones de simulación ('simulacion1' y 'simulacion2')
        debido a la ambigüedad en las reglas del enunciado sobre la planificación por prioridad.
        Cada una representa una interpretación lógica diferente, resultando en salidas distintas.
        
        - 'simulacion1' (comentada) muestra ejecución contigua del más prioritario.
        - 'simulacion2' (actualmente activa) muestra alternancia de procesos prioritarios.
        
        Para probar 'simulacion1', por favor, descomente su llamada 
        y comente la llamada a 'simulacion2'.
        */
        
        Procesador.simulacion2(procesos, handler);
        //Procesador.simulacion1(procesos, handler);
        
        // TEMA #2
        
        System.out.println("\nEjercicio 2 - Laberinto\n");
        
        int[][] matriz = {
            {1, 1, 1, 1, 1, 1, 2, 1},
            {1, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1}
        };
        
        // Mostrar formato del laberinto en la consola
        System.out.println("\nLaberinto:\n");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
        
        Casilla casillaInicio = new Casilla(1, 1);
        LinkedList<Casilla> camino = Laberinto.encontrarCamino(matriz, casillaInicio.getX(), casillaInicio.getY());
        
        System.out.println("\nCasilla inicio: " + casillaInicio);
        System.out.println("\nCamino encontrado:\n");
        
        for (Casilla c : camino) {
            System.out.println(c);
        }

    }
    
}
