/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tareacolas;

/**
 *
 * @author gatumbac
 */
public class Patient {
    private String id;
    private String name;
    private int priority;
    
    public Patient(String id, String name, int severity) {
        this.id = id;
        this.name = name;
        this.priority = severity;
    }
    
    public int getPriority() {
        return this.priority;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setPriority(int priority) {
        this.priority = priority;
    }
    
    @Override
    public String toString() {
        return this.id + " -> " + this.name + " | Gravedad: " + this.priority;
    }

}
