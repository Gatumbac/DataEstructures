/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ultimatarea;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author estudiante
 * @param <V>
 * @param <E>
 */
public class GraphAL<V,E> {
    
    // Atributos:

    private List<Vertex<V,E>> vertexs;
    private Comparator<V> cmp;
    private boolean isDirected;

    // Métodos:

    public GraphAL(Comparator<V> cmp, boolean isDirected) {
        this.cmp = cmp;
        this.isDirected = isDirected;
        this.vertexs = new LinkedList<>();
    }
    
    public List<Vertex<V, E>> getVertexs() {
        return vertexs;
    }

    public void setVertexs(List<Vertex<V, E>> vertexs) {
        this.vertexs = vertexs;
    }
    
    public Comparator<V> getCmp() {
        return this.cmp;
    }
    
    public void setCmp(Comparator<V> cmp) {
        this.cmp = cmp;
    }

    public boolean getIsDirected() {
        return isDirected;
    }

    public void setIsDirected(boolean isDirected) {
        this.isDirected = isDirected;
    }

    public Vertex<V,E> findVertex(V content){
        if(content == null){
            return null;
        }
        for(Vertex<V,E> vertex : vertexs){
            if(cmp.compare(vertex.getContent(), content) == 0){
                return vertex;
            }
        }
        return null;
    }
    
    public void resetVertexs(){
        for(Vertex<V,E> vertex : vertexs){
            vertex.setIsVisited(false);
            vertex.setCumulativeDistance(Integer.MAX_VALUE);
            vertex.setPredecessorVertex(null);
        }
    }

    public boolean addVertex(V content){
        if(content == null || this.findVertex(content) != null){
            return false;
        }
        this.vertexs.add(new Vertex<>(content));
        return true;
    }
    
    public boolean addEdge(E data, V sourceContent, V targetContent, int weight){
        if(data == null || sourceContent == null || targetContent == null || weight < 0){
            return false;
        }
        Vertex<V,E> sourceVertex = this.findVertex(sourceContent);
        Vertex<V,E> targetVertex = this.findVertex(targetContent);
        if(sourceVertex != null && targetVertex != null){
            sourceVertex.getEdges().add(new Edge<>(data, sourceVertex, targetVertex, weight));
            if(!isDirected){
                targetVertex.getEdges().add(new Edge<>(data, targetVertex, sourceVertex, weight));
            }
            return true;
        }
        return false;
    }
    
    public List<Vertex<V,E>> runDijkstra(V sourceContent, V targetContent){
        List<Vertex<V,E>> path = new LinkedList<>();
        if(sourceContent == null || targetContent == null){
            return path;
        }
        Vertex<V,E> sourceVertex = this.findVertex(sourceContent);
        Vertex<V,E> targetVertex = this.findVertex(targetContent);
        if(sourceVertex == null || targetVertex == null){
            return path;
        }
        this.resetVertexs();
        PriorityQueue<Vertex<V,E>> vertexQueue = new PriorityQueue<>();
        vertexQueue.offer(sourceVertex);
        sourceVertex.setCumulativeDistance(0);
        while(!vertexQueue.isEmpty()){
            Vertex<V,E> currentVertex = vertexQueue.poll();
            if(!currentVertex.getIsVisited()){
                currentVertex.setIsVisited(true);
                for(Edge<V,E> edge : currentVertex.getEdges()){
                    Vertex<V,E> adjacentVertex = edge.getTargetVertex();
                    int newCumulativeDistance = currentVertex.getCumulativeDistance() + edge.getWeight();
                    if(newCumulativeDistance < adjacentVertex.getCumulativeDistance()){
                        adjacentVertex.setCumulativeDistance(newCumulativeDistance);
                        adjacentVertex.setPredecessorVertex(currentVertex);
                        vertexQueue.offer(adjacentVertex);
                    }
                }
            }
        }
        Vertex<V,E> currentVertex = targetVertex;
        while(currentVertex != null){
            path.add(0, currentVertex);
            currentVertex = currentVertex.getPredecessorVertex();
        }
        if(path.isEmpty() || !path.get(0).equals(sourceVertex)){
            path.clear();
        }
        return path;
    }
    
}
