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
 * @author Daniel Alejandro Miguel
 */
public class Pelicula implements Serializable  {
    private String titulo;
    private int año;
    private String director;
    private String genero;
    private String actor;
    private String actriz;
    private ArrayList<Critica> criticas;
    
    
  
     public Pelicula(String titulo, int año, String director, String genero, String actor, String actriz){
         this.titulo = titulo;
        this.año = año;
        this.director = director;
        this.genero = genero;   
        this.actor = actor;    
        this.actriz = actriz;
          this.criticas = new ArrayList<>();
     }
     
      public Pelicula(String titulo){
         this.titulo = titulo;
        this.año = año;
        this.director = director;
        this.genero = genero;   
        this.actor = actor;    
        this.actriz = actriz;
          this.criticas = new ArrayList<>();
     }
    
    public boolean añadirCritica(Critica c){
        boolean bienCreado=false;
        if(this.criticas.add(c));{
            bienCreado=true;
    }   
      
           return bienCreado; 
    }

    
    
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public int getAño(){
        return año;
    }
    
    public void setAño(int año){
        if (año >=0)
            this.año = año;
        
    }
    
    public String getDirector(){
        return director;
    }
    
    public void setDirector(String director){
        this.director = director;
    }
    
    
    public String getGenero(){
        return genero;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public String getActor(){
        return actor;
    }
    
    public void setActor(String actor){
        this.actor= actor;
    }
    
    public String getActriz(){
        return actriz;
    }
    
    public void setActriz(String actriz){
        this.actriz = actriz;
    }

  @Override
    public String toString (){//metodo toString para imprimir la info de la peli para diferentes casos
        return "\nPELICULA"
                + "\nTitulo:"+getTitulo()+" Año:"+getAño()+" Director:"+getDirector()+" Genero:"+getGenero()+" Actriz Protagonista:"+getActriz()+ " Actor protagonista:"+getActor();
    }
         
        
    }

    
     
    

