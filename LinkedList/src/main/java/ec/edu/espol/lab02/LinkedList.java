/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.lab02;

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
    public boolean isEmpty() {
        return header == null && last == null;
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
        
        // El next de newNode es el que estaba en index
        newNode.setNext(previousElement.getNext()); 
        previousElement.setNext(newNode); 
        
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
    public String toString() {
        
        //String Builder es eficiente para concatenaciones
        StringBuilder arrayString = new StringBuilder("[");
        NodeList<E> traveler;
        
        for (traveler = header; traveler != null; traveler = traveler.getNext()) {
            arrayString.append(traveler.getContent());
            if (traveler != last) {
                arrayString.append(", ");
            }
        }

        arrayString.append("]");
        return arrayString.toString();
        
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
    public E remove(int index) {
        return null;
    }
    
    @Override
    public E get(int index) {
        return null;
    }
    
    @Override
    public E set(int index, E element) {
        return null;
    }
    
    /* LABORATORIO 2 - TUMBACO SANTANA GABRIEL ALEJANDRO - P1*/
    
    // Método 1 - Contains
    // Complejidad O(n)
    
    public boolean contains(E element) {
        
        if (element == null) {
            return false;
        }
        
        NodeList<E> traveler;
        
        for (traveler = header; traveler != null; traveler = traveler.getNext()) {
            if (traveler.getContent().equals(element)) {
                return true;
            }
        }
        return false;
        
    }
    
    // Método 2 - Concatenate
    // Complejidad O(n)
    
    public void concatenate(LinkedList<E> otherList) {
        
        if (otherList == null || otherList.isEmpty()) {
            return;
        }
        
        NodeList<E> traveler;
        
        for (traveler = otherList.getHeader() ; traveler != null; traveler = traveler.getNext()) {
            this.addLast(traveler.getContent());
        }
        
    }
    
    // Método 3 - RotateRight
    // Complejidad O(n²)
    
    public void rotateRight(int n) {
        // Si n = size, el resultado es igual a la lista original
        if (n <= 0 || n >= size()) {
            return;
        }
        
        NodeList<E> traveler = last;
        NodeList<E> previous = last;
        for (int i = 0; i < n; i++) {
            traveler.setNext(header);
            previous = this.getPrevious(traveler);
            this.setHeader(traveler);
            traveler = previous;
        }
        
        this.setLast(previous);
        last.setNext(null);
    }
    
    // Método 4 - getNElement
    // Complejidad O(n)
    
    public E getNElement(int n) {
        int size = size();
        if (n <= 0 || n > size) {
            return null;
        }
        
        if (n == 1) {
            return header.getContent();
        }
        
        if (n == size) {
            return last.getContent();
        }
        
        NodeList<E> traveler = header;
        for (int i = 1; i < n; i++) {
            traveler = traveler.getNext();
        }
        
        return traveler.getContent();
    }
    
    // Método 5 - replaceAll
    // Complejidad O(n)
    
    public int replaceAll(E old, E newValue) {
        if (old == null || newValue == null || this.isEmpty()) {
            return 0;
        }
        
        int counter = 0;
        NodeList<E> traveler;
        
        for (traveler = header; traveler != null; traveler = traveler.getNext()) {
            if (traveler.getContent().equals(old)) {
                traveler.setContent(newValue);
                counter++;
            }
        }
        
        return counter;
    }
    
    // Método 6 - splitIntoTwo
    // Complejidad O(n)
    
    public LinkedList<E>[] splitIntoTwo() {
        LinkedList<E> list1 = new LinkedList<>();
        LinkedList<E> list2 = new LinkedList<>();
        LinkedList<E>[] array = (LinkedList<E>[]) (new LinkedList[2]);
        array[0] = list1;
        array[1] = list2;
        
        if (isEmpty()) {
            return array;
        }
        
        int size = this.size();
        int separator = size % 2 == 0 ? (size / 2) : ((size + 1) / 2 );
        
        NodeList<E> traveler = header;
    
        for (int i = 0; i < size; i++) {
            if (i < separator) {
                list1.addLast(traveler.getContent());
            } else {
                list2.addLast(traveler.getContent());
            }
            traveler = traveler.getNext();
        }
        
        return array;
     
    }
    
    // Método 7 - reverse
    // Complejidad O(n)
    
    public void reverse() {
        if (isEmpty() || size() == 1) {
            return;
        }
        
        NodeList<E> previous = null;
        NodeList<E> current;
        NodeList<E> next = null;
        
        this.setLast(header);
        
        for (current = header; current != null; current = next) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
        }
        
        this.setHeader(previous);

    }
    
}
