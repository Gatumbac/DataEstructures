/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.treejava;
import java.util.LinkedList;

/**
 *
 * @author gatumbac
 */
public class NodeTree<E> {
    private E content;
    private LinkedList<Tree<E>> children;
    
    public NodeTree() {
        this.content = null;
        this.children = new LinkedList<>();
    }
    
    public NodeTree(E content) {
        this.content = content;
        this.children = new LinkedList<>();
    }

    public E getContent() {
        return content;
    }

    public LinkedList<Tree<E>> getChildren() {
        return children;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public void setChildren(LinkedList<Tree<E>> children) {
        this.children = children;
    }
    
    public void addChild(Tree<E> child) {
        this.children.add(child);
    }
    
}
