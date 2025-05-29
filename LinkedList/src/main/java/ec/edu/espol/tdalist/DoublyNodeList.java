package ec.edu.espol.tdalist;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gatumbac
 */
public class DoublyNodeList<E> {
    private E content;
    private DoublyNodeList<E> next;
    private DoublyNodeList<E> previous;

    
    public DoublyNodeList(E content) {
        this.content = content;
        this.next = null;
        this.previous = null;
    }
    
    public E getContent() {
        return this.content;
    }
    
    public void setContent(E content) {
        this.content = content;
    }
    
    public DoublyNodeList<E> getNext() {
        return this.next;
    }
    
    public void setNext(DoublyNodeList<E> next) {
        this.next = next;
    }
    
    public DoublyNodeList<E> getPrevious() {
        return this.previous;
    }
    
    public void setPrevious(DoublyNodeList<E> previous) {
        this.previous = previous;
    }
   
}
