package edu.ub.prog2.MeyerTatianaBarraganAlberto.vista;

import edu.ub.prog2.MeyerTatianaBarraganAlberto.controlador.Controlador;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.Menu;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Fa la gestió de tots els menús i de l'interacció amb l'usuari.
 * 
 * @author Alberto Barragán
 * @author Tatiana Meyer
 */
public class AplicacioUB3 {

    private final Scanner sc;
    private final Controlador controlador;
    
    private static final String TITOL_MENU_PRINCIPAL = "MENÚ PRINCIPAL";
    private static final String TITOL_MENU_GESTIO_BIBLIOTECA = "Gestió biblioteca";
    private static final String TITOL_MENU_AFEGIR_FITXER = "Afegir fitxer multimèdia a la biblioteca";
    private static final String TITOL_MENU_GESTIO_ALBUM = "Gestió àlbums";
    private static final String TITOL_MENU_GESTIONAR_ALBUM = "Gestionar àlbum";
    private static final String TITOL_MENU_CONTROL_REPRODUCCIO = "Gestió reproducció";
    private static final String TITOL_MENU_REPRODUCCIO_EN_CURS = "Gestió reproducció en curs";
    
    static private enum OpcionsMenuPrincipal {
        GESTIO_BIBLIOTECA,
        GESTIO_ALBUMS,
        CONTROL_REPRODUCCIO,
        GUARDAR_DADES,
        RECUPERAR_DADES,
        SORTIR
    }  
    
    static private enum OpcionsMenuGestioBiblioteca {
        AFEGIR_FITXER_MULTIMEDIA,
        MOSTRAR_BIBLIOTECA,
        ELIMINAR_FITXER_MULTIMEDIA,
        MENU_ANTERIOR
    }
    
    static private enum OpcionsMenuAfegirFitxer {
        AFEGIR_VIDEO,
        AFEGIR_AUDIO,
        MENU_ANTERIOR
    }
    
    static private enum OpcionsMenuGestioAlbum { 
        AFEGIR_ALBUM,
        MOSTRAR_ALBUMS,
        ELIMINAR_ALBUMS,
        GESTIONAR_ALBUM,
        MENU_ANTERIOR
    }
    
    static private enum OpcionsMenuGestionarAlbum {
        AFEGIR_FITXER,
        MOSTRAR_ALBUM,
        ELIMINAR_FITXER,
        MENU_ANTERIOR
    }
    
    static private enum OpcionsMenuControlReproduccio {
        REPRODUIR_FITXER,
        REPRODUIR_BIBLIOTECA,
        REPRODUIR_ALBUM,
        TOGGLE_LOOP,
        TOGGLE_RANDOM,
        GESTIO_REPRODUCCIO_EN_CURS,
        MENU_ANTERIOR
    }
    
    static private enum OpcionsMenuGestioReproduccioEnCurs {
        CONTINUE,
        PAUSE,
        STOP,
        SKIP,
        SCAPE
    }
    
    
    private static final String[] DESCRIPCIONS_MENU_PRINCIPAL = {
        "Gestió Biblioteca",
        "Gestió Àlbums",
        "Control Reproducció",
        "Guardar dades",
        "Recuperar dades",
        "Sortir"
    };

    private static final String[] DESCRIPCIONS_MENU_GESTIO_BIBLIOTECA = {
        "Afegir fitxer multimèdia a la biblioteca",
        "Mostrar Biblioteca",
        "Eliminar fitxer multimèdia",
        "Menú anterior"
    };
    
    private static final String[] DESCRIPCIONS_MENU_AFEGIR_FITXER = {
        "Afegir vídeo",
        "Afegir audio",
        "Menú anterior"
    };
    
    private static final String[] DESCRIPCIONS_MENU_GESTIO_ALBUM = {
        "Afegir Àlbum",
        "Mostrar Àlbums",
        "Eliminar Àlbum",
        "Gestionar Àlbum",
        "Menú Anterior"
    };
    
