/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmafinity;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Dani, Alejandro y Miguel
 */
public class Partida implements Serializable {
    private int id_partida;
    private Usuario ganador;
    private Usuario jugador1;
     private Usuario jugador2;
    private String resultado_final;
    private int pts_jugador1;
    private int pts_jugador2;
    private List<Pelicula> peliculas_preguntas;/*en este array se guardan las peliculas random que se generan al jugador 1 para que ambos
                                                jugadores les pregunten sobre las mismas preguntas*/
    
 
    


    public Partida(int id_partida,Usuario ganador,String resultado_final,Usuario usuarioCreador, Usuario usuarioContrincante){
        this.id_partida = id_partida;
        this.ganador = ganador;
        this.jugador1=usuarioCreador;
     this.jugador2=usuarioContrincante;
        this.resultado_final = resultado_final;
        this.pts_jugador1 = 0;
        this.pts_jugador2 = 0;
        this.peliculas_preguntas= new CopyOnWriteArrayList<>();
        
}
    
    
    public int getId_partida(){
        return id_partida;
}
    public Usuario getGanador(){
        return ganador;
    }
    public String getResultado_final(){
        return resultado_final;
    }
    public int getPts_jugador1(){
        return pts_jugador1;
    }
    public int getPts_jugador2(){
        return pts_jugador2;
    }
     public Usuario getJugador1(){
        return jugador1;
}
      public Usuario getJugador2(){
        return jugador2;
}
    public void setId_partida(int id_partida){
        if(id_partida >= 0)
            this.id_partida = id_partida;
    }
    public void setGanador(Usuario ganador){
            this.ganador = ganador;
    }
    public void setResultado_final(String resultado_final){
        if(resultado_final != null)
            this.resultado_final = resultado_final;
    }
    public void setPts_jugador1(int pts_jugador1){
        if(pts_jugador1 >= 0)
            this.pts_jugador1 = pts_jugador1;
    }
    public void setPts_jugador2(int pts_jugador2){
        if(pts_jugador2 >= 0)
            this.pts_jugador2 = pts_jugador2;
    }
    public Usuario getUsuarioCreador(){
        return jugador1;
}
     public Usuario getUsuarioContrincante(){
        return jugador2;
}
    @Override
     public String toString(){
         return"\nPARTIDA"
                 +"\nPuntos de "+getJugador1().getApodo()+" : "+getPts_jugador1()
                + "\nPuntos de " +getJugador2().getApodo()+" : "+getPts_jugador2()
                 +"\nResultado de la partida, "+getResultado_final();
                 
               
     }
public static Partida  crearPartida(Usuario u1, Usuario random){//cuando crea la partida un jugador recibe al jugador creador u1, y al random
    int id_partida = (int) (Math.random() * 100000) + 1;//crea el id de la partida con un numero aleatorio entre 0 y 100000
    Partida iniciada=new Partida(id_partida,null,null,u1,random);//crea la partida
    
    if(iniciada==null){
        System.out.println("La patida no se ha podido crear");
    }
    else{
         System.out.println("\nPartida creada con exito");
         return iniciada;
    }
    return iniciada;
  
    
}

