package edu.ub.prog2.MeyerTatianaBarraganAlberto.model;

import edu.ub.prog2.MeyerTatianaBarraganAlberto.controlador.Reproductor;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;

/**
 * Emmagatzema les dades d'un àudio.
 * 
 * @author Alberto Barragán
 * @author Tatiana Meyer
 */
public class Audio extends FitxerReproduible {
    
    private final File fitxerImatge;
    private final int kbps;
    
    /**
     * Inicialitza totes les variables de la classe.
     * 
     * @param cami
     * @param fitxerImatge
     * @param nom
     * @param descripcio
     * @param codec
     * @param durada
     * @param kbps
     * @param r 
     */
    public Audio(String cami, File fitxerImatge, String nom, String descripcio, String codec, float durada, int kbps, Reproductor r) {
        
        super(cami, nom, descripcio, codec, durada, r);
        
        this.fitxerImatge = fitxerImatge;
        this.kbps = kbps;
    
    }
    
    /**
     * Reproduce un audio.
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    @Override
    public void reproduir() throws AplicacioException{
        this.r.play(this, fitxerImatge);
    }
    
}