    private static final String[] DESCRIPCIONS_MENU_GESTIONAR_ALBUM = {
        "Afegir fitxer multimèdia",
        "Mostrar àlbum",
        "Eliminar fitxer multimèdia",
        "Menú anterior"
    };
   
    private static final String[] DESCRIPCIONS_MENU_CONTROL_REPRODUCCIO = {
        "Reproduir un fitxer reproduïble",
        "Reproduir tota la biblioteca",
        "Reproduir un álbum",
        "Toggle looping",
        "Toggle random",
        "Gestió reproducció en curs",
        "Menú anterior"
    };
    
    private static final String[] DESCRIPCIONS_MENU_CONTROL_REPRODUCCIO_EN_CURS = {
        "Continuar",
        "Pausa",
        "Atura",
        "Salta",
        "Sortir"
    };
    
    
    /**
     * Inicialitza les variables de la classe.
     */
    public AplicacioUB3() {
        sc = new Scanner(System.in);
        controlador = new Controlador();
    }
    
    /**
     * Mostra a l'usuari el menú principal per a poder escollir-ne una opció.
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    public void gestioAplicacioUB() throws AplicacioException {
        
        Menu<OpcionsMenuPrincipal> menu = new Menu<>(TITOL_MENU_PRINCIPAL, OpcionsMenuPrincipal.values());
        menu.setDescripcions(DESCRIPCIONS_MENU_PRINCIPAL);
    
        OpcionsMenuPrincipal opcio;
        
        do {
            
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            
            switch (opcio) {
                
                case GESTIO_BIBLIOTECA:
                    menuGestioBiblioteca();
                    break;
                    
                case GESTIO_ALBUMS:
                    menuGestioAlbums();
                    break;
                    
                case CONTROL_REPRODUCCIO:
                    menuControlReproduccio();
                    break;
                    
                case GUARDAR_DADES:
                    guardarDades();
                    break;
                    
                case RECUPERAR_DADES:
                    recuperarDades();
                    break;
                    
                case SORTIR:
                    break;
                    
                default:
                    break;
                    
            }
            
        } while (opcio != OpcionsMenuPrincipal.SORTIR);
    
    }
    
    /**
     * Mostra a l'usuari el menú de la gestió de la
     * biblioteca per a poder escollir-ne una opció.
     */
    public void menuGestioBiblioteca() {
        
        Menu<OpcionsMenuGestioBiblioteca> menu = new Menu<>(TITOL_MENU_GESTIO_BIBLIOTECA, OpcionsMenuGestioBiblioteca.values());
        menu.setDescripcions(DESCRIPCIONS_MENU_GESTIO_BIBLIOTECA);
        
        OpcionsMenuGestioBiblioteca opcio;
        
        do {
            
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            
            switch (opcio) {
                
                case AFEGIR_FITXER_MULTIMEDIA:
                    menuAfegirFitxer();
                    break;
                    
                case MOSTRAR_BIBLIOTECA:
                    mostrarBiblioteca();
                    break;
                    
                case ELIMINAR_FITXER_MULTIMEDIA:
                    eliminarFitxerMultimedia();
                    break;
                    
                case MENU_ANTERIOR:
                    break;
                
                default:
                    break;
                    
            }
            
        } while (opcio != OpcionsMenuGestioBiblioteca.MENU_ANTERIOR);
        
    }
    
