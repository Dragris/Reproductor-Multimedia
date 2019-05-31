package edu.ub.prog2.MeyerTatianaBarraganAlberto.controlador;

import edu.ub.prog2.MeyerTatianaBarraganAlberto.model.CarpetaFitxers;
import edu.ub.prog2.MeyerTatianaBarraganAlberto.model.Dades;
import edu.ub.prog2.utils.AplicacioException;
import static edu.ub.prog2.MeyerTatianaBarraganAlberto.model.Dades.carregarDades;
import edu.ub.prog2.utils.InControlador;
import java.io.File;
import java.util.List;
import java.util.Scanner;

/**
 * @author Alberto Barragán
 * @author Tatiana Meyer
 */
public class Controlador implements InControlador {
    
    private Dades dada;
    private transient Reproductor rep;
    private EscoltadorReproduccio escoltador; 
    //private BibliotecaFitxersMultimedia model;
    
    public Controlador(){
        this.escoltador = new EscoltadorReproduccio();
        this.rep = new Reproductor(escoltador);
        this.dada = new Dades();
    }
    
    /**
     * Afegeix un fitxer a l'album desitjat
     * @param titolAlbum
     * @param i
     * @throws AplicacioException 
     */
    @Override
    public void afegirFitxer(String titolAlbum, int i) throws AplicacioException {
        if(this.existeixAlbum(titolAlbum)){
            dada.afegirFitxerAlbum(titolAlbum,i);
        }else{
            throw new AplicacioException("L'album no existeix");
        }
    }
    
    /**
     * Afegeix un video
     * @param path
     * @param nomVideo
     * @param descripcio
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @throws AplicacioException 
     */
    public void afegirVideo(String path, String nomVideo, String descripcio, String codec, float durada, int
    alcada, int amplada, float fps) throws AplicacioException{
        this.dada.afegirVideo(path, nomVideo, descripcio, codec, durada, alcada, amplada, fps, rep);
    }
    
    
    @Override
    public void afegirVideo(String path, String nomVideo, String codec, float durada, int
    alcada, int amplada, float fps) throws AplicacioException {
        this.dada.afegirVideo(path, nomVideo, "descripcio", codec, durada, alcada, amplada, fps, rep);
    }
    
    
    public void afegirAudio(String cami, String camiImatge, String nomAudio, String descripcio, String
    codec, float durada, int kbps) throws AplicacioException{
        this.dada.afegirAudio(cami, camiImatge, nomAudio, descripcio, codec, durada, kbps, rep);
    }
    
    @Override
    public void afegirAudio(String cami, String camiImatge, String nomAudio,  String codec, float durada, int kbps) throws AplicacioException {
        this.dada.afegirAudio(cami, camiImatge, nomAudio, "descripcio", codec, durada, kbps, rep);
    }
    
    /**
     * 
     * @return llista dels retorns de toString() dels fitxers
     */
    public List<String> mostrarBiblioteca(){
        return this.dada.mostrarBiblioteca();
    }
    
     /**
     * Esborra un Fitxer
     * id: és la posició a llista de getBiblioteca()
     * @param id
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    @Override
    public void esborrarFitxer(int id) throws AplicacioException {
        try {
            dada.esborrarFitxer(id);
        }       
        catch (IndexOutOfBoundsException ex){
            throw new AplicacioException("ID Invàlida");
        }
        
    }
    
    @Override
    public void esborrarFitxer(String titolAlbum, int i) throws AplicacioException {
        if(this.existeixAlbum(titolAlbum)){
            dada.esborrarFitxerAlbum(titolAlbum, i);
        }else{
            throw new AplicacioException("L'album no existeix");
        }
    }
    
    
    /**
     * Delega a Dades l'implementació.
     * @param camiDesti
     * @throws AplicacioException 
     */
    @Override
    public void guardarDadesDisc(String camiDesti) throws AplicacioException {
        dada.guardarDadesDisc(camiDesti);
    }
    
    /**
     * Obté les dades del fitxer i les guarda.
     * 
     * @param camiOrigen
     * @throws AplicacioException 
     */
    @Override
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException {
        this.dada = carregarDades(camiOrigen);
        dada.setReproductor(rep);
    }
    
    //Álbumes:

    @Override
    public void afegirAlbum(String string) throws AplicacioException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Indica el tamany de l'àlbum:");
        int x = sc.nextInt();
        if(!this.existeixAlbum(string)){
            dada.addAlbum(string, x);
        }else{
            throw new AplicacioException("L'album ja existeix");
        }
    }
    
    @Override
    public List<String> mostrarLlistatAlbums() {
        return dada.mostraAlbums();
    }
    
    @Override
    public void esborrarAlbum(String string) throws AplicacioException {
        if(!this.existeixAlbum(string)){
            throw new AplicacioException("L'album no existeix");
        }else{
            dada.removeAlbum(string);
        }
    }
    
    @Override
    public boolean existeixAlbum(String string) {
        return dada.existeAlbum(string);
    }
    
    //Álbum:
    
    public void afegirFitxerAlbum(String titolAlbum, int id) throws AplicacioException {
        dada.afegirFitxerAlbum(titolAlbum, id);
    }
    
    @Override
    public List<String> mostrarAlbum(String string) throws AplicacioException {
        return dada.albumToString(string);
    }
    
    
    public void eliminarFitxerAlbum(String titulo, int id) throws AplicacioException {
        dada.esborrarFitxerAlbum(titulo, id);
    }
    
    //Control reproducción:
     /**
     * Reproduce un solo fichero
     * id: és la posició a llista de getBiblioteca()
     * @param id
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    @Override
    public void reproduirFitxer(int id) throws AplicacioException {
        try{
        obrirFinestraReproductor();
        escoltador.iniciarReproduccio(dada.getCarpetaReproduccio(id),
                false, false);
        } catch (AplicacioException e){
            tancarFinestraReproductor();
            throw new AplicacioException(e.getMessage());
        }

    }
    
    /**
     * Reproduce un solo fichero de álbum
     * id: és la posició a llista de getBiblioteca()
     * @param id
     * @param tituloAlbum
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    public void reproduirFitxer(int id, String tituloAlbum) throws AplicacioException {
        try{
        obrirFinestraReproductor();
        escoltador.iniciarReproduccio(dada.getCarpetaReproduccioAlbum(id, tituloAlbum),
                dada.isReproduccioBucle(), false);
        } catch (AplicacioException e){
            tancarFinestraReproductor();
            throw new AplicacioException(e.getMessage());
        }

    }
    
    /**
     * Reproduce la biblioteca.
     * @throws AplicacioException 
     */
    @Override
    public void reproduirCarpeta() throws AplicacioException {
        try {
            obrirFinestraReproductor();
            escoltador.iniciarReproduccio(dada.getBiblioteca(),
                    dada.isReproduccioBucle(), dada.isReproduccioAleatoria());
        } catch (AplicacioException ae) {
            tancarFinestraReproductor();
            throw new AplicacioException(ae.getMessage());
        }
    }

    /**
     * Reproduce un álbum.
     * @param titolAlbum
     * @throws AplicacioException 
     */
    @Override
    public void reproduirCarpeta(String titolAlbum) throws AplicacioException {
        try {
            obrirFinestraReproductor();
            escoltador.iniciarReproduccio(dada.getCarpetaReproduccio(titolAlbum),
                    dada.isReproduccioBucle(), dada.isReproduccioAleatoria());
        } catch (AplicacioException ae) {
            tancarFinestraReproductor();
            throw new AplicacioException(ae.getMessage());
        }
    }
    /**
     * Activa/desactiva reproducción cíclica
     */
    public void toggleLoop(){
        if (this.dada.isReproduccioBucle()){
            System.out.println("Loop Off.");
            this.dada.setReproduccioBucle(false);
        }else{
            System.out.println("Loop On.");
            this.dada.setReproduccioBucle(true);
        }
    }
    
    /**
     * Activa/desactiva reproducción aleatoria
     */
    public void toggleRandom(){
        if (dada.isReproduccioAleatoria()){
            System.out.println("Aleatorio off.");
            dada.setReproduccioAleatoria(false);
        }else{
            System.out.println("Aleatorio on.");
            dada.setReproduccioAleatoria(true);
        }
    }
    
    //Control de reproducción en curso:
    
    @Override
    public void reemprenReproduccio() throws AplicacioException {
        if (!escoltador.isReproduciendo()){
            throw new AplicacioException("No hi ha reproducción en curs pausada.");
        }
        rep.resume();
    }
    
    @Override
    public void pausaReproduccio() throws AplicacioException {
        if (!escoltador.isReproduciendo()){
            throw new AplicacioException("No hi ha reproducción en curs.");
        }
        rep.pause();
    }
    
    @Override
    public void aturaReproduccio() throws AplicacioException {
        if (!escoltador.isReproduciendo()){
            throw new AplicacioException("No hi ha reproducció en curs per aturar");
        }
        rep.stop();
        escoltador.setReproduciendo(false);
        tancarFinestraReproductor();
    }
    
    @Override
    public void saltaReproduccio() throws AplicacioException {
        if (!escoltador.isReproduciendo()){
            throw new AplicacioException("No hi ha reproducció en curs per poder saltar.");
        } else if (!escoltador.hasNext()){
            rep.stop();
            escoltador.setReproduciendo(false);
            tancarFinestraReproductor();
            throw new AplicacioException("No hi han mes fitxers per reproduir.");
        }
        escoltador.next();
    }

    
    @Override
    public void obrirFinestraReproductor() {
        rep.open();
    }

    @Override
    public void tancarFinestraReproductor() throws AplicacioException {
        rep.close();
    }

}
