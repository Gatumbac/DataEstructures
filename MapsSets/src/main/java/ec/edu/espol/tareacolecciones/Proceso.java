/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tareacolecciones;

/**
 *
 * @author gatumbac
 */

public class Proceso implements Comparable<Proceso> {
    private int id;
    private String nombre;
    private int ciclos;
    private int prioridad;

    public Proceso(int id, String nombre, int ciclos, int prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.ciclos = ciclos;
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCiclos() {
        return ciclos;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiclos(int ciclos) {
        if (ciclos >= 0) {
            this.ciclos = ciclos;
        }
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    @Override
    public int compareTo(Proceso p2) {
        int idCmp = Integer.compare(this.id, p2.id);
        if (idCmp != 0) {
            return idCmp;
        }
        
        int prioridadCmp = Integer.compare(this.prioridad, p2.prioridad);
        if (prioridadCmp != 0) {
            return prioridadCmp;
        }
        
        int ciclosCmp = Integer.compare(this.ciclos, p2.ciclos);
        if (ciclosCmp != 0) {
            return ciclosCmp;
        }
        
        return this.nombre.compareTo(p2.nombre);
    }

    @Override
    public String toString() {
        return "Id: " + id + " - Nombre: " + nombre + " - Ciclos Actuales: " + ciclos;
    }
    
    @Override
    public boolean equals(Object p2) {
        if (this == p2) {
            return true;
        }
        
        if (p2 == null || this.getClass() != p2.getClass()) {
            return false;
        }
        
        Proceso otro = (Proceso) (p2);
        return this.id == otro.id && this.nombre.equals(otro.nombre) && this.prioridad == otro.prioridad;
    }
}


