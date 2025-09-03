/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ultimatarea;

/**
 *
 * @author estudiante
 * @param <V>
 * @param <E>
 */

public class Edge<V,E> {
    
    // Atributos:

    private E data;
    private Vertex<V,E> sourceVertex;
    private Vertex<V,E> targetVertex;
    private int weight;

    // Métodos:

    public Edge(E data, Vertex<V,E> sourceVertex, Vertex<V,E> targetVertex, int weight) {
        this.data = data;
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
        this.weight = weight;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Vertex<V, E> getSourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(Vertex<V, E> nodoOrigen) {
        this.sourceVertex = nodoOrigen;
    }

    public Vertex<V, E> getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex<V, E> nodoDestino) {
        this.targetVertex = nodoDestino;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
}
