/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.lab02;

/**
 *
 * @author gatumbac
 */
public class Lab02 {

    public static void main(String[] args) {
        System.out.println("LABORATORIO #2 - TUMBACO SANTANA GABRIEL ALEJANDRO - P1");
        // La implementación de métodos del laboratorio empiezan en la línea 200 de ArrayList.java
        
        //Listas predefinidas con 5 elementos (ver métodos)

        LinkedList<Integer> intList1 = getIntLinkedList();
        LinkedList<Integer> intList2 = new LinkedList<>();
        LinkedList<Integer> intList3 = getIntLinkedList();
        
        LinkedList<String> stringList1 = getStringLinkedList();
        LinkedList<String> stringList2 = new LinkedList<>();
        LinkedList<String> stringList3 = getStringLinkedList();
        
        //Método 1
        System.out.println("\nMétodo #1 - contains");
        printList(intList1, true);
        System.out.println("Contiene 1 : " + intList1.contains(1));
        System.out.println("Contiene 1000 : " + intList1.contains(1000));
        
        printList(stringList1, true);
        System.out.println("Contiene null : " + stringList1.contains(null));
        System.out.println("Contiene Pepito : " + stringList1.contains("Pepito"));
        
        printList(stringList2, true);
        System.out.println("Contiene null : " + stringList2.contains(null));
        System.out.println("Contiene Hola : " + stringList2.contains("Hola"));
        
        //Método 2
        System.out.println("\nMétodo #2 - concatenate");
        printList(intList1, true);
        printList(intList2, false);
        System.out.println("Concatenacion: ");
        intList1.concatenate(intList2);
        printList(intList1, false);

        printList(intList1, true);
        printList(intList3, false);
        System.out.println("Concatenacion: ");
        intList1.concatenate(intList3);
        printList(intList1, false);
        
        printList(stringList2, true);
        printList(stringList1, false);
        System.out.println("Concatenacion: ");
        stringList2.concatenate(stringList1);
        printList(stringList2, false);
        
        //Método 3
        System.out.println("\nMétodo #3 - rotateRight");
        printList(intList2, true);
        System.out.println("n = 5: ");
        intList2.rotateRight(5);
        printList(intList2, false);
        
        printList(intList1, true);
        System.out.println("n = 7: ");
        intList1.rotateRight(7);
        printList(intList1, false);
        
        printList(stringList1, true);
        System.out.println("n = " + stringList1.size() + ": ");
        stringList1.rotateRight(stringList1.size());
        printList(stringList1, false);
        
        printList(stringList2, true);
        System.out.println("n = 1: ");
        stringList2.rotateRight(1);
        printList(stringList2, false);
        
        //Método 4
        System.out.println("\nMétodo #4 - getNElement");
        printList(stringList1, true);
        System.out.println("n = 0 : " + stringList1.getNElement(0));
        
        printList(stringList1, true);
        System.out.println("n = 5 : " + stringList1.getNElement(stringList1.size()));
        
        printList(intList1, true);
        System.out.println("n = -5 : " + intList1.getNElement(-5));
        
        printList(intList1, true);
        System.out.println("n = 4 : " + intList1.getNElement(4));
        
        printList(intList2, true);
        System.out.println("n = 3 : " + intList2.getNElement(3));
        
        //Método 5
        System.out.println("\nMétodo #5 - replaceAll");
        printList(intList1, true);
        System.out.println("old = 1 | new = 100 : ");
        System.out.println(intList1.replaceAll(1, 100) + " veces");
        printList(intList1, false);
        
        printList(intList2, true);
        System.out.println("old = 100 | new = 1000 : ");
        System.out.println(intList2.replaceAll(100, 1000) + " veces");
        printList(intList2, false);
        
        printList(stringList2, true);
        System.out.println("old = yes | new = hello : ");
        System.out.println(stringList2.replaceAll("yes", "hello") + " veces");
        printList(stringList2, false);
        
        printList(stringList3, true);
        System.out.println("old = Pepito | new = null : ");
        System.out.println(stringList3.replaceAll("Pepito", null) + " veces");
        printList(stringList3, false);
        
        //Método 6
        System.out.println("\nMétodo #6 - splitIntoTwo");
        printList(intList1, true);
        LinkedList<Integer>[] array1 = intList1.splitIntoTwo();
        printList(array1[0], false);
        printList(array1[1], false);
        
        printList(stringList1, true);
        LinkedList<String>[] array2 = stringList1.splitIntoTwo();
        printList(array2[0], false);
        printList(array2[1], false);
        
        LinkedList<Integer> specialList = new LinkedList();
        specialList.addLast(100);
        printList(specialList, true);
        LinkedList<Integer>[] array4 = specialList.splitIntoTwo();
        printList(array4[0], false);
        printList(array4[1], false);
        
        printList(intList2, true);
        LinkedList<Integer>[] array3 = intList2.splitIntoTwo();
        printList(array3[0], false);
        printList(array3[1], false);
        
        //Método 7
        System.out.println("\nMétodo #7 - reverse");
        printList(intList3, true);
        System.out.println("Reverse: ");
        intList3.reverse();
        printList(intList3, false);
        
        printList(specialList, true);
        System.out.println("Reverse: ");
        specialList.reverse();
        printList(specialList, false);
        
        specialList.addLast(999);
        printList(specialList, true);
        System.out.println("Reverse: ");
        specialList.reverse();
        printList(specialList, false);
        
        printList(intList2, true);
        System.out.println("Reverse: ");
        intList2.reverse();
        printList(intList2, false);
        
        printList(stringList3, true);
        System.out.println("Reverse: ");
        stringList3.reverse();
        printList(stringList3, false);
        
    }
    
    public static LinkedList<Integer> getIntLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(2);
        list.addFirst(1);
        list.add(1, 3);
        list.addLast(4);
        list.addLast(5);
        
        return list;
    }
    
    public static LinkedList<String> getStringLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("Pedro");
        list.addLast("Juan");
        list.add(1, "Marcos");
        list.addLast("Pepito");
        list.addFirst("Luis");
        
        return list;
    }
    
    public static <E> void printList(LinkedList<E> list, boolean newLine) {
        
        if (newLine) {
            System.out.println();
        }

        System.out.println(list.toString());
    }
}
