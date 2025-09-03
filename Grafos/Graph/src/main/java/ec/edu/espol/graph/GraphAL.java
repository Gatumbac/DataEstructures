/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author gatumbac
 */
public class GraphAL<V, E> {  
    private LinkedList<Vertex<V, E>> vertexs; 
    private boolean isDirected;
    private Comparator<V> cmp;

    public GraphAL(boolean isDirected, Comparator<V> cmp) {
        this.vertexs = new LinkedList<>();
        this.isDirected = isDirected;
        this.cmp = cmp;
    }

    public LinkedList<Vertex<V, E>> getVertexs() {
        return vertexs;
    }

    public void setVertexs(LinkedList<Vertex<V, E>> vertexs) {
        this.vertexs = vertexs;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setIsDirected(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public Comparator<V> getCmp() {
        return cmp;
    }

    public void setCmp(Comparator<V> cmp) {
        this.cmp = cmp;
    }
    
    public boolean addVertex(V content){
        if (content == null || findVertex(content) != null){
            return false;
        }
        
        Vertex<V, E> newVertex = new Vertex<>(content);
        this.vertexs.add(newVertex);
        return true;
    }

    private Vertex<V, E> findVertex(V content) {
        if (content == null) return null;
        
        for (Vertex<V, E> v : vertexs){
            V current = v.getContent();
            
            if (this.cmp.compare(current, content) == 0){
                return v;
            }
        }
        
        return null;
    }
    
    public boolean connect(V content1, V content2, int weight, E data){
        Vertex<V, E> v1 = findVertex(content1);
        Vertex<V, E> v2 = findVertex(content2);
        
        if (v1 == null || v2 == null){
            return false;
        }
        
        Edge<E, V> newEdge = new Edge<>(v1, v2, weight, data);
        v1.getEdges().add(newEdge);
        
        if (!this.isDirected){
            Edge<E, V> reverseEdge = new Edge<>(v2, v1, weight, data);
            v2.getEdges().add(reverseEdge);
        }
        
        return true;
    }
    
    private void resetVertexs(){
        for(Vertex<V,E> vertex : vertexs){
            vertex.setIsVisited(false);
            vertex.setCumulativeDistance(Integer.MAX_VALUE);
            vertex.setPredecessorVertex(null);
        }
    }
    
    // contar nodos de grado impar
    public int countOddDegreeVertices() {
        if (this.isDirected) {
            return -1; // los grados en grados dirigidos funcionan diferente
        }
        
        int oddCount = 0;
        for (Vertex<V, E> v : this.vertexs) {
            if (v.getDegree() % 2 != 0) {
                oddCount++;
            }
        }
        
        return oddCount;
    }
    
    public boolean isConnected() {
        if (vertexs.isEmpty() || vertexs.size() == 1) {
            return true; // // grafo vacio o con un solo vertice
        }

        resetVertexs();
        
        LinkedList<Vertex<V, E>> queue = new LinkedList<>();
        Vertex<V, E> start = vertexs.getFirst(); // se inicia el recorrido en algun vertice
        queue.offer(start);
        start.setIsVisited(true);
        int visitedCount = 1;

        while (!queue.isEmpty()) { // recorrido BFS
            Vertex<V, E> current = queue.poll();
            for (Edge<E, V> edge : current.getEdges()) {
                Vertex<V, E> adjacent = edge.getTarget();
                if (!adjacent.isIsVisited()) {
                    adjacent.setIsVisited(true);
                    queue.offer(adjacent);
                    visitedCount++;
                }
            }
        }
        
        // es conexo si el recorrido ha visitado todos los vertices
        return visitedCount == this.vertexs.size(); 
    }
    
    public Edge<E, V> findEdge(V content1, V content2) {
        Vertex<V, E> v1 = findVertex(content1);
        if (v1 == null || content2 == null) return null;

        for (Edge<E, V> edge : v1.getEdges()) {
            if (this.cmp.compare(edge.getTarget().getContent(), content2) == 0) {
                return edge;
            }
        }
        
        return null;
    }
    
    public void runBFS() {
        if (this.vertexs.isEmpty()) return;
        this.resetVertexs();
        Vertex<V, E> initial = this.vertexs.getFirst();
        
        Queue<Vertex<V,E>> c = new LinkedList<>();
        initial.setIsVisited(true);
        c.offer(initial);
        
        while (!c.isEmpty()) {
            Vertex<V, E> current = c.poll();
            System.out.println(current.getContent());
            
            for (Edge<E, V> edge: current.getEdges()) {
                Vertex<V, E> target = edge.getTarget();
                
                if (!target.isIsVisited()) {
                    target.setIsVisited(true);
                    c.offer(target);
                }
            }
        }
    }
    
    public void runDFS() {
        if (this.vertexs.isEmpty()) return;
        this.resetVertexs();
        Vertex<V, E> initial = this.vertexs.getFirst();
        
        Stack<Vertex<V,E>> s = new Stack<>();
        initial.setIsVisited(true);
        s.push(initial);
        
        while (!s.isEmpty()) {
            Vertex<V, E> current = s.pop();
            System.out.println(current.getContent());
            
            for (Edge<E, V> edge: current.getEdges()) {
                Vertex<V, E> target = edge.getTarget();
                
                if (!target.isIsVisited()) {
                    target.setIsVisited(true);
                    s.push(target);
                }
            }
        }
    }
    
    public void runDijkstra(V content) {
        if (this.vertexs.isEmpty()) return;
        this.resetVertexs();
        Vertex<V, E> initial = this.findVertex(content);
        if (initial == null) return;

        initial.setCumulativeDistance(0);

        PriorityQueue<Vertex<V, E>> queue = new PriorityQueue<>(
            (v1, v2) -> Integer.compare(v1.getCumulativeDistance(), v2.getCumulativeDistance())
        );

        queue.offer(initial);

        while (!queue.isEmpty()) {
            Vertex<V, E> current = queue.poll();

            if (current.isIsVisited()) continue; // ya procesado
            current.setIsVisited(true);

            for (Edge<E, V> edge : current.getEdges()) {
                Vertex<V, E> target = edge.getTarget();
                if (!target.isIsVisited()) {
                    int newDist = current.getCumulativeDistance() + edge.getWeight();
                    if (newDist < target.getCumulativeDistance()) {
                        target.setCumulativeDistance(newDist);
                        target.setPredecessorVertex(current); // opcional, para reconstruir camino
                        queue.offer(target); // actualizar posición en la cola
                    }
                }
            }
        }
    }

}
