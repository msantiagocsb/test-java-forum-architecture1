/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmafinity;

import java.util.Comparator;

/**
 *
 * @author miguelsantiagoherrero
 */
public class CompareToItemsPorcentajeVictorias implements Comparator <Item>{
     @Override
    public int compare(Item o1, Item o2) {
       
       
    if(o1.getPorcent_victorias()<o2.getPorcent_victorias())
          return -1;
    else if(o2.getPorcent_victorias()<o1.getPorcent_victorias())
          return 1;
    return 0;
        }
    }

