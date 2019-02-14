/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmafinity;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.io.Serializable;

/**
 *
 * @author Daniel Alejando y Miguel
 */

    
    
    
    
public class Peliculas implements Serializable {    
    private  ArrayList<Pelicula> peliculas;
    public Peliculas (){
        peliculas = new ArrayList<Pelicula>();
    }
    
    public boolean añadirPeliculas(Pelicula P){
        boolean agregar= false;
       if(!peliculas.contains(P)){//si la pelicula no está en array de peliculas del sistema se añada 
           peliculas.add(P);
           agregar = true;
       }
       else{
           System.out.println("La pelicula que quieres añadir ya existe");
       }
       return agregar;//si está devuelve false si no esta y se añadió devuelve true
   }
    
 
    
    public boolean buscarPelicula(Pelicula P){//busca una pelicula P en al array de peliculas si esta esta devuelve false
        boolean agregar=true;
       String tituloP= P.getTitulo();
        for (Pelicula pelicula : peliculas) {
            String titulo2=pelicula.getTitulo();
            if(tituloP.equals(titulo2)){
                agregar=false;
            }
            
        }
  return agregar;
}  
       public void imprimirPeliculas() 
    {   
         System.out.println("****LISTA DE PELICULAS****");
         for(Pelicula pelicula : peliculas) {//imprime por pantalla las peliculas del sistema 1 a 1 con un for
            String nombrePelicula = pelicula.getTitulo();
            System.out.println("-"+nombrePelicula);
               
               }
    } 
   public void ver_info_pelicula(Pelicula P){//imprime la info de la peli con el toString de la clase pelicula
      System.out.println(P);
            
    }
   public Pelicula anyPelicula(){//coge una pelicula random dentro del array de peliculas 
       try {
        return peliculas.get((new Random()).nextInt(peliculas.size()));
    }
    catch (Throwable e){
        return null;
    }
}
   public Pelicula buscarPeli(Pelicula P){//busca una pelicula P en al array de peliculas si está devuelve la pelicula
        Pelicula agregar=null;
       String tituloP= P.getTitulo();
        //for(int i=0; i<peliculas.length; i++) {
        for (Pelicula pelicula : peliculas) {
            String titulo2=pelicula.getTitulo();
            if(tituloP.equals(titulo2)){
                agregar=pelicula;
            }
            
        }
  return agregar;
}  
   }
   
    
    
    
    
    
    
    


