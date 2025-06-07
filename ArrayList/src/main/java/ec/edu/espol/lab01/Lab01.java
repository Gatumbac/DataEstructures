/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.lab01;

/**
 *
 * @author gatumbac
 */
public class Lab01 {

    public static void main(String[] args) {
        System.out.println("LABORATORIO #1 - TUMBACO SANTANA GABRIEL ALEJANDRO - P1");
        // La implementación de métodos del laboratorio empiezan en la línea 210 de ArrayList.java
        
        //Listas predefinidas con 5 elementos (ver métodos)
        ArrayList<Integer> list1 = getIntArrayList();
        ArrayList<String> list2 = getStringArrayList();
        
        //Método 1
        System.out.println("\nMétodo #1 - addAll");
        System.out.println("Lista de Enteros");
        System.out.println(list1.toString());
        Integer[] ex1 = {100,200,300};
        list1.addAll(ex1);
        System.out.println(list1.toString());
        
        Integer[] ex2 = {};
        list1.addAll(ex2);
        System.out.println(list1.toString());
        
        System.out.println("Lista de Strings");
        System.out.println(list2.toString());
        String[] ex3 = {"Maria", null, "Juana"};
        list2.addAll(ex3);
        System.out.println(list2.toString());
        
        //Método 2 
        System.out.println("\nMétodo #2 - removeFirstOcurrence");
        System.out.println("Lista de Enteros");
        list1.addLast(100); 
        System.out.println(list1.toString());
        list1.removeFirstOccurrence(100);
        System.out.println(list1.toString());
        
        System.out.println("Lista de Strings");
        System.out.println(list2.toString());
        list2.removeFirstOccurrence(null);
        System.out.println(list2.toString());
        
        //Método 3
        System.out.println("\nMétodo #3 - splitAt");
        System.out.println("Lista de Enteros");
        System.out.println(list1.toString());
        ArrayList<Integer> firstIntList = new ArrayList<>();
        ArrayList<Integer> secondIntList = new ArrayList<>();
        list1.splitAt(5, firstIntList, secondIntList);
        
        System.out.println(firstIntList.toString());
        System.out.println(secondIntList.toString());
        
        System.out.println("Lista de Strings");
        System.out.println(list2.toString());
        ArrayList<String> firstStringList = new ArrayList<>();
        ArrayList<String> secondStringList = new ArrayList<>();
        list2.splitAt(5, firstStringList, secondStringList);
        
        System.out.println(firstStringList.toString());
        System.out.println(secondStringList.toString());
        
        //Método 4
        System.out.println("\nMétodo #4 - shiftLeft");
        ArrayList<Integer> nums = new ArrayList<>();
        nums.addAll(new Integer[] {1,2,3,4,5,6,7,8,9,10});
        System.out.println("Lista de Enteros");
        System.out.println(nums.toString());
        nums.shiftLeft(5);
        System.out.println(nums.toString());
        
        System.out.println("Lista de Strings");
        System.out.println(list2.toString());
        list2.shiftLeft(10);
        System.out.println(list2.toString());
        list2.shiftLeft(1);
        System.out.println(list2.toString());
        
        //Método 5 
        System.out.println("\nMétodo #5 - intersection");
        System.out.println("Listas de Enteros");
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(10);
        nums.addLast(1);
        nums.addLast(2);
        nums.addLast(3);
        System.out.println(list1.toString());
        System.out.println(nums.toString());
        System.out.println("Interseccion");
        ArrayList<Integer> intersection = list1.intersection(nums);
        System.out.println(intersection.toString());
        
        System.out.println("Listas de Strings");
        ArrayList<String> ex5 = new ArrayList<>();
        System.out.println(list2.toString());
        System.out.println(ex5.toString());
        System.out.println("Interseccion");
        ArrayList<String> intersection2 = list2.intersection(ex5);
        System.out.println(intersection2.toString());
        
        //Método 6
        System.out.println("\nMétodo #6 - padToSize");
        System.out.println("Lista de Enteros");
        System.out.println(list1.toString());
        
        list1.padToSize(25, 500);
        System.out.println(list1.toString());
        System.out.println(list1.size());
        
        
        System.out.println("Lista de Strings");
        System.out.println(list2.toString());
        list2.padToSize(100, null);
        System.out.println(list2.toString());
        System.out.println(list2.size());
        
        //Método 7
        
        System.out.println("\nMétodo #7 - shuffleFirstNElements");
        System.out.println("Lista de Enteros");
        System.out.println(nums.toString());
        nums.shuffleFirstNElements(5);
        System.out.println(nums.toString());
        
        System.out.println("Lista de Strings");
        System.out.println(list2.toString());
        list2.shuffleFirstNElements(0);
        System.out.println(list2.toString());
        list2.shuffleFirstNElements(5);
        System.out.println(list2.toString());
        
    }
    
    public static ArrayList<Integer> getIntArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        list.addLast(1);
        list.addFirst(2);
        list.add(1, 3);
        list.addLast(4);
        list.addFirst(5);
        
        return list;
    }
    
    public static ArrayList<String> getStringArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.addFirst("Pedro");
        list.addLast("Juan");
        list.add(1, "Marcos");
        list.addLast("Pepito");
        list.addFirst("Luis");
        
        return list;
    }
    
}
