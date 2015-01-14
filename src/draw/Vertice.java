/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;

/**
 *
 * @author Carlos Contreras
 */
public class Vertice {

    String nombre;
    int x;
    int y;
    int posición;

    public Vertice(String nombre, int x, int y, int posición) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.posición = posición;
    }

    public int getPosición() {
        return posición;
    }

    public void setPosición(int posición) {
        this.posición = posición;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
}
