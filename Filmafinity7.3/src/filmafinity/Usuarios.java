/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmafinity;
import static filmafinity.Filmafinity.items;
import static filmafinity.Filmafinity.us;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;
/**
 *
 * @author Dani, Alejandro, Miguel.
 */
public class Usuarios implements Serializable {

    

   
    private ArrayList<Usuario> usuarios;
    
        
    public Usuarios  (){
         usuarios= new ArrayList<>();
    }
    public static void cargarUsuarios(){
        ObjectInputStream entrada = null;
        try {
            Scanner teclado = new Scanner (System.in);
            System.out.print ("Dime nombre de fichero de usuarios: ");
            String fichero = teclado.nextLine();
            entrada = new ObjectInputStream(new FileInputStream(fichero));
            us=(Usuarios)entrada.readObject();
            entrada.close();
        } catch (Exception ex) {
             System.out.print ("Fallo al cargar usuarios");
        } 
    }
    public void introducirUsuario(Usuario usuario){//para añadir usuarios al arraylist del sistema
          this.usuarios.add(usuario);
    }
     public boolean añadirUsuario(Usuario U){//comprueba si el usuario existe antes de introducirlo al sistema devuelve true si todo fue bien
        boolean agregar= false;
       if(!usuarios.contains(U)){
           usuarios.add(U);
           agregar = true;
       }
       return agregar;
   }
       public boolean registrarUsuario(Usuarios us,Clasificacion items) {
           Scanner entrada = new Scanner(System.in);
             System.out.print("Nombre del Usuario que quieres registrar:");
             String login = entrada.nextLine();
              System.out.print("Escribe la contraseña que quieres tener:");
              String pass = entrada.nextLine();
              //Usuario u=new Usuario(login,pass,items);
              boolean añadido=false;
              boolean añadir=true;
             
              
              for (Usuario f : usuarios) {//comrpueba 1 a 1 si existe algun usuario con el nombre introducido
                if (f.getApodo().equals(login) ) {
                añadir=false;//si existe añadir= false
            }
              }
              if(añadir==true) {//si no existe
                  Usuario u=new Usuario(login,pass,items);
                 añadido=us.añadirUsuario(u);//añade el usario al sistema
                 
              
              }
              
              return añadido; //devuelve true si se añadió o false si al contrario
            }
       
    
       
    public Usuario autenticar() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Usuario: ");
        String login = entrada.nextLine();
        System.out.print("Contraseña: ");
        String pass = entrada.nextLine();
        for (Usuario f : usuarios) {//comprueba 1 a 1 si los datos introducidos coinciden con algun usuario
            if (f.getApodo().equals(login) && f.getContraseña().equals(pass)) {
                return f;//si coinciden devuelve el usuario al que corresponden
            }
        }
        return null;//si no coincide con ninguno rdevuelve null
    }
   
   public void imprimirUsuarios() 
    { 
         for(Usuario usuario : usuarios) {//imprime por pantalla los usarios del sistema
            String nombreAmigo = usuario.getApodo();
            System.out.println(nombreAmigo);
               
               }
    } 
   public Usuario buscarUsuarios(Usuario U){ //para lo de la critica y poder ponerla en el muro del amigo
         Usuario agregar = null;
        
            String amigo = U.getApodo();
        for (Usuario usuarios : usuarios) {//busca en el arrayList de amigos del propio usuario si existe un amigo con ese nombre si es asi devuelve el usuairo
            if(amigo.equals(usuarios.getApodo())){
                agregar = usuarios;
                
            }
            
        }
  return agregar;
} 
   
    
     public Usuario anyUsuario(Usuario u) {
     Usuario aleatorio;
     do{
     try {
        aleatorio= usuarios.get((new Random()).nextInt(usuarios.size()));//elige una posicion del array list dentro del tamaño del mismo
                                                                           //devuelve el usuario aleatorio random
    }
    catch (Throwable e){
        return null;
    }}
     while(u.getApodo()==aleatorio.getApodo());//repite el código si el usuario random que sale es el mismo
     
     return aleatorio;//devuelve el usario random
}
     
}

