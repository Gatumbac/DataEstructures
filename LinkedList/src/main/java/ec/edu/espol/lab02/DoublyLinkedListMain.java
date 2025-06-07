/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.lab02;

/**
 *
 * @author gatumbac
 */
public class DoublyLinkedListMain {
    public static void main(String[] args) {
        
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        
        list.add(2, 8);
        
        System.out.println(list.toString());
        
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();
        list2.travelBackwards();
        list.travelBackwards();
    }
}
