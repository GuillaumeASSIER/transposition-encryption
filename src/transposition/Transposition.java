/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transposition;

import java.util.Scanner;

/**
 *
 * @author Guillaume
 */
public class Transposition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        System.out.print("Entrer le message à chiffrer\n");
        Scanner keyboard = new Scanner(System.in);
        String message1 = keyboard.nextLine();
        
        System.out.print("Entrer le code de chiffrement\n");
        Scanner keyboard2 = new Scanner(System.in);
        String code = keyboard2.nextLine();
        
        Convertisseur conv = new Convertisseur(message1,code);
        String message2 = conv.chiffrer();
        System.out.println(message2);
        
        Convertisseur conv2 = new Convertisseur(message2,code);
        System.out.println(conv2.dechiffrer());
        
        
        
    }
    
}
