/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmafinity;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Random;

/**
 *
 * @author Daniel Mguel y Alejando
 */
public class Usuario implements Serializable {

     private ArrayList<Usuario> usuarios;
    private String apodo;
    private String contraseña;
    private StringBuilder muro;
    private int partidas_ganadas;
    private int partidas_perdidas;
    private int partidas_empatadas;
    private ArrayList<Pelicula> peliculasUsuario;
    private ArrayList<Critica> criticasUsuario;
    private List<Partida> partidas_pendientes;
    private ArrayList<Partida> partidas_completas;
    private List<Usuario> peticiones_pendientes;
    private ArrayList<Usuario> amigos;
    private String aceptar;
    private String rechazar;
    
    public Usuario(String apodo, String contraseña,Clasificacion items){
            this.apodo = apodo;
            this.contraseña = contraseña;
            this.muro = new StringBuilder("*******************MURO*******************");
            this.partidas_ganadas=0;
            this.partidas_perdidas=0;
            this.partidas_empatadas=0;
            this.peliculasUsuario =  new ArrayList<>();
            this.partidas_pendientes = new CopyOnWriteArrayList<>();
            this.partidas_completas = new ArrayList<>();
            this.amigos = new ArrayList<>();
            this.criticasUsuario = new ArrayList<>();
            this.peticiones_pendientes = new CopyOnWriteArrayList<>();
            this.usuarios= new ArrayList<>();
            Item item1=new Item(apodo);
            items.añadirItem(item1);
       }
      
      public Usuario(String apodo){
          this.apodo = apodo;
      }
    
