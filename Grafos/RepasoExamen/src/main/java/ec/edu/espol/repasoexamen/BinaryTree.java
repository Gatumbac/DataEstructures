/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.repasoexamen;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author gabriel
 */
public class BinaryTree<E> {
    NodeBinaryTree<E> root;
    
    public BinaryTree() { }

    public BinaryTree(E root) {
        this.root = new NodeBinaryTree<>(root);
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
        if (this.isEmpty()) return false;
        return this.root.getLeft() == null && this.root.getRight() == null;
    }
    
    public void preOrder() {
        if (this.isEmpty()) return;
        System.out.println(this.root.getContent());
        if (this.root.getLeft() != null) {
            this.root.getLeft().preOrder();
        }
        if (this.root.getRight() != null) {
            this.root.getRight().preOrder();
        }
    }
    
    public void inOrder() {
        if (this.isEmpty()) return;
        if (this.root.getLeft() != null) {
            this.root.getLeft().inOrder();
        }
        System.out.println(this.root.getContent());
        if (this.root.getRight() != null) {
            this.root.getRight().inOrder();
        }
    }
    
    public void postOrder() {
        if (this.isEmpty()) return;
        if (this.root.getLeft() != null) {
            this.root.getLeft().postOrder();
        }
        if (this.root.getRight() != null) {
            this.root.getRight().postOrder();
        }
        System.out.println(this.root.getContent());
    }
    
    public int countNodes() {
        if (this.isEmpty()) return 0;
        if (this.isLeaf()) return 1;
        int leftNodes = 0;
        int rightNodes = 0;
        
        if (this.root.getLeft() != null) {
            leftNodes = this.root.getLeft().countNodes();
        }
        
        if (this.root.getRight() != null) {
            rightNodes = this.root.getRight().countNodes();
        }
        
        return 1 + (leftNodes + rightNodes);
    }
    
    public int countLeaves() {
        if (this.isEmpty()) return 0;
        if (this.isLeaf()) return 1;
        
        int counter = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        s.push(this);
        
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            if (tree.isLeaf()) counter++;
            if (tree.getRoot().getLeft() != null) {
                s.push(tree.getRoot().getLeft());
            }
            if (tree.getRoot().getRight() != null) {
                s.push(tree.getRoot().getRight());
            }
        }
        
