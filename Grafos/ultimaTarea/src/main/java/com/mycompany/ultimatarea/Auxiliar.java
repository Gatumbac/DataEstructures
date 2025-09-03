/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ultimatarea;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author estudiante
 */

public class Auxiliar {
    
    // Grafo no dirigido
    public static <V, E> int caminoMasCorto(GraphAL<V, E> graph, V sourceVertex, V targetVertex) {
        if (graph == null || sourceVertex == null || targetVertex == null) {
            return -1;
        }
        
        Vertex<V, E> source = graph.findVertex(sourceVertex);
        Vertex<V, E> target = graph.findVertex(targetVertex);
        if (source == null || target == null) return -1;
        
        graph.resetVertexs();
        Queue<Vertex<V, E>> vertexQueue = new LinkedList<>();
        source.setIsVisited(true);
        vertexQueue.offer(source);
        
        while (!vertexQueue.isEmpty()) {
            Vertex<V,E> current = vertexQueue.poll();
            for (Edge<V, E> edge : current.getEdges()) {
                Vertex<V, E> adjacent = edge.getTargetVertex();
                if(!adjacent.getIsVisited()){
                    adjacent.setIsVisited(true);
                    adjacent.setPredecessorVertex(current);
                    vertexQueue.offer(adjacent);
                }
            }
        }
        
        List<Vertex<V,E>> path = new LinkedList<>();
        Vertex<V, E> traveler = target;
        
        while (traveler != null) {
            path.addFirst(traveler);
            traveler = traveler.getPredecessorVertex();
        }
        
        if(!path.isEmpty() && path.getFirst().equals(source)){
            return path.size() - 1;
        }
        
        return -1; //en caso de que no existe camino
    }
    
    // Grafo dirigido
    
    public static <V,E> boolean hayRuta(GraphAL<V, E> graph, V sourceVertex, V targetVertex) {
        if (graph == null || sourceVertex == null || targetVertex == null) {
            return false;
        }
        
        Vertex<V, E> source = graph.findVertex(sourceVertex);
        Vertex<V, E> target = graph.findVertex(targetVertex);
        if (source == null || target == null) return false;

        graph.resetVertexs();
        Stack<Vertex<V, E>> vertexStack = new Stack<>();
        source.setIsVisited(true);
        vertexStack.push(source);
        
        while (!vertexStack.isEmpty()) {
            Vertex<V, E> current = vertexStack.pop();
            for (Edge<V, E> edge : current.getEdges()) {
                Vertex<V, E> adjacent = edge.getTargetVertex();
                if(!adjacent.getIsVisited()){
                    adjacent.setIsVisited(true);
                    adjacent.setPredecessorVertex(current);
                    vertexStack.push(adjacent);
                }
            }
        }
        
        List<Vertex<V,E>> path = new LinkedList<>();
        Vertex<V,E> traveler = target;
        
        while(traveler != null){
            path.addFirst(traveler);
            traveler = traveler.getPredecessorVertex();
        }
        
        return path.getFirst().equals(source);
    }
    
    public static <V,E> boolean tieneCiclo(GraphAL<V,E> graph) {
        if (graph == null) {
            return false;
        }
        
        for(Vertex<V,E> vertex : graph.getVertexs()){
            graph.resetVertexs();
            Queue<Vertex<V, E>> vertexQueue = new LinkedList<>();
            vertex.setIsVisited(true);
            vertexQueue.offer(vertex);
            while (!vertexQueue.isEmpty()) {
                Vertex<V,E> current = vertexQueue.poll();
                for (Edge<V, E> edge : current.getEdges()) {
                    Vertex<V, E> adjacent = edge.getTargetVertex();
                    if (adjacent.equals(vertex)){
                        return true;
                    } else if (!adjacent.getIsVisited()){
                        adjacent.setIsVisited(true);
                        adjacent.setPredecessorVertex(current);
                        vertexQueue.offer(adjacent);
                    }
                }
            }
        }
        return false;
    }
    
    // Grafo no dirigido
    public static <V,E> void distanciaMinima(GraphAL<V,E> graph, V sourceVertex) {
        if (graph == null) {
            System.out.println("Grafo nulo");
            return;
        }
        
        Vertex<V,E> source = graph.findVertex(sourceVertex);
        if (source == null) {
            System.out.println("No existe tal vertice en el grafo");
            return;
        }
        
        for(Vertex<V,E> vertex : graph.getVertexs()){
            List<Vertex<V,E>> path = graph.runDijkstra(source.getContent(), vertex.getContent());
            if (path.isEmpty()) {
                System.out.println(source.getContent() + " -> " + vertex.getContent() + " = Sin camino");
            } else {
                System.out.println(source.getContent() + " -> " + vertex.getContent() + " = " + path.getLast().getCumulativeDistance());
            } 
        }
    }
    
}
