/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmafinity;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.Serializable;
/**
 *
 * @author Dani, Miguel y Alejandro
 */
public class Pregunta implements Serializable  {
    private int id;
    private Pelicula pelicula;
    private int ptos_jugador1;
    private int ptos_jugador2;
   
    public Pregunta(int id, Pelicula pelicula, int ptos_jugador1, int ptos_jugador2){
        this.id = id;
        this.pelicula = pelicula;
        this.ptos_jugador1 = ptos_jugador1;
        this.ptos_jugador2 = ptos_jugador2;
    }
     public Pregunta(int id, Pelicula pelicula){
        this.id = id;
        this.pelicula = pelicula;
        this.ptos_jugador1 = 0;
        this.ptos_jugador2 = 0;
    }
    public int getPts_jugador2(){
        return ptos_jugador2;
    }
    public int getPts_jugador1(){
        return ptos_jugador1;
    }
     public void setPts_jugador1(int pts_jugador1){
        if(ptos_jugador1 >= 0)
            this.ptos_jugador1 = pts_jugador1;
    }
       public void setPts_jugador2(int pts_jugador1){
        if(ptos_jugador2 >= 0)
            this.ptos_jugador2 = pts_jugador1;
    }
    public void segundaPregunta(){//segunda pregunta de jugador1
   
     Scanner entrada = new Scanner (System.in);
    System.out.println("La pelicula que se busca tiene como título: "+this.pelicula.getTitulo());
    int respuestaint=0;
    int falloAño=0;
     do{System.out.println("¿Cuál es su año de distribucion?");
    String respuesta = entrada.nextLine();
    
    try { respuestaint = Integer.parseInt(respuesta);
                     falloAño=1;}
             catch (NumberFormatException e){
               System.out.println("El año debe ser un valor numerico y estar comprendido entre 1895-2022");
                
             }}while(falloAño==0);
     
      if(respuestaint == this.pelicula.getAño()){
           ptos_jugador1 += 50;
         System.out.println("Enhorabunea +50 puntos.");
      }else{
          
            System.out.println(respuestaint+", no es correcto");
            System.out.println("Pista 1, su género es: "+this.pelicula.getGenero());
           do{System.out.println("¿Cuál es su año de distribucion?");
                String respuesta1 = entrada.nextLine();
    
                    try { respuestaint = Integer.parseInt(respuesta1);
                             falloAño=1;}
                     catch (NumberFormatException e){
                         System.out.println("El año debe ser un valor numerico y estar comprendido entre 1895-2022");
                
                     }}while(falloAño==0);
         if(respuestaint == this.pelicula.getAño()){
             ptos_jugador1 += 40;
            System.out.println("+40 puntos.");
         }else{
             
                System.out.println(respuestaint+", no es correcto");
              System.out.println("Pista 2, su director es: "+this.pelicula.getDirector());
                do{System.out.println("¿Cuál es su año de distribucion?");
                String respuesta2 = entrada.nextLine();
    
                    try { respuestaint = Integer.parseInt(respuesta2);
                             falloAño=1;}
                     catch (NumberFormatException e){
                         System.out.println("El año debe ser un valor numerico y estar comprendido entre 1895-2022");
                
                     }}while(falloAño==0);
              if(respuestaint == this.pelicula.getAño() ){
                  ptos_jugador1 += 30;
                  System.out.println("+30 puntos.");
              }else{
                  
                    System.out.println(respuestaint+", no es correcto");
                  System.out.println("Pista 3, su actor protagonista es: "+this.pelicula.getActor());
                   do{System.out.println("¿Cuál es su año de distribucion?");
                String respuesta3 = entrada.nextLine();
    
                    try { respuestaint = Integer.parseInt(respuesta3);
                             falloAño=1;}
                     catch (NumberFormatException e){
                         System.out.println("El año debe ser un valor numerico y estar comprendido entre 1895-2022");
                
                     }}while(falloAño==0);
              if(respuestaint == this.pelicula.getAño() ){
                  ptos_jugador1 += 20;
                  System.out.println("+20 puntos.");
              }else{
                   
                  System.out.println(respuestaint+", no es correcto");
                  System.out.println("Pista 4, su actriz protagonista es: "+this.pelicula.getActriz());
                   do{System.out.println("¿Cuál es su año de distribucion?");
                String respuesta4 = entrada.nextLine();
    
                    try { respuestaint = Integer.parseInt(respuesta4);
                             falloAño=1;}
                     catch (NumberFormatException e){
                         System.out.println("El año debe ser un valor numerico y estar comprendido entre 1895-2022");
                
                     }}while(falloAño==0);
             
              if(respuestaint == this.pelicula.getAño() ){
                  ptos_jugador1 += 10;
                  System.out.println("+10 puntos.");
              }else{
                   System.out.println(respuestaint+", no es correcto");
                  System.out.println("La respuesta correcta era: "+this.pelicula.getAño());
                    }
              }
              }
         }
      }
    }
     public void primeraPregunta(){//primera pregunta de jugador1
    
     Scanner entrada = new Scanner (System.in);
    System.out.println("El año de distribucion de la pelicula es: "+this.pelicula.getAño());
     System.out.println("¿Cuál es el título de la película?");
    String respuesta = entrada.nextLine();
     
      if(respuesta.equals(this.pelicula.getTitulo())){
           ptos_jugador1 += 50;
         System.out.println("Enhorabunea +50 puntos.");
      }else{
          
           System.out.println(respuesta+", no es correcto");
         System.out.println("Pista 1, su género es: "+this.pelicula.getGenero());
         System.out.println("¿Cuál es el título de la película?");
         String respuesta1 = entrada.nextLine();
        
         if(respuesta1.equals(this.pelicula.getTitulo())){
             ptos_jugador1 += 40;
         System.out.println("+40 puntos.");
         }else{
             
                System.out.println(respuesta1+", no es correcto");
              System.out.println("Pista 2, su director es: "+this.pelicula.getDirector());
              System.out.println("¿Cuál es el título de la película?");
              String respuesta2 = entrada.nextLine();
             
              if(respuesta2.equals(this.pelicula.getTitulo())){
                  ptos_jugador1 += 30;
                  System.out.println("+30 puntos.");
              }else{
                  
                    System.out.println(respuesta2+", no es correcto");
                  System.out.println("Pista 3, su actor protagonista es: "+this.pelicula.getActor());
                 System.out.println("¿Cuál es el título de la película?");
              String respuesta3 = entrada.nextLine();
             
              if(respuesta3.equals(this.pelicula.getTitulo())){
                  ptos_jugador1 += 20;
                  System.out.println("+20 puntos.");
              }else{
                   
                  System.out.println(respuesta3+", no es correcto");
                  System.out.println("Pista 4, su actriz protagonista es: "+this.pelicula.getActriz());
                  System.out.println("¿Cuál es el título de la película?");
              String respuesta4 = entrada.nextLine();
              
             if(respuesta4.equals(this.pelicula.getTitulo())){
                  ptos_jugador1 += 10;
                  System.out.println("+10 puntos.");
              }else{
                   System.out.println(respuesta4+", no es correcto");
                  System.out.println("La respuesta correcta era: "+this.pelicula.getTitulo());
                    }
              }
              }
         }
      }
    }
      public void terceraPregunta(){//tercera pregunta de jugador1
    
     Scanner entrada = new Scanner (System.in);
    System.out.println("El año de distribucion de la pelicula es: "+this.pelicula.getAño());
     System.out.println("¿Cuál es el género de la película?");
    String respuesta = entrada.nextLine();
     
      if(respuesta.equals(this.pelicula.getGenero())){
           ptos_jugador1 += 50;
         System.out.println("Enhorabunea +50 puntos.");
      }else{
          
           System.out.println(respuesta+", no es correcto");
         System.out.println("Pista 2, su director es: "+this.pelicula.getDirector());
                System.out.println("¿Cuál es el género de la película?");
              String respuesta1 = entrada.nextLine();
        
          if(respuesta1.equals(this.pelicula.getGenero())){
             ptos_jugador1 += 40;
         System.out.println("+40 puntos.");
         }else{
             
                System.out.println(respuesta1+", no es correcto");
              System.out.println("Pista 2, su título es: "+this.pelicula.getTitulo());
                System.out.println("¿Cuál es el género de la película?");
              String respuesta2 = entrada.nextLine();
             
              if(respuesta2.equals(this.pelicula.getGenero())){
                  ptos_jugador1 += 30;
                  System.out.println("+30 puntos.");
              }else{
                  
                    System.out.println(respuesta2+", no es correcto");
                  System.out.println("Pista 3, su actor protagonista es: "+this.pelicula.getActor());
                   System.out.println("¿Cuál es el género de la película?");
              String respuesta3 = entrada.nextLine();
             
               if(respuesta3.equals(this.pelicula.getGenero())){
                  ptos_jugador1 += 20;
                  System.out.println("+20 puntos.");
              }else{
                   
                  System.out.println(respuesta3+", no es correcto");
                  System.out.println("Pista 4, su actriz protagonista es: "+this.pelicula.getActriz());
                     System.out.println("¿Cuál es el género de la película?");
              String respuesta4 = entrada.nextLine();
              
               if(respuesta4.equals(this.pelicula.getGenero())){
                  ptos_jugador1 += 10;
                  System.out.println("+10 puntos.");
              }else{
                   System.out.println(respuesta4+", no es correcto");
                  System.out.println("La respuesta correcta era: "+this.pelicula.getGenero());
                    }
              }
              }
         }
      }
    }
       public void cuartaPregunta(){//cuarta pregunta de jugador1
    
     Scanner entrada = new Scanner (System.in);
    System.out.println("El título de la pelicula es: "+this.pelicula.getTitulo());
     System.out.println("¿Cuál es el director de la película?");
    String respuesta = entrada.nextLine();
     
      if(respuesta.equals(this.pelicula.getDirector())){
           ptos_jugador1 += 50;
         System.out.println("Enhorabunea +50 puntos.");
      }else{
          
           System.out.println(respuesta+", no es correcto");
         System.out.println("Pista 2, su año de distribucion es: "+this.pelicula.getAño());
                System.out.println("¿Cuál es el director de la película?");
              String respuesta1 = entrada.nextLine();
        
        if(respuesta1.equals(this.pelicula.getDirector())){
             ptos_jugador1 += 40;
         System.out.println("+40 puntos.");
         }else{
             
                System.out.println(respuesta1+", no es correcto");
              System.out.println("Pista 2, su genero es: "+this.pelicula.getGenero());
                 System.out.println("¿Cuál es el director de la película?");
              String respuesta2 = entrada.nextLine();
             
             if(respuesta2.equals(this.pelicula.getDirector())){
                  ptos_jugador1 += 30;
                  System.out.println("+30 puntos.");
              }else{
                  
                    System.out.println(respuesta2+", no es correcto");
                  System.out.println("Pista 3, su actor protagonista es: "+this.pelicula.getActor());
                    System.out.println("¿Cuál es el director de la película?");
              String respuesta3 = entrada.nextLine();
             
              if(respuesta3.equals(this.pelicula.getDirector())){
                  ptos_jugador1 += 20;
                  System.out.println("+20 puntos.");
              }else{
                   
                  System.out.println(respuesta3+", no es correcto");
                  System.out.println("Pista 4, su actriz protagonista es: "+this.pelicula.getActriz());
                     System.out.println("¿Cuál es el director de la película?");
              String respuesta4 = entrada.nextLine();
              
              if(respuesta4.equals(this.pelicula.getDirector())){
                  ptos_jugador1 += 10;
                  System.out.println("+10 puntos.");
              }else{
                   System.out.println(respuesta4+", no es correcto");
                  System.out.println("La respuesta correcta era: "+this.pelicula.getDirector());
                    }
              }
              }
         }
      }
    }
        public void quintaPregunta(){//quinta pregunta de jugador1
    
     Scanner entrada = new Scanner (System.in);
    System.out.println("El título de la pelicula es: "+this.pelicula.getTitulo());
     System.out.println("¿Cuál es el actor protagonista de la película?");
    String respuesta = entrada.nextLine();
     
      if(respuesta.equals(this.pelicula.getActor())){
           ptos_jugador1 += 50;
         System.out.println("Enhorabunea +50 puntos.");
      }else{
          
           System.out.println(respuesta+", no es correcto");
         System.out.println("Pista 2, su año de distribucion es: "+this.pelicula.getAño());
               System.out.println("¿Cuál es el actor protagonista de la película?");
              String respuesta1 = entrada.nextLine();
        
         if(respuesta1.equals(this.pelicula.getActor())){
             ptos_jugador1 += 40;
         System.out.println("+40 puntos.");
         }else{
             
                System.out.println(respuesta1+", no es correcto");
              System.out.println("Pista 2, su genero es: "+this.pelicula.getGenero());
                System.out.println("¿Cuál es el actor protagonista de la película?");
              String respuesta2 = entrada.nextLine();
             
              if(respuesta2.equals(this.pelicula.getActor())){
                  ptos_jugador1 += 30;
                  System.out.println("+30 puntos.");
              }else{
                  
                    System.out.println(respuesta2+", no es correcto");
                  System.out.println("Pista 3, su director es: "+this.pelicula.getDirector());
                    System.out.println("¿Cuál es el actor protagonista de la película?");
              String respuesta3 = entrada.nextLine();
             
             if(respuesta3.equals(this.pelicula.getActor())){
                  ptos_jugador1 += 20;
                  System.out.println("+20 puntos.");
              }else{
                   
                  System.out.println(respuesta3+", no es correcto");
                  System.out.println("Pista 4, su actriz protagonista es: "+this.pelicula.getActriz());
                    System.out.println("¿Cuál es el actor protagonista de la película?");
              String respuesta4 = entrada.nextLine();
              
              if(respuesta4.equals(this.pelicula.getActor())){
                  ptos_jugador1 += 10;
                  System.out.println("+10 puntos.");
              }else{
                   System.out.println(respuesta4+", no es correcto");
                  System.out.println("La respuesta correcta era: "+this.pelicula.getActor());
                    }
              }
              }
         }
      }
    }
        public void sextaPregunta(){//sexta pregunta de jugador1
   
     Scanner entrada = new Scanner (System.in);
    System.out.println("El título de la pelicula es: "+this.pelicula.getTitulo());
     System.out.println("¿Cuál es la actriz protagonista de la película?");
    String respuesta = entrada.nextLine();
     
      if(respuesta.equals(this.pelicula.getActriz())){
           ptos_jugador1 += 50;
         System.out.println("Enhorabunea +50 puntos.");
      }else{
          
           System.out.println(respuesta+", no es correcto");
         System.out.println("Pista 2, su año de distribucion es: "+this.pelicula.getAño());
               System.out.println("¿Cuál es la actriz protagonista de la película?");
              String respuesta1 = entrada.nextLine();
        
         if(respuesta1.equals(this.pelicula.getActriz())){
             ptos_jugador1 += 40;
         System.out.println("+40 puntos.");
         }else{
             
                System.out.println(respuesta1+", no es correcto");
              System.out.println("Pista 2, su genero es: "+this.pelicula.getGenero());
                 System.out.println("¿Cuál es la actriz protagonista de la película?");
              String respuesta2 = entrada.nextLine();
             
             if(respuesta2.equals(this.pelicula.getActriz())){
                  ptos_jugador1 += 30;
                  System.out.println("+30 puntos.");
              }else{
                  
                    System.out.println(respuesta2+", no es correcto");
                  System.out.println("Pista 3, su director es: "+this.pelicula.getDirector());
                     System.out.println("¿Cuál es la actriz protagonista de la película?");
              String respuesta3 = entrada.nextLine();
             
              if(respuesta3.equals(this.pelicula.getActriz())){
                  ptos_jugador1 += 20;
                  System.out.println("+20 puntos.");
              }else{
                   
                  System.out.println(respuesta3+", no es correcto");
                  System.out.println("Pista 4, su actor protagonista es: "+this.pelicula.getActor());
                    System.out.println("¿Cuál es la actriz protagonista de la película?");
              String respuesta4 = entrada.nextLine();
              
              if(respuesta4.equals(this.pelicula.getActriz())){
                  ptos_jugador1 += 10;
                  System.out.println("+10 puntos.");
              }else{
                   System.out.println(respuesta4+", no es correcto");
                  System.out.println("La respuesta correcta era: "+this.pelicula.getActriz());
                    }
              }
              }
         }
      }
    }
      public void primeraPreguntaj2(){//primera pregunta de jugador2
   
     Scanner entrada = new Scanner (System.in);
    System.out.println("El año de distribucion de la pelicula es: "+this.pelicula.getAño());
     System.out.println("¿Cuál es el título de la película?");
    String respuesta = entrada.nextLine();
     
      if(respuesta.equals(this.pelicula.getTitulo())){
           ptos_jugador2 += 50;
         System.out.println("Enhorabunea +50 puntos.");
      }else{
          
           System.out.println(respuesta+", no es correcto");
         System.out.println("Pista 1, su género es: "+this.pelicula.getGenero());
         System.out.println("¿Cuál es el título de la película?");
         String respuesta1 = entrada.nextLine();
        
          if(respuesta1.equals(this.pelicula.getTitulo())){
             ptos_jugador2 += 40;
         System.out.println("+40 puntos.");
         }else{
             
                System.out.println(respuesta1+", no es correcto");
              System.out.println("Pista 2, su director es: "+this.pelicula.getDirector());
              System.out.println("¿Cuál es el título de la película?");
              String respuesta2 = entrada.nextLine();
             
               if(respuesta2.equals(this.pelicula.getTitulo())){
                  ptos_jugador2 += 30;
                  System.out.println("+30 puntos.");
              }else{
                  
                    System.out.println(respuesta2+", no es correcto");
                  System.out.println("Pista 3, su actor protagonista es: "+this.pelicula.getActor());
                 System.out.println("¿Cuál es el título de la película?");
              String respuesta3 = entrada.nextLine();
             
               if(respuesta3.equals(this.pelicula.getTitulo())){
                  ptos_jugador2 += 20;
                  System.out.println("+20 puntos.");
              }else{
                   
                  System.out.println(respuesta3+", no es correcto");
                  System.out.println("Pista 4, su actriz protagonista es: "+this.pelicula.getActriz());
                  System.out.println("¿Cuál es el título de la película?");
              String respuesta4 = entrada.nextLine();
              
               if(respuesta4.equals(this.pelicula.getTitulo())){
                  ptos_jugador2 += 10;
                  System.out.println("+10 puntos.");
              }else{
                   System.out.println(respuesta4+", no es correcto");
                  System.out.println("La respuesta correcta era: "+this.pelicula.getTitulo());
                    }
              }
              }
         }
      }
    }
    public void segundaPreguntaj2(){//segunda pregunta de jugador2
      
     Scanner entrada = new Scanner (System.in);
    System.out.println("La pelicula que se busca tiene título: "+this.pelicula.getTitulo());
     int respuestaint=0;
    int falloAño=0;
     do{System.out.println("¿Cuál es su año de distribucion?");
                String respuesta = entrada.nextLine();
    
                    try { respuestaint = Integer.parseInt(respuesta);
                             falloAño=1;}
                     catch (NumberFormatException e){
                         System.out.println("El año debe ser un valor numerico y estar comprendido entre 1895-2022");
                
                     }}while(falloAño==0);
     
      if(respuestaint == this.pelicula.getAño()){
           ptos_jugador2 += 50;
         System.out.println("Enhorabunea +50 puntos.");
      }else{
          
           System.out.println(respuestaint+", no es correcto");
         System.out.println("Pista 1, su género es: "+this.pelicula.getGenero());
          do{System.out.println("¿Cuál es su año de distribucion?");
                String respuesta1 = entrada.nextLine();
    
                    try { respuestaint = Integer.parseInt(respuesta1);
                             falloAño=1;}
                     catch (NumberFormatException e){
                         System.out.println("El año debe ser un valor numerico y estar comprendido entre 1895-2022");
                
                     }}while(falloAño==0);
         
         if(respuestaint == this.pelicula.getAño()){
             ptos_jugador2 += 40;
         System.out.println("+40 puntos.");
         }else{
             
                System.out.println(respuestaint+", no es correcto");
              System.out.println("Pista 2, su director es: "+this.pelicula.getDirector());
              do{System.out.println("¿Cuál es su año de distribucion?");
                String respuesta2 = entrada.nextLine();
    
                    try { respuestaint = Integer.parseInt(respuesta2);
                             falloAño=1;}
                     catch (NumberFormatException e){
                         System.out.println("El año debe ser un valor numerico y estar comprendido entre 1895-2022");
                
                     }}while(falloAño==0);
            
              if(respuestaint == this.pelicula.getAño() ){
                  ptos_jugador2 += 30;
                  System.out.println("+30 puntos.");
              }else{
                  
                    System.out.println(respuestaint+", no es correcto");
                  System.out.println("Pista 3, su actor protagonista es: "+this.pelicula.getActor());
                  do{System.out.println("¿Cuál es su año de distribucion?");
                String respuesta4 = entrada.nextLine();
    
                    try { respuestaint = Integer.parseInt(respuesta4);
                             falloAño=1;}
                     catch (NumberFormatException e){
                         System.out.println("El año debe ser un valor numerico y estar comprendido entre 1895-2022");
                
                     }}while(falloAño==0);
              
              if(respuestaint == this.pelicula.getAño() ){
                  ptos_jugador2 += 20;
                  System.out.println("+20 puntos.");
              }else{
                   
                  System.out.println(respuestaint+", no es correcto");
                  System.out.println("Pista 4, su actriz protagonista es: "+this.pelicula.getActriz());
                  
             do{System.out.println("¿Cuál es su año de distribucion?");
                String respuesta5 = entrada.nextLine();
    
                    try { respuestaint = Integer.parseInt(respuesta5);
                             falloAño=1;}
                     catch (NumberFormatException e){
                         System.out.println("El año debe ser un valor numerico y estar comprendido entre 1895-2022");
                
                     }}while(falloAño==0);
              if(respuestaint == this.pelicula.getAño() ){
                  ptos_jugador2 += 10;
                  System.out.println("+10 puntos.");
              }else{
                   System.out.println(respuestaint+", no es correcto");
                  System.out.println("La respuesta correcta era: "+this.pelicula.getAño());
                    }
              }
              }
         }
      }
    }
    public void terceraPreguntaj2(){//tercera pregunta de jugador2
  
     Scanner entrada = new Scanner (System.in);
    System.out.println("El año de distribucion de la pelicula es: "+this.pelicula.getAño());
     System.out.println("¿Cuál es el género de la película?");
    String respuesta = entrada.nextLine();
     
      if(respuesta.equals(this.pelicula.getGenero())){
           ptos_jugador2 += 50;
         System.out.println("Enhorabunea +50 puntos.");
      }else{
          
           System.out.println(respuesta+", no es correcto");
         System.out.println("Pista 2, su director es: "+this.pelicula.getDirector());
                System.out.println("¿Cuál es el género de la película?");
              String respuesta1 = entrada.nextLine();
        
          if(respuesta1.equals(this.pelicula.getGenero())){
             ptos_jugador2 += 40;
         System.out.println("+40 puntos.");
         }else{
             
                System.out.println(respuesta1+", no es correcto");
              System.out.println("Pista 2, su título es: "+this.pelicula.getTitulo());
                System.out.println("¿Cuál es el género de la película?");
              String respuesta2 = entrada.nextLine();
             
               if(respuesta2.equals(this.pelicula.getGenero())){
                  ptos_jugador2 += 30;
                  System.out.println("+30 puntos.");
              }else{
                  
                    System.out.println(respuesta2+", no es correcto");
                  System.out.println("Pista 3, su actor protagonista es: "+this.pelicula.getActor());
                   System.out.println("¿Cuál es el género de la película?");
              String respuesta3 = entrada.nextLine();
             
               if(respuesta3.equals(this.pelicula.getGenero())){
                  ptos_jugador2 += 20;
                  System.out.println("+20 puntos.");
              }else{
                   
                  System.out.println(respuesta3+", no es correcto");
                  System.out.println("Pista 4, su actriz protagonista es: "+this.pelicula.getActriz());
                     System.out.println("¿Cuál es el género de la película?");
              String respuesta4 = entrada.nextLine();
              
               if(respuesta4.equals(this.pelicula.getGenero())){
                  ptos_jugador2 += 10;
                  System.out.println("+10 puntos.");
              }else{
                   System.out.println(respuesta4+", no es correcto");
                  System.out.println("La respuesta correcta era: "+this.pelicula.getGenero());
                    }
              }
              }
         }
      }
    }
     public void cuartaPreguntaj2(){//cuarta pregunta de jugador2
   
     Scanner entrada = new Scanner (System.in);
    System.out.println("El título de la pelicula es: "+this.pelicula.getTitulo());
     System.out.println("¿Cuál es el director de la película?");
    String respuesta = entrada.nextLine();
     
      if(respuesta.equals(this.pelicula.getDirector())){
           ptos_jugador2 += 50;
         System.out.println("Enhorabunea +50 puntos.");
      }else{
          
           System.out.println(respuesta+", no es correcto");
         System.out.println("Pista 2, su año de distribucion es: "+this.pelicula.getAño());
                System.out.println("¿Cuál es el director de la película?");
              String respuesta1 = entrada.nextLine();
        
          if(respuesta1.equals(this.pelicula.getDirector())){
             ptos_jugador2 += 40;
         System.out.println("+40 puntos.");
         }else{
             
                System.out.println(respuesta1+", no es correcto");
              System.out.println("Pista 2, su genero es: "+this.pelicula.getGenero());
                 System.out.println("¿Cuál es el director de la película?");
              String respuesta2 = entrada.nextLine();
             
               if(respuesta2.equals(this.pelicula.getDirector())){
                  ptos_jugador2 += 30;
                  System.out.println("+30 puntos.");
              }else{
                  
                    System.out.println(respuesta2+", no es correcto");
                  System.out.println("Pista 3, su actor protagonista es: "+this.pelicula.getActor());
                    System.out.println("¿Cuál es el director de la película?");
              String respuesta3 = entrada.nextLine();
             
               if(respuesta3.equals(this.pelicula.getDirector())){
                  ptos_jugador2 += 20;
                  System.out.println("+20 puntos.");
              }else{
                   
                  System.out.println(respuesta3+", no es correcto");
                  System.out.println("Pista 4, su actriz protagonista es: "+this.pelicula.getActriz());
                     System.out.println("¿Cuál es el director de la película?");
              String respuesta4 = entrada.nextLine();
              
               if(respuesta4.equals(this.pelicula.getDirector())){
                  ptos_jugador2 += 10;
                  System.out.println("+10 puntos.");
              }else{
                   System.out.println(respuesta4+", no es correcto");
                  System.out.println("La respuesta correcta era: "+this.pelicula.getDirector());
                    }
              }
              }
         }
      }
    }
       public void quintaPreguntaj2(){//quinta pregunta de jugador2
    
     Scanner entrada = new Scanner (System.in);
    System.out.println("El título de la pelicula es: "+this.pelicula.getTitulo());
     System.out.println("¿Cuál es el actor protagonista de la película?");
    String respuesta = entrada.nextLine();
     
      if(respuesta.equals(this.pelicula.getActor())){
           ptos_jugador2 += 50;
         System.out.println("Enhorabunea +50 puntos.");
      }else{
          
           System.out.println(respuesta+", no es correcto");
         System.out.println("Pista 2, su año de distribucion es: "+this.pelicula.getAño());
               System.out.println("¿Cuál es el actor protagonista de la película?");
              String respuesta1 = entrada.nextLine();
        
         if(respuesta1.equals(this.pelicula.getActor())){
             ptos_jugador2 += 40;
         System.out.println("+40 puntos.");
         }else{
             
                System.out.println(respuesta1+", no es correcto");
              System.out.println("Pista 2, su genero es: "+this.pelicula.getGenero());
                 System.out.println("¿Cuál es el actor protagonista de la película?");
              String respuesta2 = entrada.nextLine();
             
              if(respuesta2.equals(this.pelicula.getActor())){
                  ptos_jugador2 += 30;
                  System.out.println("+30 puntos.");
              }else{
                  
                    System.out.println(respuesta2+", no es correcto");
                  System.out.println("Pista 3, su director es: "+this.pelicula.getDirector());
                      System.out.println("¿Cuál es el actor protagonista de la película?");
              String respuesta3 = entrada.nextLine();
             
              if(respuesta3.equals(this.pelicula.getActor())){
                  ptos_jugador2 += 20;
                  System.out.println("+20 puntos.");
              }else{
                   
                  System.out.println(respuesta3+", no es correcto");
                  System.out.println("Pista 4, su actriz protagonista es: "+this.pelicula.getActriz());
                    System.out.println("¿Cuál es el actor protagonista de la película?");
              String respuesta4 = entrada.nextLine();
              
              if(respuesta4.equals(this.pelicula.getActor())){
                  ptos_jugador2 += 10;
                  System.out.println("+10 puntos.");
              }else{
                   System.out.println(respuesta4+", no es correcto");
                  System.out.println("La respuesta correcta era: "+this.pelicula.getActor());
                    }
              }
              }
         }
      }
    }
     public void sextaPreguntaj2(){//sexta pregunta de jugador2
   
     Scanner entrada = new Scanner (System.in);
    System.out.println("El título de la pelicula es: "+this.pelicula.getTitulo());
     System.out.println("¿Cuál es la actriz protagonista de la película?");
    String respuesta = entrada.nextLine();
     
      if(respuesta.equals(this.pelicula.getActriz())){
           ptos_jugador2 += 50;
         System.out.println("Enhorabunea +50 puntos.");
      }else{
          
           System.out.println(respuesta+", no es correcto");
         System.out.println("Pista 2, su año de distribucion es: "+this.pelicula.getAño());
               System.out.println("¿Cuál es la actriz protagonista de la película?");
              String respuesta1 = entrada.nextLine();
        
          if(respuesta1.equals(this.pelicula.getActriz())){
             ptos_jugador2 += 40;
         System.out.println("+40 puntos.");
         }else{
             
                System.out.println(respuesta1+", no es correcto");
              System.out.println("Pista 2, su genero es: "+this.pelicula.getGenero());
                 System.out.println("¿Cuál es la actriz protagonista de la película?");
              String respuesta2 = entrada.nextLine();
             
                if(respuesta2.equals(this.pelicula.getActriz())){
                  ptos_jugador2 += 30;
                  System.out.println("+30 puntos.");
              }else{
                  
                    System.out.println(respuesta2+", no es correcto");
                  System.out.println("Pista 3, su director es: "+this.pelicula.getDirector());
                     System.out.println("¿Cuál es la actriz protagonista de la película?");
              String respuesta3 = entrada.nextLine();
             
                if(respuesta3.equals(this.pelicula.getActriz())){
                  ptos_jugador2 += 20;
                  System.out.println("+20 puntos.");
              }else{
                   
                  System.out.println(respuesta3+", no es correcto");
                  System.out.println("Pista 4, su actor protagonista es: "+this.pelicula.getActor());
                    System.out.println("¿Cuál es la actriz protagonista de la película?");
              String respuesta4 = entrada.nextLine();
              
                if(respuesta4.equals(this.pelicula.getActriz())){
                  ptos_jugador2 += 10;
                  System.out.println("+10 puntos.");
              }else{
                   System.out.println(respuesta4+", no es correcto");
                  System.out.println("La respuesta correcta era: "+this.pelicula.getActriz());
                    }
              }
              }
         }
      }
    }
}

  
