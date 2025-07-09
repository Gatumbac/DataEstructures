/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.tareacolas;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 *
 * @author gatumbac
 */
public class Tareacolas {

    public static void main(String[] args) {
        System.out.println("\nTAREA 4 - COLAS | TUMBACO SANTANA GABRIEL ALEJANDRO - P1");
        exercise1();
        exercise2();
        exercise3();
    }
    
    public static void exercise1() {
        System.out.println("\nEjercicio #1 - Búsqueda de Cliente\n");
        
        Queue<Customer> customers = getCustomerQueue();
        exercise1Format(customers, 2);
        exercise1Format(customers, 0);
        exercise1Format(customers, -5);
        exercise1Format(null, 3);
        exercise1Format(customers, 4);
    }
    
    public static void exercise2() {
        System.out.println("\nEjercicio #2 - Pedidos en restaurante\n");
        
        Queue<Order> orders = getOrderQueue();
        System.out.println("Cola de pedidos: ");
        System.out.println(orders);
        int totalTime = Helper.calculateTotalOrderTime(orders);
        System.out.println("\nTiempo de espera total -> " + totalTime + " minutos.");
        Helper.showTotalTimeEachOrder(orders);
    }
    
    public static void exercise3() {
        System.out.println("\nEjercicio #3 - Turnos de Hospital con Prioridad Dinámica\n");
        PriorityQueue<Patient> patients = new PriorityQueue<>((Patient p1, Patient p2) -> p1.getPriority() - p2.getPriority());
        fillPatientQueue(patients);
        
        System.out.println("Cola de Pacientes (Respetando orden de salida de poll()): \n");
        showPriorityQueue(patients);
        System.out.println();
        
        System.out.println("Siguiente paciente en ser atendido: " + Helper.attendNextPatient(patients));
        updatePriorityFormat(patients, "Ramiro Cobo", 1);
        updatePriorityFormat(patients, "Diana Sanchez", 1);
        updatePriorityFormat(patients, "Gabriel Tumbaco", 1);
        
        System.out.println("\nCola de Pacientes (Respetando orden de salida de poll()): \n");
        showPriorityQueue(patients);
        
    }
    
    public static void exercise1Format(Queue<Customer> customers, int minSize) {
        System.out.println("\nCola de clientes: ");
        System.out.println(customers);
        System.out.println("Minimo de Productos: " + minSize);
        
        Customer foundCustomer = Helper.findCustomerWithMoreProducts(customers, minSize);
        if (foundCustomer != null) {
            System.out.println("Primer Cliente Encontrado: " + foundCustomer);
        } else {
            System.out.println("No se encontró ningún cliente que tenga más de " + minSize + " productos.");
        }
    }
    
    public static Queue<Customer> getCustomerQueue() {
        Customer c1 = new Customer("Ana", "Pérez", "0920776994");
        c1.addProductToShoppingCart(new Product("Leche", 1.25));
        c1.addProductToShoppingCart(new Product("Pan", 0.75));

        Customer c2 = new Customer("Luis", "Mendoza", "0951846385");
        c2.addProductToShoppingCart(new Product("Arroz", 2.50));
        c2.addProductToShoppingCart(new Product("Azúcar", 1.30));
        c2.addProductToShoppingCart(new Product("Aceite", 3.00));
        c2.addProductToShoppingCart(new Product("Huevos", 2.80));

        Customer c3 = new Customer("María", "García", "0963112801");
        // 0 productos

        Customer c4 = new Customer("Carlos", "Sánchez", "0979234716");
        c4.addProductToShoppingCart(new Product("Queso", 2.00));

        Customer c5 = new Customer("Sofía", "Rivas", "0927540856");
        c5.addProductToShoppingCart(new Product("Yogur", 1.50));
        c5.addProductToShoppingCart(new Product("Mantequilla", 2.20));

        Customer c6 = new Customer("Jorge", "López", "0967676653");
        c6.addProductToShoppingCart(new Product("Cereal", 3.50));
        c6.addProductToShoppingCart(new Product("Café", 4.00));
        c6.addProductToShoppingCart(new Product("Galletas", 1.20));

        Customer c7 = new Customer("Valentina", "Núñez", "0700027121");
        // 0 productos

        Customer c8 = new Customer("Andrés", "Martínez", "0913654789");
        c8.addProductToShoppingCart(new Product("Detergente", 5.00));
        c8.addProductToShoppingCart(new Product("Jabón", 2.50));

        Customer c9 = new Customer("Camila", "Salazar", "0965842315");
        c9.addProductToShoppingCart(new Product("Pasta", 1.10));
        c9.addProductToShoppingCart(new Product("Salsa", 1.80));
        c9.addProductToShoppingCart(new Product("Atún", 2.60));
        c9.addProductToShoppingCart(new Product("Agua", 0.90));
        c9.addProductToShoppingCart(new Product("Refresco", 1.50));

        Customer c10 = new Customer("Diego", "Vera", "0952361807");
        c10.addProductToShoppingCart(new Product("Frutas", 4.00));
        
        Queue<Customer> customers = new ArrayDeque<>();
        customers.offer(c1);
        customers.offer(c2);
        customers.offer(c3);
        customers.offer(c4);
        customers.offer(c5);
        customers.offer(c6);
        customers.offer(c7);
        customers.offer(c8);
        customers.offer(c9);
        customers.offer(c10);
        
        return customers;
    }
    
    public static Queue<Order> getOrderQueue() {
        Queue<Order> orders = new LinkedList<>();

        orders.add(new Order("Encebollado", 2));
        orders.add(new Order("Bolón con bistec", 5));
        orders.add(new Order("Encebollado", 2));
        orders.add(new Order("Tigrillo con queso", 4));
        orders.add(new Order("Bolón con bistec", 5));
        orders.add(new Order("Guatita", 6));
        orders.add(new Order("Seco de pollo", 7));
        orders.add(new Order("Encebollado", 2));
        orders.add(new Order("Guatita", 6));
        orders.add(new Order("Encebollado", 2));

        return orders;
    } 
    
    public static void fillPatientQueue(Queue<Patient> patients) {
        patients.add(new Patient("0951638456", "María Cedeño", 3));
        patients.add(new Patient("0985632696", "José Guaman", 1));
        patients.add(new Patient("0945879156", "Lucía Lema", 2));
        patients.add(new Patient("0962963548", "Carlos Ayala", 2));
        patients.add(new Patient("0912563487", "Diana Sanchez", 3));
        patients.add(new Patient("0956892315", "Pedro Paredes", 2));
        patients.add(new Patient("0965847592", "Ana Villamar", 2));
        patients.add(new Patient("0920766994", "Esteban Mena", 3));
        patients.add(new Patient("0963112801", "Tatiana Benitez", 2));
        patients.add(new Patient("0951846385", "Ramiro Cobo", 2));
    }
    
    public static void showPriorityQueue(PriorityQueue<Patient> patients) {
        LinkedList<Patient> listOfQueue = new LinkedList<>();
        PriorityQueue<Patient> copyOfQueue = new PriorityQueue<>(patients);
        while(!copyOfQueue.isEmpty()) {
            listOfQueue.add(copyOfQueue.poll());
        }
        System.out.println(listOfQueue);
    }
    
    public static void updatePriorityFormat(PriorityQueue<Patient> patients, String patientName, int newPriority) {
        if (Helper.updatePriority(patients, patientName, newPriority)) {
            System.out.println("Actualizando prioridad de " + patientName + " a " + newPriority + "...");
        } else {
            System.out.println("No se pudo actualizar prioridad de " + patientName + ". No se encontró tal paciente.");
        }
    }
    
    
}
