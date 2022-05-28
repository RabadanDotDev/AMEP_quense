package com.nosferatu.queense;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Taulell {
    String _nomTaulell;
    Date _dataExpiracio;
    Boolean _esValid;
    Integer _numReptes;
    Map<String, Repte> _reptes;
    Repte _repteDiferenciat;
    Map<String, Joc> _jocs;
    
    /**
     * Constructor taulell
     * 
     * @param nomTaulell El nom del taulell
     * @param dataExpiracio La data d'expiració del taulell
     */
    public Taulell(String nomTaulell, Date dataExpiracio) {
        _nomTaulell = nomTaulell;
        _dataExpiracio = dataExpiracio;
        _esValid = true;
        _numReptes = 0;
        _reptes = new HashMap<>();
        _jocs = new HashMap<>();
    }
    
    /**
     * Inicia la creació d'un nou repte
     * 
     * @param e L'enigma font
     * @pre (!hiHaRepteDiferenciat() || teElRepteDiferenciatFlorIObstacle())
     * @post hiHaRepteDiferenciat() && estadistiquesRepteActualitzades && (!hiHaRepteDiferenciat() || s'ha posat el tipus correcte al repte diferenciat anterior)
     */
    public void iniciNouRepte(Enigma e) {
        if(this.hiHaRepteDiferenciat())
            this.posarRepteTipusCorrecte();
        
        this.crearRepte(e);
        this.actualitzarEstadistiquesRepte(e);
    }
    
    /**
     * TODO descripció
     * 
     * @param idProposta TODO
     * @pre TODO
     * @post TODO
     */
    public void seleccionarProposta(String idProposta) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @pre TODO
     * @post TODO
     */
    public void fiNouTaulell() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * Posar al repte diferenciat el tipus correcte
     * 
     * @pre hiHaRepteDiferenciat()
     * @post El repte té el tipus correcte
     */
    private void posarRepteTipusCorrecte() {
        _repteDiferenciat.posarRepteTipusCorrecte();
    }
    
    /**
     * Creador d'un repte a partir d'un enigma
     * 
     * @param e Enigma font
     * @pre Ø
     * @post Hi ha un nou repte i aquest es el diferenciat
     */
    private void crearRepte(Enigma e) {
        _repteDiferenciat = new Repte(e, this);
        _reptes.put(UUID.randomUUID().toString(), _repteDiferenciat);
    }
    
    /**
     * Actualitza el nombre de reptes de l'enigma y el taulell
     * 
     * @param e Enigma a actualitzar
     * @pre Ø
     * @post S'ha incrementat en un el nombre de reptes del taulell i de e
     */
    private void actualitzarEstadistiquesRepte(Enigma e) {
        _numReptes++;
        e.actualitzarEstadístiquesRepte();
    }
    
    /**
     * 
     * @return true si hi ha un repte diferenciat, false en cas contrari
     */
    public Boolean hiHaRepteDiferenciat() {
        return !(_repteDiferenciat == null);
    }
    
    /**
     * TODO
     * 
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean teElRepteDiferenciatFlorIObstacle() {
        throw new UnsupportedOperationException("Per programar.");
    }

    /**
     * TODO
     * 
     * @param idProposta
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean hiHaPropostaDinsDeRepteDiferenciat(String idProposta) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @param l
     * @pre TODO
     * @post TODO
     */
    public void iniciNouJocLlull(Llull l) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @pre TODO
     * @post TODO
     */
    public void iniciNouJocAnonim() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @param idRepte
     * @pre TODO
     * @post TODO
     */
    public void iniciNovaTirada(String idRepte) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @param idProposta
     * @pre TODO
     * @post TODO
     */
    public void introduccióTria(String idProposta) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @pre TODO
     * @post TODO
     */
    public void fiJoc() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO
     * 
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean hiHaJocDiferenciat() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO
     * 
     * @param idRepte
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean hiHaRepte(String idRepte) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO
     * 
     * @param idRepte
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean hiHaTiradaPelRepteAlJocDiferenciat(String idRepte) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO
     * 
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean hiHaTiradaDiferenciada() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO
     * 
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean teTiradaDiferenciadaTria() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO
     * 
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean jocDiferenciatEsComplet() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO
     * 
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean esValid() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO
     * 
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public String obtenirNom() {
        throw new UnsupportedOperationException("Per programar.");
    }
}
