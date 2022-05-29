
package com.nosferatu.queense;

import java.util.ArrayList;

public class UtilityCLI {
    /**
     * Mostrar llista numerada per consola
     * 
     * @param llistaElements Llista a mostrar
     * @pre Ø
     * @post S'ha escrit per consola la llista de elements amb els seus índexs
     */
    public static void mostraLlista(ArrayList<String> llistaElements) {
        // 0 - text
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
        return 0;
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
}
