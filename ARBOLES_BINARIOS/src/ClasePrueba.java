/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 59178
 */
public class ClasePrueba {

    public static void main(String[] args) {
        /* Arbol a1 = new Arbol();
        a1.insertar(10);
        a1.insertar(7);
        a1.insertar(15);
        a1.insertar(9);
        a1.insertar(20);
        a1.insertar(18);
        a1.insertar(9);   
        a1.insertar(8);
        a1.insertar(5);   */

 /*Arbol a2 = new Arbol();
        a2.insertar(10);
        a2.insertar(7);
        a2.insertar(15);*/
        // a2.insertar(18);
        //int x = 18;
        //System.out.println("Altura de "+x+" es: "+a1.alturaDeNodoX(x));
        //System.out.println("Nivel en que se encuentra "+x+" es: "+a1.nivelEnQueSeEncuentraX(x));
        // System.out.println("Incompletos: " + a1.incompletos());
        //System.out.println("Hojas: "+a1.cantidadDeHojas());
        // System.out.println("son hermanos: "+a1.hermanos(2, 4));
        //  System.out.println("Padre de "+x+" : "+a1.padreDeX(x));    
        //System.out.println("Abuelo de " + x + " : " + a1.abueloDeX(x));
        //System.out.println("Son iguales: "+a1.iguales(a2) );
        //System.out.println("Nivel en que se encuentra "+x+" es: "+a1.devolverNivelDeX(x));
        Arbol a = new Arbol();
        a.insertar(10);
        a.insertar(15);
        a.insertar(23);
        a.insertar(8);
        a.insertar(9);
        Arbol b = new Arbol();
         b.insertar(10);
        b.insertar(15);
        b.insertar(23);
        b.insertar(8);
        b.insertar(9);
        b.insertar(6);
        b.insertar(7);
        System.out.println("Es subarbol: " + a.esSubArbol(b));
    }
}
