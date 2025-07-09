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
        System.out.println("\nLaboratorio Tree | Gabriel Tumbaco Santana | P1\n");
        
        // Actividad 1 - Árbol multicamino
        Tree<Character> treeA = new Tree<>();
        treeA.setRoot(new NodeTree<>('A'));

        Tree<Character> treeB = new Tree<>();
        treeB.setRoot(new NodeTree<>('B'));

        Tree<Character> treeD = new Tree<>();
        treeD.setRoot(new NodeTree<>('D'));

        Tree<Character> treeE = new Tree<>();
        treeE.setRoot(new NodeTree<>('E'));

        treeB.getRoot().addChild(treeD);
        treeB.getRoot().addChild(treeE);

        Tree<Character> treeC = new Tree<>();
        treeC.setRoot(new NodeTree<>('C'));

        Tree<Character> treeF = new Tree<>();
        treeF.setRoot(new NodeTree<>('F'));

        Tree<Character> treeG = new Tree<>();
        treeG.setRoot(new NodeTree<>('G'));

        treeC.getRoot().addChild(treeF);
        treeC.getRoot().addChild(treeG);

        treeA.getRoot().addChild(treeB);
        treeA.getRoot().addChild(treeC);

        // Actividad 2 - Recorrido de árboles binarios
        
        System.out.println("Árbol Binario\n");
        
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

        BinaryTree<Character> biTreeG = new BinaryTree<>();
        biTreeG.setRoot(new NodeBinaryTree<>('G'));

        biTreeC.getRoot().setLeft(biTreeF);
        biTreeC.getRoot().setRight(biTreeG);

        biTree.getRoot().setLeft(biTreeB);
        biTree.getRoot().setRight(biTreeC);
        
        System.out.println("\nRecorrido Preorden: ");
        biTree.recorrerPreorden();
        
        System.out.println("\nRecorrido Entreorden: ");
        biTree.recorrerEntreorden();
        
        System.out.println("\nRecorrido Postorden: ");
        biTree.recorrerPostorden();
    }
}
