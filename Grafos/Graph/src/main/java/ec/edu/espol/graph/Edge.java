/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.graph;

/**
 *
 * @author gatumbac
 */
public class Edge <E, V> { 
    
    private Vertex<V, E> source; 
    private Vertex<V, E> target; 
    private int weight; 
    private E data; 

    public Edge(Vertex<V, E> source, Vertex<V, E> target, int weight, E data) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.data = data;
    }

    public Edge(Vertex<V, E> source, Vertex<V, E> target, int weight) {
        this (source, target, weight, null);
    }

    public Edge(Vertex<V, E> source, Vertex<V, E> target, E data) {
        this (source, target, -1, data);
    }

    public Edge(Vertex<V, E> source, Vertex<V, E> target) {
        this (source, target, -1, null);
    }

    public Vertex<V, E> getSource() {
        return source;
    }

    public void setSource(Vertex<V, E> source) {
        this.source = source;
    }

    public Vertex<V, E> getTarget() {
        return target;
    }

    public void setTarget(Vertex<V, E> target) {
        this.target = target;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
