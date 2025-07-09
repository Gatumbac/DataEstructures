package linkedlist;

/**
 * Clase: CircularNodeList simplemente enlazada
 * Profesora: Adriana Collaguazo
 */
public class CircularNodeList<E> {
    private E content;
    private CircularNodeList<E> next;
    
    public CircularNodeList(E content){
        this.content=content;
        this.next=this; // Instancia de un nodo el next ya no apunta a null sino a si mismo
    }
    
    public E getContent(){
        return content;
    }
    
    public void setContent(E content){
        this.content = content;
    }
    
    public CircularNodeList<E> getNext(){
        return next;
    }
    
    public void setNext(CircularNodeList<E> next){
        this.next = next;
    }
}
