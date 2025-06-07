/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.lab02;

/**
 *
 * @author gatumbac
 */
public class DoublyLinkedList<E> implements List<E> {
    
    private DoublyNodeList<E> header;
    private DoublyNodeList<E> last;
    
    public DoublyLinkedList() {}
    
    public DoublyNodeList<E> getHeader() {
        return header;
    }
    
    public void setHeader(DoublyNodeList<E> header) {
        this.header = header;
    }
    
    public DoublyNodeList<E> getLast() {
        return last;
    }
    
    public void setLast(DoublyNodeList<E> last) {
        this.last = last;
    }
    
    @Override
    public int size() {
        
        int size = 0;
        DoublyNodeList<E> traveler;
        
        for (traveler = header; traveler != null; traveler = traveler.getNext()) {
            size++;
        }
        
        return size;
        
    }
    
    @Override
    public boolean isEmpty() {
        return header == null && last == null;
    }
    
    @Override
    public boolean addFirst(E element) {
        
        if (element == null) {
            return false;
        }
        
        DoublyNodeList<E> newNode = new DoublyNodeList<>(element);
        
        if (last == null) {
            last = newNode;
        }
        
        if (header != null) {
            header.setPrevious(newNode);
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
        
        DoublyNodeList<E> newNode = new DoublyNodeList<>(element);
        
        if (last != null) {
            last.setNext(newNode);
        } 
        
        if (header == null) {
            header = newNode;
        }
        
        newNode.setPrevious(last);
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
        
        DoublyNodeList<E> newNode = new DoublyNodeList<>(element);

        DoublyNodeList<E> previousElement = header;
        
        // Se recorre desde el segundo nodo, porque el primero ya fue obtenido (header)
        // Se obtiene el elemento anterior a index
        for (int i = 1; i < index; i++) {
            previousElement = previousElement.getNext();
        }
        
        DoublyNodeList<E> nextElement = previousElement.getNext();
        
        previousElement.setNext(newNode); 
        newNode.setNext(nextElement); 
        newNode.setPrevious(previousElement); 
        nextElement.setPrevious(newNode);
        
        return true;
        
    }
    
    @Override
    public E remove(int index) {
        
        // Implementación de la profesora
        
        DoublyNodeList<E> p = header;
        
        for(int i=0; i < index; i++){
            p = p.getNext();
        }
        
        p.getPrevious().setNext(p.getNext());
        p.getNext().setPrevious(p.getPrevious());
        
        p.setNext(null);
        p.setPrevious(null);
        
        return p.getContent();
        
    }
    
    @Override
    public String toString() {
        
        //String Builder es eficiente para concatenaciones
        StringBuilder arrayString = new StringBuilder("[");
        DoublyNodeList<E> traveler;
        
        for (traveler = header; traveler != null; traveler = traveler.getNext()) {
            arrayString.append(traveler.getContent());
            if (traveler != last) {
                arrayString.append(", ");
            }
        }

        arrayString.append("]");
        return arrayString.toString();
        
    }
    
    // Complejidad O(n)
    public void travelBackwards() {
        DoublyNodeList<E> traveler;
        for (traveler = last; traveler != null; traveler = traveler.getPrevious()) {
            System.out.println(traveler.getContent());
        }
    }
    
    @Override
    public E removeFirst() {
        return null;
    }
    
    @Override
    public E removeLast() {
        return null;
    }
    
    @Override
    public void clear() {
        System.out.println("Cleaning ...");
    }
    
    @Override
    public E get(int index) {
        return null;
    }
    
    @Override
    public E set(int index, E element) {
        return null;
    }
    
}
