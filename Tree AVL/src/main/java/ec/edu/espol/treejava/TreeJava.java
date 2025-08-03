/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.treejava;
/**
 *
 * @author gatumbac
 */
public class TreeJava {

    public static void main(String[] args) {
        System.out.println("\nLaboratorio 7 - Arboles Balanceados - Gabriel Tumbaco Santana P1\n");
        rightRotationExample();
        leftRotationExample();
        leftRightRotationExample();
        rightLeftRotationExample();
        completeInsertionExample();
    }
    
    private static void rightRotationExample() {
        System.out.println("\nInsercion LL - Rotacion a la derecha");
        BSTree<Integer, Integer> tree1 = new BSTree<>((Integer i1, Integer i2) -> i1 - i2);
        BSTree<Integer, Integer> tree2 = new BSTree<>((Integer i1, Integer i2) -> i1 - i2);
        
        tree1.insertToAVL(30, 30);
        tree2.insert(30, 30);
        tree1.insertToAVL(20, 20);
        tree2.insert(20, 20);
        tree1.insertToAVL(10, 10);
        tree2.insert(10, 10);
        
        tree2.printTree();
        tree1.printTree();
    }
    
    private static void leftRotationExample() {
        System.out.println("\nInsercion RR - Rotacion a la izquierda");
        BSTree<Integer, Integer> tree1 = new BSTree<>((Integer i1, Integer i2) -> i1 - i2);
        BSTree<Integer, Integer> tree2 = new BSTree<>((Integer i1, Integer i2) -> i1 - i2);
        
        tree1.insertToAVL(10, 10);
        tree2.insert(10, 10);
        tree1.insertToAVL(20, 20);
        tree2.insert(20, 20);
        tree1.insertToAVL(30, 30);
        tree2.insert(30, 30);
        
        tree2.printTree();
        tree1.printTree();
    }
    
    private static void leftRightRotationExample() {
        System.out.println("\nInsercion LR - Rotacion izquierda derecha (desde abajo)");
        BSTree<Integer, Integer> tree1 = new BSTree<>((Integer i1, Integer i2) -> i1 - i2);
        BSTree<Integer, Integer> tree2 = new BSTree<>((Integer i1, Integer i2) -> i1 - i2);
        
        tree1.insertToAVL(30, 30);
        tree2.insert(30, 30);
        tree1.insertToAVL(10, 10);
        tree2.insert(10, 10);
        tree1.insertToAVL(20, 20);
        tree2.insert(20, 20);

        tree2.printTree();
        tree1.printTree();
    }
    
    private static void rightLeftRotationExample() {
        System.out.println("\nInsercion RL - Rotacion derecha izquierda (desde abajo)");
        BSTree<Integer, Integer> tree1 = new BSTree<>((Integer i1, Integer i2) -> i1 - i2);
        BSTree<Integer, Integer> tree2 = new BSTree<>((Integer i1, Integer i2) -> i1 - i2);
        
        tree1.insertToAVL(10, 10);
        tree2.insert(10, 10);
        tree1.insertToAVL(30, 30);
        tree2.insert(30, 30);
        tree1.insertToAVL(20, 20);
        tree2.insert(20, 20);

        tree2.printTree();
        tree1.printTree();
    }
    
    private static void completeInsertionExample() {
        System.out.println("\nEjemplo completo con todos los casos de rotacion");
        BSTree<Integer, Integer> tree1 = new BSTree<>((Integer i1, Integer i2) -> i1 - i2);
        BSTree<Integer, Integer> tree2 = new BSTree<>((Integer i1, Integer i2) -> i1 - i2);
        
        int[] numList = {30, 20, 10, 40, 50, 5, 7, 6, 60, 55, 57};

        for (Integer i: numList) {
            tree1.insertToAVL(i, i);
            tree2.insert(i, i);
        }
        
        tree2.printTree();
        tree1.printTree();
    }
   
}
    