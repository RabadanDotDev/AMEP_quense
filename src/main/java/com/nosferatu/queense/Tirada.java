package com.nosferatu.queense;

import java.util.HashMap;
import java.util.Map;

public class Tirada {
    Repte _repteDeLaTirada;
    Integer _tabesPositives;
    Integer _tabesNegatives;
    Map<String, Proposta> _tries;
    
    /**
     * Descripción TODO
     * 
     * @param r
     */
    public Tirada(Repte r) {
        _repteDeLaTirada = r;
        _tabesPositives = _tabesNegatives = 0;
        _tries = new HashMap<>();
    }
    
    /**
     * Accés a saber si la tirada ha estat suspesa
     * 
     * @pre Ø
     * @return True si és tirada suspesa, false en cas contrari
     */
    public Boolean esTiradaSuspesa() {
        return _tabesPositives < _tabesNegatives;
    }
    
    /**
     * Accés al repte de la tirada
     * 
     * @pre Ø
     * @return El repte de la tirada
     */
    public Repte recuperarRepte() {
        return _repteDeLaTirada;
    }
    
    /**
     * Introdueix una tria en la tirada 
     * 
     * @param idProposta Proposta triada
     * @pre hiHaPropostaAlRepteDeLaTirada(idProposta) && !hiHaPropostaALaTirada(idProposta)
     * @post hiHaPropostaALaTirada(idProposta)
     */
    public void introduccioTria(String idProposta) {
        Proposta p = encaixarProposta(idProposta);
        actualitzarTabes(p);
        _tries.put(p.obtenirId(), p);
    }
    
    /**
     * Accés a una proposta concreta del repte de la tirada
     * 
     * @param idProposta Proposta a encaixar
     * @pre hiHaPropostaAlRepteDeLaTirada(idProposta)
     * @return La proposta identificada per idProposta
     */
    private Proposta encaixarProposta(String idProposta) {
        return _repteDeLaTirada.encaixarProposta(idProposta);
    }
    
    /**
     * Actualitzar les tabes segons la validesa de p
     * 
     * @param p La proposta que pot ser correcta o no
     * @pre Ø
     * @post Si p.esCorrecta(), les tabes positives s'han incrementat. En cas contrari, ho han fet les negatives
     */
    private void actualitzarTabes(Proposta p) {
        if(p.esCorrecta())
            _tabesPositives++;
        else
            _tabesNegatives++;
    }
    
    /**
     * Comprovador de si hi ha una propoposta identificada per idProposta
     * 
     * @param idProposta El id de la proposta a comprovar
     * @return true si hi ha una proposta amb id idProposta
     */
    public Boolean teProposta(String idProposta) {
       return  _tries.containsKey(idProposta);
    }
    
    /**
     * Comprovador de si hi ha una propoposta a la tirada
     * 
     * @pre Ø
     * @return true si hi ha una proposta a la tirada
     */
    public Boolean teTria() {
        return !_tries.isEmpty();
    }
    
    /**
     * Afegeix el repte de la tirada a temp
     * 
     * @param temp El map a incloure el repte
     * @pre Ø
     * @post El repte de la tirada es troba dins de temp
     */
    public void subscriuRepte(Map<String, Repte> temp) {
        temp.put(_repteDeLaTirada._idRepte, _repteDeLaTirada);
    }
}
