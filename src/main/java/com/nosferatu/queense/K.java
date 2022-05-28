package com.nosferatu.queense;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class K {
    Date _dataDarreraEliminació;
    Map<String, Enigma> _enigmes;
    Map<String, Taulell> _taulells;
    Enigma _enigmaDiferenciat;
    Taulell _taulellDiferenciat;
    
    /**
     * Constructor K
     * 
     */
    public K(){
        _dataDarreraEliminació = new Date(0);
        _enigmes = new HashMap<>();
        _taulells = new HashMap<>();
    }

    /**
     * Inicia la creació d'un nou enigma
     * 
     * @param nomEnigma El nom del nou l'enigma
     * @param textEnunciat L'enunciat de l'enigma
     * @pre !hiHaEnigmaDiferenciat() && !hiHaEnigmaAnomenat(nomEnigma)
     * @post hiHaEnigmaDiferenciat() && hiHaEnigmaAnomenat(nomEnigma)
     */
    public void iniciNouEnigma(String nomEnigma, String textEnunciat) {
        _enigmaDiferenciat = new Enigma(nomEnigma, textEnunciat);
        _enigmes.put(nomEnigma, _enigmaDiferenciat);
    }

    /**
     * Introdueix una nova propsota a l'enigma en creació
     * 
     * @param textProposta El text de la proposta introduïda.
     * @param esCorrecta Correctesa de la proposta introduïda.
     * @pre hiHaEnigmaDiferenciat()
     * @post S'ha creat una proposta amb textProposta i correctesa esCorrecta dins de l'enigma diferenciat
     */
    public void introduirProposta(String textProposta, Boolean esCorrecta) {
        _enigmaDiferenciat.introduirProposta(textProposta, esCorrecta);
    }

    /**
     * Finalitza la creació del nou enigma
     * 
     * @pre hiHaEnigmaDiferenciat && teEnigmaDiferenciatPedraIFlor()
     * @post !hiHaEnigmaDiferenciat()
     */
    public void fiNouEnigma() {
        _enigmaDiferenciat = null;
    }
    
    /**
     * 
     * @return retorna true si hi ha un enigma diferenciat, false en cas contrari
     */
    public Boolean hiHaEnigmaDiferenciat() {
        Boolean b = _enigmaDiferenciat != null;
        return b;
    }
    
    /**
     * 
     * @param nomEnigma El nom de l'enigma a consultar la seva existència
     * @return True si existeix un enigma anomenat nomEnigma, false en cas contrari.
     */
    public Boolean hiHaEnigmaAnomenat(String nomEnigma) {
        return _enigmes.containsKey(nomEnigma);
    }
    
    /**
     * 
     * @pre hiHaEnigmaDiferenciat()
     * @return True si hi ha al menys una pedra i una flor en el enigma diferenciat, false en cas contrari
     */
    public Boolean teEnigmaDiferenciatPedraIFlor() {
        return 0 < _enigmaDiferenciat.numFlors() && 0 < _enigmaDiferenciat.numPedres();
    }
    
    /**
     * Inicia la creació d'un nou taulell
     * 
     * @param nomTaulell Nom del taulell
     * @param dataExpiracio Data d'exipració del taulell
     * @pre !hiHaTaulellDiferenciat() && !hiHaTaulellAnomenat(nomTaulell) && dataActual() < dataExpiració
     * @post hiHaTaulellDiferenciat() && hiHaTaulellAnomenat(nomTaulell)
     */
    public void iniciNouTaulell(String nomTaulell, Date dataExpiracio) {
        _taulellDiferenciat = new Taulell(nomTaulell, dataExpiracio);
        _taulells.put(nomTaulell, _taulellDiferenciat);
    }
    
    /**
     * Inicia la creació d'un nou repte al taulell diferenciat
     * 
     * @param nomEnigmaFont El nom de l'enigma font
     * @pre hiHaTaulellDiferenciat() && (!hiHaRepteDiferenciat() || teElRepteDiferenciatFlorIObstacle()) && hiHaEnigmaAnomenat(nomEnigmaFont)
     * @post hiHaRepteDiferenciat() && estadistiquesRepteActualitzades && (!hiHaRepteDiferenciat() || s'ha posat el tipus correcte al repte diferenciat anterior)
     */
    public void iniciNouRepte(String nomEnigmaFont) {
        Enigma e = _enigmes.get(nomEnigmaFont);
        _taulellDiferenciat.iniciNouRepte(e);
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
     * TODO
     * 
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean hiHaTaulellDiferenciat() {
        return !(_taulellDiferenciat == null);
    }
    
    /**
     * TODO
     * 
     * @param nomTaulell
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean hiHaTaulellAnomenat(String nomTaulell) {
        return _taulells.containsKey(nomTaulell);
    }
    
    /**
     * 
     * @return true si hi ha un repte diferenciat, false en cas contrari
     */
    public Boolean hiHaRepteDiferenciat() {        
        return hiHaTaulellDiferenciat() && _taulellDiferenciat.hiHaRepteDiferenciat();
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
     * @param e
     * @param idProposta
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean hiHaPropostaDinsDeEnigma(Enigma e, String idProposta) {
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
     * @param nomLlull TODO
     * @param nomTaulell TODO
     * @pre TODO
     * @post TODO
     */
    public void iniciNouJocLlull(String nomLlull, String nomTaulell) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció TODO
     * 
     * @param nomTaulell
     * @pre TODO
     * @post TODO
     */
    public void iniciNouJocAnonim(String nomTaulell) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció TODO
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
     * @param idProposta TODO
     * @pre TODO
     * @post TODO
     */
    public void introduccioTria(String idProposta) {
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
     * @param t
     * @param idRepte
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean hiHaRepteAlTaulell(Taulell t, String idRepte) {
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
     * @param r
     * @param idProposta
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean hiHaPropostaAlRepte(Repte r, String idProposta) {
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
     * TODO descripció
     * 
     * @pre TODO
     * @post TODO
     */
    public void esborrarSuspesos() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO
     * 
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Date obtenirDataDarreraEliminació() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @param nomEnigma
     * @pre TODO
     * @post TODO
     */
    public Enigma recuperarEnigma(String nomEnigma) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @param nomTaulell
     * @pre TODO
     * @post TODO
     */
    public Enigma recuperarTaulell(String nomTaulell) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @param t
     * @param idRepte
     * @pre TODO
     * @post TODO
     */
    public Repte recuperarRepte(Taulell t, String idRepte) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * Recuperador de l'iterador de enigmes
     * 
     * @pre Ø
     * @return Iterador de tots els enigmes
     */
    public Iterator<Enigma> recuperarIteradorEnigmes() {
        return _enigmes.values().iterator();
    }
    
    /**
     * Recuperador de l'iterador de les propostes de l'enigma
     * 
     * @param e L'enigma contenidor de les propostes
     * @return Iterador de les propostes d'e
     */
    public Iterator<Proposta> recuperarIteradorPropostes(Enigma e) {
        return e.recuperarIteradorPropostes();
    }
    
    /**
     * TODO descripció
     * 
     * @pre TODO
     * @post TODO
     * @return 
     */
    public Iterator<Taulell> recuperarIteradorTaulells() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @pre TODO
     * @post TODO
     * @return 
     */
    public Iterator<Repte> recuperarIteradorReptes(Taulell t) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @pre TODO
     * @post TODO
     * @return 
     */
    public Iterator<Proposta> recuperarIteradorPropostes(Repte r) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @pre TODO
     * @post TODO
     * @return 
     */
    public Enigma recuperarCopiaEnigma(Repte r) {
        throw new UnsupportedOperationException("Per programar.");
    }
}
