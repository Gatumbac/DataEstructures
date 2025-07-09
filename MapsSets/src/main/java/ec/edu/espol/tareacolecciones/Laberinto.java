/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tareacolecciones;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author gatumbac
 */
public class Laberinto {
    public static LinkedList<Casilla> encontrarCamino(int matriz[][], int x, int y) {
        LinkedList<Casilla> camino = new LinkedList<>();
        Set<Casilla> visitados = new HashSet<>();
        Casilla inicio = new Casilla(x, y);
        
        // validación de posición inicial
        if (matriz[x][y] == 1) return camino; 

        if (buscar(matriz, inicio, camino, visitados)) {
            return camino;
        } else {
            return new LinkedList<>(); // no hay camino
        }
    }
    
    private static boolean buscar(int[][] matriz, Casilla actual, LinkedList<Casilla> camino, Set<Casilla> visitados) {
        int x = actual.getX();
        int y = actual.getY();
        
        // Caso base del metodo recursivo
        if (!esValido(matriz, x, y) || visitados.contains(actual) || matriz[x][y] == 1) {
            return false;
        }
        
        camino.add(actual);
        visitados.add(actual);

        if (matriz[x][y] == 2) return true; // salida del laberinto

        // hay 4 direcciones por explorar
        int[][] direcciones = {{0,1}, {0,-1}, {-1,0}, {1,0}}; // derecha, izquierda, arriba, abajo
        for (int[] d : direcciones) {
            int nuevoX = x + d[0];
            int nuevoY = y + d[1];
            Casilla siguiente = new Casilla(nuevoX, nuevoY);

            if (buscar(matriz, siguiente, camino, visitados)) return true;
        }

        // Backtrack - Volver en caso de que no haya encontrado una casilla siguiente válida
        camino.removeLast();
        return false;
    }

    private static boolean esValido(int[][] matriz, int x, int y) {
        return x >= 0 && y >= 0 && x < matriz.length && y < matriz[0].length;
    }
}