    /**
     * Muestra al usuario el menú de gestión de los álbumes.
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    public void menuGestioAlbums() throws AplicacioException {
        Menu<OpcionsMenuGestioAlbum> menu = new Menu<>(TITOL_MENU_GESTIO_ALBUM, OpcionsMenuGestioAlbum.values());
        menu.setDescripcions(DESCRIPCIONS_MENU_GESTIO_ALBUM);
        
        OpcionsMenuGestioAlbum opcio;
        
        do{
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            
            switch (opcio) {
                case AFEGIR_ALBUM:
                    afegirAlbum();
                    break;
                    
                case MOSTRAR_ALBUMS:
                    mostrarAlbums();
                    break;
                    
                case ELIMINAR_ALBUMS:
                    eliminarAlbums();
                    break;
                    
                case GESTIONAR_ALBUM:
                    MenuGestionarAlbum();
                    break;
                    
                default:
                    break;
            }
            
        } while (opcio != OpcionsMenuGestioAlbum.MENU_ANTERIOR);
    }
    
    /**
     * Muestra al usuario el menú para modificar los ficheros de un álbum.
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    public void MenuGestionarAlbum() throws AplicacioException {
        Menu<OpcionsMenuGestionarAlbum> menu = new Menu<> (TITOL_MENU_GESTIONAR_ALBUM, OpcionsMenuGestionarAlbum.values());
        menu.setDescripcions(DESCRIPCIONS_MENU_GESTIONAR_ALBUM);
        
        OpcionsMenuGestionarAlbum opcio;
        
        do{
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            
            switch(opcio){
                case AFEGIR_FITXER:
                    afegirFitxerAlbum();
                    break;
                
                case MOSTRAR_ALBUM:
                    mostrarAlbum();
                    break;
                    
                case ELIMINAR_FITXER:
                    eliminarFitxerAlbum();
                    break;
                    
                default:
                    break;
            }
        } while (opcio != OpcionsMenuGestionarAlbum.MENU_ANTERIOR);
    }
    /**
     * Muestra al usuario el menú para reproducir los archivos almacenados en la biblioteca.
     * @throws edu.ub.prog2.utils.AplicacioException
     */
    public void menuControlReproduccio() throws AplicacioException {
        Menu<OpcionsMenuControlReproduccio> menu = new Menu<>(TITOL_MENU_CONTROL_REPRODUCCIO, OpcionsMenuControlReproduccio.values());
        menu.setDescripcions(DESCRIPCIONS_MENU_CONTROL_REPRODUCCIO);
        
        OpcionsMenuControlReproduccio opcio;
        
        do {
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            
            switch (opcio) {
                case REPRODUIR_FITXER:
                    reproduirFitxer();
                    break;
                    
                case REPRODUIR_BIBLIOTECA:
                    reproduirBiblioteca();
                    break;
                    
                case REPRODUIR_ALBUM:
                    reproduirAlbum();
                    break;
                    
                case TOGGLE_LOOP:
                    toggleLoop();
                    break;
                    
                case TOGGLE_RANDOM:
                    toggleRandom();
                    break;
                    
                case GESTIO_REPRODUCCIO_EN_CURS:
                    menuReproduccioEnCurs();
                    break;
                    
                default:
                    break;
                    
            } 
        } while (opcio != OpcionsMenuControlReproduccio.MENU_ANTERIOR);
    }
    
    
    /**
     * Muestra el menú de reproducción en curso.
     */
    public void menuReproduccioEnCurs() {
        Menu<OpcionsMenuGestioReproduccioEnCurs> menu = new Menu<>(TITOL_MENU_REPRODUCCIO_EN_CURS, OpcionsMenuGestioReproduccioEnCurs.values());
        menu.setDescripcions(DESCRIPCIONS_MENU_CONTROL_REPRODUCCIO_EN_CURS);
        
        OpcionsMenuGestioReproduccioEnCurs opcio;
        
        do {
            
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            
            switch (opcio) {
                
                case CONTINUE:
                    continuar();
                    break;
                    
                case PAUSE:
                    pausar();
                    break;
                    
                case STOP:
                    parar();
                    break;
                    
                case SKIP:
                    saltar();
                    break;
                    
                default:
                    break;
            }
            
        } while (opcio != OpcionsMenuGestioReproduccioEnCurs.SCAPE);
    }
    
    
    /**
     * Muestra al usuario el menú para añadir ficheros en la biblioteca.
     */
    public void menuAfegirFitxer() {
        
        Menu<OpcionsMenuAfegirFitxer> menu = new Menu<>(TITOL_MENU_AFEGIR_FITXER, OpcionsMenuAfegirFitxer.values());
        menu.setDescripcions(DESCRIPCIONS_MENU_AFEGIR_FITXER);
        
        OpcionsMenuAfegirFitxer opcio;
        
        do {
            
            menu.mostrarMenu();
            opcio = menu.getOpcio(sc);
            
            switch (opcio) {
                
                case AFEGIR_VIDEO:
                    afegirVideo();
                    break;
                    
                case AFEGIR_AUDIO:
                    afegirAudio();
                    break;
                    
                case MENU_ANTERIOR:
                    break;
                    
                default:
                    break;
                
            }
            
        } while (opcio != OpcionsMenuAfegirFitxer.MENU_ANTERIOR);
        
    }
    
