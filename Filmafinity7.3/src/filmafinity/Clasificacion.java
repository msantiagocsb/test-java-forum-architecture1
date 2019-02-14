/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmafinity;
import static filmafinity.Filmafinity.items;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Dani, Alejandro, Miguel
 */
public class Clasificacion implements Serializable {
    private ArrayList<Item> items;
     public Clasificacion (){
        items = new ArrayList<Item>();
    }
    
    public void visualizar(){
        int i=0;
         Scanner entrada=new Scanner (System.in);
        do{ 
            System.out.println("¿Como quieres ver la clasificacion?"
                        +"\n-Por orden de victorias (Escribe: orden)"
                        +  "\n-Por puntos totales (Escribe: puntos)"
                        +  "\n-Por porcentaje de victorias (Escribe: porcentaje)");
            String opcion= entrada.nextLine();
         
         if(opcion.equals("orden")||opcion.equals("Orden")){
             ComparteToItemsPorVictorias  comparador = new ComparteToItemsPorVictorias ();
        Collections.sort(items, comparador);
        for (Item item : items) {
            System.out.println(item);
        }
        i=1;//cambia el valor para que salga del while
         }
         if(opcion.equals("porcentaje")||opcion.equals("Porcentaje")){
             CompareToItemsPorcentajeVictorias  comparador = new CompareToItemsPorcentajeVictorias ();
        Collections.sort(items, comparador);
        for (Item item : items) {
            System.out.println(item);
        }
        i=1;//cambia el valor para que salga del while
         }
         if(opcion.equals("puntos")||opcion.equals("Puntos")){
             CompareToItemsPorPuntos comparador = new CompareToItemsPorPuntos ();
        Collections.sort(items, comparador);
        for (Item item : items) {
            System.out.println(item);
        }i=1;//cambia el valor para que salga del while
         }
       
               
       }while(i==0);//si pone una opcion que no es ninguna de las posible repite la pregunta.
        }
    public void escribirText(){
        
    }
    
    public void añadirItem(Item i){//añade un item a la clasificacion
        items.add(i);
    }
    public Item buscarItem(Usuario u){
        String nombre=u.getApodo();
        Item itemIgual=null;
        for(Item item: items){//recorre la clasificacion
     
        if(nombre.equals(item.getNombre_usuario())){//si el nombre del usuario pasado coincide con el nombre de algun item devuelve el item
            itemIgual=item;
         }
        }
        return itemIgual;
    }
     
  public void detallePartida(){
    Scanner entrada = new Scanner(System.in);
    System.out.println("Escribe el nombre del usuario del que deseas ver la información:");
    String nombre = entrada.nextLine();
    for(Item it: items){//recorre el array de clasificacion
       if(nombre.equals(it.getNombre_usuario())){//si el nombre introducido coincide con el usuario introducido lo imprime por pantalla
    
    System.out.println(it);
    }
      
      }   

  }
  public void guardarText(String nombreFichero){
      
      FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreFichero);
            pw = new PrintWriter(fichero);

           for(Item it: items){
                pw.println(it);
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        

    }
  }
    
