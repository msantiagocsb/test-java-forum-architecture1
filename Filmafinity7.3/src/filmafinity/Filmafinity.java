/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmafinity;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
import java.util.Random;
/**
 *
 *  author Alejandro, Dani y Miguel
 */
public class Filmafinity {
public static Usuarios us;
 public static Peliculas ps;
 public static Clasificacion items;
    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws IOException {
        int opcion;
        us=new Usuarios();
         ps=new Peliculas();
         items=new Clasificacion();
        
          
           Usuario Usuario = null; 
           boolean UsuarioAux=false;
        do{
             Scanner entrada = new Scanner (System.in);
            System.out.print("¿Quieres iniciar sesion o registrarte?(Escribe Iniciar o Registar): ");
          String line = entrada.nextLine();
           if(line.equals("Iniciar")||line.equals("iniciar")){
               String cargar=null;
                boolean repetir=false;
                boolean bienCargado=false;
                  do{  System.out.print("¿Quieres cargar usuarios creados anteriormente?(Escribe Si o No): ");
                
                cargar = entrada.nextLine();
                if(cargar.equals("Si")||cargar.equals("si")){
                bienCargado=cargarEstado();//va a la funcion cargar estado para cargar los archivos binarios
               repetir=true;//para que no repita
                }
                if(cargar.equals("No")||cargar.equals("no")){
                    repetir=true;//pone la variable en true para no repetir
               
                }
                
                  }while(bienCargado=false||repetir==false);//cuando uno de los dos es false repite el código
                
            Usuario = us.autenticar();
            if (Usuario==null) {
               System.out.println ("*Por favor, introduzca unos credeciales correctos");
            }}
            if(line.equals("Registrar")||line.equals("registrar")){
                UsuarioAux=us.registrarUsuario(us,items);
                 if (UsuarioAux==false) {
                     System.out.println ("*El Usuario que quieres registrar ya existe");
                 }
                 else{
                       System.out.println ("*Usuarios creado con exito");
                 }
            }
            
        }while ((Usuario==null));
        
       
        do {
            opcion = elegirOpcion(Usuario);
            menu (opcion, Usuario,us,ps,items);
            
      
            
        
         }while (opcion!=0);
        
    }



    
    public static int elegirOpcion (Usuario usuario) {
      
      
        int fallo=23;//variable para que vuelva a imprimir el menú si no ha escrito un valor entre 1-16
        System.out.println ("\n1- Ver muro");
        System.out.println ("2- Añadir pelicula ");
        System.out.println ("3- Compartir pelicula ");
        System.out.println ("4- Añadir critica ");
        System.out.println ("5- Compartir critica");
        System.out.println ("6- Compartir todo");
        System.out.println ("7- Iniciar partida");
        System.out.println ("8- Invitar amigo ");
        System.out.println ("9- Solicitudes de amistad pendientes");
        System.out.println ("10- Guardar clasificacion en archivo de texto");
        System.out.println ("11- Compartir pelicula con todos");
        System.out.println ("12- Compartir crítica con todos");
        System.out.println ("13- Compartir todo con todos");
         System.out.println ("14- Completar Partidas");
         System.out.println ("15- Ver clasificacion de partidas");
         System.out.println ("16- Ver item de 1 usuario");
        
        
        System.out.println ("0- Salir");
        
        Scanner entrada = new Scanner (System.in);
        System.out.print ("Dime una opcion: ");
        try{
        String linea = entrada.nextLine();
        return Integer.parseInt(linea);
        }
        catch(NumberFormatException e){
            System.out.print ("Has de elegir un numero del menú y tiene que ser un valor numerico\n");
            return fallo;
        }
    }

