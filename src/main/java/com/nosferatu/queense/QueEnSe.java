/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.nosferatu.queense;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author raul
 */
public class QueEnSe {
    static K k;

    public static void main(String[] args) {
        k = new K();
        
        TestsFuncionsK.testNouEnigma(k);
        TestsFuncionsK.testNouTaulell(k);
        TestsFuncionsK.testNouJoc(k, Boolean.TRUE);
        TestsFuncionsK.testNouJoc(k, Boolean.TRUE);
        TestsFuncionsK.testNouJoc(k, Boolean.FALSE);
        
        inici();
    }
    

    public static void inici(){
        Boolean sortir = Boolean.FALSE;
        while(!sortir) {
            UtilityCLI.printNomPantalla("Pantalla inicial");

            ArrayList<String> opcionsMenu = new ArrayList<>(Arrays.asList(
                    "Jugar taulell",
                    "Crear enigma",
                    "Crear taulell",
                    "Sortir",
                    "Eliminar suspesos"
            ));
            
            UtilityCLI.mostraLlista(opcionsMenu);
            
            switch(UtilityCLI.demanarNombre("Acció: ", 0, 4)) {
                case 0:
                    jugarTaulell();
                    break;
                case 1:
                    crearEnigma();
                    break;
                case 2:
                    crearTaulell();
                    break;
                case 3:
                    sortir = Boolean.TRUE;
                    break;
                case 4:
                    eliminarSuspesos();
                    break;
            }
        } 
    }
    
    public static void jugarTaulell(){
        UtilityCLI.printNomPantalla("Selecció de taulell");
        
        ArrayList<String> taulells = new ArrayList<>();
        {
            Iterator<Taulell> it = k.recuperarIteradorTaulells();
            while(it.hasNext()) {
                Taulell t = it.next();
                taulells.add(t.obtenirNom());
            }
        }
        
        UtilityCLI.mostraLlista(taulells);
        UtilityCLI.demanarNombre("Taulell a jugar: ", 0, 4);
    }
    
    public static void crearEnigma(){
        printNomPantalla("Creació de enigma");
        UtilityCLI.demanarNombre("Acció: ", 0, 4);
    }
    
    public static void crearTaulell(){
        printNomPantalla("Creació de taulel");
        UtilityCLI.demanarNombre("Acció: ", 0, 4);
    }
    
    public static void eliminarSuspesos(){
        printNomPantalla("Eliminació de suspesos");
        
        System.out.print("Data actual       " + new Date() + "\n");
        System.out.print("Ultima eliminació " + k.obtenirDataDarreraEliminacio() + "\n");
        System.out.print("Esborrant suspesos ... \n");
        k.esborrarSuspesos();
        System.out.print("Suspesos esborrats \n");
        System.out.print("Ultima eliminació " + k.obtenirDataDarreraEliminacio() + "\n");
    }
}
