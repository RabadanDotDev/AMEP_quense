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
}
