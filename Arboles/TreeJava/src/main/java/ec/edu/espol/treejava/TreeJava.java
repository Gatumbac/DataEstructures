/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.treejava;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author gatumbac
 */
public class TreeJava {

    public static void main(String[] args) {
        System.out.println("\nLaboratorio Arboles de Expresion | Gabriel Tumbaco Santana | P1\n");
        
        // Actividad - Creación de árboles de expresión
        System.out.println("\nÁrbol De Expresión #1 - Recorrido Entreorden\n");
        BinaryTree<String> expressionTree = BinaryTree.buildExpressionTree("A B + C D * - H K - +");
        
        expressionTree.recorrerEntreorden();
        
        System.out.println("\nÁrbol De Expresión #2 - Recorrido Entreorden\n");
        BinaryTree<String> expressionTree2 = BinaryTree.buildExpressionTree("13 50 + 25 9 * - 2 +");
        
        expressionTree2.recorrerEntreorden();
        
        System.out.println("\nLaboratorio Árboles Binarios de Búsqueda | Gabriel Tumbaco Santana | P1\n");
        System.out.println("Ejercicio 1 - Inserción de libros");

        BSTree<Book, Integer> bst = new BSTree<>((Integer i1, Integer i2) -> Integer.compare(i1, i2));

        for (Book book : getBookList()) {
            bst.insert(book, book.getIsbn());
        }
        
        bst.printTree(); // Formato visual del árbol de búsqueda
        
        System.out.println("\nEjercicio 2 - Búsqueda de libros");
        buscarLibro(10011, bst);
        buscarLibro(50063, bst);
        
        System.out.println("\nEjercicio 3 - Eliminación de libros");
        eliminarLibro(10008, bst);
        eliminarLibro(50065, bst);
        System.out.println("\nÁrbol actualizado:");
        bst.printTree();
        
        System.out.println("\nEjercicio 4 - Árbol de expresión de multas");
        System.out.println("\nÁrbol De Expresión Multas - Recorrido Entreorden\n");
        BinaryTree<String> expressionTreeB = BinaryTree.buildExpressionTree("dias_retraso tarifa_diaria 1.5 + *");
        expressionTreeB.recorrerEntreorden();
        exercise4(4, 0.5, expressionTreeB);

        exercise4(11, 0.30, expressionTreeB);
        
    }
    
    private static ArrayList<Book> getBookList() {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book(10008, "SICP", "Harold Abelson", 3));
        books.add(new Book(10004, "Refactoring", "Martin Fowler", 2));
        books.add(new Book(10002, "Clean Code", "Robert C. Martin", 4));
        books.add(new Book(10001, "Effective Java", "Joshua Bloch", 5));
        books.add(new Book(10003, "Design Patterns", "Erich Gamma", 3));
        books.add(new Book(10006, "Introduction to Algorithms", "Thomas H. Cormen", 2));
        books.add(new Book(10005, "The Pragmatic Programmer", "Andrew Hunt", 6));
        books.add(new Book(10012, "Computer Networks", "Andrew S. Tanenbaum", 3));
        books.add(new Book(10010, "Java Concurrency in Practice", "Brian Goetz", 2));
        books.add(new Book(10009, "Head First Design Patterns", "Eric Freeman", 4));
        books.add(new Book(10007, "Cracking the Coding Interview", "Gayle Laakmann", 5));
        books.add(new Book(10011, "Algorithms", "Robert Sedgewick", 5));
        books.add(new Book(10014, "AI: A Modern Approach", "Stuart Russell", 2));
        books.add(new Book(10013, "Operating System Concepts", "Silberschatz", 4));
        books.add(new Book(10015, "Database Systems", "Silberschatz", 3));

        return books;
    }
    
    private static void buscarLibro(int isbn, BSTree<Book, Integer> bst) {
        Book book = bst.find(isbn);
        System.out.println("\nISBN Buscado: " + isbn);
        System.out.println(book != null ? book : "No se encontró el libro en el árbol");
    }
    
    private static void eliminarLibro(int isbn, BSTree<Book, Integer> bst) {
        System.out.println("\nISBN a eliminar: " + isbn);
        System.out.println(bst.delete(isbn) ? "Eliminación completa" : "No se encontró el libro en el árbol");
    }
    
    private static void exercise4(double dias, double tarifa, BinaryTree<String> expressionTree) {

        Map<String, Double> vars = new HashMap<>();
        vars.put("dias_retraso", dias);
        vars.put("tarifa_diaria", tarifa);
        
        System.out.println("\nDias de Retraso: " + dias);
        System.out.println("Tarifa Diaria: " + tarifa);
        
        double result = BinaryTree.evaluateExpressionTree(expressionTree, vars);
        System.out.println("Multa: $" + result);
    }
}
    