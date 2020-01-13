/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transposition;

import java.util.Comparator;

/**
 *
 * @author Guillaume
 */
public class Cpt implements Comparator<Couple> {

    /**
     * 
     * @param o1 Couple 1
     * @param o2 COuple 2
     * @return valeur de la comparaison
     */
    @Override
    public int compare(Couple o1, Couple o2) {
       if(o1.getLettre()<o2.getLettre()){
           return -1;
       } else if(o1.getLettre()>o2.getLettre()) {
           return 1;
       } else {
           return (o1.getNombre()-o2.getNombre());
       }
    }
    
    
}
