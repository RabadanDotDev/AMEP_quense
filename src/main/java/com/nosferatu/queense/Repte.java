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
     * Afegeix la proposta identificada per idProposta al repte diferenciat
     * 
     * @param idProposta La proposta a afegir
     * @pre hiHaLaPropostaIdPropostaAlEnigmaFont && !hiHaProposta(idProposta)
     * @post hiHaProposta(idProposta)
     */
    public void seleccionarProposta(String idProposta) {
       _propostes.put(idProposta, _enigmaFont.encaixarProposta(idProposta));
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
     * Comprovar si hi ha una proposta identificada per idProposta 
     * 
     * @param idProposta El id de la proposta
     * @pre Ø
     * @return True si existeix una proposta identificada per idProposta, false en cas contrari.
     */
    public Boolean hiHaProposta(String idProposta) {
        return _propostes.containsKey(idProposta);
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
