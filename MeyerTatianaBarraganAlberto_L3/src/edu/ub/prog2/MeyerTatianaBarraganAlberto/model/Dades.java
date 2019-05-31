package edu.ub.prog2.MeyerTatianaBarraganAlberto.model;

import edu.ub.prog2.MeyerTatianaBarraganAlberto.controlador.Reproductor;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe on es guarden totes les dades de l'aplicació.
 * 
 * @author Alberto Barragán
 * @author Tatiana Meyer
 */
public class Dades implements Serializable {
    
    private final BibliotecaFitxersMultimedia biblioteca;
    private final List<AlbumFitxersMultimedia> albums;
    
    private boolean reproduccionBucle, reproduccionAleatoria;
    
    /**
     * Inicialitza totes les variables de la classe.
     */
    public Dades() {
        biblioteca = new BibliotecaFitxersMultimedia();
        albums = new ArrayList<>();
        reproduccionAleatoria = false;
        reproduccionBucle = false;
    }
    
    public BibliotecaFitxersMultimedia getBiblioteca() throws AplicacioException{
        if(isEmpty()){
            throw new AplicacioException("La biblioteca no té fitxers a reproduir.");
        }
        return this.biblioteca;
    }

    
    /**
     * Afegeix un nou vídeo a la biblioteca.
     * 
     * @param path
     * @param nomVideo
     * @param descripcio
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @param r
     * @throws AplicacioException 
     */
    public void afegirVideo(String path, String nomVideo, String descripcio, String codec, float durada, int alcada, int amplada, float fps, Reproductor r) throws AplicacioException {
        biblioteca.addFitxer(new Video(path, nomVideo, descripcio, codec, durada, alcada, amplada, fps, r));
    }
    
    
    /**
     * Afegeix un nou àudio a la biblioteca.
     * 
     * @param cami
     * @param camiImatge
     * @param nomAudio
     * @param descripcio
     * @param codec
     * @param durada
     * @param kbps
     * @param r
     * @throws AplicacioException 
     */
    public void afegirAudio(String cami, String camiImatge, String nomAudio, String descripcio, String codec, float durada, int kbps, Reproductor r) throws AplicacioException {
        biblioteca.addFitxer(new Audio(cami, new File(camiImatge), nomAudio, descripcio, codec, durada, kbps, r));
    }
    
    /**
     * Retorna una llista amb tots els elements de la biblioteca.
     * 
     * @return elements de la  biblioteca
     */
    public List<String> mostrarBiblioteca(){
        
        List<String> dades = new ArrayList<>();
        
        biblioteca.getArray().forEach((fm) -> {
            dades.add(fm.toString());
        });
        
        return dades;
    
    }
    
    /**
     * Diu si la biblioteca està buida
     * @return True/False depenent si està buida o no
     */
    public boolean isEmpty() {
        return this.biblioteca.getSize() == 0;
    }
    
    /**
     * Esborra el fitxer que està a la posició passada per paràmetre.
     * 
     * @param id
     * @throws AplicacioException 
     */
    public void esborrarFitxer(int id) throws AplicacioException{
        if(isEmpty())
            throw new AplicacioException ("No hay ficheros para eliminar.");
        
        try {
            FitxerMultimedia file = (FitxerMultimedia) biblioteca.getAt(id);
            biblioteca.removeFitxer(file);
            
            albums.forEach((album) -> {
                while (album.contains(file)) {
                    album.removeFitxer(file);
                }
        });
        } catch (IndexOutOfBoundsException io) {
            throw new AplicacioException("ID de fitxer incorrecte.");
        }
            
    }
    
    /**
     * Guarda al fitxer totes les dades de l'aplicació.
     * 
     * @param camiDesti
     * @throws AplicacioException 
     */
    public void guardarDadesDisc(String camiDesti) throws AplicacioException {
        File savedFile = new File(camiDesti);

        try (FileOutputStream fout = new FileOutputStream(savedFile);
            ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(this);
            oos.flush();
        } catch (IOException ex) {
            throw new AplicacioException("No es pot guardar el fitxer.");
        }
    }
    
