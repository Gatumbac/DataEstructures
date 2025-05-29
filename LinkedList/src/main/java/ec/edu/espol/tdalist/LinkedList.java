/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tdalist;

/**
 *
 * @author gatumbac
 */
public class LinkedList<E> implements List<E> {
    
    private NodeList<E> header;
    private NodeList<E> last;
    
    public LinkedList() {}
    
    public NodeList<E> getHeader() {
        return header;
    }
    
    public void setHeader(NodeList<E> header) {
        this.header = header;
    }
    
    public NodeList<E> getLast() {
        return last;
    }
    
    public void setLast(NodeList<E> last) {
        this.last = last;
    }
    
    @Override
    public int size() {
        
        int size = 0;
        NodeList<E> traveler;
        
        for (traveler = header; traveler != null; traveler = traveler.getNext()) {
            size++;
        }
        
        return size;
        
    }
    
    @Override
    public boolean addFirst(E element) {
        
        if (element == null) {
            return false;
        }
        
        NodeList<E> newNode = new NodeList<>(element);
        
        if (last == null) {
            last = newNode;
        }
        
        newNode.setNext(header);
        header = newNode;
        return true;
        
    }
    
    @Override
    public boolean addLast(E element) {
        
        if (element == null) {
            return false;
        }
        
        NodeList<E> newNode = new NodeList<>(element);
        
        if (last != null) {
            last.setNext(newNode);
        } 
        
        if (header == null) {
            header = newNode;
        }
        
        last = newNode;
        return true;
        
    }
    
    @Override
    public boolean add(int index, E element) {
        
        if (element == null || index < 0 || index > size()) {
            return false;
        }
        
        if (index == 0) {
            addFirst(element);
            return true;
        }
        
        if (index == size()) {
            addLast(element);
            return true;
        }
        
        NodeList<E> newNode = new NodeList<>(element);

        NodeList<E> previousElement = header;
        
        // Se recorre desde el segundo nodo, porque el primero ya fue obtenido (header)
        // Se obtiene el elemento anterior a index
        for (int i = 1; i < index; i++) {
            previousElement = previousElement.getNext();
        }
        
        newNode.setNext(previousElement.getNext()); // El next de newNode es el que estaba en index
        previousElement.setNext(newNode); // Se actualiza el nodo anterior
        
        return true;
        
    }
    
    private NodeList<E> getPrevious(NodeList<E> node) {
        NodeList<E> previous = null;
        NodeList<E> traveler;
        
        for (traveler = header; traveler != node; traveler = traveler.getNext()) {
            previous = traveler;
        }
        return previous;
    }
    
    public void travelBackwards() {
        NodeList<E> traveler;
        
        for (traveler = last; traveler != null; traveler = this.getPrevious(traveler)) {
            System.out.println(traveler.getContent());
        }
    }
    
    @Override
    public void print() {
        if (size() == 0) {
            System.out.println("No hay elementos para mostrar");
        }
        
        NodeList<E> traveler;
        
        for (traveler = header; traveler != null; traveler = traveler.getNext()) {
            System.out.println(traveler.getContent());
        }

    }
    

    public E removeFirst() {
        return null;
    }
    public E removeLast() {
        return null;
    }
    public boolean isEmpty() {
        return header == null || last == null;
    }
    public void clear() {
        System.out.println("Cleaning ...");
    }
    public E remove(int index) {
        return null;
    }
    public E get(int index) {
        return null;
    }
    public E set(int index, E element) {
        return null;
    }
    
    
    
    
}
