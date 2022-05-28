package com.nosferatu.queense;

public class Proposta {
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
    }
    
    /**
     * Accés a la correctesa de la proposta
     * 
     * @pre Ø
     * @return True si la proposta es correcta, false en cas contrari
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
     * 
     * @return Retorna 1 si es incorrecta
     */
    public int retorna1SiIncorrecta() {
        int r = 0;
        
        if(!_esCorrecta)
            r = 1;
        
        return r;
    }
    
    /**
     * 
     * @return Retorna 1 si es correcta
     */
    public int retorna1SiCorrecta() {
        int r = 0;
        
        if(_esCorrecta)
            r = 1;
        
        return r;
    }
}
