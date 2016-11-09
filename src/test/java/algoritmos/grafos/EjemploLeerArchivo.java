/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.grafos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author SG701-11
 */
public class EjemploLeerArchivo {
    
    public static void main(String[] args) {
        
        try {
            
            Grafo grafo = new GrafoNoDirigido();
            
            FileReader fr = new FileReader("src/test/java/algoritmos/grafos/movies.txt");
            BufferedReader br = new BufferedReader(fr);
            
            
            for (int i = 0; i < 20; i++) {
                
                
                String linea = br.readLine();

                //System.out.println(linea);

                String[] partes = linea.split("/");
                //System.out.println("pelicula = "+partes[0]);
                //System.out.println("actor= "+partes[1]);
                for (int j = 1; j < partes.length; j++) {                    
                    
                    if (grafo.getVertice(partes[j])== null) { grafo.addVertice(partes[j]); }
                   
                    for (int k = j; k < partes.length; k++) {
                        if (grafo.getVertice(partes[k])== null) { grafo.addVertice(partes[k]); }
                        grafo.addArista(partes[j], partes[k], partes[0]);
                    }
                }
                
               
                
                
            }
           
        } catch (Exception e) {
            System.out.println("error");
        }
    }
     public static void recorrerAnchura(Grafo grafo, String dato) {
        recorrerAnchura(grafo.getVertice(dato));
    }

    public static void recorrerAnchura(Vertice v) {

        Queue<Vertice> cola = new ArrayBlockingQueue<>(10);
        List<Vertice> visitados = new ArrayList<>();

        // inicia con v
        cola.add(v);

        // hay elementos a visitar ?
        while (cola.size() > 0) {
            Vertice visitando = cola.remove();
            visitados.add(visitando);

            System.out.print(visitando.getDato());
            System.out.print(" ");

            for (Vertice vi : visitando.getAdyacentes()) {
                if (!visitados.contains(vi)) {
                    if (!cola.contains(vi)) {
                        cola.add(vi);
                    }
                }
            }
        }
    }
    
    
}
