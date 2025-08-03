/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.treejava;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
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
    
    public int countLeavesRecursive() {
        if (isEmpty()) {
            return 0;
        }
        
        if (isLeaf()) {
            return 1;
        }
        
        int leftLeaves = 0;
        int rightLeaves = 0;
        
        if (this.root.getLeft() != null) {
            leftLeaves = this.root.getLeft().countLeavesRecursive();
        }
        
        if (this.root.getRight() != null) {
            rightLeaves = this.root.getRight().countLeavesRecursive();
        }
        
        return leftLeaves + rightLeaves;
    }
    
    public int countLeavesIterative() {
        
        if (this.isEmpty()) {
            return 0;
        }
        
        int leaves = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        s.push(this);
        
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            
            if (tree.isLeaf()) {
                leaves++;
            }
            
            if (tree.getRoot().getLeft() != null) {
                s.push(tree.getRoot().getLeft());
            }
            
            if (tree.getRoot().getRight() != null) {
                s.push(tree.getRoot().getRight());
            }
        }
        
        return leaves;

    }
    
    /*
    TAREA BINARY TREE
    TUMBACO SANTANA GABRIEL ALEJANDRO
    PARALELO 1 - I PAO 2025
    */
    
    // Metodo 1 - CountDescendants
    
    public int countDescendantsRecursive() {
        if (isEmpty() || isLeaf()) {
            return 0;
        } 
        
        int leftCounter = 0;
        int rightCounter = 0;
        
        if (this.root.getLeft() != null) {
            leftCounter = 1 + this.root.getLeft().countDescendantsRecursive();
        }
        
        if (this.root.getRight() != null) {
            rightCounter = 1 + this.root.getRight().countDescendantsRecursive();
        }
        
        return leftCounter + rightCounter;    
    }
    
    public int countDescendantsIterative() {        
        if (isEmpty() || isLeaf()) {
            return 0;
        }
        
        int counter = 0;
        Stack<BinaryTree> s = new Stack<>();
        s.push(this);
        
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            
            if (tree != this) {
                counter++;
            }
            
            if (tree.getRoot().getLeft() != null) {
                s.push(tree.getRoot().getLeft());
            }
            
            if (tree.getRoot().getRight() != null) {
                s.push(tree.getRoot().getRight());
            }
            
        }
        
        return counter;
    }
    
    // Metodo 2 - FindParent
    // El método busca por referencias, no por valor
    // No se busca por valor con equals para evitar salidas inesperadas si hay nodos con el mismo contenido
    public NodeBinaryTree<E> findParentRecursive(NodeBinaryTree<E> node) {
        
        if (node == null || this.isEmpty() || this.isLeaf()) {
            return null;
        }
        
        // Validar que el node no sea la raiz del árbol principal
        // Para subarboles no habrá problemas con esta línea 
        if (node == this.root) {
            return null;
        }
        
        NodeBinaryTree<E> parent = null;
        BinaryTree<E> left = this.root.getLeft();
        BinaryTree<E> right = this.root.getRight();
        
        if (left != null && !left.isEmpty()) {
            if (left.getRoot() == node && parent == null) {
                parent = this.getRoot();
            } else if (parent == null) {
                parent = left.findParentRecursive(node);
            }
        }
        
        if (right != null && !right.isEmpty()) {
            if (right.getRoot() == node && parent == null) {
                parent = this.getRoot();
            } else if (parent == null) {
                parent = right.findParentRecursive(node);
            }
        }

        return parent;
    }
    
    public NodeBinaryTree<E> findParentIterative(NodeBinaryTree<E> node) {
        
        if (node == null || isEmpty() || isLeaf() || node == this.root) {
            return null;
        }
        
        Stack<BinaryTree<E>> s = new Stack<>();
        s.push(this);
        
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            
            if (tree.getRoot().getLeft() != null) {
                NodeBinaryTree<E> leftRoot = tree.getRoot().getLeft().getRoot();
                if (leftRoot == node) {
                    return tree.getRoot();
                } else {
                    s.push(tree.getRoot().getLeft());
   
                }
            }
            
            if (tree.getRoot().getRight() != null) {
                NodeBinaryTree<E> rightRoot = tree.getRoot().getRight().getRoot();
                if (rightRoot == node) {
                    return tree.getRoot();
                } else {
                    s.push(tree.getRoot().getRight());
   
                }
            }
        }
        
        return null;
    }
    
    // Método 3 - CountLevels
    
    public int countLevelsRecursive() {
        if (isEmpty()) {
            return 0;
        }
        
        if (isLeaf()) {
            return 1;
        }
        
        int leftLevels = 0;
        int rightLevels = 0;
        
        if (this.root.getLeft() != null) {
            leftLevels = this.root.getLeft().countLevelsRecursive();
        }
        
        if (this.root.getRight() != null) {
            rightLevels = this.root.getRight().countLevelsRecursive();
        }
        
        return 1 + Math.max(leftLevels, rightLevels);
    }
    
    // Recorrido en anchura (BFS) con cola
    public int countLevelsIterative() {
        if (isEmpty()) {
            return 0;
        }

        Queue<BinaryTree<E>> queue = new LinkedList<>();
        queue.add(this);
        int levels = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();  
            
            // procesa todos los nodos del nivel
            for (int i = 0; i < size; i++) {
                BinaryTree<E> tree = queue.poll();

                if (tree.getRoot().getLeft() != null) {
                    queue.add(tree.getRoot().getLeft());
                }
                if (tree.getRoot().getRight() != null) {
                    queue.add(tree.getRoot().getRight());
                }
            }

            levels++;
        }

        return levels;
    }
    
    // Método 4
    public boolean isLeftyRecursive() {
        if (isEmpty() || isLeaf()) {
            return true;
        }
        
        
        int totalDescendants = this.countDescendantsRecursive(); // sin la raiz
        int leftDescendants = 0;

        if (this.root.getLeft() != null) {
            leftDescendants = this.root.getLeft().countDescendantsRecursive() + 1; // todo los nodos del subarbol izquierdo
        }
        
        // se asume inicialmente que left y right son lefty
        // para evitar problemas si no hay hijo derecho o izquierdo
        
        boolean leftIsLefty = true;
        if (this.root.getLeft() != null) {
            leftIsLefty = this.root.getLeft().isLeftyRecursive();
        }

        boolean rightIsLefty = true;
        if (this.root.getRight() != null) {
            rightIsLefty = this.root.getRight().isLeftyRecursive();
        }

        return leftIsLefty && rightIsLefty && (leftDescendants > totalDescendants / 2);
    }
    
    public boolean isLeftyIterative() {
        if (isEmpty() || isLeaf()) {
            return true;
        }
        
        Queue<BinaryTree<E>> c = new LinkedList<>();
        c.add(this);
        
        while (!c.isEmpty()) {

            int size = c.size();
            
            for (int i = 0; i < size; i++) {
                BinaryTree<E> tree = c.poll();
                
                if (!tree.isLeaf()) {
                    int totalDescendants = tree.countDescendantsRecursive(); // sin la raiz
                    int leftDescendants = 0;

                    if (tree.root.getLeft() != null) {
                        leftDescendants = tree.root.getLeft().countDescendantsRecursive() + 1; // todo los nodos del subarbol izquierdo
                    }

                    if (leftDescendants <= totalDescendants / 2) {
                        return false;
                    }
                }
            
                if (tree.getRoot().getLeft() != null) {
                    c.add(tree.getRoot().getLeft());
                }

                if (tree.getRoot().getRight() != null) {
                    c.add(tree.getRoot().getRight());
                }
            }

        }
        
        return true;
    }
    
    // Método 5
    
    public boolean isIdenticalRecursive(BinaryTree<E> other) {
        if (other == null) {
           return false;
        }
        
        if (this.isEmpty() && other.isEmpty()) {
            return true;
        }   
        
        if (this.isLeaf() && other.isLeaf()) {
            return this.getRoot().getContent().equals(other.getRoot().getContent());
        }
        
        if (!this.getRoot().getContent().equals(other.getRoot().getContent())) {
            return false;
        }
        
        boolean leftIdentical = false;
        boolean rightIdentical = false;
        
        if (this.root.getLeft() == null && other.getRoot().getLeft() == null) {
            leftIdentical = true;
        } else if (this.root.getLeft() != null && other.root.getLeft() != null) {
            leftIdentical = this.root.getLeft().isIdenticalRecursive(other.getRoot().getLeft());
        } else {
            return false;
        }
        
        if (this.root.getRight() == null && other.getRoot().getRight() == null) {
            rightIdentical = true;
        } else if (this.root.getRight() != null && other.root.getRight() != null) {
            rightIdentical = this.root.getRight().isIdenticalRecursive(other.getRoot().getRight());
        } else {
            return false;
        }
       
        return leftIdentical && rightIdentical;
    }
    
    public boolean isIdenticalIterative(BinaryTree<E> other) {
        if (other == null) {
            return false;
        }
        
        if (this.isEmpty() && other.isEmpty()) {
            return true;
        }
        
        Queue<BinaryTree<E>> c1 = new LinkedList<>();
        Queue<BinaryTree<E>> c2 = new LinkedList<>();
        c1.add(this);
        c2.add(other);
        
        while (!c1.isEmpty() && !c2.isEmpty()) {
            int size = c1.size();
            
            for (int i = 0; i < size; i++) {
                BinaryTree<E> tree1 = c1.poll();
                BinaryTree<E> tree2 = c2.poll();
                
                if (tree2 == null) {
                    return false;
                }
                
                if (!tree1.getRoot().getContent().equals(tree2.getRoot().getContent())) {
                    return false;
                }
                
                if (tree1.getRoot().getLeft() != null) {
                    c1.add(tree1.getRoot().getLeft());
                }
                
                if (tree2.getRoot().getLeft() != null) {
                    c2.add(tree2.getRoot().getLeft());
                }
                
                if (tree1.getRoot().getRight() != null) {
                    c1.add(tree1.getRoot().getRight());
                }
                
                if (tree2.getRoot().getRight() != null) {
                    c2.add(tree2.getRoot().getRight());
                }
            }
        }
        
        // Verificacion final, las colas se vaciaron y no se encontró diferencias
        return c1.isEmpty() && c2.isEmpty();
    }
    
    // Método 6
    // Se usa un metodo generico para evitar problemas de casting a entero
    
    public void largestValueOfEachLevelRecursive(Comparator<E> cmp) {
        if (isEmpty()) return;
        System.out.println(this.root.getContent());
        
        List<NodeBinaryTree<E>> children = new ArrayList<>();
        
        if (this.root.getLeft() != null) {
            children.add(this.root.getLeft().getRoot());
        }
        
        if (this.root.getRight() != null) {
            children.add(this.root.getRight().getRoot());
        }
        
        largestValueOfEachLevelRecursive(cmp, children);
    }
    
    private void largestValueOfEachLevelRecursive(Comparator<E> cmp, List<NodeBinaryTree<E>> nodesLevel) {
        if (nodesLevel.isEmpty()) return;
        
        E max = nodesLevel.get(0).getContent();
        List<NodeBinaryTree<E>> children = new ArrayList<>();
        for (NodeBinaryTree<E> node: nodesLevel) {
            if (cmp.compare(max, node.getContent()) < 0) {
                max = node.getContent();
            }
            
            if (node.getLeft() != null) {
                children.add(node.getLeft().getRoot());
            }
            
            if (node.getRight() != null) {
                children.add(node.getRight().getRoot());
            }
        }
        
        System.out.println(max);
        largestValueOfEachLevelRecursive(cmp, children);
    }
    
    // Se usa un metodo generico para evitar problemas de casting a entero
    public void largestValueOfEachLevelIterative(Comparator<E> cmp) {
        
        if (isEmpty()) return;
        if (isLeaf()) {
            System.out.println(this.root.getContent());
            return;
        }

        Queue<BinaryTree<E>> c = new LinkedList<>();
        c.add(this);
        
        // Recorrido por niveles 
        while (!c.isEmpty()) {
            int size = c.size();
            E max = null;
            
            for (int i = 0; i < size; i++) {
                BinaryTree<E> tree = c.poll();
                E currentValue = tree.getRoot().getContent();
                
                if (max == null || cmp.compare(max, currentValue) < 0) {
                    max = currentValue;
                }
                
                if (tree.getRoot().getLeft() != null) {
                    c.add(tree.getRoot().getLeft());
                }
                
                if (tree.getRoot().getRight() != null) {
                    c.add(tree.getRoot().getRight());
                }
            }
            
            System.out.println(max);
        }
    }
    
    // Método 7
    
    public int countNodesWithOnlyChildRecursive() {
        if (isEmpty() || isLeaf()) {
            return 0;
        }
        
        if ((this.root.getLeft() != null && this.root.getRight() == null) || (this.root.getLeft() == null && this.root.getRight() != null)) {
            return 1;
        }
        
        int leftCounter = 0;
        int rightCounter = 0;
        
        if (this.root.getLeft() != null) {
            leftCounter = this.root.getLeft().countNodesWithOnlyChildRecursive();
        }
        
        if (this.root.getRight() != null) {
            rightCounter = this.root.getRight().countNodesWithOnlyChildRecursive();
        }
        
        return leftCounter + rightCounter;
    }
    
    public int countNodesWithOnlyChildIterative() {
        if (isEmpty() || isLeaf()) {
            return 0;
        }
        
        int counter = 0;
        Stack<BinaryTree<E>> s = new Stack<>();
        s.push(this);
        
        while (!s.isEmpty()) {
            BinaryTree<E> tree = s.pop();
            int children = 0;
            
            if (tree.root.getLeft() != null) {
                children++;
                s.push(tree.root.getLeft());
            }
            
            if (tree.root.getRight() != null) {
                children++;
                s.push(tree.root.getRight());
            }
            
            if (children == 1) {
                counter++;
            }
        }
        
        return counter;   
    }
    
    // Método 8
    
    public boolean isHeightBalancedRecursive() {
        if (isEmpty()) {
            return true;
        }
        
        int leftLevels = 0;
        int rightLevels = 0;
        
        if (this.root.getLeft() != null) {
            leftLevels = this.root.getLeft().countLevelsRecursive();
        }
        
        if (this.root.getRight() != null) {
            rightLevels = this.root.getRight().countLevelsRecursive();
        }
        
        boolean leftIsBalanced = true;
        if (this.root.getLeft() != null) {
            leftIsBalanced = this.root.getLeft().isHeightBalancedRecursive();
        }
        
        boolean rightIsBalanced = true;
        if (this.root.getRight() != null) {
            rightIsBalanced = this.root.getRight().isHeightBalancedRecursive();
        }
        
        return leftIsBalanced && rightIsBalanced && (Math.abs(leftLevels - rightLevels) <= 1);
    }
    
    public boolean isHeightBalancedIterative() {
        if (isEmpty()) {
            return true;
        }
        
        Queue<BinaryTree<E>> c = new LinkedList<>();
        c.add(this);
        
        while (!c.isEmpty()) {

            int size = c.size();
            
            for (int i = 0; i < size; i++) {
                BinaryTree<E> tree = c.poll();
                
                if (!tree.isLeaf()) {
                    int rightDescendants = 0;
                    int leftDescendants = 0;

                    if (tree.getRoot().getLeft() != null) {
                        leftDescendants = tree.root.getLeft().countLevelsRecursive();
                        c.add(tree.getRoot().getLeft());
                    }
                    
                    if (tree.getRoot().getRight() != null) {
                        rightDescendants = tree.root.getRight().countLevelsRecursive();
                        c.add(tree.getRoot().getRight());
                    }
                    
                    // Busco si algún subárbol está desbalanceado, y si lo encuentro retorno falso
                    if (Math.abs(leftDescendants - rightDescendants) > 1) {
                        return false;
                    }
                }
            }

        }
        
        // no encontré árbol desbalanceado
        return true;
    }
    
    // Imprime árboles en formato amigable
    public void printTree() {
        System.out.println();
        printTree("", this, false);
    }

    private void printTree(String prefix, BinaryTree<E> tree, boolean isLeft) {
        if (tree == null || tree.isEmpty()) {
            return;
        }

        System.out.println(prefix + (isLeft ? "├── " : "└── ") + tree.getRoot().getContent());

        BinaryTree<E> left = tree.getRoot().getLeft();
        BinaryTree<E> right = tree.getRoot().getRight();

        if (left != null || right != null) {
            printTree(prefix + (isLeft ? "│   " : "    "), right, false);
            printTree(prefix + (isLeft ? "│   " : "    "), left, true);
        }
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