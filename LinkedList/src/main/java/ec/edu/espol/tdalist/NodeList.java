package ec.edu.espol.tdalist;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gatumbac
 */
public class NodeList<E> {
    private E content;
    private NodeList<E> next;
    
    public NodeList(E content) {
        this.content = content;
        this.next = null;
    }
    
    public E getContent() {
        return this.content;
    }
    
    public void setContent(E content) {
        this.content = content;
    }
    
    public NodeList<E> getNext() {
        return this.next;
    }
    
    public void setNext(NodeList<E> next) {
        this.next = next;
    }
   
}
