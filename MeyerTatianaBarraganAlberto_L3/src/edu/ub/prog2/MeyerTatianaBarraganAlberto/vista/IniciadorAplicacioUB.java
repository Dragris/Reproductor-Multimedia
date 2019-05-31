package edu.ub.prog2.MeyerTatianaBarraganAlberto.vista;

import edu.ub.prog2.utils.AplicacioException;

/**
 * Inicialitza el programa.
 * 
 * @author Alberto Barragán
 * @author Tatiana Meyer
 */
public class IniciadorAplicacioUB {

    /**
     * Inicialitza el programa.
     * 
     * @param args 
     */
    public static void main(String[] args) throws AplicacioException {
        AplicacioUB3 aplicacio = new AplicacioUB3();
        aplicacio.gestioAplicacioUB();
    } 
    
}

