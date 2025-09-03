/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.graph;

import java.util.Comparator;

/**
 *
 * @author gatumbac
 */
public class GraphAM<V> {
    private V[] vertexs;
    private int effectiveSize = 0;
    private int capacity = 100;
    
    private int [][] adjacencyMatrix;
    private boolean isDirected;
    
    private Comparator<V> cmp;
    
    public GraphAM(boolean isDirected, Comparator<V> cmp) {
        vertexs = (V[]) new Object[capacity];
        adjacencyMatrix = new int [capacity][capacity];
        this.isDirected = isDirected;
        this.cmp = cmp;
        initAdjancencyMatrix();
    }
    
    public boolean addVertex (V content){
        if (content == null || findIndexOfVertex(content) != -1) {
            return false;
        }
        
        if (isFull()) {
            addCapacity();
        }
        
        this.vertexs[effectiveSize++] = content;
        return true;
    }
    
    
    public boolean connect(V v1, V v2) {
        int index1 = findIndexOfVertex(v1);
        int index2 = findIndexOfVertex(v2);
        
        if (index1 == -1 || index2 == -1) {
            return false; 
        }
        
        adjacencyMatrix[index1][index2] = 1;
        
        if (!isDirected) {
            adjacencyMatrix[index2][index1] = 1;
        }
        
        return true;
    }

    private void initAdjancencyMatrix() {
        for (int i = 0; i < adjacencyMatrix.length; i++){
            for (int j = 0; j < adjacencyMatrix.length; j++){
                adjacencyMatrix[i][j] = -1;
            }
        }
    }

    private int findIndexOfVertex(V v) {
        for (int i = 0; i < vertexs.length; i++){
            if (this.cmp.compare(vertexs[i],v) == 0){
                return i;
            }
        }
        return -1;
    }

    private boolean isFull() {
        return effectiveSize == capacity;
    }

    private void addCapacity() {
        V[] newVertexs = (V[]) new Object[capacity * 2];
        int[][] newAdjacencyMatrix = new int[capacity * 2][capacity * 2];
        System.arraycopy(vertexs, 0, newVertexs, 0, effectiveSize);
        for (int i = 0; i < capacity; i++) {
            System.arraycopy(adjacencyMatrix[i], 0, newAdjacencyMatrix[i], 0, capacity);
        }
        vertexs = newVertexs;
        adjacencyMatrix = newAdjacencyMatrix;
        capacity *= 2;
        initAdjancencyMatrix();
    }
}

