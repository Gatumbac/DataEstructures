/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.treejava;

/**
 *
 * @author gatumbac
 */
public class PathNode<E, K> {
    private BSTree<E, K> node;
    private boolean wentRight;

    public PathNode(BSTree<E, K> node, boolean wentLeft) {
        this.node = node;
        this.wentRight = wentLeft;
    }

    public BSTree<E, K> getNode() {
        return node;
    }

    public void setNode(BSTree<E, K> node) {
        this.node = node;
    }

    public boolean isWentRight() {
        return wentRight;
    }

    public void setWentRight(boolean wentRight) {
        this.wentRight = wentRight;
    }
    
}
