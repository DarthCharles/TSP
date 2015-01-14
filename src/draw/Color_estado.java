/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;

import java.awt.Color;

/**
 *
 * @author Carlos Contreras
 */
public class Color_estado {

    String nombre;
    int R,G,B;
    Color colorin;
    int contador = -1;


    public Color_estado(String nombre, int R, int G, int B) {
        this.nombre = nombre;
        this.R = R;
        this.G = G;
        this.B = B;
        colorin = new Color(R, G, B);
    }

    public int getB() {
        return B;
    }

    public Color getColorin() {
        return colorin;
    }

    public void setColorin(Color colorin) {
        this.colorin = colorin;
    }

    public void setB(int B) {
        this.B = B;
    }

    public int getG() {
        return G;
    }

    public void setG(int G) {
        this.G = G;
    }

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