    private static void menu(int opcion, Usuario usuario,Usuarios us,Peliculas ps,Clasificacion items) throws IOException {
        
        
        
        
        
        switch (opcion) {
            case 1: ver_muro(usuario);
                      break;
            case 2: crearPelicula(usuario,ps);
                      break;
            case 3: compartir_Pelicula(usuario);
                     break;
            case 4: crearCritica(usuario);
                 break;
            case 5: compartir_Critica(usuario);
                      break;
            case 6: compartir_todo(usuario);
                      break;
            case 7: iniciarPartida(usuario,ps,items);
                      break;
            case 8: invitar_amigo(usuario,us);
                      break;
            case 9: visualizarPeticiones(usuario);
                      break;
            case 10: guardarClasificaionText(items);
                      break;   
            case 11: compartir_pelitodos(usuario);
                      break;
            case 12: compartir_criticatodos(usuario);
                      break;
            case 13: compartir_todotodito(usuario);
                      break;
             case 14: completarPartidas(usuario,items);
                      break;
              case 15: verClasificacion(items);
                      break;
             case 16: detallesPartida(items);
                      break;
            case 0:     boolean guardar;
                        do{
                            guardar=salida(us,ps,items);
                        }while(guardar==false);
                        System.out.println ("Adios");
                            break;
            default: System.out.println ("Opcion no reconocida");
        }
    }
     
  
        private static void crearPelicula(Usuario u,Peliculas ps){ 
        Scanner entrada = new Scanner (System.in);
        System.out.print ("Dime el nombre de la pelicula: ");        
        String titulo = entrada.nextLine();
        int añoint=0;
        int falloAño=0;
        do {falloAño++;
            if(falloAño==2){
             System.out.print ("El año debe estar comprendido entre 1895-2022\n");
        }
            System.out.print ("Escribe el año en el que hizo la pelicula:");
             String año = entrada.nextLine();
             try {añoint = Integer.parseInt(año);
                     falloAño=1;}
             catch (NumberFormatException e){
               System.out.println("El año debe ser un valor numerico y estar comprendido entre 1895-2022");
                añoint=0;  
                falloAño=0;
            }}while((añoint==0)||(añoint<1894)||(añoint>2022)||(falloAño==0));//si el año no está entre 1894-2022 o no es un numero repite la peticion
        
        System.out.print ("Indica el director:");
        String director = entrada.nextLine();
        System.out.print ("Indica el genero:");
        String genero = entrada.nextLine();
        System.out.print ("Di el actriz principal:");
        String actriz = entrada.nextLine();
        System.out.print ("Di el actor principal:");
        String actor = entrada.nextLine();
        Pelicula p= new Pelicula(titulo,añoint,director,genero,actor,actriz);

          boolean sePuede =  ps.buscarPelicula(p);//comprueba si existe una peli con el mismo nombre, true si no existe
            if (sePuede==true) {
          
        
                boolean sePuede2=u.añadirPeliculas(p,u,ps);//añade la pelicula, true si la añade bien
                 if (sePuede2==true) {            
       
                System.out.println ("Pelicula creada correctamente");
           
            
                }else {
                System.out.println ("La pelicula no se pudo guardar");
                } 
              }   
             else{    
             System.out.println ("\nYa existe una pelicula con ese nombre");
              }
       }
        
           
              private static void crearCritica(Usuario u){
                  Scanner entrada = new Scanner (System.in);
                    ps.imprimirPeliculas();
                  System.out.print ("Dime el nombre de la pelicula que quieres hacer la crítica: "); 
                  String titulo = entrada.nextLine();
                    Pelicula p= new Pelicula(titulo);
                   Critica c=new Critica(titulo);
                   u.crearCritica(c,p,ps);//con el nombre de la peli requerida pasa, la crítica creado, el array de peliculas y la pelicula creada para buscar la pelicula con ese nombre
                
            }
            
        
    
    
      
        private static void compartir_Pelicula(Usuario u){
        Scanner entrada = new Scanner (System.in);
        u.imprimirPelisUs();
        System.out.println("Elija la pelicula a compartir:");
        String pelicula = entrada.nextLine();
         Pelicula p = new Pelicula(pelicula);
         p=u.buscarPelicula(p);
          Pelicula SePuede =  u.buscarPelicula(p);
       if (SePuede==null) {
        
        System.out.println("No existe ninguna con ese nombre o que hayas registrado.");
        
       }else{
           u.imprimirAmigos();
        System.out.println("Con que amigo quieres compartir la pelicula");
       
        String aux = entrada.nextLine();
        Usuario amigo = new Usuario(aux);
        u.compartirPelicula(p,amigo);   
        
       }
    }  
              
