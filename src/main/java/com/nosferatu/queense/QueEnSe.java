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
                    seleccioTaulell();
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
    
    public static void seleccioTaulell(){
        Boolean sortir = Boolean.FALSE;
        String nomLlull = "";
        String nomTaulell = "";
        while(!sortir) {
            UtilityCLI.printNomPantalla("Selecció de taulell");
            System.out.print("Nom llull: " + nomLlull + "\n");
            System.out.print("Nom taulell seleccionat: " + nomTaulell + "\n");
        
            ArrayList<String> opcions = new ArrayList<>();
            {
                opcions.add("Introduir nom Llull");
                opcions.add("Jugar");
                opcions.add("Jugar joc anònim");
                opcions.add("Enrere");
                opcions.add("----------------");
            
                Iterator<Taulell> it = k.recuperarIteradorTaulells();
                while(it.hasNext()) {
                    Taulell t = it.next();
                    opcions.add(t.obtenirNom());
                }
            }

            UtilityCLI.mostraLlista(opcions);
            Integer n = UtilityCLI.demanarNombre("Selecciona una opció: ", 0, opcions.size()-1);
            switch(n) {
                case 0:
                    nomLlull = UtilityCLI.demanarText("Introdueix el nom del llull");
                    break;
                case 1:
                    if(nomTaulell == "") {
                        System.out.print("Cal seleccionar un taulell.\n");
                        UtilityCLI.demanarText("Pressiona intro per continuar...");
                        break;
                    }
                    if(nomLlull == "") {
                        System.out.print("Cal introduir un nom de Llull.\n");
                        UtilityCLI.demanarText("Pressiona intro per continuar...");
                        break;
                    }
                    
                    k.iniciNouJocLlull(nomLlull, nomTaulell);
                    jugarJoc();
                    
                    break;
                case 2:
                    if(nomTaulell == "") {
                        System.out.print("Cal seleccionar un taulell.\n");
                        UtilityCLI.demanarText("Pressiona intro per continuar...");
                        break;
                    }
                    
                    k.iniciNouJocAnonim(nomTaulell);
                    jugarJoc();
                    
                    break;
                case 3:
                    sortir = Boolean.TRUE;
                    break;
                case 4:
                    break;
                default:
                    nomTaulell = opcions.get(n);
                    break;
            }
            
        }
    }
    
    public static void jugarJoc() {
        
    }
    
    public static void crearEnigma(){
        UtilityCLI.printNomPantalla("Creació de enigma");
        UtilityCLI.demanarNombre("Acció: ", 0, 4);
    }
    
    public static void crearTaulell(){
        UtilityCLI.printNomPantalla("Creació de taulel");
        UtilityCLI.demanarNombre("Acció: ", 0, 4);
    }
    
    public static void eliminarSuspesos(){
        UtilityCLI.printNomPantalla("Eliminació de suspesos");
        
        System.out.print("Data actual       " + new Date() + "\n");
        System.out.print("Ultima eliminació " + k.obtenirDataDarreraEliminacio() + "\n");
        System.out.print("Esborrant suspesos ... \n");
        k.esborrarSuspesos();
        System.out.print("Suspesos esborrats \n");
        System.out.print("Ultima eliminació " + k.obtenirDataDarreraEliminacio() + "\n");
    }
}
