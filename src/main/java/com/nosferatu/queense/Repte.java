package com.nosferatu.queense;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class Repte {
    String _idRepte;
    Enigma _enigmaFont;
    Taulell _taulellContenedor;
    Integer _numLlavors;
    Integer _numObstacles;
    TipusRepteEnum _tipus;
    Map<String, Proposta> _propostes;
    
    /**
     * Constructor repte
     * 
     * @param e Enigma font
     * @param t Taulell contenedor
     */
    public Repte(Enigma e, Taulell t) {
        _enigmaFont = e;
        _taulellContenedor = t;
        _numLlavors = _numObstacles = 0;
        _propostes = new HashMap<>();
        _idRepte = UUID.randomUUID().toString();
        _tipus = TipusRepteEnum.DESCONEGUT;
    }
    
    /**
     * Actualitzar el repte per tal que el tipus sigui correcte
     * 
     * @pre 1 <= numLlavors() && 1 <= _numObstacles()
     * @post El tipus del repte és correcte
     */
    public void posarRepteTipusCorrecte() {
        if(_numLlavors == 1 && _numObstacles == 1)
            _tipus = TipusRepteEnum.DILEMA;
        else if(_numLlavors == 1 && _numObstacles > 1)
            _tipus = TipusRepteEnum.ELECCIO;
        else if(_numLlavors > 1 && _numObstacles >= 1)
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
        Proposta p = _enigmaFont.encaixarProposta(idProposta);
        
        if (p.esCorrecta())
            _numLlavors++;
        else
            _numObstacles++;
        
       _propostes.put(idProposta, p);
    }
    
    /**
     * Consultar nombre de llavors
     * 
     * @pre Ø
     * @return Retorna el nombre de propostes correctes contingudes
     */
    public Integer numLlavors() {
        return _propostes.values().stream().mapToInt(Proposta::retorna1SiCorrecta).sum();
    }
    
    /**
     * Consultar nombre de llavors
     * 
     * @pre Ø
     * @return Retorna el nombre de propostes incorrectes contingudes
     */
    public Integer numObstacles() {
        return _propostes.values().stream().mapToInt(Proposta::retorna1SiIncorrecta).sum();
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
     * Accés a una proposta concreta del repte
     * 
     * @param idProposta Proposta a encaixar
     * @pre hiHaProposta(idProposta)
     * @return La proposta identificada per idProposta
     */
    public Proposta encaixarProposta(String idProposta) {
        return _propostes.get(idProposta);
    }
    
    /**
     * Recuperador del tipus de repte
     * 
     * @pre Ø
     * @return El tipus del repte 
     */
    public TipusRepteEnum obtenirTipus() {
        return _tipus;
    }
    
    /**
     * Accés a l'id del repte
     * 
     * @pre Ø
     * @return Retorna el id del repte
     */
    public String obtenirId() {
        return _idRepte;
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
    
    /**
     * Recuperador de l'iterador dels reptes del repte r
     * 
     * @return Iterador de les propostes de r
     */
    public Iterator<Proposta> recuperarIteradorPropostes() {
        return _propostes.values().iterator();
    }
}
