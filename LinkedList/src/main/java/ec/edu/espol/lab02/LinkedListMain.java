/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.lab02;

/**
 *
 * @author CltControl
 */
public class LinkedListMain {
    public static void main(String[] args) {
        
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        
        list.add(4, 50);
        
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        
        list.travelBackwards();

    }
}