        return counter;
    }
    
    public int countLevels() {
        if (this.isEmpty()) return 0;
        if (this.isLeaf()) return 1;
        
        int leftLevels = 0;
        int rightLevels = 0;
        
        if (this.root.getLeft() != null) {
            leftLevels = this.root.getLeft().countLevels();
        }
        
        if (this.root.getRight() != null) {
            rightLevels = this.root.getRight().countLevels();
        }
        
        return 1 + Math.max(leftLevels, rightLevels);
    }
    
    public int countLevelsIterative() {
        if (this.isEmpty()) return 0;
        if (this.isLeaf()) return 1;
        
        int counter = 0;
        Queue<BinaryTree<E>> q = new LinkedList<>();
        q.offer(this);
        
        while (!q.isEmpty()) {
            int size = q.size();
            counter++;
            for (int i = 0; i < size; i++) {
                BinaryTree<E> tree = q.poll();
                if (tree.getRoot().getLeft() != null) {
                    q.offer(tree.getRoot().getLeft());
                }
                if (tree.getRoot().getRight() != null) {
                    q.offer(tree.getRoot().getRight());
                }
            }
        }
        
        return counter;
    }
    
    public boolean areCousins(E v1, E v2) {
        if (this.isEmpty() || this.isLeaf() || v1.equals(v2)) return false;
        Queue<BinaryTree<E>> q = new LinkedList<>();
        q.offer(this);
        
        while (!q.isEmpty()) {
            int size = q.size();
            NodeBinaryTree<E> p1 = null;
            NodeBinaryTree<E> p2 = null;
            
            boolean v1Found = false;
            boolean v2Found = false;
            
            for (int i = 0; i < size; i++) { // for each node in this level
                BinaryTree<E> tree = q.poll();
                BinaryTree<E> left = tree.getRoot().getLeft();
                BinaryTree<E> right = tree.getRoot().getRight();
                
                if (left != null) {
                    if (left.getRoot().getContent().equals(v1)) {
                        v1Found = true;
                        p1 = tree.getRoot();
                    } else if (left.getRoot().getContent().equals(v2)) {
                        v2Found = true;
                        p2 = tree.getRoot();
                    }
                    q.offer(left);
                }
                
                if (right != null) {
                    if (right.getRoot().getContent().equals(v1)) {
                        v1Found = true;
                        p1 = tree.getRoot();
                    } else if (right.getRoot().getContent().equals(v2)) {
                        v2Found = true;
                        p2 = tree.getRoot();
                    }
                    q.offer(right);
                }
            }
            
            if ((v1Found && !v2Found) || (v2Found && !v1Found)) return false;
            if (v1Found && v2Found) {
                return p1 != p2;
            }
        }
        
        return false;
    }
    
    public boolean isSumTree() {
        if (this.isEmpty()) return false;
        if (this.isLeaf()) return true;
        
        int leftSum = 0;
        int rightSum = 0;
        boolean leftIsSum = true;
        boolean rightIsSum = true;

        if (this.root.getLeft() != null) {
            leftSum = this.root.getLeft().getCummulativeSum();
            leftIsSum = this.root.getLeft().isSumTree();
        }

        if (this.root.getRight() != null) {
            rightSum = this.root.getRight().getCummulativeSum();
            rightIsSum = this.root.getRight().isSumTree();
        }

        return leftIsSum && rightIsSum && ((leftSum + rightSum) == (int) this.root.getContent());
    }

    private int getCummulativeSum() {
        if (this.isEmpty()) return 0;

        int leftSum = 0;
        int rightSum = 0;

        if (this.root.getLeft() != null) {
            leftSum = this.root.getLeft().getCummulativeSum();
        }

        if (this.root.getRight() != null) {
            rightSum = this.root.getRight().getCummulativeSum();
        }

        return (int) this.root.getContent() + leftSum + rightSum; 
    }
    
    public static BinaryTree<String> buildExpressionTree(String posFixExp) {
        if (posFixExp == null || posFixExp.length() == 0) {
            return new BinaryTree<>();
        }
        
        String[] array = posFixExp.split(" ");
        Stack<BinaryTree<String>> s = new Stack<>();
        for (String c: array) {
            BinaryTree<String> current = new BinaryTree<>(c);
            if (isOperator(c)) {
                if (!s.isEmpty()) {
                    current.getRoot().setRight(s.pop());
                }
                if (!s.isEmpty()) {
                    current.getRoot().setLeft(s.pop());
                }
            }
            s.push(current);
        }
        
        if (!s.isEmpty()) {
            return s.pop();
        }
        return new BinaryTree<>(); // if something wrong
    }
    
    public static boolean isOperator(String op) {
        if (op == null || op.length() == 0) return false;
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }
    
    public static int evaluateExpressionTree(BinaryTree<String> expTree) {
        if (expTree.isEmpty()) return 0;
        if (expTree.isLeaf()) return Integer.parseInt(expTree.getRoot().getContent());
        
        String op = expTree.getRoot().getContent();
        int leftResult = 0;
        int rightResult = 0;
        
        if (expTree.getRoot().getLeft() != null) {
            leftResult = evaluateExpressionTree(expTree.getRoot().getLeft());
        }
        
        if (expTree.getRoot().getRight() != null) {
            rightResult = evaluateExpressionTree(expTree.getRoot().getRight());
        }
        
        return getResult(op, leftResult, rightResult);
    }
    
    public static int getResult(String op, int i1, int i2) {
        switch (op) {
            case "+":
                return i1 + i2;
            case "-":
                return i1 - i2;
            case "*":
                return i1*i2;
            case "/":
                return i2 != 0 ? i1/i2 : 0;
            default: return 0;
        }
    }

}
