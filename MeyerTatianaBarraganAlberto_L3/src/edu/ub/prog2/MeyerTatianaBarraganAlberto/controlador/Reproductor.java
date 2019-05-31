package edu.ub.prog2.MeyerTatianaBarraganAlberto.controlador;
import edu.ub.prog2.MeyerTatianaBarraganAlberto.model.Audio;
import edu.ub.prog2.MeyerTatianaBarraganAlberto.model.FitxerReproduible;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.EscoltadorReproduccioBasic;
import edu.ub.prog2.utils.ReproductorBasic;
import java.io.File;
import java.io.Serializable;
/**
 * En un futur reproduirà els arxius.
 * 
 * @author Alberto Barragán
 * @author Tatiana Meyer
 */
public class Reproductor extends ReproductorBasic implements Serializable{

    public Reproductor(EscoltadorReproduccioBasic controlador) {
        super(controlador);
    }

    public Reproductor(String vlcPath, EscoltadorReproduccioBasic controlador) {
        super("\"C:\\Program Files\\VideoLAN\\VLC\"", controlador);
    }

    public Reproductor(String vlcPath, int verbose, EscoltadorReproduccioBasic controlador) {
        super(vlcPath, verbose, controlador);
    }
    
    void reprodueix (FitxerReproduible fr) throws AplicacioException{
        super.play(fr);
    }
    
    void reprodueix(Audio audio, File fitxerImatge) throws AplicacioException{
        super.play(audio, fitxerImatge);
    }

}
