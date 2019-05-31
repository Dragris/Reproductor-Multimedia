package edu.ub.prog2.MeyerTatianaBarraganAlberto.model;

import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.InFileFolder;
import java.io.File;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.Iterator;

/**
 * Contenidor de fitxers.
 * 
 * @author Alberto Barragán
 * @author Tatiana Meyer
 */
public class CarpetaFitxers implements Serializable, InFileFolder{
    
    private int MAX_Size;
    private int size;
    protected ArrayList<FitxerMultimedia> carpeta;
    
    //CONSTRUCTORES
    public CarpetaFitxers(int n){
        this.MAX_Size = n;
        carpeta = new ArrayList<>();
    }
    
    public CarpetaFitxers(){
        this.MAX_Size = 100;
        carpeta = new ArrayList<>();
    }
    
    @Override
    public int getSize(){
        return this.carpeta.size();
    }
    
    /**
     * Método para añadir un fichero en el arrayList.
     * @param fitxer 
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    @Override
    public void addFitxer(File fitxer) throws AplicacioException {
        if(!isFull()){
           this.carpeta.add((FitxerMultimedia) fitxer);
        }else{
           throw new AplicacioException("L'album esta ple.");
        }
    }
    
    /**
     * Método que elimina un fichero idéntico dentro del arrayList.
     * @param fitxer 
     */
    @Override
    public void removeFitxer(File fitxer){
        carpeta.remove(getFitxer(fitxer));
    }
    
    /**
     * Devuelve el fichero que se encuentre en la posición dada, contando la
     * posición 0.
     * @param pos posicion del fichero
     * @return fichero buscado
     */
    @Override
    public File getAt(int pos){
        return carpeta.get(pos);
    }
    
    /**
     * Vaciado instantáneo del arrayList carpeta.
     */
    @Override
    public void clear(){
        carpeta.removeAll(carpeta);
    }
    
    /**
     * Boolean que indica si la carpeta está llena.
     * @return 
     */
    @Override
    public boolean isFull() {
        return carpeta.size() >= MAX_Size;
    }
    
    /**
     * Devuelve true o false si se encuentra el fichero dentro de la carpeta.
     * @param fitxer
     * @return 
     */
    public boolean contains(File fitxer) {
        return carpeta.contains((FitxerMultimedia) fitxer);
    }
    
    /**
     * Devuelve el espacio libre en la carpeta.
     * @return 
     */
    public int freeSpace() {
        return MAX_Size - carpeta.size();
    }
    
    /**
     * Encuentra la primera coincidencia del fichero entrado por su nombre.
     * @param fitxer
     * @return 
     */
    public File getFitxer(File fitxer) {
        //String filePath = getFileName();
        String fileNom = fitxer.getName();
        for (File carpeta1 : carpeta) {
            if (fileNom.equals(carpeta1.getName())) {
                return carpeta1;
            }
        }
        System.out.println("No s'ha trobat el fitxer a borrar.");
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        Iterator<FitxerMultimedia> fileIt = carpeta.iterator();
        int cont = 1;
        while(fileIt.hasNext()) {
            FitxerMultimedia currentFile = fileIt.next();
            sb.append(cont).append(". ").append(currentFile.getName()).append(" [")
                    .append(currentFile.getClass().getSimpleName())
                    .append("]").append("\n");
            cont++;
        }
        return sb.toString();
    }
    
}
