/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.tareabinarytree;

/**
 *
 * @author gatumbac
 */
public class TareaBinaryTree {

    public static void main(String[] args) {
        System.out.println("\nTarea Binary Tree | Gabriel Tumbaco Santana | P1\n");
        
        BinaryTree<Character> biTree = getBinaryTree1();
        BinaryTree<Character> biTree2 = getBinaryTree1();
        BinaryTree<Character> biTreeLefty = getBinaryTreeLefty();
        BinaryTree<Integer> biTreeInt = getBinaryTreeInteger();
        BinaryTree<Integer> disbalancedTree = getBinaryTreeDisbalanced();
        
        // Método 1 - CountDescendants
        
        System.out.println("\nMétodo 1 - CountDescendants");
        biTree.printTree();
        System.out.println("Descendientes recursivo: " + biTree.countDescendantsRecursive());
        System.out.println("Descendientes iterativo: " + biTree.countDescendantsIterative());
        
        // Metodo 2 - FindParent
        
        System.out.println("\nMétodo 2 - FindParent");
        biTree.printTree();
        NodeBinaryTree<Character> node = biTree.getRoot().getLeft().getRoot().getLeft().getRoot();
        System.out.println("Nodo: " + node);
        System.out.println("Parent Recursivo: " + biTree.findParentRecursive(node));
        System.out.println("Parent Iterativo: " + biTree.findParentIterative(node));
        
        // Metodo 3 - CountLevels
        
        System.out.println("\nMétodo 3 - CountLevels");
        biTreeInt.printTree();
        System.out.println("Niveles recursivo: " + biTreeInt.countLevelsRecursive());
        System.out.println("Niveles iterativo: " + biTreeInt.countLevelsIterative());
        
        // Método 4 - IsLefty
        
        System.out.println("\nMétodo 4 - IsLefty");
        biTree.printTree();
        System.out.println("isLefty Recursivo: " + biTree.isLeftyRecursive());
        System.out.println("isLefty Iterativo: " + biTree.isLeftyIterative());
        
        biTreeLefty.printTree();
        System.out.println("isLefty Recursivo: " + biTreeLefty.isLeftyRecursive());
        System.out.println("isLefty Iterativo: " + biTreeLefty.isLeftyIterative());
        
        // Metodo 5 - IsIdentical
        
        System.out.println("\nMétodo 5 - IsIdentical");
        System.out.println("Árboles a comparar:");
        biTree.printTree();
        biTree2.printTree();
        
        System.out.println("Identico Recursivo: " + biTree.isIdenticalRecursive(biTree2));
        System.out.println("Identico Iterativo: " + biTree.isIdenticalIterative(biTree2));
        
        System.out.println("\nÁrboles a comparar:");
        biTree.printTree();
        biTreeLefty.printTree();
        
        System.out.println("Identico Recursivo: " + biTree.isIdenticalRecursive(biTreeLefty));
        System.out.println("Identico Iterativo: " + biTree.isIdenticalIterative(biTreeLefty));
        
        // Método 6 - LargestValueOfEachLevel
        
        System.out.println("\nMétodo 6 - LargestValueOfEachLevel");
        biTreeInt.printTree();
        System.out.println("\nSalida Recursiva:");
        biTreeInt.largestValueOfEachLevelRecursive((Integer i1, Integer i2) -> i1 - i2);
        
        System.out.println("\nSalida Iterativa:");
        biTreeInt.largestValueOfEachLevelIterative((Integer i1, Integer i2) -> i1 - i2);
        
        biTree.printTree();
        System.out.println("\nSalida Recursiva:");
        biTree.largestValueOfEachLevelRecursive((Character ch1, Character ch2) -> Character.compare(ch1, ch2));
        
        System.out.println("\nSalida Iterativa:");
        biTree.largestValueOfEachLevelIterative((Character ch1, Character ch2) -> Character.compare(ch1, ch2));
        
        // Método 7 - CountNodesWithOnlyChild
        
        System.out.println("\nMétodo 7 - CountNodesWithOnlyChild");
        biTreeLefty.printTree();
        System.out.println("Nodos con un solo hijo Recursivo: " + biTreeLefty.countNodesWithOnlyChildRecursive());
        System.out.println("Nodos con un solo hijo Iterativo: " + biTreeLefty.countNodesWithOnlyChildIterative());
        
        biTreeInt.printTree();
        System.out.println("Nodos con un solo hijo Recursivo: " + biTreeInt.countNodesWithOnlyChildRecursive());
        System.out.println("Nodos con un solo hijo Iterativo: " + biTreeInt.countNodesWithOnlyChildIterative());

        // Método 8 - IsHeightBalanced
        
        System.out.println("\nMétodo 8 - IsHeightBalanced");
        biTreeLefty.printTree();
        System.out.println("Balanceado Recursivo: " + biTreeLefty.isHeightBalancedRecursive());
        System.out.println("Balanceado Iterativo: " + biTreeLefty.isHeightBalancedIterative());
        
        disbalancedTree.printTree();
        System.out.println("Balanceado Recursivo: " + disbalancedTree.isHeightBalancedRecursive());
        System.out.println("Balanceado Iterativo: " + disbalancedTree.isHeightBalancedIterative());
        
    }
    
