/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.lab01;
import java.util.Random;

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

    private void shiftRightFrom(int index) {
        for (int i = effectiveSize; i > index; i--) {
            elements[i] = elements[i-1];
        }
    }
    
    private void shiftLeftFrom(int index) {
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
            shiftRightFrom(0);
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

        shiftRightFrom(index);

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
        shiftLeftFrom(1);
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
        
        shiftLeftFrom(index + 1);
        elements[effectiveSize - 1] = null;
        effectiveSize--;
        return element;
        
    }
    
    @Override
    public String toString() {
        
        StringBuilder arrayString = new StringBuilder("[");
        for (int i = 0; i < effectiveSize; i++) {
            arrayString.append(elements[i]);
            if (i != effectiveSize - 1) {
                arrayString.append(", ");
            }
        }
        arrayString.append("]");
        return arrayString.toString();
        
    }
    
    /*
        LABORATORIO 01 - TUMBACO SANTANA GABRIEL ALEJANDRO
    */
    
    // Método 1 - addAll
    // Complejidad O(m), m = array.length
    
    public void addAll(E[] array) {
        
        if (array == null || array.length == 0 || verifyNullInArray(array)) {
            return;
        }
        
        verifyCapacityLoop(array.length);
        
        int sizeBeforeAddition = effectiveSize;
        for (int i = 0; i < array.length; i++) {
            elements[sizeBeforeAddition + i] = array[i];
            effectiveSize++;
        }
   
    }
    
    private void verifyCapacityLoop(int arraySize) {
        // En caso de arreglos muy grandes no es suficiente una sola llamada a addCapacity
        while ((effectiveSize + arraySize) > capacity) {
            addCapacity();
        }
    }
    
    private boolean verifyNullInArray(E[] array) {
        for (E element: array) {
            if (element == null) {
                return true;
            }
        }
        return false;
    }
    
    // Método 2 - removeFirstOcurrence
    // Complejidad O(n)
    
    public void removeFirstOccurrence(E element) {
        
        if (element == null || isEmpty()) {
            return;
        }
        
        for (int i = 0; i < effectiveSize; i++) {
            if (element.equals(elements[i])) {
                // Uso del método diseñado anteriormente (ver método)
                remove(i);
                return;
            }
        }
        
    }
    
    // Método 3 - splitAt
    // Complejidad O(n)
    
    public void splitAt(int index, ArrayList<E> first, ArrayList<E> second) {
        
        if (index < 0 || index > effectiveSize) {
            return;
        }
        
        if (first == null || second == null || first == second) {
            return;
        }
        
        first.clear();
        second.clear();
        
        for (int i = 0; i < effectiveSize; i++) {
            if (i < index) {
                first.addLast(elements[i]);
            } else {
                second.addLast(elements[i]);
            }
        }
        
    }
    
    // Método 4 - shiftLeft
    // Complejidad O(n)
    
    public void shiftLeft(int k) {
        // Validacion del numero de desplazamiento
        // Si k = effectiveSize, la lista quedará igual
        if (k <= 0 || k >= effectiveSize) {
            return;
        }
        
        if (effectiveSize + k > capacity) {
            addCapacity();
        }
        
        // Copia de los primeros k elementos al final
        for (int i = 0; i < k; i++) {
            elements[effectiveSize + i] = elements[i];
        }
        
        // Desplazamiento desde el elemento k y posteriores al inicio
        // Se eliminan las copias temporales de los primeros k elementos
        for (int i = k; i < effectiveSize + k; i++ ) {
            elements[i - k] = elements[i];
            if (i >= effectiveSize) {
                elements[i] = null;
            }
        }
    }
    
    // Método 5 - intersection
    // Complejidad O(n²)
    
    public ArrayList<E> intersection(ArrayList<E> otherList) {
        if (otherList == null || otherList.isEmpty()) {
            return copy();
        }
        
        ArrayList<E> newList = new ArrayList<>();

        for (int i = 0; i < effectiveSize; i++) {
            if (otherList.contains(elements[i]) && !newList.contains(elements[i])) {
                newList.addLast(elements[i]);
            }
        }
        
        return newList;
    }
    
    public ArrayList<E> copy() {
        ArrayList<E> copy = new ArrayList<>();
        for (int i = 0; i < effectiveSize; i++) {
            copy.addLast(elements[i]);
        }
        return copy;
    }
    
    public boolean contains(E element) {
        for (int i = 0; i < effectiveSize; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }
    
    // Método 6 - padToSize
    // Complejidad O(m), m = size - effectiveSize
    
    public void padToSize(int size, E element) {
        
        if (size <= effectiveSize || element == null) {
            return;
        }
        
        int iterations = size - effectiveSize;
        
        // Asegurar el tamaño en caso de size muy grande
        verifyCapacityLoop(iterations);
        
        int sizeBeforeAddittion = effectiveSize;
        for (int i = 0; i < iterations; i++) {
            elements[sizeBeforeAddittion + i] = element;
            effectiveSize++;
        }
    }
    
    // Método 7 - shuffleFirstNEelements
    // Complejidad O(n)
    
    public void shuffleFirstNElements(int n) {
        if (n <= 0 || n > effectiveSize) {
            return;
        }
        
        Random random = new Random();
        int randomIndex; 
        
        for (int i = 0; i < n; i++) {
            randomIndex = random.nextInt(n);
            E randomElement = elements[randomIndex];
            
            elements[randomIndex] = elements[i];
            elements[i] = randomElement;
        }
    }
    
    
}
