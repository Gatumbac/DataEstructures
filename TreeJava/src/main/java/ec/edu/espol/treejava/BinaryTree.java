/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.treejava;

/**
 *
 * @author gatumbac
 */
public class BinaryTree<E> {
    private NodeBinaryTree<E> root;
    
    public BinaryTree() {
        this.root = null;
    }
    
    public BinaryTree(NodeBinaryTree<E> root) {
        this.root = root;
    }
    
    public BinaryTree(E content) {
        this.root = new NodeBinaryTree(content);
    }

    public NodeBinaryTree<E> getRoot() {
        return root;
    }

    public void setRoot(NodeBinaryTree<E> root) {
        this.root = root;
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public boolean isLeaf() {
        if (!isEmpty()) {
            return this.root.getLeft() == null && this.root.getRight() == null;
        }
        
        return false;
    }
    
    public void recorrerPreorden() {
        if (isEmpty()) {
            return;
        }
        
        System.out.println(root.getContent());
        
        if (root.getLeft() != null) {
            root.getLeft().recorrerPreorden();
        }
        
        if (root.getRight() != null) {
            root.getRight().recorrerPreorden();
        }
    }
    
    public void recorrerEntreorden() {
        if (isEmpty()) {
            return;
        }
        
        if (root.getLeft() != null) {
            root.getLeft().recorrerEntreorden();
        }
        
        System.out.println(root.getContent());
        
        if (root.getRight() != null) {
            root.getRight().recorrerEntreorden();
        }
    }
    
    public void recorrerPostorden() {
        if (isEmpty()) {
            return;
        }
        
        if (root.getLeft() != null) {
            root.getLeft().recorrerPostorden();
        }
        
        if (root.getRight() != null) {
            root.getRight().recorrerPostorden();
        }
        
        System.out.println(root.getContent());
    }
}