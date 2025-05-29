/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tdalist;

/**
 *
 * @author CltControl
 */
public class DoublyLinkedList<E> implements List<E> {
    
    private DoublyNodeList<E> header;
    private DoublyNodeList<E> last;
    
    public DoublyLinkedList() {
        this.header = null;
        this.last = null;
    }
    
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
        
        if (isEmpty()) {
            last = newNode;
        } else {
            header.setPrevious(newNode);
            newNode.setNext(header);
        }
        
        header = newNode;
        return true;
        
    }
    
    @Override
    public boolean addLast(E element) {
        
        if (element == null) {
            return false;
        }
        
        DoublyNodeList<E> newNode = new DoublyNodeList<>(element);
        
        if (isEmpty()) {
            header = newNode;
        } else {
            last.setNext(newNode);
            newNode.setPrevious(last);
        }
        
        last = newNode;
        return true;
        
    }
    
    @Override
    public void print() {
        if (size() == 0) {
            System.out.println("No hay elementos para mostrar");
        }
        
        DoublyNodeList<E> traveler;
        
        for (traveler = header; traveler != null; traveler = traveler.getNext()) {
            System.out.println(traveler.getContent());
        }

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
    
    private NodeList<E> getPrevious(NodeList<E> node) {
        return null;
    }
    
    public void travelBackwards() {
        
    }
    

    public E removeFirst() {
        return null;
    }
    public E removeLast() {
        return null;
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
