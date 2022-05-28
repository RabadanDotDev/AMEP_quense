package com.nosferatu.queense;

import java.util.HashMap;
import java.util.Map;

public class Repte {
    Enigma _enigmaFont;
    Taulell _taulellContenedor;
    Integer _numLlavors;
    Integer _numObstacles;
    TipusRepteEnum _tipus;
    Map<String, Proposta> _propostes;
    
    /**
     * Descripción TODO
     * 
     * @param e Enigma font
     * @param t Taulell contenedor
     */
    public Repte(Enigma e, Taulell t) {
        _enigmaFont = e;
        _taulellContenedor = t;
        _numLlavors = _numObstacles = 0;
        _propostes = new HashMap<>();
    }
    
    /**
     * Actualitzar el repte per tal que el tipus sigui correcte
     * 
     * @pre 1 < numLlavors() && 1 < _numObstacles()
     * @post El tipus del repte es correcte
     */
    public void posarRepteTipusCorrecte() {
        if(_numLlavors == 1 && _numObstacles == 1)
            _tipus = TipusRepteEnum.DILEMA;
        else if(_numLlavors == 1 && _numObstacles == 1)
            _tipus = TipusRepteEnum.ELECCIO;
        else if(_numLlavors == 1 && _numObstacles == 1)
            _tipus = TipusRepteEnum.MARCACIO;
    }
    
    /**
     * TODO descripció
     * 
     * @param idProposta
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
     * @return 
     */
    public Integer numLlavors() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @pre TODO
     * @post TODO
     * @return 
     */
    public Integer numObstacles() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @param idProposta
     * @pre TODO
     * @post TODO
     * @return 
     */
    public Boolean hiHaProposta(String idProposta) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @param idProposta
     * @pre TODO
     * @post TODO
     * @return 
     */
    public Proposta encaixarProposta(String idProposta) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @pre TODO
     * @post TODO
     * @return 
     */
    public TipusRepteEnum obtenirTipus() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * TODO descripció
     * 
     * @pre TODO
     * @post TODO
     * @return 
     */
    public Enigma recuperarCopiaEnigma() {
        throw new UnsupportedOperationException("Per programar.");
    }
}
