/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.treejava;

/**
 *
 * @author gatumbac
 */
public class NodeBinaryTree<E> {
    private E content;
    private BinaryTree<E> left;
    private BinaryTree<E> right;
    
    public NodeBinaryTree() {
        this.content = null;
        this.left = null;
        this.right = null;
    }
    
    public NodeBinaryTree(E content) {
        this.content = content;
        this.left = null;
        this.right = null;
    }

    public E getContent() {
        return content;
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public void setLeft(BinaryTree<E> left) {
        this.left = left;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
    }
    
}
