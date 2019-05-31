package edu.ub.prog2.MeyerTatianaBarraganAlberto.model;

import java.io.File;
import java.util.Date;
import java.util.Objects;

/**
 * Emmagatzema i fa les funcionalitats d'un fitxer multimèdia.
 * 
 * @author Alberto Barragán
 * @author Tatiana Meyer
 */
public class FitxerMultimedia extends File {
    
    private String desc;

    /**
     * Inicialitza totes les variables de la classe.
     * 
     * @param nom 
     * @param descripcio 
     */
    public FitxerMultimedia(String nom, String descripcio) {
        super(nom);
        desc = descripcio;
    }

    /**
     * Retorna la data de l'última modificació del fitxer.
     * @return Date
     */
    public Date getUltimaModificacio(){
        return new Date(lastModified());
    }
    
    /**
     * Retorna el camí absolut del fitxer.
     * @return String
     */
    public String getCamiAbsolut(){
        return this.getAbsolutePath();
    }
    
    /**
     * Retorna el nom del fitxer.
     * @return String
     */
    public String getNomFitxer(){
        return getName();
    }
    
    /**
     * Retorna l'extensió del fitxer.
     * @return String
     */
    public String getExtensio(){
        int pos=this.getName().lastIndexOf(".");
        String ex=this.getName().substring(++pos);
        return ex;
    }
    
    /**
     * Retorna la descripció.
     * @return String
     */
    public String getDescripcio(){
        return this.desc;
    }
    
    /**
     * Guarda la descripció passada per paràmetre.
     * @param descripcio 
     */
    public void setDescripcio(String descripcio){
        this.desc = descripcio;
    }
    
    /**
     * Compara dos fitxers per comprovar si són iguals.
     * 
     * @param fitxer
     * @return ambdós fitxers són iguals.
     */
    @Override
    public boolean equals(Object fitxer) {
        
        boolean res;
        
        FitxerMultimedia other = null;
        
        if (fitxer instanceof FitxerMultimedia) {
            other = (FitxerMultimedia) fitxer;
        }
        
        if (other == null) {
            res = false;
        }
        
        else {
            res = this.getNomFitxer().equals(other.getNomFitxer());
        }
        
        return res;
    
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.desc);
        return hash;
    }
    
    /**
     * Retorna una string amb tot el contingut de la classe.
     * 
     * @return string
     */
    @Override
    public String toString() {
        
        String all;
        
        all = "Nombre de archivo= "        + this.getNomFitxer()           + ", " + 
              "Nombre = "                  + this.getDescripcio()          + ", " + 
              "Última modificación = "     + this.getUltimaModificacio()   + ", " +
              "Extensión = "               + this.getExtensio()            + ", " + 
              "Camino completo = "         + this.getAbsolutePath();
        
        return all;
    
    }

}