    /**
     * Carrega les dades del fitxer i les guarda.
     * 
     * @param camiOrigen
     * @return
     * @throws AplicacioException 
     */
    public static Dades carregarDades(String camiOrigen) throws AplicacioException {
        File loadFile = new File(camiOrigen);
        Dades dades;

        if (!loadFile.exists()) {
            throw new AplicacioException("No existeix el fixter de dades.");
        } else {
            try (FileInputStream fis = new FileInputStream(loadFile);
                    ObjectInputStream ois = new ObjectInputStream(fis)) {
                dades = (Dades) ois.readObject();
            } catch (IOException ex) {
                throw new AplicacioException("No es pot carregar o no existeix el fitxer.");
            } catch (ClassNotFoundException ex) {
                throw new AplicacioException("Error amb les dades.");
            }
            return dades;
        }
    }
    
    /**
     * Asigna el reproductor a cada fichero
     *
     * @param reproductor
     */
    public void setReproductor(Reproductor reproductor) {
        for (int i = 0; i < biblioteca.getSize(); i++) {
            File fitxer = biblioteca.getAt(i);
            if (fitxer instanceof FitxerReproduible) {
                ((FitxerReproduible) fitxer).setReproductor(reproductor);
            }
        }
    }    
    
    // Getters y Setters START
    public boolean isReproduccioBucle() {
        return reproduccionBucle;
    }

    public boolean isReproduccioAleatoria() {
        return reproduccionAleatoria;
    }

    public void setReproduccioBucle(boolean reproduccioCiclica) {
        this.reproduccionBucle = reproduccioCiclica;
    }

    public void setReproduccioAleatoria(boolean reproduccioAleatoria) {
        this.reproduccionAleatoria = reproduccioAleatoria;
    }
    /**
     * Devuelve CarpetaFiters con un solo fichero
     * @param id
     * @return
     * @throws AplicacioException 
     */
    public CarpetaFitxers getCarpetaReproduccio (int id) throws AplicacioException {
        if (isEmpty()){
            throw new AplicacioException("No hi ha fitxers a la biblioteca.");
        }
        try{
            CarpetaFitxers tmp = new CarpetaFitxers(1);
            tmp.addFitxer(biblioteca.getAt(id));
            return tmp;
        } catch (IndexOutOfBoundsException io){
            throw new AplicacioException("Id de fitxer incorrecte.");
        }
    }
    /**
     * Devuelve el album seleccionado
     *
     * @param titol
     * @return CarpetaFitxer
     * @throws AplicacioException
     */
    public CarpetaFitxers getCarpetaReproduccio(String titol) throws AplicacioException {
        AlbumFitxersMultimedia album = getAlbumByTitulo(titol);
        if (album.getSize() == 0) {
            throw new AplicacioException("No hi ha fitxers en aquest album");
        }
        return album;
    }    
    
    /**
     * Devuelve CarpetaFitxers con un solo fichero de un álbum.
     * @param id
     * @param tituloAlbum
     * @return
     * @throws AplicacioException 
     */
    public CarpetaFitxers getCarpetaReproduccioAlbum(int id, String tituloAlbum) throws AplicacioException {
        if (isEmpty()){
            throw new AplicacioException("No hi ha fitxers a la biblioteca.");
        }
        try {
            CarpetaFitxers tmp = new CarpetaFitxers(1);
            tmp.addFitxer(getAlbumByTitulo(tituloAlbum).getAt(id));
            return tmp;
        } catch (IndexOutOfBoundsException io){
            throw new AplicacioException("Id de fitxer incorrecte.");
        }
    }
    
    
    /**
    * Borra el álbum por título.
    * @param titulo titulo del álbum a borrar
    * @throws AplicacioException 
    */
    public void removeAlbum(String titulo) throws AplicacioException {
        albums.remove(getAlbumByTitulo(titulo));
    }
    
    /**
    * Añade un nuevo album
    *
    * @param titol titulo del album a añadir
    * @param size tamaño del album a añadir
    * @throws AplicacioException
    */
    public void addAlbum(String titol, int size) throws AplicacioException {
        if (existeAlbum(titol)) {
            throw new AplicacioException("Ya existeix aquest album.");
        }
        if (titol.isEmpty() || titol.startsWith(" ")) {
            throw new AplicacioException("Títol no valid.");
        }
        albums.add(new AlbumFitxersMultimedia(size, titol));
    }
    
