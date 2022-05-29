package com.nosferatu.queense;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Joc {
    Date _dataRealitzacio;
    Taulell _taulellFont;
    Llull _autor;    
    String _idJoc;
    Map<String, Tirada> _tirades;
    Tirada _tiradaDiferenciada;
    
    /**
     * Constructor
     * 
     * @param t taulell font
     * @param l Llull autor
     */
    public Joc(Taulell t, Llull l) {
        _dataRealitzacio = new Date();
        _taulellFont = t;
        _autor = l;
        _idJoc = UUID.randomUUID().toString();
        _tirades = new HashMap<>();
    }
    
    /**
     * Constructor
     * 
     * @param t taulell font
     */
    public Joc(Taulell t) {
        _dataRealitzacio = new Date();
        _taulellFont = t;
        _autor = null;
        _idJoc = UUID.randomUUID().toString();
        _tirades = new HashMap<>();
    }
    
    /**
     * Inicia la introducció de una nova tirada
     * 
     * @param r Repte sobre el que es farà la tirada
     * @pre (!hiHaTiradaDiferenciada() || teTiradaDiferenciadaTria()) && && !hiHaTiradaPelRepte(idRepte)
     * @post hiHaTiradaDiferenciada() && hiHaTiradaPelRepte(idRepte) && (!hiHaTiradaDiferenciada() || recompte tabes tirada correcte)
     */
    public void iniciNovaTirada(Repte r) {
        if(hiHaTiradaDiferenciada())
            tancaUltimaTirada();
        
        _tiradaDiferenciada = new Tirada(r);
        _tirades.put(r.obtenirId(), _tiradaDiferenciada);
    }
    
    /**
     * Introdueix una tria en la tirada diferenciada
     * 
     * @param idProposta Proposta triada
     * @pre hiHaTiradaDiferenciada() && hiHaPropostaAlRepteDeLaTiradaDiferenciada(idProposta) && !hiHaPropostaALaTiradaDiferenciada(idProposta)
     * @post hiHaPropostaALaTiradaDiferenciada(idProposta)
     */
    public void introduccióTria(String idProposta) {
        _tiradaDiferenciada.introduccioTria(idProposta);
    }
    
    /**
     * Finalitza la creació del nou joc
     * 
     * @pre hiHaTiradaDiferenciada()
     * @post !hiHaTiradaDiferenciada() && recompte tabes ultima tirada correcte
     */
    public void fiJoc() {
        tancaUltimaTirada();
        _tiradaDiferenciada = null;
    }
    
    /**
     * Tanca la tirada diferenciada
     * 
     * @pre hiHaTiradaDiferenciada()
     * @post la tirada diferenciada ha estat comunicada al autor si aquest existeix i si la tirada ha estat suspesa
     */
    private void tancaUltimaTirada() {
        if(!(_autor == null) && _tiradaDiferenciada.esTiradaSuspesa()) {
            Repte r = _tiradaDiferenciada.recuperarRepte();
            _autor.repteSuspes(r);
        }
    }
    
    /**
     * Comprovador de si hi ha tirada pel repte identificat per idRepte
     * 
     * @param idRepte El id del repte a comprovar
     * @pre Ø
     * @return True si hi ha una tirada pel repte identificat per idRepte
     */
    public Boolean hiHaTiradaPelRepte(String idRepte) {
        return _tirades.containsKey(idRepte);
    }
    
    /**
     * Comprovador de si hi ha una propoposta a la tirada diferenciada identificada per idProposta
     * 
     * @param idProposta El id de la proposta a comprovar
     * @pre hiHaTiradaDiferenciada()
     * @return true si hi ha una proposta amb id idProposta a la tirada diferenciada
     */
    public Boolean hiHaPropostaALaTiradaDiferenciada(String idProposta) {
        return _tiradaDiferenciada.teProposta(idProposta);
    }
    
    /**
     * Comprovador de si hi ha tirada diferenciada
     * 
     * @pre Ø
     * @return True si hi ha una tirada diferenciada, false en cas contrari
     */
    public Boolean hiHaTiradaDiferenciada() {
        return !(_tiradaDiferenciada == null);
    }
    
    /**
     * Comprovador de si hi ha una propoposta a la tirada diferenciada
     * 
     * @pre hiHaTiradaDiferenciada()
     * @return true si hi ha una proposta a la tirada diferenciada
     */
    public Boolean teTiradaDiferenciadaTria() {
        return _tiradaDiferenciada.teTria();
    }
    
    /**
     * Retorna un map de tots els reptes els quals s'han fet tirades en el jo
     * 
     * @pre Ø
     * @return Map amb els reptes de les tirades
     */
    public Map<String, Repte> obtenirReptes() {
        Map<String, Repte> temp = new HashMap<>();
        _tirades.values().stream().forEach(t -> t.subscriuRepte(temp));
        return temp;
    }
    
    /**
    * Accés al id de la proposta
    * 
    * @pre Ø
    * @return Retorna el id de la proposta
    */
    public String obtenirId() {
        return _idJoc;
    }
}
