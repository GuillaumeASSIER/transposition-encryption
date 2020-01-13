/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transposition;

/**
 *
 * @author Guillaume
 */
public class Couple {
    char lettre; //Lettre du couple
    int nombre; //Nombre du couple
    
    /**
     * 
     * @param lettre Lettre du couple
     * @param nombre Nombre du couple
     */
    public Couple(char lettre, int nombre){
        this.lettre = lettre;
        this.nombre = nombre;
    }
    /**
     * 
     * @return Lettre du couple
     */
    public char getLettre(){
        return this.lettre;
    }
    
    /**
     * 
     * @return Nombre du couple
     */
    public int getNombre(){
        return this.nombre;
    }
    
}
