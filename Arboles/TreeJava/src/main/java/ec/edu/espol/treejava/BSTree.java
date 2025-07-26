/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.treejava;
import java.util.Comparator;

/**
 *
 * @author gatumbac
 */
public class BSTree<E, K> {
    private BSTNode<E, K> root;
    private Comparator<K> cmp;
    
    public BSTree(Comparator<K> cmp) {
        this.root = null;
        this.cmp = cmp;
    }
    
    public BSTree(BSTNode<E, K> root, Comparator<K> cmp) {
        this.root = root;
        this.cmp = cmp;
    }

    public BSTNode<E, K> getRoot() {
        return root;
    }

    public void setRoot(BSTNode<E, K> root) {
        this.root = root;
    }

    public Comparator<K> getCmp() {
        return cmp;
    }

    public void setCmp(Comparator<K> cmp) {
        this.cmp = cmp;
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
    
    // Imprimir el ABB en formato amigable
    public void printTree() {
        System.out.println();
        printTree("", this, false);
    }

    private void printTree(String prefix, BSTree<E, K> tree, boolean isLeft) {
        if (tree == null || tree.isEmpty()) {
            return;
        }

        System.out.println(prefix + (isLeft ? "├── " : "└── ") + tree.getRoot().getKey());

        BSTree<E, K> left = tree.getRoot().getLeft();
        BSTree<E, K> right = tree.getRoot().getRight();

        if ((left != null && !left.isEmpty()) || (right != null && !right.isEmpty())) {
            printTree(prefix + (isLeft ? "│   " : "    "), right, false);
            printTree(prefix + (isLeft ? "│   " : "    "), left, true);
        }
    }

    public void inOrder() {
        if (isEmpty()) {
            return;
        }
   
        if (root.getLeft() != null) {
            root.getLeft().inOrder();
        }
        
        System.out.println(root.getContent());
        
        if (root.getRight() != null) {
            root.getRight().inOrder();
        }
    }
    
    public boolean insert(E content, K key) {
        BSTNode<E, K> node = new BSTNode<>(content, key);
        if (this.isEmpty()) {
            this.setRoot(node);
            return true;
        }
        
        int cmpResult = this.cmp.compare(key, this.root.getKey());
        
        if (cmpResult < 0) {
            if (this.root.getLeft() != null) {
                return this.root.getLeft().insert(content, key);
            } else {
                this.root.setLeft(new BSTree<>(node, this.cmp));
                return true;
            }
        }
        
        if (cmpResult > 0) {
            if (this.root.getRight() != null) {
                return this.root.getRight().insert(content, key);
            } else {
                this.root.setRight(new BSTree<>(node, this.cmp));
                return true;
            }
        }
        
        return false;
    }
    
    public E find(K key) {
        if (this.isEmpty()) {
            return null;
        }
        
        int cmpResult = this.cmp.compare(key, this.root.getKey());
        
        if (cmpResult == 0) {
            return this.root.getContent();
        }
        
        if (cmpResult < 0 && this.root.getLeft() != null) {
            return this.root.getLeft().find(key);
        }
        
        if (cmpResult > 0 && this.root.getRight() != null) {
            return this.root.getRight().find(key);
        }
        
        return null;
    }
    
    public boolean delete(K key) {
        if (this.isEmpty()) {
            return false;
        }
        
        int cmpResult = this.cmp.compare(key, this.root.getKey());
        
        if (this.isLeaf() && cmpResult == 0) {
            this.setRoot(null);
            return true;
        } 
        
        if (cmpResult == 0) {
            if (this.hasOnlyChild()) {
                BSTree<E, K> child = (this.root.getLeft() != null) ? this.root.getLeft() : this.root.getRight();
                this.setRoot(child.getRoot()); 
            } else {
                BSTree<E, K> maxLeft = this.findLeftMax();
                this.swapData(maxLeft);
            }

            return true;
        }
        
        if (cmpResult < 0 && this.root.getLeft() != null) {
            return this.root.getLeft().delete(key);
        }
        
        if (cmpResult > 0 && this.root.getRight() != null) {
            return this.root.getRight().delete(key);
        }
        
        return false;
        
    }
    
    public boolean hasOnlyChild() {
        return (this.root.getLeft() == null && this.root.getRight() != null) || (this.root.getRight() == null && this.root.getLeft() != null);
    }
    
    private BSTree<E, K> findLeftMax() {
        BSTree<E, K> parent = this;
        BSTree<E, K> current = this.root.getLeft();
        
        // Buscamos la mayor de las claves del subarbol izquierdo
        while (current.getRoot().getRight() != null) {
            parent = current;
            current = current.getRoot().getRight();
        }
        
        // No se entró al bucle, verificamos si el hijo izquierdo no tiene hijos
        if (parent == this && current.isLeaf()) {
            this.root.setLeft(null);
            return current;
        }
        
        // Si encontró un nodo distinto al hijo izquierdo - Reestructuración del árbol
        if (current.getRoot().getLeft() != null) {
            current.setRoot(current.getRoot().getLeft().getRoot());
        } else { 
            parent.getRoot().setRight(null);
        }
        
        return current;
    }

    private void swapData(BSTree<E, K> child) {
        this.root.setContent(child.getRoot().getContent());
        this.root.setKey(child.getRoot().getKey());
    }
    
    
    
    
}
