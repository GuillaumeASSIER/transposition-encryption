/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transposition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Guillaume
 */
public class Convertisseur {
    String messageEntree; //Message d'entrée avant traitement
    String messageSortie; //Message de sortie après traitement
    String code; //Code de chiffrement / déchiffrement
    int lignes,colonnes; //Lignes et colonnes
    char[][] tab = null; //tableau de chiffrement / déchiffrement
    ArrayList<Couple> listeCouples; //liste de couples pour le chiffrement / déchiffrement
    
    /**
     * 
     * @param messageEntree Message d'entrée
     * @param code Code de déchiffrement
     */
    public Convertisseur(String messageEntree, String code){
        this.messageEntree = messageEntree;
        this.code = code;
        this.listeCouples=new ArrayList<>();
    }
    
    /**
     * 
     * @return Fonction de chiffrement
     */
    public String chiffrer(){
        this.calculsPreli();
        this.miseEnTableauChiffrement();
        this.couplage();
        this.triCouples();
        this.lectureChiffrement();
        return messageSortie;
    }
    
    /**
     * 
     * @return Fonction de déchiffrement
     */
    public String dechiffrer(){
        this.calculsPreli();
        this.couplage();
        this.triCouples();
        this.miseEnTableauDechiffrement();
        this.lectureDechiffrement();
        return messageSortie;
    }
    
    /**
     * Calcul de lignes et colonnes
     */
    public void calculsPreli(){
        this.lignes = messageEntree.length()/code.length();
        if ((messageEntree.length() % code.length()) != 0){
            this.lignes++;
        }

        this.colonnes = code.length();
        //System.out.println(this.colonnes);
    }
    
    /**
     * Remplissage du tableau en mode chiffrement
     */
    public void miseEnTableauChiffrement(){
        int cpt =0 ;
        char[][] tab = new char[this.lignes][this.colonnes];
        Random r = new Random();
        for(int x=0;x<this.lignes;x++){
            for(int y=0;y<this.colonnes;y++){
                if(cpt < this.messageEntree.length()){
                    tab[x][y] = this.messageEntree.charAt(cpt);
                } else {
                    tab[x][y] = (char) (r.nextInt(26) + 'a');
                }
                cpt++;
            }
        }
        this.tab = tab;
    }
    
    /**
     * Remplissage du tableau en mode déchiffrement
     */
    public void miseEnTableauDechiffrement(){
        int cpt = 0;
        char[][] tab = new char[this.lignes][this.colonnes];
        for(Couple c:this.listeCouples){
            for(int x=0;x<this.lignes;x++){
                tab[x][c.nombre-1] = this.messageEntree.charAt(cpt);
                cpt++;
            }
            
        }
        this.tab = tab;
    }
    
    /*
    public void afficherTab(){
        for(int x=0;x<this.lignes;x++){
            for(int y=0;y<this.colonnes;y++){
                System.out.println("["+tab[x][y]+"]");
            }
        System.out.println("\n");    
        }
    }*/
    
    /**
     * Procédure création des couples
     */
    public void couplage(){
        for(int i=0;i<this.code.length();i++){
            Couple newCouple = new Couple(this.code.charAt(i), i+1);
            this.listeCouples.add(newCouple);
        }
    }  
    
    /**
     * Procédure de tri des couples
     */
    public void triCouples(){
        Collections.sort(listeCouples, new Cpt());
    }
    
    /**
     * Procédure lecture du tableau lors du chiffrement
     */
    public void lectureChiffrement(){
        this.messageSortie = "";
        for(Couple c:this.listeCouples){
            for(int x=0;x<this.lignes;x++){
                this.messageSortie = this.messageSortie + this.tab[x][c.nombre-1];
            }
        }
    }
    
    /**
     * 
     */
    public void lectureDechiffrement(){
        this.messageSortie = "";
        for(int x=0;x<this.lignes;x++){
            for(int y=0;y<this.colonnes;y++){
                this.messageSortie = this.messageSortie + this.tab[x][y];
            }
        }
    }
}
