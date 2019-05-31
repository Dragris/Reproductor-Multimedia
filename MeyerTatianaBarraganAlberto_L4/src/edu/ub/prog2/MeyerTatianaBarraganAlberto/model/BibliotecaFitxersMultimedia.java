package edu.ub.prog2.MeyerTatianaBarraganAlberto.model;

import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.util.ArrayList;

/**
 * Contenidor de fitxers existents i no repetits.
 * 
 * @author Alberto Barragán
 * @author Tatiana Meyer
 */
public class BibliotecaFitxersMultimedia extends CarpetaFitxers{
    
    /**
     * Inicialitza totes les variables de la classe.
     */
    public BibliotecaFitxersMultimedia(){
        carpeta = new ArrayList();
    }
    
    /**
     * Afegeix un fitxer no repetit i existent a la carpeta.
     * 
     * @param f
     * @throws AplicacioException 
     */
    @Override
    public void addFitxer(File f) throws AplicacioException {
                
        if (!carpeta.contains(f) && f.exists()) {
            super.addFitxer(f);
        }
        
        else if (!f.exists()) {
            throw new AplicacioException("El fichero buscado no existe en el disco.");
        }
        
        else {
            throw new AplicacioException("El fichero ya existe en la biblioteca.");
        }
        
    }

    /**
     * Retorna la carpeta en forma d'array.
     * @return 
     */
    public ArrayList<FitxerMultimedia> getArray() {
        return this.carpeta;
    }
    
    /**
     * Elimina el fitxer que es troba a l'índex passat per paràmetre.
     * @param index
     * @throws AplicacioException 
     */
    public void removeFitxer(int index) throws AplicacioException {
        carpeta.remove(index);
    }
    
    
}
