/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ultimatarea;

/**
 *
 * @author estudiante
 */
public class UltimaTarea {

    public static void main(String[] args) {
        System.out.println("\nTarea #7 Grafos - Darwin Diaz, Gabriel Tumbaco, Xavier Guzman - P1");

        
        // EJERCICIO #1
        // Creación del grafo
        GraphAL<String, String> grafo1 = new GraphAL<>((a,b) -> a.compareTo(b), false);

        // Vértices
        grafo1.addVertex("Hospital");
        grafo1.addVertex("Parque");
        grafo1.addVertex("Biblioteca");
        grafo1.addVertex("Museo");
        grafo1.addVertex("Banco");
        grafo1.addVertex("Estacion");

        // Aristas (no dirigidas)
        grafo1.addEdge("Ruta1", "Hospital", "Parque", 1);
        grafo1.addEdge("Ruta2", "Parque", "Biblioteca", 1);
        grafo1.addEdge("Ruta3", "Parque", "Museo", 1);
        grafo1.addEdge("Ruta4", "Biblioteca", "Banco", 1);
        grafo1.addEdge("Ruta5", "Museo", "Estacion", 1);
        
        System.out.println("\nEjercicio #1 - Camino mas corto (aristas) entre hospital y estacion: ");
        System.out.println(Auxiliar.caminoMasCorto(grafo1, "Hospital", "Estacion"));
        
        
        // EJERCICIO #2 y #3
        // Creación del grafo
        GraphAL<String, String> grafo2 = new GraphAL<>((a,b) -> a.compareTo(b), true);

        // Vértices
        grafo2.addVertex("A");
        grafo2.addVertex("B");
        grafo2.addVertex("C");
        grafo2.addVertex("D");
        grafo2.addVertex("E");
        grafo2.addVertex("F");

        // Aristas (dirigidas)
        grafo2.addEdge("RutaAB", "A", "B", 1);
        grafo2.addEdge("RutaAD", "A", "D", 1);
        grafo2.addEdge("RutaBC", "B", "C", 1);
        grafo2.addEdge("RutaCE", "C", "E", 1);
        grafo2.addEdge("RutaDE", "D", "E", 1);
        grafo2.addEdge("RutaFC", "F", "C", 1);

        // Arista adicional para crear un ciclo (C -> F)
        grafo2.addEdge("RutaCF", "C", "F", 1);
        
        System.out.println("\nEjercicio #2 - Hay ruta entre A y E: ");
        System.out.println(Auxiliar.hayRuta(grafo2, "A", "E"));
        
        System.out.println("\nEjercicio #3 - Tiene ciclo: ");
        System.out.println(Auxiliar.tieneCiclo(grafo2));
        
        
        // EJERCICIO #3
        // Creación del grafo
        GraphAL<String, String> grafo3 = new GraphAL<>((a,b) -> a.compareTo(b), false);

        // Vértices
        grafo3.addVertex("A");
        grafo3.addVertex("B");
        grafo3.addVertex("C");
        grafo3.addVertex("D");
        grafo3.addVertex("E");
        grafo3.addVertex("Z");

        // Aristas (con peso)
        grafo3.addEdge("RutaAB", "A", "B", 3);
        grafo3.addEdge("RutaAC", "A", "C", 2);
        grafo3.addEdge("RutaBD", "B", "D", 5);
        grafo3.addEdge("RutaCD", "C", "D",6);
        grafo3.addEdge("RutaCE", "C", "E", 8);
        grafo3.addEdge("RutaDZ", "D", "Z", 5);
        grafo3.addEdge("RutaEZ", "E", "Z", 3);
        
        
        System.out.println("\nEjercicio #4 - Minimas distancias desde A: ");
        Auxiliar.distanciaMinima(grafo3, "A");
    }
}
