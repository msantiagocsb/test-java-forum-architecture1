/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmafinity;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author donat
 */
public class Critica implements Serializable {
    private String pelicula;
    private double puntuacion;
    private String texto;
    
    public Critica(String pelicula){
        this.pelicula = pelicula;
        this.puntuacion = puntuacion;
        this.texto = texto;
    }
    public Critica(String pelicula,double puntuacion, String texto){
        this.pelicula = pelicula;
        this.puntuacion = puntuacion;
        this.texto = texto;
    }
     
    public String getPelicula(){
        return pelicula;
    }
    
    public double getPuntuacion(){
        return puntuacion;
    }
    
    public String getTexto(){
        return texto;
    }
    
    public void setPelicula(String pelicula){
        this.pelicula = pelicula;
    }
    
    public void setPuntuacion(double puntuacion){
        if(puntuacion >= 0)
        this.puntuacion = puntuacion;
    }
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    
     @Override
    public String toString (){
        return "\nCRITICA"
                + "\nPelicula referenciada:"+getPelicula()+" Puntuacion:"+getPuntuacion()+" Crítica:"+getTexto();
    }
}
