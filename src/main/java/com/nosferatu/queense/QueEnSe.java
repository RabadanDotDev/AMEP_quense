/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.nosferatu.queense;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author raul
 */
public class QueEnSe {

    public static void main(String[] args) {
        K k = new K();
        testNouEnigma(k);
    }
    
    public static void testNouEnigma(K k){
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.print("test nou enigma\n");
        
        System.out.print("Diferenciat " + k.hiHaEnigmaDiferenciat() + "\n");
        System.out.print("Enigma anomenat suma curiosa " + k.hiHaEnigmaAnomenat("Suma curiosa") + "\n");
        
        k.iniciNouEnigma("Suma curiosa", "2+2 =");
        
        System.out.print("Diferenciat " + k.hiHaEnigmaDiferenciat() + "\n");
        System.out.print("Enigma anomenat suma curiosa " + k.hiHaEnigmaAnomenat("Suma curiosa") + "\n");
        
        System.out.print("Enigma amb pedra i flor " + k.teEnigmaDiferenciatPedraIFlor() + "\n");
        k.introduirProposta("4", Boolean.TRUE);
        System.out.print("Enigma amb pedra i flor " + k.teEnigmaDiferenciatPedraIFlor() + "\n");
        k.introduirProposta("5", Boolean.FALSE);
        System.out.print("Enigma amb pedra i flor " + k.teEnigmaDiferenciatPedraIFlor() + "\n");
        
        k.introduirProposta("5", Boolean.FALSE);
        k.introduirProposta("1254781", Boolean.FALSE);
        k.introduirProposta("Es una referencia a 1984", Boolean.TRUE);
        
        k.fiNouEnigma();
        
        k.iniciNouEnigma("Suma normal", "1+1 =");
        k.introduirProposta("2", Boolean.TRUE);
        k.introduirProposta("3", Boolean.FALSE);
        k.fiNouEnigma();
        
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
}
