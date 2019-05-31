package edu.ub.prog2.MeyerTatianaBarraganAlberto.model;

import edu.ub.prog2.MeyerTatianaBarraganAlberto.controlador.Reproductor;
import edu.ub.prog2.utils.AplicacioException;

/**
 * Emmagatzema les dades d'un vídeo.
 * 
 * @author Alberto Barragán
 * @author Tatiana Meyer
 */
public class Video extends FitxerReproduible {
    
    private final int alcada;
    private final int amplada;
    private final float fps;
    
    /**
     * Inicialitza totes les variables de la classe.
     * 
     * @param cami
     * @param nom
     * @param descripcio
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @param r 
     */
    public Video(String cami, String nom, String descripcio, String codec, float durada, int alcada, int amplada, float fps, Reproductor r) {
        super(cami, nom, descripcio, codec, durada, r);
        this.alcada = alcada;
        this.amplada = amplada;
        this.fps = fps;
    }
    
    /**
     * En el futur reproduirà un vídeo.
     */
    @Override
    public void reproduir() throws AplicacioException {
        this.r.play(this);
    }
    
}