    public static boolean comenzarPartida(Usuario u, Usuario contrincante, Peliculas ps,Clasificacion items) {//cuando se da la opcion de comenzar partida
        int i=1;//indicador de en que pregunta estamos
        boolean comenzada=false;
        Scanner entrada = new Scanner (System.in);
        Partida iniciada=crearPartida(u,contrincante);//se crea la partida
        int puntoSiguientes=0;
        if(iniciada==null){
             System.out.println("La partida no se ha podido crear");
             
        }
        
        else{//si se crea bien
            do{if(i==1){//para la primera pregunta
                Pelicula p= ps.anyPelicula();//pelicula random
                int partida=iniciada.getId_partida();
                 Pregunta preg=new Pregunta(partida,p,0,0);//crea la pregunta
                preg.primeraPregunta();//llama al metodo de la primera pregunta del jugador1
                puntoSiguientes=+preg.getPts_jugador1();//coge los puntos conseguidos por esa partida y los añade a los totales de la partida del jugador1
                iniciada.peliculas_preguntas.add(p);//añade la pelicula random al array de peliculas, para luego usarlas con el jugador2
            }
             if(i==2){//para la segunda pregunta, todo igual que la primera pero con la segunda
                 Pelicula p= ps.anyPelicula();
                  int partida=iniciada.getId_partida();
                 Pregunta preg=new Pregunta(partida,p,puntoSiguientes,0);
                preg.segundaPregunta();
                puntoSiguientes=+preg.getPts_jugador1();
                iniciada.peliculas_preguntas.add(p);

             }
             if(i==3){
                  Pelicula p= ps.anyPelicula();
                 int partida=iniciada.getId_partida();
                 Pregunta preg=new Pregunta(partida,p,puntoSiguientes,0);
                preg.terceraPregunta();
                puntoSiguientes=+preg.getPts_jugador1();
                iniciada.peliculas_preguntas.add(p);
             }


              if(i==4){
                   Pelicula p= ps.anyPelicula();
                    int partida=iniciada.getId_partida();
                 Pregunta preg=new Pregunta(partida,p,puntoSiguientes,0);
                preg.cuartaPregunta();
                puntoSiguientes=+preg.getPts_jugador1();
                iniciada.peliculas_preguntas.add(p);

              }
              if(i==5){
                  
                  Pelicula p= ps.anyPelicula();
                  int partida=iniciada.getId_partida();
                 Pregunta preg=new Pregunta(partida,p,puntoSiguientes,0);
                preg.quintaPregunta();
                puntoSiguientes=+preg.getPts_jugador1();
                iniciada.peliculas_preguntas.add(p);

            }
              if(i==6){
                  Pelicula p= ps.anyPelicula();
                     int partida=iniciada.getId_partida();
                 Pregunta preg=new Pregunta(partida,p,puntoSiguientes,0);
                preg.sextaPregunta();
                puntoSiguientes=+preg.getPts_jugador1();
                iniciada.peliculas_preguntas.add(p);
                 iniciada.setPts_jugador1(preg.getPts_jugador1());
                  System.out.println("Los puntos acumulado en la partida son:\n"
                          + iniciada.getJugador1()+": "+iniciada.getPts_jugador1()+"\n"+iniciada.getJugador2()+": "+iniciada.getPts_jugador2()+"\n");
                        //imprime los puntos acumulados hasta el momento en la partida
                          
                    boolean bienAdd=contrincante.añadirPartidaPendiente(iniciada,contrincante);//añade al array de peliculas pendientes del contrincante(jugador2) la partida iniciada por jugador 1
            if(bienAdd==false){
                 System.out.println("La partida no se ha podido crear(fallo al añadir la partida a las pendientes de tu contrincante");
            }
            else{
                    comenzada=true;
            }
                }
              i++;
        }while(i<7);//hasta que no hace las 6 preguntas no sale del bucle
            }   
        
    
        return comenzada;
    }
    
