/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.tdalist;

/**
 *
 * @author gatumbac
 */
public class ArrayListMain {
    
    public static void main(String[] args) {

        ArrayList<String> arr1 = new ArrayList<>();
        //System.out.println(arr1.size());
        arr1.addLast("Hola");
        arr1.addFirst("Primer elemento");
        arr1.add(1, "Segundo elemento");
        
        //arr1.removeFirst();
        //arr1.removeLast();
        //arr1.remove(1);

        arr1.print();
        arr1.set(1, "Elemento 2");
        String element = arr1.get(1);
        
        System.out.println(element);
        System.out.println(arr1.size());

    }

}
