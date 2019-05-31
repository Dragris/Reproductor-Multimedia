/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.MeyerTatianaBarraganAlberto.controlador;

import edu.ub.prog2.MeyerTatianaBarraganAlberto.model.CarpetaFitxers;
import edu.ub.prog2.MeyerTatianaBarraganAlberto.model.FitxerReproduible;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.EscoltadorReproduccioBasic;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Tatiana
 * @editor Dragris Bernhard
 */
public class EscoltadorReproduccio extends EscoltadorReproduccioBasic{
    
    private CarpetaFitxers llistaReproduint;
    private List<Integer> llistaCtrl;
    private boolean reproduccioCiclica, reproduccioAleatoria;
    private int pos, size;
    private boolean reproduciendo;

    public EscoltadorReproduccio(){
        reproduccioCiclica = false;
        reproduccioAleatoria = false;
        size = 0;
    }
    
    public boolean isReproduciendo(){
        return reproduciendo;
    }
    public void setReproduciendo(boolean bool){
        this.reproduciendo = bool;
    }
    public void setLoop(boolean loop){
        this.reproduccioCiclica = loop;
    }
    public void setRand(boolean rand){
        this.reproduccioAleatoria = rand;
    }
    /**
     * Retorna si hi ha un altre fitxer per reproduir
     * @return true/false depenent si hi ha un altre fitxer per reproduir
     */
    @Override
    protected boolean hasNext() {
        return pos + 1 <= llistaCtrl.size() || (reproduccioCiclica && !llistaCtrl.isEmpty());
    }
    
    /**
     * Intenta reproducir el siguiente fichero si es posible, si no finaliza la reproducción.
     */
    @Override
    protected void next() {
        pos = (pos + 1) % llistaCtrl.size(); //Pasa a módulo de ficheros reproducibles en caso de loop = true para volver a inicar la lista
        if (reproduccioAleatoria && pos == 0){
            Collections.shuffle(llistaCtrl);
        }
        if(hasNext()){
            File f = llistaReproduint.getAt(llistaCtrl.get(pos));
            if(f instanceof FitxerReproduible){
                FitxerReproduible fr= (FitxerReproduible)f;
                try {
                    fr.reproduir();
                    reproduciendo = true;
                } catch (AplicacioException ex) {
                    //Elimina de la lista de control los archivos no reproducibles
                    //Y evita loop de cíclica si no funciona ningún archivo
                    llistaCtrl.remove(pos);
                    pos--;
                    next();
                }
        }else {
                reproduciendo = false;
            }
        }
    }
    /**
     * Es llamado cuando acaba la reproducción e intenta llamar al siguiente fichero.
     */
    @Override
    protected void onEndFile() {
        this.next();
    }

    /**
     * Inicia la reproducción
     * @param LlistaReproduint
     * @param ReproduccioCiclica
     * @param ReproduccioAleatoria
     * @throws AplicacioException 
     */
    public void iniciarReproduccio(CarpetaFitxers LlistaReproduint, boolean ReproduccioCiclica, boolean ReproduccioAleatoria) throws AplicacioException{
        this.llistaReproduint = LlistaReproduint;
    if(llistaReproduint.getSize()==0){
        throw new AplicacioException("Biblioteca buida");
    }else{
        size=llistaReproduint.getSize();
        //Genera una lista de integers desde 0 hasta el tamaño de la carpeta -1 (para recorrer las posiciones en la propia carpeta)
        llistaCtrl = IntStream.range(0, LlistaReproduint.getSize()).boxed().collect(Collectors.toList());
        this.reproduccioCiclica = ReproduccioCiclica;
        this.reproduccioAleatoria = ReproduccioAleatoria;
        pos= -1;
        reproduciendo = true;
        next();
    }
    }
}
