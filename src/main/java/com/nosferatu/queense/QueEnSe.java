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
        
        while(!sortir) {
            UtilityCLI.printNomPantalla("Selecció de taulell");
            System.out.print("Nom llull: " + nomLlull + "\n");
            System.out.print("Nom taulell seleccionat: " + nomTaulell + "\n");
      
            UtilityCLI.mostraLlista(opcions);
            Integer n = UtilityCLI.demanarNombre("Selecciona una opció: ", 0, opcions.size()-1);
            switch(n) {
                case 0:
                    nomLlull = UtilityCLI.demanarText("Introdueix el nom del llull");
                    break;
                case 1:
                    if(nomTaulell == "") {
                        System.out.print("Cal seleccionar un taulell. ");
                        UtilityCLI.demanarText("Pressiona intro per continuar...");
                        break;
                    }
                    if(nomLlull == "") {
                        System.out.print("Cal introduir un nom de Llull. ");
                        UtilityCLI.demanarText("Pressiona intro per continuar...");
                        break;
                    }
                    
                    k.iniciNouJocLlull(nomLlull, nomTaulell);
                    seleccioRepteJoc(k.recuperarTaulell(nomTaulell));
                    
                    break;
                case 2:
                    if(nomTaulell == "") {
                        System.out.print("Cal seleccionar un taulell. ");
                        UtilityCLI.demanarText("Pressiona intro per continuar...");
                        break;
                    }
                    
                    k.iniciNouJocAnonim(nomTaulell);
                    seleccioRepteJoc(k.recuperarTaulell(nomTaulell));
                    
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
    
    public static void seleccioRepteJoc(Taulell t) {
        Boolean sortir = Boolean.FALSE;
        Integer indexSeleccionat = -1;
        String idRepte = "";
        
        ArrayList<String> opcions = new ArrayList<>();
        ArrayList<Boolean> reptesAmbTirada = new ArrayList<>();
        {
            opcions.add("Fer tirada repte seleccionat");
            opcions.add("Finalitzar");
            opcions.add("----------------");

            Iterator<Repte> it = k.recuperarIteradorReptes(t);
            while(it.hasNext()) {
                Repte r = it.next();
                opcions.add(r.obtenirId());
                reptesAmbTirada.add(Boolean.FALSE);
            }
        }
        
        while(!sortir) {
            UtilityCLI.printNomPantalla("Selecció de repte");
            System.out.print("index seleccionat: " + indexSeleccionat + "\n");
            System.out.print("id repte seleccionat: " + idRepte + "\n");
                        
            UtilityCLI.mostraLlista(opcions);
            Integer n = UtilityCLI.demanarNombre("Selecciona una opció: ", 0, opcions.size()-1);
            switch(n) {
                case 0:
                    if(indexSeleccionat == -1) {
                        System.out.print("Cal seleccionar un repte. ");
                        UtilityCLI.demanarText("Pressiona intro per continuar...");
                        break;
                    }
                    
                    if(reptesAmbTirada.get(indexSeleccionat - 3)) {
                        System.out.print("Cal seleccionar un repte sense tirada. ");
                        UtilityCLI.demanarText("Pressiona intro per continuar...");
                        break;
                    }
                    
                    k.iniciNovaTirada(idRepte);
                    seleccioPropostaTirada(k.recuperarRepte(t, idRepte));
                    reptesAmbTirada.set(indexSeleccionat - 3, Boolean.TRUE);
                    
                    break;
                case 1:
                    if(reptesAmbTirada.indexOf(Boolean.FALSE) != -1) {
                        System.out.print("Falten reptes sense tirada. ");
                        UtilityCLI.demanarText("Pressiona intro per continuar...");
                        break;
                    }
                    
                    k.fiJoc();
                    sortir = Boolean.TRUE;
                    break;
                case 2:
                    break;
                default:
                    indexSeleccionat = n;
                    idRepte = opcions.get(n);
            }
        }
        
    }
    
    public static void seleccioPropostaTirada(Repte r){
        Boolean sortir = Boolean.FALSE;
        
        String enunciat = k.recuperarCopiaEnigma(r).obtenirEnunciat();
        ArrayList<String> opcions = new ArrayList<>();
        ArrayList<Boolean> seleccio = new ArrayList<>();
        ArrayList<String> idsProposta = new ArrayList<>();
        {
            opcions.add("Finalitzar");
            seleccio.add(Boolean.FALSE);
            opcions.add("----------------");
            seleccio.add(Boolean.FALSE);

            Iterator<Proposta> it = k.recuperarIteradorPropostes(r);
            while(it.hasNext()) {
                Proposta p = it.next();
                opcions.add(p.obtenirText());
                seleccio.add(Boolean.FALSE);
                idsProposta.add(p.obtenirId());
            }
        }
        
        while(!sortir) {
            UtilityCLI.printNomPantalla("Selecció de proposta");
            System.out.print("Enigma: " + enunciat + "\n");
            
            UtilityCLI.mostraLlista(opcions, seleccio);
            Integer n = UtilityCLI.demanarNombre("Selecciona una opció: ", 0, opcions.size()-1);
            switch(n){
                case 0:
                    if(seleccio.indexOf(Boolean.TRUE) == -1) {
                        System.out.print("S'ha de seleccionar al menys una proposta. ");
                        UtilityCLI.demanarText("Pressiona intro per continuar...");
                        break;
                    }
                    
                    for (int i = 2; i < seleccio.size(); i++) {
                        if(seleccio.get(i))
                            k.introduccioTria(idsProposta.get(i - 2));
                    }
                    
                    sortir = Boolean.TRUE;
                    
                    break;
                case 1:
                    break;
                default:
                    seleccio.set(n, !seleccio.get(n));
            }
        }
    }
    
    public static void crearEnigma(){
        Boolean sortir = Boolean.FALSE;
        
        String enunciat = "";
        ArrayList<String> opcions = new ArrayList<>();
        {
            opcions.add("Posar nom a l'enigma");
            opcions.add("Posar enunciat a l'enigma");
            opcions.add("Crear proposta");
            opcions.add("Finalitzar");
            opcions.add("----------------");
        }
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
