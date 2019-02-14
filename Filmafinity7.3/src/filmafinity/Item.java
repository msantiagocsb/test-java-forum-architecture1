/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmafinity;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;
/**
 *
 * @author Alejandro, Miguel y Dani
 */
public class Item implements Serializable {
    private String nombre_usuario;
    private int jugadas;
    private int ganadas;
    private int perdidas;
    private int puntos;
    private double porcent_victorias;


public Item(String nombre_usuario){
this.nombre_usuario = nombre_usuario;
this.jugadas = 0;
this.ganadas = 0;
this.perdidas = 0;
this.puntos = 0;
this.porcent_victorias = 0.0;
}

public String getNombre_usuario(){
    return nombre_usuario;
}
public void setNombre_usuario(String nombre_usuario){
    this.nombre_usuario = nombre_usuario;
}
public int getJugadas(){
    return jugadas;
}
public void setJugadas(int jugadas){
    this.jugadas = this.jugadas+jugadas;
}
public int getGanadas(){
    return ganadas;
}
public void setGanadas(int ganadas){
    this.ganadas = this.ganadas+ganadas;
}
public int getPerdidas(){
    return perdidas;
}
public void setPerdidas(int perdidas){
    this.perdidas = this.perdidas+perdidas;
}
public int getPuntos(){
    return puntos;
}
public void setPuntos(int puntos){
    this.puntos = this.puntos+puntos; 
}
public double getPorcent_victorias(){
    return porcent_victorias;
}
public void setPorcent_victorias(double porcentaje){
    //double porcentaje = getGanadas()/getJugadas();
    this.porcent_victorias= porcentaje;
        }

    @Override
 public String toString (){
        return "Nombre: "+getNombre_usuario()+" Partidas jugadas: "+getJugadas()+" Partidas perdidas: "+getPerdidas()+" Puntos: "+getPuntos()+" Porcentaje de victorias: "+getPorcent_victorias()+"%";
    }


}