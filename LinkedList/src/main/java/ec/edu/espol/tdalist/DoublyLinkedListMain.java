/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tdalist;

/**
 *
 * @author CltControl
 */
public class DoublyLinkedListMain {
    public static void main(String[] args) {
        
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.print();
        
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);
        list.addLast(4);
        
        list.add(2, 8);
        
        list.print();

    }
}
