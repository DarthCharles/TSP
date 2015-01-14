/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package draw;

import java.util.ArrayList;

/**
 *
 * @author Carlos Contreras
 */
public class TSP_ALGM {

    public static void copy(ArrayList<Vertice> cuidad, ArrayList<Vertice> apa) {
        for (int i = 0; i < cuidad.size(); i++) {
            apa.add(cuidad.get(i));
        }
    }

    public static void get_matrix(double distancia, double array[][], ArrayList<Vertice> cuidad) {
        for (int i = 0; i < cuidad.size(); i++) {
            for (int j = 0; j < cuidad.size(); j++) {

                distancia = Math.sqrt(Math.pow(cuidad.get(i).x - cuidad.get(j).x, 2)
                        + Math.pow(cuidad.get(i).y - cuidad.get(j).y, 2));
                array[i][j] = distancia;
            }
        }

    }

    public static void get_shortestRoute(double distancia, ArrayList<Vertice> cuidad, double min, int el_cabron, Vertice aux, Vertice fin, ArrayList<Vertice> ruta, ArrayList<Vertice> apa) {
        try {
            TSP_ALGM.copy(cuidad, apa);
            fin = apa.get(0);
            do {

                aux = apa.get(el_cabron);
                apa.remove(el_cabron);
                ruta.add(aux);
                if (!apa.isEmpty()) {
                    distancia = Math.sqrt(Math.pow(aux.x - apa.get(0).x, 2)
                            + Math.pow(aux.y - apa.get(0).y, 2));

                    min = distancia;

                    for (int i = 0; i < apa.size(); i++) {
                        distancia = Math.sqrt(Math.pow(aux.x - apa.get(i).x, 2)
                                + Math.pow(aux.y - apa.get(i).y, 2));

                        if (distancia <= min) {
                            min = distancia;
                            el_cabron = i;
                        }
                    }
                    //costo += min;
                } else {
                    break;
                }

            } while (!cuidad.isEmpty());
            ruta.add(fin);
            //System.out.println(costo);
        } catch (Exception e) {
        }
    }
}