     public boolean acabarPartida(Clasificacion items) {//cuando el jugador2 decide acabar la partida
         
          boolean acabada=false;
          int i=1;//para saber en que pregunta estamos
          int puntoSiguientes=0;//puntos actuales
          do{if(i==1){//para la primera pregunta 
                Pelicula p= this.peliculas_preguntas.get(0);
                Pregunta preg=new Pregunta(this.id_partida,p,this.pts_jugador1,this.pts_jugador2);//crea pregunta con los datos de la partida
                preg.primeraPreguntaj2();
                puntoSiguientes=+preg.getPts_jugador2();//añade los puntos acumulados en la pregunta al jugador2
                
            }
             if(i==2){//para la segunda pregunta, todo igual que la 1 pero con la segunda
                 Pelicula p= this.peliculas_preguntas.get(1);
                  Pregunta preg=new Pregunta(this.id_partida,p,this.pts_jugador1,puntoSiguientes);
                  preg.segundaPreguntaj2();
                  puntoSiguientes=+preg.getPts_jugador2();
               
             }
             if(i==3){
                   Pelicula p= this.peliculas_preguntas.get(2);
                  Pregunta preg=new Pregunta(this.id_partida,p,this.pts_jugador1,puntoSiguientes);
                  preg.terceraPreguntaj2();
                  puntoSiguientes=+preg.getPts_jugador2();
                 
             }


              if(i==4){
                    Pelicula p= this.peliculas_preguntas.get(3);
                    
                  Pregunta preg=new Pregunta(this.id_partida,p,this.pts_jugador1,puntoSiguientes);
                  preg.cuartaPreguntaj2();
                  puntoSiguientes=+preg.getPts_jugador2();
                   
              }
              if(i==5){
                  Pelicula p= this.peliculas_preguntas.get(4);
                    Pregunta preg=new Pregunta(this.id_partida,p,this.pts_jugador1,puntoSiguientes);
                  preg.quintaPreguntaj2();
                  puntoSiguientes=+preg.getPts_jugador2();
                   
          

            }
              if(i==6){
                    Pelicula p= this.peliculas_preguntas.get(5);
                    Pregunta preg=new Pregunta(this.id_partida,p,this.pts_jugador1,puntoSiguientes);
                  preg.sextaPreguntaj2();
                  puntoSiguientes=+preg.getPts_jugador2();
                  acabada=true;
                  setPts_jugador1(preg.getPts_jugador1());
                  setPts_jugador2(preg.getPts_jugador2());
                  if(this.pts_jugador1>this.getPts_jugador2()){//para ver quien es el ganador
                      String resultado=("El ganador de la partida es: "+getJugador1().getApodo());
                        setResultado_final(resultado);
                        System.out.println("El ganador de la partida es: "+getJugador1().getApodo());
                        String resultado1=toString();
                        StringBuilder sendMuro = new StringBuilder(resultado1);
                          getJugador1().setMuro(sendMuro);//envia el resultado al muro del jugador1
                          getJugador2().setMuro(sendMuro);//envia el resultado al muro del jugador2
                      
                         Item itemj1=items.buscarItem(getJugador1());//devuelve el item con el nombre del jugador1
                         itemj1.setPuntos(getPts_jugador1());//manda los puntos conseguidos del jugador1 en la partida
                         itemj1.setJugadas(1);//añade 1 partida jugada al jugador1
                         itemj1.setGanadas(1);//añade 1 partida ganada a jugador 1
                          double porcentaje=(itemj1.getGanadas()*100)/itemj1.getJugadas();
                          itemj1.setPorcent_victorias(porcentaje);//actualiza el porcentaje de victorias
                          
                         Item itemj2=items.buscarItem(getJugador2());//devuelve el item con el nombre del jugador2
                         itemj2.setPuntos(getPts_jugador2());//manda los puntos conseguidos del jugador2 en la partida
                         itemj2.setJugadas(1);//añade 1 partida jugada al jugador2
                         itemj2.setPerdidas(1);//añade 1 partida perdida a jugador 2
                         double porcentaje1=(itemj2.getGanadas()*100)/itemj2.getJugadas();
                          itemj2.setPorcent_victorias(porcentaje1);//actualiza el porcentaje de victorias
                  }
                   if(this.pts_jugador1<this.getPts_jugador2()){
                       
                        String resultado=("El ganador de la partida es: "+getJugador2().getApodo());
                        setResultado_final(resultado);
                        System.out.println("El ganador de la partida es: "+getJugador2().getApodo());
                        String resultado1=toString();
                        StringBuilder sendMuro = new StringBuilder(resultado1);
                          getJugador1().setMuro(sendMuro);
                          getJugador2().setMuro(sendMuro);

                        Item itemj1=items.buscarItem(getJugador1());//devuelve el item con el nombre del jugador1
                         itemj1.setPuntos(getPts_jugador1());//manda los puntos conseguidos del jugador1 en la partida
                         itemj1.setJugadas(1);//añade 1 partida jugada al jugador1
                         itemj1.setPerdidas(1);//añade 1 partida perdidaa a jugador 1
                          double porcentaje=(itemj1.getGanadas()*100)/itemj1.getJugadas();
                          itemj1.setPorcent_victorias(porcentaje);//actualiza el porcentaje de victorias
                          
                         Item itemj2=items.buscarItem(getJugador2());//devuelve el item con el nombre del jugador2
                         itemj2.setPuntos(getPts_jugador2());//manda los puntos conseguidos del jugador2 en la partida
                         itemj2.setJugadas(1);//añade 1 partida jugada al jugador2
                         itemj2.setGanadas(1);//añade 1 partida ganada a jugador 2
                         double porcentaje1=(itemj2.getGanadas()*100)/itemj2.getJugadas();
                          itemj2.setPorcent_victorias(porcentaje1);//actualiza el porcentaje de victorias
                   }
                   if(this.pts_jugador1==this.getPts_jugador2()){
                       String resultado=("El resultado es de Empate");
                        setResultado_final(resultado);
                        System.out.println("El resultado es de Empate");
                         String resultado1=toString();
                        StringBuilder sendMuro = new StringBuilder(resultado1);
                       
                         Item itemj1=items.buscarItem(getJugador1());//devuelve el item con el nombre del jugador1
                         itemj1.setPuntos(getPts_jugador1());//manda los puntos conseguidos del jugador1 en la partida
                         itemj1.setJugadas(1);//añade 1 partida jugada al jugador1
                         double porcentaje=(itemj1.getGanadas()*100)/itemj1.getJugadas();
                          itemj1.setPorcent_victorias(porcentaje);//actualiza el porcentaje de victorias
                         
                         Item itemj2=items.buscarItem(getJugador2());//devuelve el item con el nombre del jugador2
                         itemj2.setPuntos(getPts_jugador2());//manda los puntos conseguidos del jugador2 en la partida
                         itemj2.setJugadas(1);//añade 1 partida jugada al jugador2
                        double porcentaje1=(itemj2.getGanadas()*100)/itemj2.getJugadas();
                          itemj2.setPorcent_victorias(porcentaje1);//actualiza el porcentaje de victorias
                   }
                   
         
     }i++;
          }while(i<7);
             
        
    
        return acabada;
    }
}