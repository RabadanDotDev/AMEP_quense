package com.nosferatu.queense;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Taulell {
    String _nomTaulell;
    Date _dataExpiracio;
    Boolean _esValid;
    Integer _numReptes;
    Map<String, Repte> _reptes;
    Repte _repteDiferenciat;
    Map<String, Joc> _jocs;
    Joc _jocDiferenciat;
    
    /**
     * Constructor taulell
     * 
     * @param nomTaulell El nom del taulell
     * @param dataExpiracio La data d'expiració del taulell
     */
    public Taulell(String nomTaulell, Date dataExpiracio) {
        _nomTaulell = nomTaulell;
        _dataExpiracio = dataExpiracio;
        _esValid = true;
        _numReptes = 0;
        _reptes = new HashMap<>();
        _jocs = new HashMap<>();
    }
    
    /**
     * Inicia la creació d'un nou repte
     * 
     * @param e L'enigma font
     * @pre (!hiHaRepteDiferenciat() || teElRepteDiferenciatFlorIObstacle())
     * @post hiHaRepteDiferenciat() && estadistiquesRepteActualitzades && (!hiHaRepteDiferenciat() || s'ha posat el tipus correcte al repte diferenciat anterior)
     */
    public void iniciNouRepte(Enigma e) {
        if(this.hiHaRepteDiferenciat())
            this.posarRepteTipusCorrecte();
        
        this.crearRepte(e);
        this.actualitzarEstadistiquesRepte(e);
    }
    
    /**
     * Afegeix la proposta identificada per idProposta al repte diferenciat
     * 
     * @param idProposta La proposta a afegir
     * @pre hiHaRepteDiferenciat() && hiHaLaPropostaIdPropostaAlEnigmaFontDelRepteDiferenciat && !hiHaPropostaDinsDeRepteDiferenciat(idProposta)
     * @post hiHaPropostaDinsDeRepteDiferenciat(idProposta)
     */
    public void seleccionarProposta(String idProposta) {
        _repteDiferenciat.seleccionarProposta(idProposta);
    }
    
    /**
     * Finalitza la creació del taulell
     * 
     * @pre hiHaRepteDiferenciat() && teElRepteDiferenciatFlorIObstacle()
     * @post !hiHaRepteDiferenciat()
     */
    public void fiNouTaulell() {
        this.posarRepteTipusCorrecte();
        _repteDiferenciat = null;
    }
    
    /**
     * Posar al repte diferenciat el tipus correcte
     * 
     * @pre hiHaRepteDiferenciat()
     * @post El repte té el tipus correcte
     */
    private void posarRepteTipusCorrecte() {
        _repteDiferenciat.posarRepteTipusCorrecte();
    }
    
    /**
     * Creador d'un repte a partir d'un enigma
     * 
     * @param e Enigma font
     * @pre Ø
     * @post Hi ha un nou repte i aquest és el diferenciat
     */
    private void crearRepte(Enigma e) {
        _repteDiferenciat = new Repte(e, this);
        _reptes.put(_repteDiferenciat.obtenirId(), _repteDiferenciat);
    }
    
    /**
     * Actualitza el nombre de reptes de l'enigma i el taulell
     * 
     * @param e Enigma a actualitzar
     * @pre Ø
     * @post S'ha incrementat en un el nombre de reptes del taulell i de e
     */
    private void actualitzarEstadistiquesRepte(Enigma e) {
        _numReptes++;
        e.actualitzarEstadístiquesRepte();
    }
    
    /**
     * 
     * @return true si hi ha un repte diferenciat, false en cas contrari
     */
    public Boolean hiHaRepteDiferenciat() {
        return !(_repteDiferenciat == null);
    }
    
    /**
     * Comprovar si el repte diferenciat te flor i obstacle
     * 
     * @pre hiHaRepteDiferenciat()
     * @return true si el repte diferenciat té flor i obstacle, false en cas contrari
     */
    public Boolean teElRepteDiferenciatFlorIObstacle() {
        return 0 < _repteDiferenciat.numLlavors() && 0 < _repteDiferenciat.numObstacles();
    }

    /**
     * Comprovar si hi ha una proposta identificada per idProposta en el repte diferenciat
     * 
     * @param idProposta El id de la proposta
     * @pre hiHaRepteDiferenciat()
     * @return True si existeix una proposta identificada per idProposta en el repte diferenciat, false en cas contrari.
     */
    public Boolean hiHaPropostaDinsDeRepteDiferenciat(String idProposta) {
        return _repteDiferenciat.hiHaProposta(idProposta);
    }
    
    /**
     * Inicia la creació d'un nou joc amb Llull
     * 
     * @param nomLlull El nom del Llull
     * @pre !hiHaJocDiferenciat()
     * @post hiHaJocDiferenciat() && elJocDiferenciatEsDelLlull(nomLlull)
     */
    public void iniciNouJocLlull(Llull l) {
        _jocDiferenciat = new Joc(this, l);
        _jocs.put(_jocDiferenciat.obtenirId(), _jocDiferenciat);
        l.apropiarJoc(_jocDiferenciat);
    }
    
    /**
     * Inicia la creació d'un nou joc sense Llull
     * 
     * @pre elTaulellEsValid && !hiHaJocDiferenciat()
     * @post hiHaJocDiferenciat() && elJocDiferenciatEsDelTaulell
     */
    public void iniciNouJocAnonim() {
        _jocDiferenciat = new Joc(this);
        _jocs.put(_jocDiferenciat.obtenirId(), _jocDiferenciat);
    }
    
    /**
     * Inicia la introducció d'una nova tirada
     * 
     * @param idRepte Repte sobre el que es farà la tirada
     * @pre hiHaJocDiferenciat() && (!hiHaTiradaDiferenciada() || teTiradaDiferenciadaTria()) && hiHaRepteAlTaulell(idRepte) && !hiHaTiradaPelRepte(idRepte)
     * @post hiHaTiradaDiferenciada() && hiHaTiradaPelRepte(idRepte) && (!hiHaTiradaDiferenciada() || recompte tabes tirada correcte)
     */
    public void iniciNovaTirada(String idRepte) {
        _jocDiferenciat.iniciNovaTirada(_reptes.get(idRepte));
    }
    
    /**
     * Introdueix una tria en la tirada diferenciada
     * 
     * @param idProposta Proposta triada
     * @pre hiHaTiradaDiferenciada() && hiHaPropostaAlRepteDeLaTiradaDiferenciada(idProposta) && !hiHaPropostaALaTiradaDiferenciada(idProposta)
     * @post hiHaPropostaALaTiradaDiferenciada(idProposta)
     */
    public void introduccióTria(String idProposta) {
        _jocDiferenciat.introduccióTria(idProposta);
    }
    
    /**
     * Finalitza la creació del nnou joc
     * 
     * @pre hiHaJocDiferenciat() && hiHaTiradaDiferenciada() && jocDiferenciatEsComplert()
     * @post !hiHaTiradaDiferenciada() && !hiHaJocDiferenciat() && recompte tabes ultima tirada correcte
     */
    public void fiJoc() {
        _jocDiferenciat.fiJoc();
        _jocDiferenciat = null;
    }
    
    /**
     * Comprovador de si existeix un joc diferenciat
     * 
     * @pre Ø
     * @return True si hi ha un joc diferenciat, false en cas contrari
     */
    public Boolean hiHaJocDiferenciat() {
        return !(_jocDiferenciat == null);
    }
    
    /**
     * Comprovador de si hi ha el repte identificat per idRepte
     * 
     * @param idRepte El id del repte a comprovar
     * @pre Ø
     * @return True si hi ha un repte identificat per idRepte
     */
    public Boolean hiHaRepte(String idRepte) {
        return _reptes.containsKey(idRepte);
    }
    
    /**
     * Comprovador de si hi ha tirada pel repte identificat per idRepte al joc diferenciat
     * 
     * @param idRepte El id del repte a comprovar
     * @pre Ø
     * @return True si hi ha una tirada pel repte al joc diferenciat
     */
    public Boolean hiHaTiradaPelRepteAlJocDiferenciat(String idRepte) {
        return _jocDiferenciat.hiHaTiradaPelRepte(idRepte);
    }
    
    /**
     * Comprovador de si hi ha tirada diferenciada
     * 
     * @pre Ø
     * @return True si hi ha una tirada diferenciada, false en cas contrari
     */
    public Boolean hiHaTiradaDiferenciada() {
        Boolean b = !(_jocDiferenciat == null);
        
        if(b)
            b = _jocDiferenciat.hiHaTiradaDiferenciada();
        
        return b;
    }
    
    /**
     * Comprovador de si hi ha una propoposta a la tirada diferenciada identificada per idProposta
     * 
     * @param idProposta El id de la proposta a comprovar
     * @pre hiHaTiradaDiferenciada()
     * @return true si hi ha una proposta amb id idProposta a la tirada diferenciada
     */
    public Boolean hiHaPropostaALaTiradaDiferenciada(String idProposta) {
        return _jocDiferenciat.hiHaPropostaALaTiradaDiferenciada(idProposta);
    }
    
    /**
     * Comprovador de si hi ha una propoposta a la tirada diferenciada
     * 
     * @pre hiHaTiradaDiferenciada()
     * @return true si hi ha una proposta a la tirada diferenciada
     */
    public Boolean teTiradaDiferenciadaTria() {
        return _jocDiferenciat.teTiradaDiferenciadaTria();
    }
    
    /**
     * Comprovador de si el joc diferenciat és complert
     * 
     * @pre hiHaJocDiferenciat()
     * @return True si el joc diferenciat és complert, false en cas contrari.
     */
    public Boolean jocDiferenciatEsComplet() {
        Map<String, Repte> temp = _jocDiferenciat.obtenirReptes();
        return _reptes.equals(temp);
    }
    
    /**
     * Obtenció de la validesa del taulell
     * 
     * @pre Ø
     * @return True si és valid, false en cas contrari
     */
    public Boolean esValid() {
        return (_esValid = _dataExpiracio.after(new Date()));
    }
    
    /**
     * Recuperador del nom del taulell
     * 
     * @pre Ø
     * @return El nom del taulell
     */
    public String obtenirNom() {
        return _nomTaulell;
    }
    
    /**
     * Recuperador de l'iterador dels reptes
     * 
     * @return Iterador dels reptes
     */
    public Iterator<Repte> recuperarIteradorReptes() {
        return _reptes.values().iterator();
    }
    
    /**
     * Recuperació d'un repte del taulell
     * 
     * @param idRepte identificador del repte
     * @pre hiHaRepte(idRepte)
     * @return retorna el repte amb id idRepte
     */
    public Repte recuperarRepte(String idRepte) {
        return _reptes.get(idRepte);
    }
}
