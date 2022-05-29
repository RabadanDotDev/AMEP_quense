
package com.nosferatu.queense;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UtilityCLI {
    /**
     * Mostrar llista numerada per consola
     * 
     * @param llistaElements Llista a mostrar
     * @pre Ø
     * @post S'ha escrit per consola la llista de elements amb els seus índexs
     */
    public static void mostraLlista(ArrayList<String> llistaElements) {
        Iterator<String> it = llistaElements.iterator();
        int i = 0;
        while(it.hasNext()){
            System.out.print(i);
            System.out.print(" - ");
            System.out.print(it.next());
            System.out.print("\n");
            ++i;
        }
    }
    
    /**
     * Mostrar llista numerada amb caselles per consola
     * 
     * @param llistaElements Llista a mostrar
     * @param elementsMarcats Elements marcats
     * @pre Ø
     * @post S'ha escrit per consola la llista de elements amb els seus índexs i si es troben marcats
     */
    public static void mostraLlista(ArrayList<String> llistaElements, ArrayList<Boolean> elementsMarcats) {
        // 0 [x] text
        // 1 [ ] text
    }
    
    /**
     * Demanar nombre a l'usuari per consola
     * 
     * @param peticio Text a mostrar a l'usuari
     * @param min Num minim (inclusiu)
     * @param max Num màxim (inclusiu)
     * @pre Ø
     * @post el valor de retorn es troba entre min i max (inclusiu)
     * @return el valor introduit per l'usuari
     */
    public static Integer demanarNombre(String peticio, Integer min, Integer max) {
        // peticio (entre $min y $max)
        System.out.print(peticio + " (entre " + min + " i " + max + " ) ");
        Scanner input = new Scanner(System.in);
        int i;
        while(input.hasNext()){
        input = new Scanner(System.in);
        if(input.hasNextInt()){
        i = input.nextInt();
            if(i < min || max < i) System.out.print("Introdueix un nombre dins l'interval d'opcions" + " (entre " + min + " i " + max + " ) ");
        }
        else System.out.print(peticio + " (entre " + min + " i " + max + " ) ");
        }
        return i;
    }
    
    /**
     * Demanar text a l'usuari per consola
     * 
     * @pre Ø
     * @post el valor de retorn no es buit
     * @return el valor introduit per l'usuari
     */
    public static String demanarText() {
        return "xd";
    }
    
    /**
     * Demanar data a l'usuari per consola
     * 
     * @pre Ø
     * @post el valor de retorn no es buit
     * @return la data introduida per l'usuari
     */
    public static String demanarData() {
        return "xd";
    }
}
