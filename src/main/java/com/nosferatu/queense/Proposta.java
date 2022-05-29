package com.nosferatu.queense;

import java.util.UUID;

public class Proposta {
    String _idProposta;
    String _textProposta;
    Boolean _esCorrecta;
    
    /**
     * Constructor proposta
     * 
     * @param textProposta El text de la poposta
     * @param esCorrecta La correctesa de la proposta
     */
    public Proposta(String textProposta, Boolean esCorrecta) {
        _textProposta = textProposta;
        _esCorrecta = esCorrecta;
        _idProposta = UUID.randomUUID().toString();
    }
    
    /**
     * Accés a la correctesa de la proposta
     * 
     * @pre Ø
     * @return True si la proposta és correcta, false en cas contrari
     */
    public Boolean esCorrecta() {
        return _esCorrecta;
    }

    /**
     * Accés al text de la proposta
     * 
     * @pre Ø
     * @return Retorna el text de la proposta
     */
    public String obtenirText() {
        return _textProposta;
    }
    
    /**
     * Accés al id de la proposta
     * 
     * @pre Ø
     * @return Retorna el id de la proposta
     */
    public String obtenirId() {
        return _idProposta;
    }
    
    /**
     * 
     * @return Retorna 1 si és incorrecta
     */
    public int retorna1SiIncorrecta() {
        int r = 0;
        
        if(!_esCorrecta)
            r = 1;
        
        return r;
    }
    
    /**
     * 
     * @return Retorna 1 si és correcta
     */
    public int retorna1SiCorrecta() {
        int r = 0;
        
        if(_esCorrecta)
            r = 1;
        
        return r;
    }


}
