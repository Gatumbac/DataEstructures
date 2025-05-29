/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tdalist;
import java.util.Arrays;

/**
 *
 * @author gatumbac
 */
public class ArrayList<E> implements List<E> {
    
    private E[] elements;
    private int capacity = 100;
    private int effectiveSize;

    public ArrayList() {
        elements = (E[]) (new Object[capacity]);
        effectiveSize = 0;
    }

    private boolean isFull() {
        return effectiveSize == capacity;
    }

    @Override
    public boolean isEmpty() {
        return effectiveSize == 0;
    }

    @Override
    public int size() {
        return effectiveSize;
    }
    
    @Override
    public void clear() {
        //capacity no se modifica, puede haberse incrementado
        for (int i = 0; i < effectiveSize; i++) {
            elements[i] = null;
        }
        effectiveSize = 0;
    }

    private void addCapacity() {
        E[] backup = (E[]) (new Object[capacity * 2]);
        for (int i = 0; i < effectiveSize; i++) {
            backup[i] = elements[i];
        }

        elements = backup;
        capacity = capacity * 2;
    }

    private void shiftRight(int index) {
        for (int i = effectiveSize; i > index; i--) {
            elements[i] = elements[i-1];
        }
    }
    
    private void shiftLeft(int index) {
        for (int i = index; i < effectiveSize; i++) {
            elements[i - 1] = elements[i];
        }
    }

    @Override
    public boolean addFirst(E element) {

        if (element == null) {
            return false;
        }

        if (isFull()) {
            addCapacity();
        }

        if (!isEmpty()) {
            shiftRight(0);
        }

        elements[0] = element;
        effectiveSize++;
        return true;

    }

    @Override 
    public boolean addLast(E element) {

        if (element == null) {
            return false;
        }

        if (isFull()) {
            addCapacity();
        }

        elements[effectiveSize++] = element;
        return true;

    }

    @Override 
    public boolean add(int index, E element) {

        if (element == null || index < 0 || index > effectiveSize) {
            return false;
        }

        if (isFull()) {
            addCapacity();
        }

        shiftRight(index);

        elements[index] = element;
        effectiveSize++;
        return true;
    }

    @Override
    public E get(int index) {
        
        if (index < 0 || index >= effectiveSize) {
            return null;
        }
        
        return elements[index];
        
    }
    
    //Setea el elemento y retorna el que estaba previamente
    @Override
    public E set(int index, E element) {
        
        if (element == null || index < 0 || index >= effectiveSize) {
            return null;
        }
        
        E previousElement = elements[index];
        elements[index] = element;
        return previousElement;
        
    }
    
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        
        E firstElement = elements[0];
        shiftLeft(1);
        elements[effectiveSize - 1] = null;
        effectiveSize--;
        return firstElement;
    }
    
    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        
        E element = elements[effectiveSize - 1];
        elements[effectiveSize - 1] = null;
        effectiveSize--;
        return element;
    }
    
    @Override
    public E remove(int index) {
        if (index < 0 || index >= effectiveSize) {
            return null;
        }
        
        E element = elements[index];
        
        shiftLeft(index + 1);
        elements[effectiveSize - 1] = null;
        effectiveSize--;
        return element;
    }
    
    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOf(elements, effectiveSize)));
    }
        
}
