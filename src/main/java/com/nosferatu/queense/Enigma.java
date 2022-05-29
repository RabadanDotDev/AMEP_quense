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
        _propostes.put(p.obtenirId(), p);
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
     * Encaixa l'id de la proposta
     * 
     * @param idProposta La proposta a encaixar
     * @pre hiHaProposta(idProposta)
     * @return La proposta identificada per idProposta
     */
    public Proposta encaixarProposta(String idProposta) {
        return _propostes.get(idProposta);
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
     * Recuperador del nom de l'enigma
     * 
     * @pre Ø
     * @return El nom de l'enigma
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
