package com.nosferatu.queense;

import java.util.HashMap;
import java.util.Map;

public class Llull {
    String _nomLlull;
    Map<String, Joc> _jocsApropiats;
    Map<String, Repte> _reptesSuspesos;
    
    /**
     * Constructor
     * 
     * @param nomLlull Nom del Llull
     */
    public Llull(String nomLlull) {
        _nomLlull = nomLlull;
        _jocsApropiats = new HashMap<>();
        _reptesSuspesos = new HashMap<>();
    }
    
    /**
     * Permet al Llull apriopiar-se d'un joc
     * 
     * @param j El joc a apropiar
     * @pre Ø
     * @post El Llull ha guardat el joc
     */
    public void apropiarJoc(Joc j) {
        _jocsApropiats.put(j.obtenirId(), j);
    }
    
    /**
     * Permet comunicar un repte que el Llull ha suspès perquè el guardi.
     * 
     * @param r El repte suspès
     * @pre Ø
     * @post El Llull ha guardat r
     */
    public void repteSuspes(Repte r) {
        _reptesSuspesos.put(r.obtenirId(), r);
    }
    
    /**
     * Esborrar tots els reptes suspesos del llull
     * 
     * @pre Ø
     * @post El llull no té cap suspens recent
     */
    public void esborrarSuspesos() {
        _reptesSuspesos = new HashMap<>();
    }
}
