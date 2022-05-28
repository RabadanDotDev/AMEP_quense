package com.nosferatu.queense;

import java.util.HashMap;
import java.util.Map;

public class MagatzemLlulls {
    Map<String, Llull> _llulls;
    
    /**
     * Constructor
     * 
     */
    public MagatzemLlulls() {
        _llulls = new HashMap<>();
    }
    
    /**
     * Recupera el Llull nomNull, el crea si fa falta.
     * 
     * @param nomLlull
     * @pre Ø
     * @return retorna el Llull amb nom nomLlull
     */
    public Llull obtenirLlull(String nomLlull) {
        Llull l = _llulls.get(nomLlull);
        if(l == null) {
            l = new Llull(nomLlull);
            _llulls.put(nomLlull, l);
        }
        return l;    
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
}