    /**
    * Comprueba si existe un album
    *
    * @param titol nombre del album del cual se comprueba su existencia
    * @return boolean true/false si existe o no
    */
    public boolean existeAlbum(String titol) {
        AlbumFitxersMultimedia nouAlbum = new AlbumFitxersMultimedia(titol);
        return albums.contains(nouAlbum);
    }
    
    /**
    * Obtiene el título de un album
    *
    * @param id: identificador del album
    * @return titulo del album con ese id
    * @throws AplicacioException
    */
    public String getTituloAlbum(int id) throws AplicacioException {
        if (albums.isEmpty()) {
            throw new AplicacioException("No hi ha albums.");
        }
        try {
            return albums.get(id).getTitulo();
        } catch (IndexOutOfBoundsException io) {
            throw new AplicacioException("Id del album incorrecte.");
        }
    }
    
    /**
     * Retorna una llista amb el titol de tots els àlbums
     * @return Llistat de titols
     */
    public List<String> mostraAlbums(){
        List<String> mostraAlbums = new ArrayList<>(albums.size());
        for (AlbumFitxersMultimedia album : albums){
            StringBuilder sb = new StringBuilder();
            sb.append(album.getTitulo()).append(" (").append(album.freeSpace()).append(")");
            mostraAlbums.add(sb.toString());
        }
        return mostraAlbums;
    }
    
    /**
    * Obtiene el album a traves del título
    *
    * @param title nombre del album
    * @return el album con ese titulo
    * @throws AplicacioException
    */
    public AlbumFitxersMultimedia getAlbumByTitulo(String title) throws AplicacioException {
        AlbumFitxersMultimedia albumTmp = new AlbumFitxersMultimedia(title);
        int albumIndex = albums.indexOf(albumTmp);
        if (albumIndex == -1) {
            throw new AplicacioException("No existeix aquest album.");
        }
        return albums.get(albumIndex);
    }
    
    /**
    * Añade un fichero al Album seleccionado
    *
    * @param titolAlbum titulo del album
    * @param id 
    * @throws AplicacioException
    */
    public void afegirFitxerAlbum(String titolAlbum, int id) throws AplicacioException {
        if (isEmpty()) {
            throw new AplicacioException("No hi ha fitxers a la biblioteca.");
        }
        try {
            FitxerMultimedia file = (FitxerMultimedia) biblioteca.getAt(id);
            getAlbumByTitulo(titolAlbum).addFitxer(file);
        } catch (IndexOutOfBoundsException io) {
            throw new AplicacioException("Id de fitxer incorrecte.");
        }
    }

    /**
     * Borra un fichero del album seleccionado
     *
     * @param titulo
     * @param id identificador de la cancion
     * @throws AplicacioException
     */
    public void esborrarFitxerAlbum(String titulo, int id) throws AplicacioException {
        try {
            AlbumFitxersMultimedia album = getAlbumByTitulo(titulo);
            if (album.getSize() == 0) {
                throw new AplicacioException("No hi ha fitxers en aquest album.");
            }
            FitxerMultimedia file = (FitxerMultimedia) album.getAt(id);
            album.removeFitxer(file);
        } catch (IndexOutOfBoundsException io) {
            throw new AplicacioException("Id de fitxer incorrecte.");
        }
    }
    
    
    /**
    * Retorna la lista de ficheros multimedia en lista de Strings
    *
    * @param titol titulo del album
    * @return List lista de los ficheros del album
    * @throws AplicacioException
    */
    public List<String> albumToString(String titol) throws AplicacioException {
        List<String> albumList;
        String albumToStr = getAlbumByTitulo(titol).toString();

        if (albumToStr.isEmpty()) {
            albumList = new ArrayList<>();
        } else {
            String[] albumToStrArr = albumToStr.split("\n"); // Array de Strings (Lineas)
            albumList = new ArrayList<>(Arrays.asList(albumToStrArr));
        }
        return albumList;
    }
}
    