    private static void compartir_Critica(Usuario u){
        Scanner entrada = new Scanner (System.in);
        u.imprimirCriticas();
        System.out.println("Elija la critica a compartir:");
        String critica = entrada.nextLine();
         Critica c = new Critica(critica);
         c= u.buscarCritica(c);
          Critica SePuede =  u.buscarCritica(c);
       if (SePuede==null) {
        
        System.out.println("No existe ninguna critica de esa pelicula elaborada por ti.");
        
       }else{
            u.imprimirAmigos();
        System.out.println("Con que amigo quieres compartir la critica.");
        
        String aux = entrada.nextLine();
        Usuario amigo = new Usuario(aux);
        u.compartirCritica(c,amigo);   
        
       }
    }
                      
      private static void invitar_amigo (Usuario u,Usuarios us){
           Scanner entrada = new Scanner (System.in);
           
           String nuevoAmigo=null;
           String yo;
           int yoMismo=0;
           do{
           yoMismo++;
           if(yoMismo>=2){
               System.out.println("No puedes ser amigo de ti mismo!");
           }
            us.imprimirUsuarios();
           System.out.println("Indica a que usuario quieres mandarle la invitacion de amistad:");
           nuevoAmigo = entrada.nextLine();
            yo=u.getApodo();
            }
           while((nuevoAmigo.equals(yo))||(nuevoAmigo.equals(null)));
           Usuario amigoNew=new Usuario(nuevoAmigo);
           
           Usuario amigo=u.invitarAmigo(amigoNew,u,us);
           if(amigo!=null){
                 boolean bienCreado=amigo.PeticionesPen(u,amigo);
               if(bienCreado==true){
                    System.out.println("Peticion enviada con exito a "+amigo.getApodo());
               }
               else{
                   System.out.println("Error al enviar la peticion (al guardar en el array peticiones_pendientes");
               }
           }u.imprimirPetis();
           
      }
           private static void visualizarPeticiones(Usuario u){
               u.tratarPeticiones(u);
               
               
           }
           private static void guardarClasificaionText(Clasificacion items){
                Scanner entrada = new Scanner (System.in);
              System.out.print ("Di como quieres llamar al fichero con la clasificacion: ");
                String fichero = entrada.nextLine();
                items.guardarText(fichero);
           }
           private static void ver_muro(Usuario u){ 
               u.verMuro();
           }
            private static boolean guardarEstado(Usuarios us,Peliculas ps,Clasificacion items){
                
                boolean guardado;
         Scanner entrada = new Scanner (System.in);
        System.out.print ("Indique el nombre del fichero de usuarios: ");
        String fichero = entrada.nextLine();
            
        ObjectOutputStream salida;
        try {
            salida = new ObjectOutputStream(new FileOutputStream(fichero));
            salida.writeObject(us);
            salida.close();
            guardado=true;
        } catch (IOException ex) {
            System.out.print ("Fallo al guardar usuarios");
            guardado=false;
            
        }
       if(guardado==true){
        System.out.print ("Indique el nombre del fichero de peliculas: ");
        String fichero2 = entrada.nextLine();
        ObjectOutputStream salida2;
        try {
            salida2 = new ObjectOutputStream(new FileOutputStream(fichero2));
            salida2.writeObject(ps);
            salida2.close();
            guardado=true;
        } catch (IOException ex) {
            System.out.print ("Fallo al guardar pelis");
            guardado=false;
            
        }
        if(guardado==true){
            System.out.print ("Indique el nombre del fichero de clasificiacion: ");
        String fichero3 = entrada.nextLine();
        ObjectOutputStream salida3;
        try {
            salida3 = new ObjectOutputStream(new FileOutputStream(fichero3));
            salida3.writeObject(items);
            salida3.close();
            guardado=true;
        } catch (IOException ex) {
            System.out.print ("Fallo al guardar pelis");
            guardado=false;
            
        }
        }
       }
       return guardado;
    }
            
