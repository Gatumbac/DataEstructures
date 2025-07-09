/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tareacolas;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.LinkedList;


/**
 *
 * @author gatumbac
 */
public class Helper {
    public static Customer findCustomerWithMoreProducts(Queue<Customer> customers, int minProducts) {
        if (customers == null || customers.isEmpty() || minProducts < 0) {
            return null;
        }
        
        for (Customer customer: customers) {
            if (customer.getShoppingCartSize() > minProducts) {
                return customer;
            }
        }
        return null;
    }
    
    public static int calculateTotalOrderTime(Queue<Order> orders) {
        int total = 0;
        for (Order o: orders) {
            total += o.getWaitingTime();
        }
        return total;
    }
    
    public static void showTotalTimeEachOrder(Queue<Order> orders) {
        // Se obtiene el tiempo acumulado de cada pedido en la cola. Se usa el metodo equals definido en la clase Order
        Queue<Order> acumulatedOrders = new LinkedList<>();
        
        for (Order o1: orders) {
            boolean isRepeatedOrder = false;
            for (Order acumulatedOrder: acumulatedOrders) {
                if (acumulatedOrder.equals(o1)) {
                    isRepeatedOrder = true;
                }
            }
            
            if (!isRepeatedOrder) {
                int acumulatedTime = 0;
                for (Order o2: orders) {
                    if (o2.equals(o1)) {
                        acumulatedTime += o2.getWaitingTime();
                    }
                }
                
                acumulatedOrders.offer(new Order(o1.getName(), acumulatedTime));
            }
        }
        
        showAcumulatedOrders(acumulatedOrders);
    }
    
    private static void showAcumulatedOrders(Queue<Order> acumulatedOrders) {
        StringBuilder builder = new StringBuilder();
        for (Order acumulatedOrder: acumulatedOrders) {
            builder.append(acumulatedOrder.toString());
            builder.append(", ");
        }

        if (builder.length() > 0) {
            builder.setLength(builder.length() - 2); //Eliminar última coma
        }
        
        System.out.println("Tiempo de espera de cada producto -> " + builder.toString());
    }
    
    public static boolean updatePriority(PriorityQueue<Patient> patients, String patientName, int newPriority) {
        Iterator<Patient> it = patients.iterator();
        while (it.hasNext()) {
            Patient currentPatient = it.next();
            if(currentPatient.getName().equals(patientName)) {
                // Se actualiza la estructura interna de la PriorityQueue
                patients.remove(currentPatient);
                currentPatient.setPriority(newPriority);
                patients.add(currentPatient);
                return true;
            }
        }
        return false;
    }
    
    public static Patient attendNextPatient(PriorityQueue<Patient> patients) {
        return patients.peek();
    }
}
