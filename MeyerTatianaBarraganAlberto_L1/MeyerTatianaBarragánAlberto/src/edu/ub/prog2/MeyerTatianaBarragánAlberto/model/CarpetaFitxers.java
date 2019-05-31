package edu.ub.prog2.MeyerTatianaBarragánAlberto.model;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.io.File;


public class CarpetaFitxers {
    private int MAX_Size;
    private int size;
    List<File> carpeta = new ArrayList<>();
    
    
    //CONSTRUCTORES
    public CarpetaFitxers(int n){
        this.MAX_Size = n;
        carpeta = new ArrayList<>();
    }
    
    public CarpetaFitxers(){
        this.MAX_Size = 100;
        carpeta = new ArrayList<>();
    }
    
    public int getSize(){
        return this.size;
    }
    
    
    /**
     * Método para añadir un fichero en el arrayList.
     * @param fitxer 
     */
    public void addFitxer(File fitxer){
        if (carpeta.size() < MAX_Size) {
            carpeta.add(fitxer);
        } else {
            System.out.println("Error, la carpeta és plena.");
        }
    }
    
    /**
     * Método que elimina un fichero idéntico dentro del arrayList.
     * @param fitxer 
     */
    public void removeFitxer(File fitxer){
        carpeta.remove(getFitxer(fitxer));
    }
    
    /**
     * Devuelve el fichero que se encuentre en la posición dada, contando la
     * posición 0.
     * @param pos
     * @return 
     */
    public File getAt(int pos){
        return carpeta.get(pos);
    }
    
    /**
     * Vaciado instantáneo del arrayList carpeta.
     */
    public void clear(){
        carpeta.removeAll(carpeta);
    }
    
    /**
     * Boolean que indica si la carpeta está llena.
     * @return 
     */
    public boolean isFull() {
        return carpeta.size() >= MAX_Size;
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
    public String toString(){
        String all = null;
        all = "Carpeta	Fitxers:	\n" + "==============\n";
        for (int i = 0; i < carpeta.size(); i++){
            all = all + "["+i+"]"+ carpeta.get(i).toString() +"\n";
        }
        return all;
    }
}
