/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gatumbac
 */
public class Lab08 {
    public static <V,E> boolean existeRecorridoEuleriano(GraphAL<V,E> graph) {
        if (graph == null) return false;
        int oddDegrees = graph.countOddDegreeVertices();
        return graph.isConnected() && (oddDegrees == 0 || oddDegrees == 2);
    }
    
    public static <V, E> GraphAL<V, E> unirGrafos(GraphAL<V, E> g1, GraphAL<V, E> g2) {
        if (g1 == null || g2 == null || g1.isDirected() || g2.isDirected()) return null;
        GraphAL<V, E> newGraph = new GraphAL<>(false, g1.getCmp());
        
        addVertexs(newGraph, g1, g2);
        addBaseEdges(newGraph, g1);
        mergeEdges(newGraph, g2); // si es necesario fusionar
        
        return newGraph;
    }
    
    private static <V, E> void addVertexs(GraphAL<V, E> destination, GraphAL<V, E> source1, GraphAL<V, E> source2) {
        for (Vertex<V, E> v : source1.getVertexs()) {
            destination.addVertex(v.getContent());
        }
        for (Vertex<V, E> v : source2.getVertexs()) {
            destination.addVertex(v.getContent());
        }
    }

    
    private static <V, E> void addBaseEdges(GraphAL<V, E> destination, GraphAL<V, E> source) {
        for (Vertex<V, E> v : source.getVertexs()) {
            for (Edge<E, V> edge : v.getEdges()) {
                if (source.getCmp().compare(edge.getSource().getContent(), edge.getTarget().getContent()) < 0) {
                    destination.connect(edge.getSource().getContent(), edge.getTarget().getContent(), edge.getWeight(), edge.getData());
                }
            }
        }
    }

    
    private static <V, E> void mergeEdges(GraphAL<V, E> destination, GraphAL<V, E> source) {
        for (Vertex<V, E> v : source.getVertexs()) {
            for (Edge<E, V> sourceEdge : v.getEdges()) {
                V sourceContent = sourceEdge.getSource().getContent();
                V targetContent = sourceEdge.getTarget().getContent();

                Edge<E, V> destinationEdge = destination.findEdge(sourceContent, targetContent);

                if (destinationEdge == null) {
                    if (source.getCmp().compare(sourceContent, targetContent) < 0) {
                        destination.connect(sourceContent, targetContent, sourceEdge.getWeight(), sourceEdge.getData());
                    }
                } else {
                    if (sourceEdge.getWeight() < destinationEdge.getWeight()) {
                        updateEdge(destination, sourceContent, targetContent, sourceEdge);
                    }
                }
            }
        }
    }

    
    private static <V, E> void updateEdge(GraphAL<V, E> graph, V v1, V v2, Edge<E, V> newEdge) {
        Edge<E, V> directEdge = graph.findEdge(v1, v2);
        Edge<E, V> inverseEdge = graph.findEdge(v2, v1);

        if (directEdge != null) {
            directEdge.setWeight(newEdge.getWeight());
            directEdge.setData(newEdge.getData());
        }
        if (inverseEdge != null) {
            inverseEdge.setWeight(newEdge.getWeight());
            inverseEdge.setData(newEdge.getData());
        }
    }

    
    public static <V, E> List<V> encontrarPaginasDeInicio(GraphAL<V, E> graph) {
        if (graph == null || !graph.isDirected() || graph.getVertexs().isEmpty()) {
            // el metodo es para grafos dirigidos
            return new ArrayList<>();
        }

        // mapa para guardar grados de entrada
        // en la clase vertex no se guardan los grados de entrada, solo los de salida
        Map<V, Integer> inDegrees = new HashMap<>();
        for (Vertex<V, E> v : graph.getVertexs()) {
            inDegrees.put(v.getContent(), 0);
        }

        for (Vertex<V, E> v : graph.getVertexs()) {
            for (Edge<E, V> edge : v.getEdges()) {
                V targetContent = edge.getTarget().getContent();
                inDegrees.put(targetContent, inDegrees.get(targetContent) + 1);
            }
        }

        // todos los vertices con grado de entrada 0
        List<V> startPages = new ArrayList<>();
        for (Map.Entry<V, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                startPages.add(entry.getKey());
            }
        }

        return startPages;
    }
}
