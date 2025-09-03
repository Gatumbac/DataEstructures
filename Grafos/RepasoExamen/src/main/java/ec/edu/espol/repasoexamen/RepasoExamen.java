/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.repasoexamen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gabriel
 */
public class RepasoExamen {

    public static void main(String[] args) {
                // Lista desordenada que queremos ordenar
        List<Integer> miLista = new ArrayList<>(Arrays.asList(4, 10, 3, 5, 1, 15, 8));

        // 1. Crear el Heap (Max-Heap)
        // El comparador (i1, i2) -> i1.compareTo(i2) ordena de forma natural (menor a mayor).
        // La lógica del heap usará esto para poner el mayor en la raíz.
        Heap<Integer> maxHeap = new Heap<>((i1, i2) -> i1.compareTo(i2), true);

        // 2. Insertar todos los elementos de la lista en el heap
        for (Integer num : miLista) {
            maxHeap.offer(num);
        }

        // 3. Extraer los elementos del heap para obtener la lista ordenada
        List<Integer> listaOrdenada = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            listaOrdenada.add(maxHeap.poll()); // Extrae el elemento más grande cada vez
        }

        System.out.println("Lista Original: " + miLista);
        // Salida -> [15, 10, 8, 5, 4, 3, 1]
        System.out.println("Ordenada de Mayor a Menor: " + listaOrdenada);
    }
}