     private static boolean cargarEstado() {
        ObjectInputStream entrada = null;
        boolean bienCargado=false;
        try {
            Scanner teclado = new Scanner (System.in);
            System.out.print ("Dime nombre de fichero de usuario: ");
            String fichero = teclado.nextLine();
            entrada = new ObjectInputStream(new FileInputStream(fichero));
            us=(Usuarios)entrada.readObject();
            entrada.close();
            bienCargado=true;
        } catch (Exception ex) {
             System.out.print ("Fallo al cargar usuarios");
             bienCargado=false;
        } 
       ObjectInputStream entrada2 = null;
        try {
            Scanner teclado = new Scanner (System.in);
            System.out.print ("Dime nombre de fichero de peliculas: ");
            String fichero2 = teclado.nextLine();
            entrada2 = new ObjectInputStream(new FileInputStream(fichero2));
            ps=(Peliculas)entrada2.readObject();
            entrada2.close();
            bienCargado=true;
        } catch (Exception ex) {
            System.out.print ("Fallo al cargar pelis");
            bienCargado=false;
        } 
         ObjectInputStream entrada3 = null;
         try {
            Scanner teclado = new Scanner (System.in);
            System.out.print ("Dime nombre de fichero de partidas: ");
            String fichero3 = teclado.nextLine();
            entrada3 = new ObjectInputStream(new FileInputStream(fichero3));
            items=(Clasificacion)entrada3.readObject();
            entrada3.close();
            bienCargado=true;
        } catch (Exception ex) {
             System.out.print ("Fallo al cargar partidas");
             bienCargado=false;
        } 
        return bienCargado;
    }
            
           private static void iniciarPartida(Usuario u,Peliculas ps,Clasificacion items){
               Scanner entrada = new Scanner (System.in);
                Usuario contrincante=us.anyUsuario(u);
                 System.out.print ("Tu contrincante aleatorio es: "+contrincante.getApodo());
                boolean acabada=Partida.comenzarPartida(u,contrincante,ps,items);
                if(acabada=true){
                     System.out.print ("Esperando que "+contrincante.getApodo()+" acabe la partida");
                     
                }
                else{
                     System.out.print ("Ocurrió algún fallo durante la partida vuelva a iniciar otra si quiere jugar");
                }
           }

    
    private static void compartir_todo(Usuario u){
         
       
        Scanner teclado  = new Scanner(System.in);
         u.imprimirAmigos();
        System.out.println("¿Con que amigo quieres compartir todo?");
        String amigo = teclado.nextLine();
        Usuario aux = new Usuario(amigo);
        u.compartir_todo(aux);   
        

        
    }        
     private static void compartir_todotodito(Usuario u){
         
       u.compartir_todoTodos();  
        

        
    } 
            
    private static void compartir_pelitodos(Usuario u){
        
        Scanner entrada = new Scanner (System.in);
        u.imprimirPelisUs();
        System.out.println("Elija la pelicula a compartir:");
        String pelicula = entrada.nextLine();
        Pelicula p = new Pelicula(pelicula);
        p=u.buscarPelicula(p);
          Pelicula SePuede =  u.buscarPelicula(p);
       if (SePuede==null) {
        
        System.out.println("No existe ninguna con ese nombre o que hayas registrado.");
        
       }else{

           
        u.compartir_pelitodo(p);   
        
       }
    }  
    private static void compartir_criticatodos(Usuario u){
        
        Scanner entrada = new Scanner (System.in);
        u.imprimirCriticasUs();
        System.out.println("Elija la crítica a compartir:");
        String critica = entrada.nextLine();
        Critica c = new Critica(critica);
        c=u.buscarCritica(c);
          Critica SePuede =  u.buscarCritica(c);
       if (SePuede==null) {
        
        System.out.println("No existe ninguna con ese nombre o que hayas registrado.");
        
       }else{

           
        u.compartir_criticatodo(c);   
        
       }
    }  
      private static void detallesPartida(Clasificacion it){
            it.detallePartida();
    }
      
            
            
            
            
     
            
            
    private static boolean salida(Usuarios us, Peliculas ps, Clasificacion clas) {
        Scanner teclado = new Scanner (System.in);
            boolean salir=false;
            System.out.print ("¿Quieres guardar los cambios realizados?(Escirbe Si o No): ");
            String decision = teclado.nextLine();
            if(decision.equals("si")||decision.equals("Si")){
                boolean guardado=guardarEstado(us,ps,clas);
                 if(guardado==true){
                     salir=true;
                 }}
                  if(decision.equals("no")||decision.equals("No")){
                      salir=true;
                  }
            
      
           
            return salir;
       }

    private static void completarPartidas(Usuario u,Clasificacion items) {
       u.imprimirPartidasPendientes(items);
    }
      private static void verClasificacion(Clasificacion items){
          items.visualizar();
      } 
    }

           
           
            







    




 
