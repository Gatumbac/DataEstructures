/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.tareacolecciones;
import java.util.Objects;

/**
 *
 * @author gatumbac
 */
public class Casilla {
    private int x;
    private int y;

    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Casilla casilla = (Casilla) obj;
        return this.x == casilla.x && this.y == casilla.y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
