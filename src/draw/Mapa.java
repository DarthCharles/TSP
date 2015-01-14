/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Carlos Contreras
 */
public class Mapa {

    public static Point punto = new Point();
    public static ArrayList<Vertice> Cuidades = new ArrayList<>();
    public static ArrayList<Vertice> auxis = new ArrayList<>();
    public static Mapa mapa = new Mapa();
    public static ArrayList<Color_estado> Estados = new ArrayList<>();
    public static ArrayList<Vertice> ruta = new ArrayList<>();
    public static int var, num, el_cabron;
    public static Vertice aux, auxi, fin;
    public static double distancia, min, costo;
    public static Polygon p;

    public static void mouseclicked(MouseEvent e) {
        try {
            punto.x = e.getX();
            punto.y = e.getY();
            mapa.get_PixelColor();
            if (Estados.get(var).contador == 0) {
                Cuidades.add(new Vertice(Estados.get(var).nombre, punto.x, punto.y, var));
            } else {
                Cuidades.add(new Vertice(Estados.get(var).nombre + " " + Estados.get(var).contador, punto.x, punto.y, var));
                
            }

        } catch (IOException ex) {
            Logger.getLogger(Mapa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void add_estados() {
        //Rosas
        Estados.add(new Color_estado("Sonora", 208, 0, 122));
        Estados.add(new Color_estado("Jalisco", 202, 6, 111));
        Estados.add(new Color_estado("Tamaulipas", 208, 0, 101));
        Estados.add(new Color_estado("Querétaro", 212, 20, 132));
        //Verdes
        Estados.add(new Color_estado("Baja California", 12, 148, 63));
        Estados.add(new Color_estado("Coahuila", 12, 148, 59));
        Estados.add(new Color_estado("Michoacán", 12, 145, 62));
        Estados.add(new Color_estado("Oaxaca", 33, 157, 84));
        //Azul
        Estados.add(new Color_estado("Baja California Sur", 28, 45, 127));
        Estados.add(new Color_estado("Guanajuato", 26, 41, 117));
        Estados.add(new Color_estado("Puebla", 30, 48, 134));
        Estados.add(new Color_estado("Chiapas", 28, 60, 127));
        //Azul Claro
        Estados.add(new Color_estado("Nuevo León", 1, 141, 176));
        Estados.add(new Color_estado("Nayarit", 1, 149, 176));
        Estados.add(new Color_estado("Hidalgo", 18, 149, 181));
        Estados.add(new Color_estado("Guerrero", 1, 136, 171));
        Estados.add(new Color_estado("Quintana Roo", 0, 141, 177));
        //Amarillo
        Estados.add(new Color_estado("Aguascalientes", 253, 210, 35));
        Estados.add(new Color_estado("Colima", 255, 211, 33));
        Estados.add(new Color_estado("Tlaxcala", 253, 211, 44));
        Estados.add(new Color_estado("D.F", 238, 197, 33));
        Estados.add(new Color_estado("Tabasco", 255, 214, 55));
        //Rojo
        Estados.add(new Color_estado("Durango", 226, 24, 38));
        Estados.add(new Color_estado("Veracruz", 229, 47, 59));
        //Morado
        Estados.add(new Color_estado("Sinaloa", 179, 120, 174));
        Estados.add(new Color_estado("San Luis P.", 178, 119, 171));
        Estados.add(new Color_estado("Morelos", 181, 124, 176));
        Estados.add(new Color_estado("Yucatán", 180, 119, 175));
        //Naranja
        Estados.add(new Color_estado("Chihuaha", 235, 114, 9));
        Estados.add(new Color_estado("Zacatecas", 237, 118, 36));
        Estados.add(new Color_estado("Campeche", 229, 110, 9));
        Estados.add(new Color_estado("Edo. Méx", 238, 113, 6));
        //Otros
        Estados.add(new Color_estado("Guatemala", 217, 234, 216));
        Estados.add(new Color_estado("Belice", 199, 216, 236));
        Estados.add(new Color_estado("Honduras", 248, 207, 225));
        Estados.add(new Color_estado("E.U.A", 235, 221, 234));
        Estados.add(new Color_estado("Oceano Pacifico", 241, 242, 243));
        Estados.add(new Color_estado("Golfo de Méx", 255, 255, 255));
        Estados.add(new Color_estado("Tierra de Carlos", 255, 232, 188));
    }

    public void get_PixelColor() throws IOException {

        BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/Imagenes/Mapa_TSP2.png"));

        int h = image.getRGB(punto.x, punto.y);
        int R = (h & 0x00ff0000) >> 16;
        int G = (h & 0x0000ff00) >> 8;
        int B = h & 0x000000ff;



        Color colis = new Color(R, G, B);

        for (int i = 0; i < Estados.size(); i++) {
            if (colis.getRGB() == Estados.get(i).getColorin().getRGB()) {
                var = i;
                Estados.get(i).contador++;

            }

        }

    }

    public void dibujar(Graphics g) {

        g.setFont(g.getFont().deriveFont(Font.BOLD));
        for (int i = 0; i < Cuidades.size(); i++) {
            g.fillOval(Cuidades.get(i).x - 5, Cuidades.get(i).y - 5, 10, 10);
            g.drawString(Cuidades.get(i).nombre, Cuidades.get(i).x, Cuidades.get(i).y);
        }
    }

    public static void rutacorta() {
        TSP_ALGM.get_shortestRoute(distancia, Cuidades, min, el_cabron, aux, fin, ruta, auxis);
    }

    public void draw_shortestRoute(Graphics g) {
        int ruta_x[] = new int[ruta.size()];
        int ruta_y[] = new int[ruta.size()];

        for (int i = 0; i < ruta.size(); i++) {
            ruta_x[i] = ruta.get(i).x;
            ruta_y[i] = ruta.get(i).y;
        }

        p = new Polygon(ruta_x, ruta_y, ruta.size());
        g.setColor(Color.cyan);
        g.drawPolygon(p);

    }

    public static void get_costo() {

        for (int i = 0; i < ruta.size() - 1; i++) {

            double dx = ruta.get(i).x - ruta.get(i + 1).x;
            double dy = ruta.get(i).y - ruta.get(i + 1).y;

            costo += Math.hypot(dx, dy);
            
        }






    }

    public void draw_routes(Graphics g) {
        for (int i = 0; i < Cuidades.size(); i++) {
            for (int j = 0; j < Cuidades.size(); j++) {
                g.setColor(Color.BLACK);
                g.drawLine(Cuidades.get(i).x, Cuidades.get(i).y, Cuidades.get(j).x, Cuidades.get(j).y);
            }
        }
    }

    public void draw_price(Graphics g) {

        for (int i = 0; i < Cuidades.size(); i++) {
            for (int j = 0; j < Cuidades.size(); j++) {

                if (Mapa.get_distancia(i, j) != 0) {
                    g.drawString("$" + Integer.toString(Mapa.get_distancia(i, j)), (Cuidades.get(i).x + Cuidades.get(j).x) / 2, (Cuidades.get(i).y + Cuidades.get(j).y) / 2);
                }
            }
        }
    }

    public static int get_distancia(int i, int j) {

        distancia = (int) Math.sqrt(Math.pow(Cuidades.get(i).x - Cuidades.get(j).x, 2)
                + Math.pow(Cuidades.get(i).y - Cuidades.get(j).y, 2));

        return (int) distancia;
    }
    
    public static void reset_counters(){
        for (int i = 0; i < Estados.size(); i++) {
            Estados.get(i).contador = -1;
        }
    }

    public Mapa() {
    }
}
