package com.nosferatu.queense;

import java.util.HashMap;
import java.util.Iterator;
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
     * Actualitza el nombre de reptes que estan fonamentats en l'enigma
     * 
     * @pre Ø
     * @post S'ha incrementat en un el nombre de reptes
     */
    public void actualitzarEstadístiquesRepte() {
        _numReptes++;
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
     * Recuperador del nom de l'enigma
     * 
     * @pre Ø
     * @return El nom
     */
    public String obtenirNom() {
        return _nomEnigma;
    }
    
    /**
     * Recuperador de l'enunciat de l'enigma
     * 
     * @pre Ø
     * @return El text de l'enunciat
     */
    public String obtenirEnunciat() {
        return _textEnunciat;
    }
    
    /**
     * Recuperador de l'iterador de les propostes
     * 
     * @return Iterador de les propostes
     */
    public Iterator<Proposta> recuperarIteradorPropostes() {
        return _propostes.values().iterator();
    }
}
