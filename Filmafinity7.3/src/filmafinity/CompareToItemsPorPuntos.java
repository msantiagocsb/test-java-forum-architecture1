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
public class CompareToItemsPorPuntos implements Comparator <Item>{
    @Override
    public int compare(Item o1, Item o2) {
        return o1.getPuntos()-o2.getPuntos();
    }
    
}