    private static BinaryTree<Character> getBinaryTree1() {
        
        BinaryTree<Character> biTree = new BinaryTree<>();
        biTree.setRoot(new NodeBinaryTree<>('A'));

        BinaryTree<Character> biTreeB = new BinaryTree<>();
        biTreeB.setRoot(new NodeBinaryTree<>('B'));

        BinaryTree<Character> biTreeD = new BinaryTree<>();
        biTreeD.setRoot(new NodeBinaryTree<>('D'));

        BinaryTree<Character> biTreeE = new BinaryTree<>();
        biTreeE.setRoot(new NodeBinaryTree<>('E'));

        biTreeB.getRoot().setLeft(biTreeD);
        biTreeB.getRoot().setRight(biTreeE);

        BinaryTree<Character> biTreeC = new BinaryTree<>();
        biTreeC.setRoot(new NodeBinaryTree<>('C'));

        BinaryTree<Character> biTreeF = new BinaryTree<>();
        biTreeF.setRoot(new NodeBinaryTree<>('F'));

        biTreeC.getRoot().setLeft(biTreeF);

        biTree.getRoot().setLeft(biTreeB);
        biTree.getRoot().setRight(biTreeC);
        
        return biTree;
    }
    
    private static BinaryTree<Integer> getBinaryTreeInteger() {
        BinaryTree<Integer> intTree = new BinaryTree<>();
        intTree.setRoot(new NodeBinaryTree<>(10));

        BinaryTree<Integer> intTreeLeft = new BinaryTree<>();
        intTreeLeft.setRoot(new NodeBinaryTree<>(5));

        BinaryTree<Integer> intTreeLeftLeft = new BinaryTree<>();
        intTreeLeftLeft.setRoot(new NodeBinaryTree<>(3));

        BinaryTree<Integer> intTreeLeftRight = new BinaryTree<>();
        intTreeLeftRight.setRoot(new NodeBinaryTree<>(7));

        intTreeLeft.getRoot().setLeft(intTreeLeftLeft);
        intTreeLeft.getRoot().setRight(intTreeLeftRight);

        BinaryTree<Integer> intTreeRight = new BinaryTree<>();
        intTreeRight.setRoot(new NodeBinaryTree<>(15));

        BinaryTree<Integer> intTreeRightLeft = new BinaryTree<>();
        intTreeRightLeft.setRoot(new NodeBinaryTree<>(12));

        BinaryTree<Integer> intTreeRightRight = new BinaryTree<>();
        intTreeRightRight.setRoot(new NodeBinaryTree<>(20));

        intTreeRight.getRoot().setLeft(intTreeRightLeft);
        intTreeRight.getRoot().setRight(intTreeRightRight);

        intTree.getRoot().setLeft(intTreeLeft);
        intTree.getRoot().setRight(intTreeRight);

        return intTree;
    }
    
    private static BinaryTree<Integer> getBinaryTreeDisbalanced() {
        BinaryTree<Integer> tree = new BinaryTree(0);
        tree.getRoot().setLeft(new BinaryTree(1));
        tree.getRoot().setRight(new BinaryTree(2));
        tree.getRoot().getLeft().getRoot().setLeft(new BinaryTree(3));
        tree.getRoot().getLeft().getRoot().setRight(new BinaryTree(4));
        tree.getRoot().getRight().getRoot().setLeft(new BinaryTree(5));
        tree.getRoot().getRight().getRoot().setRight(new BinaryTree(6));
        tree.getRoot().getRight().getRoot().getRight().getRoot().setRight(new BinaryTree(7));
        tree.getRoot().getRight().getRoot().getRight().getRoot().getRight().getRoot().setRight(new BinaryTree(8));
        return tree;
    }

    private static BinaryTree<Character> getBinaryTreeLefty() {
        
        BinaryTree<Character> biTree = new BinaryTree<>();
        biTree.setRoot(new NodeBinaryTree<>('A'));

        BinaryTree<Character> biTreeB = new BinaryTree<>();
        biTreeB.setRoot(new NodeBinaryTree<>('B'));

        BinaryTree<Character> biTreeD = new BinaryTree<>();
        biTreeD.setRoot(new NodeBinaryTree<>('D'));

        biTreeB.getRoot().setLeft(biTreeD);

        BinaryTree<Character> biTreeC = new BinaryTree<>();
        biTreeC.setRoot(new NodeBinaryTree<>('C'));

        biTree.getRoot().setLeft(biTreeB);
        biTree.getRoot().setRight(biTreeC);
        
        return biTree;
    }

}
