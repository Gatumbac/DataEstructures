package linkedlist;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * TUMBACO SANTANA GABRIEL ALEJANDRO
 * PARALELO 1
 * LAB 03 - ITERADORES Y COMPARADORES
 */

public class Main {
    
    public static void main (String[] args)
    {   
        System.out.println("\n-- LAB03 ITERADORES COMPARADORES | TUMBACO SANTANA GABRIEL ALEJANDRO P1 --");
        // Listas de enteros
        List<Integer> list1 = new LinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);
        list1.addLast(1);
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(4);
        
        List<Integer> list2 = new ArrayList<>();
        list2.addLast(5);
        list2.addLast(8);
        list2.addLast(9);
        list2.addLast(11);
        
        // Listas de Personas
        List<Person> list3 = new LinkedList<>();
        list3.addLast(new Person("Raquel", "Jaramillo", 24));
        list3.addLast(new Person("Gabriel", "Tumbaco", 28));
        list3.addLast(new Person("Gabriel", "Tumbaco", 28));
        list3.addLast(new Person("Ramiro", "Lopez", 47));
        list3.addLast(new Person("Rafael", "Pesantez", 23));
        list3.addLast(new Person("Felix", "Peralta", 38));

        List<Person> list4 = new ArrayList<>();
        list4.addLast(new Person("Julio", "Carrera", 24));
        list4.addLast(new Person("Flor", "Parrales", 38));
        list4.addLast(new Person("Emilio", "Doumet", 48));
        list4.addLast(new Person("Alex", "Vaca", 84));
        list4.addLast(new Person("Daniel", "Macias", 100));
        
        // Comparadores Base
        
        Comparator<Person> personCmp = new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int nameCmp = p1.getName().compareTo(p2.getName());
                int lastNameCmp = p1.getLastName().compareTo(p2.getLastName());
                int ageCmp = p1.getAge() - p2.getAge();
                
                if (ageCmp != 0) return ageCmp;
                if (nameCmp != 0) return nameCmp;
                return lastNameCmp;
            }
        };
        
        Comparator<Integer> integerCmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1 - i2;
            }
        };
        
        // Método #1
        System.out.println("\n-- METODO 1 | countOcurrences --");
        int count1 = Lab03.countOcurrences(list1.iterator(), integerCmp, 1);
        System.out.println("Lista: " + list1);
        System.out.println("Elemento: 1 | Contador: " + count1);
        
        System.out.println();
        int count2 = Lab03.countOcurrences(list2.iterator(), integerCmp, 100);
        System.out.println("Lista: " + list2);
        System.out.println("Elemento: 100 | Contador: " + count2);
        
        System.out.println();
        int count3 = Lab03.countOcurrences(list3.iterator(), personCmp, new Person("Gabriel", "Tumbaco", 28));
        System.out.println("Lista: " + list3);
        System.out.println("Elemento: Gabriel Tumbaco 28 | Contador: " + count3);
        
        // Método #2
        System.out.println("\n-- METODO 2 | isStrictlyIncreasing --");
        
        boolean isIncreasing1 = Lab03.isStrictlyIncreasing(list1.iterator(), integerCmp);
        System.out.println("Lista: " + list1);
        System.out.println("Estrictamente Creciente: " + isIncreasing1);
        
        System.out.println();
        boolean isIncreasing2 = Lab03.isStrictlyIncreasing(list2.iterator(), integerCmp);
        System.out.println("Lista: " + list2);
        System.out.println("Estrictamente Creciente: " + isIncreasing2);
        
        System.out.println(); // Comparador por edad. Verifica si las edades son estrictamente crecientes
        boolean isIncreasing3 = Lab03.isStrictlyIncreasing(list4.iterator(), (Person p1, Person p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        System.out.println("Lista: " + list4);
        System.out.println("Estrictamente Creciente: " + isIncreasing3);
        
        // Método #3
        System.out.println("\n-- METODO 3 | findNext --");
        
        Integer next1 = Lab03.findNext(list1.iterator(), integerCmp, 3);
        System.out.println("Lista: " + list1);
        System.out.println("Elemento: 3 | Siguiente: " + next1);
        
        Integer next2 = Lab03.findNext(list2.iterator(), integerCmp, 100);
        System.out.println("Lista: " + list2);
        System.out.println("Elemento: 100 | Siguiente: " + next2);
        
        Person next3 = Lab03.findNext(list3.iterator(), personCmp, new Person("Raquel", "Jaramillo", 24));
        System.out.println("Lista: " + list3);
        System.out.println("Elemento: Raquel Jaramillo 24 | Siguiente: " + next3);
        
        // Método #4
        System.out.println("\n-- METODO 4 | findMinMax --");
        
        List<Integer> minMax = Lab03.findMinMax(list1, integerCmp);
        System.out.println("Lista: " + list1);
        System.out.println("Min, Max: " + minMax);
        
        List<Integer> minMax2 = Lab03.findMinMax(list2, integerCmp);
        System.out.println("Lista: " + list2);
        System.out.println("Min, Max: " + minMax2);
        
        // Método #5
        System.out.println("\n-- METODO 5 | countUniqueElements --");
        
        int uniques = Lab03.countUniqueElements(list1, integerCmp);
        System.out.println("Lista: " + list1);
        System.out.println("Elementos Unicos: " + uniques);
        
        System.out.println();
        int uniques2 = Lab03.countUniqueElements(list2, integerCmp);
        System.out.println("Lista: " + list2);
        System.out.println("Elementos Unicos: " + uniques2);
        
        // Método #6
        System.out.println("\n-- METODO 6 | countElementsBetween --");
        
        int countBet1 = Lab03.countElementsBetween(list1.iterator(), integerCmp, 1, 4);
        System.out.println("Lista: " + list1);
        System.out.println("Elementos entre 1 y 4: " + countBet1);
        
        System.out.println();
        int countBet2 = Lab03.countElementsBetween(list2.iterator(), integerCmp, 5, 11);
        System.out.println("Lista: " + list2);
        System.out.println("Elementos entre 5 y 11: " + countBet2);
        
        System.out.println();
        int countBet3 = Lab03.countElementsBetween(list1.iterator(), integerCmp, 4, 25);
        System.out.println("Lista: " + list1);
        System.out.println("Elementos entre 4 y 25: " + countBet3);
        
        System.out.println();
        int countBet4 = Lab03.countElementsBetween(list3.iterator(), personCmp, new Person("Gabriel", "Tumbaco", 28), new Person("Felix", "Peralta", 38) );
        System.out.println("Lista: " + list3);
        System.out.println("Elementos entre Gabriel Tumbaco y Felix Peralta: " + countBet4);
  
    }
}