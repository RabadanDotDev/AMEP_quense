
package com.nosferatu.queense;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.text.ParseException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class UtilityCLI {
    
    /**
     * Mostrar nom pantalla amb lletres de "¿QuèEnSé? en gran
     * 
     * @param nomPantalla Nom de la pantalla
     * @pre Ø
     * @post S'ha escrit per consola el nom de la pantalla
     */
    public static void printNomPantalla(String nomPantalla){
        System.out.print(
            " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
            "    ____         __  ______        _____   _____  \n" +
            "   / __ \\        \\_\\|  ____|      / ____| /_/__ \\ \n" +
            "  | |  | |_   _  ___| |__   _ __ | (___   ___  ) |\n" +
            "  | |  | | | | |/ _ \\  __| | '_ \\ \\___ \\ / _ \\/ / \n" +
            "  | |__| | |_| |  __/ |____| | | |____) |  __/_|  \n" +
            "   \\___\\_\\\\__,_|\\___|______|_| |_|_____/ \\___(_)\n\n" +
            " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
            " " + nomPantalla + "\n" +
            " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
        );
    }
    
    /**
     * Mostrar llista numerada per consola
     * 
     * @param it Iterador de la llista a mostrar
     * @pre Ø
     * @post S'ha escrit per consola la llista de elements amb els seus índexs
     */
    public static void mostraLlista(Iterator<String> it) {
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
     * Mostrar llista numerada per consola
     * 
     * @param llistaElements Llista a mostrar
     * @pre Ø
     * @post S'ha escrit per consola la llista de elements amb els seus índexs
     */
    public static void mostraLlista(ArrayList<String> llistaElements) {
        mostraLlista(llistaElements.iterator());
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
        Iterator<String> itElements = llistaElements.iterator();
        Iterator<Boolean> itMarcats = elementsMarcats.iterator();
        int i = 0;
        Boolean estaMarcat;
        String element;
        while(itElements.hasNext()){
            element = itElements.next();
            estaMarcat  = itMarcats.next();
            System.out.print(i + " [");
            if(estaMarcat) System.out.print("X");
            else System.out.print(" ");
            System.out.print("] " + element + "\n");
            ++i;
        }
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
        Integer n = null;
        Boolean llegit = Boolean.FALSE;
        Scanner s = new Scanner(System.in);
        
        while(!llegit) {
            System.out.print(peticio + " (entre " + min + " i " + max + " ): ");
            String txt = s.nextLine();
            
            if(!txt.matches("-?\\d+"))
                continue;
            
            n = Integer.parseInt(txt);
            
            if(min <= n && n <= max)
                llegit = Boolean.TRUE;
        }
        
        return n;
    }
    
    /**
     * Demanar text a l'usuari per consola
     * 
     * @param peticio Text a mostrar a l'usuari
     * @pre Ø
     * @post el valor de retorn no es buit
     * @return el valor introduit per l'usuari
     */
    public static String demanarText(String peticio) {
        System.out.print(peticio + ": ");
        
        Scanner s = new Scanner(System.in);
        String txt = s.nextLine();
        return txt;
    }
    
    /**
     * Demanar text a l'usuari per consola
     * 
     * @param peticio Text a mostrar a l'usuari
     * @pre Ø
     * @return el valor introduit per l'usuari
     */
    public static Boolean demanarBool(String peticio) {
        String txt = demanarText(peticio + "(si/no)");
        
        while(!("si".equals(txt) || "no".equals(txt)))
            txt = demanarText(peticio + "(si/no)");
        
        return "si".equals(txt);
    }
    
    
    /**
     * Demanar data a l'usuari per consola
     * 
     * @pre Ø
     * @post el valor de retorn no es buit
     * @return la data introduida per l'usuari
     */
    public static Date demanaData(String peticio) {
        Boolean llegit = Boolean.FALSE;
        String txt = "";
        Date d = new Date(0);
            
        while(!llegit) {
            txt = demanarText(peticio + "(YYYY-MM-DD)");
            
            if(!txt.matches("(?:\\d{4})[-](?:0[1-9]|1[012])[-](?:0[1-9]|[12][0-9]|3[01])"))
                continue;
            
            try {
                d = new SimpleDateFormat("yyyy-MM-dd").parse(txt);
                llegit = Boolean.TRUE;
            } catch (Exception e) {
            }
        }
        
        return d;
    }
}

