/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 59178
 */
public class Pruebas {

    public static void main(String[] args) {
        Grafo G = new Grafo();
        G.crearVertice("A");
        G.crearVertice("B");
        G.crearVertice("C");
        G.crearVertice("D");
        G.crearVertice("E");
       
        G.insertarArco("A", "B", 15);
        G.insertarArco("A", "C", 10);
        G.insertarArco("C", "D", 20);
        G.insertarArco("B", "D", 30);
        G.insertarArco("E", "B",40);
        
        //G.mostrarCaminosRecorridoBFS("A", "D");
        //System.out.println(G.repeExiteCaminoConDFS("A", "B"));
     //   System.out.println(G.repeExisteCaminoConBFS("Z", "Q"));
     //   System.out.println(G.cantidadCaminos("A", "B"));
       // System.out.println(G.repeCantCaminosBFS("A", "C"));
      // G.mostrarCaminosBFS("A", "D");
      G.mostrarCaminosRecorridoBFS("A", "D");
    }
}
