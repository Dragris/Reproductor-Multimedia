package edu.ub.prog2.MeyerTatianaBarraganAlberto.model;

import edu.ub.prog2.MeyerTatianaBarraganAlberto.controlador.Reproductor;
import edu.ub.prog2.utils.AplicacioException;

/**
 * Base per a implementar les classes Audio i Video.
 * 
 * @author Alberto Barragán
 * @author Tatiana Meyer
 */
public abstract class FitxerReproduible extends FitxerMultimedia {

    private final String codec;
    private final float durada;
    protected transient Reproductor r;

    /**
     * Inicialitza totes les variables de la classe.
     * 
     * @param cami
     * @param nom
     * @param descripcio
     * @param codec
     * @param durada
     * @param r 
     */
    protected FitxerReproduible(String cami, String nom, String descripcio, String codec, float durada, Reproductor r) {
        
        super(cami, descripcio);
        
        this.codec = codec;
        this.durada = durada;
        this.r = r;
    
    }
    
    public void setReproductor(Reproductor reproductor) {
    this.r = reproductor;
    }
    /**
     * Les classes filles implementaràn la reproducció
     * en funció de quin tipus d'arxiu sigui.
     * 
     * @throws AplicacioException 
     */
    public abstract void reproduir() throws AplicacioException;

}
