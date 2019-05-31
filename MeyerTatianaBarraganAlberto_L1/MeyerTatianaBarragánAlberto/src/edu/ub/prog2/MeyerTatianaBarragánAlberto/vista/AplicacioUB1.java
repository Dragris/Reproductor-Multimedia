package edu.ub.prog2.MeyerTatianaBarragánAlberto.vista;
import edu.ub.prog2.MeyerTatianaBarragánAlberto.model.CarpetaFitxers;
import edu.ub.prog2.MeyerTatianaBarragánAlberto.model.FitxerMultimedia;
import java.util.*;
import edu.ub.prog2.utils.Menu;


public class AplicacioUB1{
    
    /**
     * Enumeración de las opciones del menú
     */
    static private enum OpcionsMenuPrincipal {MENU_PRINCIPAL_ADD_FILE,
                                              MENU_PRINCIPAL_SHOW_LIST,
                                              MENU_PRINCIPAL_DEL_FILE,
                                              MENU_PRINCIPAL_SORTIR};
    
    /**
     * Strings atados a las opciones que usamos para el menú, estas se muestran
     * por pantalla
     */
    static private String[] descMenuPrincipal = {"Afegir fitxer",
                                                  "Mostrar llista fitxers",
                                                  "Eliminar fitxers",
                                                  "Sortir"};
    private CarpetaFitxers carpetaFitxers;
    
    //Constructor   
    public AplicacioUB1(){
        carpetaFitxers = new CarpetaFitxers();
    }  
    
    void gestioAplicacioUB(){
        
        Scanner sc = new Scanner(System.in);
        
        Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu Principal", OpcionsMenuPrincipal.values());
        
        menu.setDescripcions(descMenuPrincipal);
        
        OpcionsMenuPrincipal opcio;
        
        do {
           menu.mostrarMenu();
           
           opcio = menu.getOpcio(sc);
           
           switch(opcio){
               case MENU_PRINCIPAL_ADD_FILE:
                   FitxerMultimedia newFitxerMultimedia = getFitxerMultimediaData(sc);
                   if (newFitxerMultimedia != null){
                       carpetaFitxers.addFitxer (newFitxerMultimedia);
                   } break;
                   
               case MENU_PRINCIPAL_SHOW_LIST:
                   System.out.println(carpetaFitxers);
                   break;
                
               case MENU_PRINCIPAL_DEL_FILE:
                   FitxerMultimedia delFitxerMultimedia = getFitxerMultimediaData(sc);
                   if (delFitxerMultimedia != null){
                       carpetaFitxers.removeFitxer(delFitxerMultimedia);
                   }
                   break;
           }
        }while (opcio != OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
    }
        
    /**
     * Método para generar un fichero multimedia pidiendo el path.
     * @param sc
     * @return 
     */    
    private FitxerMultimedia getFitxerMultimediaData(Scanner sc){
        FitxerMultimedia newFitxer = null;
        String filePath = getFileName(sc);
        if (filePath != null){
            newFitxer = new FitxerMultimedia (filePath);
        }
        return newFitxer;
    } 
    
    /**
     * Suponemos que el path contiene también el nombre del fichero para buscar
     * así coincidencias con otros métodos del programa.
     * @param sc
     * @return 
     */
    private String getFileName (Scanner sc){
        System.out.println("Entra el nom del fitxer.");
        String nom = sc.nextLine();
        return nom;
    }
}
