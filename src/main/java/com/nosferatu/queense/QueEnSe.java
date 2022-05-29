/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.nosferatu.queense;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author raul
 */
public class QueEnSe {
    static K k;

    public static void main(String[] args) {
        if(null == System.console()) {
            JOptionPane.showMessageDialog(null, "GUI no disponible. Si us plau, executeu el programa des d'una consola de comandes amb \"java -jar $nomDelArxiu\"");
        }
        
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
                        UtilityCLI.demanarText("Prem intro per continuar...");
                        break;
                    }
                    if(nomLlull == "") {
                        System.out.print("Cal introduir un nom de Llull. ");
                        UtilityCLI.demanarText("Prem intro per continuar...");
                        break;
                    }
                    
                    k.iniciNouJocLlull(nomLlull, nomTaulell);
                    seleccioRepteJoc(k.recuperarTaulell(nomTaulell));
                    
                    break;
                case 2:
                    if(nomTaulell == "") {
                        System.out.print("Cal seleccionar un taulell. ");
                        UtilityCLI.demanarText("Prem intro per continuar...");
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
                        UtilityCLI.demanarText("Prem intro per continuar...");
                        break;
                    }
                    
                    if(reptesAmbTirada.get(indexSeleccionat - 3)) {
                        System.out.print("Cal seleccionar un repte sense tirada. ");
                        UtilityCLI.demanarText("Prem intro per continuar...");
                        break;
                    }
                    
                    k.iniciNovaTirada(idRepte);
                    seleccioPropostaTirada(k.recuperarRepte(t, idRepte));
                    reptesAmbTirada.set(indexSeleccionat - 3, Boolean.TRUE);
                    
