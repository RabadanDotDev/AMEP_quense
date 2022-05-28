/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.nosferatu.queense;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author raul
 */
public class QueEnSe {

    public static void main(String[] args) {
        K k = new K();
        testNouEnigma(k);
        testNouTaulell(k);
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
    
    public static void testNouTaulell(K k){       
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        System.out.print("test nou enigma\n");
        System.out.print("Taulell diferenciat " + k.hiHaTaulellDiferenciat() + "\n");
        System.out.print("Taulell anomenat 'El taulell 1' " + k.hiHaTaulellAnomenat("El taulell 1") + "\n");
        
        k.iniciNouTaulell("El taulell 1", new Date(2022, 12, 5));
        
        System.out.print("Taulell diferenciat " + k.hiHaTaulellDiferenciat() + "\n");
        System.out.print("Taulell anomenat 'El taulell 1' " + k.hiHaTaulellAnomenat("El taulell 1") + "\n");
        
        {
            System.out.print("enigmes");
            Iterator<Enigma> it = k.recuperarIteradorEnigmes();
            while(it.hasNext()) {
                Enigma e = it.next();
                System.out.print("[" + e.obtenirNom() + " " + e.obtenirEnunciat() + " {");
                
                Iterator<Proposta> it2 = k.recuperarIteradorPropostes(e);
                while(it2.hasNext()) {
                    Proposta p = it2.next();
                    System.out.print(p.obtenirText() + " " + p.esCorrecta());
                    if(it2.hasNext()) {
                        System.out.print(", ");
                    }
                }
                
                System.out.print("}");
            }
            System.out.print("]\n");
        }
        
        System.out.print("Enigma anomenat suma curiosa " + k.hiHaEnigmaAnomenat("Suma curiosa") + "\n");
        System.out.print("Taulell diferenciat " + k.hiHaTaulellDiferenciat() + "\n");
        System.out.print("Repte diferenciat " + k.hiHaRepteDiferenciat()+ "\n");
        
        {
            System.out.print("....... Suma normal ....... \n");
            k.iniciNouRepte("Suma normal");
            System.out.print("Repte diferenciat - " + k.teElRepteDiferenciatFlorIObstacle() + "\n");
        
            System.out.print("Repte diferenciat " + k.hiHaRepteDiferenciat()+ "\n");

            List<String> ids = new ArrayList<>();
            Enigma e = k.recuperarEnigma("Suma normal");
            {
                Iterator<Proposta> it = k.recuperarIteradorPropostes(e);
                while(it.hasNext()) {
                    Proposta p = it.next();
                    ids.add(p.obtenirId());
                }
            }

            for (String s : ids) {

                System.out.print("Id proposta" + s + " a l'enigma " + e.obtenirNom() + " " + k.hiHaPropostaDinsDeEnigma(e, s) + "\n");
                System.out.print("Id proposta" + s + " al repte diferenciat " + k.hiHaPropostaDinsDeRepteDiferenciat(s) + "\n");

                k.seleccionarProposta(s);
                System.out.print("Repte diferenciat - " + k.teElRepteDiferenciatFlorIObstacle() + "\n");

                System.out.print("Id proposta" + s + " al repte diferenciat " + k.hiHaPropostaDinsDeRepteDiferenciat(s) + "\n");
            }

            System.out.print("Repte diferenciat - " + k.teElRepteDiferenciatFlorIObstacle() + "\n");
        }
            
        {
            System.out.print("....... Suma curiosa ....... \n");
            k.iniciNouRepte("Suma curiosa");
            System.out.print("Repte diferenciat - " + k.teElRepteDiferenciatFlorIObstacle() + "\n");
        
            System.out.print("Repte diferenciat " + k.hiHaRepteDiferenciat()+ "\n");

            List<String> ids = new ArrayList<>();
            Enigma e = k.recuperarEnigma("Suma curiosa");
            {
                Iterator<Proposta> it = k.recuperarIteradorPropostes(e);
                while(it.hasNext()) {
                    Proposta p = it.next();
                    ids.add(p.obtenirId());
                }
            }

            for (String s : ids) {

                System.out.print("Id proposta" + s + " a l'enigma " + e.obtenirNom() + " " + k.hiHaPropostaDinsDeEnigma(e, s) + "\n");
                System.out.print("Id proposta" + s + " al repte diferenciat " + k.hiHaPropostaDinsDeRepteDiferenciat(s) + "\n");

                k.seleccionarProposta(s);
                System.out.print("Repte diferenciat - " + k.teElRepteDiferenciatFlorIObstacle() + "\n");

                System.out.print("Id proposta" + s + " al repte diferenciat " + k.hiHaPropostaDinsDeRepteDiferenciat(s) + "\n");
            }
            
            System.out.print("Repte diferenciat - " + k.teElRepteDiferenciatFlorIObstacle() + "\n");
        }
        
        System.out.print("Taulell diferenciat " + k.hiHaTaulellDiferenciat() + "\n");
        System.out.print("Repte diferenciat " + k.hiHaRepteDiferenciat()+ "\n");
        System.out.print("Repte diferenciat - " + k.teElRepteDiferenciatFlorIObstacle() + "\n");
        
        System.out.print("....... fi taulell ....... \n");
        k.fiNouTaulell();
        System.out.print("Repte diferenciat " + k.hiHaRepteDiferenciat()+ "\n");
        System.out.print("Taulell diferenciat " + k.hiHaTaulellDiferenciat() + "\n");
        
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
}
