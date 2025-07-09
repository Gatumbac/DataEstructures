/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedlist;
import java.util.Iterator;
import java.util.Comparator;

/**
 *
 * @author gatumbac
 */
public class Lab03 {
    
    // Métodos estáticos genéricos
    public static <E> int countOcurrences(Iterator<E> it, Comparator<E> cmp, E element) {
        int count = 0;
        
        if (element == null) {
            return count;
        }
        
        while (it.hasNext()) {
            E next = it.next();
            if (cmp.compare(next, element) == 0) {
                count++;
            }
        }
        return count;
    }
    
    public static <E> boolean isStrictlyIncreasing(Iterator<E> it, Comparator<E> cmp) {
        E current = null;
        if (it.hasNext()) {
            current = it.next();
        }
        
        while (it.hasNext()) {
            E next = it.next();
            if (cmp.compare(current, next) >= 0) {
                return false;
            }
            
            current = next;
        }
        
        return true;
    }
    
    public static <E> E findNext(Iterator<E> it, Comparator<E> cmp, E element) {
        if (element == null) {
            return null;
        }
        
        while (it.hasNext()) {
            E current = it.next();
            
            if (cmp.compare(current, element) == 0 && it.hasNext()) {
                return it.next();
            }
        }
        
        return null;
    }
    
    public static List<Integer> findMinMax(List<Integer> list, Comparator<Integer> cmp) {
        Iterator<Integer> it = list.iterator();
        int min = 0;
        int max = 0;
        
        if (it.hasNext()) {
            Integer first = it.next();
            min = first;
            max = first;
        }
        
        while (it.hasNext()) {
            Integer current = it.next();
            if (cmp.compare(current, min) <= 0) {
                min = current;
            } 
            
            if (cmp.compare(current, max) > 0) {
                max = current;
            }
        }
        
        List<Integer> pair = new ArrayList<>();
        pair.addLast(min);
        pair.addLast(max);
        return pair;
    }
    
    // Complejidad O(n²)
    public static int countUniqueElements(List<Integer> list, Comparator<Integer> cmp) {
        Iterator<Integer> it1 = list.iterator();
        
        int uniques = 0;
        
        while (it1.hasNext()) {
            Integer current = it1.next();
            Iterator<Integer> it2 = list.iterator();
            int currentCounts = 0;
            
            while (it2.hasNext()) {
                Integer i2 = it2.next();
                
                if (cmp.compare(current, i2) == 0) {
                    currentCounts++;
                }
            }

            if(currentCounts == 1) {
                uniques++;
            }            
        }
        
        return uniques;
    }
    
    public static <E> int countElementsBetween(Iterator<E> it, Comparator<E> cmp, E start, E end) {
        int count = 0;
        boolean hasStart = false;
        boolean hasEnd = false;
        
        while(it.hasNext()) {
            E current = it.next();
            
            if (cmp.compare(current, start) == 0) {
               hasStart = true;
            }

            if (hasStart && !hasEnd) {
               count++;
            }

            if (cmp.compare(current, end) == 0) {
               hasEnd = true;
               break; //Terminar bucle, no es eficiente seguir contando luego de encontrar el final
            }
        }
        
        if (hasStart && hasEnd) {
            return count;
        } 
        
        return 0;
    }
}
