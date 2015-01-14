/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 *
 * @author Carlos Contreras
 */
public class Panel extends JPanel {

    private Mapa mondix = new Mapa();
    public ImageIcon imageIcon = (new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mapa_TSP2.png")));

    public Panel(Dimension d) {

        this.setSize(d);
        this.setPreferredSize(d);
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY));

    }
    // override update

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imageIcon.getImage(), 0, 0, this);
        mondix.dibujar(g);

        if (Mapa_TSP.ruta) {
            mondix.draw_routes(g);
        }
        
        if (Mapa_TSP.precio) {
            mondix.draw_price(g);
        }
        mondix.draw_shortestRoute(g);
    }
}
