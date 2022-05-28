package com.nosferatu.queense;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Enigma {
    String _nomEnigma;
    String _textEnunciat;
    Integer _numReptes;
    Map<String, Proposta> _propostes;
    
    /**
     * Constructor
     * 
     * @param nomEnigma El nom del nou l'enigma
     * @param textEnunciat L'enunciat de l'enigma
     */
    public Enigma(String nomEnigma, String textEnunciat) {
        _nomEnigma = nomEnigma;
        _textEnunciat = textEnunciat;
        _numReptes = 0;
        _propostes = new HashMap<>();
    }
    
    /**
     * Introductor de propostes
     * 
     * @param textProposta TODO
     * @param esCorrecta TODO
     * @pre Ø
     * @post S'ha creat una proposta amb textProposta i correctesa esCorrecta dins de l'enigma
     */
    public void introduirProposta(String textProposta, Boolean esCorrecta) {
        Proposta p = new Proposta(textProposta, esCorrecta);
        _propostes.put(UUID.randomUUID().toString(), p);
    }
    
    /**
     * Consultor nombre de pedres
     * 
     * @pre Ø
     * @return Retorna el nombre de propostes incorrectes contingudes
     */
    public Integer numPedres() {
        return _propostes.values().stream().mapToInt(Proposta::retorna1SiIncorrecta).sum();
    }
    
    /**
     * Consultor nombre de flors
     * 
     * @pre Ø
     * @return Retorna el nombre de propostes correctes contingudes
     */
    public Integer numFlors() {
        return _propostes.values().stream().mapToInt(Proposta::retorna1SiCorrecta).sum();
    }
    
    /**
     * Descripción TODO
     * 
     * @pre TODO
     * @post TODO
     */
    public void actualitzarEstadístiquesRepte() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * Descripción TODO
     * 
     * @param idProposta TODO
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Proposta encaixarProposta(String idProposta) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * Descripción TODO
     * 
     * @param idProposta
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public Boolean hiHaProposta(String idProposta) {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * Descripción TODO
     * 
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public String obtenirNom() {
        throw new UnsupportedOperationException("Per programar.");
    }
    
    /**
     * Descripción TODO
     * 
     * @pre TODO
     * @post TODO
     * @return TODO
     */
    public String obtenirEnunciat() {
        throw new UnsupportedOperationException("Per programar.");
    }
}