      public String getContraseña(){
        return contraseña;
    }
    
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }
    public String getApodo(){
        return apodo;
    }
    
    public void setApodo(String apodo){
        this.apodo = apodo;
    }
    
    public void setMuro(StringBuilder infoMuro){
        this.muro=muro.append(infoMuro);
        System.out.println(getMuro()+"\n******************************************");
        
    }
    public StringBuilder getMuro(){
       return muro;
                         
    }
    @Override
    public String toString(){
        return getApodo();
    }
     public void tratarPeticiones(Usuario u) 
    {  Scanner entrada = new Scanner (System.in);
    if(this.peticiones_pendientes.size()==0){
        System.out.println ("No tienes solicitudes de amistad pentientes :(");
        
        }
    else{
         for(Usuario peticiones : this.peticiones_pendientes) {
            String nombreAmigo = peticiones.getApodo();
            System.out.println(nombreAmigo);
            System.out.println ("Quieres aceptar la peticion de amistad de "+nombreAmigo+"?(Escribe Si/No): ");
            String respuesta = entrada.nextLine();
            if(respuesta.equals("Si")||respuesta.equals("si")){
             
                     this.amigos.add(peticiones);
                     peticiones.amigos.add(u);
                     System.out.println(nombreAmigo+" añadido a tus amigos");
                     //peticiones_pendientes.remove(1);
                    this.peticiones_pendientes.remove(peticiones);
                    
                     System.out.println("");
                    
                 }else 
                if(respuesta.equals("No")||respuesta.equals("no")){
                    System.out.println (nombreAmigo+" NO se ha añadido a tus amigos");
                    this.peticiones_pendientes.remove(peticiones);//borra la peticion del array de peticiones
                    System.out.println("");
                    
                }
                else{
                    System.out.println ("Opcion no valida");
                }
             }
            }
           
                
           }
 
  public static boolean buscarAmigo(Usuario u){
        boolean agregar=false;
        
            String apodo= u.getApodo();
        
        for (Usuario usuario : u.amigos) {//recorre el array de amigos del usuario que le pasamos(el que esta logeado)
            if(apodo.equals(usuario.getApodo())){
                agregar=true;
                
            }
            else{
                return agregar;
            }
        }
  return agregar;
}  
      public void imprimirAmigos() 
    {  System.out.println("****LISTA DE AMIGOS****");
         for(Usuario usuario : this.amigos) {
            String nombreAmigo = usuario.getApodo();
            System.out.println("-"+nombreAmigo);
               
               }
          System.out.println("*********************");
    }
      public void imprimirCriticas() 
    {  System.out.println("****LISTA DE PELICULAS CRITICADAS****");
         
         for(Critica critica : this.criticasUsuario) {
            String nombreCritica = critica.getPelicula();
            System.out.println("-"+nombreCritica);
               
               }
          System.out.println("*************************************");
    }
      
      public void imprimirPetis() 
    { 
         System.out.println("****LISTA DE PETICIONES DE AMISTAD****");
         for(Usuario usuario : this.peticiones_pendientes) {
            String nombreAmigo = usuario.getApodo();
            System.out.println("-"+nombreAmigo);
               
               }
         System.out.println("*************************************");
    }
     
  
         
        
    public static boolean PeticionesPen(Usuario u,Usuario amigo){
        boolean agregar=false;
        if(!amigo.peticiones_pendientes.contains(u)){
            amigo.peticiones_pendientes.add(u);
            agregar=true;
        }
      
       
       return agregar;
   }
    
     public boolean añadirPeliculas(Pelicula P,Usuario u,Peliculas ps){
        boolean agregar= false;
      
        
      boolean sePuede2=ps.añadirPeliculas(P);
      if(sePuede2){
           peliculasUsuario.add(P);
           StringBuilder sendMuro = new StringBuilder(P.toString());
            u.setMuro(sendMuro);
           
           agregar = true;
      }
      else{
          System.out.println("Error en añadirPeliculas(usario)");
      }
      
      
       return agregar;
   }
     public static boolean añadirPartidaPendiente(Partida part,Usuario contrincante){
          boolean bienAdd=false;
        if(contrincante.partidas_pendientes.add(part)){
         bienAdd=true;
     }
          return bienAdd;
     }
     
     public void añadirPelisC(Usuario u, Pelicula p){
      u.peliculasUsuario.add(p);
       StringBuilder sendpeli = new StringBuilder(p.toString()+"  (Pelicula compartida por "+getApodo()+")");
         u.setMuro(sendpeli);
    }   
     
     public void imprimirPartidasPendientes(Clasificacion items){
         Scanner entrada = new Scanner (System.in);
         if(this.partidas_pendientes.size()==0){
        System.out.println ("No tienes partidas pentientes :(");
        
        }
         for(Partida pendientes : this.partidas_pendientes) {
            Usuario contrincante = pendientes.getUsuarioCreador();
            String nombreContrin= contrincante.getApodo();
            System.out.println ("Quieres acabar la partida que tienes con "+nombreContrin+"?(Escribe Si/No): ");
            String respuesta = entrada.nextLine();
            if(respuesta.equals("Si")||respuesta.equals("si")){
                
                     boolean acabada=pendientes.acabarPartida(items);//devuelve true si todo el desarrollo de las partidas ha ido bien, false si no
                     if(acabada==true){
                         System.out.println ("*******Partida terminada*******");
                         this.partidas_completas.add(pendientes);//añade la partida completa al array del usuario que acaba la partida
                         pendientes.getJugador1().partidas_completas.add(pendientes);//añade la partida completa al array del que inició la partida
                         this.partidas_pendientes.remove(pendientes);//borra esta oartida de partidas pendientes
                     }
                     else{
                          System.out.println ("No se ha completado bien la partida");
                     }
                  
                 }else 
                if(respuesta.equals("No")||respuesta.equals("no")){
                    System.out.println ("La partida con "+nombreContrin+" NO se ha terminado la partida");
                    //no hace nada mas para dejar en el array de partidas pendientes la partida que NO se quiere acabar para en un futuro acabarla
                    
                }
                else{
                    System.out.println ("Opcion no valida");
                }
             }
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     public boolean crearCritica(Critica c,Pelicula P,Peliculas ps){ // ES CREAR CRITICA
        boolean agregar=false;
        Scanner entrada = new Scanner (System.in);
        boolean sePuede =  ps.buscarPelicula(P);//le pasa la pelicula para ver si existe
        double puntDouble;
                 if(sePuede==false){//si sePuede=false ( es decir está la peli hace el código)
                     puntDouble=0;
                     int falloAño=0;//inicializa la variable para controlar las veces que se entra en el do
                          do {falloAño++;//cuando repite el do año=2 y entra el if(fallo==año)
                             if(falloAño==2){
                             System.out.print ("La puntuacion debe estar comprendida entre 0.0-10.0\n");
                                }
                             System.out.print ("Pon una puntuacion entre 0.0-10.0: ");
                             String punt = entrada.nextLine();
                              try {puntDouble = Double.parseDouble(punt);
                                    falloAño=1;}
                              catch (NumberFormatException e){//cuando no pones un valor tipo int salta la excepcion
                                     System.out.println("La puntuacion debe ser un valor numerico y estar comprendido entre 0.0-10.0");
                                     puntDouble=-1;  //al no haber conseguida hacer el try bien se pone a -1 para que repitir el bucle
                                     falloAño=0;//pone fallo falloaño=0 para no repetir el mensaje cuando (falloaño==2)
                            }}while((puntDouble<0)||(puntDouble>10)||(falloAño==0));
                     
                        c.setPuntuacion(puntDouble);//se manda la puntuacion valida a la critica creada antes
                        System.out.print ("Escribe el cuerpo de la crítica:");
                         String cuerpo = entrada.nextLine();
                        c.setTexto(cuerpo);//se manda lo introducido por pantalla a la crítica creada
                    Pelicula Peli=ps.buscarPeli(P);//devuelve la pelicula del sistema que tiene el nombre que hemos dicho antes
                    boolean bienCreado=Peli.añadirCritica(c);//añade a la pelicula la crítica
                        if(bienCreado){
                            boolean bienCreado2=añadirCritica(c);//añade la crítica a mis críticas
                        
                            if(bienCreado2){
                             StringBuilder sendMuro = new StringBuilder(c.toString());//si todo se crea bien lo manda  ami muro
                                 setMuro(sendMuro);
                            System.out.print ("Crítica guardada con exito");
                            agregar=true;
                        }
                            else{
                                 System.out.print ("Error al guardar la crítica en la lista de CriticasUsuario");//si algo falla
                            }
                            
                        }
                        
                        else{
                            System.out.print ("Error al guardar la critica");
                            System.out.println(c);
                            agregar=false;
                        }
                            
              }
                 else{
                     System.out.print ("La pelicula que quieres criticar no existe");//si la pelicula dicha no existe
                 }
                 return agregar;
            }
            
        
    
      
    
  public  Pelicula buscarPelicula(Pelicula P){//busca en el array de peliculas usuario y devuelve la pelicula si existe si no, null
        Pelicula agregar=null;
        
          try{  String tituloP= P.getTitulo();//try porque si el array esta vacio saltará excepcion
        //for(int i=0; i<peliculas.length; i++) {
        for (Pelicula pelicula : this.peliculasUsuario) {
            if(tituloP.equals(pelicula.getTitulo())  ){
                agregar=pelicula;//variable que devuelve = a la pelicula con el mismo nombre que el introducido
             return agregar;}}}
            catch(NullPointerException e){//si el array vacio
                System.out.print("Aun no tienes peliculas para compartir\n");
                    
                    }
                return agregar;
            }
            
        
 

  public void imprimirPelisUs(){//imprime el array de peliculas recorriendolo
       System.out.println("****LISTA DE PELICULAS creadas por ti****");
         for(Pelicula pelicula : this.peliculasUsuario) {
            String nombrePelicula = pelicula.getTitulo();
            System.out.println("-"+nombrePelicula);
               
               }
         System.out.println("*****************************************");
  }
  
  public void imprimirCriticasUs(){//recorre el array de críticas del usuario recorriendolo con un for
       System.out.println("****LISTA DE CRITICAS creadas por ti****");
         for(Critica critica : this.criticasUsuario) {
            String nombreCritica = critica.getPelicula();
            System.out.println("-"+nombreCritica);
               
               }
         System.out.println("*****************************************");
  }
  
 public  Critica buscarCritica(Critica C){   //lo mismo que hemos hecho con el buscar amigos para el muro 
        Critica agregar = null;                    //pero ahora para la critica
        try{
            String tituloC = C.getPelicula();
        for (Critica criticas : this.criticasUsuario) {
            if(tituloC.equals(criticas.getPelicula())){
                agregar = criticas;
                return agregar;}}}
        catch(NullPointerException e){
                System.out.print("Aun no tienes críticas para compartir\n");
                
            }
            
        
  return agregar;
} 
public boolean añadirCritica(Critica C){//añade críticas al usuario
    boolean añadido=false;
    if(this.criticasUsuario.add(C));{
            añadido=true;//devuelve true si se añade con existo
    }   
      
           return añadido; 
    }
    


  

   
  public void compartir_todo(Usuario amigo){//se le pasa el usuario amigo para comprobar si le tiene en amigos
        
              Usuario SePuede = buscarAmigos(amigo);//comprueba si en el array de amigos esta el amigo indicado
            if(SePuede == null){
                System.out.println("El usuario con el que se va a compartir no es tu amigo o no existe");
            }else{//si si existe
                try{//hace try por si aun no has dado de alta ninguna pelicula y no salte la excepcion
                for(Pelicula pelicula : this.peliculasUsuario){
                
                 añadirPelisC(SePuede, pelicula);
                 }
                }catch(NullPointerException e){//cuando el array está vacio
                     System.out.println("No tienes peliculas para compartir");
                }try{       
                  for(Critica critica : this.criticasUsuario){//hace try por si aun no has dado de alta ninguna crítica y no salte la excepcion
                    StringBuilder sendcritica = new StringBuilder(critica.toString()+"  (Criticas compartida por "+getApodo()+")");
                    SePuede.setMuro(sendcritica); 
                    }
                }catch(NullPointerException e){//si array vacio
                       System.out.println("No tienes criticas para compartir");
                    }
                          
                 System.out.print("Comparitendo peliculas y criticas en el muro de "+SePuede.getApodo());
                
                }
            }    
    public void compartir_todoTodos(){
       for(Usuario amigo : this.amigos){//busca en el array de amigos del usuario (1 a 1)
           try{
                for(Pelicula pelicula : this.peliculasUsuario){//busca todas las peliculas 1 a 1 del usuario try por si está vacio
                 amigo.peliculasUsuario.add(pelicula);//añade la pelicula al array de peliculas del usuario para que tambien las pueda compartir
                 StringBuilder sendpeli = new StringBuilder(pelicula.toString()+"  (Pelicula compartida por "+getApodo()+")");//comparte la peli en el muro del amigo
                 amigo.setMuro(sendpeli);//comparte la peli en el muro del amigo
                System.out.print("Comparitendo peliculas en el muro de "+amigo.getApodo());
                 }
                }catch(NullPointerException e){//si array de peliculas del usuario vacio
                     System.out.println("No tienes peliculas para compartir");
                }try{       
                  for(Critica critica : this.criticasUsuario){//lo mismo que peliculas pero con críticas
                    StringBuilder sendcritica = new StringBuilder(critica.toString()+"  (Criticas compartida por "+getApodo()+")");
                    amigo.setMuro(sendcritica); 
                    System.out.print("Compartiendo criticas en el muro de "+amigo.getApodo());
                    }
                }catch(NullPointerException e){
                       System.out.println("No tienes criticas para compartir");
                    }
                          
                
                
                }
       }
   

            

    public void compartir_pelitodo(Pelicula p){
      
        Pelicula SePuede = buscarPelicula(p);//busca la pelicula en el array de peliculas del usuario y la devuelve si existe
         if(SePuede == null){//si no existe
            System.out.println("La pelicula que quieres compartir no te pertenece");
         }else{
          try{
                for(Usuario amigo : this.amigos){//recorre el array de amigos compartiendola con todos
                 amigo.peliculasUsuario.add(SePuede);
                 StringBuilder sendpeli = new StringBuilder(SePuede.toString()+"  (Pelicula compartida por "+getApodo()+")");
                 amigo.setMuro(sendpeli);//comparte la peli en el muro del amigo
                 
                 }
                }catch(NullPointerException e){//si array de pelis vacio
                     System.out.println("No tienes peliculas para compartir");
                }
             
             
         }
        
    }
    public void compartir_criticatodo(Critica c){//lo mismo que pelicula pero concrítica
      
        Critica SePuede = buscarCritica(c);
         if(SePuede == null){
            System.out.println("La crítica que quieres compartir no te pertenece");
         }else{
          try{
                for(Usuario amigo : this.amigos){
                 amigo.criticasUsuario.add(SePuede);
                 StringBuilder sendcritica = new StringBuilder(SePuede.toString()+"  (Crítica compartida por "+getApodo()+")");
                 amigo.setMuro(sendcritica);
                 
                 }
                }catch(NullPointerException e){
                     System.out.println("No tienes críticas para compartir");
                }
             
             
         }
        
    }


    
  public void compartirPelicula(Pelicula p,Usuario amigo){
        Scanner entrada = new Scanner (System.in);
        
             Usuario SePuede = buscarAmigos(amigo);//busca el amigo en el array de maigos del usuario
            if(SePuede == null){//si no es su amigo
                System.out.println("El usuario con el que se va a compartir no es tu amigo o no existe");
            }else{//si si lo es
                 StringBuilder sendpeli = new StringBuilder(p.toString()+"  (Pelicula compartida por "+getApodo()+")");
                 SePuede.setMuro(sendpeli);//comparte peli con el amigo
                 System.out.print("Comparitendo pelicula en el muro de "+SePuede.getApodo());
                
            }     
    }
  
  
    public void compartirCritica(Critica c, Usuario amigo){//lo mismo que pelicula pero con crítica
        Scanner entrada = new Scanner (System.in);
        
             Usuario SePuede = buscarAmigos(amigo);
            if(SePuede == null){
                System.out.println("El usuario con el que se va a compartir no es tu amigo o no existe");
            }else{
                 StringBuilder sendcritica = new StringBuilder(c.toString()+"  (Crítica compartida por "+getApodo()+")");
                 SePuede.setMuro(sendcritica);
                 System.out.print("Comparitendo critica en el muro de "+SePuede.getApodo());
                
            }     
    }
    
    
    public Usuario buscarAmigos(Usuario u){ //para lo de la critica y poder ponerla en el muro del amigo
         Usuario agregar = null;
        
            String amigo=u.getApodo();
        for (Usuario amigos : amigos) {
            if(amigo.equals(amigos.getApodo())){
                agregar = amigos;
            }
            else{
                agregar = null;
            }
        }
        return agregar;
    } 
          
                 
              
    public static Usuario invitarAmigo( Usuario amigo,Usuario u,Usuarios us){
        Scanner entrada = new Scanner (System.in);
         Usuario SePuede = u.buscarAmigos(amigo);//busca el nuevo amigo en la lista de amigos si está devuelve al amigo
          Usuario a=null;
         if(SePuede == null){//si el usuario no esta en tu lista de amigos
            Usuario existe=us.buscarUsuarios(amigo);//busca al usuario en la lista de usuarios y si existe devulve al mismo

             if(existe!=null){ //si no existe usuario en sistema
                 a=existe;
             }
             else{
                  System.out.println("Usuario no existe");
             }
         
         }
         else{//si es tu amigo
             System.out.println("El Usuario "+amigo.getApodo()+" ya es tu amigo");
         }
         return a;
    }
           public  void verMuro(){//llama a la funcion ver muro y añade ******... en la linea final
              System.out.println(getMuro()+"\n******************************************");
               
           }
    
           
           
}
        
     
 


    

 