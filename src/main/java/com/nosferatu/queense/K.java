package com.nosferatu.queense;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class K {
    Date _dataDarreraEliminacio;
    Map<String, Enigma> _enigmes;
    Map<String, Taulell> _taulells;
    Enigma _enigmaDiferenciat;
    Taulell _taulellDiferenciat;
    MagatzemLlulls _magatzemLlulls;
    
    /**
     * Constructor K
     * 
     */
    public K(){
        _dataDarreraEliminacio = new Date(0);
        _enigmes = new HashMap<>();
        _taulells = new HashMap<>();
        _magatzemLlulls = new MagatzemLlulls();
    }

    /**
     * Inicia la creació d'un nou enigma
     * 
     * @param nomEnigma El nom del nou l'enigma
     * @param textEnunciat L'enunciat de l'enigma
     * @pre !hiHaEnigmaDiferenciat() && !hiHaEnigmaAnomenat(nomEnigma)
     * @post hiHaEnigmaDiferenciat() && hiHaEnigmaAnomenat(nomEnigma)
     */
    public void iniciNouEnigma(String nomEnigma, String textEnunciat) {
        _enigmaDiferenciat = new Enigma(nomEnigma, textEnunciat);
        _enigmes.put(nomEnigma, _enigmaDiferenciat);
    }

    /**
     * Introdueix una nova propsota a l'enigma en creació
     * 
     * @param textProposta El text de la proposta introduïda.
     * @param esCorrecta Correctesa de la proposta introduïda.
     * @pre hiHaEnigmaDiferenciat()
     * @post S'ha creat una proposta amb textProposta i correctesa esCorrecta dins de l'enigma diferenciat
     */
    public void introduirProposta(String textProposta, Boolean esCorrecta) {
        _enigmaDiferenciat.introduirProposta(textProposta, esCorrecta);
    }

    /**
     * Finalitza la creació del nou enigma
     * 
     * @pre hiHaEnigmaDiferenciat && teEnigmaDiferenciatPedraIFlor()
     * @post !hiHaEnigmaDiferenciat()
     */
    public void fiNouEnigma() {
        _enigmaDiferenciat = null;
    }
    
    /**
     * 
     * @return retorna true si hi ha un enigma diferenciat, false en cas contrari
     */
    public Boolean hiHaEnigmaDiferenciat() {
        Boolean b = _enigmaDiferenciat != null;
        return b;
    }
    
    /**
     * 
     * @param nomEnigma El nom de l'enigma a consultar la seva existència
     * @return True si existeix un enigma anomenat nomEnigma, false en cas contrari.
     */
    public Boolean hiHaEnigmaAnomenat(String nomEnigma) {
        return _enigmes.containsKey(nomEnigma);
    }
    
    /**
     * 
     * @pre hiHaEnigmaDiferenciat()
     * @return True si hi ha al menys una pedra i una flor en el enigma diferenciat, false en cas contrari
     */
    public Boolean teEnigmaDiferenciatPedraIFlor() {
        return 0 < _enigmaDiferenciat.numFlors() && 0 < _enigmaDiferenciat.numPedres();
    }
    
    /**
     * Inicia la creació d'un nou taulell
     * 
     * @param nomTaulell Nom del taulell
     * @param dataExpiracio Data d'exipració del taulell
     * @pre !hiHaTaulellDiferenciat() && !hiHaTaulellAnomenat(nomTaulell) && dataActual() <= dataExpiració
     * @post hiHaTaulellDiferenciat() && hiHaTaulellAnomenat(nomTaulell)
     */
    public void iniciNouTaulell(String nomTaulell, Date dataExpiracio) {
        _taulellDiferenciat = new Taulell(nomTaulell, dataExpiracio);
        _taulells.put(nomTaulell, _taulellDiferenciat);
    }
    
    /**
     * Inicia la creació d'un nou repte al taulell diferenciat
     * 
     * @param nomEnigmaFont El nom de l'enigma font
     * @pre hiHaTaulellDiferenciat() && (!hiHaRepteDiferenciat() || teElRepteDiferenciatFlorIObstacle()) && hiHaEnigmaAnomenat(nomEnigmaFont)
     * @post hiHaRepteDiferenciat() && estadistiquesRepteActualitzades && (!hiHaRepteDiferenciat() || s'ha posat el tipus correcte al repte diferenciat anterior)
     */
    public void iniciNouRepte(String nomEnigmaFont) {
        Enigma e = _enigmes.get(nomEnigmaFont);
        _taulellDiferenciat.iniciNouRepte(e);
    }
    
    /**
     * Afegeix la proposta identificada per idProposta al repte diferenciat
     * 
     * @param idProposta La proposta a afegir
     * @pre hiHaTaulellDiferenciat() && hiHaRepteDiferenciat() && hiHaLaPropostaIdPropostaAlEnigmaFontDelRepteDiferenciat && !hiHaPropostaDinsDeRepteDiferenciat(idProposta)
     * @post hiHaPropostaDinsDeRepteDiferenciat(idProposta)
     */
    public void seleccionarProposta(String idProposta) {
        _taulellDiferenciat.seleccionarProposta(idProposta);
    }
    
    /**
     * Finalitza la creació d'un nou taulell
     * 
     * @pre hiHaTaulellDiferenciat() && hiHaRepteDiferenciat() && teElRepteDiferenciatFlorIObstacle()
     * @post !hiHaTaulellDiferenciat() && !hiHaRepteDiferenciat()
     */
    public void fiNouTaulell() {
        _taulellDiferenciat.fiNouTaulell();
        _taulellDiferenciat = null;
    }
    
    /**
     * Comprovar si hi ha un taulell diferenciat
     * 
     * @pre Ø
     * @return True si hi ha un taulell diferenciat, false en cas contrari
     */
    public Boolean hiHaTaulellDiferenciat() {
        return !(_taulellDiferenciat == null);
    }
    
    /**
     * Comprovar si hi ha un taulell amb nom nomTaulell
     * 
     * @param nomTaulell El nom del taulell a comprovar
     * @pre Ø
     * @return True si hi ha un taulell amb nom nomTaulell, false en cas contrari
     */
    public Boolean hiHaTaulellAnomenat(String nomTaulell) {
        return _taulells.containsKey(nomTaulell);
    }
    
    /**
     * Comprovar si hi ha un repte diferenciat
     * 
     * @return true si hi ha un repte diferenciat, false en cas contrari
     */
    public Boolean hiHaRepteDiferenciat() {        
        return hiHaTaulellDiferenciat() && _taulellDiferenciat.hiHaRepteDiferenciat();
    }
    
    /**
     * Comprovar si el repte diferenciat te flor i obstacle
     * 
     * @pre hiHaRepteDiferenciat()
     * @return true si el repte diferenciat té flor i obstacle, false en cas contrari
     */
    public Boolean teElRepteDiferenciatFlorIObstacle() {
        return _taulellDiferenciat.teElRepteDiferenciatFlorIObstacle();
    }
    
    /**
     * Comprovar si hi ha una proposta identificada per idProposta en e
     * 
     * @param e L'enigma a identificar
     * @param idProposta El id de la proposta
     * @pre Ø
     * @return True si existeix una proposta identificada per idProposta en e, false en cas contrari.
     */
    public Boolean hiHaPropostaDinsDeEnigma(Enigma e, String idProposta) {
        return e.hiHaProposta(idProposta);
    }

    /**
     * Comprovar si hi ha una proposta identificada per idProposta en el repte diferenciat
     * 
     * @param idProposta El id de la proposta
     * @pre hiHaRepteDiferenciat()
     * @return True si existeix una proposta identificada per idProposta en el repte diferenciat, false en cas contrari.
     */
    public Boolean hiHaPropostaDinsDeRepteDiferenciat(String idProposta) {
        return _taulellDiferenciat.hiHaPropostaDinsDeRepteDiferenciat(idProposta);
    }
    
    /**
     * Inicia la creació d'un nou joc amb Llull
     * 
     * @param nomLlull El nom del Llull
     * @param nomTaulell El nom del taulell
     * @pre hiHaTaulellAnomenat(nomTaulell) && elTaulellEsValid && !hiHaJocDiferenciat()
     * @post hiHaJocDiferenciat() && elJocDiferenciatEsDelLlull(nomLlull) && elJocDiferenciatEsDelTaulell
     */
    public void iniciNouJocLlull(String nomLlull, String nomTaulell) {
        _taulellDiferenciat = _taulells.get(nomTaulell);
        Llull l = _magatzemLlulls.obtenirLlull(nomLlull);
        _taulellDiferenciat.iniciNouJocLlull(l);
    }
    
    /**
     * Inicia la creació d'un nou joc sense Llull
     * 
     * @param nomTaulell El nom del taulell
     * @pre hiHaTaulellAnomenat(nomTaulell) && elTaulellEsValid && !hiHaJocDiferenciat()
     * @post hiHaJocDiferenciat() && elJocDiferenciatEsDelTaulell
     */
    public void iniciNouJocAnonim(String nomTaulell) {
        _taulellDiferenciat = _taulells.get(nomTaulell);
        _taulellDiferenciat.iniciNouJocAnonim();
    }
    
    /**
     * Inicia la introducció d'una nova tirada
     * 
     * @param idRepte Repte sobre el que es farà la tirada
     * @pre hiHaJocDiferenciat() && (!hiHaTiradaDiferenciada() || teTiradaDiferenciadaTria()) && hiHaRepteAlTaulell(idRepte) && !hiHaTiradaPelRepte(idRepte)
     * @post hiHaTiradaDiferenciada() && hiHaTiradaPelRepte(idRepte) && (!hiHaTiradaDiferenciada() || recompte tabes tirada correcte)
     */
    public void iniciNovaTirada(String idRepte) {
        _taulellDiferenciat.iniciNovaTirada(idRepte);
    }
    
    /**
     * Introdueix una tria en la tirada diferenciada
     * 
     * @param idProposta Proposta triada
     * @pre hiHaTiradaDiferenciada() && hiHaPropostaAlRepteDeLaTiradaDiferenciada(idProposta) && !hiHaPropostaALaTiradaDiferenciada(idProposta)
     * @post hiHaPropostaALaTiradaDiferenciada(idProposta)
     */
    public void introduccioTria(String idProposta) {
        _taulellDiferenciat.introduccióTria(idProposta);
    }
    
    /**
     * Finalitza la creació del nou joc
     * 
     * @pre hiHaJocDiferenciat() && hiHaTiradaDiferenciada() && jocDiferenciatEsComplert()
     * @post !hiHaTiradaDiferenciada() && !hiHaJocDiferenciat() && recompte tabes ultima tirada correcte
     */
    public void fiJoc() {
        _taulellDiferenciat.fiJoc();
        _taulellDiferenciat = null;
    }
    
    /**
     * Comprovador de si existeix un joc diferenciat
     * 
     * @pre Ø
     * @return True si hi ha un joc diferenciat, false en cas contrari
     */
    public Boolean hiHaJocDiferenciat() {
        Boolean b = !(_taulellDiferenciat == null);
        
        if(b)
            b = _taulellDiferenciat.hiHaJocDiferenciat();
        
        return b;
    }
    
    /**
     * Comprovador de si el repte identificat per idRepte es troba al taulell
     * 
     * @param t El taulell
     * @param idRepte El id del repte a comprovar
     * @pre Ø
     * @return True si hi ha un repte al taulell identificat per idRepte
     */
    public Boolean hiHaRepteAlTaulell(Taulell t, String idRepte) {
        return t.hiHaRepte(idRepte);
    }
    
    /**
     * Comprovador de si hi ha tirada pel repte identificat per idRepte al joc diferenciat
     * 
     * @param idRepte El id del repte a comprovar
     * @pre Ø
     * @return True si hi ha una tirada pel repte al joc diferenciat
     */
    public Boolean hiHaTiradaPelRepteAlJocDiferenciat(String idRepte) {
        return _taulellDiferenciat.hiHaTiradaPelRepteAlJocDiferenciat(idRepte);
    }
    
    /**
     * Comprovador de si hi ha tirada diferenciada
     * 
     * @pre Ø
     * @return True si hi ha una tirada diferenciada, false en cas contrari
     */
    public Boolean hiHaTiradaDiferenciada() {
        Boolean b = !(_taulellDiferenciat == null);
        
        if(b)
            b = _taulellDiferenciat.hiHaTiradaDiferenciada();
        
        return b;
    }
    
    /**
     * Comprovador de si hi ha una propoposta a la tirada diferenciada
     * 
     * @pre hiHaTiradaDiferenciada()
     * @return true si hi ha una proposta a la tirada diferenciada
     */
    public Boolean teTiradaDiferenciadaTria() {
        return _taulellDiferenciat.teTiradaDiferenciadaTria();
    }
    
    
    /**
     * Comprovador de si hi ha una propoposta identifiada per idProposta a r
     * 
     * @param r El repte on cercarem la proposta a comprovar
     * @param idProposta El id de la proposta a comprovar
     * @pre Ø
     * @return True si hi ha una proposta al repte amb id idProposta
     */
    public Boolean hiHaPropostaAlRepte(Repte r, String idProposta) {
        return r.hiHaProposta(idProposta);
    }
    
    /**
     * Comprovador de si hi ha una propoposta a la tirada diferenciada identificada per idProposta
     * 
     * @param idProposta El id de la proposta a comprovar
     * @pre hiHaTiradaDiferenciada()
     * @return true si hi ha una proposta amb id idProposta a la tirada diferenciada
     */
    public Boolean hiHaPropostaALaTiradaDiferenciada(String idProposta) {
        return _taulellDiferenciat.hiHaPropostaALaTiradaDiferenciada(idProposta);
    }
    
    /**
     * Comprovador de si el joc diferenciat és complert
     * 
     * @pre hiHaJocDiferenciat()
     * @return True si el joc diferenciat és complert, false en cas contrari.
     */
    public Boolean jocDiferenciatEsComplet() {
        return _taulellDiferenciat.jocDiferenciatEsComplet();                
    }
    
    /**
     * Esborrar tots els reptes suspesos de tots els Llulls
     * 
     * @pre La data actual no es igual a la de la darrera eliminació
     * @post No hi ha cap Llull amb suspens recent && la data de la darrera eliminació es avui
     */
    public void esborrarSuspesos() {
        _magatzemLlulls.esborrarSuspesos();
        _dataDarreraEliminacio = new Date();
    }
    
    /**
     * Consultor de la data de la darrera eliminació
     * 
     * @pre Ø
     * @return Data de la darrera eliminació
     */
    public Date obtenirDataDarreraEliminacio() {
        return _dataDarreraEliminacio;
    }
    
    /**
     * Recuperació d'un enigma
     * 
     * @param nomEnigma nom de l'enigma
     * @pre hiHaEnigmaAnomenat(nomEnigma)
     * @return retorna una copia de l'enigma amb nom nomEnigma
     */
    public Enigma recuperarEnigma(String nomEnigma) {
        // TODO: mirar com fer la copia, per ara, retornem el objecte tal cual
        return _enigmes.get(nomEnigma);
    }
    
    /**
     * Recuperació d'un taulell
     * 
     * @param nomTaulell nom del taulell
     * @pre hiHaTaulellAnomenat(nomTaulell)
     * @return retorna una copia del taulell amb nom nomTaulell
     */
    public Taulell recuperarTaulell(String nomTaulell) {
        // TODO: mirar com fer la copia, per ara, retornem el objecte tal cual
        return _taulells.get(nomTaulell);
    }
    
    /**
     * Recuperació d'un repte del taulell
     * 
     * @param t Taulell contenidor del repte
     * @param idRepte identificador del repte
     * @pre hiHaRepteAlTaulell(t, idRepte)
     * @post retorna una copia del repte amb nom idRepte
     */
    public Repte recuperarRepte(Taulell t, String idRepte) {
        // TODO: mirar com fer la copia, per ara, retornem el objecte tal cual
        return t.recuperarRepte(idRepte);
    }
    
    /**
     * Recuperador de l'iterador de enigmes
     * 
     * @pre Ø
     * @return Iterador de tots els enigmes
     */
    public Iterator<Enigma> recuperarIteradorEnigmes() {
        return _enigmes.values().iterator();
    }
    
    /**
     * Recuperador de l'iterador de les propostes de l'enigma e
     * 
     * @param e L'enigma contenidor de les propostes
     * @return Iterador de les propostes d'e
     */
    public Iterator<Proposta> recuperarIteradorPropostes(Enigma e) {
        return e.recuperarIteradorPropostes();
    }
    
    /**
     * Recuperador de l'iterador de tots els taulells
     * 
     * @pre Ø
     * @return Iterador de tots els taulells
     */
    public Iterator<Taulell> recuperarIteradorTaulells() {
        return _taulells.values().iterator();
    }
    
    /**
     * Recuperador de l'iterador dels reptes del taulell t
     * 
     * @param t El taulell contenidor dels reptes
     * @return Iterador dels reptes de t
     */
    public Iterator<Repte> recuperarIteradorReptes(Taulell t) {
        return t.recuperarIteradorReptes();
    }
    
    /**
     * Recuperador de l'iterador dels reptes del repte r
     * 
     * @param r El repte contenidor de les propostes
     * @return Iterador de les propostes de r
     */
    public Iterator<Proposta> recuperarIteradorPropostes(Repte r) {
        return r.recuperarIteradorPropostes();
    }
    
    /**
     * TODO descripció
     * 
     * @pre TODO
     * @post TODO
     * @return 
     */
    public Enigma recuperarCopiaEnigma(Repte r) {
        throw new UnsupportedOperationException("Per programar.");
    }
}