    /**
     * Demana a l'usuari les dades d'un àudio i
     * delega al Controlador l'implementació.
     */
    private void afegirAudio() {
        
        System.out.print("Camí: ");
        String cami = sc.nextLine();
        
        System.out.print("Camí de la imatge: ");
        String camiImatge = sc.nextLine();
        
        System.out.print("Descripció: ");
        String descripcio = sc.nextLine();
        
        System.out.print("Codec: ");
        String codec = sc.nextLine();
        
        String nomAudio = "";
        float durada = 0.0f;
        int kbps = 0;
        
        try {
            controlador.afegirAudio(cami, camiImatge, nomAudio, descripcio, codec, durada, kbps);
        } 
        
        catch (AplicacioException excepcio) {
            System.out.println(excepcio.getMessage());
        }
        
    }

    /**
     * Demana a l'usuari les dades d'un àudio i
     * delega al Controlador l'implementació.
     */
    private void afegirVideo() {
        
        System.out.print("Camí: ");
        String path = sc.nextLine();
        
        System.out.print("Descripció: ");
        String descripcio = sc.nextLine();
        
        System.out.print("Codec: ");
        String codec = sc.nextLine();
        //No els demanem perquè encara no reprouïm els fitxers.
        String nomVideo = "";
        float durada = 0.0f;
        int alcada = 0;
        int amplada = 0;
        float fps = 0.0f;
        
        try {
            controlador.afegirVideo(path, nomVideo, descripcio, codec, durada, alcada, amplada, fps);
        } 
        
        catch (AplicacioException excepcio) {
            System.out.println(excepcio.getMessage());
        }
        
    }

    /**
     * Demana a l'usuari les dades d'un fitxer i
     * delega al Controlador l'implementació.
     */
    private void eliminarFitxerMultimedia() {

        System.out.print("Índex: ");
        
        try {
            controlador.esborrarFitxer(sc.nextInt() -1);
        } 
        
        catch (AplicacioException excepcio) {
            System.out.println(excepcio.getMessage());
        }
        
    }

    /**
     * Mostra tots els elements de la biblioteca de fitxers.
     */
    private void mostrarBiblioteca() {
        Iterator iterator = controlador.mostrarBiblioteca().iterator();
        int posicio = 1;
        
        while (iterator.hasNext()) {
            System.out.println(posicio+ " " + iterator.next());
            posicio++;
        }
        
    }

    /**
     * Demana a l'usuari l'ubicació del fitxer on vol guardar
     * les dades i delega al Controlador l'implementació.
     */
    private void guardarDades() {
        
        System.out.print("Camí: ");
        
        try {
            controlador.guardarDadesDisc(sc.nextLine());
        } 
        
        catch (AplicacioException excepcio) {
            System.out.println(excepcio.getMessage());
        }
        
    }
    
