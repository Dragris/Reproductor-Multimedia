package edu.ub.prog2.MeyerTatianaBarragánAlberto.model;
import java.io.File;
import java.util.Date;
import java.util.*;

public class FitxerMultimedia extends File{
    
    private String name, ext, desc, cami;
    private Date data;

    public FitxerMultimedia(String nom) {
        super(nom);
        this.cami = this.getCamiAbsolut();
        this.name= nom;
        this.ext = "Default";
        this.desc="Default";
    }

    // GETTERS
    public Date getUltimaModificacio(){
        return this.data;
    }
    
    public String getCamiAbsolut(){
        return this.getAbsolutePath();
    }
    
    public String getNomFitxer(){
        return this.name;
    }
    
    public String getExtensio(){
        return this.ext;
    }
    
    public String getDescripció(){
        return this.desc;
    }
    
    // SETTERS
    public void setUltimaModificacio(Date data){
        this.data = data;
    }
    
    public void setCamiAbsolut(String cami){
        this.cami = cami;
    }
    
    public void setNomFitxer(String nom){
        this.name = nom;
    }
    
    public void setExtensio(String extensio){
        this.ext = extensio;
    }
    
    public void setDescripció(String desc){
        this.desc = desc;
    }
    
    // DEMANA DADES DEL FITXER
    public void setInfo(){
        Scanner scan = new Scanner(System.in);
        Date now = new Date();
        System.out.println("Digues el nom del fitxer");
        this.setNomFitxer(scan.nextLine());
        System.out.println("Digues la ruta del fitxer");
        this.setCamiAbsolut(scan.nextLine());
        System.out.println("Digues la descripcio del fitxer");
        this.setDescripció(scan.nextLine());
        System.out.println("Digues la extensio del fitxer");
        this.setExtensio(scan.nextLine());
        //System.out.println("Digues la data del fitxer"); 
        this.setUltimaModificacio(now);
    }
    
    
    // OVERRIDES
    @Override
    public boolean equals(Object FitxerMultimedia){
        return super.equals(FitxerMultimedia); //super.equals o this.equals(?)
    }
    
    @Override
    public String toString(){
        String all;
        all="Nom= "+this.getNomFitxer()+", descripció= "+this.getDescripció()+", data= "+this.getUltimaModificacio()+", ext= "
            +this.getExtensio()+", cami complet= "+this.getAbsolutePath();
        return all;
    }

}
