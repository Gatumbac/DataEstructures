/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tareacolas;

/**
 *
 * @author gatumbac
 */
public class Order {
    private String name;
    private int waitingTime;
    
    public Order (String name, int waitingTime) {
        this.name = name;
        this.waitingTime = waitingTime;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getWaitingTime() {
        return this.waitingTime;
    }
    
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
    
    @Override
    public String toString() {
        return this.name + ": " + this.waitingTime + " minutos";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        
        if (o == this) {
            return true;
        }
        
        if (this.getClass() != o.getClass()){
            return false;
        }
        
        Order o2 = (Order) o;
        
        return o2.getName().equals(this.name);
    }
}
