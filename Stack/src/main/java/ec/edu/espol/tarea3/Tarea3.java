/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.tarea3;

/**
 *
 * @author grupo1
 */
public class Tarea3 {

    public static void main(String[] args) {
        System.out.println("\nTAREA 3 | PILAS - STACKS | GRUPO 1 - P1\n");
        
        Document doc = new Document();
        System.out.println("Estado inicial: " + doc);

        // Caso 1: Agregar contenido
        doc.addContent("Hola |");
        doc.addContent("Esto es una prueba |");
        doc.addContent("Agregamos más texto |");
        System.out.println("\nDespués de agregar contenido:");
        System.out.println(doc);
        doc.showHistorial();

        // Caso 2: Rollback una vez
        doc.rollBack();
        System.out.println("\nDespués de un rollback:");
        System.out.println(doc);
        doc.showHistorial();

        // Caso 3: Rollback dos veces más
        doc.rollBack();
        doc.rollBack();
        System.out.println("\nDespués de dos rollbacks más:");
        System.out.println(doc);
        doc.showHistorial();

        // Caso 4: Intentar rollback cuando ya no hay más versiones
        doc.rollBack();  // no debería cambiar nada
        System.out.println("\nDespués de rollback sin historial:");
        System.out.println(doc);

        // Caso 5: Rehacer dos veces
        doc.nextVersion();
        doc.nextVersion();
        System.out.println("\nDespués de dos nextVersion:");
        System.out.println(doc);
        doc.showHistorial();

        // Caso 6: Agregar nuevo contenido (debe limpiar la pila de registrados)
        doc.addContent("Nuevo contenido tras rollback |");
        System.out.println("\nDespués de nuevo contenido tras rollback:");
        System.out.println(doc);
        doc.showHistorial();

        // Caso 7: Intentar rehacer (no debe pasar nada)
        doc.nextVersion();
        System.out.println("\nIntento de rehacer después de agregar contenido nuevo:");
        System.out.println(doc);
        doc.showHistorial();

    }
}
