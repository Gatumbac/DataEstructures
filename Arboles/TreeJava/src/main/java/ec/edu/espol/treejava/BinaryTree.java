/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.treejava;

import java.util.Stack;
import java.util.Map;

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
    
    public static BinaryTree<String> buildExpressionTree(String expression) {
        Stack<BinaryTree<String>> s = new Stack<>();
        String[] tokens = expression.split(" ");
        
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            BinaryTree<String> t = new BinaryTree<>(token);
            if (isOperator(token)) {
                if (!s.isEmpty()) {
                    t.getRoot().setRight(s.pop());
                }
                if (!s.isEmpty()) {
                    t.getRoot().setLeft(s.pop());
                }
            }
            s.push(t);
        }
        return s.pop();
    }
    
    private static boolean isOperator(String token) {
        if (token.isEmpty()) {
            return false;
        }
        Character ch = token.charAt(0);
        Character[] operators = {'+', '-', '*', '/'};
        
        for (Character op: operators) {
            if (op.equals(ch)) {
                return true;
            }
        }
        return false;
    }
    
    public static double evaluateExpressionTree(BinaryTree<String> tree, Map<String, Double> vars) {
        if (tree == null || tree.isEmpty()) {
            return 0;
        }

        String value = tree.getRoot().getContent();

        if (tree.isLeaf()) {
            // Se busca en el mapa el valor de la variable
            if (vars.containsKey(value)) {
                return vars.get(value);
            } else { 
                return Double.parseDouble(value);
            }
        }
        
        double left = 0;
        double right = 0;
        
        if (tree.getRoot().getLeft() != null) {
            left = evaluateExpressionTree(tree.getRoot().getLeft(), vars);
        }
        
        if (tree.getRoot().getRight() != null) {
            right = evaluateExpressionTree(tree.getRoot().getRight(), vars);
        }

        return operate(value, left, right);
    }
    
    private static double operate(String operator, double leftValue, double rightValue) {
        switch(operator){
            case "+": return leftValue + rightValue;
            case "-": return leftValue - rightValue;
            case "*": return leftValue * rightValue;
            case "/": return rightValue != 0 ? leftValue / rightValue : 0;
            default: return 0;
        }
    }
}