                    break;
                case 1:
                    if(reptesAmbTirada.indexOf(Boolean.FALSE) != -1) {
                        System.out.print("Falten reptes sense tirada. ");
                        UtilityCLI.demanarText("Prem intro per continuar...");
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
            System.out.print("Tipus: " + r.obtenirTipus().toString() + "\n");
            
            UtilityCLI.mostraLlista(opcions, seleccio);
            Integer n = UtilityCLI.demanarNombre("Selecciona una opció: ", 0, opcions.size()-1);
            switch(n){
                case 0:
                    if(seleccio.indexOf(Boolean.TRUE) == -1) {
                        System.out.print("S'ha de seleccionar al menys una proposta. ");
                        UtilityCLI.demanarText("Prem intro per continuar...");
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
        
        String nomEnigma = "";
        String enunciat = "";
        ArrayList<String> propostes = new ArrayList<>(); 
        ArrayList<Boolean> correcta = new ArrayList<>(); 
        
        ArrayList<String> opcions = new ArrayList<>();
        {
            opcions.add("Posar nom a l'enigma");
            opcions.add("Posar enunciat a l'enigma");
            opcions.add("Crear proposta");
            opcions.add("Finalitzar");
        }
        
        while(!sortir) {
            UtilityCLI.printNomPantalla("Creació de enigma");
            System.out.print("Propostes creades: \n");
            UtilityCLI.mostraLlista(propostes, correcta);
            System.out.print("Nom enigma: " + nomEnigma + "\n");
            System.out.print("Enunciat: " + enunciat + "\n");
            
            UtilityCLI.mostraLlista(opcions);
            Integer n = UtilityCLI.demanarNombre("Selecciona una opció: ", 0, opcions.size()-1);
            switch(n){
                case 0:
                    nomEnigma = UtilityCLI.demanarText("Introdueix nom de l'enigma");
                    break;
                case 1:
                    enunciat = UtilityCLI.demanarText("Introdueix l'enunciat de l'enigma");
                    break;
                case 2:
                    String text = UtilityCLI.demanarText("Text proposta");
                    Boolean b = UtilityCLI.demanarBool("Es correcta");
                    
                    propostes.add(text);
                    correcta.add(b);
                    break;
                case 3:
                    if(nomEnigma == "") {
                        System.out.print("Cal posar nom a l'enigma. ");
                        UtilityCLI.demanarText("Prem intro per continuar...");
                        break;
                    }
                    
                    if(k.hiHaEnigmaAnomenat(nomEnigma)) {
                        System.out.print("El nom de l'enigma ha de ser nou. ");
                        UtilityCLI.demanarText("Prem intro per continuar...");
                        break;
                    }
                    
                    if(enunciat == "") {
                        System.out.print("Cal un enunciat. ");
                        UtilityCLI.demanarText("Prem intro per continuar...");
                        break;
                    }
                    
                    if(correcta.indexOf(Boolean.TRUE) == -1 || correcta.indexOf(Boolean.FALSE) == -1) {
                        System.out.print("S'ha de afegir una flor i una pedra. ");
                        UtilityCLI.demanarText("Prem intro per continuar...");
                        break;
                    }
                    
                    k.iniciNouEnigma(nomEnigma, enunciat);
                    
                    for (int i = 0; i < propostes.size(); i++)
                        k.introduirProposta(propostes.get(i), correcta.get(i));
                    
                    k.fiNouEnigma();
                    
                    sortir = Boolean.TRUE;
                    
                    break;
            }
        }
    }
    
    public static void crearTaulell(){
        Boolean sortir = Boolean.FALSE;
        
        // Demanar nom taulell
        String nomTaulell = UtilityCLI.demanarText("Introdueix el nom del taulell");
        while(k.hiHaTaulellAnomenat(nomTaulell)) {
            System.out.print("Taulell ya existent");
            nomTaulell = UtilityCLI.demanarText("Introdueix el nom del taulell");
        }
        
        // Demanar data expiració
        Date dataExpiracio = UtilityCLI.demanaData("Introdueix la data d'expiració del taulell");
        while(!dataExpiracio.after(new Date())) {
            System.out.print("La data ha de ser posterior a avui. \n");
            dataExpiracio = UtilityCLI.demanaData("Introdueix la data d'expiració del taulell");
        }
        
        k.iniciNouTaulell(nomTaulell, dataExpiracio);
        
        ArrayList<String> enigmesDisponibles = new ArrayList<>();
        Iterator<Enigma> it = k.recuperarIteradorEnigmes();
        while(it.hasNext()) {
            Enigma e = it.next();
            enigmesDisponibles.add(e.obtenirNom());
        }
        
        // crear reptes
        do {
            UtilityCLI.mostraLlista(enigmesDisponibles);
            Integer i = UtilityCLI.demanarNombre("Escull un enigma font", 0, enigmesDisponibles.size()-1);
            k.iniciNouRepte(enigmesDisponibles.get(i));
            crearRepte(enigmesDisponibles.get(i));
        } while (UtilityCLI.demanarBool("Crear un altre repte?"));
        
        k.fiNouTaulell();
    }
    
    public static void crearRepte(String idEnigma) {
        Boolean sortir = Boolean.FALSE;
        
        ArrayList<String> opcions = new ArrayList<>();
        ArrayList<Boolean> seleccio = new ArrayList<>();
        ArrayList<Boolean> correctesa = new ArrayList<>();
        ArrayList<String> idsProposta = new ArrayList<>();
        Integer numObstacles = 0;
        Integer numLlavors = 0;
        {
            opcions.add("Finalitzar");
            seleccio.add(Boolean.FALSE);
            opcions.add("----------------");
            seleccio.add(Boolean.FALSE);

            Iterator<Proposta> it = k.recuperarIteradorPropostes(k.recuperarEnigma(idEnigma));
            while(it.hasNext()) {
                Proposta p = it.next();
                idsProposta.add(p.obtenirId());
                opcions.add(p.obtenirText());
                correctesa.add(p.esCorrecta());
                seleccio.add(Boolean.FALSE);
            }
        }
        
        while(!sortir) {
            UtilityCLI.printNomPantalla("Selecció de proposta");
            System.out.print("num llavors " + numLlavors + "\n");
            System.out.print("num obstacles " + numObstacles + "\n");
            
            UtilityCLI.mostraLlista(opcions, seleccio);
            Integer n = UtilityCLI.demanarNombre("Selecciona una opció: ", 0, opcions.size()-1);
            switch(n){
                case 0:
                    if(seleccio.indexOf(Boolean.TRUE) == -1) {
                        System.out.print("S'ha de seleccionar al menys una proposta. ");
                        UtilityCLI.demanarText("Prem intro per continuar...");
                        break;
                    }
                    
                    if(!(0 < numLlavors && 0 < numObstacles)) {
                        System.out.print("S'ha de seleccionar al menys una proposta correcta i una d'incorrecta. ");
                        UtilityCLI.demanarText("Prem intro per continuar...");
                        break;
                    }
                    
                    for (int i = 2; i < seleccio.size(); i++) {
                        if(seleccio.get(i))
                            k.seleccionarProposta(idsProposta.get(i - 2));
                    }
                    
                    sortir = Boolean.TRUE;
                    break;
                case 1:
                    break;
                default:
                    Boolean estaba_selecionada = seleccio.get(n);
                    
                    if(estaba_selecionada) {
                        if(correctesa.get(n - 2)) {
                            numLlavors--;
                        } else {
                            numObstacles--;
                        }
                    } else {
                        if(correctesa.get(n - 2)) {
                            numLlavors++;
                        } else {
                            numObstacles++;
                        }
                    }
                    
                    seleccio.set(n, !seleccio.get(n));
            }
        }
    }
    
    public static void eliminarSuspesos(){
        UtilityCLI.printNomPantalla("Eliminació de suspesos");
        
        System.out.print("Data actual       " + new Date() + "\n");
        System.out.print("Ultima eliminació " + k.obtenirDataDarreraEliminacio() + "\n");
        System.out.print("Esborrant suspesos ... \n");
        k.esborrarSuspesos();
        System.out.print("Suspesos esborrats \n");
        System.out.print("Ultima eliminació " + k.obtenirDataDarreraEliminacio() + "\n");
        UtilityCLI.demanarText("Prem intro per continuar...");
    }
}
