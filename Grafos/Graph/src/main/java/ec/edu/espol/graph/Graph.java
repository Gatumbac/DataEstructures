/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.graph;

/**
 *
 * @author gatumbac
 */
import java.util.Comparator;
import java.util.List;

public class Graph {

    public static void main(String[] args) {
        System.out.println("\nLab08 Grafos - Gabriel Tumbaco - P1");
        
        probar();
        
    }

    public static void probarRecorridoEuleriano() {

        GraphAL<String, Integer> grafoEuler1 = new GraphAL<>(false, (a,b) -> a.compareTo(b));
        grafoEuler1.addVertex("A");
        grafoEuler1.addVertex("B");
        grafoEuler1.addVertex("C");
        grafoEuler1.addVertex("D");
        grafoEuler1.addVertex("E");
        grafoEuler1.connect("A", "B", 1, null);
        grafoEuler1.connect("B", "C", 1, null);
        grafoEuler1.connect("B", "D", 1, null);
        grafoEuler1.connect("B", "E", 1, null);
        grafoEuler1.connect("D", "E", 1, null);

        GraphAL<String, Integer> grafoEuler2 = new GraphAL<>(false, (a,b) -> a.compareTo(b));
        grafoEuler2.addVertex("A");
        grafoEuler2.addVertex("B");
        grafoEuler2.addVertex("C");
        grafoEuler2.addVertex("D");
        grafoEuler2.addVertex("E");
        grafoEuler2.connect("A", "B", 1, null);
        grafoEuler2.connect("B", "C", 1, null);
        grafoEuler2.connect("B", "D", 1, null);
        grafoEuler2.connect("B", "E", 1, null);

        boolean resultado1 = Lab08.existeRecorridoEuleriano(grafoEuler1);
        System.out.println("Resultado para el Grafo 1 (debería ser true): " + resultado1);

        boolean resultado2 = Lab08.existeRecorridoEuleriano(grafoEuler2);
        System.out.println("Resultado para el Grafo 2 (debería ser false): " + resultado2);
    }
    
    public static void probar() {

        GraphAL<String, Integer> grafoEuler1 = new GraphAL<>(false, (a,b) -> a.compareTo(b));
        grafoEuler1.addVertex("A");
        grafoEuler1.addVertex("B");
        grafoEuler1.addVertex("C");
        grafoEuler1.addVertex("D");
        grafoEuler1.addVertex("E");
        grafoEuler1.connect("A", "B", 1, null);
        grafoEuler1.connect("B", "C", 1, null);
        grafoEuler1.connect("B", "D", 1, null);
        grafoEuler1.connect("B", "E", 1, null);
        grafoEuler1.connect("D", "E", 1, null);
        
        grafoEuler1.runBFS();

        GraphAL<String, Integer> grafoEuler2 = new GraphAL<>(false, (a,b) -> a.compareTo(b));
        grafoEuler2.addVertex("A");
        grafoEuler2.addVertex("B");
        grafoEuler2.addVertex("C");
        grafoEuler2.addVertex("D");
        grafoEuler2.addVertex("E");
        grafoEuler2.connect("A", "B", 1, null);
        grafoEuler2.connect("B", "C", 1, null);
        grafoEuler2.connect("B", "D", 1, null);
        grafoEuler2.connect("B", "E", 1, null);

    }

    public static void probarUnirGrafos() {
        // Grafo G1
        GraphAL<String, Integer> g1 = new GraphAL<>(false, (a,b) -> a.compareTo(b));
        g1.addVertex("A");
        g1.addVertex("B");
        g1.addVertex("C");
        g1.addVertex("D");
        g1.addVertex("E");
        g1.connect("A", "C", 3, null);
        g1.connect("C", "D", 6, null);
        g1.connect("B", "D", 4, null);
        g1.connect("D", "E", 8, null);

        // Grafo G2
        GraphAL<String, Integer> g2 = new GraphAL<>(false, (a,b) -> a.compareTo(b));
        g2.addVertex("A");
        g2.addVertex("B");
        g2.addVertex("C");
        g2.addVertex("D");
        g2.connect("A", "B", 3, null);
        g2.connect("A", "C", 1, null);
        g2.connect("B", "D", 8, null);
        g2.connect("C", "D", 2, null);
        
        GraphAL<String, Integer> grafoResultante = Lab08.unirGrafos(g1, g2);

        System.out.println("Se unieron los grafos G1 y G2.");

        int numVertices = grafoResultante.getVertexs().size();
        int pesoAC = grafoResultante.findEdge("A", "C").getWeight();
        int pesoCD = grafoResultante.findEdge("C", "D").getWeight();
        
        System.out.println("El grafo resultante tiene " + numVertices + " vértices. (Esperado: 5)");
        System.out.println("El peso de la arista A-C es " + pesoAC + ". (Esperado: 1, el menor)");
        System.out.println("El peso de la arista C-D es " + pesoCD + ". (Esperado: 2, el menor)");
    }


    public static void probarPaginasDeInicio() {

        GraphAL<Integer, String> grafoWeb = new GraphAL<>(true, (a,b) -> a.compareTo(b));
        for (int i = 1; i <= 7; i++) {
            grafoWeb.addVertex(i);
        }
        grafoWeb.connect(1, 2, 1, null);
        grafoWeb.connect(1, 3, 1, null);
        grafoWeb.connect(3, 4, 1, null);
        grafoWeb.connect(5, 6, 1, null);
        grafoWeb.connect(5, 7, 1, null);
        grafoWeb.connect(6, 7, 1, null);

        List<Integer> paginas = Lab08.encontrarPaginasDeInicio(grafoWeb);
        
        System.out.println("Páginas de inicio encontradas: " + paginas);
    }
}