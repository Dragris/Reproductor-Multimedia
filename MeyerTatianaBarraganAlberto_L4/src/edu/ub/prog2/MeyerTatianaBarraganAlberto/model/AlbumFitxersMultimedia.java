package edu.ub.prog2.MeyerTatianaBarraganAlberto.model;

import edu.ub.prog2.utils.AplicacioException;
import java.util.Objects;


public class AlbumFitxersMultimedia extends CarpetaFitxers{
    private String titulo;
    
    /**
     * Constructior amb un paràmetre
     * @param tit: titol de l'album
     */
    public AlbumFitxersMultimedia(String tit) {
        this.titulo = tit;
    }
    
    /**
     * Constructior amb dos paràmetres
     * @param cap: capacitat de l'album
     * @param tit: titol de l'album
     * @throws AplicacioException 
     */
    public AlbumFitxersMultimedia(int cap, String tit) throws AplicacioException {
        super(cap);
        this.titulo = tit;
    }

    // Getter y setter
    /**
     * Retorna el titol de l'album
     * @return retorna el nom de l'album en String
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Canvia el nom de l'album
     * @param titulo: nou nom de l'album
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    /**
     * Override a equals y hashcode que pide generado por Netbeans.
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlbumFitxersMultimedia other = (AlbumFitxersMultimedia) obj;
        return Objects.equals(this.titulo, other.titulo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.titulo);
        return hash;
    }
}
