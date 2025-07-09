/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tareacolas;
import java.util.ArrayList;
/**
 *
 * @author gatumbac
 */
public class Customer {
    private String name;
    private String lastname;
    private String id;
    private ArrayList<Product> products;
    
    public Customer(String name, String lastname, String id) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
        this.products = new ArrayList<>();
    }
    
    public boolean addProductToShoppingCart(Product product) {
        return products.add(product);
    }
    
    public int getShoppingCartSize() {
        return products.size();
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getLastName() {
        return this.lastname;
    }
    
    public String getId() {
        return this.id;
    }
    
    @Override 
    public String toString() {
        return this.name + " " + this.lastname + " | " + getShoppingCartSize() + " productos";
    }
    
}