    /**
     * Demana a l'usuari l'ubicació del fitxer d'on vol agafar
     * les dades i delega al Controlador l'implementació.
     */
    private void recuperarDades() {
        System.out.print("Camí: ");
        
        try {
            controlador.carregarDadesDisc(sc.nextLine());
        } 
        
        catch (AplicacioException excepcio) {
            System.out.println(excepcio.getMessage());
        }
        
    }
    
    //Gestión álbumes.
    
    private void afegirAlbum() throws AplicacioException {
        System.out.println("Introdeix un titol per l'album.");
        String opc = sc.nextLine();
        controlador.afegirAlbum(opc);
    }
    
    private void mostrarAlbums() {
        System.out.println(controlador.mostrarLlistatAlbums());
    }
    
    private void eliminarAlbums() throws AplicacioException {
        mostrarAlbums();
        System.out.println("Introduzca el titol de l'album a esborrar: ");
        String opc = sc.nextLine();
        controlador.esborrarAlbum(opc);
    }
    
    
    //Gestionar álbum.
    
    private void afegirFitxerAlbum() throws AplicacioException {
        mostrarAlbums();
        System.out.println("Introdueix el títol de l'album: ");
        String opc = sc.nextLine();
        mostrarBiblioteca();
        System.out.println("Introdueix el índex del fitxer a afegir.");
        int id = sc.nextInt() - 1;
        controlador.afegirFitxer(opc, id);
    }
    
    private void mostrarAlbum() throws AplicacioException {
        mostrarAlbums();
        System.out.println("Introdueix el nom de l'àlbum a imprimir: ");
        String opc = sc.nextLine();
        System.out.println(controlador.mostrarAlbum(opc));
    }
    
    private void eliminarFitxerAlbum() throws AplicacioException {
        mostrarAlbums();
        System.out.println("Introdueix el nom de l'àlbum: ");
        String opc = sc.nextLine();
        mostrarAlbum(opc);
        System.out.println("Introdueix l'index del fitxer a esborrar: ");
        int id = sc.nextInt() - 1;
        controlador.esborrarFitxer(opc, id);
    }
    
        private void mostrarAlbum(String opc) throws AplicacioException {
        System.out.println(controlador.mostrarAlbum(opc));
    }
    
    
    //Control reproducción.
    
    private void reproduirFitxer() throws AplicacioException {
        mostrarBiblioteca();
        System.out.println("Introdueix l'índex del fitxer a reproduir:");
        try{
        int opc = sc.nextInt() -1;
        controlador.reproduirFitxer(opc);
        }catch (AplicacioException excepcio) {
        }
    }
    
    private void reproduirBiblioteca() throws AplicacioException {
        try{
        controlador.reproduirCarpeta();
        }catch (AplicacioException excepcio) {
        }
    }
    
    private void reproduirAlbum() throws AplicacioException {
        mostrarAlbums();
        System.out.println("Introdueix el nom de l'àlbum: ");
        String opc = sc.nextLine();
        try{
        controlador.reproduirCarpeta(opc);
        } catch (AplicacioException excepcio) {
        }
    }
    
    private void toggleLoop() {
        controlador.toggleLoop();
    }
    
    private void toggleRandom() {
        controlador.toggleRandom();
    }
    
    //Control reproducción en curso.
    
    private void continuar() {
        try{
            this.controlador.reemprenReproduccio();
        } catch (AplicacioException excepcio) {
            System.out.println(excepcio.getMessage());
        }   
    }
    
    private void pausar() {
        try{
            this.controlador.pausaReproduccio();
        } catch (AplicacioException excepcio) {
            System.out.println(excepcio.getMessage());
        }   
    }
    
    private void parar() {
        try{
        this.controlador.aturaReproduccio();
        }  catch (AplicacioException excepcio) {
            System.out.println(excepcio.getMessage());
        }   
    }
    
    private void saltar() {
        try{
        this.controlador.saltaReproduccio();
        } catch (AplicacioException excepcio) {
            System.out.println(excepcio.getMessage());
        }
    }
    
}