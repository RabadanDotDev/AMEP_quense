/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.nosferatu.queense;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author raul
 */
public class QueEnSe {
    static K k;

    public static void main(String[] args) {
        k = new K();
        inici();
        /*
        TestsFuncionsK.testNouEnigma(k);
        TestsFuncionsK.testNouTaulell(k);
        TestsFuncionsK.testNouJoc(k, Boolean.TRUE);
        TestsFuncionsK.testNouJoc(k, Boolean.TRUE);
        TestsFuncionsK.testNouJoc(k, Boolean.FALSE);
        TestsFuncionsK.testEsborrarSuspesos(k);*/
    }
    
    public static void printNomPantalla(String nomPantalla){
        System.out.print(
            " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
            "    _  ____         __  ______        _____   _____  \n" +
            "   (_)/ __ \\        \\_\\|  ____|      / ____| /_/__ \\ \n" +
            "   | | |  | |_   _  ___| |__   _ __ | (___   ___  ) |\n" +
            "  / /| |  | | | | |/ _ \\  __| | '_ \\ \\___ \\ / _ \\/ / \n" +
            " | (_| |__| | |_| |  __/ |____| | | |____) |  __/_|  \n" +
            "  \\___\\___\\_\\\\__,_|\\___|______|_| |_|_____/ \\___(_)\n\n" +
            " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
            " " + nomPantalla + "\n" +
            " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n"
        );
    }
    
    public static void inici(){
        Boolean sortir = Boolean.FALSE;
        while(!sortir) {
            printNomPantalla("Pantalla inicial");

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
        printNomPantalla("Selecció de taulell");
    }
    
    public static void crearEnigma(){
        printNomPantalla("Creació de enigma");
    }
    
    public static void crearTaulell(){
        printNomPantalla("Creació de taulel");
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
