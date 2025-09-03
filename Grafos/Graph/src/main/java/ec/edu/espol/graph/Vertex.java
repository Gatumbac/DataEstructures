/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.graph;

import java.util.LinkedList;

/**
 *
 * @author gatumbac
 */
public class Vertex<V, E> {  
    private V content; 
    private LinkedList<Edge<E, V>> edges; 
    
    private boolean isVisited;
    private int cumulativeDistance;
    private Vertex<V,E> predecessorVertex;

    public Vertex(V content) {
        this.content = content;
        this.edges = new LinkedList<>(); 
    }

    public V getContent() {
        return content;
    }

    public void setContent(V content) {
        this.content = content;
    }

    public LinkedList<Edge<E, V>> getEdges() {
        return edges;
    }

    public void setEdges(LinkedList<Edge<E, V>> edges) {
        this.edges = edges;
    }
    
    public int getDegree() {
        return edges.size();
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public int getCumulativeDistance() {
        return cumulativeDistance;
    }

    public void setCumulativeDistance(int cumulativeDistance) {
        this.cumulativeDistance = cumulativeDistance;
    }

    public Vertex<V, E> getPredecessorVertex() {
        return predecessorVertex;
    }

    public void setPredecessorVertex(Vertex<V, E> predecessorVertex) {
        this.predecessorVertex = predecessorVertex;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Vertex<V,E> v = (Vertex<V,E>) o;
        return this.content.equals(v.getContent());
    }
   
}
